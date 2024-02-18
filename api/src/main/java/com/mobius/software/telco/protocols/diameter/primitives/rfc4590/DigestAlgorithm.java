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
	3.9.  Digest-Algorithm Attribute

   	Description
         This attribute holds the algorithm parameter that influences
         the HTTP Digest calculation.  It MUST only be used in
         Access-Request and Access-Challenge packets.  If this attribute
         is missing, MD5 is assumed.
   
   	Type
         111 for Digest-Algorithm
   
   	Length
         >=3
   
   	Text
         In Access-Requests, the RADIUS client takes the value of the
         algorithm directive (as described in [RFC2617], section 3.2.1)
         from the HTTP-style request it wants to authenticate.  In
         Access-Challenge packets, the RADIUS server SHOULD put the
         desired algorithm into this attribute.
 */
@DiameterAvpDefinition(code = AvpCodes.DIGEST_ALGORITHM, vendorId = -1, name = "Digest-Algorithm")
public interface DigestAlgorithm extends DiameterUTF8String
{
}