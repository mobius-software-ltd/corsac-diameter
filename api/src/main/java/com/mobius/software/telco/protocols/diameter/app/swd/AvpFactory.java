package com.mobius.software.telco.protocols.diameter.app.swd;
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

import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionIdTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gx.AllocationRetentionPriority;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSClassIdentifierEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPHomeAgentHost;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6AgentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.QoSCapability;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.QoSProfileTemplate;
import com.mobius.software.telco.protocols.diameter.primitives.rfc6734.Key;
import com.mobius.software.telco.protocols.diameter.primitives.rfc6734.KeyTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc6942.ERPRKRequest;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AMBR;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.APNConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AreaScope;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EPSSubscribedQoSProfile;
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
import com.mobius.software.telco.protocols.diameter.primitives.sta.ConnectivityFlags;
import com.mobius.software.telco.protocols.diameter.primitives.sta.DEAFlags;
import com.mobius.software.telco.protocols.diameter.primitives.sta.DERFlags;
import com.mobius.software.telco.protocols.diameter.primitives.sta.TWANConnectivityParameters;
import com.mobius.software.telco.protocols.diameter.primitives.sta.WLANIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.swx.TraceInfo;

import io.netty.buffer.ByteBuf;

public interface AvpFactory extends com.mobius.software.telco.protocols.diameter.app.commons.AvpFactory
{
	public OCSupportedFeatures getOCSupportedFeatures();
	
	public SupportedFeatures getSupportedFeatures(Long vendorId, Long featureListID, Long featureList) throws MissingAvpException;
	
	public SubscriptionId getSubscriptionId(SubscriptionIdTypeEnum subscriptionIdType,String subscriptionIdData) throws MissingAvpException;
	
	public QoSCapability getQoSCapability(List<QoSProfileTemplate> qoSProfileTemplate) throws MissingAvpException;
	
	public QoSProfileTemplate getQoSProfileTemplate(Long vendorId,Long qoSProfileId) throws MissingAvpException;
	
	public TerminalInformation getTerminalInformation();
	
	public WLANIdentifier getWLANIdentifier();
	
	public TWANConnectivityParameters getTWANConnectivityParameters();
	
	public ERPRKRequest getERPRKRequest(String erpRealm) throws MissingAvpException;
	
	public APNConfiguration getAPNConfiguration(Long contextIdentifier,PDNTypeEnum pdnType,String serviceSelection) throws MissingAvpException;
	
	public EPSSubscribedQoSProfile getEPSSubscribedQoSProfile(QoSClassIdentifierEnum qoSClassIdentifier,AllocationRetentionPriority allocationRetentionPriority) throws MissingAvpException;
	
	public AllocationRetentionPriority getAllocationRetentionPriority(Long priorityLevel) throws MissingAvpException;
	
	public MIP6AgentInfo getMIP6AgentInfo();
	
	public MIPHomeAgentHost getMIPHomeAgentHost(String destinationHost,String destinationRealm) throws MissingAvpException;
	
	public AMBR getAMBR(Long maxRequestedBandwidthUL,Long maxRequestedBandwidthDL) throws MissingAvpException;
	
	public SpecificAPNInfo getSpecificAPNInfo(String serviceSelection,MIP6AgentInfo mip6AgentInfo) throws MissingAvpException;
	
	public WLANOffloadability getWLANOffloadability();
	
	public TraceInfo getTraceInfo();
	
	public TraceData getTraceData(ByteBuf traceReference,TraceDepthEnum traceDepth,ByteBuf traceNETypeList,ByteBuf traceEventList,InetAddress traceCollectionEntity) throws MissingAvpException;
	
	public MDTConfiguration getMDTConfiguration(JobTypeEnum jobType) throws MissingAvpException;
	
	public AreaScope getAreaScope();
	
	public ListOfMeasurements getListOfMeasurements();
	
	public ReportingTrigger getReportingTrigger();
	
	public MBSFNArea getMBSFNArea();
	
	public ConnectivityFlags getConnectivityFlags();
	
	public Key getKey(KeyTypeEnum keyType, ByteBuf keyingMaterial) throws MissingAvpException;
	
	public DERFlags getDERFlags();
	
	public DEAFlags getDEAFlags();
}
