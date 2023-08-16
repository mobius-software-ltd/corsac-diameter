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
 * 8.9.  Authorization-Lifetime AVP

   The Authorization-Lifetime AVP (AVP Code 291) is of type Unsigned32
   and contains the maximum number of seconds of service to be provided
   to the user before the user is to be re-authenticated and/or re-
   authorized.  Care should be taken when the Authorization-Lifetime
   value is determined, since a low, non-zero value could create
   significant Diameter traffic, which could congest both the network
   and the agents.

   A value of zero (0) means that immediate re-auth is necessary by the
   access device.  The absence of this AVP, or a value of all ones
   (meaning all bits in the 32-bit field are set to one) means no re-
   auth is expected.
   
   If both this AVP and the Session-Timeout AVP are present in a
   message, the value of the latter MUST NOT be smaller than the
   Authorization-Lifetime AVP.

   An Authorization-Lifetime AVP MAY be present in re-authorization
   messages, and it contains the number of seconds the user is
   authorized to receive service from the time the re-auth answer
   message is received by the access device.

   This AVP MAY be provided by the client as a hint of the maximum
   lifetime that it is willing to accept.  The server MUST return a
   value that is equal to, or smaller than, the one provided by the
   client.
 */
@DiameterAvpDefinition(code = 291L, vendorId = -1L, name = "Authorization-Lifetime")
public interface AuthorizationLifetime extends DiameterUnsigned32
{
}