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
 * 4.4.10.5.3.  Framed-Route AVP

   The Framed-Route AVP (AVP Code 22) is of type UTF8String and contains
   the 7-bit US-ASCII routing information to be configured for the user
   on the NAS.  Zero or more of these AVPs MAY be present in an
   authorization response.

   The string MUST contain a destination prefix in dotted quad form
   optionally followed by a slash and a decimal-length specifier stating
   how many high-order bits of the prefix should be used.  This is
   followed by a space, a gateway address in dotted quad form, a space,
   and one or more metrics separated by spaces; for example,

      "192.0.2.0/24 192.0.2.1 1"

   The length specifier may be omitted, in which case it should default
   to 8 bits for class A prefixes, 16 bits for class B prefixes, and 24
   bits for class C prefixes; for example,

      "192.0.2.0 192.0.2.1 1"

   Whenever the gateway address is specified as "0.0.0.0", the IP
   address of the user SHOULD be used as the gateway address.
 */
@DiameterAvpDefinition(code = 22L, vendorId = -1L, name = "Framed-Route")
public interface FramedRoute extends DiameterOctetString
{
}