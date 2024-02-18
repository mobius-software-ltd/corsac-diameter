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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.68	Routing-Rule-Install AVP 
	The Routing-Rule-Install AVP (AVP code 1081 ) is of type Grouped, and it is used to install or modify IP flow mobility routing rules defined in clause 4.3a or NBIFOM routing rules defined in clause 4.3c as instructed from the PCEF to the PCRF.
	For installing a new IP flow mobility routing rule/NBIFOM routing rule or modifying an IP flow mobility routing rule/NBIFOM routing rule already installed, Routing-Rule-Definition AVP shall be used.
	AVP Format:

	Routing-Rule-Install ::= 	< AVP Header: 1081 >
		*[ Routing-Rule-Definition ]
		*[ AVP ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.ROUTING_RULE_INSTALL, vendorId = VendorIDs.TGPP_ID, must=false, name = "Routing-Rule-Install")
public interface RoutingRuleInstall extends DiameterGroupedAvp
{
	List<RoutingRuleDefinition> getRoutingRuleDefinition();
	
	void setRoutingRuleDefinition(List<RoutingRuleDefinition> value);
}