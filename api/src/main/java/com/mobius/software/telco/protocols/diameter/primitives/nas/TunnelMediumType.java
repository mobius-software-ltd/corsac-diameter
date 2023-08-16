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
 * 4.5.3.  Tunnel-Medium-Type AVP

   The Tunnel-Medium-Type AVP (AVP Code 65) is of type Enumerated and
   contains the transport medium to use when creating a tunnel for
   protocols (such as L2TP [RFC3931]) that can operate over multiple
   transports.  It MAY be used in an authorization request as a hint to
   the server that a specific medium is desired, but the server is not
   required to honor the hint in the corresponding response.

   The supported values are listed in [RADIUSAttrVals].
 */
@DiameterAvpDefinition(code = 65L, vendorId = -1L, name = "Tunnel-Medium-Type")
public interface TunnelMediumType extends DiameterEnumerated<TunnelMediumTypeEnum>
{
}