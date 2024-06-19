package com.mobius.software.telco.protocols.diameter.impl.app.swm;
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

import com.mobius.software.telco.protocols.diameter.app.swm.AvpFactory;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.SubscriptionIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.SupportedFeaturesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.AllocationRetentionPriorityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPHomeAgentHostImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5447.MIP6AgentInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5777.QoSCapabilityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5777.QoSProfileTemplateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7683.OCOLRImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7683.OCSupportedFeaturesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc8583.LoadImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.AMBRImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.APNConfigurationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.AreaScopeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.EPSSubscribedQoSProfileImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.EmergencyInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.ListOfMeasurementsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.MBSFNAreaImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.MDTConfigurationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.ReportingTriggerImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.SpecificAPNInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.TerminalInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.TraceDataImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.WLANOffloadabilityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sta.AccessNetworkInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.swm.AARFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.swm.EmergencyServicesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.swx.TraceInfoImpl;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionIdTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gx.AllocationRetentionPriority;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSClassIdentifierEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPHomeAgentHost;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6AgentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.QoSCapability;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.QoSProfileTemplate;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCReportTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AMBR;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.APNConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AreaScope;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EPSSubscribedQoSProfile;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EmergencyInfo;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.JobTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ListOfMeasurements;
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
import com.mobius.software.telco.protocols.diameter.primitives.swm.AARFlags;
import com.mobius.software.telco.protocols.diameter.primitives.swm.EmergencyServices;
import com.mobius.software.telco.protocols.diameter.primitives.swx.TraceInfo;

import io.netty.buffer.ByteBuf;
/**
*
* @author yulian oifa
*
*/
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
	
	public SubscriptionId getSubscriptionId(SubscriptionIdTypeEnum subscriptionIdType,String subscriptionIdData) throws MissingAvpException
	{
		return new SubscriptionIdImpl(subscriptionIdType, subscriptionIdData);
	}
	
	public MIP6AgentInfo getMIP6AgentInfo()
	{
		return new MIP6AgentInfoImpl();
	}
	
	public MIPHomeAgentHost getMIPHomeAgentHost(String destinationHost,String destinationRealm) throws MissingAvpException
	{
		return new MIPHomeAgentHostImpl(destinationHost, destinationRealm);
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
	
	public AMBR getAMBR(Long maxRequestedBandwidthUL,Long maxRequestedBandwidthDL) throws MissingAvpException
	{
		return new AMBRImpl(maxRequestedBandwidthUL, maxRequestedBandwidthDL);
	}
	
	public SpecificAPNInfo getSpecificAPNInfo(String serviceSelection,MIP6AgentInfo mip6AgentInfo) throws MissingAvpException
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
	
	public AccessNetworkInfo getAccessNetworkInfo()
	{
		return new AccessNetworkInfoImpl();
	}
	
	public QoSCapability getQoSCapability(List<QoSProfileTemplate> qoSProfileTemplate) throws MissingAvpException
	{
		return new QoSCapabilityImpl(qoSProfileTemplate);
	}
	
	public QoSProfileTemplate getQoSProfileTemplate(Long vendorId,Long qoSProfileId) throws MissingAvpException
	{
		return new QoSProfileTemplateImpl(vendorId, qoSProfileId);
	}
	
	public TerminalInformation getTerminalInformation()
	{
		return new TerminalInformationImpl();
	}
	
	public EmergencyInfo getEmergencyInfo()
	{
		return new EmergencyInfoImpl();
	}
	
	public AARFlags getAARFlags()
	{
		return new AARFlagsImpl();
	}
	
	public EmergencyServices getEmergencyServices()
	{
		return new EmergencyServicesImpl();
	}
}
