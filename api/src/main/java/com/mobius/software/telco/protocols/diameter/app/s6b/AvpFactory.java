package com.mobius.software.telco.protocols.diameter.app.s6b;
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
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gx.AllocationRetentionPriority;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSClassIdentifierEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPHomeAgentHost;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6AgentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.Classifier;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.DayOfMonthMask;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.DayOfWeekMask;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.ETHOption;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.ETHProtoType;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.EUI64AddressMask;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.ExcessTreatment;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.FilterRule;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.FromSpec;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.ICMPType;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.ICMPTypeNumberEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.IPAddressMask;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.IPAddressRange;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.IPOption;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.IPOptionTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.MACAddressMask;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.MonthOfYearMask;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.PortRange;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.QoSCapability;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.QoSParameters;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.QoSProfileTemplate;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.QoSResources;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.TCPFlags;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.TCPOption;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.TCPOptionTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.TimeOfDayCondition;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.ToSpec;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.TreatmentActionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCReportTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
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
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TraceData;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TraceDepthEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.WLANOffloadability;
import com.mobius.software.telco.protocols.diameter.primitives.s6b.DERS6bFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6b.RARFlags;
import com.mobius.software.telco.protocols.diameter.primitives.swx.TraceInfo;

import io.netty.buffer.ByteBuf;

public interface AvpFactory extends com.mobius.software.telco.protocols.diameter.app.commons.AvpFactory
{
	public Load getLoad();
	
	public OCOLR getOCOLR(Long ocSequenceNumber, OCReportTypeEnum ocReportType) throws MissingAvpException;
	
	public OCSupportedFeatures getOCSupportedFeatures();
	
	public SupportedFeatures getSupportedFeatures(Long vendorId, Long featureListID, Long featureList) throws MissingAvpException;
	
	public MIP6AgentInfo getMIP6AgentInfo();
	
	public MIPHomeAgentHost getMIPHomeAgentHost(String destinationHost,String destinationRealm) throws MissingAvpException;
	
	public QoSCapability getQoSCapability(List<QoSProfileTemplate> qoSProfileTemplate) throws MissingAvpException;
	
	public QoSProfileTemplate getQoSProfileTemplate(Long vendorId,Long qoSProfileId) throws MissingAvpException;
	
	public QoSParameters getQoSParameters();
	
	public ExcessTreatment getExcessTreatment(TreatmentActionEnum treatmentAction) throws MissingAvpException;
	
	public APNConfiguration getAPNConfiguration(Long contextIdentifier,PDNTypeEnum pdnType,String serviceSelection) throws MissingAvpException;
	
	public EPSSubscribedQoSProfile getEPSSubscribedQoSProfile(QoSClassIdentifierEnum qoSClassIdentifier,AllocationRetentionPriority allocationRetentionPriority) throws MissingAvpException;
	
	public AllocationRetentionPriority getAllocationRetentionPriority(Long priorityLevel) throws MissingAvpException;
	
	public AMBR getAMBR(Long maxRequestedBandwidthUL,Long maxRequestedBandwidthDL) throws MissingAvpException;
	
	public SpecificAPNInfo getSpecificAPNInfo(String serviceSelection,MIP6AgentInfo mip6AgentInfo) throws MissingAvpException;
	
	public WLANOffloadability getWLANOffloadability();
	
	public QoSResources getQoSResources(List<FilterRule> filterRule) throws MissingAvpException;
	
	public RARFlags getRARFlags();
	
	public FilterRule getFilterRule();
	
	public TimeOfDayCondition getTimeOfDayCondition();
	
	public Classifier getClassifier(ByteBuf classifierID) throws MissingAvpException;
	
	public MonthOfYearMask getMonthOfYearMask();
	
	public DayOfMonthMask getDayOfMonthMask();
	
	public DayOfWeekMask getDayOfWeekMask();
	
	public FromSpec getFromSpec();
	
	public ToSpec getToSpec();
	
	public IPOption getIPOption(IPOptionTypeEnum ipOptionType) throws MissingAvpException; 
	
	public TCPOption getTCPOption(TCPOptionTypeEnum tcpOptionType) throws MissingAvpException;
	
	public TCPFlags getTCPFlags(Long tcpFlagType) throws MissingAvpException;
	
	public ICMPType getICMPType(ICMPTypeNumberEnum icmpTypeNumber) throws MissingAvpException;
	
	public ETHOption getETHOption(ETHProtoType ethProtoType) throws MissingAvpException;
	
	public IPAddressRange getIPAddressRange(InetAddress ipAddressStart,InetAddress ipAddressEnd);
	
	public IPAddressMask getIPAddressMask(InetAddress ipAddress,Long ipBitMaskWidth) throws MissingAvpException;
	
	public MACAddressMask getMACAddressMask(ByteBuf macAddress,ByteBuf macAddressMaskPattern) throws MissingAvpException;
	
	public EUI64AddressMask getEUI64AddressMask(ByteBuf eui64Address,ByteBuf eui64AddressMaskPattern) throws MissingAvpException;
	
	public PortRange getPortRange(Integer portStart,Integer portEnd);
	
	public TraceInfo getTraceInfo();
	
	public TraceData getTraceData(ByteBuf traceReference,TraceDepthEnum traceDepth,ByteBuf traceNETypeList,ByteBuf traceEventList,InetAddress traceCollectionEntity) throws MissingAvpException;
	
	public MDTConfiguration getMDTConfiguration(JobTypeEnum jobType) throws MissingAvpException;
	
	public AreaScope getAreaScope();
	
	public ListOfMeasurements getListOfMeasurements();
	
	public ReportingTrigger getReportingTrigger();
	
	public MBSFNArea getMBSFNArea();
	
	public DERS6bFlags getDERS6bFlags();
}
