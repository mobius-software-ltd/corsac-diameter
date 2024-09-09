package com.mobius.software.telco.protocols.diameter.impl.app.rfc5778i;
import java.io.Externalizable;

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
import com.mobius.software.telco.protocols.diameter.app.rfc5778i.ClientListener;
import com.mobius.software.telco.protocols.diameter.app.rfc5778i.Rfc5778iClientSession;
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
import com.mobius.software.telco.protocols.diameter.impl.app.ClientAccSessionImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.ClientAuthSessionImpl;

public class Rfc5778iClientSessionImpl implements Rfc5778iClientSession
{
	private ClientAccSessionImpl<AccountingRequest, AccountingAnswer> accSession = null;
	private ClientAuthSessionImpl<EAPRequest, EAPAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer> authSession = null;
	
	public Rfc5778iClientSessionImpl()
	{
		
	}
	
	public Rfc5778iClientSessionImpl(Boolean isAuth, String sessionID, String remoteHost, String remoteRealm, DiameterProvider<? extends ClientListener, ?, ?, ?, ?> provider)
	{
		if(isAuth==null || isAuth)
			authSession = new ClientAuthSessionImpl<EAPRequest, EAPAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer>(sessionID, Long.valueOf(ApplicationIDs.MIP6I), remoteHost, remoteRealm, provider);
		else
			accSession = new ClientAccSessionImpl<AccountingRequest, AccountingAnswer>(sessionID, Long.valueOf(ApplicationIDs.MIP6I), remoteHost, remoteRealm, provider);		
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
		else
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
	public void sendInitialRequest(EAPRequest request, AsyncCallback callback)
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
		else
			return authSession.getRemoteHost();
	}

	@Override
	public String getRemoteRealm()
	{
		if(accSession!=null)
			return accSession.getRemoteRealm();
		else
			return authSession.getRemoteRealm();
	}

	@Override
	public void setRemoteHost(String remoteHost)
	{
		if(accSession!=null)
			accSession.setRemoteHost(remoteHost);
		else
			authSession.setRemoteHost(remoteHost);
	}

	@Override
	public void setRemoteRealm(String remoteRealm)
	{
		if(accSession!=null)
			accSession.setRemoteRealm(remoteRealm);
		else
			authSession.setRemoteRealm(remoteRealm);
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
	public void requestReceived(DiameterRequest request, String linkID, AsyncCallback callback)
	{
		if(accSession!=null)
			accSession.requestReceived(request, linkID, callback);
		else
			authSession.requestReceived(request, linkID, callback);
	}

	@Override
	public void answerReceived(DiameterAnswer answer, Long idleTime, Boolean stopSendTimer, String linkID, AsyncCallback callback)
	{
		if(accSession!=null)
			accSession.answerReceived(answer, idleTime, stopSendTimer, linkID, callback);	
		else
			authSession.answerReceived(answer, idleTime, stopSendTimer, linkID, callback);	
	}

	@Override
	public void requestSent(Boolean newSession,DiameterRequest request, AsyncCallback callback)
	{
		if(accSession!=null)
			accSession.requestSent(newSession, request, callback);
		else
			authSession.requestSent(newSession, request, callback);
	}

	@Override
	public void answerSent(DiameterAnswer answer, Long idleTime, AsyncCallback callback)
	{
		if(accSession!=null)
			accSession.answerSent(answer, idleTime, callback);
		else
			authSession.answerSent(answer, idleTime, callback);
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
		else
			authSession.setSessionState(state);
	}

	@Override
	public DiameterRequest getLastSendRequest()
	{
		if(accSession!=null)
			return accSession.getLastSendRequest();
		else
			return authSession.getLastSendRequest();
	}

	@Override
	public void setLastSentRequest(DiameterRequest request)
	{
		if(accSession!=null)
			accSession.setLastSentRequest(request);
		else
			authSession.setLastSentRequest(request);
	}

	@Override
	public Boolean isRetry()
	{
		if(accSession!=null)
			return accSession.isRetry();
		else
			return authSession.isRetry();
	}

	@Override
	public void setIsRetry(Boolean isRetry)
	{
		if(accSession!=null)
			accSession.setIsRetry(isRetry);
		else
			authSession.setIsRetry(isRetry);
	}
	
	@Override
	public DiameterProvider<?, ?, ?, ?, ?> getProvider()
	{
		if(accSession!=null)
			return accSession.getProvider();
		else
			return authSession.getProvider();
	}

	@Override
	public void setProvider(DiameterProvider<?, ?, ?, ?, ?> provider)
	{
		if(accSession!=null)
			accSession.setProvider(provider);
		else
			authSession.setProvider(provider);
	}

	@Override
	public void load(String sessionID, SessionStateEnum sessionSate, byte otherFields)
	{
		Boolean isAcc = (otherFields & 0x40)!=0;
		if(isAcc)
		{
			accSession = new ClientAccSessionImpl<AccountingRequest, AccountingAnswer>(Long.valueOf(ApplicationIDs.MIP6I));
			accSession.load(sessionID, sessionSate, otherFields);
		}
		else
		{
			authSession = new ClientAuthSessionImpl<EAPRequest, EAPAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer>(Long.valueOf(ApplicationIDs.MIP6I));
			authSession.load(sessionID, sessionSate, otherFields);
		}
	}
	
	@Override
	public byte getOtherFieldsByte()
	{
		if(accSession!=null)
			return (byte)(accSession.getOtherFieldsByte() + 64);
		else
			return authSession.getOtherFieldsByte();
	}

	@Override
	public void setUserObject(Externalizable uo)
	{
		if(accSession!=null)
			accSession.setUserObject(uo);
		else
			authSession.setUserObject(uo);
	}

	@Override
	public Externalizable getUserObject()
	{
		if(accSession!=null)
			return accSession.getUserObject();
		else
			return authSession.getUserObject();
	}
}