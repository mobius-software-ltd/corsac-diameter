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

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.56	Packet-Filter-Information AVP
	The Packet-Filter-Information AVP (AVP code 1061) is of type Grouped, and it contains the information from a single packet filter sent from the PCEF to the PCRF. Depending on the Packet-Filter-Operation included within the CCR command it may include the packet filter identifier, evaluation precedence, filter value, filter direction, Type-of-Service/Traffic Class, the IPSec SPI, and the Flow Label.
	When the Packet-Filter-Operation AVP included within the CCR command indicates DELETION, only the Packet-Filter-Identifier AVP shall be provided.
	The Flow-Direction AVP shall be included unless no other AVPs other than Packet-Filter-Identifier AVP are included within the Packet-Filter-Information AVP.
	When the Packet-Filter-Operation AVP included within the CCR command indicates ADDITION and is linked to an existing packet filter, only the Packet-Filter-Identifier AVP shall be provided for the existing packet filter.
	See annex B.3.4 for E-UTRAN specific details.
	AVP Format:

	Packet-Filter-Information ::= < AVP Header: 1061 >
		 [ Packet-Filter-Identifier ]
		 [ Precedence ]
		 [ Packet-Filter-Content ]
		 [ ToS-Traffic-Class ]
		 [ Security-Parameter-Index ]
		 [ Flow-Label ]
		 [ Flow-Direction ]
		*[ AVP ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.PACKET_FILTER_INFORMATION, vendorId = VendorIDs.TGPP_ID, must=false, name = "Packet-Filter-Information")
public interface PacketFilterInformation extends DiameterGroupedAvp
{
	ByteBuf getPacketFilterIdentifier();
	
	void setPacketFilterIdentifier(ByteBuf value);	
	
	Long getPrecedence();
	
	void setPrecedence(Long value);	
	
	PacketFilterContent getPacketFilterContent();
	
	void setPacketFilterContent(PacketFilterContent value);	
	
	ByteBuf getToSTrafficClass();
	
	void setToSTrafficClass(ByteBuf value);	
	
	ByteBuf getSecurityParameterIndex();
	
	void setSecurityParameterIndex(ByteBuf value);
	
	ByteBuf getFlowLabel();
	
	void setFlowLabel(ByteBuf value);
	
	FlowDirectionEnum getFlowDirection();
	
	void setFlowDirection(FlowDirectionEnum value);
}