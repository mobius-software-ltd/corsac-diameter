package com.mobius.software.telco.protocols.diameter.impl.primitives.t6a;
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

import java.util.Date;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.DLBufferingSuggestedPacketCountImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.SubscribedPeriodicRAUTAUTimerImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.DLBufferingSuggestedPacketCount;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EDRXCycleLength;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SubscribedPeriodicRAUTAUTimer;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.ActiveTime;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.IdleStatusIndication;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.IdleStatusTimestamp;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 4322L, vendorId = KnownVendorIDs.TGPP_ID)
public class IdleStatusIndicationImpl extends DiameterGroupedAvpImpl implements IdleStatusIndication
{
	private IdleStatusTimestamp idleStatusTimestamp;
	
	private ActiveTime activeTime;
	
	private SubscribedPeriodicRAUTAUTimer subscribedPeriodicRAUTAUTimer;
	
	private EDRXCycleLength eDRXCycleLength;
	
	private DLBufferingSuggestedPacketCount dlBufferingSuggestedPacketCount;
	
	public IdleStatusIndicationImpl()
	{
		
	}
	
	public Date getIdleStatusTimestamp()
	{
		if(idleStatusTimestamp == null)
			return null;
		
		return idleStatusTimestamp.getDateTime();
	}
	
	public void setIdleStatusTimestamp(Date value)
	{
		if(value==null)
			this.idleStatusTimestamp = null;
		else
			this.idleStatusTimestamp = new IdleStatusTimestampImpl(value, null, null);						
	}
	
	public Long getActiveTime()
	{
		if(activeTime == null)
			return null;
		
		return activeTime.getUnsigned();
	}
	
	public void setActiveTime(Long value)
	{
		if(value==null)
			this.activeTime = null;
		else
			this.activeTime = new ActiveTimeImpl(value, null, null);						
	}
	
	public Long getSubscribedPeriodicRAUTAUTimer()
	{
		if(subscribedPeriodicRAUTAUTimer == null)
			return null;
		
		return subscribedPeriodicRAUTAUTimer.getUnsigned();
	}
	
	public void setSubscribedPeriodicRAUTAUTimer(Long value)
	{
		if(value==null)
			this.subscribedPeriodicRAUTAUTimer = null;
		else
			this.subscribedPeriodicRAUTAUTimer = new SubscribedPeriodicRAUTAUTimerImpl(value, null, null);						
	}
	
	public EDRXCycleLength getEDRXCycleLength()
	{
		return eDRXCycleLength;
	}
	
	public void setEDRXCycleLength(EDRXCycleLength value)
	{
		this.eDRXCycleLength = value;
	}
	
	public Integer getDLBufferingSuggestedPacketCount()
	{
		if(dlBufferingSuggestedPacketCount == null)
			return null;
		
		return dlBufferingSuggestedPacketCount.getInteger();
	}
	
	public void setDLBufferingSuggestedPacketCount(Integer value)
	{
		if(value==null)
			this.dlBufferingSuggestedPacketCount = null;
		else
			this.dlBufferingSuggestedPacketCount = new DLBufferingSuggestedPacketCountImpl(value, null, null);	
	}
}