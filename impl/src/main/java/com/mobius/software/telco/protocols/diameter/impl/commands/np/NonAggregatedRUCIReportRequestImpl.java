package com.mobius.software.telco.protocols.diameter.impl.commands.np;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.np.NonAggregatedRUCIReportRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.CalledStationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.np.CongestionLevelSetIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.np.CongestionLevelValueImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.np.RCAFIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.nas.CalledStationId;
import com.mobius.software.telco.protocols.diameter.primitives.np.CongestionLevelSetId;
import com.mobius.software.telco.protocols.diameter.primitives.np.CongestionLevelValue;
import com.mobius.software.telco.protocols.diameter.primitives.np.CongestionLocationId;
import com.mobius.software.telco.protocols.diameter.primitives.np.RCAFId;

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
@DiameterCommandImplementation(applicationId = 16777342, commandCode = 8388720, request = true)
public class NonAggregatedRUCIReportRequestImpl extends NpRequestImpl implements NonAggregatedRUCIReportRequest
{
	private SubscriptionId subscriptionId;
	
	private CalledStationId calledStationId;
	
	private CongestionLevelValue congestionLevelValue;
	
	private CongestionLevelSetId congestionLevelSetId;
	
	private CongestionLocationId congestionLocationId;
	
	private RCAFId rcafId;
	
	protected List<SupportedFeatures> supportedFeatures;
	
	protected NonAggregatedRUCIReportRequestImpl() 
	{
		super();
	}
	
	public NonAggregatedRUCIReportRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID,AuthSessionStateEnum authSessionState)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);		
	}
	
	@Override	
	public SubscriptionId getSubscriptionId()
	{
		return this.subscriptionId;
	}
	
	@Override	
	public void setSubscriptionId(SubscriptionId value)
	{
		this.subscriptionId = value;
	}
	
	@Override	
	public String getCalledStationId()
	{
		if(calledStationId == null)
			return null;
		
		return calledStationId.getString();
	}
	
	@Override	
	public void setCalledStationId(String value)
	{
		if(value == null)
			this.calledStationId = null;
		else
			this.calledStationId = new CalledStationIdImpl(value, null, null);
	}
	
	@Override	
	public Long getCongestionLevelValue()
	{
		if(congestionLevelValue == null)
			return null;
		
		return congestionLevelValue.getUnsigned();
	}
	
	@Override	
	public void setCongestionLevelValue(Long value)
	{
		if(value==null)
			this.congestionLevelValue = null;
		else
			this.congestionLevelValue = new CongestionLevelValueImpl(value, null, null);
	}
	
	@Override	
	public Long getCongestionLevelSetId()
	{
		if(congestionLevelSetId == null)
			return null;
		
		return congestionLevelSetId.getUnsigned();
	}
	
	@Override	
	public void setCongestionLevelSetId(Long value)
	{
		if(value==null)
			this.congestionLevelSetId = null;
		else
			this.congestionLevelSetId = new CongestionLevelSetIdImpl(value, null, null);
	}
	
	@Override	
	public CongestionLocationId getCongestionLocationId()
	{
		return this.congestionLocationId;
	}
	
	@Override	
	public void setCongestionLocationId(CongestionLocationId value)
	{
		this.congestionLocationId = value;
	}
	
	@Override	
	public String getRCAFId()
	{
		if(rcafId == null)
			return null;
		
		return rcafId.getIdentity();
	}
	
	@Override	
	public void setRCAFId(String value)
	{
		if(value==null)
			this.rcafId = null;
		else
			this.rcafId = new RCAFIdImpl(value, null, null);
	}

	@Override
	public List<SupportedFeatures> getSupportedFeatures() 
	{
		return supportedFeatures;
	}

	@Override
	public void setSupportedFeatures(List<SupportedFeatures> value) 
	{
		this.supportedFeatures = value;
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(vendorSpecificApplicationId);
		result.add(authSessionState);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationHost);
		result.add(destinationRealm);
		result.add(originStateId);
		result.add(subscriptionId);
		result.add(calledStationId);
		result.add(congestionLevelValue);
		result.add(congestionLevelSetId);
		result.add(congestionLocationId);
		result.add(ocSupportedFeatures);
		result.add(rcafId);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);				
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}
}