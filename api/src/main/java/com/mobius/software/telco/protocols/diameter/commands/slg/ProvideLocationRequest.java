package com.mobius.software.telco.protocols.diameter.commands.slg;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LCSClientTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.slg.AreaEventInfo;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LCSEPSClientName;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LCSPrivacyCheckNonSession;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LCSPrivacyCheckSession;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LCSQoS;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LCSRequestorName;
import com.mobius.software.telco.protocols.diameter.primitives.slg.MotionEventInfo;
import com.mobius.software.telco.protocols.diameter.primitives.slg.PeriodicLDRInfo;
import com.mobius.software.telco.protocols.diameter.primitives.slg.ReportingPLMNList;
import com.mobius.software.telco.protocols.diameter.primitives.slg.SLgLocationTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.slg.VelocityRequestedEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.1	Provide-Location-Request (PLR) Command
	The Provide-Location-Request (PLR) command, indicated by the Command-Code field set to 8388620 and the 'R' bit set in the Command Flags field, is sent by the GMLC in order to request subscriber location to the MME or SGSN.
	Message Format

	< Provide-Location-Request> ::=	< Diameter Header: 8388620, REQ, PXY, 16777255 >
				 < Session-Id >
				 [ DRMP ]
				 [ Vendor-Specific-Application-Id ]
				 { Auth-Session-State }
				 { Origin-Host }
				 { Origin-Realm }
				 { Destination-Host }
				 { Destination-Realm }
				 { SLg-Location-Type }
				 [ User-Name ]
				 [ MSISDN ]
				 [ IMEI ]
				 { LCS-EPS-Client-Name }
				 { LCS-Client-Type }
				 [ LCS-Requestor-Name ]
				 [ LCS-Priority ]
				 [ LCS-QoS ]
				 [ Velocity-Requested ]
				 [ LCS-Supported-GAD-Shapes ]
				 [ LCS-Service-Type-ID ]
				 [ LCS-Codeword ]
				 [ LCS-Privacy-Check-Non-Session ]
				 [ LCS-Privacy-Check-Session ]
				 [ Service-Selection ]
				 [ Deferred-Location-Type ]
				 [ LCS-Reference-Number ]
				 [ Area-Event-Info ]
				 [ GMLC-Address ]
				 [ PLR-Flags ]
				 [ Periodic-LDR-Information ]
				 [ Reporting-PLMN-List ]
				 [ Motion-Event-Info ]
				*[ Supported-Features ]
				*[ AVP ]
				*[ Proxy-Info ]
				*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = 16777255, commandCode = 8388620, request = true, proxyable = true, name="Provide-Location-Request")
public interface ProvideLocationRequest extends SlgRequest
{
	SLgLocationTypeEnum getSLgLocationType();
	
	void setSLgLocationType(SLgLocationTypeEnum value);
	
	String getMSISDN();
	
	void setMSISDN(String value);
	
	String getIMEI();
	 
	void setIMEI(String value);
	 		
	LCSEPSClientName getLCSEPSClientName();
	
	void setLCSEPSClientName(LCSEPSClientName value);
	
	LCSClientTypeEnum getLCSClientType();
	
	void setLCSClientType(LCSClientTypeEnum value);	
	
	LCSRequestorName getLCSRequestorName();
	
	void setLCSRequestorName(LCSRequestorName value);	
	
	Long getLCSPriority();
	
	void setLCSPriority(Long value);	
	
	LCSQoS getLCSQoS();
	
	void setLCSQoS(LCSQoS value);	
	
	VelocityRequestedEnum getVelocityRequested();
	
	void setVelocityRequested(VelocityRequestedEnum value);	
	
	Long getLCSSupportedGADShapes();
	
	void setLCSSupportedGADShapes(Long value);
	
	Long getLCSServiceTypeID();
	
	void setLCSServiceTypeID(Long value);	
	
	String getLCSCodeword();
	
	void setLCSCodeword(String value);	
	
	LCSPrivacyCheckNonSession getLCSPrivacyCheckNonSession();
	
	void setLCSPrivacyCheckNonSession(LCSPrivacyCheckNonSession value);			
	
	LCSPrivacyCheckSession getLCSPrivacyCheckSession();
	
	void setLCSPrivacyCheckSession(LCSPrivacyCheckSession value);	
	
	String getServiceSelection();
	
	void setServiceSelection(String value);	
	
	Long getDeferredLocationType();
	
	void setDeferredLocationType(Long value);	
	
	ByteBuf getLCSReferenceNumber();
	
	void setLCSReferenceNumber(ByteBuf value);
	
	AreaEventInfo getAreaEventInfo();
	
	void setAreaEventInfo(AreaEventInfo value);
	
	InetAddress getGMLCAddress();
	
	void setGMLCAddress(InetAddress value);
	
	Long getPLRFlags();
	
	void setPLRFlags(Long value);
	
	PeriodicLDRInfo getPeriodicLDRInformation();
	
	void setPeriodicLDRInformation(PeriodicLDRInfo value);
	
	ReportingPLMNList getReportingPLMNList();
	
	void setReportingPLMNList(ReportingPLMNList value);
	
	MotionEventInfo getMotionEventInfo();
	
	void setMotionEventInfo(MotionEventInfo value);
}