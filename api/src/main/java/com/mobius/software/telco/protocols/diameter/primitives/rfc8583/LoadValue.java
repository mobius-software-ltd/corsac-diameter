package com.mobius.software.telco.protocols.diameter.primitives.rfc8583;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned64;

/**
*
* @author yulian oifa
*
*/

/*
	7.3.  Load-Value AVP

   	The Load-Value AVP (AVP code 652) is of type Unsigned64.  It is used
   	to convey relative load information about the sender of the load
   	report.

   	The Load-Value AVP is specified in a manner similar to the weight
   	value in DNS SRV ([RFC2782]).

   	The Load value has a range of 0-65535.

   	A higher value indicates a lower load on the sending node.  A lower
   	value indicates that the sending node is heavily loaded.

      Stated another way, a node that has zero load would have a Load
      value of 65535.  A node that is 100% loaded would have a Load
      value of 0.
 */
@DiameterAvpDefinition(code = 652L, vendorId = -1L, must = false, name = "Load-Value")
public interface LoadValue extends DiameterUnsigned64
{
}