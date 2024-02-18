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
 * 4.5.  Extended-Location-Policy-Rules Attribute

   The Extended-Location-Policy-Rules Attribute MAY be sent in Access-
   Request, Access-Accept, Access-Challenge, Access-Reject, Change-of-
   Authorization, and Accounting-Request messages.

   The Ruleset Reference field of this attribute is of variable length.
   It contains a URI that indicates where the richer ruleset can be
   found.  This URI SHOULD use the HTTPS URI scheme.  As a deviation
   from [RFC4119], this field only contains a reference and does not
   carry an attached, extended ruleset.  This modification is motivated
   by the size limitations imposed by RADIUS.

   In order to understand and process the Extended-Location-Policy-Rules
   Attribute, RADIUS clients are obligated to attach the URI to the
   Extended-Location-Policy-Rules Attribute when they are explicitly
   configured to do so, and to echo the Extended-Location-Policy-Rules
   Attribute that they receive from a server.  There is no expectation
   that RADIUS clients will need to retrieve data at the URL specified
   in the attribute or to parse the XML policies.

   The format of the Extended-Location-Policy-Rules Attribute is shown
   below.

      0                   1                   2                   3
      0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1
     +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
     |     Type      |    Length     |            String            ...
     +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
     |       String (cont.)                                         ...
     +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+

   Type:

      130 - Extended-Location-Policy-Rules

   Length:

      >= 3
 */
@DiameterAvpDefinition(code = AvpCodes.EXTENDED_LOCATION_POLICY_RULES, vendorId = -1L, name = "Extended-Location-Policy-Rules")
public interface ExtendedLocationPolicyRules extends DiameterOctetString
{
}