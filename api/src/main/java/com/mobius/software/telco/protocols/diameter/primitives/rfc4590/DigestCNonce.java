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
	3.11.  Digest-CNonce Attribute

   	Description
         This attribute holds the client nonce parameter that is used in
         the HTTP Digest calculation.  It MUST only be used in
         Access-Request packets.
   
   	Type
         113 for Digest-CNonce
   
   	Length
         >=3
   
   	Text
         This attribute includes the value of the cnonce-value [RFC2617]
         without surrounding quotes, taken from the HTTP-style request.
 */
@DiameterAvpDefinition(code = AvpCodes.DIGEST_CNONCE, vendorId = -1, name = "Digest-CNonce")
public interface DigestCNonce extends DiameterUTF8String
{
}