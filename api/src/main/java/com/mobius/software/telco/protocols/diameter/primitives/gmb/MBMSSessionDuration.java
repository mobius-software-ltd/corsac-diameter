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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	17.7.7	MBMS-Session-Duration AVP
	The MBMS-Session-Duration AVP (AVP code 904) is of type OctetString with a length of three octets and indicates the estimated session duration (MBMS Service data transmission). Bit 8 of octet 1 to bit 8 of octet 3 (17 bits) express seconds, for which the maximum allowed value is 86400 seconds. Bits 7 to 1 of octet 3 (7 bits) express days, for which the maximum allowed value is 18 days. The coding is as follows (the ‘s’ bits represent the seconds, the ‘d’ bits represent the days):



	Bits							Octets
	8   7   6   5   4   3   2   1   
	s	s	s	s	s	s	s	s	1
	s	s	s	s	s	s	s	s	2
	s	d	d	d	d	d	d	d	3

	For the whole session duration the seconds and days are added together and the maximum session duration is 19 days.
	The lowest value of this AVP (i.e. all 0’s), is reserved to indicate an indefinite value to denote sessions that are expected to be always-on.
 */
@DiameterAvpDefinition(code = 904L, vendorId = KnownVendorIDs.TGPP_ID, name = "MBMS-Session-Duration")
public interface MBMSSessionDuration extends DiameterOctetString
{
}