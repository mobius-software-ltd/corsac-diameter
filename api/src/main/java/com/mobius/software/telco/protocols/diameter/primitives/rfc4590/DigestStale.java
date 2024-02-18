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
	3.18.  Digest-Stale Attribute

   	Description
         This attribute is sent by a RADIUS server in order to notify
         the RADIUS client whether it has accepted a nonce.  If the
         nonce presented by the RADIUS client was stale, the value is
         'true' and is 'false' otherwise.  The RADIUS client puts the
         content of this attribute into a 'stale' directive of the
         WWW-Authenticate header in the HTTP-style response to the
         request it wants to authenticate.  The attribute MUST only be
         used in Access-Challenge packets.
   
   	Type
         120 for Digest-Stale
   
   	Length
         3
   
   	Text
         The attribute has either the value 'true' or 'false' (both
         values without surrounding quotes).
 */
@DiameterAvpDefinition(code = AvpCodes.DIGEST_STATE, vendorId = -1, name = "Digest-Stale")
public interface DigestStale extends DiameterUTF8String
{
}