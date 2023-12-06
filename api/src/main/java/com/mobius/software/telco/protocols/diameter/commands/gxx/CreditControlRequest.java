package com.mobius.software.telco.protocols.diameter.commands.gxx;
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

import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationRequest;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UserCSGInformation;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfoExtension;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gx.DefaultEPSBearerQoS;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventTriggerEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.IPCANTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NetworkRequestSupportEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PacketFilterInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PacketFilterOperationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gxx.QoSRuleReport;
import com.mobius.software.telco.protocols.diameter.primitives.gxx.SessionLinkingIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMPEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TraceData;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5a.6.2	CC-Request (CCR) Command
	The CCR command, indicated by the Command-Code field set to 272 and the 'R' bit set in the Command Flags field, is sent by the BBERF to the PCRF in order to request QoS rules. The CCR command is also sent by the BBERF to the PCRF in order to indicate QoS rule related events or the termination of the Gateway Control session.
	Message Format:

	<CC-Request> ::= < Diameter Header: 272, REQ, PXY >
				  < Session-Id >
				  [ DRMP ]
				  { Auth-Application-Id }
				  { Origin-Host }
				  { Origin-Realm }
				  { Destination-Realm }
				  { CC-Request-Type }
				  { CC-Request-Number }
				  [ Destination-Host ]
				  [ Origin-State-Id ]
				  [ OC-Supported-Features ]
				* [ Supported-Features ]
				* [ Subscription-Id ]
				  [ Network-Request-Support ]
				* [ Packet-Filter-Information ]
				  [ Packet-Filter-Operation ]
				  [ Framed-IP-Address ]
				  [ Framed-Ipv6-Prefix ]
				  [ IP-CAN-Type ]
				  [ RAT-Type ]
				  [ Termination-Cause ]
				  [ User-Equipment-Info ]
				  [ User-Equipment-Info-Extension ]
				  [ QoS-Information ] 
				  [ Default-EPS-Bearer-QoS ]
			  0*2 [ AN-GW-Address ]
				  [ 3GPP-SGSN-MCC-MNC ]
				  [ RAI ]
				  [ 3GPP-User-Location-Info]
				  [ User-Location-Info-Time ]
 				  [ 3GPP-MS-TimeZone ]
				  [ 3GPP2-BSID ]
				  [ User-CSG-Information ]
				  [ HeNB-Local-IP-Address ]
				  [ UE-Local-IP-Address ]
				  [ UDP-Source-Port ]
				  [ Called-Station-Id ]
				  [ PDN-Connection-ID ]
				* [ QoS-Rule-Report]
				* [ Event-Trigger]
				  [ Session-Linking-Indicator ]
				  [ Trace-Data ]
				  [ Trace-Reference ]
				* [ Proxy-Info ]
				* [ Route-Record ]
				* [ AVP ]
 */
@DiameterCommandDefinition(applicationId = 16777266, commandCode = 272, request = true, proxyable = true, name="Credit-Control-Request")
public interface CreditControlRequest extends AuthenticationRequest
{
	DRMPEnum getDRMP();
	
	void setDRMP(DRMPEnum value);
	
	CcRequestTypeEnum getCcRequestType();
	
	void setCcRequestType(CcRequestTypeEnum value);
	
	Long getCcRequestNumber();
	
	void setCcRequestNumber(Long value);
	
	OCSupportedFeatures getOCSupportedFeatures();
	
	void setOCSupportedFeatures(OCSupportedFeatures value);
	
	public List<SupportedFeatures> getSupportedFeatures();
	 
	void setSupportedFeatures(List<SupportedFeatures> value);
	
	public List<SubscriptionId> getSubscriptionId();
	
	void setSubscriptionId(List<SubscriptionId> value);

	NetworkRequestSupportEnum getNetworkRequestSupport();
	
	void setNetworkRequestSupport(NetworkRequestSupportEnum value);
	
	public List<PacketFilterInformation> getPacketFilterInformation();
	 
	void setPacketFilterInformation(List<PacketFilterInformation> value);
	
	PacketFilterOperationEnum getPacketFilterOperation();
	
	void setPacketFilterOperation(PacketFilterOperationEnum value);
	
	InetAddress getFramedIPAddress();
	
	void setFramedIPAddress(Inet4Address value);	
	
	ByteBuf getFramedIPv6Prefix();
	
	void setFramedIPv6Prefix(ByteBuf value);
	
	IPCANTypeEnum getIPCANType();
	
	void setIPCANType(IPCANTypeEnum value);
	
	RATTypeEnum getRATType();
	
	void setRATType(RATTypeEnum value);
	
	public TerminationCauseEnum getTerminationCause();
	
	void setTerminationCause(TerminationCauseEnum value);
	
	public UserEquipmentInfo getUserEquipmentInfo();
	
	void setUserEquipmentInfo(UserEquipmentInfo value);
	
	public UserEquipmentInfoExtension getUserEquipmentInfoExtension();
	
	void setUserEquipmentInfoExtension(UserEquipmentInfoExtension value);
	
	public QoSInformation getQoSInformation();
	
	void setQoSInformation(QoSInformation value);
	
	public DefaultEPSBearerQoS getDefaultEPSBearerQoS();
	
	void setDefaultEPSBearerQoS(DefaultEPSBearerQoS value);
	
	List<InetAddress> getANGWAddress();
	
	void setANGWAddress(List<InetAddress> value);
	
	String getTGPPSGSNMCCMNC();
	
	void setTGPPSGSNMCCMNC(String value);	
	
	String getRAI();
	
	void setRAI(String value);	
	
	ByteBuf getTGPPUserLocationInfo();
	
	void setTGPPUserLocationInfo(ByteBuf value);	
	
	Date getUserLocationInfoTime();
	
	void setUserLocationInfoTime(Date value);	
	
	ByteBuf getTGPPMSTimeZone();
	
	void setTGPPMSTimeZone(ByteBuf value);	

	ByteBuf getTGPP2BSID();
	
	void setTGPP2BSID(ByteBuf value);	

	UserCSGInformation getUserCSGInformation();
	
	void setUserCSGInformation(UserCSGInformation value);	
	
	InetAddress getHeNBLocalIPAddress();
	
	void setHeNBLocalIPAddress(InetAddress value);	
	
	InetAddress getUELocalIPAddress();
	
	void setUELocalIPAddress(InetAddress value);	
	
	Long getUDPSourcePort();
	
	void setUDPSourcePort(Long value);	
	
	String getCalledStationId();
	
	void setCalledStationId(String value);	
	
	ByteBuf getPDNConnectionID();
	
	void setPDNConnectionID(ByteBuf value);	
	
	List<QoSRuleReport> getQoSRuleReport();
	
	void setQoSRuleReport(List<QoSRuleReport> value);	
	
	List<EventTriggerEnum> getEventTrigger();
	
	void setEventTrigger(List<EventTriggerEnum> value);	
	
	SessionLinkingIndicatorEnum getSessionLinkingIndicator();
	
	void setSessionLinkingIndicator(SessionLinkingIndicatorEnum value);
	
	TraceData getTraceData();
	
	void setTraceData(TraceData value);
	
	ByteBuf getTraceReference();
	
	void setTraceReference(ByteBuf value);
}