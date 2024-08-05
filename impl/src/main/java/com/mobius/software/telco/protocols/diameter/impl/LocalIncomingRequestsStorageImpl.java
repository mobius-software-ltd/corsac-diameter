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

import com.mobius.software.telco.protocols.diameter.DiameterAnswerData;
import com.mobius.software.telco.protocols.diameter.DiameterStack;
import com.mobius.software.telco.protocols.diameter.IncomingRequestsStorage;
import com.mobius.software.telco.protocols.diameter.commands.DiameterAnswer;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class LocalIncomingRequestsStorageImpl implements IncomingRequestsStorage
{
	private ConcurrentHashMap<String,ConcurrentHashMap<Long,DiameterAnswerData>> referencesMap=new ConcurrentHashMap<String,ConcurrentHashMap<Long,DiameterAnswerData>>();
	private LocalIncomingCleanupTimer cleanupTimer;
	private DiameterStack stack;
	
	public LocalIncomingRequestsStorageImpl(DiameterStack stack)
	{
		this.stack = stack;
		this.cleanupTimer = new LocalIncomingCleanupTimer(stack, referencesMap);
	}
	
	public void stop()
	{
		this.cleanupTimer.stop();
	}
	
	@Override
	public DiameterAnswerData incomingMessageReceived(DiameterRequest request)
	{
		if(stack.getDuplicatesTimeout()==null || stack.getDuplicatesTimeout()==0 || stack.getDuplicatesCheckPeriod()==null || stack.getDuplicatesCheckPeriod()==0)
			return null;
		
		ConcurrentHashMap<Long,DiameterAnswerData> hostMap = referencesMap.get(request.getOriginHost());
		if(hostMap==null)
		{
			hostMap = new ConcurrentHashMap<Long,DiameterAnswerData>();
			ConcurrentHashMap<Long,DiameterAnswerData> oldMap = referencesMap.putIfAbsent(request.getOriginHost(), hostMap);
			if(oldMap!=null)
				hostMap = oldMap;
		}
		
		DiameterAnswerData result = hostMap.get(request.getHopByHopIdentifier());
		if(result != null)
			return result;
		
		result = new DiameterAnswerData(System.currentTimeMillis());
		DiameterAnswerData oldResult = hostMap.putIfAbsent(request.getHopByHopIdentifier(), result);
		if(oldResult!=null)
		{
			result = oldResult;
			return result;
		}
		
		return null;
	}

	@Override
	public void answerSent(String originHost, DiameterAnswer answer, ByteBuf buffer)
	{
		ConcurrentHashMap<Long,DiameterAnswerData> hostMap = referencesMap.get(originHost);
		if(hostMap==null)
		{
			hostMap = new ConcurrentHashMap<Long,DiameterAnswerData>();
			ConcurrentHashMap<Long,DiameterAnswerData> oldMap = referencesMap.putIfAbsent(originHost, hostMap);
			if(oldMap!=null)
				hostMap = oldMap;
		}
		
		DiameterAnswerData result = hostMap.get(answer.getHopByHopIdentifier());
		if(result != null)
			result.setBuffer(buffer);
	}

	@Override
	public Integer getRequestsCount()
	{
		Integer result = 0;
		for(ConcurrentHashMap<Long,DiameterAnswerData> currHostData:referencesMap.values())
			result +=currHostData.size();
		
		return result;
	}
}