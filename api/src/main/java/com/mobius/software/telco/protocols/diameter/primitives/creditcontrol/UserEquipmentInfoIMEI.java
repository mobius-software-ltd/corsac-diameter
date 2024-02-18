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

import com.mobius.software.telco.protocols.diameter.AvpCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;

/**
*
* @author yulian oifa
*
*/
/*
 * 8.57.  User-Equipment-Info-IMEI AVP

   The User-Equipment-Info-IMEI AVP (AVP Code 658) is of type
   OctetString.  The User-Equipment-Info-IMEI AVP contains the
   International Mobile Equipment Identifier in the IMEI format
   according to 3GPP TS 23.003 [TGPPIMEI].
 */
@DiameterAvpDefinition(code = AvpCodes.USER_EQUIPMENT_INFO_IMEI, vendorId = -1L, must = false, name = "User-Equipment-Info-IMEI")
public interface UserEquipmentInfoIMEI extends DiameterOctetString
{
}