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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/

/*
 * 4.1.7.1.  Negated AVP

   The Negated AVP (AVP Code 517) is of type Enumerated containing the
   values of True or False.  Exactly zero or one of these AVPs may
   appear in the From-Spec or To-Spec AVP.
   
   When set to True, the meaning of the match is inverted and the
   classifier will match addresses other than those specified by the
   From-Spec or To-Spec AVP.  When set to False, or when the Negated AVP
   is not present, the classifier will match the addresses specified by
   the From-Spec or To-Spec AVP.

   Note that the negation does not impact the port comparisons.

     Value | Name
     ------+--------
       0   | False
       1   | True
 */
@DiameterAvpDefinition(code = 517L, vendorId = -1L, name = "Negated")
public interface Negated extends DiameterEnumerated<NegatedEnum>
{
}