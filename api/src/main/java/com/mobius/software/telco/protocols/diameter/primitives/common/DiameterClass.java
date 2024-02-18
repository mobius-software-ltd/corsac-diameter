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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;

/**
*
* @author yulian oifa
*
*/
/*
 * 8.20.  Class AVP

   The Class AVP (AVP Code 25) is of type OctetString and is used by
   Diameter servers to return state information to the access device.
   When one or more Class AVPs are present in application-specific
   authorization answer messages, they MUST be present in subsequent re-
   authorization, session termination and accounting messages.  Class
   AVPs found in a re-authorization answer message override the ones
   found in any previous authorization answer message.  Diameter server
   implementations SHOULD NOT return Class AVPs that require more than
   4096 bytes of storage on the Diameter client.  A Diameter client that
   receives Class AVPs whose size exceeds local available storage MUST
   terminate the session.
 */
@DiameterAvpDefinition(code = AvpCodes.CLASS, vendorId = -1L, name = "Class")
public interface DiameterClass extends DiameterOctetString
{
}