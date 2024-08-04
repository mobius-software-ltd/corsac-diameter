package com.mobius.software.telco.protocols.diameter.impl.app.rfc5778a;
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
import com.mobius.software.telco.protocols.diameter.app.rfc5778a.Rfc5778aServerSession;
import com.mobius.software.telco.protocols.diameter.app.rfc5778a.ServerListener;
import com.mobius.software.telco.protocols.diameter.commands.DiameterAnswer;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778a.MIP6Answer;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778a.MIP6Request;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778a.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778a.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778a.AccountingAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778a.AccountingRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778a.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778a.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778a.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778a.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.impl.app.ServerAccSessionImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.ServerAuthSessionImpl;

public class Rfc5778aServerSessionImpl implements Rfc5778aServerSession
{
	private ServerAccSessionImpl<AccountingRequest, AccountingAnswer> accSession=null;
	private ServerAuthSessionImpl<MIP6Request, MIP6Answer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer> authSession=null;
	
	public Rfc5778aServerSessionImpl(Boolean isAuth, String sessionID, String remoteHost, String remoteRealm, DiameterProvider<?, ? extends ServerListener, ?, ?, ?> provider)
	{
		if(isAuth==null || isAuth)
			authSession = new ServerAuthSessionImpl<MIP6Request, MIP6Answer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer>(sessionID, Long.valueOf(ApplicationIDs.MIP6A), remoteHost, remoteRealm, provider);
		else
			accSession = new ServerAccSessionImpl<AccountingRequest, AccountingAnswer>(sessionID, Long.valueOf(ApplicationIDs.MIP6A), remoteHost, remoteRealm, provider);
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
	public void sendInitialAnswer(MIP6Answer answer, AsyncCallback callback)
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
}