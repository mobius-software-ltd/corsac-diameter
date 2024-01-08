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
 * 6.5.  Destination-Host AVP

   The Destination-Host AVP (AVP Code 293) is of type DiameterIdentity.
   This AVP MUST be present in all unsolicited agent initiated messages,
   MAY be present in request messages, and MUST NOT be present in answer
   messages.

   The absence of the Destination-Host AVP will cause a message to be
   sent to any Diameter server supporting the application within the
   realm specified in Destination-Realm AVP.

   This AVP SHOULD be placed as close to the Diameter header as
   possible.
 */
@DiameterAvpDefinition(code = 293L, vendorId = -1L, name = "Destination-Host")
public interface DestinationHost extends DiameterIdentity
{
}