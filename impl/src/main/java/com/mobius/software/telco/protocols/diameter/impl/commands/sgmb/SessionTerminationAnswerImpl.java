package com.mobius.software.telco.protocols.diameter.impl.commands.sgmb;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.sgmb.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sgmb.RestartCounterImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.sgmb.RestartCounter;

/*
 * Mobius Software LTD, Open Source Cloud Communications
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

/**
*
* @author yulian oifa
*
*/
@DiameterCommandImplementation(applicationId = 16777292, commandCode = 275, request = false)
public class SessionTerminationAnswerImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.SessionTerminationAnswerImpl implements SessionTerminationAnswer
{
	private RestartCounter restartCounter;
	
	protected SessionTerminationAnswerImpl() 
	{
	}
	
	public SessionTerminationAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID);
	}
	
	@Override
	public Long getRestartCounter()
	{
		if(restartCounter==null)
			return null;
		
		return restartCounter.getUnsigned();
	}
	
	@Override
	public void setRestartCounter(Long value)
	{
		if(value==null)
			this.restartCounter = null;
		else
			this.restartCounter = new RestartCounterImpl(value, null, null);
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(resultCode);
		result.add(originHost);
		result.add(originRealm);
		
		if(diameterClass!=null)
			result.addAll(diameterClass);
		
		result.add(errorMessage);
		result.add(errorReportingHost);
		result.add(failedAvp);
		result.add(originStateId);
		
		if(redirectHost!=null)
			result.addAll(redirectHost);
		
		result.add(redirectHostUsage);
		result.add(redirectMaxCacheTime);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		result.add(restartCounter);
		
		return result;
	}
}