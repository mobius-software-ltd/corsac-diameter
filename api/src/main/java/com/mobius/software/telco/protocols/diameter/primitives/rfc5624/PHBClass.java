package com.mobius.software.telco.protocols.diameter.primitives.rfc5624;
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
	3.4.  PHB-Class AVP

    The PHB-Class AVP (AVP Code 503) is of type Unsigned32.

    A description of the semantics of the parameter values can be found
    in [RFC3140].  The registries needed for usage with [RFC3140] already
    exist and hence a new registry is not required for this purpose.  The
    encoding requires that three cases be differentiated.  All bits
    indicated as "reserved" MUST be set to zero (0).
 */
@DiameterAvpDefinition(code = 503L, vendorId = -1L, name = "PHB-Class")
public interface PHBClass extends DiameterUnsigned32
{
}