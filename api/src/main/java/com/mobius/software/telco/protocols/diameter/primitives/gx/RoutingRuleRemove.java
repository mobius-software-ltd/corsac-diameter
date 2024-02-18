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

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.69	Routing-Rule-Remove AVP
	The Routing-Rule-Remove AVP (AVP code 1075) is of type Grouped, and it is used to remove IP flow mobility routing rules defined in clause 4.3a or NBIFOM routing rule defined in clause 4.3c for an IP CAN session from the PCRF.
	Routing-Rule-Identifier AVP is a reference for a specific IP flow mobility routing rule/NBIFOM routing rule at the PCRF to be removed.
	AVP Format:
	
	Routing-Rule-Remove ::= < AVP Header: 1075 >
		*[ Routing-Rule-Identifier ]
		*[ AVP ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.ROUTING_RULE_REMOVE, vendorId = VendorIDs.TGPP_ID, must=false, name = "Routing-Rule-Remove")
public interface RoutingRuleRemove extends DiameterGroupedAvp
{
	List<ByteBuf> getRoutingRuleIdentifier();
	
	void setRoutingRuleIdentifier(List<ByteBuf> value);
}