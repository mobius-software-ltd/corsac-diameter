package com.mobius.software.telco.protocols.diameter.primitives.accounting;
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
 * 	7.2.80G Layer-2-Group-ID AVP
	The Layer-2-Group-ID AVP (AVP code 3429) is of type OctetString and carry the identifier of a ProSe communication
	group, uniquely represents a specific one-to-many ProSe Direct Communication and is included in CDRs for each
	participantes in the specific group. This identity is referred to as "ProSe Layer-2 Group ID" in TS 23.303 [235]. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.LAYER_2_GROUP_ID, vendorId = VendorIDs.TGPP_ID, name = "Layer-2-Group-ID")
public interface Layer2GroupID extends DiameterOctetString
{
}