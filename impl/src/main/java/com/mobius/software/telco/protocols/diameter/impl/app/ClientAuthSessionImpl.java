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
	public ClientAuthSessionImpl(String sessionID, String remoteHost, String remoteRealm, DiameterProvider<? extends ClientAuthListener<R1, A1,R2, A2, R3, A3, R4, A4>, ?, ?, ?, ?> provider)
	{
		super(sessionID, remoteHost, remoteRealm, provider);
		this.provider = provider;
	}

	@Override
	public void sendInitialRequest(R1 request, AsyncCallback callback)
	{
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
				setLastSentRequest(request);	
				requestSent(request, callback);
				provider.getStack().sendRequest(request, new CallbackWrapper(callback));
			}
		});						
	}

	@Override
	public void sendReauthAnswer(A2 answer, AsyncCallback callback)
	{
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
				if(answer.getIsError()!=null && answer.getIsError())
				{	
					setSessionState(SessionStateEnum.IDLE);
					terminate();
				}
				
				answerSent(answer, callback, null);
				provider.getStack().sendAnswer(answer, getRemoteHost(), getRemoteRealm(), callback);		
			}
		});		
	}

	@Override
	public void sendSessionTerminationRequest(R4 request, AsyncCallback callback)
	{
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
				
				answerSent(answer, callback,  null);
				provider.getStack().sendAnswer(answer, getRemoteHost(), getRemoteRealm(), callback);	
			}
		});			
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void requestReceived(DiameterRequest request, AsyncCallback callback)
	{
		Collection<ClientAuthListener<R1, A1,R2, A2, R3, A3, R4, A4>> listeners = null;
		if(provider.getClientListeners()!=null)
			listeners = (Collection<ClientAuthListener<R1, A1,R2, A2, R3, A3, R4, A4>>) provider.getClientListeners().values();
		
		if(request instanceof ReAuthRequest)
		{
			try
			{
				R2 castedRequest = (R2)request;
				if(listeners!=null)
				{
					for(ClientAuthListener<R1, A1,R2, A2, R3, A3, R4, A4> listener:listeners)
						listener.onReauthRequest(castedRequest, this, callback);
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
				for(ClientAuthListener<R1, A1,R2, A2, R3, A3, R4, A4> listener:listeners)
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
						terminate();
						if(listeners!=null)
						{
							for(ClientAuthListener<R1, A1,R2, A2, R3, A3, R4, A4> listener:listeners)
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
						if(castedAnswer.getResultCode()!=null && !castedAnswer.getIsError())
						{
							setSessionState(SessionStateEnum.OPEN);
							if(listeners!=null)
							{
								for(ClientAuthListener<R1, A1,R2, A2, R3, A3, R4, A4> listener:listeners)
									listener.onInitialAnswer(castedAnswer, this, callback);
							}
						}
						else
						{
							setSessionState(SessionStateEnum.IDLE);
							terminate();
							if(listeners!=null)
							{
								for(ClientAuthListener<R1, A1,R2, A2, R3, A3, R4, A4> listener:listeners)
									listener.onInitialAnswer(castedAnswer, this, callback);
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
				super.answerReceived(answer, callback, idleTime, stopSendTimer);
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
			terminate();
			realCallback.onError(ex);	
		}		
	}
}
