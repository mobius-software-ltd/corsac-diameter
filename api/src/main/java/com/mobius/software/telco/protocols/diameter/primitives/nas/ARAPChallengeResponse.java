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
 * 4.3.10.  ARAP-Challenge-Response AVP

   The ARAP-Challenge-Response AVP (AVP Code 84) is of type OctetString
   and is only present when the Framed-Protocol AVP (Section 4.4.10.1)
   is included in the message and is set to ARAP.  This AVP contains an
   8-octet response to the dial-in client's challenge.  The Diameter
   server calculates this value by taking the dial-in client's challenge
   from the high-order 8 octets of the ARAP-Password AVP and performing
   DES encryption on this value with the authenticating user's password
   as the key.  If the user's password is fewer than 8 octets in length,
   the password is padded at the end with NULL octets to a length of 8
   before it is used as a key.
 */
@DiameterAvpDefinition(code = AvpCodes.ARAP_CHALLENGE_RESPONSE, vendorId = -1L, name = "ARAP-Challenge-Response")
public interface ARAPChallengeResponse extends DiameterOctetString
{
}