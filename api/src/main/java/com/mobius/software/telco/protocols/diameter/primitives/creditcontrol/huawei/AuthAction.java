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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	3.2.453  Auth-Action AVP

	AVP Name
	Auth-Action

	AVP Code
	30803

	AVP Data Type
	UTF8String
	Length Range: [0,36)

	Vendor ID
	2011

	Description
	This AVP is defined according to the instruction of an authentication result. The definition of each digit is as follows:
	First digit: whether to continue the service logic
    	- 0:CONTINUE service logic
			Indicates to continue the service logic.
    	- 1:BREAK service logic
			Indicates to release the service logic unconditionally.
    	- 2:access service/management Conponent directly
			Indicates to release the service logic and connect the service logic to the service component.
    	- 3:Indicates to release the service logic and reroute the call to another number.
	Second digit: whether to display a message
    	- 0:No
			Indicates not to display any message.
    	- 1:Need prompt
			Indicates to display a message. The message contents can be the same as the information identified by the first digit or any other contents.
 */
@DiameterAvpDefinition(code = 30803L, vendorId = KnownVendorIDs.HUAWEI_ID, name = "Auth-Action")
public interface AuthAction extends DiameterUTF8String
{
}