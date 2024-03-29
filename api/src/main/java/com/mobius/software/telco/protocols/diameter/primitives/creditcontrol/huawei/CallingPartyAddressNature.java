package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei;
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

import com.mobius.software.telco.protocols.diameter.HuaweiAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/
/*
 * 	3.2.295  Calling-Party-Address-Nature AVP

	AVP Name
	Calling-Party-Address-Nature

	AVP Code
	21162

	AVP Data Type
	Unsigned32

	Vendor ID
	2011

	Description
	Calling number address attribute. The options are as follows:
	    - 0: spare
	    - 1: subscriber number (in a national service)
	    - 2: unknown number (in a national service)
	    - 3: national number
	    - 4: international number
	    - 5: number specified by a network (in a national service)
 */
@DiameterAvpDefinition(code = HuaweiAvpCodes.CALLING_PARTY_ADDRESS_NATURE, vendorId = VendorIDs.HUAWEI_ID, name = "Calling-Party-Address-Nature")
public interface CallingPartyAddressNature extends DiameterUnsigned32
{
}