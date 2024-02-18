package com.mobius.software.telco.protocols.diameter.primitives.accounting;
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

import java.net.InetAddress;

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.242aaA	UWAN-User-Location-Info AVP
	The UWAN-User-Location-Info AVP (AVP code 3918) is of type Grouped and contains the UE location in an Unrusted Wireless Access Network (UWAN). The UWAN User Location Information shall include the UE local IP address and optionally UDP source port number (if NAT is detected) or TCP source port number. It may also include WLAN Location Information as TWAN Identifier defined in  TS 29.274 [226] .
	It has the following ABNF grammar:
	
	UWAN-User-Location-Info :: = 	< AVP Header: 3918>
			{ UE-Local-IP-Address }
			[ UDP-Source-Port ]
			[ SSID ]
			[ BSSID ]
			[ TCP-Source-Port ]
			[ Civic-Address-Information ]
			[ WLAN-Operator-Id ]
			[ Logical-Access-ID ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.UWAN_USER_LOCATION_INFO, vendorId = VendorIDs.TGPP_ID, name = "UWAN-User-Location-Info")
public interface UWANUserLocationInfo extends DiameterAvp
{
	InetAddress getUELocalIPAddress();
	
	void setUELocalIPAddress(InetAddress value) throws MissingAvpException;
	
	Long getUDPSourcePort();
	
	void setUDPSourcePort(Long value);
	
	String getSSID();
	
	void setSSID(String value);
	
	String getBSSID();
	
	void setBSSID(String value);
	
	Long getTCPSourcePort();
	
	void setTCPSourcePort(Long value);
	
	ByteBuf getCivicAddressInformation();
	
	void setCivicAddressInformation(ByteBuf value);
	
	WLANOperatorId getWLANOperatorId();
	
	void setWLANOperatorId(WLANOperatorId value);
	
	ByteBuf getLogicalAccessID();
	
	void setLogicalAccessID(ByteBuf value);	
}