package com.mobius.software.telco.protocols.diameter.impl.app.s9;
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

import com.mobius.software.telco.protocols.diameter.app.s9.AvpFactory;
import com.mobius.software.telco.protocols.diameter.exceptions.InvalidAvpValueException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.OCOLRImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.UserCSGInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CCMoneyImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.FinalUnitIndicationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.GrantedServiceUnitImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.RedirectServerImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.RestrictionFilterRuleImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.SubscriptionIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.UnitValueImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.UsedServiceUnitImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.UserEquipmentInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.ChargingInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.SupportedFeaturesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.AccessNetworkChargingIdentifierGxImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.AllocationRetentionPriorityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.ApplicationDetectionInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.ChargingRuleDefinitionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.ChargingRuleInstallImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.ChargingRuleRemoveImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.ChargingRuleReportImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.CoAInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.ConditionalAPNAggregateMaxBitrateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.CreditManagementStatusImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.DefaultEPSBearerQoSImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.EventReportIndicationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.FlowInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.MonitoringFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.PacketFilterContentImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.PacketFilterInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.PresenceReportingAreaInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.PresenceReportingAreaNodeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.QoSInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RedirectInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RoutingFilterImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RoutingRuleDefinitionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RoutingRuleInstallImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RoutingRuleRemoveImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RoutingRuleReportImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.TFTFilterImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.TFTPacketFilterInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.TunnelHeaderFilterImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.TunnelInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.UsageMonitoringInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gxx.QoSRuleDefinitionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gxx.QoSRuleInstallImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gxx.QoSRuleRemoveImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gxx.QoSRuleReportImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7683.OCSupportedFeaturesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc8583.LoadImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.CalleeInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.FlowDescriptionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.FlowsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.AreaScopeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.ListOfMeasurementsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.MBSFNAreaImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.MDTConfigurationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.ReportingTriggerImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.TraceDataImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s9.SubsessionDecisionInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s9.SubsessionEnforcementInfoImpl;
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

public class AvpFactoryImpl extends com.mobius.software.telco.protocols.diameter.impl.app.commons.AvpFactoryImpl implements AvpFactory
{
	public UserEquipmentInfo getUserEquipmentInfo(UserEquipmentInfoTypeEnum userEquipmentInfoType,ByteBuf userEquipmentInfoValue) throws MissingAvpException
	{
		return new UserEquipmentInfoImpl(userEquipmentInfoType, userEquipmentInfoValue);
	}
	
	public SubscriptionId getSubscriptionId(SubscriptionIdTypeEnum subscriptionIdType,String subscriptionIdData) throws MissingAvpException
	{
		return new SubscriptionIdImpl(subscriptionIdType, subscriptionIdData);
	}
	
	public OCOLR getOCOLR(Long ocSequenceNumber, OCReportTypeEnum ocReportType) throws MissingAvpException
	{
		return new OCOLRImpl(ocSequenceNumber, ocReportType);
	}
	
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return new OCSupportedFeaturesImpl();
	}
	
	public Load getLoad()
	{
		return new LoadImpl();
	}
	
	public SupportedFeatures getSupportedFeatures(Long vendorId, Long featureListID, Long featureList) throws MissingAvpException
	{
		return new SupportedFeaturesImpl(vendorId, featureListID, featureList);
	}
	
	public QoSInformation getQoSInformation()
	{
		return new QoSInformationImpl();
	}
	
	public AllocationRetentionPriority getAllocationRetentionPriority(Long priorityLevel) throws MissingAvpException
	{
		return new AllocationRetentionPriorityImpl(priorityLevel);
	}
	
	public ConditionalAPNAggregateMaxBitrate getConditionalAPNAggregateMaxBitrate()
	{
		return new ConditionalAPNAggregateMaxBitrateImpl();
	}
	
	public QoSRuleInstall getQoSRuleInstall()
	{
		return new QoSRuleInstallImpl();
	}
	
	public QoSRuleRemove getQoSRuleRemove()
	{
		return new QoSRuleRemoveImpl();
	}
	
	public QoSRuleReport getQoSRuleReport()
	{
		return new QoSRuleReportImpl();
	}
	
	public QoSRuleDefinition getQoSRuleDefinition(ByteBuf qosRuleName) throws MissingAvpException
	{
		return new QoSRuleDefinitionImpl(qosRuleName);
	}
	
	public ChargingRuleRemove getChargingRuleRemove()
	{
		return new ChargingRuleRemoveImpl();
	}
	
	public ChargingRuleInstall getChargingRuleInstall()
	{
		return new ChargingRuleInstallImpl();
	}
	
	public ChargingRuleReport getChargingRuleReport()
	{
		return new ChargingRuleReportImpl();
	}
	
	public ChargingRuleDefinition getChargingRuleDefinition(ByteBuf chargingRuleName) throws MissingAvpException
	{
		return new ChargingRuleDefinitionImpl(chargingRuleName);
	}
	
	public MonitoringFlags getMonitoringFlags()
	{
		return new MonitoringFlagsImpl();
	}
	
	public RoutingRuleInstall getRoutingRuleInstall()
	{
		return new RoutingRuleInstallImpl();
	}
	
	public RoutingRuleRemove getRoutingRuleRemove()
	{
		return new RoutingRuleRemoveImpl();
	}
	
	public RoutingRuleReport getRoutingRuleReport()
	{
		return new RoutingRuleReportImpl();
	}
	
	public RoutingRuleDefinition getRoutingRuleDefinition(ByteBuf routingRuleIdentifier) throws MissingAvpException
	{
		return new RoutingRuleDefinitionImpl(routingRuleIdentifier);
	}
	
	public RoutingFilter getRoutingFilter(FlowDescription flowDescription,FlowDirectionEnum flowDirection) throws MissingAvpException
	{
		return new RoutingFilterImpl(flowDescription, flowDirection);
	}
	
	public FinalUnitIndication getFinalUnitIndication(FinalUnitActionEnum finalUnitAction) throws MissingAvpException
	{
		return new FinalUnitIndicationImpl(finalUnitAction);
	}
	
	public FlowInformation getFlowInformation()
	{
		return new FlowInformationImpl();
	}
	
	public PacketFilterInformation getPacketFilterInformation()
	{
		return new PacketFilterInformationImpl();
	}
	
	public TFTPacketFilterInformation getTFTPacketFilterInformation()
	{
		return new TFTPacketFilterInformationImpl();
	}
	
	public UserCSGInformation getUserCSGInformation(Long csgId,CSGAccessModeEnum csgAccessMode) throws MissingAvpException
	{
		return new UserCSGInformationImpl(csgId, csgAccessMode);
	}	
	
	public CreditManagementStatus getCreditManagementStatus()
	{
		return new CreditManagementStatusImpl();
	}
	
	public ApplicationDetectionInformation getApplicationDetectionInformation(ByteBuf tdfApplicationIdentifier) throws MissingAvpException
	{
		return new ApplicationDetectionInformationImpl(tdfApplicationIdentifier);
	}
	
	public DefaultEPSBearerQoS getDefaultEPSBearerQoS()
	{
		return new DefaultEPSBearerQoSImpl();
	}
	
	public UsageMonitoringInformation getUsageMonitoringInformation()
	{
		return new UsageMonitoringInformationImpl();
	}
	
	public GrantedServiceUnit getGrantedServiceUnit()
	{
		return new GrantedServiceUnitImpl();
	}
	
	public UsedServiceUnit getUsedServiceUnit()
	{
		return new UsedServiceUnitImpl();
	}
	
	public CCMoney getCCMoney(UnitValue unitValue) throws MissingAvpException
	{
		return new CCMoneyImpl(unitValue);
	}
	
	public UnitValue getUnitValue(Long valueDigits) throws MissingAvpException
	{
		return new UnitValueImpl(valueDigits);
	}
	
	public AccessNetworkChargingIdentifierGx getAccessNetworkChargingIdentifierGx(ByteBuf accessNetworkChargingIdentifierValue) throws MissingAvpException
	{
		return new AccessNetworkChargingIdentifierGxImpl(accessNetworkChargingIdentifierValue);
	}
	
	public PacketFilterContent getPacketFilterContent(String rule) throws InvalidAvpValueException
	{
		return new PacketFilterContentImpl(rule, null, null);
	}
	
	public PacketFilterContent getPacketFilterContent(DiameterIpAction action,DiameterRuleDirection direction,InternetProtocol protocol,DiameterRuleAddress from,List<DiameterRulePorts> fromPorts,DiameterRuleAddress to,List<DiameterRulePorts> toPorts,List<DiameterRuleOption> options,List<DiameterRuleIpOption> ipOptions,List<DiameterRuleIpOption> negativeIpOptions,List<DiameterRuleTcpOption> tcpOptions,List<DiameterRuleTcpOption> negativeTcpOptions,List<DiameterRuleTcpFlag> tcpFlags,List<DiameterRuleTcpFlag> negativeTcpFlags,List<DiameterRuleIcmpType> icmpTypes) throws InvalidAvpValueException
	{
		return new PacketFilterContentImpl(action, direction, protocol, from, fromPorts, to, toPorts, options, ipOptions, negativeIpOptions, tcpOptions, negativeTcpOptions, tcpFlags, negativeTcpFlags, icmpTypes, null, null);
	}
	
	public RestrictionFilterRule getRestrictionFilterRule(String rule) throws InvalidAvpValueException
	{
		return new RestrictionFilterRuleImpl(rule, null, null);				
	}
	
	public RestrictionFilterRule getRestrictionFilterRule(DiameterIpAction action,DiameterRuleDirection direction,InternetProtocol protocol,DiameterRuleAddress from,List<DiameterRulePorts> fromPorts,DiameterRuleAddress to,List<DiameterRulePorts> toPorts,List<DiameterRuleOption> options,List<DiameterRuleIpOption> ipOptions,List<DiameterRuleIpOption> negativeIpOptions,List<DiameterRuleTcpOption> tcpOptions,List<DiameterRuleTcpOption> negativeTcpOptions,List<DiameterRuleTcpFlag> tcpFlags,List<DiameterRuleTcpFlag> negativeTcpFlags,List<DiameterRuleIcmpType> icmpTypes) throws InvalidAvpValueException
	{
		return new RestrictionFilterRuleImpl(action, direction, protocol, from, fromPorts, to, toPorts, options, ipOptions, negativeIpOptions, tcpOptions, negativeTcpOptions, tcpFlags, negativeTcpFlags, icmpTypes, null, null);
	}
	
	public RedirectServer getRedirectServer(RedirectAddressTypeEnum redirectAddressType, String redirectServerAddress) throws MissingAvpException
	{
		return new RedirectServerImpl(redirectAddressType, redirectServerAddress);
	}
	
	public TFTFilter getTFTFilter(String rule) throws InvalidAvpValueException
	{
		return new TFTFilterImpl(rule, null, null);
	}
	
	public TFTFilter getTFTFilter(DiameterIpAction action, DiameterRuleDirection direction, InternetProtocol protocol, DiameterRuleAddress from, List<DiameterRulePorts> fromPorts, DiameterRuleAddress to,
			List<DiameterRulePorts> toPorts, List<DiameterRuleOption> options, List<DiameterRuleIpOption> ipOptions, List<DiameterRuleIpOption> negativeIpOptions,
			List<DiameterRuleTcpOption> tcpOptions, List<DiameterRuleTcpOption> negativeTcpOptions, List<DiameterRuleTcpFlag> tcpFlags, List<DiameterRuleTcpFlag> negativeTcpFlags,
			List<DiameterRuleIcmpType> icmpTypes) throws InvalidAvpValueException
	{
		return new TFTFilterImpl(action, direction, protocol, from, fromPorts, to, toPorts, options, ipOptions, negativeIpOptions, tcpOptions, negativeTcpOptions, tcpFlags, negativeTcpFlags, icmpTypes, null, null);
	}
	
	public FlowDescription getFlowDescription(String rule) throws InvalidAvpValueException
	{
		return new FlowDescriptionImpl(rule, null, null);
	}
	
	public FlowDescription getFlowDescription(DiameterIpAction action, DiameterRuleDirection direction, InternetProtocol protocol, DiameterRuleAddress from, List<DiameterRulePorts> fromPorts, DiameterRuleAddress to,
			List<DiameterRulePorts> toPorts, List<DiameterRuleOption> options, List<DiameterRuleIpOption> ipOptions, List<DiameterRuleIpOption> negativeIpOptions,
			List<DiameterRuleTcpOption> tcpOptions, List<DiameterRuleTcpOption> negativeTcpOptions, List<DiameterRuleTcpFlag> tcpFlags, List<DiameterRuleTcpFlag> negativeTcpFlags,
			List<DiameterRuleIcmpType> icmpTypes) throws InvalidAvpValueException
	{
		return new FlowDescriptionImpl(action, direction, protocol, from, fromPorts, to, toPorts, options, ipOptions, negativeIpOptions, tcpOptions, negativeTcpOptions, tcpFlags, negativeTcpFlags, icmpTypes, null, null);
	}
	
	public Flows getFlows(Long mediaComponentNumber) throws MissingAvpException
	{
		return new FlowsImpl(mediaComponentNumber);
	}
	
	public RedirectInformation getRedirectInformation()
	{
		return new RedirectInformationImpl();
	}
	
	public CalleeInformation getCalleeInformation()
	{
		return new CalleeInformationImpl();
	}
	
	public EventReportIndication getEventReportIndication()
	{
		return new EventReportIndicationImpl();
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
	
	public PresenceReportingAreaInformation getPresenceReportingAreaInformation()
	{
		return new PresenceReportingAreaInformationImpl();
	}
	
	public PresenceReportingAreaNode getPresenceReportingAreaNode()
	{
		return new PresenceReportingAreaNodeImpl();
	}
	
	public SubsessionEnforcementInfo getSubsessionEnforcementInfo(Long subsessionId) throws MissingAvpException
	{
		return new SubsessionEnforcementInfoImpl(subsessionId);
	}
	
	public ChargingInformation getChargingInformation()
	{
		return new ChargingInformationImpl();
	}
	
	public SubsessionDecisionInfo getSubsessionDecisionInfo(Long subsessionId) throws MissingAvpException
	{
		return new SubsessionDecisionInfoImpl(subsessionId);
	}
	
	public CoAInformation getCoAInformation(TunnelInformation tunnelInformation,InetAddress coAIPAddress) throws MissingAvpException
	{
		return new CoAInformationImpl(tunnelInformation, coAIPAddress);
	}
	
	public TunnelInformation getTunnelInformation()
	{
		return new TunnelInformationImpl();
	}
	
	public TunnelHeaderFilter getTunnelHeaderFilter(String rule) throws InvalidAvpValueException
	{
		return new TunnelHeaderFilterImpl(rule, null, null);
	}
	
	public TunnelHeaderFilter getTunnelHeaderFilter(DiameterIpAction action, DiameterRuleDirection direction, InternetProtocol protocol, DiameterRuleAddress from, List<DiameterRulePorts> fromPorts,
			DiameterRuleAddress to, List<DiameterRulePorts> toPorts, List<DiameterRuleOption> options, List<DiameterRuleIpOption> ipOptions, List<DiameterRuleIpOption> negativeIpOptions,
			List<DiameterRuleTcpOption> tcpOptions, List<DiameterRuleTcpOption> negativeTcpOptions, List<DiameterRuleTcpFlag> tcpFlags, List<DiameterRuleTcpFlag> negativeTcpFlags,
			List<DiameterRuleIcmpType> icmpTypes) throws InvalidAvpValueException
	{
		return new TunnelHeaderFilterImpl(action, direction, protocol, from, fromPorts, to, toPorts, options, ipOptions, negativeIpOptions, tcpOptions, negativeTcpOptions, tcpFlags, negativeTcpFlags, icmpTypes, null, null);
	}		
}