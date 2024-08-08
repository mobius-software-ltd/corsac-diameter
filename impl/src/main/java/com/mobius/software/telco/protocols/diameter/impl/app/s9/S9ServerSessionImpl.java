package com.mobius.software.telco.protocols.diameter.impl.app.s9;
import org.restcomm.cluster.ClusteredID;

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.AsyncCallback;
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
import com.mobius.software.telco.protocols.diameter.DiameterProvider;
import com.mobius.software.telco.protocols.diameter.ResultCodes;
import com.mobius.software.telco.protocols.diameter.app.SessionStateEnum;
import com.mobius.software.telco.protocols.diameter.app.s9.S9ServerSession;
import com.mobius.software.telco.protocols.diameter.app.s9.ServerListener;
import com.mobius.software.telco.protocols.diameter.commands.DiameterAnswer;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.commands.s9.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s9.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.s9.CreditControlAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s9.CreditControlRequest;
import com.mobius.software.telco.protocols.diameter.commands.s9.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s9.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.s9.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s9.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.commands.s9.TriggerEstablishmentAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s9.TriggerEstablishmentRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.impl.app.ServerAuthSessionStatelessImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.ServerCCSessionImpl;
public class S9ServerSessionImpl implements S9ServerSession
{
	private ServerAuthSessionStatelessImpl<TriggerEstablishmentRequest, TriggerEstablishmentAnswer> authSession = null;
	private ServerCCSessionImpl<CreditControlRequest, CreditControlAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer> ccSession=null;
	
	public S9ServerSessionImpl()
	{
		
	}
	
	public S9ServerSessionImpl(Boolean isCC, String sessionID, String remoteHost, String remoteRealm, DiameterProvider<?, ? extends ServerListener, ?, ?, ?> provider)
	{
		if(isCC==null || isCC)
			ccSession = new ServerCCSessionImpl<CreditControlRequest, CreditControlAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer>(sessionID, Long.valueOf(ApplicationIDs.S9), remoteHost, remoteRealm, provider);
		else
			authSession = new ServerAuthSessionStatelessImpl<TriggerEstablishmentRequest, TriggerEstablishmentAnswer>(sessionID, Long.valueOf(ApplicationIDs.S9), remoteHost, remoteRealm, provider);
	}

	@Override
	public void sendInitialAnswer(TriggerEstablishmentAnswer answer, AsyncCallback callback)
	{
		if(authSession != null)
			authSession.sendInitialAnswer(answer, callback);
		else 
			callback.onError(new DiameterException("Invalid session type", null, ResultCodes.DIAMETER_UNABLE_TO_DELIVER, null));
	}

	@Override
	public SessionStateEnum getSessionState()
	{
		if(authSession!=null)
			return authSession.getSessionState();
		else
			return ccSession.getSessionState();
	}

	@Override
	public void terminate(Long resultCode)
	{
		if(authSession==null)
			authSession.terminate(resultCode);
		else
			ccSession.terminate(resultCode);
	}

	@Override
	public void sendInitialAnswer(CreditControlAnswer answer, AsyncCallback callback)
	{
		if(ccSession != null)
			ccSession.sendInitialAnswer(answer, callback);
		else 
			callback.onError(new DiameterException("Invalid session type", null, ResultCodes.DIAMETER_UNABLE_TO_DELIVER, null));
	}

	@Override
	public void sendReauthRequest(ReAuthRequest request, AsyncCallback callback)
	{
		if(ccSession != null)
			ccSession.sendReauthRequest(request, callback);
		else 
			callback.onError(new DiameterException("Invalid session type", null, ResultCodes.DIAMETER_UNABLE_TO_DELIVER, null));
	}

	@Override
	public void sendSessionTerminationAnswer(SessionTerminationAnswer answer, AsyncCallback callback)
	{
		if(ccSession != null)
			ccSession.sendSessionTerminationAnswer(answer, callback);
		else 
			callback.onError(new DiameterException("Invalid session type", null, ResultCodes.DIAMETER_UNABLE_TO_DELIVER, null));
	}

	@Override
	public void sendAbortSessionRequest(AbortSessionRequest request, AsyncCallback callback)
	{
		if(ccSession != null)
			ccSession.sendAbortSessionRequest(request, callback);
		else 
			callback.onError(new DiameterException("Invalid session type", null, ResultCodes.DIAMETER_UNABLE_TO_DELIVER, null));
	}

	@Override
	public String getID()
	{
		if(authSession!=null)
			return authSession.getID();
		else
			return ccSession.getID();
	}

	@Override
	public String getRemoteHost()
	{
		if(authSession!=null)
			return authSession.getRemoteHost();
		else
			return ccSession.getRemoteHost();
	}

	@Override
	public String getRemoteRealm()
	{
		if(authSession!=null)
			return authSession.getRemoteRealm();
		else
			return ccSession.getRemoteRealm();
	}

	@Override
	public void setRemoteHost(String remoteHost)
	{
		if(authSession!=null)
			authSession.setRemoteHost(remoteHost);
		else
			ccSession.setRemoteHost(remoteHost);
	}

	@Override
	public void setRemoteRealm(String remoteRealm)
	{
		if(authSession!=null)
			authSession.setRemoteRealm(remoteRealm);
		else
			ccSession.setRemoteRealm(remoteRealm);
	}

	@Override
	public Long getApplicationID()
	{
		if(authSession!=null)
			return authSession.getApplicationID();
		else
			return ccSession.getApplicationID();
	}

	@Override
	public ClusteredID<?> getIdleTimerID()
	{
		if(authSession!=null)
			return authSession.getIdleTimerID();
		else
			return ccSession.getIdleTimerID();
	}

	@Override
	public ClusteredID<?> getSendTimerID()
	{
		if(authSession!=null)
			return authSession.getSendTimerID();
		else
			return ccSession.getSendTimerID();
	}

	@Override
	public void setIdleTimerID(ClusteredID<?> id)
	{
		if(authSession!=null)
			authSession.setIdleTimerID(id);
		else
			ccSession.setIdleTimerID(id);
	}

	@Override
	public void setSendTimerID(ClusteredID<?> id)
	{
		if(authSession!=null)
			authSession.setSendTimerID(id);
		else
			ccSession.setSendTimerID(id);
	}

	@Override
	public void requestReceived(DiameterRequest request, AsyncCallback callback)
	{
		if(authSession!=null)
			authSession.requestReceived(request, callback);
		else
			ccSession.requestReceived(request, callback);
	}

	@Override
	public void answerReceived(DiameterAnswer answer, AsyncCallback callback, Long idleTime, Boolean stopSendTimer)
	{
		if(authSession!=null)
			authSession.answerReceived(answer, callback, idleTime, stopSendTimer);	
		else
			ccSession.answerReceived(answer, callback, idleTime, stopSendTimer);	
	}

	@Override
	public void requestSent(DiameterRequest request, AsyncCallback callback)
	{
		if(authSession!=null)
			authSession.requestSent(request, callback);
		else
			ccSession.requestSent(request, callback);
	}

	@Override
	public void answerSent(DiameterAnswer answer, AsyncCallback callback, Long idleTime)
	{
		if(authSession!=null)
			authSession.answerSent(answer, callback, idleTime);
		else
			ccSession.answerSent(answer, callback, idleTime);
	}

	@Override
	public void onTimeout()
	{
		if(authSession!=null)
			authSession.onTimeout();
		else
			ccSession.onTimeout();
	}

	@Override
	public void onIdleTimeout()
	{
		if(authSession!=null)
			authSession.onIdleTimeout();
		else
			ccSession.onIdleTimeout();
	}

	@Override
	public boolean isServer()
	{
		if(authSession!=null)
			return authSession.isServer();
		else
			return ccSession.isServer();
	}

	@Override
	public void setSessionState(SessionStateEnum state)
	{
		if(authSession!=null)
			authSession.setSessionState(state);
		else
			ccSession.setSessionState(state);
	}

	@Override
	public DiameterRequest getLastSendRequest()
	{
		if(authSession!=null)
			return authSession.getLastSendRequest();
		else
			return ccSession.getLastSendRequest();
	}

	@Override
	public void setLastSentRequest(DiameterRequest request)
	{
		if(authSession!=null)
			authSession.setLastSentRequest(request);
		else
			ccSession.setLastSentRequest(request);
	}

	@Override
	public Boolean isRetry()
	{
		if(authSession!=null)
			return authSession.isRetry();
		else
			return ccSession.isRetry();
	}

	@Override
	public void setIsRetry(Boolean isRetry)
	{
		if(authSession!=null)
			authSession.setIsRetry(isRetry);
		else
			ccSession.setIsRetry(isRetry);
	}
	
	@Override
	public DiameterProvider<?, ?, ?, ?, ?> getProvider()
	{
		if(authSession!=null)
			return authSession.getProvider();
		else
			return ccSession.getProvider();
	}

	@Override
	public void setProvider(DiameterProvider<?, ?, ?, ?, ?> provider)
	{
		if(authSession!=null)
			authSession.setProvider(provider);
		else
			ccSession.setProvider(provider);
	}

	@Override
	public void load(String sessionID, SessionStateEnum sessionSate, byte otherFields)
	{
		Boolean isAuth = (otherFields & 0x40)!=0;
		if(isAuth)
		{
			authSession = new ServerAuthSessionStatelessImpl<TriggerEstablishmentRequest, TriggerEstablishmentAnswer>(Long.valueOf(ApplicationIDs.S9));
			authSession.load(sessionID, sessionSate, otherFields);		
		}
		else
		{
			ccSession = new ServerCCSessionImpl<CreditControlRequest, CreditControlAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer>(Long.valueOf(ApplicationIDs.S9));
			ccSession.load(sessionID, sessionSate, otherFields);
		}
	}
	
	@Override
	public byte getOtherFieldsByte()
	{
		if(authSession!=null)
			return (byte)(authSession.getOtherFieldsByte() + 64);
		else
			return ccSession.getOtherFieldsByte();
	}
}