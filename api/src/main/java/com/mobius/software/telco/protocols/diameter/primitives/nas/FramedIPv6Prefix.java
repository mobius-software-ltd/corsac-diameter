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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;

/**
*
* @author yulian oifa
*
*/
/*
 * 4.4.10.5.6.  Framed-IPv6-Prefix AVP

   The Framed-IPv6-Prefix AVP (AVP Code 97) is of type OctetString and
   contains the IPv6 prefix to be configured for the user.  One or more
   AVPs MAY be used in authorization requests as a hint to the server
   that specific IPv6 prefixes are desired, but the server is not
   required to honor the hint in the corresponding response.
 */
@DiameterAvpDefinition(code = 97L, vendorId = -1L, name = "Framed-IPv6-Prefix")
public interface FramedIPv6Prefix extends DiameterOctetString
{
}