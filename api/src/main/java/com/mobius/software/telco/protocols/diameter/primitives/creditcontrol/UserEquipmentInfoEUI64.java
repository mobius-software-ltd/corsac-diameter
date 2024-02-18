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
 * 8.55.  User-Equipment-Info-EUI64 AVP

   The User-Equipment-Info-EUI64 AVP (AVP Code 656) is of type
   OctetString.  The User-Equipment-Info-EUI64 AVP contains the 64-bit
   identifier used to identify the hardware instance of the product, as
   defined in [EUI64].
 */
@DiameterAvpDefinition(code = AvpCodes.USER_EQUIPMENT_INFO_EUI164, vendorId = -1L, must = false, name = "User-Equipment-Info-EUI64")
public interface UserEquipmentInfoEUI64 extends DiameterOctetString
{
}