package com.mobius.software.telco.protocols.diameter.primitives.gy;
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
import java.util.List;

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.PDNTypeEnum;

import io.netty.buffer.ByteBuf;



/*
  				3.2.7 Diameter Gy CCR – PS-Information grouped AVP
		Grouped AVP format as defined in TS 32.299:
		
				PS-Information :: = < AVP Header: 874>
						[ 3GPP-Charging-Id ]
						[ PDN-Connection Charging-Id ]
						[ PDN-Type ]
						[ PDP-Address ]
						[ PDP-Address-Prefix-Length ]
						[ 3GPP-GPRS-Negotiated-QoS-Profile ]
						[ GGSN-Address  ]
						[ TDF-IP-Address ]
						[ TGPP-IMSI-MCC-MNC ]
						[ 3GPP-GGSN-MCC-MNC  ]
						[ TDF-MCC-MNC ]
					    [ Called-Station-Id ]
						[ Session-Stop-Indicator ]
						[ Selection-Mode ]
						[ MS-Time-Zone ] 
						[ User-Location-Info ]
						[ RAT-Type ] 
*/
@DiameterAvpDefinition(code = TgppAvpCodes.PS_INFORMATION, vendorId = VendorIDs.TGPP_ID, name = "PS-Information")
public interface PSInformation extends DiameterAvp
{
	ByteBuf get3GPPChargingId();
	
	void set3GPPChargingId(ByteBuf value);

	Long getPDNConnectionChargingID();
	
	void setPDNConnectionChargingID(Long value);
	
	PDNTypeEnum getPDNType();
	
	void setPDNType(PDNTypeEnum value);
	
	List<InetAddress> getPDPAddress();
	
	void setPDPAddress(List<InetAddress> value);
	
	Long getPDPAddressPrefixLength();
	
	void setPDPAddressPrefixLength(Long value);
	
	String getTGPPGPRSNegotiatedQoSProfile();
	
	void setTGPPGPRSNegotiatedQoSProfile(String value);	
	
	ByteBuf getTGPPGGSNAddress();
	
	void setTGPPGGSNAddress(ByteBuf value);	
	
	List<InetAddress> getTDFIPAddress();
	
	void setTDFIPAddress(List<InetAddress> value);
	
	String getTGPPIMSIMCCMNC();
	
	void setTGPPIMSIMCCMNC(String value);
	
	String getTGPPGGSNMCCMNC ();
	
	void setTGPPGGSNMCCMNC(String value);
	
	String getCalledStationId();
	
	void setCalledStationId(String value);	
	
	ByteBuf getTGPPSessionStopIndicator();
	
	void setTGPPSessionStopIndicator(ByteBuf value);
	
	String getTGPPSelectionMode();
	
	void setTGPPSelectionMode(String value);	
	
	public ByteBuf getTGPPMSTimeZone();
	
	void setTGPPMSTimeZone(ByteBuf value);
	 
	ByteBuf get3GPPUserLocationInfo();
	
	void set3GPPUserLocationInfo(ByteBuf value);
	
	ByteBuf getTGPPRATType();
	
	void setTGPPRATType(ByteBuf value);	
	
	
}