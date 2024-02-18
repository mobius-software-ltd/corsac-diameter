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
 * 	3.2.152  SM-Id AVP

	AVP Name
	SM-Id

	AVP Code
	20402

	AVP Data Type
	UTF8String
	Length Range: (0,63]

	Vendor ID
	2011

	Description
	ID that uniquely identifies a short message. In the SMS refund process, the OCS system uses the ID of a short message to determine which subscriber needs to be refunded.
	The uniqueness of this parameter is guaranteed by the generating party.
 */
@DiameterAvpDefinition(code = HuaweiAvpCodes.SM_ID, vendorId = VendorIDs.HUAWEI_ID, name = "SM-Id")
public interface SMId extends DiameterUTF8String
{
}