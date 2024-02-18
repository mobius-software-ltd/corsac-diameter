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
 * 	7.3.127	Active-APN
	The Active-APNs AVP is of type Grouped. It shall contain information about a dynamically established APN on a serving node, so the HSS can restore it, if it is eventually lost after a node restart.
	The AVP format shall conform to:
	
	Active-APN ::= <AVP header: 1612 10415>
			 { Context-Identifier }
			 [ Service-Selection ]
			 [ MIP6-Agent-Info ]
			 [ Visited-Network-Identifier ]
			*[ Specific-APN-Info ]
			*[ AVP ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.ACTIVE_APN, vendorId = VendorIDs.TGPP_ID, must = false, name = "Active-APN")
public interface ActiveAPN extends DiameterGroupedAvp
{
	Long getContextIdentifier();
	
	void setContextIdentifier(Long value) throws MissingAvpException;	
	
	String getServiceSelection();
	
	void setServiceSelection(String value);
	
	MIP6AgentInfo getMIP6AgentInfo();
	
	void setMIP6AgentInfo(MIP6AgentInfo value);
	
	ByteBuf getVisitedNetworkIdentifier();
	
	void setVisitedNetworkIdentifier(ByteBuf value);
	
	SpecificAPNInfo getSpecificAPNInfo();
	
	void setSpecificAPNInfo(SpecificAPNInfo value);
}