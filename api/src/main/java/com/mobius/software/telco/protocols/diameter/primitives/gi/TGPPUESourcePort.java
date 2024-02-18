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
	33 – 3GPP-UE-Source-Port
	3GPP Type: 33
	Length=5
	Source Port Type field: It is encoded in Octet String type and the following decimal equivalent values apply:
	1			UDP Source Port 
	2			TCP Source Port 

	Port Number field: It is encoded in Octet String type, with bit 8 of Octet 4 represents the most significant bit of the port number and bit 1 of Octet 5 represents the least significant bit.
*/
@DiameterAvpDefinition(code = TgppAvpCodes.TGPP_UE_SOURCE_PORT, vendorId = VendorIDs.TGPP_ID, must = false, name = "3GPP-UE-Source-Port")
public interface TGPPUESourcePort extends DiameterOctetString
{
}