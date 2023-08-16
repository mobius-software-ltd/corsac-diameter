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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/
/*
 * 8.15.  Termination-Cause AVP

   The Termination-Cause AVP (AVP Code 295) is of type Enumerated, and
   is used to indicate the reason why a session was terminated on the
   access device.  The currently assigned values for this AVP can be
   found in the IANA registry for Termination-Cause AVP Values
   [IANATCV].
 */
@DiameterAvpDefinition(code = 295L, vendorId = -1L, name = "Termination-Cause")
public interface TerminationCause extends DiameterEnumerated<TerminationCauseEnum>
{
}