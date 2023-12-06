package com.mobius.software.telco.protocols.diameter.commands.s9;
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
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationRequest;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UserCSGInformation;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventTriggerEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.IPCANTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NetworkRequestSupportEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PacketFilterInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PacketFilterOperationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSNegotiationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSUpgradeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gxx.QoSRuleReport;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMPEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s9.SubsessionEnforcementInfo;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.5.2	CC-Request (CCR) Command
	The CCR command, indicated by the Command-Code field set to 272 and the 'R' bit set in the Command Flags field, is sent by the V-PCRF to the H-PCRF in order to request PCC or QoS rules. The CCR command is also sent by the V-PCRF to the H-PCRF in order to indicate bearer or PCC/QoS rule related events.
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
				*[ Subscription-Id ]
                 [ Framed-IP-Address ]
                 [ Framed-IPv6-Prefix ]
				*[ Supported-Features ]
				 [ OC-Supported-Features ]
                 [ QoS-Information ]
                *[ QoS-Rule-Report ]
             0*2 [ AN-GW-Address ]
				 [ Network-Request-Support ]
				*[ Packet-Filter-Information ]
				 [ Packet-Filter-Operation ]
                *[ Subsession-Enforcement-Info ]
				 [ IP-CAN-Type ]
				 [ RAT-Type ]
				 [ Termination-Cause ]
				 [ User-Equipment-Info ]
                 [ QoS-Negotiation ]
                 [ QoS-Upgrade ]
				 [ 3GPP-SGSN-MCC-MNC ]
				 [ 3GPP-SGSN-Address ]
				 [ 3GPP-SGSN-IPv6-Address ]
				 [ RAI ]
				 [ 3GPP-User-Location-Info]
				 [ 3GPP-MS-TimeZone ]
				 [ 3GPP2-BSID ]
				*[ Event-Trigger]
				 [ Multiple-BBERF-Action ]
				 [ User-CSG-Information ]				
                *[ Proxy-Info ]
				*[ Route-Record ]
				*[ AVP ]

	NOTE:	Multiple instances of the Subscription-Id AVP in the CCR command correspond to multiple types of identifier for the same subscriber, for example IMSI and MSISDN.
 */
@DiameterCommandDefinition(applicationId = 16777267, commandCode = 272, request = true, proxyable = true, name="Credit-Control-Request")
public interface CreditControlRequest extends AuthenticationRequest
{
	DRMPEnum getDRMP();
	
	void setDRMP(DRMPEnum value);
	
	CcRequestTypeEnum getCcRequestType();
	
	void setCcRequestType(CcRequestTypeEnum value);
	
	Long getCcRequestNumber();
	
	void setCcRequestNumber(Long value);
	
	public List<SubscriptionId> getSubscriptionId();
	
	void setSubscriptionId(List<SubscriptionId> value);

	InetAddress getFramedIPAddress();
	
	void setFramedIPAddress(Inet4Address value);	
	
	ByteBuf getFramedIPv6Prefix();
	
	void setFramedIPv6Prefix(ByteBuf value);
	
	public List<SupportedFeatures> getSupportedFeatures();
	 
	void setSupportedFeatures(List<SupportedFeatures> value);
	
	OCSupportedFeatures getOCSupportedFeatures();
	
	void setOCSupportedFeatures(OCSupportedFeatures value);
	
	public QoSInformation getQoSInformation();
	
	void setQoSInformation(QoSInformation value);
	
	List<QoSRuleReport> getQoSRuleReport();
	
	void setQoSRuleReport(List<QoSRuleReport> value);	
	
	List<InetAddress> getANGWAddress();
	
	void setANGWAddress(List<InetAddress> value);
	
	NetworkRequestSupportEnum getNetworkRequestSupport();
	
	void setNetworkRequestSupport(NetworkRequestSupportEnum value);
	
	public List<PacketFilterInformation> getPacketFilterInformation();
	 
	void setPacketFilterInformation(List<PacketFilterInformation> value);
	
	PacketFilterOperationEnum getPacketFilterOperation();
	
	void setPacketFilterOperation(PacketFilterOperationEnum value);
	
	List<SubsessionEnforcementInfo> getSubsessionEnforcementInfo();
	
	void setSubsessionEnforcementInfo(List<SubsessionEnforcementInfo> value);
	
	IPCANTypeEnum getIPCANType();
	
	void setIPCANType(IPCANTypeEnum value);
	
	RATTypeEnum getRATType();
	
	void setRATType(RATTypeEnum value);
	
	public TerminationCauseEnum getTerminationCause();
	
	void setTerminationCause(TerminationCauseEnum value);
	
	public UserEquipmentInfo getUserEquipmentInfo();
	
	void setUserEquipmentInfo(UserEquipmentInfo value);
	
	public QoSNegotiationEnum getQoSNegotiation();
	
	void setQoSNegotiation(QoSNegotiationEnum value);
	
	public QoSUpgradeEnum getQoSUpgrade();
	
	void setQoSUpgrade(QoSUpgradeEnum value);
	
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
	
	ByteBuf getTGPPMSTimeZone();
	
	void setTGPPMSTimeZone(ByteBuf value);	

	ByteBuf getTGPP2BSID();
	
	void setTGPP2BSID(ByteBuf value);	

	List<EventTriggerEnum> getEventTrigger();
	
	void setEventTrigger(List<EventTriggerEnum> value);	
	
	UserCSGInformation getUserCSGInformation();
	
	void setUserCSGInformation(UserCSGInformation value);
}