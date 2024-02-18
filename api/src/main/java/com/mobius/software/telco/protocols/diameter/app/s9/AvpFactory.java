package com.mobius.software.telco.protocols.diameter.app.s9;
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

import com.mobius.software.telco.protocols.diameter.exceptions.InvalidAvpValueException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterIpAction;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleAddress;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleDirection;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleIcmpType;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleIpOption;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleOption;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRulePorts;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleTcpFlag;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleTcpOption;
import com.mobius.software.telco.protocols.diameter.primitives.InternetProtocol;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CSGAccessModeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UserCSGInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CCMoney;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.FinalUnitActionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.FinalUnitIndication;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.GrantedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RedirectAddressTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RedirectServer;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RestrictionFilterRule;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionIdTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UnitValue;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UsedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfoTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ChargingInformation;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gx.AccessNetworkChargingIdentifierGx;
import com.mobius.software.telco.protocols.diameter.primitives.gx.AllocationRetentionPriority;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ApplicationDetectionInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleInstall;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleRemove;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleReport;
import com.mobius.software.telco.protocols.diameter.primitives.gx.CoAInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ConditionalAPNAggregateMaxBitrate;
import com.mobius.software.telco.protocols.diameter.primitives.gx.CreditManagementStatus;
import com.mobius.software.telco.protocols.diameter.primitives.gx.DefaultEPSBearerQoS;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventReportIndication;
import com.mobius.software.telco.protocols.diameter.primitives.gx.FlowDirectionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.FlowInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.MonitoringFlags;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PacketFilterContent;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PacketFilterInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PresenceReportingAreaInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PresenceReportingAreaNode;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RedirectInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RoutingFilter;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RoutingRuleDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RoutingRuleInstall;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RoutingRuleRemove;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RoutingRuleReport;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TFTFilter;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TFTPacketFilterInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TunnelHeaderFilter;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TunnelInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UsageMonitoringInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gxx.QoSRuleDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.gxx.QoSRuleInstall;
import com.mobius.software.telco.protocols.diameter.primitives.gxx.QoSRuleRemove;
import com.mobius.software.telco.protocols.diameter.primitives.gxx.QoSRuleReport;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCReportTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.rx.CalleeInformation;
import com.mobius.software.telco.protocols.diameter.primitives.rx.FlowDescription;
import com.mobius.software.telco.protocols.diameter.primitives.rx.Flows;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AreaScope;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.JobTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ListOfMeasurements;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.MBSFNArea;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.MDTConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ReportingTrigger;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TraceData;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TraceDepthEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s9.SubsessionDecisionInfo;
import com.mobius.software.telco.protocols.diameter.primitives.s9.SubsessionEnforcementInfo;

import io.netty.buffer.ByteBuf;


public interface AvpFactory extends com.mobius.software.telco.protocols.diameter.app.commons.AvpFactory
{
	public UserEquipmentInfo getUserEquipmentInfo(UserEquipmentInfoTypeEnum userEquipmentInfoType,ByteBuf userEquipmentInfoValue) throws MissingAvpException;
	
	public SubscriptionId getSubscriptionId(SubscriptionIdTypeEnum subscriptionIdType,String subscriptionIdData) throws MissingAvpException;
	
	public OCOLR getOCOLR(Long ocSequenceNumber, OCReportTypeEnum ocReportType) throws MissingAvpException;
	
	public OCSupportedFeatures getOCSupportedFeatures();
	
	public Load getLoad();
	
	public SupportedFeatures getSupportedFeatures(Long vendorId, Long featureListID, Long featureList) throws MissingAvpException;
	
	public QoSInformation getQoSInformation();
	
	public AllocationRetentionPriority getAllocationRetentionPriority(Long priorityLevel) throws MissingAvpException;
	
	public ConditionalAPNAggregateMaxBitrate getConditionalAPNAggregateMaxBitrate();
	
	public QoSRuleInstall getQoSRuleInstall();
	
	public QoSRuleRemove getQoSRuleRemove();
	
	public QoSRuleReport getQoSRuleReport();
	
	public QoSRuleDefinition getQoSRuleDefinition(ByteBuf qosRuleName) throws MissingAvpException;
	
	public ChargingRuleRemove getChargingRuleRemove();
	
	public ChargingRuleInstall getChargingRuleInstall();
	
	public ChargingRuleReport getChargingRuleReport();
	
	public ChargingRuleDefinition getChargingRuleDefinition(ByteBuf chargingRuleName) throws MissingAvpException;
	
	public MonitoringFlags getMonitoringFlags();
	
	public RoutingRuleInstall getRoutingRuleInstall();
	
	public RoutingRuleRemove getRoutingRuleRemove();
	
	public RoutingRuleReport getRoutingRuleReport();
	
	public RoutingRuleDefinition getRoutingRuleDefinition(ByteBuf routingRuleIdentifier) throws MissingAvpException;
	
	public RoutingFilter getRoutingFilter(FlowDescription flowDescription,FlowDirectionEnum flowDirection) throws MissingAvpException;
	
	public FinalUnitIndication getFinalUnitIndication(FinalUnitActionEnum finalUnitAction) throws MissingAvpException;
	
	public FlowInformation getFlowInformation();
	
	public PacketFilterInformation getPacketFilterInformation();
	
	public TFTPacketFilterInformation getTFTPacketFilterInformation();
	
	public UserCSGInformation getUserCSGInformation(Long csgId,CSGAccessModeEnum csgAccessMode) throws MissingAvpException;	
	
	public CreditManagementStatus getCreditManagementStatus();
	
	public ApplicationDetectionInformation getApplicationDetectionInformation(ByteBuf tdfApplicationIdentifier) throws MissingAvpException;
	
	public DefaultEPSBearerQoS getDefaultEPSBearerQoS();
	
	public UsageMonitoringInformation getUsageMonitoringInformation();
	
	public GrantedServiceUnit getGrantedServiceUnit();
	
	public UsedServiceUnit getUsedServiceUnit();
	
	public CCMoney getCCMoney(UnitValue unitValue) throws MissingAvpException;
	
	public UnitValue getUnitValue(Long valueDigits) throws MissingAvpException;
	
	public AccessNetworkChargingIdentifierGx getAccessNetworkChargingIdentifierGx(ByteBuf accessNetworkChargingIdentifierValue) throws MissingAvpException;
	
	public PacketFilterContent getPacketFilterContent(String rule) throws InvalidAvpValueException;
	
	public PacketFilterContent getPacketFilterContent(DiameterIpAction action, DiameterRuleDirection direction, InternetProtocol protocol, DiameterRuleAddress from, List<DiameterRulePorts> fromPorts,
			DiameterRuleAddress to, List<DiameterRulePorts> toPorts, List<DiameterRuleOption> options, List<DiameterRuleIpOption> ipOptions, List<DiameterRuleIpOption> negativeIpOptions,
			List<DiameterRuleTcpOption> tcpOptions, List<DiameterRuleTcpOption> negativeTcpOptions, List<DiameterRuleTcpFlag> tcpFlags, List<DiameterRuleTcpFlag> negativeTcpFlags,
			List<DiameterRuleIcmpType> icmpTypes) throws InvalidAvpValueException;
	
	public RestrictionFilterRule getRestrictionFilterRule(String rule) throws InvalidAvpValueException;
	
	public RestrictionFilterRule getRestrictionFilterRule(DiameterIpAction action,DiameterRuleDirection direction,InternetProtocol protocol,DiameterRuleAddress from,List<DiameterRulePorts> fromPorts,DiameterRuleAddress to,List<DiameterRulePorts> toPorts,List<DiameterRuleOption> options,List<DiameterRuleIpOption> ipOptions,List<DiameterRuleIpOption> negativeIpOptions,List<DiameterRuleTcpOption> tcpOptions,List<DiameterRuleTcpOption> negativeTcpOptions,List<DiameterRuleTcpFlag> tcpFlags,List<DiameterRuleTcpFlag> negativeTcpFlags,List<DiameterRuleIcmpType> icmpTypes) throws InvalidAvpValueException;
	
	public RedirectServer getRedirectServer(RedirectAddressTypeEnum redirectAddressType, String redirectServerAddress) throws MissingAvpException;
	
	public TFTFilter getTFTFilter(String rule) throws InvalidAvpValueException;
	
	public TFTFilter getTFTFilter(DiameterIpAction action, DiameterRuleDirection direction, InternetProtocol protocol, DiameterRuleAddress from, List<DiameterRulePorts> fromPorts, DiameterRuleAddress to,
			List<DiameterRulePorts> toPorts, List<DiameterRuleOption> options, List<DiameterRuleIpOption> ipOptions, List<DiameterRuleIpOption> negativeIpOptions,
			List<DiameterRuleTcpOption> tcpOptions, List<DiameterRuleTcpOption> negativeTcpOptions, List<DiameterRuleTcpFlag> tcpFlags, List<DiameterRuleTcpFlag> negativeTcpFlags,
			List<DiameterRuleIcmpType> icmpTypes) throws InvalidAvpValueException;
	
	public FlowDescription getFlowDescription(String rule) throws InvalidAvpValueException;
	
	public FlowDescription getFlowDescription(DiameterIpAction action, DiameterRuleDirection direction, InternetProtocol protocol, DiameterRuleAddress from, List<DiameterRulePorts> fromPorts, DiameterRuleAddress to,
			List<DiameterRulePorts> toPorts, List<DiameterRuleOption> options, List<DiameterRuleIpOption> ipOptions, List<DiameterRuleIpOption> negativeIpOptions,
			List<DiameterRuleTcpOption> tcpOptions, List<DiameterRuleTcpOption> negativeTcpOptions, List<DiameterRuleTcpFlag> tcpFlags, List<DiameterRuleTcpFlag> negativeTcpFlags,
			List<DiameterRuleIcmpType> icmpTypes) throws InvalidAvpValueException;
	
	public Flows getFlows(Long mediaComponentNumber) throws MissingAvpException;
	
	public RedirectInformation getRedirectInformation();
	
	public CalleeInformation getCalleeInformation();
	
	public EventReportIndication getEventReportIndication();
	
	public TraceData getTraceData(ByteBuf traceReference,TraceDepthEnum traceDepth,ByteBuf traceNETypeList,ByteBuf traceEventList,InetAddress traceCollectionEntity) throws MissingAvpException;
	
	public MDTConfiguration getMDTConfiguration(JobTypeEnum jobType) throws MissingAvpException;
	
	public AreaScope getAreaScope();
	
	public ListOfMeasurements getListOfMeasurements();
	
	public ReportingTrigger getReportingTrigger();
	
	public MBSFNArea getMBSFNArea();
	
	public PresenceReportingAreaInformation getPresenceReportingAreaInformation();
	
	public PresenceReportingAreaNode getPresenceReportingAreaNode();
	
	public SubsessionEnforcementInfo getSubsessionEnforcementInfo(Long subsessionId) throws MissingAvpException;
	
	public ChargingInformation getChargingInformation();
	
	public SubsessionDecisionInfo getSubsessionDecisionInfo(Long subsessionId) throws MissingAvpException;
	
	public CoAInformation getCoAInformation(TunnelInformation tunnelInformation,InetAddress coAIPAddress) throws MissingAvpException;
	
	public TunnelInformation getTunnelInformation();
	
	public TunnelHeaderFilter getTunnelHeaderFilter(String rule) throws InvalidAvpValueException;
	
	public TunnelHeaderFilter getTunnelHeaderFilter(DiameterIpAction action, DiameterRuleDirection direction, InternetProtocol protocol, DiameterRuleAddress from, List<DiameterRulePorts> fromPorts,
			DiameterRuleAddress to, List<DiameterRulePorts> toPorts, List<DiameterRuleOption> options, List<DiameterRuleIpOption> ipOptions, List<DiameterRuleIpOption> negativeIpOptions,
			List<DiameterRuleTcpOption> tcpOptions, List<DiameterRuleTcpOption> negativeTcpOptions, List<DiameterRuleTcpFlag> tcpFlags, List<DiameterRuleTcpFlag> negativeTcpFlags,
			List<DiameterRuleIcmpType> icmpTypes) throws InvalidAvpValueException;		
}