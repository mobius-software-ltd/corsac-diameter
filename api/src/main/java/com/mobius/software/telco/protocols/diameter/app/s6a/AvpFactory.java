package com.mobius.software.telco.protocols.diameter.app.s6a;
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
import java.util.List;

import com.mobius.software.telco.protocols.diameter.primitives.accounting.CSGAccessModeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UserCSGInformation;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gx.AllocationRetentionPriority;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSClassIdentifierEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.pc4a.ProSeAllowedPLMN;
import com.mobius.software.telco.protocols.diameter.primitives.pc4a.ProSeDirectAllowed;
import com.mobius.software.telco.protocols.diameter.primitives.pc4a.ProSePermission;
import com.mobius.software.telco.protocols.diameter.primitives.pc4a.ProSeSubscriptionData;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPHomeAgentHost;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6AgentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.DayOfWeekMask;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCReportTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AIRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AMBR;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.APNConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.APNConfigurationProfile;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AccessRestrictionData;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ActiveAPN;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AdjacentAccessRestrictionData;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AdjacentPLMNs;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AreaScope;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AuthenticationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.BroadcastLocationAssistanceDataTypes;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.CLRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.CSGSubscriptionData;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.CallBarringInfo;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.CompleteDataListIncludedIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.DSAFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.DSRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.DaylightSavingTimeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EDRXCycleLength;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EDRXRelatedRAT;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EPSLocationInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EPSSubscribedQoSProfile;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EPSUserState;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EUTRANVector;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EmergencyInfo;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EquivalentPLMNList;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ExternalClient;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.GERANVector;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.GPRSSubscriptionData;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.HPLMNODB;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.IDAFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.IDRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.IMSIGroupId;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.JobTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.LCSInfo;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.LCSPrivacyException;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ListOfMeasurements;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.LocalTimeZone;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.MBSFNArea;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.MDTConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.MMELocationInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.MMEUserState;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.MOLR;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.MPSPriority;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.NORFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.OperationModeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.OperatorDeterminedBarring;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.PC5FlowBitrates;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.PC5QoSFlow;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.PDNTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.PDPContext;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.PUAFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.PURFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.PagingTimeWindow;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ReportingTrigger;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.RequestedEUTRANAuthenticationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.RequestedUTRANGERANAuthenticationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SGSNLocationInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SGSNUserState;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ServiceType;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SpecificAPNInfo;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SubscriptionData;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SubscriptionDataDeletion;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SubscriptionDataFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TeleserviceList;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TerminalInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TraceData;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TraceDepthEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.UEPC5QoS;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ULAFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ULRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.UTRANVector;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.V2XPermission;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.V2XSubscriptionData;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.V2XSubscriptionDataNr;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.WLANOffloadability;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.AESECommunicationPattern;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.CommunicationPatternSet;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.ExcludeIdentifiers;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.IMEIChange;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.IncludeIdentifiers;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.LocationInformationConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MTCProviderInfo;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringEventConfigStatus;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringEventConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringEventReport;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.PDNConnectivityStatusConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.PDNConnectivityStatusReport;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.PDNConnectivityStatusTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.ReachabilityType;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.ScheduledCommunicationTime;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.ServiceReport;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.ServiceResult;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SupportedMonitoringEvents;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SupportedServices;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.UEReachabilityConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.IdleStatusIndication;

import io.netty.buffer.ByteBuf;

public interface AvpFactory extends com.mobius.software.telco.protocols.diameter.app.commons.AvpFactory
{
	public Load getLoad();
	
	public OCOLR getOCOLR(Long ocSequenceNumber, OCReportTypeEnum ocReportType);
	
	public OCSupportedFeatures getOCSupportedFeatures();
	
	public SupportedFeatures getSupportedFeatures(Long vendorId, Long featureListID, Long featureList);
	
	public RequestedEUTRANAuthenticationInfo getRequestedEUTRANAuthenticationInfo();
	
	public RequestedUTRANGERANAuthenticationInfo getRequestedUTRANGERANAuthenticationInfo();
	
	public AuthenticationInfo getAuthenticationInfo();
	
	public EUTRANVector getEUTRANVector(ByteBuf rand,ByteBuf xres,ByteBuf autn,ByteBuf kasme);
	
	public UTRANVector getUTRANVector(ByteBuf rand,ByteBuf xres,ByteBuf autn,ByteBuf confidentialityKey,ByteBuf integrityKey);
	
	public GERANVector getGERANVector(ByteBuf rand,ByteBuf sres,ByteBuf kc);
	
	public EDRXRelatedRAT getEDRXRelatedRAT(List<RATTypeEnum> ratType);
	
	public EPSUserState getEPSUserState();
	
	public MMEUserState getMMEUserState();
	
	public SGSNUserState getSGSNUserState();
	
	public EPSLocationInformation getEPSLocationInformation();
	
	public MMELocationInformation getMMELocationInformation();
	
	public SGSNLocationInformation getSGSNLocationInformation();
	
	public com.mobius.software.telco.protocols.diameter.primitives.s6t.EPSLocationInformation getS6TEPSLocationInformation();
	
	public com.mobius.software.telco.protocols.diameter.primitives.s6t.MMELocationInformation getS6TMMELocationInformation();
	
	public com.mobius.software.telco.protocols.diameter.primitives.s6t.SGSNLocationInformation getS6TSGSNLocationInformation();
	
	public UserCSGInformation getUserCSGInformation(Long csgId,CSGAccessModeEnum csgAccessMode);	
	
	public LocalTimeZone getLocalTimeZone(String timeZone,DaylightSavingTimeEnum daylightSavingTime);
	
	public SupportedServices getSupportedServices();
	
	public SupportedMonitoringEvents getSupportedMonitoringEvents();
	
	public MonitoringEventReport getMonitoringEventReport(Long scefReferenceID);
	
	public MonitoringEventConfigStatus getMonitoringEventConfigStatus(List<ServiceReport> serviceReport);
	
	public IMEIChange getIMEIChange();
	
	public ServiceReport getServiceReport();
	
	public ServiceResult getServiceResult();
	
	public IdleStatusIndication getIdleStatusIndication();
	
	public EDRXCycleLength getEDRXCycleLength(RATTypeEnum ratType,ByteBuf eDRXCycleLengthValue);
	
	public PDNConnectivityStatusReport getPDNConnectivityStatusReport(Long contextIdentifier,PDNConnectivityStatusTypeEnum pdnConnectivityStatusType,String serviceSelection);
	
	public SubscriptionData getSubscriptionData();
	
	public OperatorDeterminedBarring getOperatorDeterminedBarring();
	
	public HPLMNODB getHPLMNODB();
	
	public AccessRestrictionData getAccessRestrictionData();
	
	public LCSInfo getLCSInfo();
	
	public LCSPrivacyException getLCSPrivacyException(ByteBuf ssCode,ByteBuf ssStatus);
	
	public ExternalClient getExternalClient(String clientIdentity);
	
	public ServiceType getServiceType(Long serviceTypeIdentity);
	
	public MOLR getMOLR(ByteBuf ssCode,ByteBuf ssStatus);
	
	public TeleserviceList getTeleserviceList(List<ByteBuf> tsCode);
		
	public CallBarringInfo getCallBarringInfo(ByteBuf ssCode,ByteBuf ssStatus);
	
	public AMBR getAMBR(Long maxRequestedBandwidthUL,Long maxRequestedBandwidthDL);
	
	public APNConfigurationProfile getAPNConfigurationProfile(Long contextIdentifier,List<APNConfiguration> apnConfiguration);
	
	public APNConfiguration getAPNConfiguration(Long contextIdentifier,PDNTypeEnum pdnType,String serviceSelection);
	
	public EPSSubscribedQoSProfile getEPSSubscribedQoSProfile(QoSClassIdentifierEnum qoSClassIdentifier,AllocationRetentionPriority allocationRetentionPriority);
	
	public AllocationRetentionPriority getAllocationRetentionPriority(Long priorityLevel);
	
	public SpecificAPNInfo getSpecificAPNInfo(String serviceSelection,MIP6AgentInfo mip6AgentInfo);
	
	public WLANOffloadability getWLANOffloadability();
	
	public TraceData getTraceData(ByteBuf traceReference,TraceDepthEnum traceDepth,ByteBuf traceNETypeList,ByteBuf traceEventList,InetAddress traceCollectionEntity);
	
	public MDTConfiguration getMDTConfiguration(JobTypeEnum jobType);
	
	public AreaScope getAreaScope();
	
	public ListOfMeasurements getListOfMeasurements();
	
	public ReportingTrigger getReportingTrigger();
	
	public MBSFNArea getMBSFNArea();
	
	public GPRSSubscriptionData getGPRSSubscriptionData(CompleteDataListIncludedIndicatorEnum completeDataListIncludedIndicator,List<PDPContext> pdpContext);
	
	public PDPContext getPDPContext(Long contextIdentifier,ByteBuf qoSSubscribed ,String serviceSelection);
	
	public CSGSubscriptionData getCSGSubscriptionData(Long csgId);
	
	public MPSPriority getMPSPriority();
	
	public ProSeSubscriptionData getProSeSubscriptionData(ProSePermission proSePermission);
	
	public ProSePermission getProSePermission();
	
	public ProSeAllowedPLMN getProSeAllowedPLMN();
	
	public ProSeDirectAllowed getProSeDirectAllowed();
	
	public SubscriptionDataFlags getSubscriptionDataFlags();
	
	public AdjacentAccessRestrictionData getAdjacentAccessRestrictionData(ByteBuf visitedPLMNId,AccessRestrictionData accessRestrictionData);
	
	public IMSIGroupId getIMSIGroupId(Long groupServiceId,ByteBuf groupPLMNId,ByteBuf localGroupId);
	
	public AESECommunicationPattern getAESECommunicationPattern(String scefID);
	
	public CommunicationPatternSet getCommunicationPatternSet();
	
	public ScheduledCommunicationTime getScheduledCommunicationTime();
	
	public DayOfWeekMask getDayOfWeekMask();
	
	public MTCProviderInfo getMTCProviderInfo();
	
	public MonitoringEventConfiguration getMonitoringEventConfiguration(String scefID,MonitoringTypeEnum monitoringType);
	
	public UEReachabilityConfiguration getUEReachabilityConfiguration();
	
	public ReachabilityType getReachabilityType();
	
	public LocationInformationConfiguration getLocationInformationConfiguration();
	
	public PDNConnectivityStatusConfiguration getPDNConnectivityStatusConfiguration();
	
	public ExcludeIdentifiers getExcludeIdentifiers();
	
	public IncludeIdentifiers getIncludeIdentifiers();
	
	public TerminalInformation getTerminalInformation();
	
	public MIP6AgentInfo getMIP6AgentInfo();
	
	public MIPHomeAgentHost getMIPHomeAgentHost(String destinationHost,String destinationRealm);
	
	public SubscriptionDataDeletion getSubscriptionDataDeletion(DSRFlags dsrFlags);
	
	public EmergencyInfo getEmergencyInfo();
	
	public V2XSubscriptionData getV2XSubscriptionData();
	
	public V2XSubscriptionDataNr getV2XSubscriptionDataNr();
	
	public V2XPermission getV2XPermission();
	
	public UEPC5QoS getUEPC5QoS(List<PC5QoSFlow> pc5QoSFlow);
	
	public PC5QoSFlow getPC5QoSFlow(Integer fiveQI);
	
	public PC5FlowBitrates getPC5FlowBitrates();
	
	public BroadcastLocationAssistanceDataTypes getBroadcastLocationAssistanceDataTypes();
	
	public PagingTimeWindow getPagingTimeWindow(OperationModeEnum operationMode,ByteBuf pagingTimeWindowLength);
	
	public ActiveAPN getActiveAPN(Long contextIdentifier);
	
	public EquivalentPLMNList getEquivalentPLMNList(List<ByteBuf> visitedPLMNId);
	
	public AdjacentPLMNs getAdjacentPLMNs(List<ByteBuf> visitedPLMNId);
	
	public AIRFlags getAIRFlags();
	
	public CLRFlags getCLRFlags();
	
	public DSAFlags getDSAFlags();
	
	public DSRFlags getDSRFlags();
	
	public IDAFlags getIDAFlags();
	
	public IDRFlags getIDRFlags();
	
	public NORFlags getNORFlags();
	
	public PUAFlags getPUAFlags();
	
	public PURFlags getPURFlags();	
	
	public ULAFlags getULAFlags();
	
	public ULRFlags getULRFlags();
}