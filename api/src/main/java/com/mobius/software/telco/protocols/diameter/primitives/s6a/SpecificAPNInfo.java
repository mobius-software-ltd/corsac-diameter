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
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6AgentInfo;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.82	Specific-APN-Info AVP
	The Specific-APN-Info AVP is of type Grouped. It shall only be present in the APN configuration when the APN is a wild card APN. It shall contain the APN which is not present in the subscription context but the UE is authorized to connect to and the identity of the registered PDN-GW.
	The AVP format shall conform to:
	
	Specific-APN-Info ::= <AVP header: 1472 10415>
		 { Service-Selection }
		 { MIP6-Agent-Info }
		 [ Visited-Network-Identifier ]
		*[ AVP ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SPECIFIC_APN_INFO, vendorId = VendorIDs.TGPP_ID, name = "Specific-APN-Info")
public interface SpecificAPNInfo extends DiameterGroupedAvp
{
	String getServiceSelection();
	
	void setServiceSelection(String value) throws MissingAvpException;
	
	MIP6AgentInfo getMIP6AgentInfo();
	
	void setMIP6AgentInfo(MIP6AgentInfo value) throws MissingAvpException;
	
	ByteBuf getVisitedNetworkIdentifier();
	
	void setVisitedNetworkIdentifier(ByteBuf value);	
}