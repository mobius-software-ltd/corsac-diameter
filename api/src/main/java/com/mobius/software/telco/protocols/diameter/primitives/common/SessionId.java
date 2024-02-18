package com.mobius.software.telco.protocols.diameter.primitives.common;
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
 * 8.8.  Session-Id AVP

   The Session-Id AVP (AVP Code 263) is of type UTF8String and is used
   to identify a specific session (see Section 8).  All messages
   pertaining to a specific session MUST include only one Session-Id
   AVP, and the same value MUST be used throughout the life of a
   session.  When present, the Session-Id SHOULD appear immediately
   following the Diameter header (see Section 3).

   The Session-Id MUST be globally and eternally unique, as it is meant
   to uniquely identify a user session without reference to any other
   information, and it may be needed to correlate historical
   authentication information with accounting information.  The
   Session-Id includes a mandatory portion and an implementation-defined
   portion; a recommended format for the implementation-defined portion
   is outlined below.

   The Session-Id MUST begin with the sender's identity encoded in the
   DiameterIdentity type (see Section 4.3.1).  The remainder of the
   Session-Id is delimited by a ";" character, and it MAY be any
   
   sequence that the client can guarantee to be eternally unique;
   however, the following format is recommended, (square brackets []
   indicate an optional element):

      <DiameterIdentity>;<high 32 bits>;<low 32 bits>[;<optional value>]

   <high 32 bits> and <low 32 bits> are decimal representations of the
   high and low 32 bits of a monotonically increasing 64-bit value.  The
   64-bit value is rendered in two part to simplify formatting by 32-bit
   processors.  At startup, the high 32 bits of the 64-bit value MAY be
   initialized to the time in NTP format [RFC5905], and the low 32 bits
   MAY be initialized to zero.  This will for practical purposes
   eliminate the possibility of overlapping Session-Ids after a reboot,
   assuming the reboot process takes longer than a second.
   Alternatively, an implementation MAY keep track of the increasing
   value in non-volatile memory.


   <optional value> is implementation specific, but it may include a
   modem's device Id, a Layer 2 address, timestamp, etc.

   Example, in which there is no optional value:

      accesspoint7.example.com;1876543210;523

   Example, in which there is an optional value:

     accesspoint7.example.com;1876543210;523;mobile@200.1.1.88

   The Session-Id is created by the Diameter application initiating the
   session, which, in most cases, is done by the client.  Note that a
   Session-Id MAY be used for both the authentication, authorization,
   and accounting commands of a given application.
 */
@DiameterAvpDefinition(code = AvpCodes.SESSION_ID, vendorId = -1L, name = "Session-Id")
public interface SessionId extends DiameterUTF8String
{
}