package com.mobius.software.telco.protocols.diameter.app.s6t;
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

public interface AvpFactory extends com.mobius.software.telco.protocols.diameter.app.commons.AvpFactory
{
	public Load getLoad();
	
	public OCOLR getOCOLR(Long ocSequenceNumber, OCReportTypeEnum ocReportType);
	
	public OCSupportedFeatures getOCSupportedFeatures();
	
	public SupportedFeatures getSupportedFeatures(Long vendorId, Long featureListID, Long featureList);
	
	public UpdatedNetworkConfiguration getUpdatedNetworkConfiguration(String scefID);
	
	public GroupReport getGroupReport(Long scefReferenceID);
	
	public GroupReportItem getGroupReportItem(UserIdentifier userIdentifier);
	
	public MonitoringEventReportStatus getMonitoringEventReportStatus(Long scefReferenceID,String scefID);
	
	public UserIdentifier getUserIdentifier();
	
	public GroupUserIdentifier getGroupUserIdentifier();
	
	public AdditionalIdentifiers getAdditionalIdentifiers();
	
	public NIDDAuthorizationRequest getNIDDAuthorizationRequest();
	
	public NIDDAuthorizationUpdate getNIDDAuthorizationUpdate();
	
	public NIDDAuthorizationResponse getNIDDAuthorizationResponse();
	
	public APNValidityTime getAPNValidityTime(Date grantedValidityTime);
	
	public SuggestedNetworkConfiguration getSuggestedNetworkConfiguration(Long scefReferenceID,String scefID);
	
	public EnhancedCoverageRestriction getEnhancedCoverageRestriction();
	
	public RestrictedPLMNList getRestrictedPLMNList();
	
	public AllowedPLMNList getAllowedPLMNList();
	
	public AESECommunicationPatternConfigStatus getAESECommunicationPatternConfigStatus(Long scefReferenceID);
	
	public AESEErrorReport getAESEErrorReport();
	
	public MonitoringEventConfigStatus getMonitoringEventConfigStatus(List<ServiceReport> serviceReport);
	
	public MonitoringEventConfiguration getMonitoringEventConfiguration(String scefID,MonitoringTypeEnum monitoringType);
	
	public UEReachabilityConfiguration getUEReachabilityConfiguration();
	
	public LocationInformationConfiguration getLocationInformationConfiguration();
	
	public ReachabilityType getReachabilityType();
	
	public PDNConnectivityStatusConfiguration getPDNConnectivityStatusConfiguration();
	
	public ExcludeIdentifiers getExcludeIdentifiers();
	
	public IncludeIdentifiers getIncludeIdentifiers();
	
	public MonitoringEventReport getMonitoringEventReport(Long scefReferenceID);
	
	public IMEIChange getIMEIChange();
	
	public TerminalInformation getTerminalInformation();
	
	public EPSLocationInformation getEPSLocationInformation();
	
	public MMELocationInformation getMMELocationInformation();
	
	public SGSNLocationInformation getSGSNLocationInformation();
	
	public UserCSGInformation getUserCSGInformation(Long csgId,CSGAccessModeEnum csgAccessMode);	
	
	public ServiceReport getServiceReport();
	
	public ServiceResult getServiceResult();
	
	public IdleStatusIndication getIdleStatusIndication();
	
	public EDRXCycleLength getEDRXCycleLength(RATTypeEnum ratType,ByteBuf eDRXCycleLengthValue);
	
	public PDNConnectivityStatusReport getPDNConnectivityStatusReport(Long contextIdentifier,PDNConnectivityStatusTypeEnum pdnConnectivityStatusType,String serviceSelection);
	
	public SupportedServices getSupportedServices();
	
	public SupportedMonitoringEvents getSupportedMonitoringEvents();
	
	public MTCProviderInfo getMTCProviderInfo();
	
	public AESECommunicationPattern getAESECommunicationPattern(String scefID);
	
	public CommunicationPatternSet getCommunicationPatternSet();
	
	public ScheduledCommunicationTime getScheduledCommunicationTime();
	
	public DayOfWeekMask getDayOfWeekMask();
	
	public ServiceData getServiceData();
	
	public T4Data getT4Data();
	
	public HSSCause getHSSCause();
	
	public ServingNode getServingNode();
	
	public AdditionalServingNode getAdditionalServingNode();
	
	public IMSIGroupId getIMSIGroupId(Long groupServiceId,ByteBuf groupPLMNId,ByteBuf localGroupId);
	
	public RIRFlags getRIRFlags();
	
	public NIRFlags getNIRFlags();
	
	public CIRFlags getCIRFlags();
	
	public CIAFlags getCIAFlags();
}
