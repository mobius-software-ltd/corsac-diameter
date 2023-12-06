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
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.RequiredAccessInfoImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.gxx.QoSRuleBaseName;
import com.mobius.software.telco.protocols.diameter.primitives.gxx.QoSRuleName;
import com.mobius.software.telco.protocols.diameter.primitives.gxx.QoSRuleRemove;
import com.mobius.software.telco.protocols.diameter.primitives.rx.RequiredAccessInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rx.RequiredAccessInfoEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1052L, vendorId = KnownVendorIDs.TGPP_ID)
public class QoSRuleRemoveImpl extends DiameterGroupedAvpImpl implements QoSRuleRemove
{
	private List<QoSRuleName> chargingRuleName;
	private List<QoSRuleBaseName> qosRuleBaseName;
	private List<RequiredAccessInfo> requiredAccessInfo;
		
	public QoSRuleRemoveImpl()
	{
		
	}
	
	public List<ByteBuf> getQoSRuleName()
	{
		if(chargingRuleName==null || chargingRuleName.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(QoSRuleName curr:chargingRuleName)
			result.add(curr.getValue());
		
		return result;
	}	
	
	
	public void setQoSRuleName(List<ByteBuf> value)
	{
		if(value==null || value.size()==0)
			this.chargingRuleName = null;
		else
		{
			this.chargingRuleName = new ArrayList<QoSRuleName>();
			for(ByteBuf curr:value)
				this.chargingRuleName.add(new QoSRuleNameImpl(curr, null, null));			
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
	
	public List<RequiredAccessInfoEnum> getRequiredAccessInfo()
	{
		if(requiredAccessInfo==null || requiredAccessInfo.size()==0)
			return null;
		
		List<RequiredAccessInfoEnum> result = new ArrayList<RequiredAccessInfoEnum>();
		for(RequiredAccessInfo curr:requiredAccessInfo)
			result.add(curr.getEnumerated(RequiredAccessInfoEnum.class));
		
		return result;
	}
	
	public void setRequiredAccessInfo(List<RequiredAccessInfoEnum> value)
	{
		if(value==null || value.size()==0)
			this.requiredAccessInfo = null;
		else
		{
			this.requiredAccessInfo = new ArrayList<RequiredAccessInfo>();
			for(RequiredAccessInfoEnum curr:value)
				this.requiredAccessInfo.add(new RequiredAccessInfoImpl(curr, null, null));			
		}
	}
}