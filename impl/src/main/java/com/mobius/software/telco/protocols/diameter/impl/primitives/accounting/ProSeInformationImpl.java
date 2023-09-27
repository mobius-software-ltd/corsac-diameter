package com.mobius.software.telco.protocols.diameter.impl.primitives.accounting;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc2.OriginAppLayerUserIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc2.ProSeFunctionIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc2.TargetAppLayerUserIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.ProSeAppIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.ProSeValidityTimerImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.RequestingEPUIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.TimeWindowImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AnnouncingPLMNID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AnnouncingUEHPLMNIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AnnouncingUEVPLMNIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ApplicationSpecificData;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CoverageInfo;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.Layer2GroupID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MonitoredPLMNIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MonitoringUEHPLMNIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MonitoringUEIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MonitoringUEVPLMNIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PC3ControlProtocolCause;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PC3EPCControlProtocolCause;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PC5RadioTechnology;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PC5RadioTechnologyEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ProSe3rdPartyApplicationID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ProSeDirectCommunicationReceptionDataContainer;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ProSeDirectCommunicationTransmissionDataContainer;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ProSeDirectDiscoveryModel;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ProSeDirectDiscoveryModelEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ProSeEventType;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ProSeEventTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ProSeFunctionIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ProSeFunctionPLMNIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ProSeGroupIPMulticastAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ProSeInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ProSeRangeClass;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ProSeRangeClassEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ProSeReasonForCancellation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ProSeReasonForCancellationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ProSeRequestTimestamp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ProSeRoleOfUE;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ProSeRoleOfUEEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ProSeSourceIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ProSeTargetLayer2ID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ProSeUEID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ProSeUEToNetworkRelayUEID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ProximityAlertIndication;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ProximityAlertIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ProximityAlertTimestamp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ProximityCancellationTimestamp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RadioParameterSetInfo;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RelayIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RequestedPLMNIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RequestorPLMNIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RoleOfProSeFunction;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RoleOfProSeFunctionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TargetIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TimeFirstReception;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TimeFirstTransmission;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TransmitterInfo;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.pc2.OriginAppLayerUserId;
import com.mobius.software.telco.protocols.diameter.primitives.pc2.ProSeFunctionID;
import com.mobius.software.telco.protocols.diameter.primitives.pc2.TargetAppLayerUserId;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ProSeAppId;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ProSeValidityTimer;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.RequestingEPUID;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.TimeWindow;
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
@DiameterAvpImplementation(code = 3441L, vendorId = KnownVendorIDs.TGPP_ID)
public class ProSeInformationImpl implements ProSeInformation
{
	private List<SupportedFeatures> supportedFeatures;
 	private AnnouncingUEHPLMNIdentifier announcingUEHPLMNIdentifier;
	private AnnouncingUEVPLMNIdentifier announcingUEVPLMNIdentifier;
	private MonitoringUEHPLMNIdentifier monitoringUEHPLMNIdentifier;
	private MonitoringUEVPLMNIdentifier monitoringUEVPLMNIdentifier;
	private MonitoredPLMNIdentifier monitoredPLMNIdentifier;
	private RoleOfProSeFunction roleOfProSeFunction;
	private ProSeAppId proSeAppId;
	private ProSe3rdPartyApplicationID proSe3rdPartyApplicationID;
	private ApplicationSpecificData applicationSpecificData;
	private ProSeEventType proSeEventType;
	private ProSeDirectDiscoveryModel proSeDirectDiscoveryModel;
	private ProSeFunctionIPAddress proSeFunctionIPAddress;
	private ProSeFunctionID proSeFunctionID;
	private ProSeValidityTimer proSeValidityTimer;
	private ProSeRoleOfUE proSeRoleOfUE;
	private ProSeRequestTimestamp proSeRequestTimestamp; 
	private PC3ControlProtocolCause pc3ControlProtocolCause;
	private MonitoringUEIdentifier monitoringUEIdentifier;
	private ProSeFunctionPLMNIdentifier proSeFunctionPLMNIdentifier;
	private RequestorPLMNIdentifier requestorPLMNIdentifier;
	private OriginAppLayerUserId originAppLayerUserId;
	private WLANLinkLayerId wlanLinkLayerId;
	private RequestingEPUID requestingEPUID;
	private TargetAppLayerUserId targetAppLayerUserId;
	private RequestedPLMNIdentifier requestedPLMNIdentifier;
	private TimeWindow timeWindow;
	private ProSeRangeClass proSeRangeClass;
	private ProximityAlertIndication proximityAlertIndication;
	private ProximityAlertTimestamp proximityAlertTimestamp;
	private ProximityCancellationTimestamp proximityCancellationTimestamp;
	private ProSeReasonForCancellation proSeReasonForCancellation;
	private PC3EPCControlProtocolCause pc3EPCControlProtocolCause;
	private ProSeUEID proSeUEID;
	private ProSeSourceIPAddress proSeSourceIPAddress;
	private Layer2GroupID layer2GroupID;
	private ProSeGroupIPMulticastAddress proSeGroupIPMulticastAddress;
 	private List<CoverageInfo> coverageInfo;
 	private List<RadioParameterSetInfo> radioParameterSetInfo;
 	private List<TransmitterInfo> transmitterInfo;
	private TimeFirstTransmission timeFirstTransmission;
	private TimeFirstReception timeFirstReception;
	private List<ProSeDirectCommunicationTransmissionDataContainer> proSeDirectCommunicationTransmissionDataContainer;
	private List<ProSeDirectCommunicationReceptionDataContainer> proSeDirectCommunicationReceptionDataContainer; 
 	private AnnouncingPLMNID announcingPLMNID;
	private ProSeTargetLayer2ID proSeTargetLayer2ID;
	private RelayIPAddress relayIPAddress;
	private ProSeUEToNetworkRelayUEID proSeUEToNetworkRelayUEID;
	private TargetIPAddress targetIPAddress;
	private PC5RadioTechnology pc5RadioTechnology;
			
	public ProSeInformationImpl()
	{
		
	}
	
	public List<SupportedFeatures> getSupportedFeatures()
	{
		return this.supportedFeatures;
	}
	
	public void setSupportedFeatures(List<SupportedFeatures> value)
	{
		this.supportedFeatures = value;
	}
	
	public String getAnnouncingUEHPLMNIdentifier()
	{
		if(announcingUEHPLMNIdentifier==null)
			return null;
		
		return announcingUEHPLMNIdentifier.getString();
	}
	
	public void setAnnouncingUEHPLMNIdentifier(String value)
	{
		if(value==null)
			this.announcingUEHPLMNIdentifier = null;
		else
			this.announcingUEHPLMNIdentifier = new AnnouncingUEHPLMNIdentifierImpl(value, null, null);			
	}
	
	public String getAnnouncingUEVPLMNIdentifier()
	{
		if(announcingUEVPLMNIdentifier==null)
			return null;
		
		return announcingUEVPLMNIdentifier.getString();
	}
	
	public void setAnnouncingUEVPLMNIdentifier(String value)
	{
		if(value==null)
			this.announcingUEVPLMNIdentifier = null;
		else
			this.announcingUEVPLMNIdentifier = new AnnouncingUEVPLMNIdentifierImpl(value, null, null);			
	}
	
	public String getMonitoringUEHPLMNIdentifier()
	{
		if(monitoringUEHPLMNIdentifier==null)
			return null;
		
		return monitoringUEHPLMNIdentifier.getString();
	}
	
	public void setMonitoringUEHPLMNIdentifier(String value)
	{
		if(value==null)
			this.monitoringUEHPLMNIdentifier = null;
		else
			this.monitoringUEHPLMNIdentifier = new MonitoringUEHPLMNIdentifierImpl(value, null, null);			
	}
	
	public String getMonitoringUEVPLMNIdentifier()
	{
		if(monitoringUEVPLMNIdentifier==null)
			return null;
		
		return monitoringUEVPLMNIdentifier.getString();
	}
	
	public void setMonitoringUEVPLMNIdentifier(String value)
	{
		if(value==null)
			this.monitoringUEVPLMNIdentifier = null;
		else
			this.monitoringUEVPLMNIdentifier = new MonitoringUEVPLMNIdentifierImpl(value, null, null);			
	}
	
	public String getMonitoredPLMNIdentifier()
	{
		if(monitoredPLMNIdentifier==null)
			return null;
		
		return monitoredPLMNIdentifier.getString();
	}
	
	public void setMonitoredPLMNIdentifier(String value)
	{
		if(value==null)
			this.monitoredPLMNIdentifier = null;
		else
			this.monitoredPLMNIdentifier = new MonitoredPLMNIdentifierImpl(value, null, null);			
	}
	
	public RoleOfProSeFunctionEnum getRoleOfProSeFunction()
	{
		if(roleOfProSeFunction==null)
			return null;
		
		return roleOfProSeFunction.getEnumerated(RoleOfProSeFunctionEnum.class);
	}
	
	public void setRoleOfProSeFunction(RoleOfProSeFunctionEnum value)
	{
		if(value==null)
			this.roleOfProSeFunction = null;
		else
			this.roleOfProSeFunction = new RoleOfProSeFunctionImpl(value, null, null);			
	}
	
	public String getProSeAppId()
	{
		if(proSeAppId==null)
			return null;
		
		return proSeAppId.getString();
	}
	
	public void setProSeAppId(String value)
	{
		if(value==null)
			this.proSeAppId = null;
		else
			this.proSeAppId = new ProSeAppIdImpl(value, null, null);			
	}
	
	public String getProSe3rdPartyApplicationID()
	{
		if(proSe3rdPartyApplicationID==null)
			return null;
		
		return proSe3rdPartyApplicationID.getString();
	}
	
	public void setProSe3rdPartyApplicationID(String value)
	{
		if(value==null)
			this.proSe3rdPartyApplicationID = null;
		else
			this.proSe3rdPartyApplicationID = new ProSe3rdPartyApplicationIDImpl(value, null, null);			
	}
	
	public ByteBuf getApplicationSpecificData()
	{
		if(applicationSpecificData==null)
			return null;
		
		return applicationSpecificData.getValue();
	}
	
	public void setApplicationSpecificData(ByteBuf value)
	{
		if(value==null)
			this.applicationSpecificData = null;
		else
			this.applicationSpecificData = new ApplicationSpecificDataImpl(value, null, null);			
	}
	
	public ProSeEventTypeEnum getProSeEventType()
	{
		if(proSeEventType==null)
			return null;
		
		return proSeEventType.getEnumerated(ProSeEventTypeEnum.class);
	}
	
	public void setProSeEventType(ProSeEventTypeEnum value)
	{
		if(value==null)
			this.proSeEventType = null;
		else
			this.proSeEventType = new ProSeEventTypeImpl(value, null, null);			
	}
	
	public ProSeDirectDiscoveryModelEnum getProSeDirectDiscoveryModel()
	{
		if(proSeDirectDiscoveryModel==null)
			return null;
		
		return proSeDirectDiscoveryModel.getEnumerated(ProSeDirectDiscoveryModelEnum.class);
	}
	
	public void setProSeDirectDiscoveryModel(ProSeDirectDiscoveryModelEnum value)
	{
		if(value==null)
			this.proSeDirectDiscoveryModel = null;
		else
			this.proSeDirectDiscoveryModel = new ProSeDirectDiscoveryModelImpl(value, null, null);			
	}
	
	public InetAddress getProSeFunctionIPAddress()
	{
		if(proSeFunctionIPAddress==null)
			return null;
		
		return proSeFunctionIPAddress.getAddress();
	}
	
	public void setProSeFunctionIPAddress(InetAddress value)
	{
		if(value==null)
			this.proSeFunctionIPAddress = null;
		else
			this.proSeFunctionIPAddress = new ProSeFunctionIPAddressImpl(value, null, null);			
	}
	
	public ByteBuf getProSeFunctionID()
	{
		if(proSeFunctionID==null)
			return null;
		
		return proSeFunctionID.getValue();
	}
	
	public void setProSeFunctionID(ByteBuf value)
	{
		if(value==null)
			this.proSeFunctionID = null;
		else
			this.proSeFunctionID = new ProSeFunctionIDImpl(value, null, null);			
	}
	
	public Long getProSeValidityTimer()
	{
		if(proSeValidityTimer==null)
			return null;
		
		return proSeValidityTimer.getUnsigned();
	}
	
	public void setProSeValidityTimer(Long value)
	{
		if(value==null)
			this.proSeValidityTimer = null;
		else
			this.proSeValidityTimer = new ProSeValidityTimerImpl(value, null, null);			
	}
	
	public ProSeRoleOfUEEnum getProSeRoleOfUE()
	{
		if(proSeRoleOfUE==null)
			return null;
		
		return proSeRoleOfUE.getEnumerated(ProSeRoleOfUEEnum.class);
	}
	
	public void setProSeRoleOfUE(ProSeRoleOfUEEnum value)
	{
		if(value==null)
			this.proSeRoleOfUE = null;
		else
			this.proSeRoleOfUE = new ProSeRoleOfUEImpl(value, null, null);			
	}
	
	public Date getProSeRequestTimestamp()
	{
		if(proSeRequestTimestamp==null)
			return null;
		
		return proSeRequestTimestamp.getDateTime();
	}
	
	public void setProSeRequestTimestamp(Date value)
	{
		if(value==null)
			this.proSeRequestTimestamp = null;
		else
			this.proSeRequestTimestamp = new ProSeRequestTimestampImpl(value, null, null);			
	}
	
	public Integer getPC3ControlProtocolCause()
	{
		if(pc3ControlProtocolCause==null)
			return null;
		
		return pc3ControlProtocolCause.getInteger();
	}
	
	public void setPC3ControlProtocolCause(Integer value)
	{
		if(value==null)
			this.pc3ControlProtocolCause = null;
		else
			this.pc3ControlProtocolCause = new PC3ControlProtocolCauseImpl(value, null, null);			
	}
	
	public String getMonitoringUEIdentifier()
	{
		if(monitoringUEIdentifier==null)
			return null;
		
		return monitoringUEIdentifier.getString();
	}
	
	public void setMonitoringUEIdentifier(String value)
	{
		if(value==null)
			this.monitoringUEIdentifier = null;
		else
			this.monitoringUEIdentifier = new MonitoringUEIdentifierImpl(value, null, null);			
	}
	
	public String getProSeFunctionPLMNIdentifier()
	{
		if(proSeFunctionPLMNIdentifier==null)
			return null;
		
		return proSeFunctionPLMNIdentifier.getString();
	}
	
	public void setProSeFunctionPLMNIdentifier(String value)
	{
		if(value==null)
			this.proSeFunctionPLMNIdentifier = null;
		else
			this.proSeFunctionPLMNIdentifier = new ProSeFunctionPLMNIdentifierImpl(value, null, null);			
	}
	
	public String getRequestorPLMNIdentifier()
	{
		if(requestorPLMNIdentifier==null)
			return null;
		
		return requestorPLMNIdentifier.getString();
	}
	
	public void setRequestorPLMNIdentifier(String value)
	{
		if(value==null)
			this.requestorPLMNIdentifier = null;
		else
			this.requestorPLMNIdentifier = new RequestorPLMNIdentifierImpl(value, null, null);			
	}
	
	public String getOriginAppLayerUserId()
	{
		if(originAppLayerUserId==null)
			return null;
		
		return originAppLayerUserId.getString();
	}
	
	public void setOriginAppLayerUserId(String value)
	{
		if(value==null)
			this.originAppLayerUserId = null;
		else
			this.originAppLayerUserId = new OriginAppLayerUserIdImpl(value, null, null);			
	}
	
	public WLANLinkLayerId getWLANLinkLayerId()
	{
		return this.wlanLinkLayerId;
	}
	
	public void setWLANLinkLayerId(WLANLinkLayerId value)
	{
		this.wlanLinkLayerId = value;
	}
	
	public String getRequestingEPUID()
	{
		if(requestingEPUID==null)
			return null;
		
		return requestingEPUID.getString();
	}
	
	public void setRequestingEPUID(String value)
	{
		if(value==null)
			this.requestingEPUID = null;
		else
			this.requestingEPUID = new RequestingEPUIDImpl(value, null, null);			
	}
	
	public String getTargetAppLayerUserId()
	{
		if(targetAppLayerUserId==null)
			return null;
		
		return targetAppLayerUserId.getString();
	}
	
	public void setTargetAppLayerUserId(String value)
	{
		if(value==null)
			this.targetAppLayerUserId = null;
		else
			this.targetAppLayerUserId = new TargetAppLayerUserIdImpl(value, null, null);			
	}
	
	public String getRequestedPLMNIdentifier()
	{
		if(requestedPLMNIdentifier==null)
			return null;
		
		return requestedPLMNIdentifier.getString();
	}
	
	public void setRequestedPLMNIdentifier(String value)
	{
		if(value==null)
			this.requestedPLMNIdentifier = null;
		else
			this.requestedPLMNIdentifier = new RequestedPLMNIdentifierImpl(value, null, null);			
	}
	
	public Long getTimeWindow()
	{
		if(timeWindow==null)
			return null;
		
		return timeWindow.getUnsigned();
	}
	
	public void setTimeWindow(Long value)
	{
		if(value==null)
			this.timeWindow = null;
		else
			this.timeWindow = new TimeWindowImpl(value, null, null);			
	}
	
	public ProSeRangeClassEnum getProSeRangeClass()
	{
		if(proSeRangeClass==null)
			return null;
		
		return proSeRangeClass.getEnumerated(ProSeRangeClassEnum.class);
	}
	
	public void setProSeRangeClass(ProSeRangeClassEnum value)
	{
		if(value==null)
			this.proSeRangeClass = null;
		else
			this.proSeRangeClass = new ProSeRangeClassImpl(value, null, null);			
	}
	
	public ProximityAlertIndicationEnum getProximityAlertIndication()
	{
		if(proximityAlertIndication==null)
			return null;
		
		return proximityAlertIndication.getEnumerated(ProximityAlertIndicationEnum.class);
	}
	
	public void setProximityAlertIndication(ProximityAlertIndicationEnum value)
	{
		if(value==null)
			this.proximityAlertIndication = null;
		else
			this.proximityAlertIndication = new ProximityAlertIndicationImpl(value, null, null);			
	}
	
	public Date getProximityAlertTimestamp()
	{
		if(proximityAlertTimestamp==null)
			return null;
		
		return proximityAlertTimestamp.getDateTime();
	}
	
	public void setProximityAlertTimestamp(Date value)
	{
		if(value==null)
			this.proximityAlertTimestamp = null;
		else
			this.proximityAlertTimestamp = new ProximityAlertTimestampImpl(value, null, null);			
	}	
	
	public Date getProximityCancellationTimestamp()
	{
		if(proximityCancellationTimestamp==null)
			return null;
		
		return proximityCancellationTimestamp.getDateTime();
	}
	
	public void setProximityCancellationTimestamp(Date value)
	{
		if(value==null)
			this.proximityCancellationTimestamp = null;
		else
			this.proximityCancellationTimestamp = new ProximityCancellationTimestampImpl(value, null, null);			
	}
	
	public ProSeReasonForCancellationEnum getProSeReasonForCancellation()
	{
		if(proSeReasonForCancellation==null)
			return null;
		
		return proSeReasonForCancellation.getEnumerated(ProSeReasonForCancellationEnum.class);
	}
	
	public void setProSeReasonForCancellation(ProSeReasonForCancellationEnum value)
	{
		if(value==null)
			this.proSeReasonForCancellation = null;
		else
			this.proSeReasonForCancellation = new ProSeReasonForCancellationImpl(value, null, null);			
	}	
	
	public Integer getPC3EPCControlProtocolCause()
	{
		if(pc3EPCControlProtocolCause==null)
			return null;
		
		return pc3EPCControlProtocolCause.getInteger();
	}
	
	public void setPC3EPCControlProtocolCause(Integer value)
	{
		if(value==null)
			this.pc3EPCControlProtocolCause = null;
		else
			this.pc3EPCControlProtocolCause = new PC3EPCControlProtocolCauseImpl(value, null, null);			
	}
	
	public ByteBuf getProSeUEID()
	{
		if(proSeUEID==null)
			return null;
		
		return proSeUEID.getValue();
	}
	
	public void setProSeUEID(ByteBuf value)
	{
		if(value==null)
			this.proSeUEID = null;
		else
			this.proSeUEID = new ProSeUEIDImpl(value, null, null);			
	}
	
	public InetAddress getProSeSourceIPAddress()
	{
		if(proSeSourceIPAddress==null)
			return null;
		
		return proSeSourceIPAddress.getAddress();
	}
	
	public void setProSeSourceIPAddress(InetAddress value)
	{
		if(value==null)
			this.proSeSourceIPAddress = null;
		else
			this.proSeSourceIPAddress = new ProSeSourceIPAddressImpl(value, null, null);			
	}
	
	public ByteBuf getLayer2GroupID()
	{
		if(layer2GroupID==null)
			return null;
		
		return layer2GroupID.getValue();
	}
	
	public void setLayer2GroupID(ByteBuf value)
	{
		if(value==null)
			this.layer2GroupID = null;
		else
			this.layer2GroupID = new Layer2GroupIDImpl(value, null, null);			
	}
	
	public InetAddress getProSeGroupIPMulticastAddress()
	{
		if(proSeGroupIPMulticastAddress==null)
			return null;
		
		return proSeGroupIPMulticastAddress.getAddress();
	}
	
	public void setProSeGroupIPMulticastAddress(InetAddress value)
	{
		if(value==null)
			this.proSeGroupIPMulticastAddress = null;
		else
			this.proSeGroupIPMulticastAddress = new ProSeGroupIPMulticastAddressImpl(value, null, null);			
	}
	
	public List<CoverageInfo> getCoverageInfo()
	{
		return this.coverageInfo;
	}
	
	public void setCoverageInfo(List<CoverageInfo> value)
	{
		this.coverageInfo = value;
	}
	
	public List<RadioParameterSetInfo> getRadioParameterSetInfo()
	{
		return this.radioParameterSetInfo;
	}
	
	public void setRadioParameterSetInfo(List<RadioParameterSetInfo> value)
	{
		this.radioParameterSetInfo = value;
	}
	
	public List<TransmitterInfo> getTransmitterInfo()
	{
		return this.transmitterInfo;
	}
	
	public void setTransmitterInfo(List<TransmitterInfo> value)
	{
		this.transmitterInfo = value;
	}
	
	public Date getTimeFirstTransmission()
	{
		if(timeFirstTransmission==null)
			return null;
		
		return timeFirstTransmission.getDateTime();
	}
	
	public void setTimeFirstTransmission(Date value)
	{
		if(value==null)
			this.timeFirstTransmission = null;
		else
			this.timeFirstTransmission = new TimeFirstTransmissionImpl(value, null, null);			
	}
	
	public Date getTimeFirstReception()
	{
		if(timeFirstReception==null)
			return null;
		
		return timeFirstReception.getDateTime();
	}
	
	public void setTimeFirstReception(Date value)
	{
		if(value==null)
			this.timeFirstReception = null;
		else
			this.timeFirstReception = new TimeFirstReceptionImpl(value, null, null);			
	}
	
	public List<ProSeDirectCommunicationTransmissionDataContainer> getProSeDirectCommunicationTransmissionDataContainer()
	{
		return this.proSeDirectCommunicationTransmissionDataContainer;
	}
	
	public void setProSeDirectCommunicationTransmissionDataContainer(List<ProSeDirectCommunicationTransmissionDataContainer> value)
	{
		this.proSeDirectCommunicationTransmissionDataContainer = value;
	}
	
	public List<ProSeDirectCommunicationReceptionDataContainer> getProSeDirectCommunicationReceptionDataContainer()
	{
		return this.proSeDirectCommunicationReceptionDataContainer;
	}
	
	public void setProSeDirectCommunicationReceptionDataContainer(List<ProSeDirectCommunicationReceptionDataContainer> value)
	{
		this.proSeDirectCommunicationReceptionDataContainer = value;
	}
	
	public String getAnnouncingPLMNID()
	{
		if(announcingPLMNID==null)
			return null;
		
		return announcingPLMNID.getString();
	}
	
	public 	void setAnnouncingPLMNID(String value)
	{
		if(value==null)
			this.announcingPLMNID = null;
		else
			this.announcingPLMNID = new AnnouncingPLMNIDImpl(value, null, null);			
	}

	public ByteBuf getProSeTargetLayer2ID()
	{
		if(proSeTargetLayer2ID==null)
			return null;
		
		return proSeTargetLayer2ID.getValue();
	}
	
	public void setProSeTargetLayer2ID(ByteBuf value)
	{
		if(value==null)
			this.proSeTargetLayer2ID = null;
		else
			this.proSeTargetLayer2ID = new ProSeTargetLayer2IDImpl(value, null, null);			
	}	
	
	public InetAddress getRelayIPAddress()
	{
		if(relayIPAddress==null)
			return null;
		
		return relayIPAddress.getAddress();
	}
	
	public void setRelayIPAddress(InetAddress value)
	{
		if(value==null)
			this.relayIPAddress = null;
		else
			this.relayIPAddress = new RelayIPAddressImpl(value, null, null);			
	}
	
	public ByteBuf getProSeUEtoNetworkRelayUEID()
	{
		if(proSeUEToNetworkRelayUEID==null)
			return null;
		
		return proSeUEToNetworkRelayUEID.getValue();
	}
	
	public void setProSeUEtoNetworkRelayUEID(ByteBuf value)
	{
		if(value==null)
			this.proSeUEToNetworkRelayUEID = null;
		else
			this.proSeUEToNetworkRelayUEID = new ProSeUEtoNetworkRelayUEIDImpl(value, null, null);			
	}	
	
	public InetAddress getTargetIPAddress()
	{
		if(targetIPAddress==null)
			return null;
		
		return targetIPAddress.getAddress();
	}
	
	public void setTargetIPAddress(InetAddress value)
	{
		if(value==null)
			this.targetIPAddress = null;
		else
			this.targetIPAddress = new TargetIPAddressImpl(value, null, null);			
	}
	
	public PC5RadioTechnologyEnum getPC5RadioTechnology()
	{
		if(pc5RadioTechnology==null)
			return null;
		
		return pc5RadioTechnology.getEnumerated(PC5RadioTechnologyEnum.class);
	}
	
	public void setPC5RadioTechnology(PC5RadioTechnologyEnum value)
	{
		if(value==null)
			this.pc5RadioTechnology = null;
		else
			this.pc5RadioTechnology = new PC5RadioTechnologyImpl(value, null, null);			
	}
}