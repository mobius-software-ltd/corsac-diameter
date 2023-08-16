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
 * 8.56.  User-Equipment-Info-ModifiedEUI64 AVP

   The User-Equipment-Info-ModifiedEUI64 AVP (AVP Code 657) is of type
   OctetString.  There are a number of types of terminals that have
   identifiers other than IMEI, IEEE 802 MACs, or EUI-64.  These
   identifiers can be converted to modified EUI-64 format as described
   in [RFC4291] or by using some other methods referred to in the
   service-specific documentation.  The User-Equipment-Info-
   ModifiedEUI64 AVP contains such identifiers.
 */
@DiameterAvpDefinition(code = 657L, vendorId = -1L, must = false, name = "User-Equipment-Info-ModifiedEUI64")
public interface UserEquipmentInfoModifiedEUI64 extends DiameterOctetString
{
}