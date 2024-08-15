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
import com.mobius.software.telco.protocols.diameter.app.ClientAuthSessionStateless;
import com.mobius.software.telco.protocols.diameter.app.ClientAuthStatelessListener;
import com.mobius.software.telco.protocols.diameter.app.SessionStateEnum;
import com.mobius.software.telco.protocols.diameter.commands.DiameterAnswer;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.DiameterSessionImpl;
/**
*
* @author yulian oifa
*
*/
public class ClientAuthSessionStatelessImpl<R1 extends DiameterRequest,A1 extends DiameterAnswer> extends DiameterSessionImpl implements ClientAuthSessionStateless<R1>
{
	private DiameterProvider<? extends ClientAuthStatelessListener<R1,A1>, ?, ?, ?, ?> provider;
	
	//for serialization
	public ClientAuthSessionStatelessImpl(Long applicationID)
	{
		super(applicationID);	
	}
				
	public ClientAuthSessionStatelessImpl(String sessionID, Long applicationID, String remoteHost, String remoteRealm, DiameterProvider<? extends ClientAuthStatelessListener<R1,A1>, ?, ?, ?, ?> provider)
	{
		super(sessionID, applicationID, remoteHost, remoteRealm, provider);
		this.provider = provider;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void setProvider(DiameterProvider<?, ?, ?, ?, ?> provider)
	{
		this.provider = (DiameterProvider<? extends ClientAuthStatelessListener<R1,A1>, ?, ?, ?, ?>)provider;
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
				DiameterRequest oldRequest=getLastSendRequest();
				setLastSentRequest(request);	
				requestSent(oldRequest==null, request, callback);
				provider.getStack().sendRequest(request, new CallbackWrapper(callback));
			}
		});		
	}
	
	@Override
	public void requestReceived(DiameterRequest request, String linkID, AsyncCallback callback)
	{
		callback.onError(new DiameterException("Received unexpected request", null, ResultCodes.DIAMETER_COMMAND_UNSUPPORTED, null));
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
			Collection<ClientAuthStatelessListener<R1,A1>> listeners = null;
			if(provider.getClientListeners()!=null)
				listeners = (Collection<ClientAuthStatelessListener<R1,A1>>) provider.getClientListeners().values();
			
			try
			{
				A1 castedAnswer = (A1)answer;
				
				if(getSessionState()==SessionStateEnum.PENDING)
				{
					//we should transition to open, however afterwards the session may be only terminated , so we just terminate it
					setSessionState(SessionStateEnum.IDLE);
					terminate(castedAnswer.getResultCode());
					if(listeners!=null)
					{
						for(ClientAuthStatelessListener<R1,A1> listener:listeners)
							listener.onInitialAnswer(castedAnswer, this, linkID, callback);
					}
				}
			}
			catch(Exception ex)
			{
				callback.onError(new DiameterException("Received unexpected answer", null, ResultCodes.DIAMETER_COMMAND_UNSUPPORTED, null));
				return;
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