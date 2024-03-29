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
 * 4.4.10.6.1.  Framed-IPX-Network AVP

   The Framed-IPX-Network AVP (AVP Code 23) is of type Unsigned32 and
   contains the IPX Network number to be configured for the user.  It
   MAY be used in an authorization request as a hint to the server that
   a specific address is desired, but the server is not required to
   honor the hint in the corresponding response.

   Two addresses have special significance: 0xFFFFFFFF and 0xFFFFFFFE.
   The value 0xFFFFFFFF indicates that the NAS should allow the user to
   select an address (i.e., Negotiated).  The value 0xFFFFFFFE indicates
   that the NAS should select an address for the user (e.g., assign it
   from a pool of one or more IPX networks kept by the NAS).
 */
@DiameterAvpDefinition(code = AvpCodes.FRAMED_IP_NETWORK, vendorId = -1L, name = "Framed-IPX-Network")
public interface FramedIPXNetwork extends DiameterUnsigned32
{
}