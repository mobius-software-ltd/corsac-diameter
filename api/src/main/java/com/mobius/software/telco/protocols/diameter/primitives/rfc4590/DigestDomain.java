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
	3.17.  Digest-Domain Attribute

   	Description
         When a RADIUS client has asked for a nonce, the RADIUS server
         MAY send one or more Digest-Domain attributes in its
         Access-Challenge packet.  The RADIUS client puts them into the
         quoted, space-separated list of URIs of the 'domain' directive
         of a WWW-Authenticate header.  Together with Digest-Realm, the
         URIs in the list define the protection space (see [RFC2617],
         section 3.2.1) for some HTTP-style protocols.  This attribute
         MUST only be used in Access-Challenge packets.
   
   	Type
         119 for Digest-Domain
   
   	Length
         3
   
   	Text
         This attribute consists of a single URI that defines a
         protection space component.
 */
@DiameterAvpDefinition(code = AvpCodes.DIGEST_DOMAIN, vendorId = -1, name = "Digest-Domain")
public interface DigestDomain extends DiameterUTF8String
{
}