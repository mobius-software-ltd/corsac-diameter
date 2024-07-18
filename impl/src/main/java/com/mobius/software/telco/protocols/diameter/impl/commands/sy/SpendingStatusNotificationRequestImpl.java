package com.mobius.software.telco.protocols.diameter.impl.commands.sy;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.sy.SpendingStatusNotificationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.sy.PolicyCounterStatusReport;
import com.mobius.software.telco.protocols.diameter.primitives.sy.SNRequestType;

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
public class SpendingStatusNotificationRequestImpl extends SyRequestImpl implements SpendingStatusNotificationRequest
{
	private List<PolicyCounterStatusReport> policyCounterStatusReport;
	
	private SNRequestType snRequestType;
	
	protected SpendingStatusNotificationRequestImpl() 
	{
		super();
	}
	
	public SpendingStatusNotificationRequestImpl(String originHost,String originRealm,String destinationHost, String destinationRealm, Boolean isRetransmit, String sessionID, Long authApplicationId) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authApplicationId);
	}				
	
	public List<PolicyCounterStatusReport> getPolicyCounterStatusReport()
	{
		return this.policyCounterStatusReport;
	}
	 
	public void setPolicyCounterStatusReport(List<PolicyCounterStatusReport> value)
	{
		this.policyCounterStatusReport = value;
	}
	
	public SNRequestType getSNRequestType()
	{
		return this.snRequestType;
	}
	
	public void setSNRequestType(SNRequestType value)
	{
		this.snRequestType = value;
	}	
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationRealm);
		result.add(destinationHost);
		result.add(authApplicationId);
		result.add(originStateId);
		result.add(ocSupportedFeatures);
		
		if(policyCounterStatusReport!=null)
			result.addAll(policyCounterStatusReport);
		
		result.add(snRequestType);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterUnknownAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}			
}