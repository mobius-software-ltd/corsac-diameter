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
 * 4.4.  Basic-Location-Policy-Rules Attribute

   The Basic-Location-Policy-Rules Attribute MAY be sent in Access-
   Request, Access-Accept, Access-Challenge, Change-of-Authorization,
   and Accounting-Request messages.

   Policy rules control the distribution of location information.  In
   order to understand and process the Basic-Location-Policy-Rules
   Attribute, RADIUS clients are obligated to utilize a default value of
   Basic-Location-Policy-Rules, unless explicitly configured otherwise,
   and to echo the Basic-Location-Policy-Rules Attribute that they
   receive from a server.  As a default, the Note Well field does not
   carry a pointer to human-readable privacy policies, the
   retransmission-allowed is set to zero (0), i.e., further distribution
   is not allowed, and the Retention Expires field is set to 24 hours.

   With regard to authorization policies, this document reuses work done
   in [RFC4119] and encodes those policies in a non-XML format.  Two
   fields ('Sighting Time' and 'Time-to-Live') are additionally included
   in the Location-Information Attribute to conform to the GEOPRIV
   requirements [RFC3693], Section 2.7.

   The format of the Basic-Location-Policy-Rules Attribute is shown
   below.

      0                   1                   2                   3
      0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1
     +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
     |     Type      |    Length     |            String            ...
     +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
     |       String (cont.)                                         ...
     +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+

   Type:

      129 - Basic-Location-Policy-Rules

   Length:

      >= 12
 */
@DiameterAvpDefinition(code = AvpCodes.BASIC_LOCATION_POLICY_RULES, vendorId = -1L, name = "Basic-Location-Policy-Rules")
public interface BasicLocationPolicyRules extends DiameterOctetString
{
}