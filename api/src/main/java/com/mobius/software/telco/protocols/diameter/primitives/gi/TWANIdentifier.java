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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	29 – TWAN-Identifier
	Length=m, where m depends on the type of location that is present as described in 3GPP TS 29.274 [81].
	TWAN Identifier field is used to convey the location information in a Trusted WLAN Access Network (TWAN). The coding of this field shall be the same as for the GTP TWAN Identifier starting with Octet 5, as per clause 8.100 in 3GPP TS 29.274 [81].
	TWAN Identifier field is Octet String type.
*/
@DiameterAvpDefinition(code = 29L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "TWAN-Identifier")
public interface TWANIdentifier extends DiameterOctetString
{
}