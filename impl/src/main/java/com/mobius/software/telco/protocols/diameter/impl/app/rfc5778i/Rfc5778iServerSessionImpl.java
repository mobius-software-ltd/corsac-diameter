package com.mobius.software.telco.protocols.diameter.impl.app.rfc5778i;
import java.io.IOException;
import java.io.ObjectInput;

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
import org.restcomm.cluster.ClusteredID;

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.AsyncCallback;
import com.mobius.software.telco.protocols.diameter.DiameterProvider;
import com.mobius.software.telco.protocols.diameter.ResultCodes;
import com.mobius.software.telco.protocols.diameter.app.SessionStateEnum;
import com.mobius.software.telco.protocols.diameter.app.rfc5778i.Rfc5778iServerSession;
import com.mobius.software.telco.protocols.diameter.app.rfc5778i.ServerListener;
import com.mobius.software.telco.protocols.diameter.commands.DiameterAnswer;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778i.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778i.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778i.AccountingAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778i.AccountingRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778i.EAPAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778i.EAPRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778i.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778i.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778i.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778i.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.impl.app.ServerAccSessionImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.ServerAuthSessionImpl;

import io.netty.buffer.ByteBuf;


public class Rfc5778iServerSessionImpl implements Rfc5778iServerSession
{
	private ServerAccSessionImpl<AccountingRequest, AccountingAnswer> accSession=null;
	private ServerAuthSessionImpl<EAPRequest, EAPAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer> authSession=null;
	
	public Rfc5778iServerSessionImpl()
	{
		
	}
	
	public Rfc5778iServerSessionImpl(Boolean isAuth, String sessionID, String remoteHost, String remoteRealm, DiameterProvider<?, ? extends ServerListener, ?, ?, ?> provider)
	{
		if(isAuth==null || isAuth)
			authSession = new ServerAuthSessionImpl<EAPRequest, EAPAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer>(sessionID, Long.valueOf(ApplicationIDs.MIP6I), remoteHost, remoteRealm, provider);
		else
			accSession = new ServerAccSessionImpl<AccountingRequest, AccountingAnswer>(sessionID, Long.valueOf(ApplicationIDs.MIP6I), remoteHost, remoteRealm, provider);
	}

	@Override
	public void sendAccountingResponse(AccountingAnswer answer, AsyncCallback callback)
	{
		if(accSession != null)
			accSession.sendAccountingResponse(answer, callback);
		else 
			callback.onError(new DiameterException("Invalid session type", null, ResultCodes.DIAMETER_UNABLE_TO_DELIVER, null));
	}

	@Override
	public SessionStateEnum getSessionState()
	{
		if(accSession!=null)
			return accSession.getSessionState();
		
		return authSession.getSessionState();
	}

	@Override
	public void terminate(Long resultCode)
	{
		if(accSession==null)
			accSession.terminate(resultCode);
		else
			authSession.terminate(resultCode);
	}

	@Override
	public void sendInitialAnswer(EAPAnswer answer, AsyncCallback callback)
	{
		if(authSession != null)
			authSession.sendInitialAnswer(answer, callback);
		else 
			callback.onError(new DiameterException("Invalid session type", null, ResultCodes.DIAMETER_UNABLE_TO_DELIVER, null));
	}

	@Override
	public void sendReauthRequest(ReAuthRequest request, AsyncCallback callback)
	{
		if(authSession != null)
			authSession.sendReauthRequest(request, callback);
		else 
			callback.onError(new DiameterException("Invalid session type", null, ResultCodes.DIAMETER_UNABLE_TO_DELIVER, null));
	}

	@Override
	public void sendSessionTerminationAnswer(SessionTerminationAnswer answer, AsyncCallback callback)
	{
		if(authSession != null)
			authSession.sendSessionTerminationAnswer(answer, callback);
		else 
			callback.onError(new DiameterException("Invalid session type", null, ResultCodes.DIAMETER_UNABLE_TO_DELIVER, null));
	}

	@Override
	public void sendAbortSessionRequest(AbortSessionRequest request, AsyncCallback callback)
	{
		if(authSession != null)
			authSession.sendAbortSessionRequest(request, callback);
		else 
			callback.onError(new DiameterException("Invalid session type", null, ResultCodes.DIAMETER_UNABLE_TO_DELIVER, null));
	}

	@Override
	public String getID()
	{
		if(accSession!=null)
			return accSession.getID();
		else
			return authSession.getID();
	}

	@Override
	public String getRemoteHost()
	{
		if(accSession!=null)
			return accSession.getRemoteHost();
		
		return authSession.getRemoteHost();
	}

	@Override
	public String getRemoteRealm()
	{
		if(accSession!=null)
			return accSession.getRemoteRealm();
		
		return authSession.getRemoteRealm();
	}

	@Override
	public Long getApplicationID()
	{
		if(accSession!=null)
			return accSession.getApplicationID();
		else
			return authSession.getApplicationID();
	}

	@Override
	public ClusteredID<?> getIdleTimerID()
	{
		if(accSession!=null)
			return accSession.getIdleTimerID();
		else
			return authSession.getIdleTimerID();
	}

	@Override
	public ClusteredID<?> getSendTimerID()
	{
		if(accSession!=null)
			return accSession.getSendTimerID();
		else
			return authSession.getSendTimerID();
	}

	@Override
	public void setIdleTimerID(ClusteredID<?> id)
	{
		if(accSession!=null)
			accSession.setIdleTimerID(id);
		else
			authSession.setIdleTimerID(id);
	}

	@Override
	public void setSendTimerID(ClusteredID<?> id)
	{
		if(accSession!=null)
			accSession.setSendTimerID(id);
		else
			authSession.setSendTimerID(id);
	}

	@Override
	public void requestReceived(DiameterRequest request, AsyncCallback callback)
	{
		if(accSession!=null)
			accSession.requestReceived(request, callback);
		else
			authSession.requestReceived(request, callback);
	}

	@Override
	public void answerReceived(DiameterAnswer answer, AsyncCallback callback, Long idleTime, Boolean stopSendTimer)
	{
		if(accSession!=null)
			accSession.answerReceived(answer, callback, idleTime, stopSendTimer);	
		else
			authSession.answerReceived(answer, callback, idleTime, stopSendTimer);	
	}

	@Override
	public void requestSent(DiameterRequest request, AsyncCallback callback)
	{
		if(accSession!=null)
			accSession.requestSent(request, callback);
		else
			authSession.requestSent(request, callback);
	}

	@Override
	public void answerSent(DiameterAnswer answer, AsyncCallback callback, Long idleTime)
	{
		if(accSession!=null)
			accSession.answerSent(answer, callback, idleTime);
		else
			authSession.answerSent(answer, callback, idleTime);
	}

	@Override
	public void onTimeout()
	{
		if(accSession!=null)
			accSession.onTimeout();
		else
			authSession.onTimeout();
	}

	@Override
	public void onIdleTimeout()
	{
		if(accSession!=null)
			accSession.onIdleTimeout();
		else
			authSession.onIdleTimeout();
	}

	@Override
	public boolean isServer()
	{
		if(accSession!=null)
			return accSession.isServer();
		else
			return authSession.isServer();
	}

	@Override
	public void setSessionState(SessionStateEnum state)
	{
		if(accSession!=null)
			accSession.setSessionState(state);
		
		authSession.setSessionState(state);
	}

	@Override
	public DiameterRequest getLastSendRequest()
	{
		if(accSession!=null)
			return accSession.getLastSendRequest();
		
		return authSession.getLastSendRequest();
	}

	@Override
	public void setLastSentRequest(DiameterRequest request)
	{
		if(accSession!=null)
			accSession.setLastSentRequest(request);
		
		authSession.setLastSentRequest(request);
	}

	@Override
	public Boolean isRetry()
	{
		if(accSession!=null)
			return accSession.isRetry();
		
		return authSession.isRetry();
	}

	@Override
	public void setIsRetry(Boolean isRetry)
	{
		if(accSession!=null)
			accSession.setIsRetry(isRetry);
		
		authSession.setIsRetry(isRetry);
	}

	@Override
	public ByteBuf getLastSendRequestData()
	{
		if(accSession!=null)
			return accSession.getLastSendRequestData();
		
		return authSession.getLastSendRequestData();
	}
	
	@Override
	public DiameterProvider<?, ?, ?, ?, ?> getProvider()
	{
		if(accSession!=null)
			return accSession.getProvider();
		
		return authSession.getProvider();
	}

	@Override
	public void load(ObjectInput in) throws IOException, ClassNotFoundException
	{
		Boolean isAcc = in.readBoolean();
		if(isAcc)
		{
			accSession = new ServerAccSessionImpl<AccountingRequest, AccountingAnswer>(Long.valueOf(ApplicationIDs.MIP6I));
			accSession.load(in);
		}
		else
		{
			authSession = new ServerAuthSessionImpl<EAPRequest, EAPAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer>(Long.valueOf(ApplicationIDs.MIP6I));
			authSession.load(in);
		}
	}
}