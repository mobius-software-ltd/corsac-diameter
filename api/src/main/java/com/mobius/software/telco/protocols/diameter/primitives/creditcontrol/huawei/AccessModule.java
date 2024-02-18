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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterInteger32;

/**
*
* @author yulian oifa
*
*/
/*
 * 	3.2.440  AccessModule AVP

	AVP Name
	AccessModule

	AVP Code
	30349

	AVP Data Type
	Integer32

	Vendor ID
	0
	
	Description
	This AVP is used in the recharge UVC scheme. 
	This AVP specifies the NE or system that initiates a recharge request:
	    - 0: OCG (Huawei OM or SCP invokes the interface.)
	    - 1: OCG (Huawei IPCC invokes the interface.)
	    - 2: 3rd party payment gate Way (All third party system invokes the WebService of the AR for recharge.)
	    - 3: CRM (Huawei CRM invokes the interface.)
	    - 4: CBS AR GUI (A recharge request is initiated from the Huawei Billing care AR GUI.)
	    - 5: to be extended
 */
@DiameterAvpDefinition(code = HuaweiAvpCodes.ACCESS_MODULE, vendorId = VendorIDs.HUAWEI_ID, name = "Access-Module")
public interface AccessModule extends DiameterInteger32
{
}