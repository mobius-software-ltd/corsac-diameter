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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterInteger64;

/**
*
* @author yulian oifa
*
*/
/*
 * 	3.2.439  Account-Balance-Change AVP (30348)

	AVP Name
	Account-Balance-Change

	AVP Code
	30348

	AVP Data Type
	Integer64
	Length Range: [0,999)

	Vendor ID
	0
	
	Description
	-
 */
@DiameterAvpDefinition(code = HuaweiAvpCodes.ACCOUNT_BALANCE_CHANGE_30348, vendorId = VendorIDs.HUAWEI_ID, name = "Account-Balance-Change")
public interface AccountBalanceChange30348 extends DiameterInteger64
{
}