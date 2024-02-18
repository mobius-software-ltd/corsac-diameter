package com.mobius.software.telco.protocols.diameter.primitives.nas;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;

/**
*
* @author yulian oifa
*
*/
/*
 * 4.3.1.  User-Password AVP

   The User-Password AVP (AVP Code 2) is of type OctetString and
   contains the password of the user to be authenticated or the user's
   input in a multi-round authentication exchange.

   The User-Password AVP contains a user password or one-time password
   and therefore represents sensitive information.  As required by the
   Diameter Base protocol [RFC6733], Diameter messages are encrypted by
   using IPsec [RFC4301] or Transport Layer Security (TLS) [RFC5246].
   Unless this AVP is used for one-time passwords, the User-Password AVP
   SHOULD NOT be used in untrusted proxy environments without encrypting
   it by using end-to-end security techniques.

   The clear-text password (prior to encryption) MUST NOT be longer than
   128 bytes in length.
 */
@DiameterAvpDefinition(code = AvpCodes.USER_PASSWORD, vendorId = -1L, name = "User-Password")
public interface UserPassword extends DiameterOctetString
{
}