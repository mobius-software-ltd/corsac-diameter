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

import com.mobius.software.telco.protocols.diameter.AvpCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/

/*
	4.2.8.  Absolute-Start-Fractional-Seconds AVP

   	The Absolute-Start-Fractional-Seconds AVP (AVP Code 567) is of type
   	Unsigned32.  The value specifies the fractional seconds that are
   	added to Absolute-Start-Time value in order to determine when the
   	time window starts.  If this AVP is absent from the Time-Of-Day-
   	Condition AVP, then the fractional seconds are assumed to be zero.
 */
@DiameterAvpDefinition(code = AvpCodes.ABSOLUTE_START_FRACTIONAL_SECONDS, vendorId = -1L, name = "Absolute-Start-Fractional-Seconds")
public interface AbsoluteStartFractionalSeconds extends DiameterUnsigned32
{
}