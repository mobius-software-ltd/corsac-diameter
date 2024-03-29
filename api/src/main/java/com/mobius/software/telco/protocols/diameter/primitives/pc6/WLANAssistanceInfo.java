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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 6.3.31	WLAN-Assistance-Info
	The WLAN-Assistance-Info AVP is of type Grouped. It shall contain information to assist WLAN direct discovery and communication required for WLAN direct discovery and communication between UEs.
	The AVP format shall conform to:
		
	WLAN-Assistance-Info ::=	<AVP header: 3820 10415>
		 [ WiFi-P2P-Assistance-Info ]
 		*[AVP]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.WLAN_ASSISTANCE_INFO, vendorId = VendorIDs.TGPP_ID, name = "WLAN-Assistance-Info")
public interface WLANAssistanceInfo extends DiameterGroupedAvp
{
	WiFiP2PAssistanceInfo getWiFiP2PAssistanceInfo();
	
	void setWiFiP2PAssistanceInfo(WiFiP2PAssistanceInfo value);
}