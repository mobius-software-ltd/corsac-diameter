package com.mobius.software.telco.protocols.diameter.primitives.gi;
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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;

/**
*
* @author yulian oifa
*
*/

/*
	23 - 3GPP-MS-TimeZone
	The Time Zone field and the Daylight Saving Time fields are used to indicate the offset between universal time and
	local time in steps of 15 minutes of where the MS current resides. 
	Both fields are coded as specified in 3GPP TS 29.060 [24] and represented as Octet String type. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.TGPP_MS_TIMEZONE, vendorId = VendorIDs.TGPP_ID, must = false, name = "3GPP-MSTimeZone")
public interface TGPPMSTimeZone extends DiameterOctetString
{
}