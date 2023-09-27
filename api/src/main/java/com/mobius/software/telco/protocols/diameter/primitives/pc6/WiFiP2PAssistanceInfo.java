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
 * 	6.3.30	WiFi-P2P-Assistance-Info
	The WiFi-P2P-Assistance-Info AVP is of type Grouped. It shall contain information to assist WLAN direct discovery and communication as required by the Wi-Fi P2P technology.
	The AVP format shall conform to:
		
	WiFi-P2P-Assistance-Info ::=	<AVP header: 3819 10415>
		 [ SSID ]
		 [ EAP-Master-Session-Key ]
		 [ P2P-Features ]
		 [ WLAN-Link-Layer-Id-List ]
		 [ WLAN-Link-Layer-Id-List ]
		 [ Operating-Channel ]
		 [ Assistance-Info-Validity-Timer ]
		*[AVP]
 */
@DiameterAvpDefinition(code = 3819L, vendorId = KnownVendorIDs.TGPP_ID, name = "WiFi-P2P-Assistance-Info")
public interface WiFiP2PAssistanceInfo extends DiameterGroupedAvp
{
	String getSSID();
	
	void setSSID(String value);
	
	ByteBuf getEAPMasterSessionKey();
	
	void setEAPMasterSessionKey(ByteBuf value);
	
	Long getP2PFeatures();
	
	void setP2PFeatures(Long value);
	
	WLANLinkLayerIdList getWLANLinkLayerIdList();
	
	void setWLANLinkLayerIdList(WLANLinkLayerIdList value);
	
	Long getOperatingChannel();
	
	void setOperatingChannel(Long value);
	
	Long getAssistanceInfoValidityTimer();
	
	void setAssistanceInfoValidityTimer(Long value);
}