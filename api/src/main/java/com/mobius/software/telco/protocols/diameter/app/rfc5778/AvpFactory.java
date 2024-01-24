package com.mobius.software.telco.protocols.diameter.app.rfc5778;
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

public interface AvpFactory extends com.mobius.software.telco.protocols.diameter.app.commons.AvpFactory
{
	public QoSResources getQoSResources(List<FilterRule> filterRule);
	
	public QoSCapability getQoSCapability(List<QoSProfileTemplate> qoSProfileTemplate);
	
	public QoSProfileTemplate getQoSProfileTemplate(Long vendorId,Long qoSProfileId);
	
	public MIP6AgentInfo getMIP6AgentInfo();
	
	public MIPMNHAMSA getMIPMNHAMSA(ByteBuf mipSessionKey, Long mipMSALifetime);
	
	public MIPHomeAgentHost getMIPHomeAgentHost(String destinationHost,String destinationRealm);
	
	public ExcessTreatment getExcessTreatment(TreatmentActionEnum treatmentAction);
	
	public QoSParameters getQoSParameters();
	
	public FilterRule getFilterRule();
	
	public TimeOfDayCondition getTimeOfDayCondition();
	
	public Classifier getClassifier(ByteBuf classifierID);
	
	public MonthOfYearMask getMonthOfYearMask();
	
	public DayOfMonthMask getDayOfMonthMask();
	
	public DayOfWeekMask getDayOfWeekMask();
	
	public FromSpec getFromSpec();
	
	public ToSpec getToSpec();
	
	public IPOption getIPOption(IPOptionTypeEnum ipOptionType); 
	
	public TCPOption getTCPOption(TCPOptionTypeEnum tcpOptionType);
	
	public TCPFlags getTCPFlags(Long tcpFlagType);
	
	public ICMPType getICMPType(ICMPTypeNumberEnum icmpTypeNumber);
	
	public ETHOption getETHOption(ETHProtoType ethProtoType);
	
	public IPAddressRange getIPAddressRange(InetAddress ipAddressStart,InetAddress ipAddressEnd);
	
	public IPAddressMask getIPAddressMask(InetAddress ipAddress,Long ipBitMaskWidth);
	
	public MACAddressMask getMACAddressMask(ByteBuf macAddress,ByteBuf macAddressMaskPattern);
	
	public EUI64AddressMask getEUI64AddressMask(ByteBuf eui64Address,ByteBuf eui64AddressMaskPattern);
	
	public PortRange getPortRange(Integer portStart,Integer portEnd);
}