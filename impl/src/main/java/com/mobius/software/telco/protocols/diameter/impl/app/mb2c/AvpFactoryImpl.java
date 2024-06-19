package com.mobius.software.telco.protocols.diameter.impl.app.mb2c;
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

import com.mobius.software.telco.protocols.diameter.app.mb2c.AvpFactory;
import com.mobius.software.telco.protocols.diameter.exceptions.InvalidAvpValueException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.SupportedFeaturesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.AllocationRetentionPriorityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.ConditionalAPNAggregateMaxBitrateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.QoSInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.mb2c.FECResultImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.mb2c.LocalM1InformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.mb2c.LocalMB2UInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.mb2c.MBMSBearerEventImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.mb2c.MBMSBearerEventNotificationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.mb2c.MBMSBearerRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.mb2c.MBMSBearerResponseImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.mb2c.MBMSBearerResultImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.mb2c.ROHCRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.mb2c.TMGIAllocationRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.mb2c.TMGIAllocationResponseImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.mb2c.TMGIAllocationResultImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.mb2c.TMGIDeallocationRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.mb2c.TMGIDeallocationResponseImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.mb2c.TMGIDeallocationResultImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.mb2c.TMGIExpiryImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.mb2c.UserplaneProtocolResultImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc8583.LoadImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.FlowDescriptionImpl;
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
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSStartStopIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.AllocationRetentionPriority;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ConditionalAPNAggregateMaxBitrate;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.FECResult;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.LocalM1Information;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.LocalMB2UInformation;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.MBMSBearerEvent;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.MBMSBearerEventNotification;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.MBMSBearerRequest;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.MBMSBearerResponse;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.MBMSBearerResult;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.ROHCRequest;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.TMGIAllocationRequest;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.TMGIAllocationResponse;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.TMGIAllocationResult;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.TMGIDeallocationRequest;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.TMGIDeallocationResponse;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.TMGIDeallocationResult;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.TMGIExpiry;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.UserplaneProtocolResult;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.rx.FlowDescription;

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
	
	public SupportedFeatures getSupportedFeatures(Long vendorId, Long featureListID, Long featureList) throws MissingAvpException
	{
		return new SupportedFeaturesImpl(vendorId, featureListID, featureList);
	}
	
	public TMGIExpiry getTMGIExpiry(List<ByteBuf> tmgi) throws MissingAvpException
	{
		return new TMGIExpiryImpl(tmgi);
	}
	
	public MBMSBearerEvent getMBMSBearerEvent()
	{
		return new MBMSBearerEventImpl();
	}
	
	public MBMSBearerEventNotification getMBMSBearerEventNotification(ByteBuf tmgi,ByteBuf mbmsFlowIdentifier,MBMSBearerEvent mbmsBearerEvent) throws MissingAvpException
	{
		return new MBMSBearerEventNotificationImpl(tmgi, mbmsFlowIdentifier, mbmsBearerEvent);
	}
	
	public MBMSBearerRequest getMBMSBearerRequest(MBMSStartStopIndicationEnum mbmsStartStopIndication) throws MissingAvpException
	{
		return new MBMSBearerRequestImpl(mbmsStartStopIndication);
	}
	
	public MBMSBearerResponse getMBMSBearerResponse()
	{
		return new MBMSBearerResponseImpl();
	}
	
	public MBMSBearerResult getMBMSBearerResult()
	{
		return new MBMSBearerResultImpl();
	}
	
	public TMGIAllocationRequest getTMGIAllocationRequest(Long tmgiNumber) throws MissingAvpException
	{
		return new TMGIAllocationRequestImpl(tmgiNumber);
	}
	
	public TMGIAllocationResponse getTMGIAllocationResponse()
	{
		return new TMGIAllocationResponseImpl();
	}
	
	public TMGIDeallocationRequest getTMGIDeallocationRequest()
	{
		return new TMGIDeallocationRequestImpl();
	}
	
	public TMGIDeallocationResponse getTMGIDeallocationResponse(List<ByteBuf> tmgi) throws MissingAvpException
	{
		return new TMGIDeallocationResponseImpl(tmgi);
	}
	
	public TMGIAllocationResult getTMGIAllocationResult()
	{
		return new TMGIAllocationResultImpl();
	}
	
	public TMGIDeallocationResult getTMGIDeallocationResult()
	{
		return new TMGIDeallocationResultImpl();
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
	
	public UserplaneProtocolResult getUserplaneProtocolResult()
	{
		return new UserplaneProtocolResultImpl();
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
	
	public ROHCRequest getROHCRequest(List<FlowDescription> flowDescription,Long rohcProfile) throws MissingAvpException
	{
		return new ROHCRequestImpl(flowDescription, rohcProfile);
	}
	
	public FECResult getFECResult()
	{
		return new FECResultImpl();
	}
	
	public LocalMB2UInformation getLocalMB2UInformation()
	{
		return new LocalMB2UInformationImpl();
	}
	
	public LocalM1Information getLocalM1Information()
	{
		return new LocalM1InformationImpl();
	}
}