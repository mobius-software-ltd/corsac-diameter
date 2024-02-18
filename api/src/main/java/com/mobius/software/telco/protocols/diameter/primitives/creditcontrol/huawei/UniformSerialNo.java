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
 * 	3.2.249  Uniform-Serial-No AVP

	AVP Name 
	Uniform-Serial-No

	AVP Code 
	20786

	AVP Data Type 
	UTF8String
	Length Range: [0,32)

	Vendor ID
	2011

	Description 
	Indicates a uniform sequence number.
	For the manual recharge initiated by the business system, it indicates the sequence number of the external system. For the card recharge initiated by a subscriber through self-service, the value is null.
 */
@DiameterAvpDefinition(code = HuaweiAvpCodes.UNIFORM_SERIAL_NO, vendorId = VendorIDs.HUAWEI_ID, name = "Uniform-Serial-No")
public interface UniformSerialNo extends DiameterUTF8String
{
}