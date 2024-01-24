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

import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationRequest;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.DynamicAddressFlagEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.DynamicAddressFlagExtensionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ServiceInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UserCSGInformation;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfoExtension;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ANGWStatusEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.AccessAvailabilityChangeReasonEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.AccessNetworkChargingIdentifierGx;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ApplicationDetectionInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.BearerOperationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.BearerUsageEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleReport;
import com.mobius.software.telco.protocols.diameter.primitives.gx.CoAInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.CreditManagementStatus;
import com.mobius.software.telco.protocols.diameter.primitives.gx.DefaultEPSBearerQoS;
import com.mobius.software.telco.protocols.diameter.primitives.gx.DefaultQoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventReportIndication;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventTriggerEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.FixedUserLocationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.gx.IPCANTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NBIFOMModeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NBIFOMSupportEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NetworkRequestSupportEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.OfflineEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.OnlineEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PacketFilterInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PacketFilterOperationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PresenceReportingAreaInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSNegotiationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSUpgradeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RoutingRuleInstall;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RoutingRuleRemove;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TDFInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TFTPacketFilterInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TGPPPSDataOffStatusEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UsageMonitoringInformation;
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
 * 	5.6.2	CC-Request (CCR) Command
	The CCR command, indicated by the Command-Code field set to 272 and the 'R' bit set in the Command Flags field, is sent by the PCEF to the PCRF in order to request PCC rules for a bearer and provision IP flow mobility routing rules. The CCR command is also sent by the PCEF to the PCRF in order to indicate bearer, PCC rule or IP flow mobility routing rule related events or the termination of the IP CAN bearer and/or session.
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
				 [ Credit-Management-Status ]
				 [ Destination-Host ]
				 [ Origin-State-Id ]
				*[ Subscription-Id ]
				 [ OC-Supported-Features ]
				*[ Supported-Features ] 
				 [ TDF-Information ]
				 [ Network-Request-Support ]
				*[ Packet-Filter-Information ]
				 [ Packet-Filter-Operation ]
				 [ Bearer-Identifier ]
				 [ Bearer-Operation ]
				 [ Dynamic-Address-Flag ]
				 [ Dynamic-Address-Flag-Extension ]
				 [ PDN-Connection-Charging-ID ]
				 [ Framed-IP-Address ]
				 [ Framed-Ipv6-Prefix ]
				 [ IP-CAN-Type ]
				 [ 3GPP-RAT-Type ]
				 [ AN-Trusted ]
				 [ RAT-Type ]
				 [ Termination-Cause ]
				 [ User-Equipment-Info ]
				 [ User-Equipment-Info-Extension ]
				 [ QoS-Information ] 
				 [ QoS-Negotiation ]
				 [ QoS-Upgrade ]
				 [ Default-EPS-Bearer-QoS ] 
				 [ Default-QoS-Information ]
			 0*2 [ AN-GW-Address ]
				 [ AN-GW-Status ]
				 [ 3GPP-SGSN-MCC-MNC ]
				 [ 3GPP-SGSN-Address ]
				 [ 3GPP-SGSN-Ipv6-Address ]
				 [ 3GPP-GGSN-Address ]
				 [ 3GPP-GGSN-Ipv6-Address ]
				 [ 3GPP-Selection-Mode ]
				 [ RAI ]
				 [ 3GPP-User-Location-Info ]
				 [ Fixed-User-Location-Info ]
				 [ User-Location-Info-Time ]
				 [ User-CSG-Information ]
				 [ TWAN-Identifier ]
				 [ 3GPP-MS-TimeZone ]
				*[ RAN-NAS-Release-Cause ]
				 [ 3GPP-Charging-Characteristics ]
				 [ Called-Station-Id ]
				 [ PDN-Connection-ID ]
				 [ Bearer-Usage ]
				 [ Online ]
				 [ Offline ]
				*[ TFT-Packet-Filter-Information ]
				*[ Charging-Rule-Report ]
				*[ Application-Detection-Information ]
				*[ Event-Trigger ]
				 [ Event-Report-Indication ]
				 [ Access-Network-Charging-Address ]
				*[ Access-Network-Charging-Identifier-Gx ]
				*[ CoA-Information ]
				*[ Usage-Monitoring-Information ]
				 [ NBIFOM-Support ]
				 [ NBIFOM-Mode ]
				 [ Default-Access ]
				 [ Origination-Time-Stamp ]
				 [ Maximum-Wait-Time ]
				 [ Access-Availability-Change-Reason ]
				 [ Routing-Rule-Install ]
				 [ Routing-Rule-Remove ]
				 [ HeNB-Local-IP-Address ]
				 [ UE-Local-IP-Address ]
				 [ UDP-Source-Port ]
				 [ TCP-Source-Port ]
				*[ Presence-Reporting-Area-Information ]
				 [ Logical-Access-ID ]
				 [ Physical-Access-ID ]
				*[ Proxy-Info ]
				*[ Route-Record ]
				 [ 3GPP-PS-Data-Off-Status ]
				*[ AVP ]
				
	NOTE:	Multiple instances of the Subscription-Id AVP in the CCR command correspond to multiple types of identifier for the same subscriber, for example IMSI and MSISDN.
 */
@DiameterCommandDefinition(applicationId = 16777238, commandCode = 272, request = true, proxyable = true, name="Credit-Control-Request")
public interface CreditControlRequest extends AuthenticationRequest
{
	DRMPEnum getDRMP();
	
	void setDRMP(DRMPEnum value);
	
	CcRequestTypeEnum getCcRequestType();
	
	void setCcRequestType(CcRequestTypeEnum value);
	
	Long getCcRequestNumber();
	
	void setCcRequestNumber(Long value);
	
	CreditManagementStatus getCreditManagementStatus();
	
	void setCreditManagementStatus(CreditManagementStatus value);
	
	public List<SubscriptionId> getSubscriptionId();
	
	void setSubscriptionId(List<SubscriptionId> value);

	OCSupportedFeatures getOCSupportedFeatures();
	
	void setOCSupportedFeatures(OCSupportedFeatures value);
	
	ServiceInformation getServiceInformation();
	
	void setServiceInformation(ServiceInformation value);
	
	public List<SupportedFeatures> getSupportedFeatures();
	 
	void setSupportedFeatures(List<SupportedFeatures> value);
	
	TDFInformation getTDFInformation();
	
	void setTDFInformation(TDFInformation value);
	
	NetworkRequestSupportEnum getNetworkRequestSupport();
	
	void setNetworkRequestSupport(NetworkRequestSupportEnum value);
	
	public List<PacketFilterInformation> getPacketFilterInformation();
	 
	void setPacketFilterInformation(List<PacketFilterInformation> value);
	
	PacketFilterOperationEnum getPacketFilterOperation();
	
	void setPacketFilterOperation(PacketFilterOperationEnum value);
	
	ByteBuf getBearerIdentifier();
	
	void setBearerIdentifier(ByteBuf value);
	
	BearerOperationEnum getBearerOperation();
	
	void setBearerOperation(BearerOperationEnum value);
	
	DynamicAddressFlagEnum getDynamicAddressFlag();
	
	void setDynamicAddressFlag(DynamicAddressFlagEnum value);
	
	DynamicAddressFlagExtensionEnum getDynamicAddressFlagExtension();
	
	void setDynamicAddressFlagExtension(DynamicAddressFlagExtensionEnum value);
	
	Long getPDNConnectionChargingID();
	
	void setPDNConnectionChargingID(Long value);
	
	InetAddress getFramedIPAddress();
	
	void setFramedIPAddress(Inet4Address value);	
	
	ByteBuf getFramedIPv6Prefix();
	
	void setFramedIPv6Prefix(ByteBuf value);
	
	IPCANTypeEnum getIPCANType();
	
	void setIPCANType(IPCANTypeEnum value);
	
	ByteBuf getTGPPRATType();
	
	void setTGPPRATType(ByteBuf value);	
	
	ANTrustedEnum getANTrusted();
	
	void setANTrusted(ANTrustedEnum value);	
	
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
	
	public QoSNegotiationEnum getQoSNegotiation();
	
	void setQoSNegotiation(QoSNegotiationEnum value);
	
	public QoSUpgradeEnum getQoSUpgrade();
	
	void setQoSUpgrade(QoSUpgradeEnum value);
	
	public DefaultEPSBearerQoS getDefaultEPSBearerQoS();
	
	void setDefaultEPSBearerQoS(DefaultEPSBearerQoS value);
	
	public DefaultQoSInformation getDefaultQoSInformation();
	
	void setDefaultQoSInformation(DefaultQoSInformation value);
	
	List<InetAddress> getANGWAddress();
	
	void setANGWAddress(List<InetAddress> value);
	
	public ANGWStatusEnum getANGWStatus();
	
	void setANGWStatus(ANGWStatusEnum value);
	
	String getTGPPSGSNMCCMNC();
	
	void setTGPPSGSNMCCMNC(String value);	
	
	ByteBuf getTGPPSGSNAddress();
	
	void setTGPPSGSNAddress(ByteBuf value);
	
	ByteBuf getTGPPSGSNIPv6Address();
	
	void setTGPPSGSNIPv6Address(ByteBuf value);
	
	ByteBuf getTGPPGGSNAddress();
	
	void setTGPPGGSNAddress(ByteBuf value);	
	
	ByteBuf getTGPPGGSNIPv6Address();
	
	void setTGPPGGSNIPv6Address(ByteBuf value);	
	
	String getTGPPSelectionMode();
	
	void setTGPPSelectionMode(String value);
	
	String getRAI();
	
	void setRAI(String value);	
	
	ByteBuf getTGPPUserLocationInfo();
	
	void setTGPPUserLocationInfo(ByteBuf value);	
	
	FixedUserLocationInfo getFixedUserLocationInfo();
	
	void setFixedUserLocationInfo(FixedUserLocationInfo value);	
	
	Date getUserLocationInfoTime();
	
	void setUserLocationInfoTime(Date value);	
	
	UserCSGInformation getUserCSGInformation();
	
	void setUserCSGInformation(UserCSGInformation value);	
	
	ByteBuf getTWANIdentifier();
	
	void setTWANIdentifier(ByteBuf value);	
	
	ByteBuf getTGPPMSTimeZone();
	
	void setTGPPMSTimeZone(ByteBuf value);	

	List<ByteBuf> getRANNASReleaseCause();

	void setRANNASReleaseCause(List<ByteBuf> value);
	
	String getTGPPChargingCharacteristics();
	
	void setTGPPChargingCharacteristics(String value);
	
	String getCalledStationId();
	
	void setCalledStationId(String value);	
	
	ByteBuf getPDNConnectionID();
	
	void setPDNConnectionID(ByteBuf value);	
	
	BearerUsageEnum getBearerUsage();
	
	void setBearerUsage(BearerUsageEnum value);	
	
	OnlineEnum getOnline();
	
	void setOnline(OnlineEnum value);	
	
	OfflineEnum getOffline();
	
	void setOffline(OfflineEnum value);	
	
	List<TFTPacketFilterInformation> getTFTPacketFilterInformation();
	
	void setTFTPacketFilterInformation(List<TFTPacketFilterInformation> value);	
	
	List<ChargingRuleReport> getChargingRuleReport();
	
	void setChargingRuleReport(List<ChargingRuleReport> value);	
	
	List<ApplicationDetectionInformation> getApplicationDetectionInformation();
	
	void setApplicationDetectionInformation(List<ApplicationDetectionInformation> value);	
	
	List<EventTriggerEnum> getEventTrigger();
	
	void setEventTrigger(List<EventTriggerEnum> value);	
	
	EventReportIndication getEventReportIndication();
	
	void setEventReportIndication(EventReportIndication value);	
	
	InetAddress getAccessNetworkChargingAddress();
	
	void setAccessNetworkChargingAddress(InetAddress value);	
	
	List<AccessNetworkChargingIdentifierGx> getAccessNetworkChargingIdentifierGx();
	
	void setAccessNetworkChargingIdentifierGx(List<AccessNetworkChargingIdentifierGx> value);	
	
	List<CoAInformation> getCoAInformation();
	
	void setCoAInformation(List<CoAInformation> value);	
	
	List<UsageMonitoringInformation> getUsageMonitoringInformation();
	
	void setUsageMonitoringInformation(List<UsageMonitoringInformation> value);	
	
	NBIFOMSupportEnum getNBIFOMSupport();
	
	void setNBIFOMSupport(NBIFOMSupportEnum value);	
	
	NBIFOMModeEnum getNBIFOMMode();
	
	void setNBIFOMMode(NBIFOMModeEnum value);	
	
	IPCANTypeEnum getDefaultAccess();
	
	void setDefaultAccess(IPCANTypeEnum value);	
	
	Long getOriginationTimeStamp();
	
	void setOriginationTimeStamp(Long value);	
	
	Long getMaximumWaitTime();
	
	void setMaximumWaitTime(Long value);	
	
	AccessAvailabilityChangeReasonEnum getAccessAvailabilityChangeReason();
	
	void setAccessAvailabilityChangeReason(AccessAvailabilityChangeReasonEnum value);	
	
	RoutingRuleInstall getRoutingRuleInstall();
	
	void setRoutingRuleInstall(RoutingRuleInstall value);	
	
	RoutingRuleRemove getRoutingRuleRemove();
	
	void setRoutingRuleRemove(RoutingRuleRemove value);	
	
	InetAddress getHeNBLocalIPAddress();
	
	void setHeNBLocalIPAddress(InetAddress value);	
	
	InetAddress getUELocalIPAddress();
	
	void setUELocalIPAddress(InetAddress value);	
	
	Long getUDPSourcePort();
	
	void setUDPSourcePort(Long value);	
	
	Long getTCPSourcePort();
	
	void setTCPSourcePort(Long value);	
	
	List<PresenceReportingAreaInformation> getPresenceReportingAreaInformation();
	
	void setPresenceReportingAreaInformation(List<PresenceReportingAreaInformation> value);	
	
	ByteBuf getLogicalAccessID();
	
	void setLogicalAccessID(ByteBuf value);	
	
	String getPhysicalAccessID();
	
	void setPhysicalAccessID(String value);	
	
	TGPPPSDataOffStatusEnum getTGPPPSDataOffStatus();
	
	void setTGPPPSDataOffStatus(TGPPPSDataOffStatusEnum value);	
}