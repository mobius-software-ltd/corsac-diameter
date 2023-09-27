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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
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

/*
 * 4.2.1.  Time-Of-Day-Condition AVP

   The Time-Of-Day-Condition AVP (AVP Code 560) is of type Grouped and
   specifies one or more time windows.
   
      Time-Of-Day-Condition ::= < AVP Header: 560 >
                             [ Time-Of-Day-Start ]
                             [ Time-Of-Day-End ]
                             [ Day-Of-Week-Mask ]
                             [ Day-Of-Month-Mask ]
                             [ Month-Of-Year-Mask ]
                             [ Absolute-Start-Time ]
                             [ Absolute-End-Time ]
                             [ Timezone-Flag ]
                           * [ AVP ]

   For example, a time window for 9 a.m. to 5 p.m. (local time) from
   Monday to Friday would be expressed as:

   Time-Of-Day-Condition = {
       Time-Of-Day-Start = 32400;
       Time-Of-Day-End = 61200;
       Day-Of-Week-Mask =
           ( MONDAY | TUESDAY | WEDNESDAY | THURSDAY | FRIDAY );
       Timezone-Flag = LOCAL;
   }
 */
@DiameterAvpImplementation(code = 560L, vendorId = -1L)
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
	
	public Long getDayOfWeekMask()
	{
		if(dayOfWeekMask == null)
			return null;
		
		return dayOfWeekMask.getUnsigned();
	}
	
	public void setDayOfWeekMask(Long value)
	{
		if(value == null)
			this.dayOfWeekMask = null;
		else
			this.dayOfWeekMask = new DayOfWeekMaskImpl(value, null, null);
	}
	
	public Long getDayOfMonthMask()
	{
		if(dayOfMonthMask == null)
			return null;
		
		return dayOfMonthMask.getUnsigned();
	}
	
	public void setDayOfMonthMask(Long value)
	{
		if(value == null)
			this.dayOfMonthMask = null;
		else
			this.dayOfMonthMask = new DayOfMonthMaskImpl(value, null, null);
	}
	
	public Long getMonthOfYearMask()
	{
		if(monthOfYearMask == null)
			return null;
		
		return monthOfYearMask.getUnsigned();
	}
	
	public void setMonthOfYearMask(Long value)
	{
		if(value == null)
			this.monthOfYearMask = null;
		else
			this.monthOfYearMask = new MonthOfYearMaskImpl(value, null, null);
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