package com.mobius.software.telco.protocols.diameter.primitives.rfc5778;
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
 * 	6.19.  Chargeable-User-Identity AVP

   	The Chargeable-User-Identity AVP (AVP Code 89) is of type OctetString
   	and contains a unique temporary handle of the user.  The Chargeable-
   	User-Identity is defined in [RFC4372].
 */
@DiameterAvpDefinition(code = AvpCodes.CHARGEABLE_USER_IDENTITY, vendorId = -1L, name = "Chargeable-User-Identity")
public interface ChargeableUserIdentity extends DiameterOctetString
{
}