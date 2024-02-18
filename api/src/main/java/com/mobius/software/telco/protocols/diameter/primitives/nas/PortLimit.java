package com.mobius.software.telco.protocols.diameter.primitives.nas;
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
 * 4.4.5.  Port-Limit AVP

   The Port-Limit AVP (AVP Code 62) is of type Unsigned32 and sets the
   maximum number of ports the NAS provides to the user.  It MAY be used
   in an authentication and/or authorization request as a hint to the
   server that multilink PPP [RFC1990] service is desired, but the
   server is not required to honor the hint in the corresponding
   response.
 */
@DiameterAvpDefinition(code = AvpCodes.PORT_LIMIT, vendorId = -1L, name = "Port-Limit")
public interface PortLimit extends DiameterUnsigned32
{
}