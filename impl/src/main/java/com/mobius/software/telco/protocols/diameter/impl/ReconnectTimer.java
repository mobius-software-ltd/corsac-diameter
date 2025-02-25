package com.mobius.software.telco.protocols.diameter.impl;
/*
 * Mobius Software LTD
 * Copyright 2019 - 2023, Mobius Software LTD and individual contributors
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
import java.util.concurrent.atomic.AtomicLong;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mobius.software.common.dal.timers.Timer;
import com.mobius.software.telco.protocols.diameter.AsyncCallback;
import com.mobius.software.telco.protocols.diameter.DiameterLink;
/**
*
* @author yulian oifa
*
*/
public class ReconnectTimer implements Timer 
{
	public static Logger logger=LogManager.getLogger(ReconnectTimer.class);
	
	private long startTime;
	private AtomicLong timestamp = new AtomicLong(0L);
	private DiameterLink link;
	private AsyncCallback callback;
	
	public ReconnectTimer(DiameterLink link)
	{
		this.startTime=System.currentTimeMillis();		
		this.link=link;
	}

	@Override
	public void execute() 
	{
		if(timestamp.get()<Long.MAX_VALUE)
		{		
			AsyncCallback callback = this.callback;
			
			switch(link.getPeerState())
			{
				case IDLE:
				case CER_SENT:
					if(link.isStarted())
						link.sendCER();	
					else
						link.resetReconnectTimer();
					break;
				default:
					break;
			}
			
			if(callback!=null)
				callback.onSuccess();
		}						
	}

	@Override
	public long getStartTime() 
	{
		return startTime;
	}

	@Override
	public Long getRealTimestamp() 
	{
		return timestamp.get();
	}

	@Override
	public void stop() 
	{
		timestamp.set(Long.MAX_VALUE);
	}
	
	public void startTimer(Long newTimeout,AsyncCallback callback)
	{
		this.startTime = System.currentTimeMillis();
		this.timestamp.set(startTime + newTimeout);
		this.callback = callback;
	}
}