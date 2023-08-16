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
 * 4.4.10.4.  Framed-Compression AVP

   The Framed-Compression AVP (AVP Code 13) is of type Enumerated and
   contains the compression protocol to be used for the link.  It MAY be
   used in an authorization request as a hint to the server that a
   specific compression type is desired, but the server is not required
   to honor the hint in the corresponding response.

   More than one compression protocol AVP MAY be sent.  The NAS is
   responsible for applying the proper compression protocol to the
   appropriate link traffic.

   The supported values are listed in [RADIUSAttrVals].
 */
@DiameterAvpDefinition(code = 13L, vendorId = -1L, name = "Framed-Compression")
public interface FramedCompression extends DiameterEnumerated<FramedCompressionEnum>
{
}