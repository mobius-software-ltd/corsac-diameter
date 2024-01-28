package com.mobius.software.telco.protocols.diameter.impl.app.rfc5778;
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

import com.mobius.software.telco.protocols.diameter.app.rfc5778.AvpFactory;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPHomeAgentHostImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5447.MIP6AgentInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5777.ClassifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5777.DayOfMonthMaskImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5777.DayOfWeekMaskImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5777.ETHOptionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5777.EUI64AddressMaskImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5777.ExcessTreatmentImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5777.FilterRuleImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5777.FromSpecImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5777.ICMPTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5777.IPAddressMaskImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5777.IPAddressRangeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5777.IPOptionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5777.MACAddressMaskImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5777.MonthOfYearMaskImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5777.PortRangeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5777.QoSCapabilityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5777.QoSParametersImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5777.QoSProfileTemplateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5777.QoSResourcesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5777.TCPFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5777.TCPOptionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5777.TimeOfDayConditionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5777.ToSpecImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5778.MIPMNHAMSAImpl;
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
import com.mobius.software.telco.protocols.diameter.primitives.rfc5778.MIPMNHAMSA;

import io.netty.buffer.ByteBuf;

public class AvpFactoryImpl extends com.mobius.software.telco.protocols.diameter.impl.app.commons.AvpFactoryImpl implements AvpFactory
{
	public QoSResources getQoSResources(List<FilterRule> filterRule)
	{
		return new QoSResourcesImpl(filterRule);
	}
	
	public QoSCapability getQoSCapability(List<QoSProfileTemplate> qoSProfileTemplate)
	{
		return new QoSCapabilityImpl(qoSProfileTemplate);
	}
	
	public QoSProfileTemplate getQoSProfileTemplate(Long vendorId,Long qoSProfileId)
	{
		return new QoSProfileTemplateImpl(vendorId, qoSProfileId);
	}
	
	public MIP6AgentInfo getMIP6AgentInfo()
	{
		return new MIP6AgentInfoImpl();
	}
	
	public MIPMNHAMSA getMIPMNHAMSA(ByteBuf mipSessionKey, Long mipMSALifetime)
	{
		return new MIPMNHAMSAImpl(mipSessionKey, mipMSALifetime);
	}
	
	public MIPHomeAgentHost getMIPHomeAgentHost(String destinationHost,String destinationRealm)
	{
		return new MIPHomeAgentHostImpl(destinationHost, destinationRealm);
	}
	
	public ExcessTreatment getExcessTreatment(TreatmentActionEnum treatmentAction)
	{
		return new ExcessTreatmentImpl(treatmentAction);
	}
	
	public QoSParameters getQoSParameters()
	{
		return new QoSParametersImpl();
	}
	
	public FilterRule getFilterRule()
	{
		return new FilterRuleImpl();
	}
	
	public TimeOfDayCondition getTimeOfDayCondition()
	{
		return new TimeOfDayConditionImpl();
	}
	
	public Classifier getClassifier(ByteBuf classifierID)
	{
		return new ClassifierImpl(classifierID);
	}
	
	public MonthOfYearMask getMonthOfYearMask()
	{
		return new MonthOfYearMaskImpl();
	}
	
	public DayOfMonthMask getDayOfMonthMask()
	{
		return new DayOfMonthMaskImpl();
	}
	
	public DayOfWeekMask getDayOfWeekMask()
	{
		return new DayOfWeekMaskImpl();
	}
	
	public FromSpec getFromSpec()
	{
		return new FromSpecImpl();
	}
	
	public ToSpec getToSpec()
	{
		return new ToSpecImpl();
	}
	
	public IPOption getIPOption(IPOptionTypeEnum ipOptionType)
	{
		return new IPOptionImpl(ipOptionType);
	} 
	
	public TCPOption getTCPOption(TCPOptionTypeEnum tcpOptionType)
	{
		return new TCPOptionImpl(tcpOptionType);
	}
	
	public TCPFlags getTCPFlags(Long tcpFlagType)
	{
		return new TCPFlagsImpl(tcpFlagType);
	}
	
	public ICMPType getICMPType(ICMPTypeNumberEnum icmpTypeNumber)
	{
		return new ICMPTypeImpl(icmpTypeNumber);
	}
	
	public ETHOption getETHOption(ETHProtoType ethProtoType)
	{
		return new ETHOptionImpl(ethProtoType);
	}
	
	public IPAddressRange getIPAddressRange(InetAddress ipAddressStart,InetAddress ipAddressEnd)
	{
		return new IPAddressRangeImpl(ipAddressStart, ipAddressEnd);
	}
	
	public IPAddressMask getIPAddressMask(InetAddress ipAddress,Long ipBitMaskWidth)
	{
		return new IPAddressMaskImpl(ipAddress, ipBitMaskWidth);
	}
	
	public MACAddressMask getMACAddressMask(ByteBuf macAddress,ByteBuf macAddressMaskPattern)
	{
		return new MACAddressMaskImpl(macAddress, macAddressMaskPattern);
	}
	
	public EUI64AddressMask getEUI64AddressMask(ByteBuf eui64Address,ByteBuf eui64AddressMaskPattern)
	{
		return new EUI64AddressMaskImpl(eui64Address, eui64AddressMaskPattern);
	}
	
	public PortRange getPortRange(Integer portStart,Integer portEnd)
	{
		return new PortRangeImpl(portStart, portEnd);
	}
}