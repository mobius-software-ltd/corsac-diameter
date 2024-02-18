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
 * 4.5.8.  Tunnel-Assignment-Id AVP

   The Tunnel-Assignment-Id AVP (AVP Code 82) is of type OctetString and
   is used to indicate to the tunnel initiator the particular tunnel to
   which a session is to be assigned.  Some tunneling protocols, such as
   PPTP [RFC2637] and L2TP [RFC3931], allow for sessions between the
   same two tunnel endpoints to be multiplexed over the same tunnel and
   also for a given session to use its own dedicated tunnel.  This
   attribute provides a mechanism for Diameter to inform the tunnel
   initiator (for example, a LAC) whether to assign the session to a
   
    multiplexed tunnel or to a separate tunnel.  Furthermore, it allows
   for sessions sharing multiplexed tunnels to be assigned to different
   multiplexed tunnels.

   A particular tunneling implementation may assign differing
   characteristics to particular tunnels.  For example, different
   tunnels may be assigned different QoS parameters.  Such tunnels may
   be used to carry either individual or multiple sessions.  The Tunnel-
   Assignment-Id attribute thus allows the Diameter server to indicate
   that a particular session is to be assigned to a tunnel providing an
   appropriate level of service.  It is expected that any QoS-related
   Diameter tunneling attributes defined in the future accompanying this
   one will be associated by the tunnel initiator with the Id given by
   this attribute.  In the meantime, any semantic given to a particular
   Id string is a matter left to local configuration in the tunnel
   initiator.

   The Tunnel-Assignment-Id AVP is of significance only to Diameter and
   the tunnel initiator.  The Id it specifies is only intended to be of
   local use to Diameter and the tunnel initiator.  The Id assigned by
   the tunnel initiator is not conveyed to the tunnel peer.

   This attribute MAY be included in authorization responses.  The
   tunnel initiator receiving this attribute MAY choose to ignore it and
   to assign the session to an arbitrary multiplexed or non-multiplexed
   tunnel between the desired endpoints.  This AVP SHOULD also be
   included in the Accounting-Request messages pertaining to the
   tunneled session.

   If a tunnel initiator supports the Tunnel-Assignment-Id AVP, then it
   should assign a session to a tunnel in the following manner:

   o  If this AVP is present and a tunnel exists between the specified
      endpoints with the specified Id, then the session should be
      assigned to that tunnel.

   o  If this AVP is present and no tunnel exists between the specified
      endpoints with the specified Id, then a new tunnel should be
      established for the session and the specified Id should be
      associated with the new tunnel.

   o  If this AVP is not present, then the session is assigned to an
      unnamed tunnel.  If an unnamed tunnel does not yet exist between
      the specified endpoints, then it is established and used for this
      session and for subsequent ones established without the Tunnel-
      Assignment-Id attribute.  A tunnel initiator MUST NOT assign a
      session for which a Tunnel-Assignment-Id AVP was not specified to
      a named tunnel (i.e., one that was initiated by a session
      specifying this AVP).

   Note that the same Id may be used to name different tunnels if these
   tunnels are between different endpoints.
 */
@DiameterAvpDefinition(code = AvpCodes.TUNNEL_ASSIGNMENT_ID, vendorId = -1L, name = "Tunnel-Assignment-Id")
public interface TunnelAssignmentId extends DiameterOctetString
{
}