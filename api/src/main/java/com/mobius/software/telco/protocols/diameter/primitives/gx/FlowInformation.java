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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.rx.FlowDescription;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.53	Flow-Information AVP (All access types)
	The Flow-Information AVP (AVP code 1058) is of type Grouped, and it is sent from the PCRF to the PCEF and contains the information from a single IP flow packet filter.
	The Flow-Description, ToS-Traffic-Class, Security-Parameter-Index and Flow-Label AVPs specify the parameters to be used for matching payload packets. If any of these AVPs is present, then the Flow-Direction AVP shall also be included. If the Flow-Information AVP includes any of the Flow-Description, ToS-Traffic-Class, Security-Parameter-Index or Flow-Label AVPs, these values replace any previous value for all the Flow-Description, ToS-Traffic-Class, Security-Parameter-Index and Flow-Label AVPs.
	The Flow-Information AVP shall include the Flow-Direction AVP, declaring in what direction(s) the filter applies.
	The PCRF shall only assign the packet filter identifier in the Packet-Filter-Identifier AVP for PCC rules created as a result of UE-initiated resource allocation.
	
	NOTE 1:	The UE can only modify or delete the packet filters that the UE has introduced and associated resources. The packet filter identifiers are only needed for packet filters created by the UE.

	For PCC rules modified as a result of UE-initiated resource modification that include the modified Flow-Information AVP, the PCRF shall include the packet filter identifier in the Packet-Filter-Identifier AVP.

	The Flow-Direction AVP shall be included unless no other AVPs other than Packet-Filter-Identifier AVP are included within the Flow-Information AVP.

	The Routing-Rule-Identifier AVP shall be included in the case of NBIFOM and when the PCRF initiates/has initiated the NBIFOM routing rule(s). It is used by the PCEF as routing rule identifier for the corresponding NBIFOM routing rule sent over Gx interface when the PCEF receives an UE-requested IP flow mapping modification request for the routing rule. See subclause 4.5.25.2 for further details.
	
	NOTE 2:	For 3GPP accesses, the possible combinations of Flow-Description, Type-of-Service/Traffic Class, the IPSec SPI, and the Flow Label in the TFT filter are defined in 3GPP TS 23.060 [17].

	AVP Format:
	Flow-Information ::= < AVP Header: 1058 >
		 [ Flow-Description ]
		 [ Packet-Filter-Identifier ]
		 [ Packet-Filter-Usage ]
		 [ ToS-Traffic-Class ]
		 [ Security-Parameter-Index ]
		 [ Flow-Label ]
		 [ Flow-Direction ]
		 [ Routing-Rule-Identifier ]
		*[ AVP ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.FLOW_INFORMATION, vendorId = VendorIDs.TGPP_ID, must=false, name = "Flow-Information")
public interface FlowInformation extends DiameterGroupedAvp
{
	FlowDescription getFlowDescription();
	
	void setFlowDescription(FlowDescription value);	
	
	ByteBuf getPacketFilterIdentifier();
	
	void setPacketFilterIdentifier(ByteBuf value);	
	
	PacketFilterUsageEnum getPacketFilterUsage();
	
	void setPacketFilterUsage(PacketFilterUsageEnum value);	
	
	ByteBuf getToSTrafficClass();
	
	void setToSTrafficClass(ByteBuf value);	
	
	ByteBuf getSecurityParameterIndex();
	
	void setSecurityParameterIndex(ByteBuf value);
	
	ByteBuf getFlowLabel();
	
	void setFlowLabel(ByteBuf value);
	
	FlowDirectionEnum getFlowDirection();
	
	void setFlowDirection(FlowDirectionEnum value);
	
	ByteBuf getRoutingRuleIdentifier();
	
	void setRoutingRuleIdentifier(ByteBuf value);
}