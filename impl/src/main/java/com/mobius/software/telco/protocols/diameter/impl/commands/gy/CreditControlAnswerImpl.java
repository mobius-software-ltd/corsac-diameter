package com.mobius.software.telco.protocols.diameter.impl.commands.gy;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.gy.CreditControlAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.RouteRecordImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcSessionFailoverImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CreditControlFailureHandlingImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.RouteRecord;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcSessionFailover;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcSessionFailoverEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CreditControlFailureHandling;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CreditControlFailureHandlingEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gy.ServiceInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gy.TGPPMultipleServicesCreditControl;

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

public class CreditControlAnswerImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.CreditControlAnswerImpl implements CreditControlAnswer
{
	public CcSessionFailover ccSessionFailover;
	
	public List<TGPPMultipleServicesCreditControl> tgppMultipleServicesCreditControl;
	
	public CreditControlFailureHandling creditControlFailureHandling;
	
	protected List<RouteRecord> routeRecords;
	
	public ServiceInformation serviceInformation;
	
	protected CreditControlAnswerImpl() 
	{
		super();
	}
	
	public CreditControlAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, Long authApplicationId ,CcRequestTypeEnum ccRequestType, Long ccRequestNumber) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authApplicationId, ccRequestType, ccRequestNumber);
	}
	
	@Override
	public CcSessionFailoverEnum getCcSessionFailover() 
	{
		if(ccSessionFailover==null)
			return null;
		
		return ccSessionFailover.getEnumerated(CcSessionFailoverEnum.class);
	}

	@Override
	public void setCcSessionFailover(CcSessionFailoverEnum value) 
	{
		if(value==null)
			this.ccSessionFailover = null;
		else
			this.ccSessionFailover = new CcSessionFailoverImpl(value, null, null);
	}
	
	@Override
	public List<TGPPMultipleServicesCreditControl> getTGPPMultipleServicesCreditControl()
	{
		return tgppMultipleServicesCreditControl;
	}
	
	@Override
	public void setTGPPMultipleServicesCreditControl(List<TGPPMultipleServicesCreditControl> value)
	{
		this.tgppMultipleServicesCreditControl = value;
	}
	
	@Override
	public CreditControlFailureHandlingEnum getCreditControlFailureHandling() 
	{
		if(creditControlFailureHandling==null)
			return null;
		
		return creditControlFailureHandling.getEnumerated(CreditControlFailureHandlingEnum.class);
	}

	@Override
	public void setCreditControlFailureHandling(CreditControlFailureHandlingEnum value) 
	{
		if(value==null)
			this.creditControlFailureHandling = null;
		else
			this.creditControlFailureHandling = new CreditControlFailureHandlingImpl(value, null, null);
	}
	
	@Override
	public List<String> getRouteRecords()
	{
		if(this.routeRecords==null)
			return null;
		else
		{
			List<String> result = new ArrayList<String>();
			for(RouteRecord curr:routeRecords)
				result.add(curr.getIdentity());
			
			return result;
		}
	}

	@Override
	public void setRouteRecords(List<String> value)
	{
		if(value == null || value.size()==0)
			this.routeRecords = null;
		else
		{
			this.routeRecords = new ArrayList<RouteRecord>();
			for(String curr:value)
				this.routeRecords.add(new RouteRecordImpl(curr, null, null));
		}
	}		
	
	@Override
	public ServiceInformation getServiceInformation() 
	{
		return serviceInformation;
	}

	@Override
	public void setServiceInformation(ServiceInformation value) 
	{
		this.serviceInformation = value;
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(resultCode);
		result.add(originHost);
		result.add(originRealm);
		result.add(authApplicationId);
		result.add(ccRequestType);
		result.add(ccRequestNumber);
		result.add(ccSessionFailover);
		
		if(tgppMultipleServicesCreditControl!=null)
			result.addAll(tgppMultipleServicesCreditControl);
		
		result.add(creditControlFailureHandling);
		
		if(redirectHost!=null)
			result.addAll(redirectHost);
		
		result.add(redirectHostUsage);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);
		result.add(serviceInformation);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterUnknownAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}
		    
	

}
	
