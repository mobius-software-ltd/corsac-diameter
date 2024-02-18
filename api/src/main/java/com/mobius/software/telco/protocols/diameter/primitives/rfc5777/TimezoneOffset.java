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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterInteger32;

/**
*
* @author yulian oifa
*
*/

/*
	4.2.12.  Timezone-Offset AVP

   	The Timezone-Offset AVP (AVP Code 571) is of type Integer32.  The
   	value of this AVP MUST be in the range from -43200 to 43200.  It
   	specifies the offset in seconds from UTC that was used to express
   	Time-Of-Day-Start, Time-Of-Day-End, Day-Of-Week-Mask, Day-Of-Month-
   	Mask, and Month-Of-Year-Mask AVPs.  This AVP MUST be present if the
   	Timezone-Flag AVP is set to OFFSET.
 */
@DiameterAvpDefinition(code = AvpCodes.TIMEZONE_OFFSET, vendorId = -1L, name = "Timezone-Offset")
public interface TimezoneOffset extends DiameterInteger32
{
}