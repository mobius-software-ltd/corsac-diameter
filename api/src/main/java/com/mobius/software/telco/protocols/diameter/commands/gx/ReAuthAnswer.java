package com.mobius.software.telco.protocols.diameter.commands.gx;
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
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UserCSGInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleReport;
import com.mobius.software.telco.protocols.diameter.primitives.gx.DefaultQoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.IPCANTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NetLocAccessSupportEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMPEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sta.ANTrustedEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.6.5	Re-Auth-Answer (RAA) Command
	The RAA command, indicated by the Command-Code field set to 258 and the 'R' bit cleared in the Command Flags field, is sent by the PCEF to the PCRF in response to the RAR command.
	Message Format:

	<RA-Answer> ::=  < Diameter Header: 258, PXY >
				  < Session-Id >
				  [ DRMP ]
				  { Origin-Host }
				  { Origin-Realm }
				  [ Result-Code ]
				  [ Experimental-Result ]
				  [ Origin-State-Id ]
				  [ OC-Supported-Features ]
				  [ OC-OLR ]
				  [ IP-CAN-Type ]
				  [ RAT-Type ]
				  [ AN-Trusted ]
			  0*2 [ AN-GW-Address ]
				  [ 3GPP-SGSN-MCC-MNC ]
				  [ 3GPP-SGSN-Address ]
				  [ 3GPP-SGSN-Ipv6-Address ]
				  [ RAI ]
				  [ 3GPP-User-Location-Info ]
				  [ User-Location-Info-Time ]
				  [ NetLoc-Access-Support ]
				  [ User-CSG-Information ]
				  [ 3GPP-MS-TimeZone ]
				  [ Default-QoS-Information ]
				* [ Charging-Rule-Report]
				  [ Error-Message ]
				  [ Error-Reporting-Host ] 
				  [ Failed-AVP ]
				* [ Proxy-Info ]
				* [ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.GX, commandCode = CommandCodes.REAUTH, request = false, proxyable = true, name="Re-Auth-Answer")
public interface ReAuthAnswer extends com.mobius.software.telco.protocols.diameter.commands.commons.ReAuthAnswer
{
	DRMPEnum getDRMP();
	
	void setDRMP(DRMPEnum value);
	
	OCSupportedFeatures getOCSupportedFeatures();
	
	void setOCSupportedFeatures(OCSupportedFeatures value);
	
	OCOLR getOCOLR();
	 
	void setOCOLR(OCOLR value);
	
	IPCANTypeEnum getIPCANType();
	
	void setIPCANType(IPCANTypeEnum value);
	
	RATTypeEnum getRATType();
	
	void setRATType(RATTypeEnum value);
	
	ANTrustedEnum getANTrusted();
	
	void setANTrusted(ANTrustedEnum value);	
	
	List<InetAddress> getANGWAddress();
	
	void setANGWAddress(List<InetAddress> value) throws AvpOccursTooManyTimesException;
	
	String getTGPPSGSNMCCMNC();
	
	void setTGPPSGSNMCCMNC(String value);	
	
	ByteBuf getTGPPSGSNAddress();
	
	void setTGPPSGSNAddress(ByteBuf value);
	
	ByteBuf getTGPPSGSNIPv6Address();
	
	void setTGPPSGSNIPv6Address(ByteBuf value);
	
	String getRAI();
	
	void setRAI(String value);
	
	ByteBuf getTGPPUserLocationInfo();
	
	void setTGPPUserLocationInfo(ByteBuf value);
	
	Date getUserLocationInfoTime();
	
	void setUserLocationInfoTime(Date value);	
	
	NetLocAccessSupportEnum getNetLocAccessSupport();
	
	void setNetLocAccessSupport(NetLocAccessSupportEnum value);	
	
	UserCSGInformation getUserCSGInformation();
	
	void setUserCSGInformation(UserCSGInformation value);
	
	ByteBuf getTGPPMSTimeZone();
	
	void setTGPPMSTimeZone(ByteBuf value);	

	public DefaultQoSInformation getDefaultQoSInformation();	
	
	void setDefaultQoSInformation(DefaultQoSInformation value);
	
	List<ChargingRuleReport> getChargingRuleReport();
	
	void setChargingRuleReport(List<ChargingRuleReport> value);	
}