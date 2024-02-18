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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/
/*
 * 8.11.  Auth-Session-State AVP

   The Auth-Session-State AVP (AVP Code 277) is of type Enumerated and
   specifies whether state is maintained for a particular session.  The
   client MAY include this AVP in requests as a hint to the server, but
   the value in the server's answer message is binding.  The following
   values are supported:

   STATE_MAINTAINED 0

      This value is used to specify that session state is being
      maintained, and the access device MUST issue a session termination
      message when service to the user is terminated.  This is the
      default value.

   NO_STATE_MAINTAINED 1

      This value is used to specify that no session termination messages
      will be sent by the access device upon expiration of the
      Authorization-Lifetime.
 */
@DiameterAvpDefinition(code = AvpCodes.AUTH_SESSION_STATE, vendorId = -1L, name = "Auth-Session-State")
public interface AuthSessionState extends DiameterEnumerated<AuthSessionStateEnum>
{
}