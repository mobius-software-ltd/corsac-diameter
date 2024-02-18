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
 * 4.6.  Location-Capable Attribute

   The Location-Capable Attribute allows an NAS (or client function of a
   proxy server) to indicate support for the functionality specified in
   this document.  The Location-Capable Attribute with the value for
   'Location Capable' MUST be sent with the Access-Request messages, if
   the NAS supports the functionality described in this document and is
   capable of sending location information.  A RADIUS server MUST NOT
   challenge for location information unless the Location-Capable
   Attribute has been sent to it.

      0                   1                   2                   3
      0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1
     +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
     | Type          | Length        | Integer                       |
     +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
     |       Integer (cont.)         |
     +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+

   Type:

      131 - Location-Capable Attribute

   Length:

      6
 */
@DiameterAvpDefinition(code = AvpCodes.LOCATION_CAPABLE, vendorId = -1L, name = "Location-Capable")
public interface LocationCapable extends DiameterOctetString
{
}