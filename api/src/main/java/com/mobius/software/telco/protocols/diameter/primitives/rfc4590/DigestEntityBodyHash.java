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
	3.10.  Digest-Entity-Body-Hash Attribute

   	Description
         When using the qop-level 'auth-int', a hash of the HTTP-style
         message body's contents is required for digest calculation.
         Instead of sending the complete body of the message, only its
         hash value is sent.  This hash value can be used directly in
         the digest calculation.

         The clarifications described in section 22.4 of [RFC3261] about
         the hash of empty entity bodies apply to the
         Digest-Entity-Body-Hash attribute.  This attribute MUST only be
         sent in Access-Request packets.
   
   	Type
         112 for Digest-Entity-Body-Hash
   
   	Length
         >=3
   
   	Text
         The attribute holds the hexadecimal representation of
         H(entity-body).  This hash is required by certain
         authentication mechanisms, such as HTTP Digest with quality of
         protection set to "auth-int".  RADIUS clients MUST use this
         attribute to transport the hash of the entity body when HTTP
         Digest is the authentication mechanism and the RADIUS server
         requires that the integrity of the entity body (e.g., qop
         parameter set to "auth-int") be verified.  Extensions to this
         document may define support for authentication mechanisms other
         than HTTP Digest.
 */
@DiameterAvpDefinition(code = AvpCodes.DIGEST_ENTITY_BODY_HASH, vendorId = -1, name = "Digest-Entity-Body-Hash")
public interface DigestEntityBodyHash extends DiameterUTF8String
{
}