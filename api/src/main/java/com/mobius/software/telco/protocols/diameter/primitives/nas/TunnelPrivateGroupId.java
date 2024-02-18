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
 * 4.5.7.  Tunnel-Private-Group-Id AVP

   The Tunnel-Private-Group-Id AVP (AVP Code 81) is of type OctetString
   and contains the group Id for a particular tunneled session.  The
   Tunnel-Private-Group-Id AVP MAY be included in an authorization
   request if the tunnel initiator can predetermine the group resulting
   from a particular connection.  It SHOULD be included in the
   authorization response if this tunnel session is to be treated as
   belonging to a particular private group.  Private groups may be used
   to associate a tunneled session with a particular group of users.
   For example, it MAY be used to facilitate routing of unregistered IP
   addresses through a particular interface.  This AVP SHOULD be
   included in the ACR messages that pertain to the tunneled session.
 */
@DiameterAvpDefinition(code = AvpCodes.TUNNEL_PRIVATE_GROUP_ID, vendorId = -1L, name = "Tunnel-Private-Group-Id")
public interface TunnelPrivateGroupId extends DiameterOctetString
{
}