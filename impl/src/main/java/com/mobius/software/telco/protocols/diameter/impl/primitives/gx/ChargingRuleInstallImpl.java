package com.mobius.software.telco.protocols.diameter.impl.primitives.gx;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.gx.BearerIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingCorrelationIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingCorrelationIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleBaseName;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleInstall;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleName;
import com.mobius.software.telco.protocols.diameter.primitives.gx.IPCANType;
import com.mobius.software.telco.protocols.diameter.primitives.gx.IPCANTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.MonitoringFlags;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ResourceAllocationNotification;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ResourceAllocationNotificationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RuleActivationTime;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RuleDeactivationTime;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class ChargingRuleInstallImpl extends DiameterGroupedAvpImpl implements ChargingRuleInstall
{
	private List<ChargingRuleDefinition> chargingRuleDefinition;
	private List<ChargingRuleName> chargingRuleName;
	private List<ChargingRuleBaseName> chargingRuleBaseName;
	private BearerIdentifier bearerIdentifier;
	private MonitoringFlags monitoringFlags;
	private RuleActivationTime ruleActivationTime;
	private RuleDeactivationTime ruleDeactivationTime;
	private ResourceAllocationNotification resourceAllocationNotification;
	private ChargingCorrelationIndicator chargingCorrelationIndicator;
	private IPCANType ipcanType;
		
	public ChargingRuleInstallImpl()
	{
		
	}
	
	public List<ChargingRuleDefinition> getChargingRuleDefinition()
	{
		return chargingRuleDefinition;
	}
	
	public void setChargingRuleDefinition(List<ChargingRuleDefinition> value)
	{
		this.chargingRuleDefinition = value;
	}
	
	public List<ByteBuf> getChargingRuleName()
	{
		if(chargingRuleName==null || chargingRuleName.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(ChargingRuleName curr:chargingRuleName)
			result.add(curr.getValue());
		
		return result;
	}
	
	public void setChargingRuleName(List<ByteBuf> value)
	{
		if(value==null || value.size()==0)
			this.chargingRuleName = null;
		else
		{
			this.chargingRuleName = new ArrayList<ChargingRuleName>();
			for(ByteBuf curr:value)
				this.chargingRuleName.add(new ChargingRuleNameImpl(curr, null, null));			
		}
	}
	
	public List<String> getChargingRuleBaseName()
	{
		if(chargingRuleBaseName==null || chargingRuleBaseName.size()==0)
			return null;
		
		List<String> result = new ArrayList<String>();
		for(ChargingRuleBaseName curr:chargingRuleBaseName)
			result.add(curr.getString());
		
		return result;
	}
	
	public void setChargingRuleBaseName(List<String> value)
	{
		if(value==null || value.size()==0)
			this.chargingRuleBaseName = null;
		else
		{
			this.chargingRuleBaseName = new ArrayList<ChargingRuleBaseName>();
			for(String curr:value)
				this.chargingRuleBaseName.add(new ChargingRuleBaseNameImpl(curr, null, null));			
		}
	}
	
	public ByteBuf getBearerIdentifier()
	{
		if(bearerIdentifier==null)
			return null;
		
		return bearerIdentifier.getValue();
	}
	
	public void setBearerIdentifier(ByteBuf value)
	{
		if(value==null)
			this.bearerIdentifier = null;
		else
			this.bearerIdentifier = new BearerIdentifierImpl(value, null, null);			
	}
	
	public MonitoringFlags getMonitoringFlags()
	{
		return monitoringFlags;
	}
	
	public void setMonitoringFlags(MonitoringFlags value)
	{
		this.monitoringFlags = value;			
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
	
	public ResourceAllocationNotificationEnum getResourceAllocationNotification()
	{
		if(resourceAllocationNotification==null)
			return null;
		
		return resourceAllocationNotification.getEnumerated(ResourceAllocationNotificationEnum.class);
	}
	
	public void setResourceAllocationNotification(ResourceAllocationNotificationEnum value)
	{
		if(value==null)
			this.resourceAllocationNotification = null;
		else
			this.resourceAllocationNotification = new ResourceAllocationNotificationImpl(value, null, null);			
	}
	
	public ChargingCorrelationIndicatorEnum getChargingCorrelationIndicator()
	{
		if(chargingCorrelationIndicator==null)
			return null;
		
		return chargingCorrelationIndicator.getEnumerated(ChargingCorrelationIndicatorEnum.class);
	}
	
	public void setChargingCorrelationIndicator(ChargingCorrelationIndicatorEnum value)
	{
		if(value==null)
			this.chargingCorrelationIndicator = null;
		else
			this.chargingCorrelationIndicator = new ChargingCorrelationIndicatorImpl(value, null, null);			
	}
	
	public IPCANTypeEnum getIPCANType()
	{
		if(ipcanType==null)
			return null;
		
		return ipcanType.getEnumerated(IPCANTypeEnum.class);
	}
	
	public void setIPCANType(IPCANTypeEnum value)
	{
		if(value==null)
			this.ipcanType = null;
		else
			this.ipcanType = new IPCANTypeImpl(value, null, null);			
	}
}