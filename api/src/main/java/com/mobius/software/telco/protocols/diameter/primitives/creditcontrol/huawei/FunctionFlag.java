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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;

/**
*
* @author yulian oifa
*
*/
/*
 * 	3.2.246  Function-Flag AVP

	AVP Name
	Function-Flag

	AVP Code
	20770

	AVP Data Type
	UTF8String
	Length Range: [0,64)

	Vendor ID
	2011

	Description
	The description and values of this AVP in the CCR and CCA are as follows:
    	- In the CCR, the digits from 1st digit to 64th digit are reserved.
    	- In the CCA
            ▪ First digit: indicates the flag of whether to charge according to the accumulated duration of short calls (0: no; 1: yes).
            ▪ Others: reserved.

	NOTE
	For a subscriber, when multiple calls whose duration is shorter than the set threshold exist, the calls can be charged according to their accumulated duration.
 */
@DiameterAvpDefinition(code = HuaweiAvpCodes.FUNCTION_FLAG, vendorId = VendorIDs.HUAWEI_ID, name = "Function-Flag")
public interface FunctionFlag extends DiameterUTF8String
{
}