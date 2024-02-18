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
 * 	3.2.146  Message-Content-1/ 2/ 3/ 4/ 5/ 6 AVP
	
	AVP Name
	Message-Content-1/ Message-Content-2/ Message-Content-3/ 
	Message-Content-4/ Message-Content-5/ Message-Content-6

	AVP Code
	20396/ 20397/ 20398/ 20399/ 20700/ 20701

	AVP Data Type
	UTF8String
	Length Range: [0,256)

	Vendor ID
	2011

	Description
	Refer to the description about the message contents that contain up to 140 English characters.
	The AVP whether to be used is depended on the value of the MessageCount AVP.
 */
@DiameterAvpDefinition(code = HuaweiAvpCodes.MESSAGE_CONTENT_2, vendorId = VendorIDs.HUAWEI_ID, name = "Message-Content-2")
public interface MessageContent2 extends DiameterUTF8String
{
}