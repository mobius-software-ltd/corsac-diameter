package com.mobius.software.telco.protocols.diameter.primitives.accounting;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPPDPTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.FixedUserLocationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NBIFOMModeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NBIFOMSupportEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PresenceReportingAreaInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TerminalInformation;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.RRCCauseCounter;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.ServingPLMNRateControl;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.158	PS-Information AVP
	The PS-Information AVP (AVP code 874) is of type Grouped. Its purpose is to allow the transmission of additional PS service specific information elements. 
	It has the following ABNF grammar:

	PS-Information :: = 	< AVP Header: 874>
 		* 	[ Supported-Features ]
 			[ 3GPP-Charging-Id ]
			[ PDN-Connection-Charging-ID ]
   			[ Node-Id ]
   			[ 3GPP-PDP-Type ]
 		* 	[ PDP-Address ]
		   	[ PDP-Address-Prefix-Length ]
		   	[ Dynamic-Address-Flag ]
		   	[ Dynamic-Address-Flag-Extension ]
		   	[ QoS-Information ]
		* 	[ SGSN-Address ]
		* 	[ GGSN-Address ] 
		* 	[ TDF-IP-Address ]
		* 	[ SGW-Address ] 
		* 	[ ePDG-Address ] 
		* 	[ TWAG-Address ]
   			[ CG-Address ]
   			[ Serving-Node-Type ]
		    [ SGW-Change ]
		    [ 3GPP-IMSI-MCC-MNC ]
		    [ IMSI-Unauthenticated-Flag ]
		    [ 3GPP-GGSN-MCC-MNC ]
		    [ 3GPP-NSAPI ]
		    [ Called-Station-Id ]
		   	[ 3GPP-Session-Stop-Indicator ]
		   	[ 3GPP-Selection-Mode ]
		   	[ 3GPP-Charging-Characteristics ]
		   	[ Charging-Characteristics-Selection-Mode ]
		   	[ 3GPP-SGSN-MCC-MNC ]
		   	[ 3GPP-MS-TimeZone ]
		   	[ Charging-Rule-Base-Name ] 
		   	[ ADC-Rule-Base-Name ] 
		   	[ 3GPP-User-Location-Info ]
		   	[ User-Location-Info-Time ]
		   	[ User-CSG-Information ]
 		* 	[ Presence-Reporting-Area-Information ]
   			[ 3GPP2-BSID ] 
			[ TWAN-User-Location-Info ]
			[ UWAN-User-Location-Info ]
   			[ 3GPP-RAT-Type ]
   			[ PS-Furnish-Charging-Information ]
		    [ PDP-Context-Type ] 
		    [ Offline-Charging ]
		* 	[ Traffic-Data-Volumes ]
		* 	[ Service-Data-Container ]
		    [ User-Equipment-Info ]
		    [ Terminal-Information ]
		    [ Start-Time ]
		    [ Stop-Time ]
		    [ Change-Condition ]
		    [ Diagnostics ]
			[ Low-Priority-Indicator ] 
			[ NBIFOM-Mode ]
			[ NBIFOM-Support ]
			[ MME-Number-for-MT-SMS ]
			[ MME-Name ]
			[ MME-Realm ] 
			[ Logical-Access-ID ]
			[ Physical-Access-ID ]
			[ Fixed-User-Location-Info ]
			[ CN-Operator-Selection-Entity ]
			[ Enhanced-Diagnostics ]
			[ SGi-PtP-Tunnelling-Method ]
			[ CP-CIoT-EPS-Optimisation-Indicator ]
			[ UNI-PDU-CP-Only-Flag ]
			[ Serving-PLMN-Rate-Control ]
			[ APN-Rate-Control ]
			[ Charging-Per-IP-CAN-Session-Indicator ]
			[ RRC-Cause-Counter ]
   			[ 3GPP-PS-Data-Off-Status ]
			[ SCS-AS-Address ]
   			[ Unused-Quota-Timer ]
 		* 	[ RAN-Secondary-RAT-Usage-Report ]
   			[ PSCell-Info ]
*/
@DiameterAvpDefinition(code = TgppAvpCodes.PS_INFORMATION, vendorId = VendorIDs.TGPP_ID, name = "PS-Information")
public interface PSInformation extends DiameterAvp
{
	List<SupportedFeatures> getSupportedFeatures();
	
	void setSupportedFeatures(List<SupportedFeatures> value);
	
	ByteBuf get3GPPChargingId();
	
	void set3GPPChargingId(ByteBuf value);
	
	Long getPDNConnectionChargingID();
	
	void setPDNConnectionChargingID(Long value);
	
	String getNodeId();
	
	void setNodeId(String value);
	
	TGPPPDPTypeEnum get3GPPPDPType();
	
	void get3GPPPDPType(TGPPPDPTypeEnum value);
	
	List<InetAddress> getPDPAddress();
	
	void setPDPAddress(List<InetAddress> value);
	
	Long getPDPAddressPrefixLength();
	
	void setPDPAddressPrefixLength(Long value);
	
	DynamicAddressFlagEnum getDynamicAddressFlag();
	
	void setDynamicAddressFlag(DynamicAddressFlagEnum value);
	
	DynamicAddressFlagExtensionEnum getDynamicAddressFlagExtension();
	
	void setDynamicAddressFlagExtension(DynamicAddressFlagExtensionEnum value);
	
	QoSInformation getQoSInformation();
	
	void setQoSInformation(QoSInformation value);
	
	List<InetAddress> getSGSNAddress();
	
	void setSGSNAddress(List<InetAddress> value);
	
	List<InetAddress> getGGSNAddress();
	
	void setGGSNAddress(List<InetAddress> value);
	
	List<InetAddress> getTDFIPAddress();
	
	void setTDFIPAddress(List<InetAddress> value);
	
	List<InetAddress> getSGWAddress();
	
	void setSGWAddress(List<InetAddress> value);
	
	List<InetAddress> getEPDGAddress();
	
	void setEPDGAddress(List<InetAddress> value);
	
	List<InetAddress> getTWAGAddress();
	
	void setTWAGAddress(List<InetAddress> value);
	
	InetAddress getCGAddress();
	
	void setCGAddress(InetAddress value);
	
	ServingNodeTypeEnum getServingNodeType();
	
	void setServingNodeType(ServingNodeTypeEnum value);
	
	SGWChangeEnum getSGWChange();
	
	void setSGWChange(SGWChangeEnum value);
	
	String get3GPPIMSIMCCMNC();
	
	void set3GPPIMSIMCCMNC(String value);	
	
	IMSIUnauthenticatedFlagEnum getIMSIUnauthenticatedFlag();
	
	void setIMSIUnauthenticatedFlag(IMSIUnauthenticatedFlagEnum value);	
	
	String get3GPPGGSNMCCMNC();
	
	void set3GPPGGSNMCCMNC(String value);	
	
	ByteBuf get3GPPNSAPI();
	
	void set3GPPNSAPI(ByteBuf value);	
	
	String getCalledStationId();
	
	void setCalledStationId(String value);	
	
	ByteBuf get3GPPSessionStopIndicator();
	
	void set3GPPSessionStopIndicator(ByteBuf value);	
	
	String get3GPPSelectionMode();
	
	void set3GPPSelectionMode(String value);	
	
	String getTGPPChargingCharacteristics();
	
	void setTGPPChargingCharacteristics(String value);	
	
	ChargingCharacteristicsSelectionModeEnum getChargingCharacteristicsSelectionMode();
	
	void setChargingCharacteristicsSelectionMode(ChargingCharacteristicsSelectionModeEnum value);	
	
	String get3GPPSGSNMCCMNC();
	
	void set3GPPSGSNMCCMNC(String value);	
	
	ByteBuf get3GPPMSTimeZone();
	
	void set3GPPMSTimeZone(ByteBuf value);	
	
	String getChargingRuleBaseName();
	
	void setChargingRuleBaseName(String value);	
	
	String getADCRuleBaseName();
	
	void setADCRuleBaseName(String value);	
	
	ByteBuf get3GPPUserLocationInfo();
	
	void set3GPPUserLocationInfo(ByteBuf value);	
	
	Date getUserLocationInfoTime();
	
	void setUserLocationInfoTime(Date value);	

	UserCSGInformation getUserCSGInformation();
	
	void setUserCSGInformation(UserCSGInformation value);	
	
	List<PresenceReportingAreaInformation> getPresenceReportingAreaInformation();
	
	void setPresenceReportingAreaInformation(List<PresenceReportingAreaInformation> value);	
	
	ByteBuf get3GPP2BSID();
	
	void set3GPP2BSID(ByteBuf value);	
	
	TWANUserLocationInfo getTWANUserLocationInfo();
	
	void setTWANUserLocationInfo(TWANUserLocationInfo value);	
	
	UWANUserLocationInfo getUWANUserLocationInfo();
	
	void setUWANUserLocationInfo(UWANUserLocationInfo value);	
	
	ByteBuf get3GPPRATType();
	
	void set3GPPRATType(ByteBuf value);	
	
	PSFurnishChargingInformation getPSFurnishChargingInformation();
	
	void setPSFurnishChargingInformation(PSFurnishChargingInformation value);	
	
	PDPContextTypeEnum getPDPContextType();
	
	void setPDPContextType(PDPContextTypeEnum value);	
	
	OfflineCharging getOfflineCharging();
	
	void setOfflineCharging(OfflineCharging value);	
	
	List<TrafficDataVolumes> getTrafficDataVolumes();
	
	void setTrafficDataVolumes(List<TrafficDataVolumes> value);	
	
	List<ServiceDataContainer> getServiceDataContainer();
	
	void setServiceDataContainer(List<ServiceDataContainer> value);	
	
	UserEquipmentInfo getUserEquipmentInfo();
	
	void setUserEquipmentInfo(UserEquipmentInfo value);	
	
	TerminalInformation getTerminalInformation();
	
	void setTerminalInformation(TerminalInformation value);	
	
	Date getStartTime();
	
	void setStartTime(Date value);	
	
	Date getStopTime();
	
	void setStopTime(Date value);	
	
	Long getChangeCondition();
	
	void setChangeCondition(Long value);
	
	Integer getDiagnostics();
	
	void setDiagnostics(Integer value);
	
	LowPriorityIndicatorEnum getLowPriorityIndicator();
	
	void setLowPriorityIndicator(LowPriorityIndicatorEnum value);
	
	NBIFOMModeEnum getNBIFOMMode();
	
	void setNBIFOMMode(NBIFOMModeEnum value);
	
	NBIFOMSupportEnum getNBIFOMSupport();
	
	void setNBIFOMSupport(NBIFOMSupportEnum value);
	
	String getMMENumberForMTSMS();
	
	void setMMENumberForMTSMS(String value);
	
	String getMMEName();
	
	void setMMEName(String value);
	
	String getMMERealm();
	
	void setMMERealm(String value);
	
	ByteBuf getLogicalAccessID();
	
	void setLogicalAccessID(ByteBuf value);
	
	String getPhysicalAccessID();
	
	void setPhysicalAccessID(String value);
	
	FixedUserLocationInfo getFixedUserLocationInfo();
	
	void setFixedUserLocationInfo(FixedUserLocationInfo value);
	
	CNOperatorSelectionEntityEnum getCNOperatorSelectionEntity();
	
	void setCNOperatorSelectionEntity(CNOperatorSelectionEntityEnum value);
	
	EnhancedDiagnostics getEnhancedDiagnostics();
	
	void setEnhancedDiagnostics(EnhancedDiagnostics value);
	
	SGiPtPTunnellingMethodEnum getSGiPtPTunnellingMethod();
	
	void setSGiPtPTunnellingMethod(SGiPtPTunnellingMethodEnum value);
	
	CPCIoTEPSOptimisationIndicatorEnum getCPCIoTEPSOptimisationIndicator();
	
	void setCPCIoTEPSOptimisationIndicator(CPCIoTEPSOptimisationIndicatorEnum value);
	
	UNIPDUCPOnlyFlagEnum getUNIPDUCPOnlyFlag();
	
	void setUNIPDUCPOnlyFlag(UNIPDUCPOnlyFlagEnum value);
	
	ServingPLMNRateControl getServingPLMNRateControl();
	
	void setServingPLMNRateControl(ServingPLMNRateControl value);
	
	APNRateControl getAPNRateControl();
	
	void setAPNRateControl(APNRateControl value);
	
	ChargingPerIPCANSessionIndicatorEnum getChargingPerIPCANSessionIndicator();
	
	void setChargingPerIPCANSessionIndicator(ChargingPerIPCANSessionIndicatorEnum value);
	
	RRCCauseCounter getRRCCauseCounter();
	
	void setRRCCauseCounter(RRCCauseCounter value);
	
	TGPPPSDataOffStatusEnum get3GPPPSDataOffStatus();
	
	void set3GPPPSDataOffStatus(TGPPPSDataOffStatusEnum value);
	
	SCSASAddress getSCSASAddress();
	
	void setSCSASAddress(SCSASAddress value);
	
	Long getUnusedQuotaTimer();
	
	void setUnusedQuotaTimer(Long value);
	
	List<RANSecondaryRATUsageReport> getRANSecondaryRATUsageReport();
	
	void setRANSecondaryRATUsageReport(List<RANSecondaryRATUsageReport> value);
	
	PSCellInfo getPSCellInfo();
	
	void setPSCellInfo(PSCellInfo value);
}