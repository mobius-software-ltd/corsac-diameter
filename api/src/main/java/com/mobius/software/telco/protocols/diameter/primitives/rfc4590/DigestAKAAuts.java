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
	3.16.  Digest-AKA-Auts Attribute

   	Description
         This attribute holds the auts parameter that is used in the
         Digest AKA ([RFC3310]) calculation.  It is only used if the
         algorithm of the digest-response denotes a version of AKA
         Digest [RFC3310].  This attribute MUST only be used in
         Access-Request packets.
   
   	Type
         118 for Digest-AKA-Auts
   
   	Length
         >=3
   
   	Text
         In Access-Requests, the RADIUS client takes the value of the
         auts directive (auts-param according to section 3.4 of
         [RFC3310]) without surrounding quotes from the HTTP-style
         request it wants to authenticate.
 */
@DiameterAvpDefinition(code = AvpCodes.DIGEST_AKA_AUTS, vendorId = -1, name = "Digest-AKA-Auts")
public interface DigestAKAAuts extends DiameterUTF8String
{
}