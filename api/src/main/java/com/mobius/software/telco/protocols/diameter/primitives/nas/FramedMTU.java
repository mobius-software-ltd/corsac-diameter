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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/
/*
 * 4.4.10.3.  Framed-MTU AVP

   The Framed-MTU AVP (AVP Code 12) is of type Unsigned32 and contains
   the Maximum Transmission Unit (MTU) to be configured for the user,
   when it is not negotiated by some other means (such as PPP).  This
   AVP SHOULD only be present in authorization responses.  The MTU value
   MUST be in the range from 64 to 65535.
 */
@DiameterAvpDefinition(code = 12L, vendorId = -1L, name = "Framed-MTU")
public interface FramedMTU extends DiameterUnsigned32
{
}