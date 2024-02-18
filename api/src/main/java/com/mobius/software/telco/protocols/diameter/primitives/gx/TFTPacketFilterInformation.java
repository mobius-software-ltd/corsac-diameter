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
 * 	5.3.14	TFT-Packet-Filter-Information AVP (3GPP-GPRS access type only)
	The TFT-Packet-Filter-Information AVP (AVP code 1013) is of type Grouped, and it contains the information from a single TFT packet filter including the evaluation precedence, the filter and the Type-of-Service/Traffic Class sent from the PCEF to the PCRF. The PCEF shall include one TFT-Packet-Filter-Information AVP for each TFT packet filter applicable at a PDP context within each PCC rule request corresponding to that PDP context. TFT-Packet-Filter-Information AVPs are derived from the Traffic Flow Template (TFT) defined in 3GPP TS 24.008 [13].
	AVP Format:

	TFT-Packet-Filter-Information ::= < AVP Header: 1013 >
		 [ Precedence ]
		 [ TFT-Filter ]
		 [ ToS-Traffic-Class ]
		 [ Security-Parameter-Index ]
		 [ Flow-Label ]
		 [ Flow-Direction ]
		*[ AVP ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.TFT_PACKET_FILTER_INFORMATION, vendorId = VendorIDs.TGPP_ID, name = "TFT-Packet-Filter-Information")
public interface TFTPacketFilterInformation extends DiameterGroupedAvp
{
	Long getPrecedence();
	
	void setPrecedence(Long value);	
	
	TFTFilter getTFTFilter();
	
	void setTFTFilter(TFTFilter value);	
	
	ByteBuf getToSTrafficClass();
	
	void setToSTrafficClass(ByteBuf value);	
	
	ByteBuf getSecurityParameterIndex();
	
	void setSecurityParameterIndex(ByteBuf value);
	
	ByteBuf getFlowLabel();
	
	void setFlowLabel(ByteBuf value);
	
	FlowDirectionEnum getFlowDirection();
	
	void setFlowDirection(FlowDirectionEnum value);
}