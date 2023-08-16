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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterIdentity;

/**
*
* @author yulian oifa
*
*/
/*
 * 6.3.  Origin-Host AVP

   The Origin-Host AVP (AVP Code 264) is of type DiameterIdentity, and
   it MUST be present in all Diameter messages.  This AVP identifies the
   endpoint that originated the Diameter message.  Relay agents MUST NOT
   modify this AVP.
   
   The value of the Origin-Host AVP is guaranteed to be unique within a
   single host.

   Note that the Origin-Host AVP may resolve to more than one address as
   the Diameter peer may support more than one address.

   This AVP SHOULD be placed as close to the Diameter header as
   possible.
 */
@DiameterAvpDefinition(code = 264L, position = 4, vendorId = -1L, name = "Origin-Host")
public interface OriginHost extends DiameterIdentity
{
}