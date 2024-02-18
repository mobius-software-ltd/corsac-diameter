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
 * 	3.2.109  Recharge-Method AVP

	AVP Name
	Recharge-Method

	AVP Code
	20343

	AVP Data Type
	Enumerated

	Vendor ID
	2011

	Description
	Indicates the recharging method.

	The values and description are as follows:
    	- 0: First activation

	Normal first activation rather than the first activation by recharge card or cash.
    	- 1: Voucher recharge through IVR from other phone.
    	- 2: Voucher recharge through IVR from self phone.
    	- 3: Voucher recharge through SMS from other phone.
    	- 4: Voucher recharge through SMS from self phone.
    	- 5: Voucher recharge through USSD from other phone.
    	- 6: Voucher recharge through USSD from self phone.
    	- 7: Voucher recharge by operator/external system (manual recharge).
    	- 8: First activation by recharge card.
    	- 9: First activation in cash.
    	- 10: Loan by USSD.
    	- 11: Loan by IVR.
    	- 999: EVC Recharge.
    	- 9999: Query recharge record.
    	- other: reserved.
    	- > 1000: Extended by external systems.
 */
@DiameterAvpDefinition(code = HuaweiAvpCodes.RECHARGE_METHOD, vendorId = VendorIDs.HUAWEI_ID, name = "Recharge-Method")
public interface RechargeMethod extends DiameterEnumerated<RechargeMethodEnum>
{
}