package com.mobius.software.telco.protocols.diameter.primitives.gx;
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
 * 	5.3.15 ToS-Traffic-Class AVP (All access types)
	The ToS-Traffic-Class AVP (AVP code 1014) is of type OctetString, and is encoded on two octets. The first octet
	contains the Ipv4 Type-of-Service or the Ipv6 Traffic-Class field and the second octet contains the ToS/Traffic Class
	mask field. One example is that of a TFT packet filter as defined in 3GPP TS 24.008 [13]. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.TOS_TRAFFIC_CLASS, vendorId = VendorIDs.TGPP_ID, name = "ToS-Traffic-Class")
public interface ToSTrafficClass extends DiameterOctetString
{
}