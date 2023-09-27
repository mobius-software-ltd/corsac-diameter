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
	3.15.  Digest-Auth-Param Attribute

   	Description
         This attribute is a placeholder for future extensions and
         corresponds to the "auth-param" parameter defined in section
         3.2.1 of [RFC2617].  The Digest-Auth-Param is the mechanism
         whereby the RADIUS client and RADIUS server can exchange
         auth-param extension parameters contained within Digest headers
         that are not understood by the RADIUS client and for which
         there are no corresponding stand-alone attributes.

         Unlike the previously listed Digest-* attributes, the
         Digest-Auth-Param contains not only the value but also the
         parameter name, since the parameter name is unknown to the
         RADIUS client.  If the Digest header contains several unknown
         parameters, then the RADIUS implementation MUST repeat this
         attribute and each instance MUST contain one different unknown
         Digest parameter/value combination.  This attribute MUST ONLY
         be used in Access-Request, Access-Challenge, or Access-Accept
         packets.

   	Type
         117 for Digest-Auth-Param
   
   	Length
         >=3
   
   	Text
         The text consists of the whole parameter, including its name
         and the equal sign ('=') and quotes.
 */
@DiameterAvpDefinition(code = 117L, vendorId = -1, name = "Digest-Auth-Param")
public interface DigestAuthParam extends DiameterUTF8String
{
}