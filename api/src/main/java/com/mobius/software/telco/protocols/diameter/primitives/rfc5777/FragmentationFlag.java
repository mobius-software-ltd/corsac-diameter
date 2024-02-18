package com.mobius.software.telco.protocols.diameter.primitives.rfc5777;
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
 * 4.1.8.2.  Fragmentation-Flag AVP

   The Fragmentation-Flag AVP (AVP Code 536) is of type Enumerated and
   specifies the packet fragmentation flags to match in the IP header.

     Value | Name and Semantic
     ------+------------------------------------------------------------
       0   | Don't Fragment (DF)
       1   | More Fragments (MF)
 */
@DiameterAvpDefinition(code = AvpCodes.FRAGMENTATION_FLAG, vendorId = -1L, name = "Fragmentation-Flag")
public interface FragmentationFlag extends DiameterEnumerated<FragmentationFlagEnum>
{
}