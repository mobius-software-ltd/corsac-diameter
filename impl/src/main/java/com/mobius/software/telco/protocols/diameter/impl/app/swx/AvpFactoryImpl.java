package com.mobius.software.telco.protocols.diameter.impl.app.swx;
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

import com.mobius.software.telco.protocols.diameter.app.swx.AvpFactory;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.SubscriptionIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.DeregistrationReasonImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.SIPAuthDataItemImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.SIPDigestAuthenticateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.SupportedFeaturesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.AllocationRetentionPriorityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPHomeAgentHostImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5447.MIP6AgentInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7683.OCOLRImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7683.OCSupportedFeaturesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc8583.LoadImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.AMBRImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.APNConfigurationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.ActiveAPNImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.AreaScopeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.EPSSubscribedQoSProfileImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.EmergencyInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.ListOfMeasurementsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.LocalTimeZoneImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.MBSFNAreaImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.MDTConfigurationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.ReportingTriggerImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.SpecificAPNInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.TerminalInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.TraceDataImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.WLANOffloadabilityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sta.AccessNetworkInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sta.WLANIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.swm.EmergencyServicesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.swx.AccessAuthorizationFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.swx.Non3GPPUserDataImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.swx.PPRFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.swx.TWANAccessInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.swx.TraceInfoImpl;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionIdTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.DeregistrationReason;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ReasonCodeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SIPAuthDataItem;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SIPDigestAuthenticate;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gx.AllocationRetentionPriority;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSClassIdentifierEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPHomeAgentHost;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6AgentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCReportTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AMBR;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.APNConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ActiveAPN;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AreaScope;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.DaylightSavingTimeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EPSSubscribedQoSProfile;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EmergencyInfo;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.JobTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ListOfMeasurements;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.LocalTimeZone;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.MBSFNArea;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.MDTConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.PDNTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ReportingTrigger;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SpecificAPNInfo;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TerminalInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TraceData;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TraceDepthEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.WLANOffloadability;
import com.mobius.software.telco.protocols.diameter.primitives.sta.AccessNetworkInfo;
import com.mobius.software.telco.protocols.diameter.primitives.sta.WLANIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.swm.EmergencyServices;
import com.mobius.software.telco.protocols.diameter.primitives.swx.AccessAuthorizationFlags;
import com.mobius.software.telco.protocols.diameter.primitives.swx.Non3GPPUserData;
import com.mobius.software.telco.protocols.diameter.primitives.swx.PPRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.swx.TWANAccessInfo;
import com.mobius.software.telco.protocols.diameter.primitives.swx.TraceInfo;

import io.netty.buffer.ByteBuf;

public class AvpFactoryImpl extends com.mobius.software.telco.protocols.diameter.impl.app.commons.AvpFactoryImpl implements AvpFactory
{
	public Load getLoad()
	{
		return new LoadImpl();
	}
	
	public OCOLR getOCOLR(Long ocSequenceNumber, OCReportTypeEnum ocReportType)
	{
		return new OCOLRImpl(ocSequenceNumber, ocReportType);
	}
	
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return new OCSupportedFeaturesImpl();
	}
	
	public SupportedFeatures getSupportedFeatures(Long vendorId, Long featureListID, Long featureList)
	{
		return new SupportedFeaturesImpl(vendorId, featureListID, featureList);
	}
	
	public TerminalInformation getTerminalInformation()
	{
		return new TerminalInformationImpl();
	}
	
	public SIPAuthDataItem getSIPAuthDataItem()
	{
		return new SIPAuthDataItemImpl();
	}
	
	public SIPDigestAuthenticate getSIPDigestAuthenticate(String digestRealm)
	{
		return new SIPDigestAuthenticateImpl(digestRealm);
	}
	
	public Non3GPPUserData getNon3GPPUserData()
	{
		return new Non3GPPUserDataImpl();
	}
	
	public SubscriptionId getSubscriptionId(SubscriptionIdTypeEnum subscriptionIdType,String subscriptionIdData)
	{
		return new SubscriptionIdImpl(subscriptionIdType, subscriptionIdData);
	}
	
	public AMBR getAMBR(Long maxRequestedBandwidthUL,Long maxRequestedBandwidthDL)
	{
		return new AMBRImpl(maxRequestedBandwidthUL, maxRequestedBandwidthDL);
	}
	
	public MIP6AgentInfo getMIP6AgentInfo()
	{
		return new MIP6AgentInfoImpl();
	}
	
	public MIPHomeAgentHost getMIPHomeAgentHost(String destinationHost,String destinationRealm)
	{
		return new MIPHomeAgentHostImpl(destinationHost, destinationRealm);
	}
	
	public APNConfiguration getAPNConfiguration(Long contextIdentifier,PDNTypeEnum pdnType,String serviceSelection)
	{
		return new APNConfigurationImpl(contextIdentifier, pdnType, serviceSelection);
	}
	
	public EPSSubscribedQoSProfile getEPSSubscribedQoSProfile(QoSClassIdentifierEnum qoSClassIdentifier,AllocationRetentionPriority allocationRetentionPriority)
	{
		return new EPSSubscribedQoSProfileImpl(qoSClassIdentifier, allocationRetentionPriority);
	}
	
	public AllocationRetentionPriority getAllocationRetentionPriority(Long priorityLevel)
	{
		return new AllocationRetentionPriorityImpl(priorityLevel);
	}
	
	public SpecificAPNInfo getSpecificAPNInfo(String serviceSelection,MIP6AgentInfo mip6AgentInfo)
	{
		return new SpecificAPNInfoImpl(serviceSelection, mip6AgentInfo);
	}
	
	public WLANOffloadability getWLANOffloadability()
	{
		return new WLANOffloadabilityImpl();
	}
	
	public TraceInfo getTraceInfo()
	{
		return new TraceInfoImpl();
	}
	
	public TraceData getTraceData(ByteBuf traceReference,TraceDepthEnum traceDepth,ByteBuf traceNETypeList,ByteBuf traceEventList,InetAddress traceCollectionEntity)
	{
		return new TraceDataImpl(traceReference, traceDepth, traceNETypeList, traceEventList, traceCollectionEntity);
	}
	
	public MDTConfiguration getMDTConfiguration(JobTypeEnum jobType)
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
	
	public TWANAccessInfo getTWANAccessInfo()
	{
		return new TWANAccessInfoImpl();
	}
	
	public WLANIdentifier getWLANIdentifier()
	{
		return new WLANIdentifierImpl();
	}
	
	public EmergencyInfo getEmergencyInfo()
	{
		return new EmergencyInfoImpl();
	}
	
	public AccessAuthorizationFlags getAccessAuthorizationFlags()
	{
		return new AccessAuthorizationFlagsImpl();
	}
	
	public AccessNetworkInfo getAccessNetworkInfo()
	{
		return new AccessNetworkInfoImpl();
	}
	
	public LocalTimeZone getLocalTimeZone(String timeZone,DaylightSavingTimeEnum daylightSavingTime)
	{
		return new LocalTimeZoneImpl(timeZone, daylightSavingTime);
	}
	
	public DeregistrationReason getDeregistrationReason(ReasonCodeEnum reasonCode)
	{
		return new DeregistrationReasonImpl(reasonCode);
	}
	
	public ActiveAPN getActiveAPN(Long contextIdentifier)
	{
		return new ActiveAPNImpl(contextIdentifier);
	}

	public EmergencyServices getEmergencyServices()
	{
		return new EmergencyServicesImpl();
	}
	
	public PPRFlags getPPRFlags()
	{
		return new PPRFlagsImpl();
	}
}
