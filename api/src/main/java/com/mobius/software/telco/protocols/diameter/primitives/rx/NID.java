package com.mobius.software.telco.protocols.diameter.primitives.rx;
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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;

/**
*
* @author yulian oifa
*
*/

/*
 * 	.3.68	NID AVP
	The NID AVP (AVP code 569) is of type OctetString, and it indicates Network Identifier (NID) consisting on 44 bits (11 hexadecimal digits), as specified in 3GPP TS 23.003 [38], clause 12.7.
	The NID AVP is only applicable in 5GS when the serving network is an SNPN, as described in Annex E.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.NID, vendorId = VendorIDs.TGPP_ID, must = false, name = "NID")
public interface NID extends DiameterOctetString
{
}