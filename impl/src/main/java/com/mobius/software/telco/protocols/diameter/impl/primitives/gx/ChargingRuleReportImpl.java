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
import java.util.List;

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.ContentVersionImpl;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.FinalUnitIndication;
import com.mobius.software.telco.protocols.diameter.primitives.gx.BearerIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleBaseName;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleName;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleReport;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PCCRuleStatus;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PCCRuleStatusEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RANNASReleaseCause;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RuleFailureCode;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RuleFailureCodeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.ContentVersion;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class ChargingRuleReportImpl extends DiameterGroupedAvpImpl implements ChargingRuleReport
{
	private List<ChargingRuleName> chargingRuleName;
	private List<ChargingRuleBaseName> chargingRuleBaseName;
	private BearerIdentifier bearerIdentifier;
	private PCCRuleStatus pcCRuleStatus;
	private RuleFailureCode ruleFailureCode;
	private FinalUnitIndication finalUnitIndication;
	private List<RANNASReleaseCause> ranNASReleaseCause;
	private List<ContentVersion> contentVersion;
	
	public ChargingRuleReportImpl()
	{
		
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
	
	public PCCRuleStatusEnum getPCCRuleStatus()
	{
		if(pcCRuleStatus==null)
			return null;
		
		return pcCRuleStatus.getEnumerated(PCCRuleStatusEnum.class);
	}
	
	public void setPCCRuleStatus(PCCRuleStatusEnum value)
	{
		if(value==null)
			this.pcCRuleStatus = null;
		else
			this.pcCRuleStatus = new PCCRuleStatusImpl(value, null, null);			
	}
	
	public RuleFailureCodeEnum getRuleFailureCode()
	{
		if(ruleFailureCode==null)
			return null;
		
		return ruleFailureCode.getEnumerated(RuleFailureCodeEnum.class);
	}
	
	public void setRuleFailureCode(RuleFailureCodeEnum value)
	{
		if(value==null)
			this.ruleFailureCode = null;
		else
			this.ruleFailureCode = new RuleFailureCodeImpl(value, null, null);			
	}
	
	public FinalUnitIndication getFinalUnitIndication()
	{
		return finalUnitIndication;
	}
	
	public void setFinalUnitIndication(FinalUnitIndication value)
	{
		this.finalUnitIndication = value;
	}
	
	public List<ByteBuf> getRANNASReleaseCause()
	{
		if(ranNASReleaseCause==null || ranNASReleaseCause.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(RANNASReleaseCause curr:ranNASReleaseCause)
			result.add(curr.getValue());
		
		return result;
	}
	
	public void setRANNASReleaseCause(List<ByteBuf> value)
	{
		if(value==null || value.size()==0)
			this.ranNASReleaseCause = null;
		else
		{
			this.ranNASReleaseCause = new ArrayList<RANNASReleaseCause>();
			for(ByteBuf curr:value)
				this.ranNASReleaseCause.add(new RANNASReleaseCauseImpl(curr, null, null));			
		}
	}
	
	public List<Long> getContentVersion()
	{
		if(contentVersion==null || contentVersion.size()==0)
			return null;
		
		List<Long> result = new ArrayList<Long>();
		for(ContentVersion curr:contentVersion)
			result.add(curr.getLong());
		
		return result;
	}
	
	public void setContentVersion(List<Long> value)
	{
		if(value==null || value.size()==0)
			this.contentVersion = null;
		else
		{
			this.contentVersion = new ArrayList<ContentVersion>();
			for(Long curr:value)
				this.contentVersion.add(new ContentVersionImpl(curr, null, null));			
		}
	}
}