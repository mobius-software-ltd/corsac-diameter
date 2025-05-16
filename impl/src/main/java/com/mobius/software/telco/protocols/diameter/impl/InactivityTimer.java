package com.mobius.software.telco.protocols.diameter.impl;
import java.util.concurrent.atomic.AtomicBoolean;
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
import com.mobius.software.telco.protocols.diameter.DiameterLink;
import com.mobius.software.telco.protocols.diameter.PeerStateEnum;
/**
*
* @author yulian oifa
*
*/
public class InactivityTimer implements Timer 
{
	public static Logger logger=LogManager.getLogger(InactivityTimer.class);
	
	private long startTime;
	private AtomicLong timestamp=new AtomicLong();
	private AtomicLong lastActivity;
	private AtomicBoolean waitingForDWA;
	private DiameterLink link;
	private Long lastDWRSent=0L;
	private Long inactivityTimeout;
	private Long responseTimeout;
	
	public InactivityTimer(DiameterLink link, AtomicLong lastActivity, AtomicBoolean waitingForDWA, Long inactivityTimeout, Long responseTimeout)
	{
		this.startTime=System.currentTimeMillis();	
		this.timestamp.set(System.currentTimeMillis() + responseTimeout);
		this.link=link;	
		this.lastActivity = lastActivity;
		this.waitingForDWA = waitingForDWA;
		this.inactivityTimeout=inactivityTimeout;
		this.responseTimeout=responseTimeout+10;
	}

	@Override
	public void execute() 
	{
		if(timestamp.get()<Long.MAX_VALUE)
		{			
			if(waitingForDWA.get() && this.lastDWRSent<(System.currentTimeMillis()-responseTimeout))
			{
				link.setPeerState(PeerStateEnum.IDLE);
				link.sendCER();
			}
			
			switch(link.getPeerState())
			{
				case OPEN:
					if(this.lastActivity.get()<=(System.currentTimeMillis()-inactivityTimeout))
					{				
						this.lastDWRSent = System.currentTimeMillis();
						this.lastActivity.set(System.currentTimeMillis());
						link.sendDWR();
						logger.debug("Sending DWR for link " +  link.getID() + " At " + System.currentTimeMillis());
					}
					break;
				default:
					break;				
			}
			
			// resetTimer();
			link.resetInactivityTimer();
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

	public void resetTimer()
	{		
		logger.debug("Reseting inactivity timer for link " +  link.getID() + " To " + (System.currentTimeMillis() + responseTimeout));
		this.timestamp.set(System.currentTimeMillis() + responseTimeout);		
	}
	
	@Override
	public void stop() 
	{
		timestamp.set(Long.MAX_VALUE);
	}
}