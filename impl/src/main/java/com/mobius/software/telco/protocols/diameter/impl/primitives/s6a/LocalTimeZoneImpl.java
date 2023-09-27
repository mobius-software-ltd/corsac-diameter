package com.mobius.software.telco.protocols.diameter.impl.primitives.s6a;
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
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.DaylightSavingTime;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.DaylightSavingTimeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.LocalTimeZone;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TimeZone;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1649L, vendorId = KnownVendorIDs.TGPP_ID)
public class LocalTimeZoneImpl extends DiameterGroupedAvpImpl implements LocalTimeZone
{
	private TimeZone timeZone;
	
	private DaylightSavingTime daylightSavingTime;
	
	protected LocalTimeZoneImpl()
	{
		
	}
	
	public LocalTimeZoneImpl(String timeZone,DaylightSavingTimeEnum daylightSavingTime)
	{
		if(timeZone==null)
			throw new IllegalArgumentException("Time-Zone is required");
		
		if(daylightSavingTime==null)
			throw new IllegalArgumentException("Daylight-Saving-Time is required");
		
		this.timeZone = new TimeZoneImpl(timeZone, null, null);				
		
		this.daylightSavingTime = new DaylightSavingTimeImpl(daylightSavingTime, null, null);
	}
	
	public String getTimeZone()
	{
		if(timeZone == null)
			return null;
		
		return timeZone.getString();
	}
	
	public void setTimeZone(String value)
	{
		if(value==null)
			throw new IllegalArgumentException("Time-Zone is required");
		
		this.timeZone = new TimeZoneImpl(value, null, null);	
	}
	
	public DaylightSavingTimeEnum getDaylightSavingTime()
	{
		if(daylightSavingTime == null)
			return null;
		
		return daylightSavingTime.getEnumerated(DaylightSavingTimeEnum.class);
	}
	
	public void setDaylightSavingTime(DaylightSavingTimeEnum value)
	{
		if(value==null)
			throw new IllegalArgumentException("Daylight-Saving-Time is required");
		
		this.daylightSavingTime = new DaylightSavingTimeImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(timeZone==null)
			return "Time-Zone is required";
		
		if(daylightSavingTime==null)
			return "Daylight-Saving-Time is required";
		
		return null;
	}
}