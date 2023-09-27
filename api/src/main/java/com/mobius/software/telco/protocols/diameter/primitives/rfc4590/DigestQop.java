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
	3.8.  Digest-Qop Attribute

   	Description
         This attribute holds the Quality of Protection parameter that
         influences the HTTP Digest calculation.  This attribute MUST
         only be used in Access-Request and Access-Challenge packets.  A
         RADIUS client SHOULD insert one of the Digest-Qop attributes it
         has received in a previous Access-Challenge packet.  RADIUS
         servers SHOULD insert at least one Digest-Qop attribute in an
         Access-Challenge packet.  Digest-Qop is optional in order to
         preserve backward compatibility with a minimal implementation
         of [RFC2069].
   
   	Type
         110 for Digest-Qop
   
   	Length
         >=3
   
   	Text
         In Access-Requests, the RADIUS client takes the value of the
         qop directive (qop-value as described in [RFC2617]) from the
         HTTP-style request it wants to authenticate.  In
         Access-Challenge packets, the RADIUS server puts a desired
         qop-value into this attribute.  If the RADIUS server supports
         more than one "quality of protection" value, it puts each
         qop-value into a separate Digest-Qop attribute.
 */
@DiameterAvpDefinition(code = 110L, vendorId = -1, name = "Digest-Qop")
public interface DigestQop extends DiameterUTF8String
{
}