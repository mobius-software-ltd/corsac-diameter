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
	3.3.  Digest-Nonce Attribute

   Description

         This attribute holds a nonce to be used in the HTTP Digest
         calculation.  If the Access-Request had a Digest-Method and a
         Digest-URI but no Digest-Nonce attribute, the RADIUS server
         MUST put a Digest-Nonce attribute into its Access-Challenge
         packet.  This attribute MUST only be used in Access-Request and
         Access-Challenge packets.
   Type
         105 for Digest-Nonce
   Length
         >=3
   Text
         In Access-Requests, the RADIUS client takes the value of the
         nonce directive (nonce-value in [RFC2617]) without surrounding
         quotes from the HTTP-style request it wants to authenticate.
         In Access-Challenge packets, the attribute contains the nonce
         selected by the RADIUS server.
 */
@DiameterAvpDefinition(code = AvpCodes.DIGEST_NONCE, vendorId = -1, name = "Digest-Nonce")
public interface DigestNonce extends DiameterUTF8String
{
}