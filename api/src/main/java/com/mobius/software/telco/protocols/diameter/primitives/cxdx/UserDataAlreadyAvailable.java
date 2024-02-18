package com.mobius.software.telco.protocols.diameter.primitives.cxdx;
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
 * 	6.3.26	User-Data-Already-Available AVP
	The User-Data-Already-Available AVP is of type Enumerated, and indicates to the HSS whether or not the S-CSCF already has the part of the user profile that it needs to serve the user. The following values are defined:

	USER_DATA_NOT_AVAILABLE (0)
    	• 	The S-CSCF does not have the data that it needs to serve the user.

	USER_DATA_ALREADY_AVAILABLE (1)
    	• 	The S-CSCF already has the data that it needs to serve the user.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.USER_DATA_ALREADY_AVAILABLE, vendorId = VendorIDs.TGPP_ID, name = "User-Data-Already-Available")
public interface UserDataAlreadyAvailable extends DiameterEnumerated<UserDataAlreadyAvailableEnum>
{
}