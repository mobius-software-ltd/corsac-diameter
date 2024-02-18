package com.mobius.software.telco.protocols.diameter.primitives.s9;
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
 * 	5.3.8	DRA-Binding
	The DRA-Binding AVP (AVP code 2208) is of type of Enumerated, and it indicates that the action to be done on the DRA binding information.
	The following values are defined:

	DRA_BINDING_DELETION (0)
	This value is used to indicate the DRA binding information in the DRA shall be deleted.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.DRA_BINDING, vendorId = VendorIDs.TGPP_ID, must = false, name = "DRA-Binding")
public interface DRABinding extends DiameterEnumerated<DRABindingEnum>
{
}