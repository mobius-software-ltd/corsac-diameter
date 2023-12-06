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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	3.2.160  fee_type AVP

	AVP Name
	Fee_Type

	AVP Code
	20410

	AVP Data Type
	Unsigned32

	Vendor ID
	2011

	Description
	Indicates the charging type.
    - 0: Charge by default mode
    - 1: Charge by item
    - 2: Charge by month (with authentication and fee deduction)
    - 3: Charge by month (with authentication but no fee deduction)
    - 4: Charge upper limit amount by the number of SMs
    - 5: Charge by month with limited number of SMs (with authentication and fee deduction)
    - 6: Charge by month with limited number of SMs (with authentication but no fee deduction)

	NOTE
	For the common peer-to-peer SMs, the fee is configured in the OCS system. For other SMs, fees must be charged based on the charging policy sent by the SMSC.
 */
@DiameterAvpDefinition(code = 20410L, vendorId = KnownVendorIDs.HUAWEI_ID, name = "Fee-Type")
public interface FeeType extends DiameterUnsigned32
{
}