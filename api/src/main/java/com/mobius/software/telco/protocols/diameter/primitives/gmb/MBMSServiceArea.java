package com.mobius.software.telco.protocols.diameter.primitives.gmb;
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
	17.7.6	MBMS-Service-Area AVP
	The MBMS-Service-Area AVP (AVP code 903) is of type OctetString, and indicates the area over which the MBMS bearer service has to be distributed. The AVP consists of the following parts:

	Octet

	1 Number N of MBMS service area codes coded as:
	1	binary value is ‘00000000’


	256	binary value is '11111111'
	2-(2N+1)
	A consecutive list of N MBMS service area codes

	The MBMS service area code represents the coding for the MBMS Service Area Identity.
	The MBMS Service Area Identity and its semantics are defined in subclause 15.3 of 3GPP TS 23.003 [40].
	The length of an MBMS service area code is 2 octets.
	Each MBMS service area code shall only be present once in the list.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MBMS_SERVICE_AREA, vendorId = VendorIDs.TGPP_ID, name = "MBMS-Service-Area")
public interface MBMSServiceArea extends DiameterOctetString
{
}