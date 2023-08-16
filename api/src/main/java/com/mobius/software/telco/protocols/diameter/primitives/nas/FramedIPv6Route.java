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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;

/**
*
* @author yulian oifa
*
*/
/*
 * 4.4.10.5.7.  Framed-IPv6-Route AVP

   The Framed-IPv6-Route AVP (AVP Code 99) is of type UTF8String and
   contains the US-ASCII routing information to be configured for the
   user on the NAS.  Zero or more of these AVPs MAY be present in an
   authorization response.

   The string MUST contain an IPv6 address prefix followed by a slash
   and a decimal-length specifier stating how many high-order bits of
   the prefix should be used.  This is followed by a space, a gateway
   address in hexadecimal notation, a space, and one or more metrics
   separated by spaces; for example,

      "2001:db8::/32 2001:db8:106:a00:20ff:fe99:a998 1"

   Whenever the gateway address is the IPv6 unspecified address, the IP
   address of the user SHOULD be used as the gateway address, such as
   in:

      "2001:db8::/32 :: 1"
 */
@DiameterAvpDefinition(code = 99L, vendorId = -1L, name = "Framed-IPv6-Route")
public interface FramedIPv6Route extends DiameterUTF8String
{
}