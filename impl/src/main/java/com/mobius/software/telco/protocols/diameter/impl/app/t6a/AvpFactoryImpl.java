package com.mobius.software.telco.protocols.diameter.impl.app.t6a;
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

import com.mobius.software.telco.protocols.diameter.app.t6a.AvpFactory;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.UserCSGInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.SupportedFeaturesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7683.OCOLRImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7683.OCSupportedFeaturesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc8583.LoadImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.EDRXCycleLengthImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.UserIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.EPSLocationInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.ExcludeIdentifiersImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.IMEIChangeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.IncludeIdentifiersImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.LocationInformationConfigurationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.MMELocationInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.MTCProviderInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.MonitoringEventConfigStatusImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.MonitoringEventConfigurationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.MonitoringEventReportImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.PDNConnectivityStatusConfigurationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.PDNConnectivityStatusReportImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.ReachabilityTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.SGSNLocationInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.ServiceReportImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.ServiceResultImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.UEReachabilityConfigurationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.t6a.APNRateControlStatusImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.t6a.CMRFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.t6a.IdleStatusIndicationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.t6a.RRCCauseCounterImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.t6a.ServingPLMNRateControlImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.t6a.TDAFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.t6a.TerminalInformationImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CSGAccessModeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UserCSGInformation;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCReportTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EDRXCycleLength;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.EPSLocationInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.ExcludeIdentifiers;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.IMEIChange;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.IncludeIdentifiers;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.LocationInformationConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MMELocationInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MTCProviderInfo;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringEventConfigStatus;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringEventConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringEventReport;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.PDNConnectivityStatusConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.PDNConnectivityStatusReport;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.PDNConnectivityStatusTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.ReachabilityType;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SGSNLocationInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.ServiceReport;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.ServiceResult;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.UEReachabilityConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.APNRateControlStatus;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.CMRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.IdleStatusIndication;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.RRCCauseCounter;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.ServingPLMNRateControl;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.TDAFlags;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.TerminalInformation;

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
	
	public MTCProviderInfo getMTCProviderInfo()
	{
		return new MTCProviderInfoImpl();
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
	
	public MonitoringEventConfigStatus getMonitoringEventConfigStatus(List<ServiceReport> serviceReport) throws MissingAvpException
	{
		return new MonitoringEventConfigStatusImpl(serviceReport);
	}
	
	public IMEIChange getIMEIChange()
	{
		return new IMEIChangeImpl();
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
	
	public UserIdentifier getUserIdentifier()
	{
		return new UserIdentifierImpl();
	}
	
	public ServingPLMNRateControl getServingPLMNRateControl()
	{
		return new ServingPLMNRateControlImpl();
	}
	
	public TerminalInformation getTerminalInformation()
	{
		return new TerminalInformationImpl();
	}
	
	public APNRateControlStatus getAPNRateControlStatus(String apn,Long uplinkNumberOfPacketsAllowed,Long numberOfAdditionalExceptionReports,Long downlinkNumberOfPacketsAllowed,Long apnRateControlStatusValidityTime) throws MissingAvpException
	{
		return new APNRateControlStatusImpl(apn, uplinkNumberOfPacketsAllowed, numberOfAdditionalExceptionReports, downlinkNumberOfPacketsAllowed, apnRateControlStatusValidityTime);
	}
	
	public RRCCauseCounter getRRCCauseCounter()
	{
		return new RRCCauseCounterImpl();
	}
	
	public CMRFlags getCMRFlags()
	{
		return new CMRFlagsImpl();
	}
	
	public TDAFlags getTDAFlags()
	{
		return new TDAFlagsImpl();
	}
}