package com.mobius.software.telco.protocols.diameter.impl.app.sy;
import java.util.Collection;

import com.mobius.software.common.dal.timers.Task;
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
import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.AsyncCallback;
import com.mobius.software.telco.protocols.diameter.DiameterProvider;
import com.mobius.software.telco.protocols.diameter.ResultCodes;
import com.mobius.software.telco.protocols.diameter.app.ClientAuthListener;
import com.mobius.software.telco.protocols.diameter.app.SessionStateEnum;
import com.mobius.software.telco.protocols.diameter.app.sy.ClientListener;
import com.mobius.software.telco.protocols.diameter.app.sy.SyClientSession;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.commands.sy.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sy.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.sy.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sy.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.sy.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sy.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.commands.sy.SpendingLimitAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sy.SpendingLimitRequest;
import com.mobius.software.telco.protocols.diameter.commands.sy.SpendingStatusNotificationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sy.SpendingStatusNotificationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.app.ClientAuthSessionImpl;

public class SyClientSessionImpl extends ClientAuthSessionImpl<SpendingLimitRequest, SpendingLimitAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer> implements SyClientSession
{
	private DiameterProvider<? extends ClientAuthListener<SpendingLimitRequest,SpendingLimitAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer>, ?, ?, ?, ?> provider;
	
	public SyClientSessionImpl()
	{
		super(Long.valueOf(ApplicationIDs.SY));
	}
	
	public SyClientSessionImpl(String sessionID, String remoteHost, String remoteRealm, DiameterProvider<? extends ClientAuthListener<SpendingLimitRequest,SpendingLimitAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer>, ?, ?, ?, ?> provider)
	{
		super(sessionID,Long.valueOf(ApplicationIDs.SY),remoteHost, remoteRealm, provider);
		this.provider = provider;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void requestReceived(DiameterRequest request, String linkID, AsyncCallback callback)
	{
		Collection<ClientAuthListener<SpendingLimitRequest, SpendingLimitAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer>> listeners = null;
		if(provider.getClientListeners()!=null)
			listeners = (Collection<ClientAuthListener<SpendingLimitRequest, SpendingLimitAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer>>) provider.getClientListeners().values();
		
		if(request instanceof SpendingStatusNotificationRequest)
		{
			try
			{
				SpendingStatusNotificationRequest castedRequest = (SpendingStatusNotificationRequest)request;
				
				restartIdleTimer(null);
				this.provider.getStack().getSessionStorage().storeSession(this);
				
				if(listeners!=null)
				{
					for(ClientAuthListener<SpendingLimitRequest, SpendingLimitAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer> listener:listeners)
						((ClientListener)listener).onSpendingStatusNotificationRequest(castedRequest, this, linkID, callback);
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
			super.requestReceived(request, linkID, callback);
	}
	
	@Override
	public void sendStatusNotificationAnswer(SpendingStatusNotificationAnswer answer,AsyncCallback callback)
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
}
