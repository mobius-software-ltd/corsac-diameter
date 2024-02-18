package com.mobius.software.telco.protocols.diameter.impl.app.s6a;
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

import com.mobius.software.telco.protocols.diameter.app.s6a.AvpFactory;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.UserCSGInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.SupportedFeaturesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.AllocationRetentionPriorityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc4a.ProSeAllowedPLMNImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc4a.ProSeDirectAllowedImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc4a.ProSePermissionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc4a.ProSeSubscriptionDataImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPHomeAgentHostImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5447.MIP6AgentInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5777.DayOfWeekMaskImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7683.OCOLRImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7683.OCSupportedFeaturesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc8583.LoadImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.AIRFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.AMBRImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.APNConfigurationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.APNConfigurationProfileImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.AccessRestrictionDataImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.ActiveAPNImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.AdjacentAccessRestrictionDataImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.AdjacentPLMNsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.AreaScopeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.AuthenticationInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.BroadcastLocationAssistanceDataTypesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.CLRFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.CSGSubscriptionDataImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.CallBarringInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.DSAFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.DSRFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.EDRXCycleLengthImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.EDRXRelatedRATImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.EPSLocationInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.EPSSubscribedQoSProfileImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.EPSUserStateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.EUTRANVectorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.EmergencyInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.EquivalentPLMNListImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.ExternalClientImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.GERANVectorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.GPRSSubscriptionDataImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.HPLMNODBImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.IDAFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.IDRFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.IMSIGroupIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.LCSInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.LCSPrivacyExceptionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.ListOfMeasurementsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.LocalTimeZoneImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.MBSFNAreaImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.MDTConfigurationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.MMELocationInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.MMEUserStateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.MOLRImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.MPSPriorityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.NORFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.OperatorDeterminedBarringImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.PC5FlowBitratesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.PC5QoSFlowImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.PDPContextImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.PUAFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.PURFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.PagingTimeWindowImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.ReportingTriggerImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.RequestedEUTRANAuthenticationInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.RequestedUTRANGERANAuthenticationInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.SGSNLocationInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.SGSNUserStateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.ServiceTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.SpecificAPNInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.SubscriptionDataDeletionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.SubscriptionDataFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.SubscriptionDataImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.TeleserviceListImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.TerminalInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.TraceDataImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.UEPC5QoSImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.ULAFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.ULRFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.UTRANVectorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.V2XPermissionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.V2XSubscriptionDataImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.V2XSubscriptionDataNrImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.WLANOffloadabilityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.AESECommunicationPatternImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.CommunicationPatternSetImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.ExcludeIdentifiersImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.IMEIChangeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.IncludeIdentifiersImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.LocationInformationConfigurationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.MTCProviderInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.MonitoringEventConfigStatusImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.MonitoringEventConfigurationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.MonitoringEventReportImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.PDNConnectivityStatusConfigurationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.PDNConnectivityStatusReportImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.ReachabilityTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.ScheduledCommunicationTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.ServiceReportImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.ServiceResultImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.SupportedMonitoringEventsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.SupportedServicesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.UEReachabilityConfigurationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.t6a.IdleStatusIndicationImpl;
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

public class AvpFactoryImpl extends com.mobius.software.telco.protocols.diameter.impl.app.commons.AvpFactoryImpl implements AvpFactory
{
	public Load getLoad()
	{
		return new LoadImpl();
	}
	
	public OCOLR getOCOLR(Long ocSequenceNumber, OCReportTypeEnum ocReportType) throws MissingAvpException
	{
		return new OCOLRImpl(ocSequenceNumber, ocReportType);
	}
	
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return new OCSupportedFeaturesImpl();
	}
	
	public SupportedFeatures getSupportedFeatures(Long vendorId, Long featureListID, Long featureList) throws MissingAvpException
	{
		return new SupportedFeaturesImpl(vendorId, featureListID, featureList);
	}
	
	public RequestedEUTRANAuthenticationInfo getRequestedEUTRANAuthenticationInfo()
	{
		return new RequestedEUTRANAuthenticationInfoImpl();
	}
	
	public RequestedUTRANGERANAuthenticationInfo getRequestedUTRANGERANAuthenticationInfo()
	{
		return new RequestedUTRANGERANAuthenticationInfoImpl();
	}
	
	public AuthenticationInfo getAuthenticationInfo()
	{
		return new AuthenticationInfoImpl();
	}
	
	public EUTRANVector getEUTRANVector(ByteBuf rand,ByteBuf xres,ByteBuf autn,ByteBuf kasme) throws MissingAvpException
	{
		return new EUTRANVectorImpl(rand, xres, autn, kasme);
	}
	
	public UTRANVector getUTRANVector(ByteBuf rand,ByteBuf xres,ByteBuf autn,ByteBuf confidentialityKey,ByteBuf integrityKey) throws MissingAvpException
	{
		return new UTRANVectorImpl(rand, xres, autn, confidentialityKey, integrityKey);
	}
	
	public GERANVector getGERANVector(ByteBuf rand,ByteBuf sres,ByteBuf kc) throws MissingAvpException
	{
		return new GERANVectorImpl(rand, sres, kc);
	}
	
	public EDRXRelatedRAT getEDRXRelatedRAT(List<RATTypeEnum> ratType) throws MissingAvpException
	{
		return new EDRXRelatedRATImpl(ratType);
	}
	
	public EPSUserState getEPSUserState()
	{
		return new EPSUserStateImpl();
	}
	
	public MMEUserState getMMEUserState()
	{
		return new MMEUserStateImpl();
	}
	
	public SGSNUserState getSGSNUserState()
	{
		return new SGSNUserStateImpl();
	}
	
	public EPSLocationInformation getEPSLocationInformation()
	{
		return new EPSLocationInformationImpl();
	}
	
	public MMELocationInformation getMMELocationInformation()
	{
		return new MMELocationInformationImpl();
	}
	
	public SGSNLocationInformation getSGSNLocationInformation()
	{
		return new SGSNLocationInformationImpl();
	}
	
	public com.mobius.software.telco.protocols.diameter.primitives.s6t.EPSLocationInformation getS6TEPSLocationInformation()
	{
		return new com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.EPSLocationInformationImpl();
	}
	
	public com.mobius.software.telco.protocols.diameter.primitives.s6t.MMELocationInformation getS6TMMELocationInformation()
	{
		return new com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.MMELocationInformationImpl();
	}
	
	public com.mobius.software.telco.protocols.diameter.primitives.s6t.SGSNLocationInformation getS6TSGSNLocationInformation()
	{
		return new com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.SGSNLocationInformationImpl(); 
	}
	
	public UserCSGInformation getUserCSGInformation(Long csgId,CSGAccessModeEnum csgAccessMode) throws MissingAvpException
	{
		return new UserCSGInformationImpl(csgId, csgAccessMode);
	}	
	
	public LocalTimeZone getLocalTimeZone(String timeZone,DaylightSavingTimeEnum daylightSavingTime) throws MissingAvpException
	{
		return new LocalTimeZoneImpl(timeZone, daylightSavingTime);
	}
	
	public SupportedServices getSupportedServices()
	{
		return new SupportedServicesImpl();
	}
	
	public SupportedMonitoringEvents getSupportedMonitoringEvents()
	{
		return new SupportedMonitoringEventsImpl();
	}
	
	public MonitoringEventReport getMonitoringEventReport(Long scefReferenceID) throws MissingAvpException
	{
		return new MonitoringEventReportImpl(scefReferenceID);
	}
	
	public MonitoringEventConfigStatus getMonitoringEventConfigStatus(List<ServiceReport> serviceReport) throws MissingAvpException
	{
		return new MonitoringEventConfigStatusImpl(serviceReport);
	}
	
	public IMEIChange getIMEIChange()
	{
		return new IMEIChangeImpl();
	}
	
	public ServiceReport getServiceReport()
	{
		return new ServiceReportImpl();
	}
	
	public ServiceResult getServiceResult()
	{
		return new ServiceResultImpl();
	}
	
	public IdleStatusIndication getIdleStatusIndication()
	{
		return new IdleStatusIndicationImpl();
	}
	
	public EDRXCycleLength getEDRXCycleLength(RATTypeEnum ratType,ByteBuf eDRXCycleLengthValue) throws MissingAvpException
	{
		return new EDRXCycleLengthImpl(ratType, eDRXCycleLengthValue);
	}
	
	public PDNConnectivityStatusReport getPDNConnectivityStatusReport(Long contextIdentifier,PDNConnectivityStatusTypeEnum pdnConnectivityStatusType,String serviceSelection) throws MissingAvpException
	{
		return new PDNConnectivityStatusReportImpl(contextIdentifier, pdnConnectivityStatusType, serviceSelection);
	}
	
	public SubscriptionData getSubscriptionData()
	{
		return new SubscriptionDataImpl();
	}
	
	public OperatorDeterminedBarring getOperatorDeterminedBarring()
	{
		return new OperatorDeterminedBarringImpl();
	}
	
	public HPLMNODB getHPLMNODB()
	{
		return new HPLMNODBImpl();
	}
	
	public AccessRestrictionData getAccessRestrictionData()
	{
		return new AccessRestrictionDataImpl();
	}
	
	public LCSInfo getLCSInfo()
	{
		return new LCSInfoImpl();
	}
	
	public LCSPrivacyException getLCSPrivacyException(ByteBuf ssCode,ByteBuf ssStatus) throws MissingAvpException
	{
		return new LCSPrivacyExceptionImpl(ssCode, ssStatus);
	}
	
	public ExternalClient getExternalClient(String clientIdentity) throws MissingAvpException
	{
		return new ExternalClientImpl(clientIdentity);
	}
	
	public ServiceType getServiceType(Long serviceTypeIdentity) throws MissingAvpException
	{
		return new ServiceTypeImpl(serviceTypeIdentity);
	}
	
	public MOLR getMOLR(ByteBuf ssCode,ByteBuf ssStatus) throws MissingAvpException
	{
		return new MOLRImpl(ssCode, ssStatus);
	}
	
	public TeleserviceList getTeleserviceList(List<ByteBuf> tsCode) throws MissingAvpException
	{
		return new TeleserviceListImpl(tsCode);
	}
		
	public CallBarringInfo getCallBarringInfo(ByteBuf ssCode,ByteBuf ssStatus) throws MissingAvpException
	{
		return new CallBarringInfoImpl(ssCode, ssStatus);
	}
	
	public AMBR getAMBR(Long maxRequestedBandwidthUL,Long maxRequestedBandwidthDL) throws MissingAvpException
	{
		return new AMBRImpl(maxRequestedBandwidthUL, maxRequestedBandwidthDL);
	}
	
	public APNConfigurationProfile getAPNConfigurationProfile(Long contextIdentifier,List<APNConfiguration> apnConfiguration) throws MissingAvpException
	{
		return new APNConfigurationProfileImpl(contextIdentifier, apnConfiguration);
	}
	
	public APNConfiguration getAPNConfiguration(Long contextIdentifier,PDNTypeEnum pdnType,String serviceSelection) throws MissingAvpException
	{
		return new APNConfigurationImpl(contextIdentifier, pdnType, serviceSelection);
	}
	
	public EPSSubscribedQoSProfile getEPSSubscribedQoSProfile(QoSClassIdentifierEnum qoSClassIdentifier,AllocationRetentionPriority allocationRetentionPriority) throws MissingAvpException
	{
		return new EPSSubscribedQoSProfileImpl(qoSClassIdentifier, allocationRetentionPriority);
	}
	
	public AllocationRetentionPriority getAllocationRetentionPriority(Long priorityLevel) throws MissingAvpException
	{
		return new AllocationRetentionPriorityImpl(priorityLevel);
	}
	
	public SpecificAPNInfo getSpecificAPNInfo(String serviceSelection,MIP6AgentInfo mip6AgentInfo) throws MissingAvpException
	{
		return new SpecificAPNInfoImpl(serviceSelection, mip6AgentInfo);
	}
	
	public WLANOffloadability getWLANOffloadability()
	{
		return new WLANOffloadabilityImpl();
	}
	
	public TraceData getTraceData(ByteBuf traceReference,TraceDepthEnum traceDepth,ByteBuf traceNETypeList,ByteBuf traceEventList,InetAddress traceCollectionEntity) throws MissingAvpException
	{
		return new TraceDataImpl(traceReference, traceDepth, traceNETypeList, traceEventList, traceCollectionEntity);
	}
	
	public MDTConfiguration getMDTConfiguration(JobTypeEnum jobType) throws MissingAvpException
	{
		return new MDTConfigurationImpl(jobType);
	}
	
	public AreaScope getAreaScope()
	{
		return new AreaScopeImpl();
	}
	
	public ListOfMeasurements getListOfMeasurements()
	{
		return new ListOfMeasurementsImpl();
	}
	
	public ReportingTrigger getReportingTrigger()
	{
		return new ReportingTriggerImpl();
	}
	
	public MBSFNArea getMBSFNArea()
	{
		return new MBSFNAreaImpl();
	}
	
	public GPRSSubscriptionData getGPRSSubscriptionData(CompleteDataListIncludedIndicatorEnum completeDataListIncludedIndicator,List<PDPContext> pdpContext) throws MissingAvpException, AvpOccursTooManyTimesException
	{
		return new GPRSSubscriptionDataImpl(completeDataListIncludedIndicator, pdpContext);
	}
	
	public PDPContext getPDPContext(Long contextIdentifier,ByteBuf qoSSubscribed ,String serviceSelection) throws MissingAvpException
	{
		return new PDPContextImpl(contextIdentifier, qoSSubscribed, serviceSelection);
	}
	
	public CSGSubscriptionData getCSGSubscriptionData(Long csgId) throws MissingAvpException
	{
		return new CSGSubscriptionDataImpl(csgId);
	}
	
	public MPSPriority getMPSPriority()
	{
		return new MPSPriorityImpl();
	}
	
	public ProSeSubscriptionData getProSeSubscriptionData(ProSePermission proSePermission) throws MissingAvpException
	{
		return new ProSeSubscriptionDataImpl(proSePermission);
	}
	
	public ProSePermission getProSePermission()
	{
		return new ProSePermissionImpl();
	}
	
	public ProSeAllowedPLMN getProSeAllowedPLMN()
	{
		return new ProSeAllowedPLMNImpl();
	}
	
	public ProSeDirectAllowed getProSeDirectAllowed()
	{
		return new ProSeDirectAllowedImpl();
	}
	
	public SubscriptionDataFlags getSubscriptionDataFlags()
	{
		return new SubscriptionDataFlagsImpl();
	}
	
	public AdjacentAccessRestrictionData getAdjacentAccessRestrictionData(ByteBuf visitedPLMNId,AccessRestrictionData accessRestrictionData) throws MissingAvpException
	{
		return new AdjacentAccessRestrictionDataImpl(visitedPLMNId, accessRestrictionData);
	}
	
	public IMSIGroupId getIMSIGroupId(Long groupServiceId,ByteBuf groupPLMNId,ByteBuf localGroupId) throws MissingAvpException
	{
		return new IMSIGroupIdImpl(groupServiceId, groupPLMNId, localGroupId);
	}
	
	public AESECommunicationPattern getAESECommunicationPattern(String scefID) throws MissingAvpException
	{
		return new AESECommunicationPatternImpl(scefID);
	}
	
	public CommunicationPatternSet getCommunicationPatternSet()
	{
		return new CommunicationPatternSetImpl();
	}
	
	public ScheduledCommunicationTime getScheduledCommunicationTime()
	{
		return new ScheduledCommunicationTimeImpl();
	}
	
	public DayOfWeekMask getDayOfWeekMask()
	{
		return new DayOfWeekMaskImpl();
	}
	
	public MTCProviderInfo getMTCProviderInfo()
	{
		return new MTCProviderInfoImpl();
	}
	
	public MonitoringEventConfiguration getMonitoringEventConfiguration(String scefID,MonitoringTypeEnum monitoringType) throws MissingAvpException
	{
		return new MonitoringEventConfigurationImpl(scefID, monitoringType);
	}
	
	public UEReachabilityConfiguration getUEReachabilityConfiguration()
	{
		return new UEReachabilityConfigurationImpl();
	}
	
	public ReachabilityType getReachabilityType()
	{
		return new ReachabilityTypeImpl();
	}
	
	public LocationInformationConfiguration getLocationInformationConfiguration()
	{
		return new LocationInformationConfigurationImpl();
	}
	
	public PDNConnectivityStatusConfiguration getPDNConnectivityStatusConfiguration()
	{
		return new PDNConnectivityStatusConfigurationImpl();
	}
	
	public ExcludeIdentifiers getExcludeIdentifiers()
	{
		return new ExcludeIdentifiersImpl();
	}
	
	public IncludeIdentifiers getIncludeIdentifiers()
	{
		return new IncludeIdentifiersImpl();
	}
	
	public TerminalInformation getTerminalInformation()
	{
		return new TerminalInformationImpl();
	}
	
	public MIP6AgentInfo getMIP6AgentInfo()
	{
		return new MIP6AgentInfoImpl();
	}
	
	public MIPHomeAgentHost getMIPHomeAgentHost(String destinationHost,String destinationRealm) throws MissingAvpException
	{
		return new MIPHomeAgentHostImpl(destinationHost, destinationRealm);
	}
	
	public SubscriptionDataDeletion getSubscriptionDataDeletion(DSRFlags dsrFlags) throws MissingAvpException
	{
		return new SubscriptionDataDeletionImpl(dsrFlags);
	}
	
	public EmergencyInfo getEmergencyInfo()
	{
		return new EmergencyInfoImpl();
	}
	
	public V2XSubscriptionData getV2XSubscriptionData()
	{
		return new V2XSubscriptionDataImpl();
	}
	
	public V2XSubscriptionDataNr getV2XSubscriptionDataNr()
	{
		return new V2XSubscriptionDataNrImpl();
	}
	
	public V2XPermission getV2XPermission()
	{
		return new V2XPermissionImpl();
	}
	
	public UEPC5QoS getUEPC5QoS(List<PC5QoSFlow> pc5QoSFlow) throws MissingAvpException
	{
		return new UEPC5QoSImpl(pc5QoSFlow);
	}
	
	public PC5QoSFlow getPC5QoSFlow(Integer fiveQI) throws MissingAvpException
	{
		return new PC5QoSFlowImpl(fiveQI);
	}
	
	public PC5FlowBitrates getPC5FlowBitrates()
	{
		return new PC5FlowBitratesImpl();
	}
	
	public BroadcastLocationAssistanceDataTypes getBroadcastLocationAssistanceDataTypes()
	{
		return new BroadcastLocationAssistanceDataTypesImpl();
	}
	
	public PagingTimeWindow getPagingTimeWindow(OperationModeEnum operationMode,ByteBuf pagingTimeWindowLength) throws MissingAvpException
	{
		return new PagingTimeWindowImpl(operationMode, pagingTimeWindowLength);
	}
	
	public ActiveAPN getActiveAPN(Long contextIdentifier) throws MissingAvpException
	{
		return new ActiveAPNImpl(contextIdentifier);
	}
	
	public EquivalentPLMNList getEquivalentPLMNList(List<ByteBuf> visitedPLMNId) throws MissingAvpException
	{
		return new EquivalentPLMNListImpl(visitedPLMNId);
	}
	
	public AdjacentPLMNs getAdjacentPLMNs(List<ByteBuf> visitedPLMNId) throws MissingAvpException
	{
		return new AdjacentPLMNsImpl(visitedPLMNId);
	}
	
	public AIRFlags getAIRFlags()
	{
		return new AIRFlagsImpl();
	}
	
	public CLRFlags getCLRFlags()
	{
		return new CLRFlagsImpl();
	}
	
	public DSAFlags getDSAFlags()
	{
		return new DSAFlagsImpl();
	}
	
	public DSRFlags getDSRFlags()
	{
		return new DSRFlagsImpl();
	}
	
	public IDAFlags getIDAFlags()
	{
		return new IDAFlagsImpl();
	}
	
	public IDRFlags getIDRFlags()
	{
		return new IDRFlagsImpl();
	}
	
	public NORFlags getNORFlags()
	{
		return new NORFlagsImpl();
	}
	
	public PUAFlags getPUAFlags()
	{
		return new PUAFlagsImpl();
	}
	
	public PURFlags getPURFlags()
	{
		return new PURFlagsImpl();
	}	
	
	public ULAFlags getULAFlags()
	{
		return new ULAFlagsImpl();
	}
	
	public ULRFlags getULRFlags()
	{
		return new ULRFlagsImpl();
	}
}