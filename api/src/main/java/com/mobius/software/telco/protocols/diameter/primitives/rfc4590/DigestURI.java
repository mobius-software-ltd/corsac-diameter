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
	3.7.  Digest-URI Attribute

   	Description
         This attribute is used to transport the contents of the
         digest-uri directive or the URI of the HTTP-style request.  It
         MUST only be used in Access-Request packets.
   
   	Type
         109 for Digest-URI
   
   	Length
         >=3
   
   	Text
         If the HTTP-style request has an Authorization header, the
         RADIUS client puts the value of the "uri" directive found in
         the HTTP-style request Authorization header (known as
         "digest-uri-value" in section 3.2.2 of [RFC2617]) without
         surrounding quotes into this attribute.  If there is no
         Authorization header, the RADIUS client takes the value of the
         request URI from the HTTP-style request it wants to
         authenticate.
 */
@DiameterAvpDefinition(code = AvpCodes.DIGEST_URI, vendorId = -1, name = "Digest-URI")
public interface DigestURI extends DiameterUTF8String
{
}