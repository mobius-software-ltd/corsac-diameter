package com.mobius.software.telco.protocols.diameter.primitives.rfc5580;
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
 * 4.7.  Requested-Location-Info Attribute

   The Requested-Location-Info Attribute allows the RADIUS server to
   indicate which location information about which entity it wants to
   receive.  The latter aspect refers to the entities that are indicated
   in the Entity field of the Location-Information Attribute.
   
   The Requested-Location-Info Attribute MUST be sent by the RADIUS
   server, in the absence of an out-of-band agreement, if it wants the
   RADIUS client to return location information and if authorization
   policies permit it.  This Requested-Location-Info Attribute MAY
   appear in the Access-Accept or in the Access-Challenge message.

   A summary of the attribute is shown below.

      0                   1                   2                   3
      0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1
     +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
     |     Type      |    Length     |            Integer           ...
     +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
     |       Integer (cont.)         |
     +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+

   Type:

      132 - Requested-Location-Info Attribute

   Length:

      6

   Integer:

      The content of the Integer field encodes the requested information
      attributes.  Each capability value represents a bit position.
 */
@DiameterAvpDefinition(code = AvpCodes.REQUESTED_LOCATION_INFO, vendorId = -1L, name = "Requested-Location-Info")
public interface RequestedLocationInfo extends DiameterOctetString
{
}