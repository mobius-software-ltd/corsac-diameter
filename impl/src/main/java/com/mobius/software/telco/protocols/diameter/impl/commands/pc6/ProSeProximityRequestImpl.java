package com.mobius.software.telco.protocols.diameter.impl.commands.pc6;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.pc6.ProSeProximityRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.LocationEstimateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.PRRFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.RequestingEPUIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.TargetedEPUIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.TimeWindowImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LocationEstimate;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.LocationUpdateTrigger;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.PRRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.RequestingEPUID;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.TargetedEPUID;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.TimeWindow;

import io.netty.buffer.ByteBuf;

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
@DiameterCommandImplementation(applicationId = 16777340, commandCode = 8388672, request = true)
public class ProSeProximityRequestImpl extends Pc6RequestImpl implements ProSeProximityRequest
{
	private PRRFlags prrFlags;
	
	private RequestingEPUID requestingEPUID;
	
	private TargetedEPUID targetedEPUID;
	
	private TimeWindow timeWindow;
	
	private LocationEstimate locationEstimate;
	
	private LocationUpdateTrigger locationUpdateTrigger;
	
	
	protected ProSeProximityRequestImpl() 
	{
		super();
	}
	
	public ProSeProximityRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID,AuthSessionStateEnum authSessionState,Long prrFlags,String requestingEPUID,String targetedEPUID,Long timeWindow,ByteBuf locationEstimate)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);
		
		setPRRFlags(prrFlags);
		
		setRequestingEPUID(requestingEPUID);

		setTargetedEPUID(targetedEPUID);
		
		setTimeWindow(timeWindow);
		
		setLocationEstimate(locationEstimate);
	}
	
	@Override	
	public Long getPRRFlags()
	{
		if(prrFlags == null)
			return null;
		
		return prrFlags.getUnsigned();
	}
	
	@Override	
	public void setPRRFlags(Long value)
	{
		if(value == null)
			throw new IllegalArgumentException("PRR-Flags is required");
		
		this.prrFlags = new PRRFlagsImpl(value, null, null);
	}
	
	@Override	
	public String getRequestingEPUID()
	{
		if(requestingEPUID == null)
			return null;
		
		return requestingEPUID.getString();
	}
	
	@Override	
	public void setRequestingEPUID(String value)
	{
		if(value == null)
			throw new IllegalArgumentException("Requesting-EPUID is required");
		
		this.requestingEPUID = new RequestingEPUIDImpl(value, null, null);
	}
	
	@Override	
	public String getTargetedEPUID()
	{
		if(targetedEPUID == null)
			return null;
		
		return targetedEPUID.getString();
	}
	
	@Override	
	public void setTargetedEPUID(String value)
	{
		if(value == null)
			throw new IllegalArgumentException("Targeted-EPUID is required");
		
		this.targetedEPUID = new TargetedEPUIDImpl(value, null, null);
	}
	
	@Override	
	public Long getTimeWindow()
	{
		if(timeWindow == null)
			return null;
		
		return timeWindow.getUnsigned();
	}
	
	@Override	
	public void setTimeWindow(Long value)
	{
		if(value == null)
			throw new IllegalArgumentException("Time-Window is required");
		
		this.timeWindow = new TimeWindowImpl(value, null, null);
	}
		
	@Override	
	public ByteBuf getLocationEstimate()
	{
		if(locationEstimate == null)
			return null;
		
		return locationEstimate.getValue();
	}
	
	@Override	
	public void setLocationEstimate(ByteBuf value)
	{
		if(value == null)
			throw new IllegalArgumentException("Location-Estimate is required");
		
		this.locationEstimate = new LocationEstimateImpl(value, null, null);
	}
	
	@Override	
	public LocationUpdateTrigger getLocationUpdateTrigger()
	{
		return this.locationUpdateTrigger;
	}
	
	@Override	
	public void setLocationUpdateTrigger(LocationUpdateTrigger value)
	{
		this.locationUpdateTrigger = value;
	}
		
	@DiameterValidate
	public String validate()
	{
		if(prrFlags == null)
			return "PRR-Flags is required";
		
		if(requestingEPUID == null)
			return "Requesting-EPUID is required";
		
		if(targetedEPUID == null)
			return "Targeted-EPUID is required";
		
		if(timeWindow == null)
			return "Time-Window is required";
		
		if(locationEstimate == null)
			return "Location-Estimate is required";
		
		return super.validate();
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
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		result.add(ocSupportedFeatures);
		result.add(prrFlags);
		result.add(requestingEPUID);
		result.add(targetedEPUID);
		result.add(timeWindow);
		result.add(locationEstimate);
		result.add(locationUpdateTrigger);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);				
		
		return result;
	}
}