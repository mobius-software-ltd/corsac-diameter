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
	private DiameterProvider<? extends ClientAuthStatelessListener<R1>, ?, ?, ?, ?> provider;
	public ClientAuthSessionStatelessImpl(String sessionID, String remoteHost, String remoteRealm, DiameterProvider<? extends ClientAuthStatelessListener<R1>, ?, ?, ?, ?> provider)
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
	public void requestReceived(DiameterRequest request, AsyncCallback callback)
	{
		callback.onError(new DiameterException("Received unexpected request", null, ResultCodes.DIAMETER_COMMAND_UNSUPPORTED, null));
		super.requestReceived(request, callback);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void answerReceived(DiameterAnswer answer, AsyncCallback callback, Long idleTime,Boolean stopSendTimer)
	{
		DiameterRequest request = getLastSendRequest();
		if(request!=null)
		{
			Collection<ClientAuthStatelessListener<R1>> listeners = null;
			if(provider.getClientListeners()!=null)
				listeners = (Collection<ClientAuthStatelessListener<R1>>) provider.getClientListeners().values();
			
			try
			{
				A1 castedAnswer = (A1)answer;
				
				if(getSessionState()==SessionStateEnum.PENDING)
				{
					//we should transition to open, however afterwards the session may be only terminated , so we just terminate it
					setSessionState(SessionStateEnum.IDLE);
					terminate();
					if(listeners!=null)
					{
						for(ClientAuthStatelessListener<R1> listener:listeners)
							listener.onInitialAnswer(castedAnswer, this, callback);
					}
				}
			}
			catch(Exception ex)
			{
				callback.onError(new DiameterException("Received unexpected answer", null, ResultCodes.DIAMETER_COMMAND_UNSUPPORTED, null));
				return;
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