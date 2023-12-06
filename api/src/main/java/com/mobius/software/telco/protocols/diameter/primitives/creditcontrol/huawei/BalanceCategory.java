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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterInteger32;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	3.2.528  Balance-Category AVP

	AVP Name
	Balance-Category

	AVP Code
	60003

	AVP Data Type
	Integer32

	Vendor ID
	2011

	Description
	Balance type. The options are as follows:
	    - 0: balance account
	    - 1: credit account
	    - 2: free resource account

	NOTE
	When this AVP is set to 0, Payment-Type can be set to 0 or 1. When this AVP is set to 1, Payment-Type can be set only to 1. When this AVP is set to 2, Payment-Type can be blank.
 */
@DiameterAvpDefinition(code = 60003L, vendorId = KnownVendorIDs.HUAWEI_ID, name = "Balance-Category")
public interface BalanceCategory extends DiameterInteger32
{
}