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
	3.19.  Digest-HA1 Attribute

  	Description
         This attribute is used to allow the generation of an
         Authentication-Info header, even if the HTTP-style response's
         body is required for the calculation of the rspauth value.  It
         SHOULD be used in Access-Accept packets if the required quality
         of protection ('qop') is 'auth-int'.

         This attribute MUST NOT be sent if the qop parameter was not
         specified or has a value of 'auth' (in this case, use
         Digest-Response-Auth instead).

         The Digest-HA1 attribute MUST only be sent by the RADIUS server
         or processed by the RADIUS client if at least one of the
         following conditions is true:

         +  The Digest-Algorithm attribute's value is 'MD5-sess' or
            'AKAv1-MD5-sess'.

         +  IPsec is configured to protect traffic between RADIUS client
            and RADIUS server with IPsec (see Section 8).

         This attribute MUST only be used in Access-Accept packets.
   	Type
         121 for Digest-HA1
   
   	Length
         >= 3

   	Text
         This attribute contains the hexadecimal representation of H(A1)
         as described in [RFC2617], sections 3.1.3, 3.2.1, and 3.2.2.2.
 */
@DiameterAvpDefinition(code = AvpCodes.DIGEST_HA1, vendorId = -1, name = "Digest-HA1")
public interface DigestHA1 extends DiameterUTF8String
{
}