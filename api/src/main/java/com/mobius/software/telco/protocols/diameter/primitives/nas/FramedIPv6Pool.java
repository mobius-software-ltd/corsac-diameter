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
 * 4.4.10.5.8.  Framed-IPv6-Pool AVP

   The Framed-IPv6-Pool AVP (AVP Code 100) is of type OctetString and
   contains the name of an assigned pool that SHOULD be used to assign
   an IPv6 prefix for the user.  If the access device does not support
   multiple prefix pools, it MUST ignore this AVP.

   Although specified as type OctetString for compatibility with RADIUS
   [RFC3162], the encoding of the Data field SHOULD also conform to the
   rules for the UTF8String Data Format.
 */
@DiameterAvpDefinition(code = AvpCodes.FRAMED_IPV6_POOL, vendorId = -1L, name = "Framed-IPv6-Pool")
public interface FramedIPv6Pool extends DiameterOctetString
{
}