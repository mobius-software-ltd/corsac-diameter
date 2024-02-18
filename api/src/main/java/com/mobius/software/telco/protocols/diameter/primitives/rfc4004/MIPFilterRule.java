package com.mobius.software.telco.protocols.diameter.primitives.rfc4004;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterIpFilterRule;

/**
*
* @author yulian oifa
*
*/

/*
	7.8.  MIP-Filter-Rule AVP

   	The MIP-Filter-Rule AVP (AVP Code 342) is of type IPFilterRule and
   	provides filter rules that have to be configured on the foreign or
   	home agent for the user.  The packet filtering rules are set by the
   	AAAH by adding one or more MIP-Filter-Rule AVPs in the HAR if
   	destined for the home agent and/or in the AMA if destined for the
   	foreign agent.
 */
@DiameterAvpDefinition(code = AvpCodes.MIP_FILTER_RULE, vendorId = -1L, name = "MIP-Filter-Rule")
public interface MIPFilterRule extends DiameterIpFilterRule
{
}