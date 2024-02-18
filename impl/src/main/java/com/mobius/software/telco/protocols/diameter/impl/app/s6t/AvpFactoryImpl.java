package com.mobius.software.telco.protocols.diameter.impl.app.s6t;
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

import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.app.s6t.AvpFactory;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.UserCSGInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.SupportedFeaturesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5777.DayOfWeekMaskImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7683.OCOLRImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7683.OCSupportedFeaturesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc8583.LoadImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.EDRXCycleLengthImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.IMSIGroupIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.TerminalInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.AdditionalServingNodeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.HSSCauseImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.ServiceDataImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.ServingNodeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.T4DataImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.AESECommunicationPatternConfigStatusImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.AESECommunicationPatternImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.AESEErrorReportImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.APNValidityTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.AdditionalIdentifiersImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.AllowedPLMNListImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.CIAFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.CIRFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.CommunicationPatternSetImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.EPSLocationInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.EnhancedCoverageRestrictionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.ExcludeIdentifiersImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.GroupReportImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.GroupReportItemImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.GroupUserIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.IMEIChangeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.IncludeIdentifiersImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.LocationInformationConfigurationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.MMELocationInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.MTCProviderInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.MonitoringEventConfigStatusImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.MonitoringEventConfigurationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.MonitoringEventReportImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.MonitoringEventReportStatusImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.NIDDAuthorizationRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.NIDDAuthorizationResponseImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.NIDDAuthorizationUpdateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.NIRFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.PDNConnectivityStatusConfigurationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.PDNConnectivityStatusReportImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.RIRFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.ReachabilityTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.RestrictedPLMNListImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.SGSNLocationInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.ScheduledCommunicationTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.ServiceReportImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.ServiceResultImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.SuggestedNetworkConfigurationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.SupportedMonitoringEventsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.SupportedServicesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.UEReachabilityConfigurationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.UpdatedNetworkConfigurationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.UserIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.t6a.IdleStatusIndicationImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CSGAccessModeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UserCSGInformation;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.DayOfWeekMask;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCReportTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EDRXCycleLength;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.IMSIGroupId;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TerminalInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.AdditionalServingNode;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.HSSCause;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.ServiceData;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.ServingNode;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.T4Data;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.AESECommunicationPattern;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.AESECommunicationPatternConfigStatus;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.AESEErrorReport;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.APNValidityTime;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.AdditionalIdentifiers;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.AllowedPLMNList;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.CIAFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.CIRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.CommunicationPatternSet;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.EPSLocationInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.EnhancedCoverageRestriction;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.ExcludeIdentifiers;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.GroupReport;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.GroupReportItem;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.GroupUserIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.IMEIChange;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.IncludeIdentifiers;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.LocationInformationConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MMELocationInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MTCProviderInfo;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringEventConfigStatus;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringEventConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringEventReport;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringEventReportStatus;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.NIDDAuthorizationRequest;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.NIDDAuthorizationResponse;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.NIDDAuthorizationUpdate;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.NIRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.PDNConnectivityStatusConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.PDNConnectivityStatusReport;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.PDNConnectivityStatusTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.RIRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.ReachabilityType;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.RestrictedPLMNList;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SGSNLocationInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.ScheduledCommunicationTime;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.ServiceReport;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.ServiceResult;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SuggestedNetworkConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SupportedMonitoringEvents;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SupportedServices;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.UEReachabilityConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.UpdatedNetworkConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.UserIdentifier;
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
	
	public UpdatedNetworkConfiguration getUpdatedNetworkConfiguration(String scefID) throws MissingAvpException
	{
		return new UpdatedNetworkConfigurationImpl(scefID);
	}
	
	public GroupReport getGroupReport(Long scefReferenceID) throws MissingAvpException
	{
		return new GroupReportImpl(scefReferenceID);
	}
	
	public GroupReportItem getGroupReportItem(UserIdentifier userIdentifier) throws MissingAvpException
	{
		return new GroupReportItemImpl(userIdentifier);
	}
	
	public MonitoringEventReportStatus getMonitoringEventReportStatus(Long scefReferenceID,String scefID) throws MissingAvpException
	{
		return new MonitoringEventReportStatusImpl(scefReferenceID, scefID);
	}
	
	public UserIdentifier getUserIdentifier()
	{
		return new UserIdentifierImpl();
	}
	
	public GroupUserIdentifier getGroupUserIdentifier()
	{
		return new GroupUserIdentifierImpl();
	}
	
	public AdditionalIdentifiers getAdditionalIdentifiers()
	{
		return new AdditionalIdentifiersImpl();
	}
	
	public NIDDAuthorizationRequest getNIDDAuthorizationRequest()
	{
		return new NIDDAuthorizationRequestImpl();
	}
	
	public NIDDAuthorizationUpdate getNIDDAuthorizationUpdate()
	{
		return new NIDDAuthorizationUpdateImpl();
	}
	
	public NIDDAuthorizationResponse getNIDDAuthorizationResponse()
	{
		return new NIDDAuthorizationResponseImpl();
	}
	
	public APNValidityTime getAPNValidityTime(Date grantedValidityTime) throws MissingAvpException
	{
		return new APNValidityTimeImpl(grantedValidityTime);
	}
	
	public SuggestedNetworkConfiguration getSuggestedNetworkConfiguration(Long scefReferenceID,String scefID) throws MissingAvpException
	{
		return new SuggestedNetworkConfigurationImpl(scefReferenceID, scefID);
	}
	
	public EnhancedCoverageRestriction getEnhancedCoverageRestriction()
	{
		return new EnhancedCoverageRestrictionImpl();
	}
	
	public RestrictedPLMNList getRestrictedPLMNList()
	{
		return new RestrictedPLMNListImpl();
	}
	
	public AllowedPLMNList getAllowedPLMNList()
	{
		return new AllowedPLMNListImpl();
	}
	
	public AESECommunicationPatternConfigStatus getAESECommunicationPatternConfigStatus(Long scefReferenceID) throws MissingAvpException
	{
		return new AESECommunicationPatternConfigStatusImpl(scefReferenceID);
	}
	
	public AESEErrorReport getAESEErrorReport()
	{
		return new AESEErrorReportImpl();
	}
	
	public MonitoringEventConfigStatus getMonitoringEventConfigStatus(List<ServiceReport> serviceReport) throws MissingAvpException
	{
		return new MonitoringEventConfigStatusImpl(serviceReport);
	}
	
	public MonitoringEventConfiguration getMonitoringEventConfiguration(String scefID,MonitoringTypeEnum monitoringType) throws MissingAvpException
	{
		return new MonitoringEventConfigurationImpl(scefID, monitoringType);
	}
	
	public UEReachabilityConfiguration getUEReachabilityConfiguration()
	{
		return new UEReachabilityConfigurationImpl();
	}
	
	public LocationInformationConfiguration getLocationInformationConfiguration()
	{
		return new LocationInformationConfigurationImpl();
	}
	
	public ReachabilityType getReachabilityType()
	{
		return new ReachabilityTypeImpl();
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
	
	public MonitoringEventReport getMonitoringEventReport(Long scefReferenceID) throws MissingAvpException
	{
		return new MonitoringEventReportImpl(scefReferenceID);
	}
	
	public IMEIChange getIMEIChange()
	{
		return new IMEIChangeImpl();
	}
	
	public TerminalInformation getTerminalInformation()
	{
		return new TerminalInformationImpl();
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
	
	public UserCSGInformation getUserCSGInformation(Long csgId,CSGAccessModeEnum csgAccessMode) throws MissingAvpException
	{
		return new UserCSGInformationImpl(csgId, csgAccessMode);
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
	
	public SupportedServices getSupportedServices()
	{
		return new SupportedServicesImpl();
	}
	
	public SupportedMonitoringEvents getSupportedMonitoringEvents()
	{
		return new SupportedMonitoringEventsImpl();
	}
	
	public MTCProviderInfo getMTCProviderInfo()
	{
		return new MTCProviderInfoImpl();
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
	
	public ServiceData getServiceData()
	{
		return new ServiceDataImpl();
	}
	
	public T4Data getT4Data()
	{
		return new T4DataImpl();
	}
	
	public HSSCause getHSSCause()
	{
		return new HSSCauseImpl();
	}
	
	public ServingNode getServingNode()
	{
		return new ServingNodeImpl();
	}
	
	public AdditionalServingNode getAdditionalServingNode()
	{
		return new AdditionalServingNodeImpl();
	}
	
	public IMSIGroupId getIMSIGroupId(Long groupServiceId,ByteBuf groupPLMNId,ByteBuf localGroupId) throws MissingAvpException
	{
		return new IMSIGroupIdImpl(groupServiceId, groupPLMNId, localGroupId);
	}
	
	public RIRFlags getRIRFlags()
	{
		return new RIRFlagsImpl();
	}
	
	public NIRFlags getNIRFlags()
	{
		return new NIRFlagsImpl();
	}
	
	public CIRFlags getCIRFlags()
	{
		return new CIRFlagsImpl();
	}
	
	public CIAFlags getCIAFlags()
	{
		return new CIAFlagsImpl();
	}
}