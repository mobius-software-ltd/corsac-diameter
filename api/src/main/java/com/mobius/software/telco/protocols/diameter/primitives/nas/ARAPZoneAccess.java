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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/
/*
 * 4.4.10.8.2.  ARAP-Zone-Access AVP

   The ARAP-Zone-Access AVP (AVP Code 72) is of type Enumerated and MAY
   be present in the AA-Accept message if the Framed-Protocol AVP is set
   to the value of ARAP.

   The supported values are listed in [RADIUSAttrVals] and defined in
   [RFC2869].
 */
@DiameterAvpDefinition(code = AvpCodes.ARAP_ZONE_ACCESS, vendorId = -1L, name = "ARAP-Zone-Access")
public interface ARAPZoneAccess extends DiameterEnumerated<ARAPZoneAccessEnum>
{
}