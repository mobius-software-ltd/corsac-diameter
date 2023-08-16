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
 * 4.2.4.  NAS-Port-Type AVP

   The NAS-Port-Type AVP (AVP Code 61) is of type Enumerated and
   contains the type of the port on which the NAS is authenticating the
   user.  This AVP SHOULD be present if the NAS uses the same NAS-Port
   number ranges for different service types concurrently.

   The currently supported values of the NAS-Port-Type AVP are listed in
   [RADIUSAttrVals].
 */
@DiameterAvpDefinition(code = 61L, vendorId = -1L, name = "NAS-Port-Type")
public interface NASPortType extends DiameterEnumerated<NASPortTypeEnum>
{
}