package com.mobius.software.telco.protocols.diameter.primitives.rfc8583;
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
 * 7.2.  Load-Type AVP

   The Load-Type AVP (AVP code 651) is of type Enumerated.  It is used
   to convey the type of Diameter node that sent the load information.
   The following values are defined:

   HOST 0  The load report is for a host.

   PEER 1  The load report is for a peer.
 */
@DiameterAvpDefinition(code = 651L, vendorId = -1L, must = false, name = "Load-Type")
public interface LoadType extends DiameterEnumerated<LoadTypeEnum>
{
}