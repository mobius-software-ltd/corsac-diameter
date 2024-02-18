package com.mobius.software.telco.protocols.diameter.impl.primitives.sd;
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
import com.mobius.software.telco.protocols.diameter.primitives.sd.ADCRuleBaseName;
import com.mobius.software.telco.protocols.diameter.primitives.sd.ADCRuleName;
import com.mobius.software.telco.protocols.diameter.primitives.sd.ADCRuleRemove;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class ADCRuleRemoveImpl extends DiameterGroupedAvpImpl implements ADCRuleRemove
{
	private List<ADCRuleName> adcRuleName;
	private List<ADCRuleBaseName> adcRuleBaseName;
		
	public ADCRuleRemoveImpl()
	{
		
	}
	
	public List<ByteBuf> getADCRuleName()
	{
		if(adcRuleName==null || adcRuleName.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(ADCRuleName curr:adcRuleName)
			result.add(curr.getValue());
		
		return result;
	}	
	
	
	public void setADCRuleName(List<ByteBuf> value)
	{
		if(value==null || value.size()==0)
			this.adcRuleName = null;
		else
		{
			this.adcRuleName = new ArrayList<ADCRuleName>();
			for(ByteBuf curr:value)
				this.adcRuleName.add(new ADCRuleNameImpl(curr, null, null));			
		}
	}
	
	public List<String> getADCRuleBaseName()
	{
		if(adcRuleBaseName==null || adcRuleBaseName.size()==0)
			return null;
		
		List<String> result = new ArrayList<String>();
		for(ADCRuleBaseName curr:adcRuleBaseName)
			result.add(curr.getString());
		
		return result;
	}
	
	public void setADCRuleBaseName(List<String> value)
	{
		if(value==null || value.size()==0)
			this.adcRuleBaseName = null;
		else
		{
			this.adcRuleBaseName = new ArrayList<ADCRuleBaseName>();
			for(String curr:value)
				this.adcRuleBaseName.add(new ADCRuleBaseNameImpl(curr, null, null));			
		}
	}
}