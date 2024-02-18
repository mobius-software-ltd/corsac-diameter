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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/

/*
	3.3.  Filter-Rule-Precedence AVP

   	The Filter-Rule-Precedence AVP (AVP Code 510) is of type Unsigned32
   	and specifies the execution order of the rules expressed in the QoS-
   	Resources AVP.  The lower the numerical value of Filter-Rule-
   	Precedence AVP, the higher the rule precedence.  Rules with equal
   	precedence MAY be executed in parallel if supported by the Resource
   	Management Function.  If the Filter-Rule-Precedence AVP is absent
   	from the Filter-Rule AVP, the rules SHOULD be executed in the order
   	in which they appear in the QoS-Resources AVP.
 */
@DiameterAvpDefinition(code = AvpCodes.FILTER_RULE_PRECEDENCE, vendorId = -1L, name = "Filter-Rule-Precedence")
public interface FilterRulePrecedence extends DiameterUnsigned32
{
}