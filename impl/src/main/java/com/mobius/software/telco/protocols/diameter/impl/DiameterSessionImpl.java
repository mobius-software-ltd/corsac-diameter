package com.mobius.software.telco.protocols.diameter.impl;
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
import java.util.Iterator;
import java.util.Map.Entry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.restcomm.cluster.ClusteredID;

import com.mobius.software.telco.protocols.diameter.ApplicationID;
import com.mobius.software.telco.protocols.diameter.AsyncCallback;
import com.mobius.software.telco.protocols.diameter.DiameterProvider;
import com.mobius.software.telco.protocols.diameter.DiameterSession;
import com.mobius.software.telco.protocols.diameter.ResultCodes;
import com.mobius.software.telco.protocols.diameter.SessionListener;
import com.mobius.software.telco.protocols.diameter.app.SessionStateEnum;
import com.mobius.software.telco.protocols.diameter.commands.DiameterAnswer;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;

/**
*
* @author yulian oifa
*
*/
public abstract class DiameterSessionImpl implements DiameterSession
{
	public static Logger logger=LogManager.getLogger(DiameterLinkImpl.class);
	
	private DiameterProvider<?, ?, ?, ?, ?> provider;
	private String sessionID;
	private Long applicationID;
	private ClusteredID<?> idleTimerID;
	private ClusteredID<?> sendTimerID;
	private SessionStateEnum state;
	private String remoteHost,remoteRealm;
	private DiameterRequest lastSentRequest;
	
	private Boolean isRetry = false;
	
	//for serialization
	public DiameterSessionImpl(Long applicationID)
	{
		this.applicationID = applicationID;
	}
	
	public DiameterSessionImpl(String sessionID, Long applicationID, String remoteHost, String remoteRealm, DiameterProvider<?, ?, ?, ?, ?> provider)
	{
		this.sessionID = sessionID;
		this.applicationID = applicationID;
		this.remoteHost = remoteHost;
		this.remoteRealm = remoteRealm;
		this.provider = provider;
	}
	
	@Override
	public ClusteredID<?> getIdleTimerID()
	{
		return idleTimerID;
	}
	
	@Override
	public ClusteredID<?> getSendTimerID()
	{
		return sendTimerID;
	}
	
	@Override
	public void setIdleTimerID(ClusteredID<?> id)
	{
		this.idleTimerID = id;
	}
	
	@Override
	public void setSendTimerID(ClusteredID<?> id)
	{
		this.sendTimerID = id;
	}
	
	@Override
	public String getID()
	{
		return this.sessionID;
	}
	
	
	@Override
	public Long getApplicationID()
	{
		return applicationID;
	}
	
	@Override
	public void requestReceived(DiameterRequest request, AsyncCallback callback)
	{
		restartIdleTimer(null);
		this.provider.getStack().getSessionStorage().storeSession(this);
	}
	
	@Override
	public void answerReceived(DiameterAnswer answer, AsyncCallback callback, Long idleTime,Boolean stopSendTimer)
	{
		restartIdleTimer(idleTime);
		
		if(stopSendTimer!=null && stopSendTimer)
			stopSendTimer();
		
		this.provider.getStack().getSessionStorage().storeSession(this);
	}
	
	@Override
	public void requestSent(DiameterRequest request, AsyncCallback callback)
	{
		restartIdleTimer(null);
		restartSendTimer();
		if(!this.provider.getStack().getSessionStorage().storeSession(this))
		{
			if(this.getApplicationID()!=null)
			{
				ApplicationID applicationID = ApplicationID.fromInt(this.getApplicationID().intValue());
				if(applicationID!=null)
					provider.getStack().newOutgoingSession(applicationID);
			}
		}			
	}
	
	@Override
	public void answerSent(DiameterAnswer answer, AsyncCallback callback, Long idleTime)
	{
		restartIdleTimer(idleTime);
		this.provider.getStack().getSessionStorage().storeSession(this);
	}
	
	protected void restartIdleTimer(Long time)
	{
		this.provider.getStack().getSessionStorage().restartIdleTimer(this, time);
	}
	
	protected void stopIdleTimer()
	{
		if(idleTimerID!=null)
			this.provider.getStack().getSessionStorage().stopIdleTimer(idleTimerID);
	}
	
	protected void startIdleTimer()
	{
		this.provider.getStack().getSessionStorage().startIdleTimer(this, null);
	}
	
	protected void restartSendTimer()
	{
		this.provider.getStack().getSessionStorage().restartSendTimer(this);
	}
	
	protected void startSendTimer()
	{
		this.provider.getStack().getSessionStorage().startSendTimer(this);
	}
	
	protected void stopSendTimer()
	{
		if(sendTimerID!=null)
			this.provider.getStack().getSessionStorage().stopSendTimer(sendTimerID);
	}
	
	@Override
	public void terminate(Long resultCode)
	{
		stopIdleTimer();
		stopSendTimer();
		if(this.provider.getStack().getSessionStorage().removeSession(this.sessionID))
		{
			if(this.getApplicationID()!=null)
			{
				ApplicationID applicationID = ApplicationID.fromInt(this.getApplicationID().intValue());
				if(applicationID!=null)
					this.provider.getStack().sessionEnded(resultCode, applicationID);
			}
		}
	}

	@Override
	public SessionStateEnum getSessionState()
	{
		return this.state;
	}
	
	@Override
	public void setSessionState(SessionStateEnum state)
	{
		this.state = state;
	}

	@Override
	public String getRemoteHost()
	{
		return remoteHost;
	}

	public void setRemoteHost(String remoteHost)
	{
		this.remoteHost = remoteHost;
	}

	@Override
	public String getRemoteRealm()
	{
		return remoteRealm;
	}

	public void setRemoteRealm(String remoteRealm)
	{
		this.remoteRealm = remoteRealm;
	}

	@Override
	public void onTimeout()
	{
		Iterator<?> iterator = null;
		if(isServer())
		{
			if(provider.getServerListeners()!=null)
				iterator = provider.getServerListeners().entrySet().iterator();
		}
		else
		{
			if(provider.getClientListeners()!=null)
				iterator = provider.getClientListeners().entrySet().iterator();
		}
		
		if(iterator!=null)
		{
			while(iterator.hasNext())
			{
				Entry<?,?> currEntry = (Entry<?,?>)iterator.next();
				((SessionListener)currEntry.getValue()).onTimeout();			
			}
		}
		
		this.provider.getStack().getSessionStorage().storeSession(this);
	}

	@Override
	public void onIdleTimeout()
	{
		Iterator<?> iterator = null;			
		if(isServer())
		{
			if(provider.getServerListeners()!=null)
				iterator = provider.getServerListeners().entrySet().iterator();
		}
		else
		{
			if(provider.getClientListeners()!=null)
				iterator = provider.getClientListeners().entrySet().iterator();
		}
		
		if(iterator!=null)
		{
			while(iterator.hasNext())
			{
				Entry<?,?> currEntry = (Entry<?,?>)iterator.next();
				((SessionListener)currEntry.getValue()).onIdleTimeout();			
			}				
		}
		
		terminate(ResultCodes.DIAMETER_SESSION_TIMEOUT);
	}
	
	@Override
	public DiameterRequest getLastSendRequest()
	{
		return this.lastSentRequest;
	}
	
	@Override
	public void setLastSentRequest(DiameterRequest request)
	{
		//if we will not generate the identifiers here, we may have invalid identifiers stored
		if(request.getHopByHopIdentifier()==null)
		{
			Long hopIdentifier = provider.getStack().getNextHopByHopIdentifier();
			request.setHopByHopIdentifier(hopIdentifier);			
		}
		
		if(request.getEndToEndIdentifier()==null)
			request.setEndToEndIdentifier(request.getHopByHopIdentifier());
		
		this.lastSentRequest = request;
	}
	
	protected void validateAnswer(DiameterAnswer answer) throws DiameterException
	{
		if(lastSentRequest==null)
		{
			logger.warn("Received answer, however original request not found");
			throw new DiameterException("Request has not been found for this answer", null, ResultCodes.DIAMETER_UNABLE_TO_COMPLY, null);
		}
		
		if(!lastSentRequest.getEndToEndIdentifier().equals(answer.getEndToEndIdentifier()))
		{
			logger.warn("Received answer, however with unexpected end to end identifier");
			throw new DiameterException("Unexpected end to end identifier", null, ResultCodes.DIAMETER_UNABLE_TO_COMPLY, null);
		}
		
		if(!lastSentRequest.getHopByHopIdentifier().equals(answer.getHopByHopIdentifier()))
		{
			logger.warn("Received answer, however with unexpected hpp by hop identifier");
			throw new DiameterException("Unexpected hop to hop identifier", null, ResultCodes.DIAMETER_UNABLE_TO_COMPLY, null);		
		}
	}
	
	@Override
	public Boolean isRetry()
	{
		return this.isRetry;
	}
	
	@Override
	public void setIsRetry(Boolean isRetry)
	{
		this.isRetry = isRetry;
	}
	
	@Override
	public DiameterProvider<?, ?, ?, ?, ?> getProvider()
	{
		return provider;
	}
	
	@Override
	public void load(String sessionID, SessionStateEnum sessionSate, byte otherFields)
	{
		this.sessionID = sessionID;
		this.state = sessionSate;
	}
	
	@Override
	public void setProvider(DiameterProvider<?, ?, ?, ?, ?> provider)
	{
		this.provider = provider;
	}
	
	@Override
	public byte getOtherFieldsByte()
	{
		byte otherFields = 0;
		if(getRemoteHost()!=null)
			otherFields += 1;
		
		if(getRemoteRealm()!=null)
			otherFields += 2;
		
		if(getIdleTimerID()!=null)
			otherFields += 4;
		
		if(getSendTimerID()!=null)
			otherFields += 8;
		
		if(getLastSendRequest()!=null)
			otherFields += 16;
		
		if(isRetry())
			otherFields += 32;
		
		return otherFields;
	}
}