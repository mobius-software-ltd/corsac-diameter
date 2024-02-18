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
 * 	3.2.407  Ex-Parameter-4 AVP

	AVP Name
	Ex-Parameter-4

	AVP Code
	30315

	AVP Data Type
	UTF8String
	Length Range: [0,256)
	
	Vendor ID
	2011

	Description
	This AVP is used for transmitting common attribute fields in the recharge UVC scheme.

	The value format is code1|value1|code2|value2|codeN|valueN. The value must end with a vertical bar (|). 
	If the value of this AVP exceeds 256 digits, the excessive code|value groups are stored in ExParameter2, ExParameter3, until ExParameter10.
 */
@DiameterAvpDefinition(code = HuaweiAvpCodes.EX_PARAMETER_4, vendorId = VendorIDs.HUAWEI_ID, name = "Ex-Parameter-4")
public interface ExParameter4 extends DiameterUTF8String
{
}