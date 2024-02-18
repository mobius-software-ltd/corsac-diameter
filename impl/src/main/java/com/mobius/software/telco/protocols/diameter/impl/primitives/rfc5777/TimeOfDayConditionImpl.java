package com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5777;
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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.AbsoluteEndTime;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.AbsoluteStartTime;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.DayOfMonthMask;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.DayOfWeekMask;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.MonthOfYearMask;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.TimeOfDayCondition;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.TimeOfDayEnd;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.TimeOfDayStart;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.TimezoneFlag;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.TimezoneFlagEnum;

/**
*
* @author yulian oifa
*
*/
public class TimeOfDayConditionImpl extends DiameterGroupedAvpImpl implements TimeOfDayCondition
{
	private TimeOfDayStart timeOfDayStart;
	
	private TimeOfDayEnd timeOfDayEnd;
	
	private DayOfWeekMask dayOfWeekMask;
	
	private DayOfMonthMask dayOfMonthMask;
	
	private MonthOfYearMask monthOfYearMask;
	
	private AbsoluteStartTime absoluteStartTime;
	
	private AbsoluteEndTime absoluteEndTime;
	
	private TimezoneFlag timezoneFlag;
	
	public TimeOfDayConditionImpl()
	{
		
	}
	
	public Long getTimeOfDayStart()
	{
		if(timeOfDayStart == null)
			return null;
		
		return timeOfDayStart.getUnsigned();
	}
	
	public void setTimeOfDayStart(Long value)
	{
		if(value == null)
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
		if(value == null)
			this.timeOfDayEnd = null;
		else
			this.timeOfDayEnd = new TimeOfDayEndImpl(value, null, null);
	}
	
	public DayOfWeekMask getDayOfWeekMask()
	{
		return dayOfWeekMask;
	}
	
	public void setDayOfWeekMask(DayOfWeekMask value)
	{
		this.dayOfWeekMask = value;
	}
	
	public DayOfMonthMask getDayOfMonthMask()
	{
		return dayOfMonthMask;
	}
	
	public void setDayOfMonthMask(DayOfMonthMask value)
	{
		this.dayOfMonthMask = value;
	}
	
	public MonthOfYearMask getMonthOfYearMask()
	{
		return monthOfYearMask;
	}
	
	public void setMonthOfYearMask(MonthOfYearMask value)
	{
		this.monthOfYearMask = value;
	}
	
	public Date getAbsoluteStartTime()
	{
		if(absoluteStartTime == null)
			return null;
		
		return absoluteStartTime.getDateTime();
	}
	
	public void setAbsoluteStartTime(Date value)
	{
		if(value == null)
			this.absoluteStartTime = null;
		else
			this.absoluteStartTime = new AbsoluteStartTimeImpl(value, null, null);
	}
	
	public Date getAbsoluteEndTime()
	{
		if(absoluteEndTime == null)
			return null;
		
		return absoluteEndTime.getDateTime();
	}
	
	public void setAbsoluteEndTime(Date value)
	{
		if(value == null)
			this.absoluteEndTime = null;
		else
			this.absoluteEndTime = new AbsoluteEndTimeImpl(value, null, null);
	}
	
	public TimezoneFlagEnum getTimezoneFlag()
	{
		if(timezoneFlag == null)
			return null;
		
		return timezoneFlag.getEnumerated(TimezoneFlagEnum.class);
	}
	
	public void setTimezoneFlag(TimezoneFlagEnum value)
	{
		if(value == null)
			this.timezoneFlag = null;
		else
			this.timezoneFlag = new TimezoneFlagImpl(value, null, null);
	}
}