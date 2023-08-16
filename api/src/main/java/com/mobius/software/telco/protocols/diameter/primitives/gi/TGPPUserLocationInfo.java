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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	22 - 3GPP-User-Location-Info
	Length=m, where m depends on the Geographic Location Type
 	For example, m= 10 in the CGI and SAI types.
	Geographic Location Type field is used to convey what type of location information is present in the 'Geographic
	Location' field. For GGSN, the Geographic Location Type values and coding are as defined in 3GPP TS 29.060 [24].
	For P-GW, the Geographic Location Type values and coding are defined in 3GPP TS 29.274 [81].
	Geographic Location field is used to convey the actual geographic information as indicated in the Geographic Location
	Type. For GGSN, the coding of this field is as specified in 3GPP TS 29.060 [24]. For P-GW, the coding of this field is
	as specified in 3GPP TS 29.274 [81].
	Geographic Location Type and Geographic Location fields are Octet String type. 
*/
@DiameterAvpDefinition(code = 22L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "3GPP-UserLocation-Info")
public interface TGPPUserLocationInfo extends DiameterOctetString
{
}