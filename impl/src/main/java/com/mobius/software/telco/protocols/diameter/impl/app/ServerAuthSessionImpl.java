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
import com.mobius.software.telco.protocols.diameter.app.ServerAuthListener;
import com.mobius.software.telco.protocols.diameter.app.ServerAuthSession;
import com.mobius.software.telco.protocols.diameter.app.SessionStateEnum;
import com.mobius.software.telco.protocols.diameter.commands.DiameterAnswer;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.commands.commons.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.commons.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.commons.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.commons.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.commons.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.commons.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.impl.DiameterSessionImpl;
/**
*
* @author yulian oifa
*
*/
public class ServerAuthSessionImpl<R1 extends DiameterRequest,A1 extends DiameterAnswer,R2 extends ReAuthRequest,A2 extends ReAuthAnswer,R3 extends AbortSessionRequest,A3 extends AbortSessionAnswer,R4 extends SessionTerminationRequest,A4 extends SessionTerminationAnswer> extends DiameterSessionImpl implements ServerAuthSession<A1,R2,R3,A4>
{
	private DiameterProvider<?, ? extends ServerAuthListener<R1, A1,R2, A2, R3, A3, R4, A4>, ?, ?, ?> provider;
	public ServerAuthSessionImpl(String sessionID, Long applicationID, String remoteHost, String remoteRealm, DiameterProvider<?, ? extends ServerAuthListener<R1, A1,R2, A2, R3, A3, R4, A4>, ?, ?, ?> provider)
	{
		super(sessionID, applicationID, remoteHost, remoteRealm, provider);
		this.provider = provider;
	}

	@Override
	public void sendInitialAnswer(A1 answer, AsyncCallback callback)
	{
		if(getSessionState()!=null && getSessionState()!=SessionStateEnum.IDLE && getSessionState()!=SessionStateEnum.OPEN)
		{
			callback.onError(new DiameterException("session state is invalid, can not send message", null, ResultCodes.DIAMETER_UNABLE_TO_COMPLY, null));
			return;
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
				else
				{
					setSessionState(SessionStateEnum.OPEN);
					answerSent(answer, callback, null);
				}
				
				provider.getStack().sendAnswer(answer, getRemoteHost(), getRemoteRealm(), callback);
			}
		});					
	}

	@Override
	public void sendReauthRequest(R2 request, AsyncCallback callback)
	{
		if(getSessionState()==null || (getSessionState()!=SessionStateEnum.IDLE && getSessionState()!=SessionStateEnum.OPEN))			
		{
			callback.onError(new DiameterException("session state is invalid, can not send message", null, ResultCodes.DIAMETER_UNABLE_TO_COMPLY, null));
			return;
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
				setLastSentRequest(request);
				requestSent(request, callback);
				provider.getStack().sendRequest(request, callback);
			}
		});				
	}

	@Override
	public void sendSessionTerminationAnswer(A4 answer, AsyncCallback callback)
	{
		if(getSessionState()==null || (getSessionState()!=SessionStateEnum.IDLE && getSessionState()!=SessionStateEnum.OPEN))
		{
			callback.onError(new DiameterException("session state is invalid, can not send message", null, ResultCodes.DIAMETER_UNABLE_TO_COMPLY, null));
			return;
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
				setSessionState(SessionStateEnum.IDLE);
				terminate(answer.getResultCode());
				provider.getStack().sendAnswer(answer, getRemoteHost(), getRemoteRealm(), callback);
			}
		});			
	}

	@Override
	public void sendAbortSessionRequest(R3 request, AsyncCallback callback)
	{
		if(getSessionState()==null || (getSessionState()!=SessionStateEnum.IDLE && getSessionState()!=SessionStateEnum.OPEN))
		{
			callback.onError(new DiameterException("session state is invalid, can not send message", null, ResultCodes.DIAMETER_UNABLE_TO_COMPLY, null));
			return;
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
				requestSent(request, callback);
				provider.getStack().sendRequest(request, callback);
			}
		});			
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void requestReceived(DiameterRequest request, AsyncCallback callback)
	{
		Collection<ServerAuthListener<R1, A1,R2, A2, R3, A3, R4, A4>> listeners = null;
		if(provider.getServerListeners()!=null)
			listeners = (Collection<ServerAuthListener<R1, A1,R2, A2, R3, A3, R4, A4>>) provider.getServerListeners().values();
		
		if(request instanceof SessionTerminationRequest)
		{
			try
			{
				R4 castedRequest = (R4)request;
				if(listeners!=null)
				{
					for(ServerAuthListener<R1, A1,R2, A2, R3, A3, R4, A4> listener:listeners)
						listener.onSessionTerminationRequest(castedRequest, this, callback);
				}
			}
			catch(Exception ex)
			{
				callback.onError(new DiameterException("Received unexpected request", null, ResultCodes.DIAMETER_COMMAND_UNSUPPORTED, null));
				return;
			}
		}
		else
		{
			try
			{
				R1 castedRequest = (R1)request;
				if(listeners!=null)
				{
					for(ServerAuthListener<R1, A1,R2, A2, R3, A3, R4, A4> listener:listeners)
						listener.onInitialRequest(castedRequest, this, callback);
				}
			}
			catch(Exception ex)
			{
				callback.onError(new DiameterException("Received unexpected request", null, ResultCodes.DIAMETER_COMMAND_UNSUPPORTED, null));
				return;
			}
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
		if(request!=null)
		{
			Collection<ServerAuthListener<R1, A1,R2, A2, R3, A3, R4, A4>> listeners = null;
			if(provider.getServerListeners()!=null)
				listeners = (Collection<ServerAuthListener<R1, A1,R2, A2, R3, A3, R4, A4>>) provider.getServerListeners().values();
			
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
							for(ServerAuthListener<R1, A1,R2, A2, R3, A3, R4, A4> listener:listeners)
								listener.onAbortSessionAnswer(castedAnswer, this, callback);
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
							if(listeners!=null)
							{
								for(ServerAuthListener<R1, A1,R2, A2, R3, A3, R4, A4> listener:listeners)
									listener.onReauthAnswer(castedAnswer, this, callback);
							}
						}
						else
						{
							setSessionState(SessionStateEnum.IDLE);
							terminate(castedAnswer.getResultCode());
							if(listeners!=null)
							{
								for(ServerAuthListener<R1, A1,R2, A2, R3, A3, R4, A4> listener:listeners)
									listener.onReauthAnswer(castedAnswer, this, callback);
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
			
			if(getSessionState()!=SessionStateEnum.IDLE)
				super.answerReceived(answer, callback, idleTime, stopSendTimer);
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