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
 * 	6.3.12	Match-Report
	The Match-Report AVP is of type Grouped. It shall contain the information elements used in ProSe Match Report answer.
	The AVP format shall conform to:
		
	Match-Report ::=		<AVP header: 3807 10415>
		 { Discovery-Type }
		 [ ProSe-App-Code ]
		 [ ProSe-Metadata-Index-Mask ]
		 [ ProSe-App-Id ]
		 [ ProSe-Validity-Timer ]
		 [ ProSe-Match-Refresh-Timer ]
		 [ ProSe-Application-Metadata ]
		 [ PC5-tech ]
		*[AVP]

	The valid value for Discovery-Type for Match-Report AVP is: "MONITORING_REQUEST_FOR_OPEN_PROSE_DIRECT_DISCOVERY",
	When the Discovery-Type is set to "MONITORING_REQUEST_FOR_OPEN_PROSE_DIRECT_DISCOVERY", the Match-Report shall contain a ProSe Application Code, the associated ProSe Application ID Name, the validity time for which the ProSe Application Code is valid, the associated match report refresh timer and optionally the PC5 radio technology that the UE is using.
	If the ProSe Application Code contains a metadata index, a ProSe-Metadata-Index-Mask AVP shall be provided for this ProSe Application Code.
 */
@DiameterAvpDefinition(code = 3807L, vendorId = KnownVendorIDs.TGPP_ID, name = "Match-Report")
public interface MatchReport extends DiameterGroupedAvp
{
	DiscoveryTypeEnum getDiscoveryType();
	
	void setDiscoveryType(DiscoveryTypeEnum value);
	
	ByteBuf getProSeAppCode();
	
	void setProSeAppCode(ByteBuf value);
	
	ByteBuf getProSeMetadataIndexMask();
	
	void setProSeMetadataIndexMask(ByteBuf value);
	
	String getProSeAppId();
	
	void setProSeAppId(String value);
	
	Long getProSeValidityTimer();
	
	void setProSeValidityTimer(Long value);
	
	Long getProSeMatchRefreshTimer();
	
	void setProSeMatchRefreshTimer(Long value);
	
	String getProSeApplicationMetadata();
	
	void setProSeApplicationMetadata(String value);
	
	ByteBuf getPC5Tech();
	
	void setPC5Tech(ByteBuf value);
}