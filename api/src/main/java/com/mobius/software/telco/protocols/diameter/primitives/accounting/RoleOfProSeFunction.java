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
 * 	7.2.177aA Role-Of-ProSe-Function AVP
	The Role-Of-ProSe-Function AVP (AVP code 3438) is of type Enumerated and indicates ProSe Function resides in
	which PLMN. The AVP may take the values as follows:
	
	0 HPLMN
	1 VPLMN
	2 Local PLMN
 */
@DiameterAvpDefinition(code = TgppAvpCodes.ROLE_OF_PROSE_FUNCTION, vendorId = VendorIDs.TGPP_ID, name = "Role-Of-ProSe-Function")
public interface RoleOfProSeFunction extends DiameterEnumerated<RoleOfProSeFunctionEnum>
{
}