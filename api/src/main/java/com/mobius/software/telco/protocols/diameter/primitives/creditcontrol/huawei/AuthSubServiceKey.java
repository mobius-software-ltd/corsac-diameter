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
 * 	3.2.456  Auth-Sub-Service-Key AVP

	AVP Name
	Auth-Sub-Service-Key

	AVP Code
	30806

	AVP Data Type
	UTF8String
	Length Range: [0,36)

	Vendor ID
	2011

	Description
	Indicates the function ID of a service component when the first digit of the Auth-action AVP is 2, that is, when the service logic is released and connected to the service component.
 */
@DiameterAvpDefinition(code = HuaweiAvpCodes.AUTH_SUBSERVICE_KEY, vendorId = VendorIDs.HUAWEI_ID, name = "Auth-Sub-Service-Key")
public interface AuthSubServiceKey extends DiameterUTF8String
{
}