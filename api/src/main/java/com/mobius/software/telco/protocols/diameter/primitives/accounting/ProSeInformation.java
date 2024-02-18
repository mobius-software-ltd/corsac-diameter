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
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.WLANLinkLayerId;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.154I	ProSe-Information AVP
	The ProSe-Information AVP (AVP code 3447) is of type Grouped. Its purpose is to allow the transmission of additional ProSe service specific information elements. 
	It has the following ABNF grammar:
	
	ProSe-Information :: = 	< AVP Header: 3447>
		* 	[ Supported-Features ]
 			[ Announcing-UE-HPLMN-Identifier ]
			[ Announcing-UE-VPLMN-Identifier ]
			[ Monitoring-UE-HPLMN-Identifier ]
			[ Monitoring-UE-VPLMN-Identifier ]
			[ Monitored-HPLMN-Identifier ]
			[ Role-Of-ProSe-Function ]
			[ ProSe-App-Id ]
			[ ProSe-3rd-Party-Application-ID ]
			[ Application-Specific-Data ]
			[ ProSe-Event-Type ]
			[ ProSe-Direct-Discovery-Model ]
			[ ProSe-Function-IP-Address ]
			[ ProSe-Function-ID ]
			[ ProSe-Validity-Timer ]
			[ ProSe-Role-Of-UE ]
			[ ProSe-Request-Timestamp ] 
			[ PC3-Control-Protocol-Cause ]
			[ Monitoring-UE-Identifier ]
			[ Prose-Function-PLMN-Identifier ]
			[ Requestor-PLMN-Identifier ]
			[ Origin-App-Layer-User-Id ]
			[ WLAN-Link-Layer-Id ]
			[ Requesting-EPUID ]
			[ Target-App-Layer-User-Id ]
			[ Requested-PLMN-Identifier ]
			[ Time-Window ]
			[ ProSe-Range-Class ]
			[ Proximity-Alert-Indication ]
			[ Proximity-Alert-Timestamp ]
			[ Proximity-Cancellation-Timestamp ]
			[ ProSe-Reason-For-Cancellation ]
			[ PC3-EPC-Control-Protocol-Cause ]
			[ ProSe-UE-ID ]
			[ ProSe-Source-IP-Address ]
			[ Layer-2-Group-ID ]
			[ ProSe-Group-IP-Multicast-Address ]
 		* 	[ Coverage-Info ]
 		* 	[ Radio-Parameter-Set-Info ]
 		* 	[ Transmitter-Info ]
			[ Time-First-Transmission ]
			[ Time-First-Reception ]
 		* 	[ ProSe-Direct-Communication-Transmission-Data-Container ]
 		* 	[ ProSe-Direct-Communication-Reception-Data-Container ] 
 			[ Announcing-PLMN-ID]
			[ ProSe-Target-Layer-2-ID ]
			[ Relay-IP-address ]
			[ ProSe-UE-to-Network-Relay-UE-ID ]
			[ Target-IP-Address ]
			[ PC5-Radio-Technology ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.PROSE_INFORMATION, vendorId = VendorIDs.TGPP_ID, name = "ProSe-Direct-Communication- Transmission-Data-Container")
public interface ProSeInformation extends DiameterAvp
{
	List<SupportedFeatures> getSupportedFeatures();
	
	void setSupportedFeatures(List<SupportedFeatures> value);
	
	String getAnnouncingUEHPLMNIdentifier();
	
	void setAnnouncingUEHPLMNIdentifier(String value);
	
	String getAnnouncingUEVPLMNIdentifier();
	
	void setAnnouncingUEVPLMNIdentifier(String value);
	
	String getMonitoringUEHPLMNIdentifier();
	
	void setMonitoringUEHPLMNIdentifier(String value);
	
	String getMonitoringUEVPLMNIdentifier();
	
	void setMonitoringUEVPLMNIdentifier(String value);
	
	String getMonitoredPLMNIdentifier();
	
	void setMonitoredPLMNIdentifier(String value);
	
	RoleOfProSeFunctionEnum getRoleOfProSeFunction();
	
	void setRoleOfProSeFunction(RoleOfProSeFunctionEnum value);
	
	String getProSeAppId();
	
	void setProSeAppId(String value);
	
	String getProSe3rdPartyApplicationID();
	
	void setProSe3rdPartyApplicationID(String value);
	
	ByteBuf getApplicationSpecificData();
	
	void setApplicationSpecificData(ByteBuf value);
	
	ProSeEventTypeEnum getProSeEventType();
	
	void setProSeEventType(ProSeEventTypeEnum value);
	
	ProSeDirectDiscoveryModelEnum getProSeDirectDiscoveryModel();
	
	void setProSeDirectDiscoveryModel(ProSeDirectDiscoveryModelEnum value);
	
	InetAddress getProSeFunctionIPAddress();
	
	void setProSeFunctionIPAddress(InetAddress value);
	
	ByteBuf getProSeFunctionID();
	
	void setProSeFunctionID(ByteBuf value);
	
	Long getProSeValidityTimer();
	
	void setProSeValidityTimer(Long value);
	
	ProSeRoleOfUEEnum getProSeRoleOfUE();
	
	void setProSeRoleOfUE(ProSeRoleOfUEEnum value);
	
	Date getProSeRequestTimestamp();
	
	void setProSeRequestTimestamp(Date value);
	
	Integer getPC3ControlProtocolCause();
	
	void setPC3ControlProtocolCause(Integer value);
	
	String getMonitoringUEIdentifier();
	
	void setMonitoringUEIdentifier(String value);
	
	String getProSeFunctionPLMNIdentifier();
	
	void setProSeFunctionPLMNIdentifier(String value);
	
	String getRequestorPLMNIdentifier();
	
	void setRequestorPLMNIdentifier(String value);
	
	String getOriginAppLayerUserId();
	
	void setOriginAppLayerUserId(String value);
	
	WLANLinkLayerId getWLANLinkLayerId();
	
	void setWLANLinkLayerId(WLANLinkLayerId value);
	
	String getRequestingEPUID();
	
	void setRequestingEPUID(String value);
	
	String getTargetAppLayerUserId();
	
	void setTargetAppLayerUserId(String value);
	
	String getRequestedPLMNIdentifier();
	
	void setRequestedPLMNIdentifier(String value);
	
	Long getTimeWindow();
	
	void setTimeWindow(Long value);
	
	ProSeRangeClassEnum getProSeRangeClass();
	
	void setProSeRangeClass(ProSeRangeClassEnum value);
	
	ProximityAlertIndicationEnum getProximityAlertIndication();
	
	void setProximityAlertIndication(ProximityAlertIndicationEnum value);
	
	Date getProximityAlertTimestamp();
	
	void setProximityAlertTimestamp(Date value);	
	
	Date getProximityCancellationTimestamp();
	
	void setProximityCancellationTimestamp(Date value);	
	
	ProSeReasonForCancellationEnum getProSeReasonForCancellation();
	
	void setProSeReasonForCancellation(ProSeReasonForCancellationEnum value);	
	
	Integer getPC3EPCControlProtocolCause();
	
	void setPC3EPCControlProtocolCause(Integer value);	
	
	ByteBuf getProSeUEID();
	
	void setProSeUEID(ByteBuf value);	
	
	InetAddress getProSeSourceIPAddress();
	
	void setProSeSourceIPAddress(InetAddress value);	
	
	ByteBuf getLayer2GroupID();
	
	void setLayer2GroupID(ByteBuf value);	
	
	InetAddress getProSeGroupIPMulticastAddress();
	
	void setProSeGroupIPMulticastAddress(InetAddress value);	
	
	List<CoverageInfo> getCoverageInfo();
	
	void setCoverageInfo(List<CoverageInfo> value);	
	
	List<RadioParameterSetInfo> getRadioParameterSetInfo();
	
	void setRadioParameterSetInfo(List<RadioParameterSetInfo> value);	
	
	List<TransmitterInfo> getTransmitterInfo();
	
	void setTransmitterInfo(List<TransmitterInfo> value);	
	
	Date getTimeFirstTransmission();
	
	void setTimeFirstTransmission(Date value);	
	
	Date getTimeFirstReception();
	
	void setTimeFirstReception(Date value);	
	
	List<ProSeDirectCommunicationTransmissionDataContainer> getProSeDirectCommunicationTransmissionDataContainer();
	
	void setProSeDirectCommunicationTransmissionDataContainer(List<ProSeDirectCommunicationTransmissionDataContainer> value);	
	
	List<ProSeDirectCommunicationReceptionDataContainer> getProSeDirectCommunicationReceptionDataContainer();
	
	void setProSeDirectCommunicationReceptionDataContainer(List<ProSeDirectCommunicationReceptionDataContainer> value);	
	
	String getAnnouncingPLMNID();
	
	void setAnnouncingPLMNID(String value);	

	ByteBuf getProSeTargetLayer2ID();
	
	void setProSeTargetLayer2ID(ByteBuf value);	
	
	InetAddress getRelayIPAddress();
	
	void setRelayIPAddress(InetAddress value);	
	
	ByteBuf getProSeUEtoNetworkRelayUEID();
	
	void setProSeUEtoNetworkRelayUEID(ByteBuf value);	
	
	InetAddress getTargetIPAddress();
	
	void setTargetIPAddress(InetAddress value);	
	
	PC5RadioTechnologyEnum getPC5RadioTechnology();
	
	void setPC5RadioTechnology(PC5RadioTechnologyEnum value);	
}