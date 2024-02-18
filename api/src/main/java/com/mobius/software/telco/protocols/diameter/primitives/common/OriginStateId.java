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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/
/*
 * 8.16.  Origin-State-Id AVP

   The Origin-State-Id AVP (AVP Code 278), of type Unsigned32, is a
   monotonically increasing value that is advanced whenever a Diameter
   entity restarts with loss of previous state, for example, upon
   reboot.  Origin-State-Id MAY be included in any Diameter message,
   including CER.

   A Diameter entity issuing this AVP MUST create a higher value for
   this AVP each time its state is reset.  A Diameter entity MAY set
   Origin-State-Id to the time of startup, or it MAY use an incrementing
   counter retained in non-volatile memory across restarts.

   The Origin-State-Id, if present, MUST reflect the state of the entity
   indicated by Origin-Host.  If a proxy modifies Origin-Host, it MUST
   either remove Origin-State-Id or modify it appropriately as well.
   Typically, Origin-State-Id is used by an access device that always
   starts up with no active sessions; that is, any session active prior
   to restart will have been lost.  By including Origin-State-Id in a
   message, it allows other Diameter entities to infer that sessions
   associated with a lower Origin-State-Id are no longer active.  If an
   access device does not intend for such inferences to be made, it MUST
   either not include Origin-State-Id in any message or set its value to
   0.
 */
@DiameterAvpDefinition(code = AvpCodes.ORIGIN_STATE_ID, vendorId = -1L, name = "Origin-State-Id")
public interface OriginStateId extends DiameterUnsigned32
{
		
}