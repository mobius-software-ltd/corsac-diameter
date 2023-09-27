package com.mobius.software.telco.protocols.diameter.primitives.pc6;
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
import com.mobius.software.telco.protocols.diameter.primitives.sh.UserIdentity;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.3.55	Match-Request 
	The Match-Request is of type Grouped. It shall contain the information elements used in ProSe Match Report request.
	The AVP format shall conform to:
		
	Match-Request ::=		<AVP header: 3856 10415>
		 { Discovery-Type }
		 [ User Identity ]
		 [ Visited-PLMN-ID ]
		*[ ProSe-App-Code-Info ]
		 [ PC5-tech ]
		*[AVP]

	The valid value for Discovery-Type for Match-Report AVP is: "MONITORING_REQUEST_FOR_OPEN_PROSE_DIRECT_DISCOVERY",
	When the Discovery-Type is set to "MONITORING_REQUEST_FOR_OPEN_PROSE_DIRECT_DISCOVERY", the Match-Request shall contain one UE Identity, one Visited PLMN ID, one or more ProSe App Code Info and optionally the PC5 radio technology that the UE is using.
 */
@DiameterAvpDefinition(code = 3856L, vendorId = KnownVendorIDs.TGPP_ID, name = "Match-Request")
public interface MatchRequest extends DiameterGroupedAvp
{
	DiscoveryTypeEnum getDiscoveryType();
	
	void setDiscoveryType(DiscoveryTypeEnum value);
	
	UserIdentity getUserIdentity();
	
	void setUserIdentity(UserIdentity value);
	
	ByteBuf getVisitedPLMNID();
	
	void setVisitedPLMNID(ByteBuf value);
	
	List<ProSeAppCodeInfo> getProSeAppCodeInfo();
	
	void setProSeAppCodeInfo(List<ProSeAppCodeInfo> value);
	
	ByteBuf getPC5Tech();
	
	void setPC5Tech(ByteBuf value);
}