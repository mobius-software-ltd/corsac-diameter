package com.mobius.software.telco.protocols.diameter.primitives.s9;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UserCSGInformation;
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
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventTriggerEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.IPCANTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NBIFOMModeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NBIFOMSupportEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NetworkRequestSupportEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.OfflineEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.OnlineEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PacketFilterInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PacketFilterOperationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RoutingRuleInstall;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RoutingRuleRemove;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TFTPacketFilterInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UsageMonitoringInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gxx.QoSRuleReport;
import com.mobius.software.telco.protocols.diameter.primitives.gxx.SessionLinkingIndicatorEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.2	Subsession-Enforcement-Info
	The Subsession-Enforcement-Info AVP (AVP code 2201) is of type Grouped, and it is used to set up and tear down  subsessions, provide information about the subsession, request PCC/QoS rules and report on PCC/QoS rules and related events. This information is sent from the V-PCRF to the H-PCRF. The information contained within this grouped AVP pertains only to the subsession identified by the Subsession-Id AVP.
	The following AVPs are only applicable when the Subsession-Enforcement-Info AVP is provided within a CCR: Subsession-Operation AVP, Bearer-Identifier AVP, Bearer-Operation AVP, Packet-Filter-Information AVP, Packet-Filter-Operation AVP, Framed-IP-Address AVP, Framed-IPv6-Prefix AVP, Called-Station-ID AVP,  PDN-Connection-ID AVP, Bearer-Usage AVP, TFT-Packet-Filter-Information AVP, Online AVP, Offline AVP, Application-Detection-Information AVP, Routing-Rule-Install AVP, Routing-Rule-Remove AVP, NBIFOM-Support AVP, NBIFOM-Mode AVP, Default-Access AVP, Access-Availability-Change-Reason AVP and Credit-Management-Status AVP.
	The following AVPs are only applicable when the Subsession-Enforcement-Info AVP is provided within an RAA: Result-Code AVP and Experimental-Result-Code AVP.
	The other AVPs are applicable when the Subsession-Enforcement-Info AVP is provided in either a CCR or RAA.
	IP-CAN-Type AVP, RAT-Type AVP, 3GPP-SGSN-MCC-MNC AVP, 3GPP-SGSN-Address AVP, 3GPP-SGSN-IPv6-Address AVP, RAI AVP, 3GPP-User-Location-Info AVP, 3GPP2-BSID AVP and User-CSG-Information AVP are only applicable when the MAPCON feature is supported as described in clause 5.4.1.
	The Result-Code AVP or Experimental-Result-Code AVP may be provided to inform the H-PCRF of possible errors when processing subsession information that was provided in a corresponding RAR command.
	Subsession-Enforcement-Info ::= < AVP Header: 2201 >
                                { Subsession-Id }
                                [ Subsession-Operation ]
                             0*2[ AN-GW-Address ]
                                [ Bearer-Identifier ]
                                [ Bearer-Operation ]
                               *[ Packet-Filter-Information ]
                                [ Packet-Filter-Operation ]
                                [ QoS-Information ]
                                [ Framed-IP-Address ]
                                [ Framed-IPv6-Prefix ]
                               *[ CoA-Information ]
                                [ Called-Station-Id ]
                                [ PDN-Connection-ID ]
                                [ Bearer-Usage ]
                               *[ TFT-Packet-Filter-Information ]
                                [ Online ]
                                [ Offline ]
                                [ Result-Code ]
                                [ Experimental-Result-Code ]
                               *[ Charging-Rule-Report ]
                                [ Credit-Management-Status ]
                               *[ QoS-Rule-Report ]
                               *[ Application-Detection-Information ]
                                [ IP-CAN-Type ]
                                [ RAT-Type ]
                                [ 3GPP-SGSN-MCC-MNC ]
                                [ 3GPP-SGSN-Address ]
                                [ 3GPP-SGSN-IPv6-Address ]
                                [ RAI ]
                                [ 3GPP-User-Location-Info]
                                [ 3GPP2-BSID ]
                                [ User-CSG-Information ]
                                [ Default-EPS-Bearer-QoS ]
                                [ Default-Access ]
                                [ NBIFOM-Support ]
                                [ NBIFOM-Mode ]
                                [ Access-Availability-Change-Reason ]
                                [ Network-Request-Support ]
                                [ Routing-Rule-Install ]
                                [ Routing-Rule-Remove ]
                                [ User-Location-Info-Time ]
                                [ Logical-Access-ID ]
                                [ Physical-Access-ID ]
                               *[ Usage-Monitoring-Information ]
                                [ Multiple-BBERF-Action ]
                               *[ Event-Trigger ]
                                [ Access-Network-Charging-Address ]
                               *[ Access-Network-Charging-Identifier-Gx ]
                                [ Session-Linking-Indicator ]
                                [ HeNB-Local-IP-Address ]
                                [ UE-Local-IP-Address ]
                                [ UE-Local-IPv6-Prefix ]
                                [ UDP-Source-Port ]
                                [ AN-GW-Status ]
                               *[ AVP ]

 */
@DiameterAvpDefinition(code = 2201L, vendorId = KnownVendorIDs.TGPP_ID, name = "Subsession-Enforcement-Info")
public interface SubsessionEnforcementInfo extends DiameterGroupedAvp
{
	Long getSubsessionId();
	
	void setSubsessionId(Long value);
	
	SubsessionOperationEnum getSubsessionOperation();
	
	void setSubsessionOperation(SubsessionOperationEnum value);
		
	List<InetAddress> getANGWAddress();
	
	void setANGWAddress(List<InetAddress> value);
	
	ByteBuf getBearerIdentifier();
	
	void setBearerIdentifier(ByteBuf value);
	
	BearerOperationEnum getBearerOperation();
	
	void setBearerOperation(BearerOperationEnum value);
	
	public List<PacketFilterInformation> getPacketFilterInformation();
	 
	void setPacketFilterInformation(List<PacketFilterInformation> value);
	
	PacketFilterOperationEnum getPacketFilterOperation();
	
	void setPacketFilterOperation(PacketFilterOperationEnum value);
	
	public QoSInformation getQoSInformation();
	
	void setQoSInformation(QoSInformation value);
	
	InetAddress getFramedIPAddress();
	
	void setFramedIPAddress(Inet4Address value);	
	
	ByteBuf getFramedIPv6Prefix();
	
	void setFramedIPv6Prefix(ByteBuf value);
	
	List<CoAInformation> getCoAInformation();
	
	void setCoAInformation(List<CoAInformation> value);	
	
	String getCalledStationId();
	
	void setCalledStationId(String value);	
	
	ByteBuf getPDNConnectionID();
	
	void setPDNConnectionID(ByteBuf value);	
	
	BearerUsageEnum getBearerUsage();
	
	void setBearerUsage(BearerUsageEnum value);
	
	List<TFTPacketFilterInformation> getTFTPacketFilterInformation();
	
	void setTFTPacketFilterInformation(List<TFTPacketFilterInformation> value);	
	
	OnlineEnum getOnline();
	
	void setOnline(OnlineEnum value);	
	
	OfflineEnum getOffline();
	
	void setOffline(OfflineEnum value);
	
	public Long getResultCode();
	
	void setResultCode(Long value);
	
	Long getExperimentalResultCode();
	
	void setExperimentalResultCode(Long experimentalResultCode);
	
	List<ChargingRuleReport> getChargingRuleReport();
	
	void setChargingRuleReport(List<ChargingRuleReport> value);	
	
	CreditManagementStatus getCreditManagementStatus();
	
	void setCreditManagementStatus(CreditManagementStatus value);
	
	List<QoSRuleReport> getQoSRuleReport();
	
	void setQoSRuleReport(List<QoSRuleReport> value);
	
	List<ApplicationDetectionInformation> getApplicationDetectionInformation();
	
	void setApplicationDetectionInformation(List<ApplicationDetectionInformation> value);
	
	IPCANTypeEnum getIPCANType();
	
	void setIPCANType(IPCANTypeEnum value);	
	
	RATTypeEnum getRATType();
	
	void setRATType(RATTypeEnum value);
	
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
	
	ByteBuf getTGPP2BSID();
	
	void setTGPP2BSID(ByteBuf value);	

	UserCSGInformation getUserCSGInformation();
	
	void setUserCSGInformation(UserCSGInformation value);
	
	public DefaultEPSBearerQoS getDefaultEPSBearerQoS();
	
	void setDefaultEPSBearerQoS(DefaultEPSBearerQoS value);
	
	IPCANTypeEnum getDefaultAccess();
	
	void setDefaultAccess(IPCANTypeEnum value);
	
	NBIFOMModeEnum getNBIFOMMode();
	
	void setNBIFOMMode(NBIFOMModeEnum value);	
	
	NBIFOMSupportEnum getNBIFOMSupport();
	
	void setNBIFOMSupport(NBIFOMSupportEnum value);	
	
	AccessAvailabilityChangeReasonEnum getAccessAvailabilityChangeReason();
	
	void setAccessAvailabilityChangeReason(AccessAvailabilityChangeReasonEnum value);
	
	NetworkRequestSupportEnum getNetworkRequestSupport();
	
	void setNetworkRequestSupport(NetworkRequestSupportEnum value);
	
	RoutingRuleInstall getRoutingRuleInstall();
	
	void setRoutingRuleInstall(RoutingRuleInstall value);	
	
	RoutingRuleRemove getRoutingRuleRemove();
	
	void setRoutingRuleRemove(RoutingRuleRemove value);	
	
	Date getUserLocationInfoTime();
	
	void setUserLocationInfoTime(Date value);	
	
	ByteBuf getLogicalAccessID();
	
	void setLogicalAccessID(ByteBuf value);	
	
	String getPhysicalAccessID();
	
	void setPhysicalAccessID(String value);	
	
	List<UsageMonitoringInformation> getUsageMonitoringInformation();
	
	void setUsageMonitoringInformation(List<UsageMonitoringInformation> value);	
	
	MultipleBBERFActionEnum getMultipleBBERFAction();
	
	void setMultipleBBERFAction(MultipleBBERFActionEnum value);	
	
	List<EventTriggerEnum> getEventTrigger();
	
	void setEventTrigger(List<EventTriggerEnum> value);
	
	InetAddress getAccessNetworkChargingAddress();
	
	void setAccessNetworkChargingAddress(InetAddress value);	
	
	List<AccessNetworkChargingIdentifierGx> getAccessNetworkChargingIdentifierGx();
	
	void setAccessNetworkChargingIdentifierGx(List<AccessNetworkChargingIdentifierGx> value);
	
	SessionLinkingIndicatorEnum getSessionLinkingIndicator();
	
	void setSessionLinkingIndicator(SessionLinkingIndicatorEnum value);
	
	InetAddress getHeNBLocalIPAddress();
	
	void setHeNBLocalIPAddress(InetAddress value);	
	
	InetAddress getUELocalIPAddress();
	
	void setUELocalIPAddress(InetAddress value);	
	
	ByteBuf getUELocalIPv6Prefix();
	
	void setUELocalIPv6Prefix(ByteBuf value);
	
	Long getUDPSourcePort();
	
	void setUDPSourcePort(Long value);	

	public ANGWStatusEnum getANGWStatus();
	
	void setANGWStatus(ANGWStatusEnum value);
}