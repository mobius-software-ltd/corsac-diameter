package com.mobius.software.telco.protocols.diameter.primitives.gx;
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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.119 Routing-Rule-Failure-Code AVP
	The Routing-Rule-Failure-Code AVP (AVP code 2834) is of type Unsigned32. It is sent by the PCRF to the PCEF
	within a Routing-Rule-Report AVP to identify the reason a NBIFOM routing rule is being reported.
	The following values are defined in this specification:

	0 (Subscription limitation):
 		This value shall be used to indicate that the NBIFOM routing rule cannot be installed or modified due to the
		subscription limitation.
	1 (Operator policy):
 		This value shall be used to indicate that the NBIFOM routing rule cannot be installed or modified due to the
		operator policy.
	2 (Resource limitation):
 		This value shall be used to indicate that the NBIFOM routing rule cannot be installed or modified due to the
		resource limitation.
	3 (Routing access information not allowed):
 		This value shall be used to indicate that the NBIFOM routing rule cannot be installed or modified due to the
		routing access information is not allowed by the network.
	4 (Unspecified error):
 		This value shall be used to indicate that the NBIFOM routing rule cannot be installed or modified due to the
		unspecified error.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.ROUTING_RULE_FAILURE_CODE, vendorId = VendorIDs.TGPP_ID, must = false, name = "Routing-Rule-Failure-Code")
public interface RoutingRuleFailureCode extends DiameterEnumerated<RoutingRuleFailureCodeEnum>
{
}