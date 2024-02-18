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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/
/*
 * 	3.2.112  Charge-Confirm-Flag AVP

	AVP Name
	Charge-ConfirmFlag

	AVP Code
	20347

	AVP Data Type
	Enumerated

	Vendor ID
	2011

	Description
	Indicates the flag for confirming the recharge.
    	- 0: Confirm the recharge.
    	- 1: Cancel the recharge.

	The default value is 0.
 */
@DiameterAvpDefinition(code = HuaweiAvpCodes.CHARGE_CONFIRM_FLAG, vendorId = VendorIDs.HUAWEI_ID, name = "Charge-Confirm-Flag")
public interface ChargeConfirmFlag extends DiameterEnumerated<ChargeConfirmFlagEnum>
{
}