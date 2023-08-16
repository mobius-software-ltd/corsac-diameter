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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterIpv4Address;

/**
*
* @author yulian oifa
*
*/
/*
 * 4.4.10.5.1.  Framed-IP-Address AVP

   The Framed-IP-Address AVP (AVP Code 8) [RFC2865] is of type
   OctetString and contains an IPv4 address of the type specified in the
   attribute value to be configured for the user.  It MAY be used in an
   authorization request as a hint to the server that a specific address
   is desired, but the server is not required to honor the hint in the
   corresponding response.

   Two values have special significance: 0xFFFFFFFF and 0xFFFFFFFE.  The
   value 0xFFFFFFFF indicates that the NAS should allow the user to
   select an address (i.e., negotiated).  The value 0xFFFFFFFE indicates
   that the NAS should select an address for the user (e.g., assigned
   from a pool of addresses kept by the NAS).
 */
@DiameterAvpDefinition(code = 8L, vendorId = -1L, name = "Framed-IP-Address")
public interface FramedIPAddress extends DiameterIpv4Address
{
}