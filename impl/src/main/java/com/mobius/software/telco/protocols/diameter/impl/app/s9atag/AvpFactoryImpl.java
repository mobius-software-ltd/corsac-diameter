package com.mobius.software.telco.protocols.diameter.impl.app.s9atag;
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

import java.text.ParseException;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.app.s9atag.AvpFactory;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.OCOLRImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.FinalUnitIndicationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.RedirectServerImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.RestrictionFilterRuleImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.SubscriptionIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.SupportedFeaturesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.AllocationRetentionPriorityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.ChargingRuleDefinitionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.ChargingRuleInstallImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.ChargingRuleRemoveImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.ChargingRuleReportImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.ConditionalAPNAggregateMaxBitrateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.MonitoringFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.QoSInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.TDFInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7683.OCSupportedFeaturesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc8583.LoadImpl;
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
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.FinalUnitActionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.FinalUnitIndication;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RedirectAddressTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RedirectServer;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RestrictionFilterRule;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionIdTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gx.AllocationRetentionPriority;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleInstall;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleRemove;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleReport;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ConditionalAPNAggregateMaxBitrate;
import com.mobius.software.telco.protocols.diameter.primitives.gx.MonitoringFlags;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TDFInformation;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCReportTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;

import io.netty.buffer.ByteBuf;

public class AvpFactoryImpl extends com.mobius.software.telco.protocols.diameter.impl.app.commons.AvpFactoryImpl implements AvpFactory
{
	public SubscriptionId getSubscriptionId(SubscriptionIdTypeEnum subscriptionIdType,String subscriptionIdData)
	{
		return new SubscriptionIdImpl(subscriptionIdType, subscriptionIdData);
	}
	
	public OCOLR getOCOLR(Long ocSequenceNumber, OCReportTypeEnum ocReportType)
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
	
	public SupportedFeatures getSupportedFeatures(Long vendorId, Long featureListID, Long featureList)
	{
		return new SupportedFeaturesImpl(vendorId, featureListID, featureList);
	}
	
	public QoSInformation getQoSInformation()
	{
		return new QoSInformationImpl();
	}
	
	public AllocationRetentionPriority getAllocationRetentionPriority(Long priorityLevel)
	{
		return new AllocationRetentionPriorityImpl(priorityLevel);
	}
	
	public ConditionalAPNAggregateMaxBitrate getConditionalAPNAggregateMaxBitrate()
	{
		return new ConditionalAPNAggregateMaxBitrateImpl();
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
	
	public ChargingRuleDefinition getChargingRuleDefinition(ByteBuf chargingRuleName)
	{
		return new ChargingRuleDefinitionImpl(chargingRuleName);
	}
	
	public MonitoringFlags getMonitoringFlags()
	{
		return new MonitoringFlagsImpl();
	}
	
	public FinalUnitIndication getFinalUnitIndication(FinalUnitActionEnum finalUnitAction, List<RestrictionFilterRule> restrictionFilterRule, List<String> filterId, RedirectServer redirectServer)
	{
		return new FinalUnitIndicationImpl(finalUnitAction, restrictionFilterRule, filterId, redirectServer);
	}
	
	public RestrictionFilterRule getRestrictionFilterRule(String rule) throws ParseException
	{
		return new RestrictionFilterRuleImpl(rule, null, null);
	}
	
	public RestrictionFilterRule getRestrictionFilterRule(DiameterIpAction action,DiameterRuleDirection direction,InternetProtocol protocol,DiameterRuleAddress from,List<DiameterRulePorts> fromPorts,DiameterRuleAddress to,List<DiameterRulePorts> toPorts,List<DiameterRuleOption> options,List<DiameterRuleIpOption> ipOptions,List<DiameterRuleIpOption> negativeIpOptions,List<DiameterRuleTcpOption> tcpOptions,List<DiameterRuleTcpOption> negativeTcpOptions,List<DiameterRuleTcpFlag> tcpFlags,List<DiameterRuleTcpFlag> negativeTcpFlags,List<DiameterRuleIcmpType> icmpTypes) throws ParseException
	{
		return new RestrictionFilterRuleImpl(action, direction, protocol, from, fromPorts, to, toPorts, options, ipOptions, negativeIpOptions, tcpOptions, negativeTcpOptions, tcpFlags, negativeTcpFlags, icmpTypes, null, null);
	}
	
	public RedirectServer getRedirectServer(RedirectAddressTypeEnum redirectAddressType, String redirectServerAddress)
	{
		return new RedirectServerImpl(redirectAddressType, redirectServerAddress);
	}
	
	public TDFInformation getTDFInformation()
	{
		return new TDFInformationImpl();
	}
}