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
 * 	3.2.427  ABM-Operation-Type AVP

	AVP Name
	ABM-Operation-Type

	AVP Code
	30336

	AVP Data Type
	Uninteger32
	Length Range: [0,999)

	Vendor ID
	0

	Description
	    - 0: forward operation (for example, expense or recharge).
	    - 1: reversal (for example, expense or recharge reversal).
	    - 2: submission. (This value is valid only in the locking operation.)
	    - 3: locking rollback.
 */
@DiameterAvpDefinition(code = HuaweiAvpCodes.ABM_OPERATION_TYPE, vendorId = VendorIDs.HUAWEI_ID, name = "ABM-Operation-Type")
public interface ABMOperationType extends DiameterUnsigned32
{
}