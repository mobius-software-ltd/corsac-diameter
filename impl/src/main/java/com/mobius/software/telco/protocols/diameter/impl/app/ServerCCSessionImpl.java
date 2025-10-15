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

import com.mobius.software.common.dal.timers.RunnableTask;
import com.mobius.software.telco.protocols.diameter.AsyncCallback;
import com.mobius.software.telco.protocols.diameter.DiameterProvider;
import com.mobius.software.telco.protocols.diameter.ResultCodes;
import com.mobius.software.telco.protocols.diameter.app.ServerCCListener;
import com.mobius.software.telco.protocols.diameter.app.ServerCCSession;
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
/**
*
* @author yulian oifa
*
*/
public class ServerCCSessionImpl<R1 extends CreditControlRequest,A1 extends CreditControlAnswer,R2 extends ReAuthRequest,A2 extends ReAuthAnswer,R3 extends AbortSessionRequest,A3 extends AbortSessionAnswer,R4 extends SessionTerminationRequest,A4 extends SessionTerminationAnswer> extends DiameterSessionImpl implements ServerCCSession<A1,R2,R3,A4>
{
	private DiameterProvider<?, ? extends ServerCCListener<R1,A1, R2, A2, R3, A3, R4, A4>, ?, ?, ?> provider;
	//for serialization
	public ServerCCSessionImpl(Long applicationID)
	{
		super(applicationID);
	}
	
	public ServerCCSessionImpl(String sessionID, Long applicationID, String remoteHost, String remoteRealm, DiameterProvider<?, ? extends ServerCCListener<R1,A1, R2, A2, R3, A3, R4, A4>, ?, ?, ?> provider)
	{
		super(sessionID, applicationID, remoteHost, remoteRealm, provider);
		this.provider = provider;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void setProvider(DiameterProvider<?, ?, ?, ?, ?> provider)
	{
		this.provider = (DiameterProvider<?, ? extends ServerCCListener<R1,A1, R2, A2, R3, A3, R4, A4>, ?, ?, ?>)provider;
		super.setProvider(provider);
	}

	@Override
	public void sendInitialAnswer(A1 answer, AsyncCallback callback)
	{
		if(getSessionState()!=null && getSessionState()!=SessionStateEnum.IDLE && getSessionState()!=SessionStateEnum.OPEN)
		{
			callback.onError(new DiameterException("session state is invalid, can not send message", null, ResultCodes.DIAMETER_UNABLE_TO_COMPLY, null));
			return;
		}
		
		provider.getStack().getWorkerPool().addTaskLast(new RunnableTask(new Runnable()
		{	
			@Override
			public void run()
			{
				Boolean shouldKeepOpen=true;
				
				if(answer.getIsError()!=null && answer.getIsError())
					shouldKeepOpen=false;
				else if(((CreditControlAnswer)answer).getCcRequestType()!=null && ((CreditControlAnswer)answer).getCcRequestType()==CcRequestTypeEnum.EVENT_REQUEST)
					shouldKeepOpen=false;
				else if(((CreditControlAnswer)answer).getCcRequestType()!=null && ((CreditControlAnswer)answer).getCcRequestType()==CcRequestTypeEnum.TERMINATION_REQUEST)
					shouldKeepOpen=false;
				
				if(!shouldKeepOpen)
				{	
					setSessionState(SessionStateEnum.IDLE);
					terminate(answer.getResultCode());
				}
				else
				{
					setSessionState(SessionStateEnum.OPEN);
					
					Long newTime = null;
					try
					{
						if(answer.getValidityTime()!=null)
							newTime = answer.getValidityTime()*1000L;
					}
					catch(AvpNotSupportedException ex)
					{
						
					}
					
					answerSent(answer, newTime, callback);
				}
				
				provider.getStack().sendAnswer(answer, getRemoteHost(), getRemoteRealm(), callback);				
			}
		}, this.getID(), "ServerCCOutgoingInitialAnswerTask"));
	}

	@Override
	public void sendReauthRequest(R2 request, AsyncCallback callback)
	{
		if(getSessionState()==null || (getSessionState()!=SessionStateEnum.IDLE && getSessionState()!=SessionStateEnum.OPEN))
		{
			callback.onError(new DiameterException("session state is invalid, can not send message", null, ResultCodes.DIAMETER_UNABLE_TO_COMPLY, null));
			return;
		}
		
		provider.getStack().getWorkerPool().addTaskLast(new RunnableTask(new Runnable()
		{	
			@Override
			public void run()
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
				
				setLastSentRequest(request);
				requestSent(false, request, callback);
				provider.getStack().sendRequest(request, callback);				
			}
		}, this.getID(), "ServerCCOutgoingReauthRequestTask"));
	}

	@Override
	public void sendSessionTerminationAnswer(A4 answer, AsyncCallback callback)
	{
		if(getSessionState()==null || (getSessionState()!=SessionStateEnum.IDLE && getSessionState()!=SessionStateEnum.OPEN))
		{
			callback.onError(new DiameterException("session state is invalid, can not send message", null, ResultCodes.DIAMETER_UNABLE_TO_COMPLY, null));
			return;
		}
		
		provider.getStack().getWorkerPool().addTaskLast(new RunnableTask(new Runnable()
		{	
			@Override
			public void run()
			{
				setSessionState(SessionStateEnum.IDLE);
				terminate(answer.getResultCode());
				provider.getStack().sendAnswer(answer, getRemoteHost(), getRemoteRealm(), callback);
			}
		}, this.getID(), "ServerCCOutgoingSessionTerminationAnswerTask"));
	}

	@Override
	public void sendAbortSessionRequest(R3 request, AsyncCallback callback)
	{
		if(getSessionState()==null || (getSessionState()!=SessionStateEnum.IDLE && getSessionState()!=SessionStateEnum.OPEN))
		{
			callback.onError(new DiameterException("session state is invalid, can not send message", null, ResultCodes.DIAMETER_UNABLE_TO_COMPLY, null));
			return;
		}
		
		provider.getStack().getWorkerPool().addTaskLast(new RunnableTask(new Runnable()
		{	
			@Override
			public void run()
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
				
				setLastSentRequest(request);
				requestSent(false, request, callback);
				provider.getStack().sendRequest(request, callback);				
			}
		}, this.getID(), "ServerCCOutgoingAbortSessionRequestTask"));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void requestReceived(DiameterRequest request, String linkID, AsyncCallback callback)
	{
		Collection<ServerCCListener<R1, A1, R2, A2, R3, A3, R4, A4>> listeners = null;
		if(provider.getServerListeners()!=null)
			listeners = (Collection<ServerCCListener<R1, A1, R2, A2, R3, A3, R4, A4>>) provider.getServerListeners().values();
		
		if(request instanceof SessionTerminationRequest)
		{
			try
			{
				R4 castedRequest = (R4)request;
				super.requestReceived(request, linkID, callback);
				if(listeners!=null)
				{
					for(ServerCCListener<R1, A1, R2, A2, R3, A3, R4, A4> listener:listeners)
						listener.onSessionTerminationRequest(castedRequest, this, linkID, callback);
				}
			}
			catch(Exception ex)
			{
				logger.warn("An error occured while processing incoming request," + ex.getMessage(),ex);
				callback.onError(new DiameterException("Received unexpected request", null, ResultCodes.DIAMETER_COMMAND_UNSUPPORTED, null));
				return;
			}
		}
		else
		{
			try
			{
				R1 castedRequest = (R1)request;
				super.requestReceived(request, linkID, callback);
				if(listeners!=null)
				{
					for(ServerCCListener<R1, A1, R2, A2, R3, A3, R4, A4> listener:listeners)
						listener.onInitialRequest(castedRequest, this, linkID, callback);
				}
			}
			catch(Exception ex)
			{
				logger.warn("An error occured while processing incoming request," + ex.getMessage(),ex);
				callback.onError(new DiameterException("Received unexpected request", null, ResultCodes.DIAMETER_COMMAND_UNSUPPORTED, null));
				return;
			}
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
			Collection<ServerCCListener<R1, A1, R2, A2, R3, A3, R4, A4>> listeners = null;
			if(provider.getServerListeners()!=null)
				listeners = (Collection<ServerCCListener<R1, A1, R2, A2, R3, A3, R4, A4>>) provider.getServerListeners().values();
			
			if(request instanceof AbortSessionRequest)
			{
				if(answer instanceof AbortSessionAnswer)
				{
					try
					{
						A3 castedAnswer = (A3)answer;
						
						setSessionState(SessionStateEnum.IDLE);
						terminate(castedAnswer.getResultCode());
						if(listeners!=null)
						{
							for(ServerCCListener<R1, A1, R2, A2, R3, A3, R4, A4> listener:listeners)
								listener.onAbortSessionAnswer(castedAnswer, this, linkID,callback);
						}
					}
					catch(Exception ex)
					{
						callback.onError(new DiameterException("Received unexpected answer", null, ResultCodes.DIAMETER_COMMAND_UNSUPPORTED, null));
						return;
					}
					
				}
			}
			else if(request instanceof ReAuthRequest)
			{
				if(answer instanceof ReAuthAnswer)
				{
					try
					{
						A2 castedAnswer = (A2)answer;
						if(castedAnswer.getResultCode()!=null && !castedAnswer.getIsError())
						{
							setSessionState(SessionStateEnum.OPEN);
							super.answerReceived(answer, idleTime, stopSendTimer,linkID, callback);
							if(listeners!=null)
							{
								for(ServerCCListener<R1, A1, R2, A2, R3, A3, R4, A4> listener:listeners)
									listener.onReauthAnswer(castedAnswer, this, linkID ,callback);
							}
						}
						else
						{
							setSessionState(SessionStateEnum.IDLE);
							terminate(answer.getResultCode());
							if(listeners!=null)
							{
								for(ServerCCListener<R1, A1, R2, A2, R3, A3, R4, A4> listener:listeners)
									listener.onReauthAnswer(castedAnswer, this, linkID, callback);
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
		}
		else 
			callback.onError(new DiameterException("Received unexpected answer", null, ResultCodes.DIAMETER_COMMAND_UNSUPPORTED, null));		
	}

	@Override
	public boolean isServer()
	{
		return true;
	}
}