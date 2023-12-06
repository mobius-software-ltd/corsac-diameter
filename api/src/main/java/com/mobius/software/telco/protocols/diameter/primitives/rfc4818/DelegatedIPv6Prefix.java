package com.mobius.software.telco.protocols.diameter.primitives.rfc4818;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;

/**
*
* @author yulian oifa
*
*/

/*
	The format of the Delegated-IPv6-Prefix is:

       0                   1                   2                   3
       0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1
      +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
      |     Type      |    Length     |  Reserved     | Prefix-Length |
      +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
                                   Prefix
      +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
                                   Prefix
      +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
                                   Prefix
      +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
                                   Prefix                             |
      +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+

      Type

           123 for Delegated-IPv6-Prefix

      Length

           The length of the entire attribute, in bytes.  At least 4 (to
           hold Type/Length/Reserved/Prefix-Length for a 0-bit prefix),
           and no larger than 20 (to hold Type/Length/ Reserved/Prefix-
           Length for a 128-bit prefix)

      Reserved

           Always set to zero by sender; ignored by receiver

      Prefix-Length

           The length of the prefix being delegated, in bits.  At least
           0 and no larger than 128 bits (identifying a single IPv6
           address)

   	Note that the prefix field is only required to be long enough to hold
   	the prefix bits and can be shorter than 16 bytes.  Any bits in the
   	prefix field that are not part of the prefix MUST be zero.

   	The Delegated-IPv6-Prefix MAY appear in an Access-Accept packet, and
   	can appear multiple times.  It MAY appear in an Access-Request packet
   	as a hint by the NAS to the server that it would prefer these
   	prefix(es), but the server is not required to honor the hint.
 */
@DiameterAvpDefinition(code = 123L, vendorId = -1, name = "Delegated-IPv6-Prefix")
public interface DelegatedIPv6Prefix extends DiameterOctetString
{
}