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
import com.mobius.software.telco.protocols.diameter.app.ClientAccListener;
import com.mobius.software.telco.protocols.diameter.app.ClientAccSession;
import com.mobius.software.telco.protocols.diameter.app.SessionStateEnum;
import com.mobius.software.telco.protocols.diameter.commands.DiameterAnswer;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.commands.commons.AccountingAnswer;
import com.mobius.software.telco.protocols.diameter.commands.commons.AccountingRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.DiameterSessionImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AccountingRealtimeRequiredEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.AccountingRecordTypeEnum;
/**
*
* @author yulian oifa
*
*/
public class ClientAccSessionImpl<R1 extends AccountingRequest,A1 extends AccountingAnswer> extends DiameterSessionImpl implements ClientAccSession<R1>
{
	private DiameterProvider<? extends ClientAccListener<R1, A1>, ?, ?, ?, ?> provider;
	
	//for serialization
	public ClientAccSessionImpl(Long applicationID)
	{
		super(applicationID);
	}
		
	public ClientAccSessionImpl(String sessionID, Long applicationID, String remoteHost, String remoteRealm, DiameterProvider<? extends ClientAccListener<R1, A1>, ?, ?, ?, ?> provider)
	{
		super(sessionID, applicationID, remoteHost, remoteRealm, provider);
		this.provider = provider;
	}

	@Override
	public void sendAccountingRequest(R1 request, AsyncCallback callback)
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
				if(!isRetry()) 
				{
					setLastSentRequest(request);	
					requestSent(request, callback);
				}
				
				provider.getStack().sendRequest(request, new CallbackWrapper(callback));
			}
		});				
	}
	
	@Override
	public void requestReceived(DiameterRequest request, AsyncCallback callback)
	{
		callback.onError(new DiameterException("Received unexpected request", null, ResultCodes.DIAMETER_COMMAND_UNSUPPORTED, null));
		return;
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
			try
			{
				A1 castedAnswer = (A1)answer;
				
				Collection<ClientAccListener<R1, A1>> listeners = null;
				if(provider.getClientListeners()!=null)
					listeners = (Collection<ClientAccListener<R1, A1>>) provider.getClientListeners().values();
				
				if(getSessionState()==SessionStateEnum.PENDING)
				{
					if(((AccountingRequest)request).getAcctInterimInterval()!=null)
						newTime = ((AccountingRequest)request).getAcctInterimInterval()*1000L;
					
					if(((AccountingRequest)request).getAccountingRecordType()!=null && ((AccountingRequest)request).getAccountingRecordType()==AccountingRecordTypeEnum.STOP_RECORD)
					{
						setSessionState(SessionStateEnum.IDLE);
						terminate(answer.getResultCode());
						if(listeners!=null)
						{
							for(ClientAccListener<R1, A1> listener:listeners)
								listener.onAccountingResponse(castedAnswer, this, callback);
						}
					}
					else if(castedAnswer.getResultCode()!=null && !castedAnswer.getIsError())
					{
						if(((AccountingRequest)request).getAccountingRecordType()!=null && ((AccountingRequest)request).getAccountingRecordType()==AccountingRecordTypeEnum.EVENT_RECORD)
						{
							setSessionState(SessionStateEnum.IDLE);
							terminate(answer.getResultCode());
							if(listeners!=null)
							{
								for(ClientAccListener<R1, A1> listener:listeners)
									listener.onAccountingResponse(castedAnswer, this, callback);
							}
						}
						else
						{
							setSessionState(SessionStateEnum.OPEN);
							if(listeners!=null)
							{
								for(ClientAccListener<R1, A1> listener:listeners)
									listener.onAccountingResponse(castedAnswer, this, callback);
							}
						}
					}
					else
					{
						Boolean processed = false;
						if(((AccountingRequest)request).getAccountingRecordType()!=null && (((AccountingRequest)request).getAccountingRecordType()==AccountingRecordTypeEnum.START_RECORD || ((AccountingRequest)request).getAccountingRecordType()==AccountingRecordTypeEnum.INTERIM_RECORD))
						{
							Boolean shouldProcessLocally = false;
							try
							{
								if(((AccountingRequest)request).getAccountingRealtimeRequired()!=null && ((AccountingRequest)request).getAccountingRealtimeRequired()==AccountingRealtimeRequiredEnum.GRANT_AND_LOSE)
									shouldProcessLocally = true;
							}
							catch(AvpNotSupportedException ex)
							{
								
							}
							
							if(shouldProcessLocally)
							{
								setSessionState(SessionStateEnum.OPEN);
								if(listeners!=null)
								{
									for(ClientAccListener<R1, A1> listener:listeners)
										listener.onAccountingResponse(castedAnswer, this, callback);
								}
								
								processed = true;
							}
						}
						
						if(!processed)
						{
							setSessionState(SessionStateEnum.IDLE);
							terminate(answer.getResultCode());
							if(listeners!=null)
							{
								for(ClientAccListener<R1, A1> listener:listeners)
									listener.onAccountingResponse(castedAnswer, this, callback);													
							}
						}
					}
				}
			}
			catch(Exception ex)
			{
				callback.onError(new DiameterException("Received unexpected answer", null, ResultCodes.DIAMETER_COMMAND_UNSUPPORTED, null));
				return;
			}
			
			if(getSessionState()!=SessionStateEnum.IDLE)
				super.answerReceived(answer, callback,newTime, !isRetry());			
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
			DiameterRequest request = getLastSendRequest();
			if(request!=null)
			{
				Boolean shouldResend=false;
				if(!isRetry())
				{
					if(((AccountingRequest)request).getAccountingRecordType()!=null && (((AccountingRequest)request).getAccountingRecordType()==AccountingRecordTypeEnum.START_RECORD || ((AccountingRequest)request).getAccountingRecordType()==AccountingRecordTypeEnum.INTERIM_RECORD))
					{
						try
						{
							if(((AccountingRequest)request).getAccountingRealtimeRequired()!=null && ((AccountingRequest)request).getAccountingRealtimeRequired()!=AccountingRealtimeRequiredEnum.DELIVER_AND_GRANT)
								shouldResend = true;
						}
						catch(AvpNotSupportedException ex2)
						{
							//ignore
						}
					}
					else
						shouldResend=true;
				}
				
				//does not really matters since will be changed right away to PENDING again
				setSessionState(SessionStateEnum.IDLE);
				if(!shouldResend)
				{
					terminate(ex.getErrorCode());
					realCallback.onError(ex);	
				}
				else
				{
					setIsRetry(true);
					@SuppressWarnings("unchecked")
					R1 castedRequest=(R1)request;
					sendAccountingRequest(castedRequest, realCallback);				
				}
			}
			else
				realCallback.onError(ex);
		}		
	}
}