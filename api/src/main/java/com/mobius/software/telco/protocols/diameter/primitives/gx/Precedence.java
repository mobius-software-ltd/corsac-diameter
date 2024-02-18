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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.11 Precedence AVP (All access types)
	The Precedence AVP (AVP code 1010) is of type Unsigned32.
	Within the Charging Rule Definition AVP, the Precedence AVP determines the order, in which service data flow
	templates consisting of service data flow filters are applied at service data flow detection at the PCEF. For PCC rules
	with an application detection filter, the Precedence AVP only determines which PCC rule is applicable for the detected
	application for the enforcement of QoS, for charging control, for reporting of application start and stop and for usage
	monitoring. A PCC rule with the Precedence AVP with lower value shall be applied before a PCC rule with the
	Precedence AVP with higher value. 
	
	NOTE 1: For PCRF-initiated IP-CAN session modification cases where the PCEF creates new service data flow
	filters (e.g. mapping into new TFT-UL filters), the PCEF need to make an appropriate mapping between
	the value of the Precedence AVP from the PCC rule and the precedence information of the traffic
	mapping information filter. The PCEF have to maintain the order of the precedence information provided
	by the PCRF for the PCC rules with the precedence information of the new traffic mapping information
	filters. For UE-initiated IP-CAN session modification cases, according to 3GPP TS 23.060 [17], the
	precedence of the traffic mapping information filter provided by the UE is not modified by the PCEF.
	Also see access specific annexes for mapping of Precedence AVP from the PCC rule and the precedence
	information of the traffic mapping information filter.
	
	NOTE 2: The precedence value range defined within the PCC rule is operator configurable and can be set based on
	the IP-CAN type.
	
	The Precedence AVP is also used within the TFT-Packet-Filter-Information AVP to indicate the evaluation precedence
	of the Traffic Mapping Information filters (for GPRS the TFT packet filters) as received from the UE. The PCEF shall
	assign a lower value in the corresponding Precedence AVP to a Traffic Mapping Information filter with a higher
	evaluation precedence than to a Traffic Mapping Information filter with a lower evaluation precedence.
	The Precedence AVP is also used within the Routing-Rule-Definition AVP to indicate the evaluation precedence of the
	routing filters contained as within the IP flow mobility routing rules or NBIFOM routing rules. A lower value in the
	Precedence AVP indicates higher evaluation precedence. The PCEF shall assign the lowest evaluation precedence to a
	Routing filter containg the wild card filter. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.PRECEDENCE, vendorId = VendorIDs.TGPP_ID, name = "Precedence")
public interface Precedence extends DiameterUnsigned32
{
}