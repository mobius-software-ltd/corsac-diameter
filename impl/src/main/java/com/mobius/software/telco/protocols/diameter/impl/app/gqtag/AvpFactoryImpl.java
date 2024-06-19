package com.mobius.software.telco.protocols.diameter.impl.app.gqtag;
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

import java.net.Inet4Address;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.app.gqtag.AvpFactory;
import com.mobius.software.telco.protocols.diameter.exceptions.InvalidAvpValueException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.e4.GloballyUniqueAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gq.BindingInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gq.BindingInputListImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gq.BindingOutputListImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gq.FlowGroupingImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gq.FlowsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gq.MediaComponentDescriptionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gq.MediaSubComponentImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gq.V4TransportAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gq.V6TransportAddressImpl;
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
import com.mobius.software.telco.protocols.diameter.primitives.e4.GloballyUniqueAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gq.BindingInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gq.BindingInputList;
import com.mobius.software.telco.protocols.diameter.primitives.gq.BindingOutputList;
import com.mobius.software.telco.protocols.diameter.primitives.gq.FlowGrouping;
import com.mobius.software.telco.protocols.diameter.primitives.gq.Flows;
import com.mobius.software.telco.protocols.diameter.primitives.gq.MediaComponentDescription;
import com.mobius.software.telco.protocols.diameter.primitives.gq.MediaSubComponent;
import com.mobius.software.telco.protocols.diameter.primitives.gq.V4TransportAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gq.V6TransportAddress;
import com.mobius.software.telco.protocols.diameter.primitives.rx.FlowDescription;

import io.netty.buffer.ByteBuf;
/**
*
* @author yulian oifa
*
*/
public class AvpFactoryImpl extends com.mobius.software.telco.protocols.diameter.impl.app.commons.AvpFactoryImpl implements AvpFactory
{
	public Flows getFlows(Long mediaComponentNumber) throws MissingAvpException
	{
		return new FlowsImpl(mediaComponentNumber);
	}
	
	public MediaComponentDescription getMediaComponentDescription(Long mediaComponentNumber) throws MissingAvpException
	{
		return new MediaComponentDescriptionImpl(mediaComponentNumber);
	}
	
	public MediaSubComponent getMediaSubComponent(Long flowNumber) throws MissingAvpException
	{
		return new MediaSubComponentImpl(flowNumber);
	}
	
	public FlowGrouping getFlowGrouping()
	{
		return new FlowGroupingImpl();
	}
	
	public BindingInformation getBindingInformation(BindingInputList bindingInputList) throws MissingAvpException
	{
		return new BindingInformationImpl(bindingInputList);
	}
	
	public BindingInputList getBindingInputList()
	{
		return new BindingInputListImpl();
	}
	
	public BindingOutputList getBindingOutputList()
	{
		return new BindingOutputListImpl();
	}
	
	public V6TransportAddress getV6TransportAddress(ByteBuf framedIPv6Prefix,Long portNumber) throws MissingAvpException
	{
		return new V6TransportAddressImpl(framedIPv6Prefix, portNumber);
	}
	
	public V4TransportAddress getV4TransportAddress(Inet4Address framedIPAddress,Long portNumber) throws MissingAvpException
	{
		return new V4TransportAddressImpl(framedIPAddress, portNumber);
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
	
	public GloballyUniqueAddress getGloballyUniqueAddress()
	{
		return new GloballyUniqueAddressImpl();
	}
}