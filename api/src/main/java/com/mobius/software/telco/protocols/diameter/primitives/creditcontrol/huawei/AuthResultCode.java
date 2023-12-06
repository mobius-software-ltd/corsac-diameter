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
 * 	3.2.451  Auth-Result-Code AVP

	AVP Name
	Auth-Result-Code

	AVP Code
	30801

	AVP Data Type
	Uninteger32

	Vendor ID
	2011

	Description
	Indicates an authentication result code.
	The authentication result code is used to identify the result of authenticating the authorization to use a service. The subscriber state, service scenario, subscriber information, and other information about the service are authenticated.
	For the details, see 3.3.2 Result Codes.
 */
@DiameterAvpDefinition(code = 30801L, vendorId = KnownVendorIDs.HUAWEI_ID, name = "Auth-Result-Code")
public interface AuthResultCode extends DiameterUnsigned32
{
}