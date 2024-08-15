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

import java.util.concurrent.ConcurrentHashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.restcomm.cluster.ClusteredID;

import com.mobius.software.telco.protocols.diameter.DiameterProvider;
import com.mobius.software.telco.protocols.diameter.DiameterSession;
import com.mobius.software.telco.protocols.diameter.DiameterSessionStorage;
import com.mobius.software.telco.protocols.diameter.DiameterStack;

/**
*
* @author yulian oifa
*
*/
public class LocalDiameterSessionStorageImpl implements DiameterSessionStorage
{
	public static Logger logger=LogManager.getLogger(InactivityTimer.class);
	
	private ConcurrentHashMap<String,DiameterSession> localMap=new ConcurrentHashMap<String,DiameterSession>();
	private ConcurrentHashMap<ClusteredID<?>,IdleCheckTimer> idleMap=new ConcurrentHashMap<ClusteredID<?>,IdleCheckTimer>();
	private ConcurrentHashMap<ClusteredID<?>,SendTimer> sendMap=new ConcurrentHashMap<ClusteredID<?>,SendTimer>();
	
	private DiameterStack stack;
	
	public LocalDiameterSessionStorageImpl(DiameterStack stack)
	{
		this.stack = stack;
	}
	
	@Override
	public void removeSession(String sessionId)
	{
		DiameterSession session = localMap.remove(sessionId);
		
		if(session!=null)
		{
			if(session.getIdleTimerID()!=null)
			{
				IdleCheckTimer idleTimer = idleMap.remove(session.getIdleTimerID());
				if(idleTimer != null)
					idleTimer.stop();
			}
			
			if(session.getSendTimerID()!=null)
			{
				SendTimer sendTimer = sendMap.remove(session.getSendTimerID());
				if(sendTimer != null)
					sendTimer.stop();
			}
		}
	}

	@Override
	public void storeSession(DiameterSession session)
	{
		localMap.put(session.getID(), session);
	}

	@Override
	public DiameterSession getSession(String sessionId, DiameterProvider<?, ?, ?, ?, ?> provider)
	{
		return localMap.get(sessionId);
	}

	@Override
	public void stopIdleTimer(ClusteredID<?> timerID)
	{
		IdleCheckTimer idleTimer = idleMap.remove(timerID);
		if(idleTimer != null)
			idleTimer.stop();
	}

	@Override
	public void startIdleTimer(DiameterSession session, Long idleTime)
	{
		if(session.getIdleTimerID()==null)
			session.setIdleTimerID(stack.getIDGenerator().generateID());
		
		IdleCheckTimer idleTimer = idleMap.get(session.getIdleTimerID());
		if(idleTimer == null)
		{			
			IdleCheckTimer newTimer;
			if(idleTime==null)
				newTimer = new IdleCheckTimer(session, stack.getIdleTimeout());
			else
				newTimer = new IdleCheckTimer(session, idleTime);
			
			idleTimer = idleMap.putIfAbsent(session.getIdleTimerID(), newTimer);
			if(idleTimer==null)
				stack.getPeriodicQueue().store(newTimer.getRealTimestamp(), newTimer);
		}
	}

	@Override
	public void stopSendTimer(ClusteredID<?> timerID)
	{
		SendTimer sendTimer = sendMap.remove(timerID);
		if(sendTimer != null)
			sendTimer.stop();
	}

	@Override
	public void startSendTimer(DiameterSession session)
	{
		if(session.getSendTimerID()==null)
			session.setSendTimerID(stack.getIDGenerator().generateID());
		
		SendTimer sendTimer = sendMap.get(session.getSendTimerID());
		if(sendTimer == null)
		{
			SendTimer newTimer=new SendTimer(session, stack.getResponseTimeout());
			sendTimer = sendMap.putIfAbsent(session.getSendTimerID(), newTimer);
			if(sendTimer==null)
				stack.getPeriodicQueue().store(newTimer.getRealTimestamp(), newTimer);
		}
	}

	@Override
	public void restartIdleTimer(DiameterSession session,Long idleTime)
	{
		if(session.getIdleTimerID()==null)
		{
			startIdleTimer(session, idleTime);
			return;
		}
		
		IdleCheckTimer idleTimer = idleMap.get(session.getIdleTimerID());
		if(idleTimer != null)
		{
			idleTimer.restart(idleTime);
			stack.getPeriodicQueue().store(idleTimer.getRealTimestamp(), idleTimer);
		}
		else
			startIdleTimer(session, idleTime);
	}

	@Override
	public void restartSendTimer(DiameterSession session)
	{
		if(session.getSendTimerID()==null)
		{
			startSendTimer(session);
			return;
		}
		
		SendTimer sendTimer = sendMap.get(session.getSendTimerID());
		if(sendTimer != null)
		{
			sendTimer.restart();
			stack.getPeriodicQueue().store(sendTimer.getRealTimestamp(), sendTimer);
		}
		else
			startSendTimer(session);
	}

	@Override
	public Integer getSessionsCount()
	{
		return localMap.size();
	}
}