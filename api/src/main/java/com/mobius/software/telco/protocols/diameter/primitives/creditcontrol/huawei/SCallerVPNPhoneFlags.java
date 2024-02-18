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
 * 	3.2.333  S-Caller-VPN-Phone-Flags AVP

	AVP Name
	S-Caller-VPN-Phone-Flags

	AVP Code
	21210

	AVP Data Type
	OctetString
	Length Range: [0,64)

	Vendeor-ID
	2011

	Description
	In the MO, MT, or MF process, the value of this AVP is fixed to the calling party information. If the calling party is not a group subscriber, this AVP is left empty.
	First digit: On-net or super group call display mode.
	    - 0: display short number
	    - 1: display long number

	Second to fourth digits: 0
	
	Fifth-digit: User type.
	    - 0: common user
	    - 1: manager
	    - 2: attendant
	    - 3: manager+attendant

	Sixth digit: 0
	
	Seventh digit: Whether has joined a hunting list.
	    - 0: No
	    - 1: Yes

	Eighth to ninth digits: 0
	
	Tenth digit: IVR notification mode for individual payment.
	    - 0: No notification
	    - 1: Only once
	    - 2: Every time

	Eleventh digit: USSD notification mode for individual payment.
	    - 0: No notification
	    - 1: Only once
	    - 2: Every time

	Set all the other digits to 0.
 */
@DiameterAvpDefinition(code = HuaweiAvpCodes.S_CALLER_VPPN_PHONE_FLAGS, vendorId = VendorIDs.HUAWEI_ID, name = "S-Caller-VPN-Phone-Flags")
public interface SCallerVPNPhoneFlags extends DiameterOctetString
{
}