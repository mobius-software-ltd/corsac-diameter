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
 * 4.1.4.  Direction AVP

   The Direction AVP (AVP Code 514) is of type Enumerated and specifies
   in which direction to apply the classifier.  The values of the
   enumeration are "IN","OUT","BOTH".  In the "IN" and "BOTH"
   directions, the From-Spec refers to the address of the managed
   terminal and the To-Spec refers to the unmanaged terminal.  In the
   "OUT" direction, the From-Spec refers to the unmanaged terminal
   whereas the To-Spec refers to the managed terminal.  If the Direction
   AVP is omitted, the classifier matches packets flowing in both
   directions.

     Value | Name and Semantic
     ------+--------------------------------------------------
       0   | IN - The classifier applies to flows from the
           | managed terminal.
       1   | OUT - The classifier applies to flows to the
           | managed terminal.
       2   | BOTH - The classifier applies to flows both to
           | and from the managed terminal.
 */
@DiameterAvpDefinition(code = AvpCodes.DIRECTION, vendorId = -1L, name = "Direction")
public interface Direction extends DiameterEnumerated<DirectionEnum>
{
}