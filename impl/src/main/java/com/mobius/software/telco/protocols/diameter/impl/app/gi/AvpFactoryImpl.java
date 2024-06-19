package com.mobius.software.telco.protocols.diameter.impl.app.gi;
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

import com.mobius.software.telco.protocols.diameter.app.gi.AvpFactory;
import com.mobius.software.telco.protocols.diameter.exceptions.InvalidAvpValueException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.CHAPAuthImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.DiameterQosFilterRuleImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.NASFilterRuleImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.TunnelingImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterIpAction;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterQosAction;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleAddress;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleDirection;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleIcmpType;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleIpOption;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleOption;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRulePorts;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleTcpFlag;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleTcpOption;
import com.mobius.software.telco.protocols.diameter.primitives.InternetProtocol;
import com.mobius.software.telco.protocols.diameter.primitives.nas.CHAPAlgorithmEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.CHAPAuth;
import com.mobius.software.telco.protocols.diameter.primitives.nas.DiameterQosFilterRule;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASFilterRule;
import com.mobius.software.telco.protocols.diameter.primitives.nas.TunnelMediumTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.TunnelTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.Tunneling;

import io.netty.buffer.ByteBuf;
/**
*
* @author yulian oifa
*
*/
public class AvpFactoryImpl extends com.mobius.software.telco.protocols.diameter.impl.app.commons.AvpFactoryImpl implements AvpFactory
{
	public CHAPAuth getCHAPAuth(CHAPAlgorithmEnum chapAlgorithm, ByteBuf chapIdent) throws MissingAvpException
	{
		return new CHAPAuthImpl(chapAlgorithm, chapIdent);
	}
	
	public Tunneling getTunneling(TunnelTypeEnum tunnelType, TunnelMediumTypeEnum tunnelMediumType,String tunnelClientEndpoint,String tunnelServerEndpoint) throws MissingAvpException
	{
		return new TunnelingImpl(tunnelType, tunnelMediumType, tunnelClientEndpoint, tunnelServerEndpoint);
	}
	
	public DiameterQosFilterRule getDiameterQosFilterRule(String rule) throws InvalidAvpValueException
	{
		return new DiameterQosFilterRuleImpl(rule, null, null);
	}
	
	public DiameterQosFilterRule getDiameterQosFilterRule(DiameterQosAction action,DiameterRuleDirection direction,InternetProtocol protocol,DiameterRuleAddress from,List<DiameterRulePorts> fromPorts,DiameterRuleAddress to,List<DiameterRulePorts> toPorts,String dscpColor,Long meteringRate,String colorUnder,String colorOver) throws InvalidAvpValueException
	{
		return new DiameterQosFilterRuleImpl(action, direction, protocol, from, fromPorts, to, toPorts, dscpColor, meteringRate, colorUnder, colorOver, null, null);
	}
	
	public NASFilterRule getNASFilterRule(String rule) throws InvalidAvpValueException
	{
		return new NASFilterRuleImpl(rule, null, null);
	}
	
	public NASFilterRule getNASFilterRule(DiameterIpAction action,DiameterRuleDirection direction,InternetProtocol protocol,DiameterRuleAddress from,List<DiameterRulePorts> fromPorts,DiameterRuleAddress to,List<DiameterRulePorts> toPorts,List<DiameterRuleOption> options,List<DiameterRuleIpOption> ipOptions,List<DiameterRuleIpOption> negativeIpOptions,List<DiameterRuleTcpOption> tcpOptions,List<DiameterRuleTcpOption> negativeTcpOptions,List<DiameterRuleTcpFlag> tcpFlags,List<DiameterRuleTcpFlag> negativeTcpFlags,List<DiameterRuleIcmpType> icmpTypes) throws InvalidAvpValueException
	{
		return new NASFilterRuleImpl(action, direction, protocol, from, fromPorts, to, toPorts, options, ipOptions, negativeIpOptions, tcpOptions, negativeTcpOptions, tcpFlags, negativeTcpFlags, icmpTypes, null, null);
	}
}