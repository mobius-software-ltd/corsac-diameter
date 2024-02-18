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
 * 	3.2.268  Diversion-Count AVP

	AVP Name
	Diversion-Count

	AVP Code
	20822

	AVP Data Type
	Unsigned32

	Vendor ID
	10415

	Description
	Indicates the forward count.

	This field holds the forward count. It is used for call forward service. The field is valued as the sum of diversion count in History-Info header of INVITE message and call forward times triggered in local ATS.
	For example: A calls B, B forwards to C and C forwards to D.
	    - ATS-A: null ACR(A->B)
	    - ATS-B: 0 ACR(A-C)
	    - ATS-B: 1 ACR(B->C)
	    - ATS-C: 1 ACR(A-C)
	    - ATS-C: 2 ACR(C-D) 
 */
@DiameterAvpDefinition(code = HuaweiAvpCodes.DIVERSION_COUNT, vendorId = VendorIDs.HUAWEI_ID, name = "Diversion-Count")
public interface DiversionCount extends DiameterUnsigned32
{
}