package com.mobius.software.telco.protocols.diameter.primitives.pc6;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	6.3.11	MAC-Address
	The MAC-Address AVP is of type UTF8String and it shall contain a 6-octet MAC address used as link layer identifier for discovery and communication. It shall be encoded in upper-case ASCII characters with the octet values separated by dash characters. It shall contain a string of 17 octets. Example: "00-10-A4-23-19-C0". 
 */
@DiameterAvpDefinition(code = 3806L, vendorId = KnownVendorIDs.TGPP_ID, name = "MAC-Address")
public interface MACAddress extends DiameterUTF8String
{
}