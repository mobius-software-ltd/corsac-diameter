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
 * 	3.2.103  Called-Party-Address AVP
	
	AVP Name
	Called-Party-Address

	AVP Code
	20337

	AVP Data Type
	UTF8String
	Length Range: [0,63)

	Vendor ID
	2011

	Description
	Indicates the called number.

	The called number is reported by the SSP, that is, fill the number which dialed by the subscriber. In the forwarding process, the number reported by the SSP is a forwarding number.
	In this version, the formats of a called number are as follows:
    	- International prefix + Country code + Area number + PSTN
    	- Area number + PSTN

	The number format for the MVNO function: CC + MSISDN, and CC is the code of a country where the OCG system located.
 */
@DiameterAvpDefinition(code = HuaweiAvpCodes.CALLED_PARTY_ADDRESS, vendorId = VendorIDs.HUAWEI_ID, name = "Called-Party-Address")
public interface CalledPartyAddress extends DiameterUTF8String
{
}