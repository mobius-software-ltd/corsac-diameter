package com.mobius.software.telco.protocols.diameter.impl.app;
/*
 * Mobius Software LTD
 * Copyright 2023, Mobius Software LTD and individual contributors
 * by the @authors tag.
 *
 * This program is free software: you can redistribute it and/or modify
 * under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
import java.util.Collection;

import com.mobius.software.common.dal.timers.Task;
import com.mobius.software.telco.protocols.diameter.AsyncCallback;
import com.mobius.software.telco.protocols.diameter.DiameterProvider;
import com.mobius.software.telco.protocols.diameter.ResultCodes;
import com.mobius.software.telco.protocols.diameter.app.ClientCCListener;
import com.mobius.software.telco.protocols.diameter.app.ClientCCSession;
import com.mobius.software.telco.protocols.diameter.app.SessionStateEnum;
import com.mobius.software.telco.protocols.diameter.commands.DiameterAnswer;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.commands.commons.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.commons.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.commons.CreditControlAnswer;
import com.mobius.software.telco.protocols.diameter.commands.commons.CreditControlRequest;
import com.mobius.software.telco.protocols.diameter.commands.commons.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.commons.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.commons.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.commons.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.DiameterSessionImpl;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.DirectDebitingFailureHandlingEnum;
/**
*
* @author yulian oifa
*
*/
public class ClientCCSessionImpl<R1 extends CreditControlRequest,A1 extends CreditControlAnswer,R2 extends ReAuthRequest,A2 extends ReAuthAnswer,R3 extends AbortSessionRequest,A3 extends AbortSessionAnswer,R4 extends SessionTerminationRequest,A4 extends SessionTerminationAnswer> extends DiameterSessionImpl implements ClientCCSession<R1,A2,A3,R4>
{
	private Boolean isRetry = false;
	
	private DiameterProvider<? extends ClientCCListener<R1,A1,R2,A2,R3,A3,R4,A4>, ?, ?, ?, ?> provider;
	private RetransmissionCallback retransmissionCallback=new RetransmissionCallback();
	
	public ClientCCSessionImpl(String sessionID, String remoteHost, String remoteRealm, DiameterProvider<? extends ClientCCListener<R1,A1,R2,A2,R3,A3,R4,A4>, ?, ?, ?, ?> provider)
	{
		super(sessionID, remoteHost, remoteRealm, provider);
		this.provider = provider;
	}

	@Override
	public void sendInitialRequest(R1 request, AsyncCallback callback)
	{
		if(getSessionState()!=null && getSessionState()!=SessionStateEnum.IDLE && getSessionState()!=SessionStateEnum.OPEN)
		{
			callback.onError(new DiameterException("session state is invalid, can not send message", null, ResultCodes.DIAMETER_UNABLE_TO_COMPLY, null));
			return;
		}
		
		try
		{
			request.setSessionId(getID());
		}
		catch(MissingAvpException | AvpNotSupportedException ex)
		{
			//will not happen
		}
		
		final Long startTime = System.currentTimeMillis();
		provider.getStack().getWorkerPool().getQueue().offerLast(new Task()
		{
			@Override
			public long getStartTime()
			{
				return startTime;
			}
			
			@Override
			public void execute()
			{
				setSessionState(SessionStateEnum.PENDING);
				if(!isRetry) 
				{
					setLastSentRequest(request);	
					requestSent(request, callback);
				}
				
				provider.getStack().sendRequest(request, callback);
			}
		});						
	}

	@Override
	public void sendReauthAnswer(A2 answer, AsyncCallback callback)
	{
		if(getSessionState()==null || (getSessionState()!=SessionStateEnum.IDLE && getSessionState()!=SessionStateEnum.OPEN))
		{
			callback.onError(new DiameterException("session state is invalid, can not send message", null, ResultCodes.DIAMETER_UNABLE_TO_COMPLY, null));
			return;
		}
		
		try
		{
			answer.setSessionId(getID());
		}
		catch(MissingAvpException | AvpNotSupportedException ex)
		{
			//will not happen
		}
		
		final Long startTime = System.currentTimeMillis();
		provider.getStack().getWorkerPool().getQueue().offerLast(new Task()
		{
			@Override
			public long getStartTime()
			{
				return startTime;
			}
			
			@Override
			public void execute()
			{
				answerSent(answer, callback, null);
				provider.getStack().sendAnswer(answer, getRemoteHost(), getRemoteRealm(), callback);
			}
		});				
	}

	@Override
	public void sendSessionTerminationRequest(R4 request, AsyncCallback callback)
	{
		if(getSessionState()==null || (getSessionState()!=SessionStateEnum.IDLE && getSessionState()!=SessionStateEnum.OPEN))
		{
			callback.onError(new DiameterException("session state is invalid, can not send message", null, ResultCodes.DIAMETER_UNABLE_TO_COMPLY, null));
			return;
		}
		
		try
		{
			request.setSessionId(getID());
		}
		catch(MissingAvpException | AvpNotSupportedException ex)
		{
			//will not happen
		}
		
		final Long startTime = System.currentTimeMillis();
		provider.getStack().getWorkerPool().getQueue().offerLast(new Task()
		{
			@Override
			public long getStartTime()
			{
				return startTime;
			}
			
			@Override
			public void execute()
			{
				setSessionState(SessionStateEnum.DISCONNECTED);
				setLastSentRequest(request);	
				requestSent(request, callback);
				provider.getStack().sendRequest(request, callback);
			}
		});			
	}

	@Override
	public void sendAbortSessionAnswer(A3 answer, AsyncCallback callback)
	{
		if(getSessionState()==null || (getSessionState()!=SessionStateEnum.IDLE && getSessionState()!=SessionStateEnum.OPEN))
		{
			callback.onError(new DiameterException("session state is invalid, can not send message", null, ResultCodes.DIAMETER_UNABLE_TO_COMPLY, null));
			return;
		}
		
		try
		{
			answer.setSessionId(getID());
		}
		catch(MissingAvpException | AvpNotSupportedException ex)
		{
			//will not happen
		}
		
		final Long startTime = System.currentTimeMillis();
		provider.getStack().getWorkerPool().getQueue().offerLast(new Task()
		{
			@Override
			public long getStartTime()
			{
				return startTime;
			}
			
			@Override
			public void execute()
			{
				if(answer.getIsError()==null || !answer.getIsError())
					setSessionState(SessionStateEnum.DISCONNECTED);
				
				answerSent(answer, callback, null);
				provider.getStack().sendAnswer(answer, getRemoteHost(), getRemoteRealm(), callback);
			}
		});			
	}
	
	@Override
	public void requestReceived(DiameterRequest request, AsyncCallback callback)
	{
		@SuppressWarnings("unchecked")
		Collection<ClientCCListener<R1,A1,R2,A2,R3,A3,R4,A4>> listeners = (Collection<ClientCCListener<R1,A1,R2,A2,R3,A3,R4,A4>>) provider.getClientListeners().values();
		if(request instanceof ReAuthRequest)
		{
			try
			{
				@SuppressWarnings("unchecked")
				R2 castedRequest = (R2)request;
				for(ClientCCListener<R1,A1,R2,A2,R3,A3,R4,A4> listener:listeners)
					listener.onReauthRequest(castedRequest, this, callback);	
			}
			catch(Exception ex)
			{
				callback.onError(new DiameterException("Received unexpected request", null, ResultCodes.DIAMETER_COMMAND_UNSUPPORTED, null));
				return;
			}
		}
		else if(request instanceof AbortSessionRequest)
		{
			try
			{
				@SuppressWarnings("unchecked")
				R3 castedRequest = (R3)request;
				for(ClientCCListener<R1,A1,R2,A2,R3,A3,R4,A4> listener:listeners)
					listener.onAbortSessionRequest(castedRequest, this, callback);	
			}
			catch(Exception ex)
			{
				callback.onError(new DiameterException("Received unexpected request", null, ResultCodes.DIAMETER_COMMAND_UNSUPPORTED, null));
				return;
			}
		}
		else
		{
			callback.onError(new DiameterException("Received unexpected request", null, ResultCodes.DIAMETER_COMMAND_UNSUPPORTED, null));
			return;
		}
		
		super.requestReceived(request, callback);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void answerReceived(DiameterAnswer answer, AsyncCallback callback, Long idleTime,Boolean stopSendTimer)
	{
		try
		{
			validateAnswer(answer);
		}
		catch(DiameterException ex)
		{
			callback.onError(new DiameterException("Received unexpected answer", null, ResultCodes.DIAMETER_COMMAND_UNSUPPORTED, null));
			return;
		}
		
		DiameterRequest request = getLastSendRequest();
		Long newTime = null;
		if(request!=null)
		{
			Collection<ClientCCListener<R1,A1,R2,A2,R3,A3,R4,A4>> listeners = null;
			if(provider.getClientListeners()!=null)
				listeners = (Collection<ClientCCListener<R1,A1,R2,A2,R3,A3,R4,A4>>) provider.getClientListeners().values();
			
			if(request instanceof SessionTerminationRequest)
			{
				if(answer instanceof SessionTerminationAnswer)
				{
					try
					{
						A4 castedAnswer = (A4)answer;
						
						setSessionState(SessionStateEnum.IDLE);
						terminate();
						if(listeners!=null)
						{
							for(ClientCCListener<R1,A1,R2,A2,R3,A3,R4,A4> listener:listeners)
								listener.onSessionTerminationAnswer(castedAnswer, this, callback);
						}
					}
					catch(Exception ex)
					{
						callback.onError(new DiameterException("Received unexpected answer", null, ResultCodes.DIAMETER_COMMAND_UNSUPPORTED, null));
						return;
					}
					
				}
			}
			else
			{
				try
				{
					A1 castedAnswer = (A1)answer;
					
					if(getSessionState()==SessionStateEnum.PENDING)
					{
						try
						{
							if(castedAnswer.getValidityTime()!=null)
								newTime = castedAnswer.getValidityTime()*1000L;
						}
						catch(DiameterException ex)
						{
							//validity time may not be supported
						}
						
						if(((CreditControlRequest)request).getCcRequestType()!=null && ((CreditControlRequest)request).getCcRequestType()==CcRequestTypeEnum.TERMINATION_REQUEST)
						{
							setSessionState(SessionStateEnum.IDLE);
							terminate();
							if(listeners!=null)
							{
								for(ClientCCListener<R1,A1,R2,A2,R3,A3,R4,A4> listener:listeners)
									listener.onInitialAnswer(castedAnswer, this, callback);
							}
						}
						else if(castedAnswer.getResultCode()!=null && !castedAnswer.getIsError())
						{
							if(((CreditControlRequest)request).getCcRequestType()!=null && ((CreditControlRequest)request).getCcRequestType()==CcRequestTypeEnum.EVENT_REQUEST)
							{
								setSessionState(SessionStateEnum.IDLE);
								terminate();
								if(listeners!=null)
								{
									for(ClientCCListener<R1,A1,R2,A2,R3,A3,R4,A4> listener:listeners)
										listener.onInitialAnswer(castedAnswer, this, callback);
								}
							}
							else
							{
								setSessionState(SessionStateEnum.OPEN);
								if(listeners!=null)
								{
									for(ClientCCListener<R1,A1,R2,A2,R3,A3,R4,A4> listener:listeners)
										listener.onInitialAnswer(castedAnswer, this, callback);
								}
							}
						}
						else
						{
							Boolean shouldRetry = false;
							if(((CreditControlRequest)request).getCcRequestType()!=null && ((CreditControlRequest)request).getCcRequestType()==CcRequestTypeEnum.EVENT_REQUEST)
							{
								if(((CreditControlRequest)request).getRequestedAction()!=null)
								{
									switch(((CreditControlRequest)request).getRequestedAction())
									{
										case DIRECT_DEBITING:
											if(castedAnswer.getResultCode()>=4000L && castedAnswer.getResultCode()<5000L)
												if(castedAnswer.getDirectDebitingFailureHandling()!=null && castedAnswer.getDirectDebitingFailureHandling()==DirectDebitingFailureHandlingEnum.CONTINUE)
												{
													request.setIsRetransmit(true);
													shouldRetry = true;
												}
											break;
										case REFUND_ACCOUNT:
											if(castedAnswer.getResultCode()>=4000L && castedAnswer.getResultCode()<5000L)
											{
												request.setIsRetransmit(true);
												shouldRetry = true;
											}
											break;
										case CHECK_BALANCE:
										case PRICE_ENQUIRY:
										default:
											break;									
									}
								}
							}
							
							if(!shouldRetry)
							{
								setSessionState(SessionStateEnum.IDLE);
								terminate();
								if(listeners!=null)
								{
									for(ClientCCListener<R1,A1,R2,A2,R3,A3,R4,A4> listener:listeners)
										listener.onInitialAnswer(castedAnswer, this, callback);
								}
							}
							else
							{
								if(listeners!=null)
								{
									for(ClientCCListener<R1,A1,R2,A2,R3,A3,R4,A4> listener:listeners)
										listener.onInitialAnswer(castedAnswer, this, callback);
								}
								
								R1 realRequest=(R1)request;
								isRetry = true;
								sendInitialRequest(realRequest, retransmissionCallback);
							}
						}
					}
				}
				catch(Exception ex)
				{
					callback.onError(new DiameterException("Received unexpected answer", null, ResultCodes.DIAMETER_COMMAND_UNSUPPORTED, null));
					return;
				}
			}
			
			if(getSessionState()!=SessionStateEnum.IDLE)
			{
				//for retry we dont need to stop the timer
				super.answerReceived(answer, callback, newTime,!isRetry);
			}
		}
		else 
			callback.onError(new DiameterException("Received unexpected answer", null, ResultCodes.DIAMETER_COMMAND_UNSUPPORTED, null));		
	}
	
	@Override
	public void onTimeout()
	{
		DiameterRequest request = getLastSendRequest();
		if(request!=null)
		{
			if(!(request instanceof SessionTerminationRequest))
			{
				if(getSessionState()==SessionStateEnum.PENDING)
				{
					Boolean shouldRetry = false;
					if(((CreditControlRequest)request).getCcRequestType()!=null && ((CreditControlRequest)request).getCcRequestType()==CcRequestTypeEnum.EVENT_REQUEST)
					{
						if(((CreditControlRequest)request).getRequestedAction()!=null)
						{
							switch(((CreditControlRequest)request).getRequestedAction())
							{
								case DIRECT_DEBITING:
									shouldRetry = true;
									break;
								case REFUND_ACCOUNT:
									request.setIsRetransmit(true);
									shouldRetry = true;
									break;
								case CHECK_BALANCE:
								case PRICE_ENQUIRY:
								default:
									break;									
							}
						}
					}
					
					if(shouldRetry)
					{
						if(provider.getClientListeners()!=null)
						{
							@SuppressWarnings("unchecked")
							Collection<ClientCCListener<R1,A1,R2,A2,R3,A3,R4,A4>> listeners = (Collection<ClientCCListener<R1,A1,R2,A2,R3,A3,R4,A4>>) provider.getClientListeners().values();
						
							for(ClientCCListener<R1,A1,R2,A2,R3,A3,R4,A4> listener:listeners)
								listener.onTimeout();
						}
						
						@SuppressWarnings("unchecked")
						R1 realRequest=(R1)request;
						isRetry = true;
						sendInitialRequest(realRequest, retransmissionCallback);
						return;
					}
				}
			}
		}
		
		super.onTimeout();
	}

	@Override
	public boolean isServer()
	{
		return false;
	}
	
	private class RetransmissionCallback implements AsyncCallback
	{
		@Override
		public void onSuccess()
		{
			
		}

		@Override
		public void onError(DiameterException ex)
		{
			setSessionState(SessionStateEnum.IDLE);
			terminate();
			
			if(provider.getClientListeners()!=null)
			{
				@SuppressWarnings("unchecked")
				Collection<ClientCCListener<R1,A1,R2,A2,R3,A3,R4,A4>> listeners = (Collection<ClientCCListener<R1,A1,R2,A2,R3,A3,R4,A4>>) provider.getClientListeners().values();
			
				for(ClientCCListener<R1,A1,R2,A2,R3,A3,R4,A4> listener:listeners)
					listener.onTimeout();
			}
		}
	}
}