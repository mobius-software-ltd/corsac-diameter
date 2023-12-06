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

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.PCCRuleStatusImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RuleFailureCodeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.ContentVersionImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PCCRuleStatus;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PCCRuleStatusEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RuleFailureCode;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RuleFailureCodeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gxx.QoSRuleBaseName;
import com.mobius.software.telco.protocols.diameter.primitives.gxx.QoSRuleName;
import com.mobius.software.telco.protocols.diameter.primitives.gxx.QoSRuleReport;
import com.mobius.software.telco.protocols.diameter.primitives.rx.ContentVersion;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1055L, vendorId = KnownVendorIDs.TGPP_ID)
public class QoSRuleReportImpl extends DiameterGroupedAvpImpl implements QoSRuleReport
{
	private List<QoSRuleName> qosRuleName;
	private List<QoSRuleBaseName> qosRuleBaseName;
	private PCCRuleStatus pcCRuleStatus;
	private RuleFailureCode ruleFailureCode;
	private List<ContentVersion> contentVersion;
	
	public QoSRuleReportImpl()
	{
		
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