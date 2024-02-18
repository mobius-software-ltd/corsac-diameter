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
 * 	3.2.124  User-Passwd AVP

	AVP Name
	User-Passwd

	AVP Code
	20362

	AVP Data Type
	UTF8String

	Vendor ID
	2011

	Description
	Indicates the authentication result of the call control information.
	The meaning of each digit of the value is predefined. For example, the first digit indicates the RBT service, and the second digit indicates the Background Music (BGM) service.
	For the digit that indicates successful authentication, enter 1; for the digit that indicates failed authentication, enter 0.
 */
@DiameterAvpDefinition(code = HuaweiAvpCodes.USER_PASSWD, vendorId = VendorIDs.HUAWEI_ID, name = "User-Passwd")
public interface UserPasswd extends DiameterUTF8String
{
}