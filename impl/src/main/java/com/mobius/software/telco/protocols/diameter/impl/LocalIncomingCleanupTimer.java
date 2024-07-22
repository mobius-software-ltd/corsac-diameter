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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mobius.software.common.dal.timers.Timer;
import com.mobius.software.telco.protocols.diameter.DiameterAnswerData;
import com.mobius.software.telco.protocols.diameter.DiameterStack;
/**
*
* @author yulian oifa
*
*/
public class LocalIncomingCleanupTimer implements Timer 
{
	public static Logger logger=LogManager.getLogger(LocalIncomingCleanupTimer.class);
	
	private DiameterStack stack;
	private long startTime;
	private AtomicLong timestamp;
	private ConcurrentHashMap<String,ConcurrentHashMap<Long,DiameterAnswerData>> map;
	
	public LocalIncomingCleanupTimer(DiameterStack stack,ConcurrentHashMap<String,ConcurrentHashMap<Long,DiameterAnswerData>> map)
	{
		this.stack=stack;
		this.startTime=System.currentTimeMillis();
		this.map=map;
		if(stack.getDuplicatesTimeout()!=null && stack.getDuplicatesTimeout()>0 && stack.getDuplicatesCheckPeriod()!=null && stack.getDuplicatesCheckPeriod()>0)
		{
			this.timestamp = new AtomicLong(System.currentTimeMillis() + stack.getDuplicatesCheckPeriod());
			stack.getWorkerPool().getPeriodicQueue().store(this.getRealTimestamp(), this);
		}
	}

	@Override
	public void execute() 
	{
		if(timestamp.get()<Long.MAX_VALUE)
		{			
			Iterator<Entry<String,ConcurrentHashMap<Long,DiameterAnswerData>>> iterator = map.entrySet().iterator();
			while(iterator.hasNext())
			{
				Entry<String,ConcurrentHashMap<Long,DiameterAnswerData>> currHostEntry = iterator.next();
				Iterator<Entry<Long, DiameterAnswerData>> answersIterator = currHostEntry.getValue().entrySet().iterator();
				List<Long> expiredKeys = new ArrayList<Long>();
				while(answersIterator.hasNext())
				{
					Entry<Long, DiameterAnswerData> answerEntry = answersIterator.next();
					if(answerEntry.getValue().getInitialTimestamp()<System.currentTimeMillis()-stack.getDuplicatesTimeout())
						expiredKeys.add(answerEntry.getKey());
				}
				
				for(Long curr:expiredKeys)
					currHostEntry.getValue().remove(curr);
			}
			
			this.timestamp = new AtomicLong(System.currentTimeMillis() + stack.getDuplicatesCheckPeriod());
			stack.getWorkerPool().getPeriodicQueue().store(this.getRealTimestamp(), this);	
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
}