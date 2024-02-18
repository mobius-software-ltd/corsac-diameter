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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;

/**
*
* @author yulian oifa
*
*/
/*
 * 	3.2.331  S-Caller-Short-Number AVP

	AVP Name
	S-Caller-Short-Number

	AVP Code
	21208

	AVP Data Type
	OctetString
	Length Range: [0,16)

	Vendor-ID
	2011

	Description
	If the calling party is a group subscriber in the MO, MT, or MF process, this AVP indicates the short number of the calling party. If the calling party does not have a short number, this AVP is left empty. If the calling party is not a group subscriber, this AVP is also left empty.
 */
@DiameterAvpDefinition(code = HuaweiAvpCodes.S_CALLER_SHORT_NUMBER, vendorId = VendorIDs.HUAWEI_ID, name = "S-Caller-Short-Number")
public interface SCallerShortNumber extends DiameterOctetString
{
}