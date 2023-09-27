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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.237	PC5-QoS-Flow
	The PC5-QoS-Flow AVP is of type Grouped. It shall contain the QoS parameters for a PC5 flow.
	AVP format:

	PC5-QoS-Flow ::= <AVP header: 1712 10415>
			 { 5QI }
			 [ PC5-Flow-Bitrates ]
			 [ PC5-Range ]
			*[AVP]
 */
@DiameterAvpDefinition(code = 1712L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "PC5-QoS-Flow")
public interface PC5QoSFlow extends DiameterGroupedAvp
{
	Integer getFiveQI();
	
	void setFiveQI(Integer value);
	
	PC5FlowBitrates getPC5FlowBitrates();
	
	void setPC5FlowBitrates(PC5FlowBitrates value);
	
	Integer getPC5Range();
	
	void setPC5Range(Integer value);
}