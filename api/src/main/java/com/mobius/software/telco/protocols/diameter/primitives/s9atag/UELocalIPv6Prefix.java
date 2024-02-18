package com.mobius.software.telco.protocols.diameter.primitives.s9atag;
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
 * 	A.8.3.1.1	UE-Local-IPv6-Prefix AVP
	The UE-Local-IPv6-Prefix AVP (AVP code 2205) is of type OctetString, and it indicates the UE local IPv6 prefix allocated to the user. The encoding of the value within this AVP shall be as defined for Framed-IPv6-Prefix AVP in IETF RFC 3162 [15], clause 2.3. The "Reserved", "Prefix-Length" and "Prefix" fields shall be included in this order.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.UE_LOCAL_IPV6_PREFIX, vendorId = VendorIDs.TGPP_ID, name = "UE-Local-IPv6-Prefix")
public interface UELocalIPv6Prefix extends DiameterOctetString
{
}