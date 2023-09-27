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
	3.12.  Digest-Nonce-Count Attribute

   	Description
         This attribute includes the nonce count parameter that is used
         to detect replay attacks.  The attribute MUST only be used in
         Access-Request packets.

   	Type
         114 for Digest-Nonce-Count
   
   	Length
         10
   
   	Text
         In Access-Requests, the RADIUS client takes the value of the nc
         directive (nc-value according to [RFC2617]) without surrounding
         quotes from the HTTP-style request it wants to authenticate.
 */
@DiameterAvpDefinition(code = 114L, vendorId = -1, name = "Digest-Nonce-Count")
public interface DigestNonceCount extends DiameterUTF8String
{
}