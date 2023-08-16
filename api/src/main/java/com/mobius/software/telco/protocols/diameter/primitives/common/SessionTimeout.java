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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/
/*
 * 8.13.  Session-Timeout AVP

   The Session-Timeout AVP (AVP Code 27) [RFC2865] is of type Unsigned32
   and contains the maximum number of seconds of service to be provided
   to the user before termination of the session.  When both the
   Session-Timeout and the Authorization-Lifetime AVPs are present in an
   answer message, the former MUST be equal to or greater than the value
   of the latter.

   A session that terminates on an access device due to the expiration
   of the Session-Timeout MUST cause an STR to be issued, unless both
   the access device and the home server had previously agreed that no
   session termination messages would be sent (see Section 8).

   A Session-Timeout AVP MAY be present in a re-authorization answer
   message, and it contains the remaining number of seconds from the
   beginning of the re-auth.

   A value of zero, or the absence of this AVP, means that this session
   has an unlimited number of seconds before termination.

   This AVP MAY be provided by the client as a hint of the maximum
   timeout that it is willing to accept.  However, the server MAY return
   a value that is equal to, or smaller than, the one provided by the
   client.
 */
@DiameterAvpDefinition(code = 27L, vendorId = -1L, name = "Session-Timeout")
public interface SessionTimeout extends DiameterUnsigned32
{
}