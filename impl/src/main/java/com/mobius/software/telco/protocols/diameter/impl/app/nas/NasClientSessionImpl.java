package com.mobius.software.telco.protocols.diameter.impl.app.nas;
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
import com.mobius.software.telco.protocols.diameter.app.nas.ClientListener;
import com.mobius.software.telco.protocols.diameter.app.nas.NasClientSession;
import com.mobius.software.telco.protocols.diameter.commands.DiameterAnswer;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.commands.nas.AAAnswer;
import com.mobius.software.telco.protocols.diameter.commands.nas.AARequest;
import com.mobius.software.telco.protocols.diameter.commands.nas.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.nas.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.nas.AccountingAnswer;
import com.mobius.software.telco.protocols.diameter.commands.nas.AccountingRequest;
import com.mobius.software.telco.protocols.diameter.commands.nas.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.nas.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.nas.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.nas.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.impl.app.ClientAccSessionImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.ClientAuthSessionImpl;

public class NasClientSessionImpl implements NasClientSession
{
	private ClientAccSessionImpl<AccountingRequest, AccountingAnswer> accSession = null;
	private ClientAuthSessionImpl<AARequest, AAAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer> authSession = null;
	
	public NasClientSessionImpl(Boolean isAuth, String sessionID, String remoteHost, String remoteRealm, DiameterProvider<? extends ClientListener, ?, ?, ?, ?> provider)
	{
		if(isAuth==null || isAuth)
			authSession = new ClientAuthSessionImpl<AARequest, AAAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer>(sessionID, Long.valueOf(ApplicationIDs.NASREQ), remoteHost, remoteRealm, provider);
		else
			accSession = new ClientAccSessionImpl<AccountingRequest, AccountingAnswer>(sessionID, Long.valueOf(ApplicationIDs.NASREQ), remoteHost, remoteRealm, provider);		
	}

	@Override
	public void sendAccountingRequest(AccountingRequest request, AsyncCallback callback)
	{
		if(accSession != null)
			accSession.sendAccountingRequest(request, callback);
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
	public void sendInitialRequest(AARequest request, AsyncCallback callback)
	{
		if(authSession != null)
			authSession.sendInitialRequest(request, callback);
		else 
			callback.onError(new DiameterException("Invalid session type", null, ResultCodes.DIAMETER_UNABLE_TO_DELIVER, null));
	}

	@Override
	public void sendReauthAnswer(ReAuthAnswer answer, AsyncCallback callback)
	{
		if(authSession != null)
			authSession.sendReauthAnswer(answer, callback);
		else 
			callback.onError(new DiameterException("Invalid session type", null, ResultCodes.DIAMETER_UNABLE_TO_DELIVER, null));
	}

	@Override
	public void sendSessionTerminationRequest(SessionTerminationRequest request, AsyncCallback callback)
	{
		if(authSession != null)
			authSession.sendSessionTerminationRequest(request, callback);
		else 
			callback.onError(new DiameterException("Invalid session type", null, ResultCodes.DIAMETER_UNABLE_TO_DELIVER, null));
	}

	@Override
	public void sendAbortSessionAnswer(AbortSessionAnswer answer, AsyncCallback callback)
	{
		if(authSession != null)
			authSession.sendAbortSessionAnswer(answer, callback);
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
	public Long getApplicationID()
	{
		if(accSession!=null)
			return accSession.getApplicationID();
		else
			return authSession.getApplicationID();
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
	public DiameterProvider<?, ?, ?, ?, ?> getProvider()
	{
		if(accSession!=null)
			return accSession.getProvider();
		
		return authSession.getProvider();
	}
}