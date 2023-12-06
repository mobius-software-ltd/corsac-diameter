package com.mobius.software.telco.protocols.diameter.impl.primitives.gxx;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPGGSNAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPGGSNIPv6AddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.ANGWAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RuleActivationTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RuleDeactivationTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.UDPSourcePortImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.AccessNetworkChargingIdentifierValueImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPGGSNAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPGGSNIPv6Address;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ANGWAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RuleActivationTime;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RuleDeactivationTime;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TunnelInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UDPSourcePort;
import com.mobius.software.telco.protocols.diameter.primitives.gxx.QoSRuleBaseName;
import com.mobius.software.telco.protocols.diameter.primitives.gxx.QoSRuleDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.gxx.QoSRuleInstall;
import com.mobius.software.telco.protocols.diameter.primitives.gxx.QoSRuleName;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AccessNetworkChargingIdentifierValue;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1051L, vendorId = KnownVendorIDs.TGPP_ID)
public class QoSRuleInstallImpl extends DiameterGroupedAvpImpl implements QoSRuleInstall
{
	private List<QoSRuleDefinition> qosRuleDefinition;
	private List<QoSRuleName> qosRuleName;
	private List<QoSRuleBaseName> qosRuleBaseName;
	private TunnelInformation tunnelInformation;
	private AccessNetworkChargingIdentifierValue accessNetworkChargingIdentifierValue;
	private RuleActivationTime ruleActivationTime;
	private RuleDeactivationTime ruleDeactivationTime;
	private TGPPGGSNAddress tgppGGSNAddress;
    private TGPPGGSNIPv6Address tgppGGSNIPv6Address;
    private List<ANGWAddress> anGWAddress;
    private UDPSourcePort udpSourcePort;
		
	public QoSRuleInstallImpl()
	{
		
	}
	
	public List<QoSRuleDefinition> getQoSRuleDefinition()
	{
		return qosRuleDefinition;
	}
	
	public void setQoSRuleDefinition(List<QoSRuleDefinition> value)
	{
		this.qosRuleDefinition = value;
	}	
	
	public List<ByteBuf> getQoSRuleName()
	{
		if(qosRuleName==null || qosRuleName.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(QoSRuleName curr:qosRuleName)
			result.add(curr.getValue());
		
		return result;
	}
	
	public void setQoSRuleName(List<ByteBuf> value)
	{
		if(value==null || value.size()==0)
			this.qosRuleName = null;
		else
		{
			this.qosRuleName = new ArrayList<QoSRuleName>();
			for(ByteBuf curr:value)
				this.qosRuleName.add(new QoSRuleNameImpl(curr, null, null));			
		}
	}
	
	public List<String> getQoSRuleBaseName()
	{
		if(qosRuleBaseName==null || qosRuleBaseName.size()==0)
			return null;
		
		List<String> result = new ArrayList<String>();
		for(QoSRuleBaseName curr:qosRuleBaseName)
			result.add(curr.getString());
		
		return result;
	}
	
	public void setQoSRuleBaseName(List<String> value)
	{
		if(value==null || value.size()==0)
			this.qosRuleBaseName = null;
		else
		{
			this.qosRuleBaseName = new ArrayList<QoSRuleBaseName>();
			for(String curr:value)
				this.qosRuleBaseName.add(new QoSRuleBaseNameImpl(curr, null, null));			
		}
	}
	
	public TunnelInformation getTunnelInformation()
	{
		return tunnelInformation;
	}
	
	public void setTunnelInformation(TunnelInformation value)
	{
		this.tunnelInformation = value;
	}
	
	public ByteBuf getAccessNetworkChargingIdentifierValue()
	{
		if(accessNetworkChargingIdentifierValue==null)
			return null;
		
		return accessNetworkChargingIdentifierValue.getValue();
	}
	
	public void setAccessNetworkChargingIdentifierValue(ByteBuf value)
	{
		if(value==null)
			this.accessNetworkChargingIdentifierValue = null;
		else
			this.accessNetworkChargingIdentifierValue = new AccessNetworkChargingIdentifierValueImpl(value, null, null);			
	}
	
	public Date getRuleActivationTime()
	{
		if(ruleActivationTime==null)
			return null;
		
		return ruleActivationTime.getDateTime();
	}
	
	public void setRuleActivationTime(Date value)
	{
		if(value==null)
			this.ruleActivationTime = null;
		else
			this.ruleActivationTime = new RuleActivationTimeImpl(value, null, null);			
	}
	
	public Date getRuleDeactivationTime()
	{
		if(ruleDeactivationTime==null)
			return null;
		
		return ruleDeactivationTime.getDateTime();
	}
	
	public void setRuleDeactivationTime(Date value)
	{
		if(value==null)
			this.ruleDeactivationTime = null;
		else
			this.ruleDeactivationTime = new RuleDeactivationTimeImpl(value, null, null);			
	}
	
	@Override
	public ByteBuf getTGPPGGSNAddress() 
	{
		if(tgppGGSNAddress==null)
			return null;
		
		return tgppGGSNAddress.getValue();
	}

	@Override
	public void setTGPPGGSNAddress(ByteBuf value) 
	{
		if(value == null)
			this.tgppGGSNAddress = null;
		else
			this.tgppGGSNAddress = new TGPPGGSNAddressImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getTGPPGGSNIPv6Address() 
	{
		if(tgppGGSNIPv6Address==null)
			return null;
		
		return tgppGGSNIPv6Address.getValue();
	}

	@Override
	public void setTGPPGGSNIPv6Address(ByteBuf value) 
	{
		if(value == null)
			this.tgppGGSNIPv6Address = null;
		else
			this.tgppGGSNIPv6Address = new TGPPGGSNIPv6AddressImpl(value, null, null);
	}
	
	@Override
	public List<InetAddress> getANGWAddress()
	{
		if(anGWAddress==null || anGWAddress.size()==0)
			return null;
		
		List<InetAddress> result=new ArrayList<InetAddress>();
		for(ANGWAddress curr:anGWAddress)
			result.add(curr.getAddress());
		
		return result;
	}
	
	@Override
	public void setANGWAddress(List<InetAddress> value)
	{
		if(value!=null && value.size()>2)
			throw new IllegalArgumentException("Up to 2 AN-GW-Address allowed");
		
		if(value==null)
			this.anGWAddress = null;
		else
		{
			this.anGWAddress = new ArrayList<ANGWAddress>();
			for(InetAddress curr:value)
				this.anGWAddress.add(new ANGWAddressImpl(curr, null, null));
		}
	}
	
	@Override
	public Long getUDPSourcePort()
	{
		if(udpSourcePort==null)
			return null;
		
		return this.udpSourcePort.getUnsigned();
	}
	
	@Override
	public void setUDPSourcePort(Long value)
	{
		if(value==null)
			this.udpSourcePort = null;
		else
			this.udpSourcePort = new UDPSourcePortImpl(value, null, null);
	}	
	
	@DiameterValidate
	public String validate()
	{
		if(anGWAddress!=null && anGWAddress.size()>2)
			return "Up to 2 AN-GW-Address allowed";
		
		return null;
	}
}