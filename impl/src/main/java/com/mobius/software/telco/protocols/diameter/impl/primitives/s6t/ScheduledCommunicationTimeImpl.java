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
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5777.TimeOfDayEndImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5777.TimeOfDayStartImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.DayOfWeekMask;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.TimeOfDayEnd;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.TimeOfDayStart;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.ScheduledCommunicationTime;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3118L, vendorId = KnownVendorIDs.TGPP_ID)
public class ScheduledCommunicationTimeImpl extends DiameterGroupedAvpImpl implements ScheduledCommunicationTime
{
	private DayOfWeekMask dayOfWeekMask;
	
	private TimeOfDayStart timeOfDayStart;
	
	private TimeOfDayEnd timeOfDayEnd;
	
	public ScheduledCommunicationTimeImpl()
	{
		
	}
	
	public DayOfWeekMask getDayOfWeekMask()
	{
		return dayOfWeekMask;
	}
	
	public void setDayOfWeekMask(DayOfWeekMask value)
	{
		this.dayOfWeekMask = value;
	}
	
	public Long getTimeOfDayStart()
	{
		if(timeOfDayStart == null)
			return null;
		
		return timeOfDayStart.getUnsigned();
	}
	
	public void setTimeOfDayStart(Long value)
	{
		if(value==null)
			this.timeOfDayStart = null;
		else
			this.timeOfDayStart = new TimeOfDayStartImpl(value, null, null);
	}
	
	public Long getTimeOfDayEnd()
	{
		if(timeOfDayEnd == null)
			return null;
		
		return timeOfDayEnd.getUnsigned();
	}
	
	public void setTimeOfDayEnd(Long value)
	{
		if(value==null)
			this.timeOfDayEnd = null;
		else
			this.timeOfDayEnd = new TimeOfDayEndImpl(value, null, null);
	}
}