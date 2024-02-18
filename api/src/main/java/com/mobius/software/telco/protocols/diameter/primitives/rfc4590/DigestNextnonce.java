package com.mobius.software.telco.protocols.diameter.primitives.rfc4590;
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

import com.mobius.software.telco.protocols.diameter.AvpCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;

/**
*
* @author yulian oifa
*
*/

/*
	3.5.  Digest-Nextnonce Attribute

   	This attribute holds a nonce to be used in the HTTP Digest
   	calculation.

   	Description

         The RADIUS server MAY put a Digest-Nextnonce attribute into an
         Access-Accept packet.  If this attribute is present, the RADIUS
         client MUST put the contents of this attribute into the
         nextnonce directive of an Authentication-Info header in its
         HTTP-style response.  This attribute MUST only be used in
         Access-Accept packets.
   	Type
         107 for Digest-Nextnonce
   	Length
         >=3
   	Text
         It is recommended that this text be base64 or hexadecimal data.
 */
@DiameterAvpDefinition(code = AvpCodes.DIGEST_NEXT_NONCE, vendorId = -1, name = "Digest-Nextnonce")
public interface DigestNextnonce extends DiameterUTF8String
{
}