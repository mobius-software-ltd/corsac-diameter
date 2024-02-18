package com.mobius.software.telco.protocols.diameter.app.mb2c;
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


public interface AvpFactory extends com.mobius.software.telco.protocols.diameter.app.commons.AvpFactory
{
	public Load getLoad();
	
	public SupportedFeatures getSupportedFeatures(Long vendorId, Long featureListID, Long featureList) throws MissingAvpException;
	
	public TMGIExpiry getTMGIExpiry(List<ByteBuf> tmgi) throws MissingAvpException;
	
	public MBMSBearerEvent getMBMSBearerEvent();
	
	public MBMSBearerEventNotification getMBMSBearerEventNotification(ByteBuf tmgi,ByteBuf mbmsFlowIdentifier,MBMSBearerEvent mbmsBearerEvent) throws MissingAvpException;
	
	public MBMSBearerRequest getMBMSBearerRequest(MBMSStartStopIndicationEnum mbmsStartStopIndication) throws MissingAvpException;
	
	public MBMSBearerResponse getMBMSBearerResponse();
	
	public MBMSBearerResult getMBMSBearerResult();
	
	public TMGIAllocationRequest getTMGIAllocationRequest(Long tmgiNumber) throws MissingAvpException;
	
	public TMGIAllocationResponse getTMGIAllocationResponse();
	
	public TMGIDeallocationRequest getTMGIDeallocationRequest();
	
	public TMGIDeallocationResponse getTMGIDeallocationResponse(List<ByteBuf> tmgi) throws MissingAvpException;
	
	public TMGIAllocationResult getTMGIAllocationResult();
	
	public TMGIDeallocationResult getTMGIDeallocationResult();
	
	public QoSInformation getQoSInformation();
	
	public AllocationRetentionPriority getAllocationRetentionPriority(Long priorityLevel) throws MissingAvpException;
	
	public ConditionalAPNAggregateMaxBitrate getConditionalAPNAggregateMaxBitrate();
	
	public UserplaneProtocolResult getUserplaneProtocolResult();
	
	public FlowDescription getFlowDescription(String rule) throws InvalidAvpValueException;
	
	public FlowDescription getFlowDescription(DiameterIpAction action, DiameterRuleDirection direction, InternetProtocol protocol, DiameterRuleAddress from, List<DiameterRulePorts> fromPorts, DiameterRuleAddress to,
			List<DiameterRulePorts> toPorts, List<DiameterRuleOption> options, List<DiameterRuleIpOption> ipOptions, List<DiameterRuleIpOption> negativeIpOptions,
			List<DiameterRuleTcpOption> tcpOptions, List<DiameterRuleTcpOption> negativeTcpOptions, List<DiameterRuleTcpFlag> tcpFlags, List<DiameterRuleTcpFlag> negativeTcpFlags,
			List<DiameterRuleIcmpType> icmpTypes) throws InvalidAvpValueException;
	
	public ROHCRequest getROHCRequest(List<FlowDescription> flowDescription,Long rohcProfile) throws MissingAvpException;
	
	public FECResult getFECResult();
	
	public LocalMB2UInformation getLocalMB2UInformation();
	
	public LocalM1Information getLocalM1Information();
}