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
	3.14.  Digest-Opaque Attribute

   	Description
         This attribute holds the opaque parameter that is passed to the
         HTTP-style client.  The HTTP-style client will pass this value
         back to the server (i.e., the RADIUS client) without
         modification.  This attribute MUST only be used in
         Access-Request and Access-Challenge packets.
   
   	Type
         116 for Digest-Opaque
   
   	Length
         >=3
   
   	Text
         In Access-Requests, the RADIUS client takes the value of the
         opaque directive (opaque-value according to [RFC2617]) without
         surrounding quotes from the HTTP-style request it wants to
         authenticate and puts it into this attribute.  In
         Access-Challenge packets, the RADIUS server MAY include this
         attribute.
 */
@DiameterAvpDefinition(code = 116L, vendorId = -1, name = "Digest-Opaque")
public interface DigestOpaque extends DiameterUTF8String
{
}