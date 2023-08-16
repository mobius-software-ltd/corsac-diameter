package com.mobius.software.telco.protocols.diameter.primitives.rfc5777;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

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
@DiameterAvpDefinition(code = 560L, vendorId = -1L, name = "Time-Of-Day-Condition")
public interface TimeOfDayCondition extends DiameterGroupedAvp
{
	Long getTimeOfDayStart();
	
	void setTimeOfDayStart(Long value);	
	
	Long getTimeOfDayEnd();
	
	void setTimeOfDayEnd(Long value);
	
	Long getDayOfWeekMask();
	
	void setDayOfWeekMask(Long value);	
	
	Long getDayOfMonthMask();
	
	void setDayOfMonthMask(Long value);
	
	Long getMonthOfYearMask();
	
	void setMonthOfYearMask(Long value);
	
	Date getAbsoluteStartTime();
	
	void setAbsoluteStartTime(Date value);	
	
	Date getAbsoluteEndTime();
	
	void setAbsoluteEndTime(Date value);
	
	TimezoneFlagEnum getTimezoneFlag();
	
	void setTimezoneFlag(TimezoneFlagEnum value);
}