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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	3.2.334  S-Caller-PBX-Display-Number AVP

	AVP Name
	S-Caller-PBX-Display-Number

	AVP Code
	21211

	AVP Data Type
	OctetString
	Length Range: [0,32)

	Vendor-ID
	2011

	Description
	In the MO, MT, or MF process, this AVP indicates the number displayed to the called party when the calling number is a PBX switchboard number and an incoming call is received. If the calling party is not a group subscriber, this AVP is left empty.
 */
@DiameterAvpDefinition(code = 21211L, vendorId = KnownVendorIDs.HUAWEI_ID, name = "S-Caller-PBX-Display-Number")
public interface SCallerPBXDisplayNumber extends DiameterOctetString
{
}