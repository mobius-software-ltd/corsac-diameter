package com.mobius.software.telco.protocols.diameter.impl.primitives.s6t;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.DLBufferingSuggestedPacketCountImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.DLBufferingSuggestedPacketCount;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MaximumLatency;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MaximumResponseTime;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.ReachabilityType;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.UEReachabilityConfiguration;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3129L, vendorId = KnownVendorIDs.TGPP_ID)
public class UEReachabilityConfigurationImpl extends DiameterGroupedAvpImpl implements UEReachabilityConfiguration
{
	private ReachabilityType reachabilityType;
	
	private MaximumLatency maximumLatency;
	
	private MaximumResponseTime maximumResponseTime;
	
	private DLBufferingSuggestedPacketCount dlBufferingSuggestedPacketCount;
	
	public UEReachabilityConfigurationImpl()
	{
		
	}
	
	public ReachabilityType getReachabilityType()
	{
		return reachabilityType;
	}
	
	public void setReachabilityType(ReachabilityType value)
	{
		this.reachabilityType = value;
	}
	
	public Long getMaximumLatency()
	{
		if(maximumLatency == null)
			return null;
		
		return maximumLatency.getUnsigned();
	}
	
	public void setMaximumLatency(Long value)
	{
		if(value == null)
			this.maximumLatency = null;
		else
			this.maximumLatency = new MaximumLatencyImpl(value, null, null);
	}
	
	public Long getMaximumResponseTime()
	{
		if(maximumResponseTime == null)
			return null;
		
		return maximumResponseTime.getUnsigned();
	}
	
	public void setMaximumResponseTime(Long value)
	{
		if(value == null)
			this.maximumResponseTime = null;
		else
			this.maximumResponseTime = new MaximumResponseTimeImpl(value, null, null);
	}
	
	public Integer getDLBufferingSuggestedPacketCount()
	{
		if(dlBufferingSuggestedPacketCount == null)
			return null;
		
		return dlBufferingSuggestedPacketCount.getInteger();
	}
	
	public void setDLBufferingSuggestedPacketCount(Integer value)
	{
		if(value == null)
			this.dlBufferingSuggestedPacketCount = null;
		else
			this.dlBufferingSuggestedPacketCount = new DLBufferingSuggestedPacketCountImpl(value, null, null);
	}
}