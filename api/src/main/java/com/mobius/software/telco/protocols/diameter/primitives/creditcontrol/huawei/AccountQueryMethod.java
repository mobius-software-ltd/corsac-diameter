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
 * 	3.2.111  Account-Query-Method AVP
	
	AVP Name
	Account-Query-Method
	
	AVP Code
	20346

	AVP Data Type
	Unsigned32

	Vendor ID
	2011

	Description
	Indicates the method for querying for an account.
    	- 1: Query information about the all account.
    	- 2: Query information about the core balance account.

	For prepaid subscribers, query the account whose type is 2000.
	For postpaid subscribers, query the account whose type is 3000.
    	- 3: Query information about the residual traffic.
    	- 4: Query information about the subscriber's points account.
    	- 5: Reserved.
    	- 7: Query information about the main account and all subaccounts.
    	- 8: Query information about the main account and its validity period.
    	- 9: Query information about the main account and bonus account books.
    	- 13: Query EasyNet package information.
    	- 14: Query SMS Bundle package information.
    	- 15: Query the effective and expiration time of the CTU service.
    	- 16: Query remaining service usage of the CTU service under the FUP.
    	- 18: Query balance information about all account books. In addition, the balance information is summarized by account book type and the longest validity period is obtained.
    	- 22: The CHG returns information and validity periods of all account books by AVP and returns bonus account books by SMS message, where specific account books can be excluded.
    	- 26: Query accumulator information by USSD.
 */
@DiameterAvpDefinition(code = HuaweiAvpCodes.ACCOUNT_QUERY_METHOD, vendorId = VendorIDs.HUAWEI_ID, name = "Account-Query-Method")
public interface AccountQueryMethod extends DiameterUnsigned32
{
}