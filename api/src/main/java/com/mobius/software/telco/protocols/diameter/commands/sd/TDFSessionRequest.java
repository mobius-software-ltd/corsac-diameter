package com.mobius.software.telco.protocols.diameter.commands.sd;
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

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.commons.VendorSpecificRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.DynamicAddressFlagEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.DynamicAddressFlagExtensionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UserCSGInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfoExtension;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ChargingInformation;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gx.CSGInformationReportingEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventTriggerEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.FixedUserLocationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.gx.IPCANTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.OfflineEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.OnlineEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PresenceReportingAreaInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UsageMonitoringInformation;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMPEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sd.ADCRuleInstall;
import com.mobius.software.telco.protocols.diameter.primitives.sta.ANTrustedEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5b.6.2	TDF-Session-Request (TSR) Command
	The TSR command, indicated by the Command-Code field set to 8388637 and the 'R' bit set in the Command Flags field, is sent by the PCRF to the TDF in order to establish the TDF session and to provision the ADC rules. It may also include the requested event triggers.
	Message Format:

	<TS-Request> ::= < Diameter Header: 8388637, REQ, PXY >
				 < Session-Id >
				 [ DRMP ]
				 { Vendor-Specific-Application-Id }
				 { Origin-Host }
				 { Origin-Realm }
				 { Destination-Realm }
				 [ Destination-Host ]
				 [ Origin-State-Id ]
				 [ OC-Supported-Features ]
				*[ Subscription-Id ]
				*[ Supported-Features ]
				 [ Framed-IP-Address ]
				 [ Framed-Ipv6-Prefix ]
		 		 [ IP-CAN-Type ]
				 [ RAT-Type ]
				 [ AN-Trusted]
				 [ User-Equipment-Info ]
				 [ User-Equipment-Info-Extension ]
				 [ QoS-Information ]
			  0*2 [ AN-GW-Address ]
				 [ 3GPP-SGSN-Address ]
				 [ 3GPP-SGSN-Ipv6-Address ]
			 	 [ 3GPP-GGSN-Address ]
				 [ 3GPP-GGSN-Ipv6-Address ]
 				 [ 3GPP-Selection-Mode ]
				 [ Dynamic-Address-Flag ]
				 [ Dynamic-Address-Flag-Extension ]
				 [ PDN-Connection-Charging-ID ]
				 [ 3GPP-SGSN-MCC-MNC ]
				 [ RAI ]
				 [ 3GPP-User-Location-Info ]
				 [ Fixed-User-Location-Info ]
				 [ User-CSG-Information ]
				 [ TWAN-Identifier ]
				 [ 3GPP-MS-TimeZone ]
				 [ 3GPP-Charging-Characteristics ]
				 [ Called-Station-Id ]
				 [ Charging-Information ]
				 [ Online ]
				 [ Offline ]
				*[ ADC-Rule-Install ]
				 [ Revalidation-Time ]
				*[ Usage-Monitoring-Information ]
				*[ CSG-Information-Reporting ]
				*[ Event-Trigger]
				 [ Presence-Reporting-Area-Information ]
				 [ Logical-Access-ID ]
				 [ Physical-Access-ID ]
				 [ 3GPP2-BSID ]
				*[ Proxy-Info ]
				*[ Route-Record ]
				*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.SD, commandCode = CommandCodes.TDF_SESSION, request = true, proxyable = true, name="TS-Request")
public interface TDFSessionRequest extends VendorSpecificRequest
{
	DRMPEnum getDRMP();
	
	void setDRMP(DRMPEnum value);
	
	OCSupportedFeatures getOCSupportedFeatures();
	
	void setOCSupportedFeatures(OCSupportedFeatures value);
	
	public List<SubscriptionId> getSubscriptionId();
	
	void setSubscriptionId(List<SubscriptionId> value);

	public List<SupportedFeatures> getSupportedFeatures();
	 
	void setSupportedFeatures(List<SupportedFeatures> value);
	
	InetAddress getFramedIPAddress();
	
	void setFramedIPAddress(Inet4Address value);	
	
	ByteBuf getFramedIPv6Prefix();
	
	void setFramedIPv6Prefix(ByteBuf value);
	
	IPCANTypeEnum getIPCANType();
	
	void setIPCANType(IPCANTypeEnum value);
	
	RATTypeEnum getRATType();
	
	void setRATType(RATTypeEnum value);

	ANTrustedEnum getANTrusted();
	
	void setANTrusted(ANTrustedEnum value);	
	
	public UserEquipmentInfo getUserEquipmentInfo();
	
	void setUserEquipmentInfo(UserEquipmentInfo value);
	
	public UserEquipmentInfoExtension getUserEquipmentInfoExtension();
	
	void setUserEquipmentInfoExtension(UserEquipmentInfoExtension value);
	
	public QoSInformation getQoSInformation();
	
	void setQoSInformation(QoSInformation value);
	
	List<InetAddress> getANGWAddress();
	
	void setANGWAddress(List<InetAddress> value) throws AvpOccursTooManyTimesException;
	
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
	
	DynamicAddressFlagEnum getDynamicAddressFlag();
	
	void setDynamicAddressFlag(DynamicAddressFlagEnum value);
	
	DynamicAddressFlagExtensionEnum getDynamicAddressFlagExtension();
	
	void setDynamicAddressFlagExtension(DynamicAddressFlagExtensionEnum value);

	Long getPDNConnectionChargingID();
	
	void setPDNConnectionChargingID(Long value);	
	
	String getTGPPSGSNMCCMNC();
	
	void setTGPPSGSNMCCMNC(String value);	
	
	String getRAI();
	
	void setRAI(String value);	
	
	ByteBuf getTGPPUserLocationInfo();
	
	void setTGPPUserLocationInfo(ByteBuf value);	
	
	FixedUserLocationInfo getFixedUserLocationInfo();
	
	void setFixedUserLocationInfo(FixedUserLocationInfo value);	
	
	UserCSGInformation getUserCSGInformation();
	
	void setUserCSGInformation(UserCSGInformation value);	
	
	ByteBuf getTWANIdentifier();
	
	void setTWANIdentifier(ByteBuf value);	
	
	ByteBuf getTGPPMSTimeZone();
	
	void setTGPPMSTimeZone(ByteBuf value);	

	String getTGPPChargingCharacteristics();
	
	void setTGPPChargingCharacteristics(String value);
	
	String getCalledStationId();
	
	void setCalledStationId(String value);	
	
	ChargingInformation getChargingInformation();
	
	void setChargingInformation(ChargingInformation value);	
	
	OnlineEnum getOnline();
	
	void setOnline(OnlineEnum value);	
	
	OfflineEnum getOffline();
	
	void setOffline(OfflineEnum value);	
	
	List<ADCRuleInstall> getADCRuleInstall();
	
	void setADCRuleInstall(List<ADCRuleInstall> value);	
	
	public Date getRevalidationTime();
	
	void setRevalidationTime(Date value);
	
	List<UsageMonitoringInformation> getUsageMonitoringInformation();
	
	void setUsageMonitoringInformation(List<UsageMonitoringInformation> value);	
	
	List<CSGInformationReportingEnum> getCSGInformationReporting();
	
	void setCSGInformationReporting(List<CSGInformationReportingEnum> value);	
	
	List<EventTriggerEnum> getEventTrigger();
	
	void setEventTrigger(List<EventTriggerEnum> value);	
	
	PresenceReportingAreaInformation getPresenceReportingAreaInformation();
	
	void setPresenceReportingAreaInformation(PresenceReportingAreaInformation value);
	
	ByteBuf getLogicalAccessID();
	
	void setLogicalAccessID(ByteBuf value);	
	
	String getPhysicalAccessID();
	
	void setPhysicalAccessID(String value);
	
	ByteBuf getTGPP2BSID();
	
	void setTGPP2BSID(ByteBuf value);
}