package com.mobius.software.telco.protocols.diameter.primitives.gi;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	13 - 3GPP-Charging-Characteristics
	Charging characteristics value: Text type.
 	The charging characteristics is value of the 2 octets. The value field is taken from the GTP IE described in 3GPP
	TS 29.060 [24], subclause 7.7.23 for the GGSN and 3GPP TS 29.274 [81] for the P-GW.
	Each octet of this IE field value is represented via 2 UTF-8 encoded character, defining its hexadecimal
	representation. 
 */
@DiameterAvpDefinition(code = 13L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "3GPP-ChargingCharacteristics")
public interface TGPPChargingCharacteristics extends DiameterUTF8String
{
}