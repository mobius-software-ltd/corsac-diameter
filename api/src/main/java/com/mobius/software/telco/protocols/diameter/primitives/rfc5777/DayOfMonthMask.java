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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterBitmask32;

/**
*
* @author yulian oifa
*
*/

/*
	4.2.5.  Day-Of-Month-Mask AVP

   	The Day-Of-Month AVP (AVP Code 564) is of type Unsigned32.  The value
   	MUST be in the range from 0 to 2147483647.  The value is a bit mask
   	that specifies the days of the month where bit 0 represents the first
   	day of the month through to bit 30, which represents the last day of
   	the month.  The bit MUST be set for the time window to match on the
   	corresponding day of the month.  Bit 0 is the least significant bit
   	and unused bits MUST be cleared.  If this AVP is absent from the
   	Time-Of-Day-Condition AVP, the time windows match on all days of the
   	month.
 */
@DiameterAvpDefinition(code = 564L, vendorId = -1L, name = "Day-Of-Month-Mask")
public interface DayOfMonthMask extends DiameterBitmask32
{
	public void setDayBit(int dom, boolean isOn);
	
	public boolean isDayBitSet(int dom);	
}