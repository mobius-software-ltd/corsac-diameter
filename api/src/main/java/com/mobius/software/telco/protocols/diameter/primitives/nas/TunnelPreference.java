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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/
/*
 * 4.5.9.  Tunnel-Preference AVP

   The Tunnel-Preference AVP (AVP Code 83) is of type Unsigned32 and is
   used to identify the relative preference assigned to each tunnel when
   more than one set of tunneling AVPs is returned within separate
   grouped AVPs.  It MAY be used in an authorization request as a hint
   to the server that a specific preference is desired, but the server
   is not required to honor the hint in the corresponding response.

   For example, suppose that AVPs describing two tunnels are returned by
   the server, one with a tunnel type of PPTP and the other with a
   tunnel type of L2TP.  If the tunnel initiator supports only one of
   the tunnel types returned, it will initiate a tunnel of that type.
   If, however, it supports both tunnel protocols, it SHOULD use the
   value of the Tunnel-Preference AVP to decide which tunnel should be
   started.  The tunnel with the lowest numerical value in the Value
   field of this AVP SHOULD be given the highest preference.  The values
   assigned to two or more instances of the Tunnel-Preference AVP within
   a given authorization response MAY be identical.  In this case, the
   tunnel initiator SHOULD use locally configured metrics to decide
   which set of AVPs to use.
 */
@DiameterAvpDefinition(code = AvpCodes.TUNNEL_PREFERENCE, vendorId = -1L, name = "Tunnel-Preference")
public interface TunnelPreference extends DiameterUnsigned32
{
}