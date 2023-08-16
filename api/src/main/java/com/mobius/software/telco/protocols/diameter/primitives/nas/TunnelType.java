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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/
/*
 * 4.5.2.  Tunnel-Type AVP

   The Tunnel-Type AVP (AVP Code 64) is of type Enumerated and contains
   the tunneling protocol(s) to be used (in the case of a tunnel
   initiator) or in use (in the case of a tunnel terminator).  It MAY be
   used in an authorization request as a hint to the server that a
   specific tunnel type is desired, but the server is not required to
   honor the hint in the corresponding response.

   The Tunnel-Type AVP SHOULD also be included in ACR messages.

   A tunnel initiator is not required to implement any of these tunnel
   types.  If a tunnel initiator receives a response that contains only
   unknown or unsupported tunnel types, the tunnel initiator MUST behave
   as though a response were received with the Result-Code indicating a
   failure.

   The supported values are listed in [RADIUSAttrVals].
 */
@DiameterAvpDefinition(code = 64L, vendorId = -1L, name = "Tunnel-Type")
public interface TunnelType extends DiameterEnumerated<TunnelTypeEnum>
{
}