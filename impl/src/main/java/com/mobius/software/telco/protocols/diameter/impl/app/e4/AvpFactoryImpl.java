package com.mobius.software.telco.protocols.diameter.impl.app.e4;
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

import com.mobius.software.telco.protocols.diameter.app.e4.AvpFactory;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.RouteRecordImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.e4.AccessNetworkTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.e4.GloballyUniqueAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.e4.InitialGateSettingDescriptionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.e4.QoSProfileDescriptionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.NASFilterRuleImpl;
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
import com.mobius.software.telco.protocols.diameter.primitives.common.RouteRecord;
import com.mobius.software.telco.protocols.diameter.primitives.e4.AccessNetworkType;
import com.mobius.software.telco.protocols.diameter.primitives.e4.GloballyUniqueAddress;
import com.mobius.software.telco.protocols.diameter.primitives.e4.InitialGateSettingDescription;
import com.mobius.software.telco.protocols.diameter.primitives.e4.QoSProfileDescription;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASFilterRule;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASPortTypeEnum;

public class AvpFactoryImpl extends com.mobius.software.telco.protocols.diameter.impl.app.commons.AvpFactoryImpl implements AvpFactory
{
	public GloballyUniqueAddress getGloballyUniqueAddress()
	{
		return new GloballyUniqueAddressImpl();
	}
	
	public QoSProfileDescription getQoSProfileDescription()
	{
		return new QoSProfileDescriptionImpl();
	}
	
	public InitialGateSettingDescription getInitialGateSettingDescription()
	{
		return new InitialGateSettingDescriptionImpl();
	}
	
	public AccessNetworkType getAccessNetworkType(NASPortTypeEnum nasPortType)
	{
		return new AccessNetworkTypeImpl(nasPortType);
	}
	
	public RouteRecord getRouteRecord(String uri)
	{
		return new RouteRecordImpl(uri, null, null);
	}
	
	public NASFilterRule getNASFilterRule(String rule) throws ParseException
	{
		return new NASFilterRuleImpl(rule, null, null);
	}
	
	public NASFilterRule getNASFilterRule(DiameterIpAction action,DiameterRuleDirection direction,InternetProtocol protocol,DiameterRuleAddress from,List<DiameterRulePorts> fromPorts,DiameterRuleAddress to,List<DiameterRulePorts> toPorts,List<DiameterRuleOption> options,List<DiameterRuleIpOption> ipOptions,List<DiameterRuleIpOption> negativeIpOptions,List<DiameterRuleTcpOption> tcpOptions,List<DiameterRuleTcpOption> negativeTcpOptions,List<DiameterRuleTcpFlag> tcpFlags,List<DiameterRuleTcpFlag> negativeTcpFlags,List<DiameterRuleIcmpType> icmpTypes) throws ParseException
	{
		return new NASFilterRuleImpl(action, direction, protocol, from, fromPorts, to, toPorts, options, ipOptions, negativeIpOptions, tcpOptions, negativeTcpOptions, tcpFlags, negativeTcpFlags, icmpTypes, null, null);
	}
}