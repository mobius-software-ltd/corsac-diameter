package com.mobius.software.telco.protocols.diameter.impl.app.sd;
import java.io.IOException;
import java.io.ObjectInput;

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
import com.mobius.software.telco.protocols.diameter.app.sd.ClientListener;
import com.mobius.software.telco.protocols.diameter.app.sd.SdClientSession;
import com.mobius.software.telco.protocols.diameter.commands.DiameterAnswer;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.commands.sd.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sd.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.sd.CreditControlAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sd.CreditControlRequest;
import com.mobius.software.telco.protocols.diameter.commands.sd.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sd.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.sd.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sd.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.commands.sd.TDFSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sd.TDFSessionRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.impl.app.ClientAuthSessionImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.ClientCCSessionImpl;

import io.netty.buffer.ByteBuf;

public class SdClientSessionImpl implements SdClientSession
{
	private ClientAuthSessionImpl<TDFSessionRequest, TDFSessionAnswer, ReAuthRequest, ReAuthAnswer, AbortSessionRequest, AbortSessionAnswer, SessionTerminationRequest, SessionTerminationAnswer> authSession = null;
	private ClientCCSessionImpl<CreditControlRequest, CreditControlAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer> ccSession = null;
	
	public SdClientSessionImpl()
	{
		
	}
	
	public SdClientSessionImpl(Boolean isCC, String sessionID, String remoteHost, String remoteRealm, DiameterProvider<? extends ClientListener, ?, ?, ?, ?> provider)
	{
		if(isCC==null || isCC)
			ccSession = new ClientCCSessionImpl<CreditControlRequest, CreditControlAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer>(sessionID, Long.valueOf(ApplicationIDs.SD), remoteHost, remoteRealm, provider);
		else
			authSession = new ClientAuthSessionImpl<TDFSessionRequest, TDFSessionAnswer, ReAuthRequest, ReAuthAnswer, AbortSessionRequest, AbortSessionAnswer, SessionTerminationRequest, SessionTerminationAnswer>(sessionID, Long.valueOf(ApplicationIDs.SD), remoteHost, remoteRealm, provider);		
	}

	@Override
	public void sendInitialRequest(TDFSessionRequest request, AsyncCallback callback)
	{
		if(authSession != null)
			authSession.sendInitialRequest(request, callback);
		else 
			callback.onError(new DiameterException("Invalid session type", null, ResultCodes.DIAMETER_UNABLE_TO_DELIVER, null));
	}

	@Override
	public SessionStateEnum getSessionState()
	{
		if(authSession!=null)
			return authSession.getSessionState();
		
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
	public void sendInitialRequest(CreditControlRequest request, AsyncCallback callback)
	{
		if(ccSession != null)
			ccSession.sendInitialRequest(request, callback);
		else 
			callback.onError(new DiameterException("Invalid session type", null, ResultCodes.DIAMETER_UNABLE_TO_DELIVER, null));
	}

	@Override
	public void sendReauthAnswer(ReAuthAnswer answer, AsyncCallback callback)
	{
		if(ccSession != null)
			ccSession.sendReauthAnswer(answer, callback);
		else 
			callback.onError(new DiameterException("Invalid session type", null, ResultCodes.DIAMETER_UNABLE_TO_DELIVER, null));
	}

	@Override
	public void sendSessionTerminationRequest(SessionTerminationRequest request, AsyncCallback callback)
	{
		if(ccSession != null)
			ccSession.sendSessionTerminationRequest(request, callback);
		else 
			callback.onError(new DiameterException("Invalid session type", null, ResultCodes.DIAMETER_UNABLE_TO_DELIVER, null));
	}

	@Override
	public void sendAbortSessionAnswer(AbortSessionAnswer answer, AsyncCallback callback)
	{
		if(ccSession != null)
			ccSession.sendAbortSessionAnswer(answer, callback);
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
		
		return ccSession.getRemoteHost();
	}

	@Override
	public String getRemoteRealm()
	{
		if(authSession!=null)
			return authSession.getRemoteRealm();
		
		return ccSession.getRemoteRealm();
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
			authSession.answerSent(answer, callback, idleTime);
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
	public Long getApplicationID()
	{
		if(authSession!=null)
			return authSession.getApplicationID();
		else
			return ccSession.getApplicationID();
	}

	@Override
	public void setSessionState(SessionStateEnum state)
	{
		if(authSession!=null)
			authSession.setSessionState(state);
		
		ccSession.setSessionState(state);
	}

	@Override
	public DiameterRequest getLastSendRequest()
	{
		if(authSession!=null)
			return authSession.getLastSendRequest();
		
		return ccSession.getLastSendRequest();
	}

	@Override
	public void setLastSentRequest(DiameterRequest request)
	{
		if(authSession!=null)
			authSession.setLastSentRequest(request);
		
		ccSession.setLastSentRequest(request);
	}

	@Override
	public Boolean isRetry()
	{
		if(authSession!=null)
			return authSession.isRetry();
		
		return ccSession.isRetry();
	}

	@Override
	public void setIsRetry(Boolean isRetry)
	{
		if(authSession!=null)
			authSession.setIsRetry(isRetry);
		
		ccSession.setIsRetry(isRetry);
	}
	
	@Override
	public DiameterProvider<?, ?, ?, ?, ?> getProvider()
	{
		if(authSession!=null)
			return authSession.getProvider();
		
		return ccSession.getProvider();
	}

	@Override
	public ByteBuf getLastSendRequestData()
	{
		if(authSession!=null)
			return authSession.getLastSendRequestData();
		
		return ccSession.getLastSendRequestData();
	}
	
	@Override
	public void load(String sessionID, SessionStateEnum sessionSate, byte otherFields, ObjectInput in) throws IOException, ClassNotFoundException
	{
		Boolean isAuth = (otherFields & 0x40)!=0;
		if(isAuth)
		{
			authSession = new ClientAuthSessionImpl<TDFSessionRequest, TDFSessionAnswer, ReAuthRequest, ReAuthAnswer, AbortSessionRequest, AbortSessionAnswer, SessionTerminationRequest, SessionTerminationAnswer>(Long.valueOf(ApplicationIDs.SD));
			authSession.load(sessionID, sessionSate, otherFields, in);
		}
		else
		{
			ccSession = new ClientCCSessionImpl<CreditControlRequest, CreditControlAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer>(Long.valueOf(ApplicationIDs.SD));
			ccSession.load(sessionID, sessionSate, otherFields, in);
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