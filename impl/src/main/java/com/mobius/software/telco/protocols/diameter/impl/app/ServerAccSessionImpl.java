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

import com.mobius.software.telco.protocols.diameter.AsyncCallback;
import com.mobius.software.telco.protocols.diameter.DiameterProvider;
import com.mobius.software.telco.protocols.diameter.ResultCodes;
import com.mobius.software.telco.protocols.diameter.app.ServerAccListener;
import com.mobius.software.telco.protocols.diameter.app.ServerAccSession;
import com.mobius.software.telco.protocols.diameter.app.SessionStateEnum;
import com.mobius.software.telco.protocols.diameter.commands.DiameterAnswer;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.commands.commons.AccountingAnswer;
import com.mobius.software.telco.protocols.diameter.commands.commons.AccountingRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.impl.DiameterSessionImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AccountingRecordTypeEnum;
/**
*
* @author yulian oifa
*
*/
public class ServerAccSessionImpl<R1 extends AccountingRequest,A1 extends AccountingAnswer> extends DiameterSessionImpl implements ServerAccSession<A1>
{
	private DiameterProvider<?, ? extends ServerAccListener<R1>, ?, ?, ?> provider;
	public ServerAccSessionImpl(String sessionID, DiameterProvider<?, ? extends ServerAccListener<R1>, ?, ?, ?> provider)
	{
		super(sessionID, provider);
		this.provider = provider;
	}

	@Override
	public void sendAccountingResponse(A1 answer, AsyncCallback callback)
	{
		Boolean shouldKeepOpen=true;
		
		if(answer.getIsError()!=null && answer.getIsError())
			shouldKeepOpen=false;
		else if(answer.getAccountingRecordType()!=null && answer.getAccountingRecordType()==AccountingRecordTypeEnum.EVENT_RECORD)
			shouldKeepOpen=false;
		else if(answer.getAccountingRecordType()!=null && answer.getAccountingRecordType()==AccountingRecordTypeEnum.STOP_RECORD)
			shouldKeepOpen=false;
		
		if(!shouldKeepOpen)
		{	
			setSessionState(SessionStateEnum.IDLE);
			terminate();
		}
		else
		{
			setSessionState(SessionStateEnum.OPEN);
			
			Long newTime = null;
			if(answer.getAcctInterimInterval()!=null)
				newTime = answer.getAcctInterimInterval()*1000L;
			
			answerSent(answer, callback, newTime);
		}
		
		provider.getStack().sendMessageToNetwork(answer, callback);			
	}
	
	@Override
	public void requestReceived(DiameterRequest request, AsyncCallback callback)
	{
		@SuppressWarnings("unchecked")
		Collection<ServerAccListener<R1>> listeners = (Collection<ServerAccListener<R1>>) provider.getServerListeners().values();
		
		try
		{
			@SuppressWarnings("unchecked")
			R1 castedRequest = (R1)request;
			for(ServerAccListener<R1> listener:listeners)
				listener.onAccountingRequest(castedRequest, callback);	
		}
		catch(Exception ex)
		{
			callback.onError(new DiameterException("Received unexpected request", null, ResultCodes.DIAMETER_COMMAND_UNSUPPORTED, null));
			return;
		}
		
		super.requestReceived(request, callback);
	}
	
	@Override
	public void answerReceived(DiameterAnswer answer, AsyncCallback callback, Long idleTime,Boolean stopSendTimer)
	{
		callback.onError(new DiameterException("Received unexpected answer", null, ResultCodes.DIAMETER_COMMAND_UNSUPPORTED, null));		
	}

	@Override
	public boolean isServer()
	{
		return true;
	}
}