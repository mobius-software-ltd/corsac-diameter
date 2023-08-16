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
	4.2.3.  Time-Of-Day-End AVP

   	The Time-Of-Day-End AVP (AVP Code 562) is of type Unsigned32.  The
   	value MUST be in the range from 1 to 86400.  The value of this AVP
   	specifies the end of an inclusive time window expressed as the offset
   	in seconds from midnight.  If this AVP is absent from the Time-Of-
   	Day-Condition AVP, the time window ends one second before midnight.
 */
@DiameterAvpDefinition(code = 562L, vendorId = -1L, name = "Time-Of-Day-End")
public interface TimeOfDayEnd extends DiameterUnsigned32
{
}