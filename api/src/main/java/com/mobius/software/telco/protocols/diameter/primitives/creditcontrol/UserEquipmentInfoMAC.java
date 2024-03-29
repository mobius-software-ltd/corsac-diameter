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
 * 8.54.  User-Equipment-Info-MAC AVP

   The User-Equipment-Info-MAC AVP (AVP Code 655) is of type
   OctetString.  The User-Equipment-Info-MAC AVP contains the 48-bit MAC
   address; the MAC address is formatted as described in Section 4.1.7.8
   of [RFC5777].
 */
@DiameterAvpDefinition(code = AvpCodes.USER_EQUIPMENT_INFO_MAC, vendorId = -1L, must = false, name = "User-Equipment-Info-MAC")
public interface UserEquipmentInfoMAC extends DiameterOctetString
{
}