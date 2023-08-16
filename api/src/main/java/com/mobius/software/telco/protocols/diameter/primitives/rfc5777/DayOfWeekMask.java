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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/

/*
	4.2.4.  Day-Of-Week-Mask AVP

   	The Day-Of-Week-Mask AVP (AVP Code 563) is of type Unsigned32.  The
   	value is a bit mask that specifies the day of the week for the time
   	window to match.  This document specifies the following bits:
   	
   	Bit  | Name
     ------+------------
       0   | SUNDAY
       1   | MONDAY
       2   | TUESDAY
       3   | WEDNESDAY
       4   | THURSDAY
       5   | FRIDAY
       6   | SATURDAY

   	The bit MUST be set for the time window to match on the corresponding
   	day of the week.  Bit 0 is the least significant bit and unused bits
   	MUST be cleared.  If this AVP is absent from the Time-Of-Day-
   	Condition AVP, the time windows match on all days of the week.
 */
@DiameterAvpDefinition(code = 563L, vendorId = -1L, name = "Day-Of-Week-Mask")
public interface DayOfWeekMask extends DiameterUnsigned32
{
}