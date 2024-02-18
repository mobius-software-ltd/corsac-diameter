package com.mobius.software.telco.protocols.diameter.primitives.s6a;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.239	PC5-Flow-Bitrates
	The PC5-Flow-Bitrates AVP is of type Grouped. It shall contain the PC5 Flow Bit Rates, it's for GBR QoS Flows only.
	AVP format:
	
	PC5-Flow-Bitrates ::= <AVP header: 1714 10415>
			[ Guaranteed-Flow-Bitrates ]
			[ Maximum-Flow-Bitrates ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.PC5_FLOW_BITRATES, vendorId = VendorIDs.TGPP_ID, must = false, name = "PC5-Flow-Bitrates")
public interface PC5FlowBitrates extends DiameterAvp
{
	Integer getGuaranteedFlowBitrates();
	
	void setGuaranteedFlowBitrates(Integer value);
	
	Integer getMaximumFlowBitrates();
	
	void setMaximumFlowBitrates(Integer value);
}