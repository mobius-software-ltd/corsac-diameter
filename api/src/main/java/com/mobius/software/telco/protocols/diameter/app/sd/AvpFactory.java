package com.mobius.software.telco.protocols.diameter.app.sd;
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

import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
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
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfoExtension;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfoTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ChargingInformation;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gx.AllocationRetentionPriority;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ApplicationDetectionInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ConditionalAPNAggregateMaxBitrate;
import com.mobius.software.telco.protocols.diameter.primitives.gx.CreditManagementStatus;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventReportIndication;
import com.mobius.software.telco.protocols.diameter.primitives.gx.FixedUserLocationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.gx.FlowInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.MonitoringFlags;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PresenceReportingAreaInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PresenceReportingAreaNode;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RedirectInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UsageMonitoringInformation;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCReportTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.rx.FlowDescription;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AreaScope;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.JobTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ListOfMeasurements;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.MBSFNArea;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.MDTConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ReportingTrigger;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TraceData;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TraceDepthEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sd.ADCRuleDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.sd.ADCRuleInstall;
import com.mobius.software.telco.protocols.diameter.primitives.sd.ADCRuleRemove;
import com.mobius.software.telco.protocols.diameter.primitives.sd.ADCRuleReport;

import io.netty.buffer.ByteBuf;


public interface AvpFactory extends com.mobius.software.telco.protocols.diameter.app.commons.AvpFactory
{
	public OCSupportedFeatures getOCSupportedFeatures();
	
	public OCOLR getOCOLR(Long ocSequenceNumber, OCReportTypeEnum ocReportType) throws MissingAvpException;
	
	public SupportedFeatures getSupportedFeatures(Long vendorId, Long featureListID, Long featureList) throws MissingAvpException;
	
	public Load getLoad();
	
	public UserEquipmentInfoExtension getUserEquipmentInfoExtension(ByteBuf imeiSV,ByteBuf mac,ByteBuf eui64,ByteBuf modifiedEUI64,ByteBuf imei) throws MissingAvpException, AvpOccursTooManyTimesException;
	
	public UserEquipmentInfo getUserEquipmentInfo(UserEquipmentInfoTypeEnum userEquipmentInfoType,ByteBuf userEquipmentInfoValue) throws MissingAvpException;
	
	public SubscriptionId getSubscriptionId(SubscriptionIdTypeEnum subscriptionIdType,String subscriptionIdData) throws MissingAvpException;
	
	public CreditManagementStatus getCreditManagementStatus();
	
	public ADCRuleReport getADCRuleReport();
	
	public ADCRuleRemove getADCRuleRemove();
	
	public ADCRuleInstall getADCRuleInstall();
	
	public ADCRuleDefinition getADCRuleDefinition(ByteBuf adcRuleName) throws MissingAvpException;
	
	public FinalUnitIndication getFinalUnitIndication(FinalUnitActionEnum finalUnitAction) throws MissingAvpException;
	
	public ApplicationDetectionInformation getApplicationDetectionInformation(ByteBuf tdfApplicationIdentifier) throws MissingAvpException;
	
	public FlowInformation getFlowInformation();
	
	public EventReportIndication getEventReportIndication();
	
	public TraceData getTraceData(ByteBuf traceReference,TraceDepthEnum traceDepth,ByteBuf traceNETypeList,ByteBuf traceEventList,InetAddress traceCollectionEntity) throws MissingAvpException;
	
	public MDTConfiguration getMDTConfiguration(JobTypeEnum jobType) throws MissingAvpException;
	
	public AreaScope getAreaScope();
	
	public ListOfMeasurements getListOfMeasurements();
	
	public ReportingTrigger getReportingTrigger();
	
	public MBSFNArea getMBSFNArea();
	
	public UserCSGInformation getUserCSGInformation(Long csgId,CSGAccessModeEnum csgAccessMode) throws MissingAvpException;	
	
	public PresenceReportingAreaInformation getPresenceReportingAreaInformation();
	
	public PresenceReportingAreaNode getPresenceReportingAreaNode();
	
	public UsageMonitoringInformation getUsageMonitoringInformation();
	
	public GrantedServiceUnit getGrantedServiceUnit();
	
	public UsedServiceUnit getUsedServiceUnit();
	
	public CCMoney getCCMoney(UnitValue unitValue) throws MissingAvpException;
	
	public UnitValue getUnitValue(Long valueDigits) throws MissingAvpException;
	
	public MonitoringFlags getMonitoringFlags();
	
	public QoSInformation getQoSInformation();
	
	public AllocationRetentionPriority getAllocationRetentionPriority(Long priorityLevel) throws MissingAvpException;
	
	public ConditionalAPNAggregateMaxBitrate getConditionalAPNAggregateMaxBitrate();
	
	public RedirectInformation getRedirectInformation();
	
	public FixedUserLocationInfo getFixedUserLocationInfo();
	
	public ChargingInformation getChargingInformation();
	
	public FlowDescription getFlowDescription(String rule) throws InvalidAvpValueException;
	
	public FlowDescription getFlowDescription(DiameterIpAction action, DiameterRuleDirection direction, InternetProtocol protocol, DiameterRuleAddress from, List<DiameterRulePorts> fromPorts, DiameterRuleAddress to,
			List<DiameterRulePorts> toPorts, List<DiameterRuleOption> options, List<DiameterRuleIpOption> ipOptions, List<DiameterRuleIpOption> negativeIpOptions,
			List<DiameterRuleTcpOption> tcpOptions, List<DiameterRuleTcpOption> negativeTcpOptions, List<DiameterRuleTcpFlag> tcpFlags, List<DiameterRuleTcpFlag> negativeTcpFlags,
			List<DiameterRuleIcmpType> icmpTypes) throws InvalidAvpValueException;
	
	public RestrictionFilterRule getRestrictionFilterRule(String rule) throws InvalidAvpValueException;
	
	public RestrictionFilterRule getRestrictionFilterRule(DiameterIpAction action,DiameterRuleDirection direction,InternetProtocol protocol,DiameterRuleAddress from,List<DiameterRulePorts> fromPorts,DiameterRuleAddress to,List<DiameterRulePorts> toPorts,List<DiameterRuleOption> options,List<DiameterRuleIpOption> ipOptions,List<DiameterRuleIpOption> negativeIpOptions,List<DiameterRuleTcpOption> tcpOptions,List<DiameterRuleTcpOption> negativeTcpOptions,List<DiameterRuleTcpFlag> tcpFlags,List<DiameterRuleTcpFlag> negativeTcpFlags,List<DiameterRuleIcmpType> icmpTypes) throws InvalidAvpValueException;
	
	public RedirectServer getRedirectServer(RedirectAddressTypeEnum redirectAddressType, String redirectServerAddress) throws MissingAvpException;			
}