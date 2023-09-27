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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;

/**
*
* @author yulian oifa
*
*/

/*
	3.4.  Digest-Response-Auth Attribute

   	Description
         This attribute enables the RADIUS server to prove possession of
         the password.  If the previously received Digest-Qop attribute
         was 'auth-int' (without surrounding quotes), the RADIUS server
         MUST send a Digest-HA1 attribute instead of a
         Digest-Response-Auth attribute.  The Digest-Response-Auth
         attribute MUST only be used in Access-Accept packets.  The
         RADIUS client puts the attribute value without surrounding
         quotes into the rspauth directive of the Authentication-Info
         header.
   	Type
         106 for Digest-Response-Auth.
   	Length
         >= 3
   	Text
         The RADIUS server calculates a digest according to section
         3.2.3 of [RFC2617] and copies the result into this attribute.
         Digest algorithms other than the one defined in [RFC2617] MAY
         define digest lengths other than 32.
 */
@DiameterAvpDefinition(code = 106L, vendorId = -1, name = "Digest-Response-Auth")
public interface DigestResponseAuth extends DiameterUTF8String
{
}