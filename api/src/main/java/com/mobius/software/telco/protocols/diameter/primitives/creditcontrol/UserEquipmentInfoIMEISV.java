package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol;
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
 * 8.53.  User-Equipment-Info-IMEISV AVP

   The User-Equipment-Info-IMEISV AVP (AVP Code 654) is of type
   OctetString.  The User-Equipment-Info-IMEISV AVP contains the
   International Mobile Equipment Identifier and Software Version in the
   IMEISV format according to 3GPP TS 23.003 [TGPPIMEI].
 */
@DiameterAvpDefinition(code = 654L, vendorId = -1L, must = false, name = "User-Equipment-Info-IMEISV")
public interface UserEquipmentInfoIMEISV extends DiameterOctetString
{
}