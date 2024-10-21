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
import com.mobius.software.telco.protocols.diameter.app.ServerAuthListener;
import com.mobius.software.telco.protocols.diameter.app.SessionStateEnum;
import com.mobius.software.telco.protocols.diameter.app.sy.ServerListener;
import com.mobius.software.telco.protocols.diameter.app.sy.SyServerSession;
import com.mobius.software.telco.protocols.diameter.commands.DiameterAnswer;
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
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.app.ServerAuthSessionImpl;

public class SyServerSessionImpl extends ServerAuthSessionImpl<SpendingLimitRequest, SpendingLimitAnswer, ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer> implements SyServerSession
{
	private DiameterProvider<?, ? extends ServerAuthListener<SpendingLimitRequest, SpendingLimitAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer>, ?, ?, ?> provider;
	
	public SyServerSessionImpl()
	{
		super(Long.valueOf(ApplicationIDs.SY));
	}
	
	public SyServerSessionImpl(String sessionID, String remoteHost, String remoteRealm, DiameterProvider<?, ? extends ServerAuthListener<SpendingLimitRequest, SpendingLimitAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer>, ?, ?, ?> provider)
	{
		super(sessionID, Long.valueOf(ApplicationIDs.SY), remoteHost, remoteRealm, provider);
		this.provider = provider;
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
			Collection<ServerAuthListener<SpendingLimitRequest, SpendingLimitAnswer, ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer>> listeners = null;
			if(provider.getServerListeners()!=null)
				listeners = (Collection<ServerAuthListener<SpendingLimitRequest, SpendingLimitAnswer, ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer>>) provider.getServerListeners().values();
			
			if(request instanceof SpendingStatusNotificationRequest)
			{
				if(answer instanceof SpendingStatusNotificationAnswer)
				{
					try
					{
						SpendingStatusNotificationAnswer castedAnswer = (SpendingStatusNotificationAnswer)answer;						
						setSessionState(SessionStateEnum.IDLE);
						terminate(castedAnswer.getResultCode());
						if(listeners!=null)
						{
							for(ServerAuthListener<SpendingLimitRequest, SpendingLimitAnswer, ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer> listener:listeners)
								((ServerListener)listener).onSpendingStatusNotificationAnswer(castedAnswer, this, linkID,callback);
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
				super.answerReceived(answer, idleTime, stopSendTimer, linkID, callback);
		}
		else 
			super.answerReceived(answer, idleTime, stopSendTimer, linkID, callback);
	}
	
	@Override
	public void sendStatusNotificationRequest(SpendingStatusNotificationRequest request,AsyncCallback callback)
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
}