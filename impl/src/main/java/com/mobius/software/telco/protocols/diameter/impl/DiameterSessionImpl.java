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

import org.restcomm.cluster.ClusteredID;

import com.mobius.software.telco.protocols.diameter.AsyncCallback;
import com.mobius.software.telco.protocols.diameter.DiameterProvider;
import com.mobius.software.telco.protocols.diameter.DiameterSession;
import com.mobius.software.telco.protocols.diameter.SessionListener;
import com.mobius.software.telco.protocols.diameter.app.SessionStateEnum;
import com.mobius.software.telco.protocols.diameter.commands.DiameterAnswer;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;

/**
*
* @author yulian oifa
*
*/
public abstract class DiameterSessionImpl implements DiameterSession
{
	private DiameterProvider<?, ?, ?, ?, ?> provider;
	private String sessionID;
	private ClusteredID<?> idleTimerID;
	private ClusteredID<?> sendTimerID;
	private SessionStateEnum state;
	private String remoteHost,remoteRealm;
	private DiameterRequest lastSentRequest;
	
	public DiameterSessionImpl(String sessionID, String remoteHost, String remoteRealm, DiameterProvider<?, ?, ?, ?, ?> provider)
	{
		this.sessionID = sessionID;
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
		this.provider.getStack().getSessionStorage().storeSession(this);
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
	public void terminate()
	{
		stopIdleTimer();
		stopSendTimer();
		this.provider.getStack().getSessionStorage().removeSession(this.sessionID);
	}

	@Override
	public SessionStateEnum getSessionState()
	{
		return this.state;
	}
	
	protected void setSessionState(SessionStateEnum state)
	{
		this.state = state;
	}

	public String getRemoteHost()
	{
		return remoteHost;
	}

	public void setRemoteHost(String remoteHost)
	{
		this.remoteHost = remoteHost;
	}

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
		
		terminate();
	}
	
	protected DiameterRequest getLastSendRequest()
	{
		return this.lastSentRequest;
	}
	
	public void setLastSentRequest(DiameterRequest request)
	{
		this.lastSentRequest = request;
	}
}