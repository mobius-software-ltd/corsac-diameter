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
	3.1.  Digest-Response attribute

   	Description
         If this attribute is present in an Access-Request message, a
         RADIUS server implementing this specification MUST treat the
         Access-Request as a request for Digest Authentication.  When a
         RADIUS client receives a (Proxy-)Authorization header, it puts
         the request-digest value into a Digest-Response attribute.
         This attribute (which enables the user to prove possession of
         the password) MUST only be used in Access-Requests.
   	Type
         103 for Digest-Response.
   	Length
         >= 3
   	Text
         When using HTTP Digest, the text field is 32 octets long and
         contains a hexadecimal representation of a 16-octet digest
         value as it was calculated by the authenticated client.  Other
         digest algorithms MAY define different digest lengths.  The
         text field MUST be copied from request-digest of
         digest-response ([RFC2617]) without surrounding quotes.
 */
@DiameterAvpDefinition(code = 103L, vendorId = -1, name = "Digest-Response")
public interface DigestResponse extends DiameterUTF8String
{
}