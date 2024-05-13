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
import com.mobius.software.telco.protocols.diameter.primitives.gx.PCCRuleStatus;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PCCRuleStatusEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RoutingRuleFailureCode;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RoutingRuleFailureCodeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RoutingRuleIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RoutingRuleReport;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class RoutingRuleReportImpl extends DiameterGroupedAvpImpl implements RoutingRuleReport
{
	private List<RoutingRuleIdentifier> routingRuleIdentifier;
	private PCCRuleStatus pccRuleStatus;
	private RoutingRuleFailureCode routingRuleFailureCode;
	
	public RoutingRuleReportImpl()
	{
		
	}
	
	public List<ByteBuf> getRoutingRuleIdentifier()
	{
		if(routingRuleIdentifier==null || routingRuleIdentifier.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(RoutingRuleIdentifier curr:routingRuleIdentifier)
			result.add(curr.getValue());
		
		return result;
	}
	
	public void setRoutingRuleIdentifier(List<ByteBuf> value)
	{
		if(value==null || value.size()==0)
			this.routingRuleIdentifier = null;
		else
		{
			this.routingRuleIdentifier = new ArrayList<RoutingRuleIdentifier>();
			for(ByteBuf curr:value)
				this.routingRuleIdentifier.add(new RoutingRuleIdentifierImpl(curr, null, null));			
		}
	}
	
	public PCCRuleStatusEnum getPCCRuleStatus()
	{
		if(pccRuleStatus==null)
			return null;
		
		return pccRuleStatus.getEnumerated(PCCRuleStatusEnum.class);
	}
	
	public void setPCCRuleStatus(PCCRuleStatusEnum value)
	{
		if(value==null)
			this.pccRuleStatus = null;
		else
			this.pccRuleStatus = new PCCRuleStatusImpl(value, null, null);			
	}
	
	public RoutingRuleFailureCodeEnum getRoutingRuleFailureCode()
	{
		if(routingRuleFailureCode==null)
			return null;
		
		return routingRuleFailureCode.getEnumerated(RoutingRuleFailureCodeEnum.class);
	}
	
	public void setRoutingRuleFailureCode(RoutingRuleFailureCodeEnum value)
	{
		if(value==null)
			this.routingRuleFailureCode = null;
		else
			this.routingRuleFailureCode = new RoutingRuleFailureCodeImpl(value, null, null);			
	}	
}