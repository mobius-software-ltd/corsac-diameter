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
import com.mobius.software.telco.protocols.diameter.app.ClientAuthListener;
import com.mobius.software.telco.protocols.diameter.app.ClientAuthSession;
import com.mobius.software.telco.protocols.diameter.app.SessionStateEnum;
import com.mobius.software.telco.protocols.diameter.commands.DiameterAnswer;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.commands.commons.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.commons.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.commons.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.commons.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.commons.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.commons.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.DiameterSessionImpl;
/**
*
* @author yulian oifa
*
*/
public class ClientAuthSessionImpl<R1 extends DiameterRequest,A1 extends DiameterAnswer,R2 extends ReAuthRequest,A2 extends ReAuthAnswer,R3 extends AbortSessionRequest,A3 extends AbortSessionAnswer,R4 extends SessionTerminationRequest,A4 extends SessionTerminationAnswer> extends DiameterSessionImpl implements ClientAuthSession<R1,A2,A3,R4>
{
	private DiameterProvider<? extends ClientAuthListener<R1, A1,R2, A2, R3, A3, R4, A4>, ?, ?, ?, ?> provider;
	
	//for serialization
	public ClientAuthSessionImpl(Long applicationID)
	{
		super(applicationID);
	}
			
	public ClientAuthSessionImpl(String sessionID, Long applicationID, String remoteHost, String remoteRealm, DiameterProvider<? extends ClientAuthListener<R1, A1,R2, A2, R3, A3, R4, A4>, ?, ?, ?, ?> provider)
	{
		super(sessionID, applicationID, remoteHost, remoteRealm, provider);
		this.provider = provider;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void setProvider(DiameterProvider<?, ?, ?, ?, ?> provider)
	{
		this.provider = (DiameterProvider<? extends ClientAuthListener<R1, A1,R2, A2, R3, A3, R4, A4>, ?, ?, ?, ?>)provider;
		super.setProvider(provider);
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
		provider.getStack().getQueue().offerLast(new Task()
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
				if(request.getDestinationRealm()==null && getRemoteRealm()!=null)
				{
					try
					{
						request.setDestinationRealm(getRemoteRealm());
					}
					catch(MissingAvpException ex)
					{
						
					}
				}
				
				DiameterRequest oldRequest=getLastSendRequest();
				setLastSentRequest(request);	
				requestSent(oldRequest==null, request, callback);
				provider.getStack().sendRequest(request, new CallbackWrapper(callback));
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
		provider.getStack().getQueue().offerLast(new Task()
		{
			@Override
			public long getStartTime()
			{
				return startTime;
			}
			
			@Override
			public void execute()
			{
				if(answer.getIsError()!=null && answer.getIsError())
				{	
					setSessionState(SessionStateEnum.IDLE);
					terminate(answer.getResultCode());
				}
				
				answerSent(answer, null, callback);
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
		provider.getStack().getQueue().offerLast(new Task()
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
				if(request.getDestinationRealm()==null && getRemoteRealm()!=null)
				{
					try
					{
						request.setDestinationRealm(getRemoteRealm());
					}
					catch(MissingAvpException ex)
					{
						
					}
				}
				setLastSentRequest(request);	
				requestSent(false, request, callback);
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
		provider.getStack().getQueue().offerLast(new Task()
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
				
				answerSent(answer, null, callback);
				provider.getStack().sendAnswer(answer, getRemoteHost(), getRemoteRealm(), callback);	
			}
		});			
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void requestReceived(DiameterRequest request, String linkID, AsyncCallback callback)
	{
		Collection<ClientAuthListener<R1, A1,R2, A2, R3, A3, R4, A4>> listeners = null;
		if(provider.getClientListeners()!=null)
			listeners = (Collection<ClientAuthListener<R1, A1,R2, A2, R3, A3, R4, A4>>) provider.getClientListeners().values();
		
		if(request instanceof ReAuthRequest)
		{
			try
			{
				R2 castedRequest = (R2)request;
				super.requestReceived(request, linkID, callback);
				if(listeners!=null)
				{
					for(ClientAuthListener<R1, A1,R2, A2, R3, A3, R4, A4> listener:listeners)
						listener.onReauthRequest(castedRequest, this, linkID, callback);
				}
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
				R3 castedRequest = (R3)request;
				super.requestReceived(request, linkID, callback);
				for(ClientAuthListener<R1, A1,R2, A2, R3, A3, R4, A4> listener:listeners)
					listener.onAbortSessionRequest(castedRequest, this, linkID, callback);	
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
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void answerReceived(DiameterAnswer answer, Long idleTime,Boolean stopSendTimer,String linkID, AsyncCallback callback)
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
		if(request!=null)
		{
			Collection<ClientAuthListener<R1, A1,R2, A2, R3, A3, R4, A4>> listeners = null;
			if(provider.getClientListeners()!=null)
				listeners = (Collection<ClientAuthListener<R1, A1,R2, A2, R3, A3, R4, A4>>) provider.getClientListeners().values();
			
			if(request instanceof SessionTerminationRequest)
			{
				if(answer instanceof SessionTerminationAnswer)
				{
					try
					{
						A4 castedAnswer = (A4)answer;
						
						setSessionState(SessionStateEnum.IDLE);
						terminate(castedAnswer.getResultCode());
						if(listeners!=null)
						{
							for(ClientAuthListener<R1, A1,R2, A2, R3, A3, R4, A4> listener:listeners)
								listener.onSessionTerminationAnswer(castedAnswer, this, linkID, callback);
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
						if(castedAnswer.getResultCode()!=null && !castedAnswer.getIsError())
						{
							setSessionState(SessionStateEnum.OPEN);
							super.answerReceived(answer, idleTime, stopSendTimer, linkID, callback);
							if(listeners!=null)
							{
								for(ClientAuthListener<R1, A1,R2, A2, R3, A3, R4, A4> listener:listeners)
									listener.onInitialAnswer(castedAnswer, this, linkID, callback);
							}
						}
						else
						{
							setSessionState(SessionStateEnum.IDLE);
							terminate(castedAnswer.getResultCode());
							if(listeners!=null)
							{
								for(ClientAuthListener<R1, A1,R2, A2, R3, A3, R4, A4> listener:listeners)
									listener.onInitialAnswer(castedAnswer, this, linkID, callback);
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
		}
		else 
			callback.onError(new DiameterException("Received unexpected answer", null, ResultCodes.DIAMETER_COMMAND_UNSUPPORTED, null));		
	}

	@Override
	public boolean isServer()
	{
		return false;
	}
	
	private class CallbackWrapper implements AsyncCallback
	{
		private AsyncCallback realCallback;
		
		public CallbackWrapper(AsyncCallback realCallback)
		{
			this.realCallback = realCallback;
		}
		
		@Override
		public void onSuccess()
		{
			realCallback.onSuccess();
		}

		@Override
		public void onError(DiameterException ex)
		{
			setSessionState(SessionStateEnum.IDLE);
			terminate(ex.getErrorCode());
			realCallback.onError(ex);	
		}		
	}
}
