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
	3.2.  Digest-Realm Attribute

   Description
         This attribute describes a protection space component of the
         RADIUS server.  HTTP-style protocols differ in their definition
         of the protection space.  See [RFC2617], Section 1.2, for
         details.  It MUST only be used in Access-Request and
         Access-Challenge packets.
   Type
         104 for Digest-Realm
   Length
         >=3
   Text
         In Access-Requests, the RADIUS client takes the value of the
         realm directive (realm-value according to [RFC2617]) without
         surrounding quotes from the HTTP-style request it wants to
         authenticate.  In Access-Challenge packets, the RADIUS server
         puts the expected realm value into this attribute.
 */
@DiameterAvpDefinition(code = 104L, vendorId = -1, name = "Digest-Realm")
public interface DigestRealm extends DiameterUTF8String
{
}