package com.mobius.software.telco.protocols.diameter.primitives.s6a;
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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.pc4a.ProSeSubscriptionData;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.AESECommunicationPattern;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringEventConfiguration;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.2	Subscription-Data
	The Subscription-Data AVP is of type Grouped. It shall contain the information related to the user profile relevant for EPS and GERAN/UTRAN.
	AVP format:

	Subscription-Data ::= <AVP header: 1400 10415>
		   [ Subscriber-Status ]
		   [ MSISDN ]
		   [ A-MSISDN ]
		   [ STN-SR ]
		   [ ICS-Indicator ]
		   [ Network-Access-Mode ]
		   [ Operator-Determined-Barring ]
		   [ HPLMN-ODB ]
		*10[ Regional-Subscription-Zone-Code ]
		   [ Access-Restriction-Data ]
		   [ APN-OI-Replacement ]
		   [ LCS-Info ]
		   [ Teleservice-List ]
		*  [ Call-Barring-Info ]
		   [ 3GPP-Charging-Characteristics ]
		   [ AMBR ]
		   [ APN-Configuration-Profile ]
		   [ RAT-Frequency-Selection-Priority-ID ]
		   [ Trace-Data]
		   [ GPRS-Subscription-Data ]
		*  [ CSG-Subscription-Data ]
		   [ Roaming-Restricted-Due-To-Unsupported-Feature ]
		   [ Subscribed-Periodic-RAU-TAU-Timer ]
		   [ MPS-Priority ]
		   [ VPLMN-LIPA-Allowed ]
		   [ Relay-Node-Indicator ]
		   [ MDT-User-Consent ]
		   [ Subscribed-VSRVCC ]
		   [ ProSe-Subscription-Data ]
		   [ Subscription-Data-Flags ]
		*  [ Adjacent-Access-Restriction-Data ]
		   [ DL-Buffering-Suggested-Packet-Count ]
		*  [ IMSI-Group-Id ]
		   [ UE-Usage-Type ]
		*  [ AESE-Communication-Pattern ]
		*  [ Monitoring-Event-Configuration ]
		   [ Emergency-Info ]
		   [ V2X-Subscription-Data ]
		   [ V2X-Subscription-Data-Nr ]
		*  [ eDRX-Cycle-Length ]
		   [ External-Identifier ]
		   [ Active-Time ]
		   [ Service-Gap-Time ]
		   [ Broadcast-Location-Assistance-Data-Types ]
		   [ Aerial-UE-Subscription-Information ]
		   [ Core-Network-Restrictions ]
		*  [ Paging-Time-Window ]
		   [ Subscribed-ARPI ]
		   [ IAB-Operation-Permission ]
		*  [ AVP ]

	The AMBR included in this grouped AVP shall include the AMBR associated to the user's subscription (UE-AMBR); Max-Requested-Bandwidth-UL and Max-Requested-Bandwidth-DL within this AVP shall not both be set to "0".
	The APN-OI-Replacement included in this grouped AVP shall include the UE level APN-OI-Replacement associated to the user's subscription.
	When multiple External Identifiers are defined for the same subscription, the External-Identifier in this grouped AVP shall contain a default External Identifier determined by the HSS.
 */
@DiameterAvpDefinition(code = 1400L, vendorId = KnownVendorIDs.TGPP_ID, name = "Subscription-Data")
public interface SubscriptionData extends DiameterGroupedAvp
{
	SubscriberStatusEnum getSubscriberStatus();
	
	void setSubscriberStatus(SubscriberStatusEnum value);	
	
	String getMSISDN();
	
	void setMSISDN(String value);
	
	String getAMSISDN();
	
	void setAMSISDN(String value);
	
	String getSTNSR();
	
	void setSTNSR(String value);
	
	ICSIndicatorEnum getICSIndicator();
	
	void setICSIndicator(ICSIndicatorEnum value);
	
	NetworkAccessModeEnum getNetworkAccessMode();
	
	void setNetworkAccessMode(NetworkAccessModeEnum value);
	
	OperatorDeterminedBarring getOperatorDeterminedBarring();
	
	void setOperatorDeterminedBarring(OperatorDeterminedBarring value);
	
	HPLMNODB getHPLMNODB();
	
	void setHPLMNODB(HPLMNODB value);
	
	List<ByteBuf> getRegionalSubscriptionZoneCode();
	
	void setRegionalSubscriptionZoneCode(List<ByteBuf> value);
	
	AccessRestrictionData getAccessRestrictionData();
	
	void setAccessRestrictionData(AccessRestrictionData value);
	
	String getAPNOIReplacement();
	
	void setAPNOIReplacement(String value);
	
	LCSInfo getLCSInfo();
	
	void setLCSInfo(LCSInfo value);
	
	TeleserviceList getTeleserviceList();
	
	void setTeleserviceList(TeleserviceList value);
	
	List<CallBarringInfo> getCallBarringInfo();
	
	void setCallBarringInfo(List<CallBarringInfo> value);
	
	String getTGPPChargingCharacteristics();
	
	void setTGPPChargingCharacteristics(String value);
	
	AMBR getAMBR();
	
	void setAMBR(AMBR value);
	
	APNConfigurationProfile getAPNConfigurationProfile();
	
	void setAPNConfigurationProfile(APNConfigurationProfile value);
	
	Long getRATFrequencySelectionPriorityID();
	
	void setRATFrequencySelectionPriorityID(Long value);
	
	TraceData getTraceData();
	
	void setTraceData(TraceData value);
	
	GPRSSubscriptionData getGPRSSubscriptionData();
	
	void setGPRSSubscriptionData(GPRSSubscriptionData value);	
	
	List<CSGSubscriptionData> getCSGSubscriptionData();
	
	void setCSGSubscriptionData(List<CSGSubscriptionData> value);
	
	RoamingRestrictedDueToUnsupportedFeatureEnum getRoamingRestrictedDueToUnsupportedFeature();
	
	void setRoamingRestrictedDueToUnsupportedFeature(RoamingRestrictedDueToUnsupportedFeatureEnum value);
	
	Long getSubscribedPeriodicRAUTAUTimer();
	
	void setSubscribedPeriodicRAUTAUTimer(Long value);	
	
	MPSPriority getMPSPriority();
	
	void setMPSPriority(MPSPriority value);	
	
	VPLMNLIPAAllowedEnum getVPLMNLIPAAllowed();
	
	void setVPLMNLIPAAllowed(VPLMNLIPAAllowedEnum value);
	
	RelayNodeIndicatorEnum getRelayNodeIndicator();
	
	void setRelayNodeIndicator(RelayNodeIndicatorEnum value);
	
	MDTUserConsentEnum getMDTUserConsent();
	
	void setMDTUserConsent(MDTUserConsentEnum value);
	
	SubscribedVSRVCCEnum getSubscribedVSRVCC();
	
	void setSubscribedVSRVCC(SubscribedVSRVCCEnum value);
	
	ProSeSubscriptionData getProSeSubscriptionData();
	
	void setProSeSubscriptionData(ProSeSubscriptionData value);
	
	SubscriptionDataFlags getSubscriptionDataFlags();
	
	void setSubscriptionDataFlags(SubscriptionDataFlags value);
	
	List<AdjacentAccessRestrictionData> getAdjacentAccessRestrictionData();
	
	void setAdjacentAccessRestrictionData(List<AdjacentAccessRestrictionData> value);
	
	Integer getDLBufferingSuggestedPacketCount();
	
	void setDLBufferingSuggestedPacketCount(Integer value);
	
	List<IMSIGroupId> getIMSIGroupId();
	
	void setIMSIGroupId(List<IMSIGroupId> value);
	
	Long getUEUsageType();
	
	void setUEUsageType(Long value);
	
	List<AESECommunicationPattern> getAESECommunicationPattern();
	
	void setAESECommunicationPattern(List<AESECommunicationPattern> value);
	
	List<MonitoringEventConfiguration> getMonitoringEventConfiguration();
	
	void setMonitoringEventConfiguration(List<MonitoringEventConfiguration> value);
	
	EmergencyInfo getEmergencyInfo();
	
	void setEmergencyInfo(EmergencyInfo value);
	
	V2XSubscriptionData getV2XSubscriptionData();
	
	void setV2XSubscriptionData(V2XSubscriptionData value);
	
	V2XSubscriptionDataNr getV2XSubscriptionDataNr();
	
	void setV2XSubscriptionDataNr(V2XSubscriptionDataNr value);
	
	List<EDRXCycleLength> getEDRXCycleLength();
	
	void setEDRXCycleLength(List<EDRXCycleLength> value);
	
	String getExternalIdentifier();
	
	void setExternalIdentifier(String value);
	
	Long getActiveTime();
	
	void setActiveTime(Long value);
	
	Long getServiceGapTime();
	
	void setServiceGapTime(Long value);
	
	BroadcastLocationAssistanceDataTypes getBroadcastLocationAssistanceDataTypes();
	
	void setBroadcastLocationAssistanceDataTypes(BroadcastLocationAssistanceDataTypes value);
	
	AerialUESubscriptionInformationEnum getAerialUESubscriptionInformation();
	
	void setAerialUESubscriptionInformation(AerialUESubscriptionInformationEnum value);
	
	Long getCoreNetworkRestrictions();
	
	void setCoreNetworkRestrictions(Long value);
	
	List<PagingTimeWindow> getPagingTimeWindow();
	
	void setPagingTimeWindow(List<PagingTimeWindow> value);
	
	Long getSubscribedARPI();
	
	void setSubscribedARPI(Long value);
	
	IABOperationPermissionEnum getIABOperationPermission();
	
	void setIABOperationPermission(IABOperationPermissionEnum value);
}