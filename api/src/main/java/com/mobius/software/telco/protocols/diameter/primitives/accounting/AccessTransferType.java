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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.1B Access-Transfer-Type AVP
	The Access-Transfer-Type AVP (AVP code 2710) is of type Enumerated and indicates which type of transfer occurred
	for IMS service continuity. The following values are defined:

	0 PS to CS Transfer
	1 CS to PS Transfer
	2 PS to PS Transfer
	3 CS to CS Transfer
 */
@DiameterAvpDefinition(code = TgppAvpCodes.ACCESS_TRANSFER_TYPE, vendorId = VendorIDs.TGPP_ID, name = "Access-Transfer-Type")
public interface AccessTransferType extends DiameterEnumerated<AccessTransferTypeEnum>
{
}