package com.mobius.software.telco.protocols.diameter.commands.rx;
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

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NetLocAccessSupportEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.rx.FiveGSRANNASReleaseCause;
import com.mobius.software.telco.protocols.diameter.primitives.rx.SponsoredConnectivityData;
import com.mobius.software.telco.protocols.diameter.primitives.rx.WirelineUserLocationInfo;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.6.6	Session-Termination-Answer (STA) command
	The STA command, indicated by the Command-Code field set to 275 and the ‘R’ bit cleared in the Command Flags field, is sent by the PCRF to the AF in response to the STR command.
	Message Format:
	
	<ST-Answer>  ::= < Diameter Header: 275, PXY >
				 < Session-Id >
				 [ DRMP ]
				 { Origin-Host }
				 { Origin-Realm }
				 [ Result-Code ]
				 [ Error-Message ]
				 [ Error-Reporting-Host ]
				 [ OC-Supported-Features ]
				 [ OC-OLR ]
				 [ Failed-AVP ]
				 [ Sponsored-Connectivity-Data ]
				 [ Origin-State-Id ]
				 [ 3GPP-User-Location-Info ]
				 [ User-Location-Info-Time ]
				 [ 3GPP-MS-TimeZone ]
				*[ RAN-NAS-Release-Cause ]
				*[ 5GS-RAN-NAS-Release-Cause ]
				 [ 3GPP-SGSN-MCC-MNC ]
				 [ NID ]
				 [ TWAN-Identifier ]
				 [ TCP-Source-Port ]
				 [ UDP-Source-Port ]
				 [ UE-Local-IP-Address ]
				 [ Netloc-Access-Support ]
				 [ Wireline-User-Location-Info ]
				*[ Class ]
				*[ Redirect-Host ]
				 [ Redirect-Host-Usage ]
				 [ Redirect-Max-Cache-Time ]
				*[ Proxy-Info ]
				*[ Load ]
				*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.RX, commandCode = CommandCodes.SESSION_TERMINATION, request = false, proxyable = true, name="Session-Termination-Answer")
public interface SessionTerminationAnswer extends RxAnswer
{
	SponsoredConnectivityData getSponsoredConnectivityData();
	
	void setSponsoredConnectivityData(SponsoredConnectivityData value);	
	
	ByteBuf getTGPPUserLocationInfo();
	
	void setTGPPUserLocationInfo(ByteBuf value);	
	
	Date getUserLocationInfoTime();
	
	void setUserLocationInfoTime(Date value);	
	
	ByteBuf getTGPPMSTimeZone();
	
	void setTGPPMSTimeZone(ByteBuf value);	

	List<ByteBuf> getRANNASReleaseCause();

	void setRANNASReleaseCause(List<ByteBuf> value);
	
	List<FiveGSRANNASReleaseCause> getFiveGSRANNASReleaseCause();

	void setFiveGSRANNASReleaseCause(List<FiveGSRANNASReleaseCause> value);
	
	public String get3GPPSGSNMCCMNC();
	
	void set3GPPSGSNMCCMNC(String value);
	
	public ByteBuf getNID();
	
	void setNID(ByteBuf value);	
	
	public ByteBuf getTWANIdentifier();
	
	void setTWANIdentifier(ByteBuf value);	
	
	public Long getTCPSourcePort();
	
	void setTCPSourcePort(Long value);	
	
	public Long getUDPSourcePort();
	
	void setUDPSourcePort(Long value);	
	
	public InetAddress getUELocalIPAddress();
	
	void setUELocalIPAddress(InetAddress value);	
	
	public NetLocAccessSupportEnum getNetLocAccessSupport();
	
	void setNetLocAccessSupport(NetLocAccessSupportEnum value);
				
	public WirelineUserLocationInfo getWirelineUserLocationInfo();
				
	void setWirelineUserLocationInfo(WirelineUserLocationInfo value);
				
	List<ByteBuf> getDiameterClass();

	void setDiameterClass(List<ByteBuf> value);	
		
	public List<Load> getLoad();
	
	void setLoad(List<Load> value);
}