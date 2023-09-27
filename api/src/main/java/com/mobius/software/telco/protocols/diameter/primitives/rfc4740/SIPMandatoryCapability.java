package com.mobius.software.telco.protocols.diameter.primitives.rfc4740;
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
	9.3.1.  SIP-Mandatory-Capability AVP

   	The SIP-Mandatory-Capability AVP (AVP Code 373) is of type
   	Unsigned32.  The value represents a certain capability (or set of
   	capabilities) that have to be fulfilled by the SIP server allocated
   	to the user.

   	The semantics of the different values are not standardized, as it is
   	a matter of the administrative network to allocate its own semantics
   	within its own network.  Each value has to represent a single
   	capability within the administrative network.
 */
@DiameterAvpDefinition(code = 373L, vendorId = -1, name = "SIP-Mandatory-Capability")
public interface SIPMandatoryCapability extends DiameterUnsigned32
{
}