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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.118	Routing-Rule-Report AVP
	The Routing-Rule-Report AVP (AVP code 2835) is of type Grouped, and it is used to report the status of NBIFOM routing rules.
	Routing-Rule-Identifier AVP is a reference for a specific NBIFOM routing rule at the PCRF that cannot be installed or modified due to the operator’s policy or user subscription.
	Routing-Rule-Failure-Code AVP indicates the reason why the NBIFOM routing rules cannot be successfully installed or modified.
	AVP Format:

	Routing-Rule-Report ::= < AVP Header: 2835 >
						*[ Routing-Rule-Identifier ]
						 [ PCC-Rule-Status ]
						 [ Routing-Rule-Failure-Code ]
						*[ AVP ]

	Multiple instances of Routing-Rule-Report AVPs shall be used in the case it is required to report different Routing-Rule-Failure-Code values for different groups of rules within the same Diameter command.
 */
@DiameterAvpDefinition(code = 2835L, vendorId = KnownVendorIDs.TGPP_ID, must=false, name = "Routing-Rule-Report")
public interface RoutingRuleReport extends DiameterGroupedAvp
{
	List<ByteBuf> getRoutingRuleIdentifier();
	
	void setRoutingRuleIdentifier(List<ByteBuf> value);	
	
	PCCRuleStatusEnum getPCCRuleStatus();
	
	void setPCCRuleStatus(PCCRuleStatusEnum value);
	
	RoutingRuleFailureCodeEnum getRoutingRuleFailureCode();
	
	void setRoutingRuleFailureCode(RoutingRuleFailureCodeEnum value);
}