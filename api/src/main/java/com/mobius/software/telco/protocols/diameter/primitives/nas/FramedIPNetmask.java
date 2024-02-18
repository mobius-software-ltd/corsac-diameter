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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;

/**
*
* @author yulian oifa
*
*/
/*
 * 4.4.10.5.2.  Framed-IP-Netmask AVP

   The Framed-IP-Netmask AVP (AVP Code 9) is of type OctetString and
   contains the four octets of the IPv4 netmask to be configured for the
   user when the user is a router to a network.  It MAY be used in an
   authorization request as a hint to the server that a specific netmask
   
   is desired, but the server is not required to honor the hint in the
   corresponding response.  This AVP MUST be present in a response if
   the request included this AVP with a value of 0xFFFFFFFF.
 */
@DiameterAvpDefinition(code = AvpCodes.FRAMED_IP_NETMASK, vendorId = -1L, name = "Framed-IP-Netmask")
public interface FramedIPNetmask extends DiameterOctetString
{
}