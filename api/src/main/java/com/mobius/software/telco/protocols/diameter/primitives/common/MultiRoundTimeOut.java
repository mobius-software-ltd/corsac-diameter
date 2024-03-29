package com.mobius.software.telco.protocols.diameter.primitives.common;
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
 * 8.19.  Multi-Round-Time-Out AVP

   The Multi-Round-Time-Out AVP (AVP Code 272) is of type Unsigned32 and
   SHOULD be present in application-specific authorization answer
   messages whose Result-Code AVP is set to DIAMETER_MULTI_ROUND_AUTH.
   This AVP contains the maximum number of seconds that the access
   device MUST provide the user in responding to an authentication
   request.
 */
@DiameterAvpDefinition(code = AvpCodes.MULTI_ROUND_TIMEOUT, vendorId = -1L, name = "Multi-Round-Time-Out")
public interface MultiRoundTimeOut extends DiameterUnsigned32
{
}