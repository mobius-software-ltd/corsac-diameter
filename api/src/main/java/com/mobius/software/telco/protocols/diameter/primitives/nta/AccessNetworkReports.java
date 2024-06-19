package com.mobius.software.telco.protocols.diameter.primitives.nta;
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
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NetLocAccessSupportEnum;

import io.netty.buffer.ByteBuf;

/*A.6.3.2	Access-Network-Reports AVP
The Access-Network-Reports AVP (AVP code 4210) is of type Grouped. It indicates the access network information for a UE.
Access-Network-Reports ::= < AVP Header: 4210 >
                   [ MSISDN ]
                   [ External-Identifier ]
                   [ 3GPP-User-Location-Info ]
                   [ User-Location-Info-Time ]
                   [ 3GPP-SGSN-MCC-MNC ]
                   [ 3GPP-MS-TimeZone ]
                   [ UE-Local-IP-Address ]
                   [ TCP-Source-Port ]
                   [ UDP-Source-Port ]
                   [ NetLoc-Access-Support ]
                  *[ AVP ]
*/

@DiameterAvpDefinition(code = TgppAvpCodes.ACCESS_NETWORK_REPORTS, vendorId = VendorIDs.TGPP_ID, name = "Access-Network-Reports")
public interface AccessNetworkReports extends DiameterGroupedAvp
{
	String getMSISDN();
	 
	void setMSISDN(String value);
	
	List<String> getExternalIdentifier();
	
	void setExternalIdentifier(List<String> value);	
	
	ByteBuf getTGPPUserLocationInfo();
	
	void setTGPPUserLocationInfo(ByteBuf value);

	Date getUserLocationInfoTime();
	
	void setUserLocationInfoTime(Date value);
	
	String getTGPPSGSNMCCMNC();
	
	void setTGPPSGSNMCCMNC(String value);
	
	ByteBuf getTGPPMSTimeZone();
	
	void setTGPPMSTimeZone(ByteBuf value);
	
	InetAddress getUELocalIPAddress();
	
	void setUELocalIPAddress(InetAddress value);

	Long getTCPSourcePort();
	
	void setTCPSourcePort(Long value);
	
	Long getUDPSourcePort();
	
	void setUDPSourcePort(Long value);
	
	NetLocAccessSupportEnum getNetLocAccessSupport();
	
	void setNetLocAccessSupport(NetLocAccessSupportEnum value);	
	
}