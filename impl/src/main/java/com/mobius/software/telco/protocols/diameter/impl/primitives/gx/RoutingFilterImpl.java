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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.gx.FlowDirection;
import com.mobius.software.telco.protocols.diameter.primitives.gx.FlowDirectionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.FlowLabel;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RoutingFilter;
import com.mobius.software.telco.protocols.diameter.primitives.gx.SecurityParameterIndex;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ToSTrafficClass;
import com.mobius.software.telco.protocols.diameter.primitives.rx.FlowDescription;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1078L, vendorId = KnownVendorIDs.TGPP_ID)
public class RoutingFilterImpl extends DiameterGroupedAvpImpl implements RoutingFilter
{
	private FlowDescription flowDescription;
	private FlowDirection flowDirection;
	private ToSTrafficClass tosTrafficClass;
	private SecurityParameterIndex securityParameterIndex;
	private FlowLabel flowLabel;
	
	protected RoutingFilterImpl()
	{
		
	}
	
	public RoutingFilterImpl(FlowDescription flowDescription,FlowDirectionEnum flowDirection)
	{
		if(flowDescription==null)
			throw new IllegalArgumentException("Flow-Description is required");
		
		if(flowDirection==null)
			throw new IllegalArgumentException("Flow-Direction is required");
		
		this.flowDescription = flowDescription;				
		
		this.flowDirection = new FlowDirectionImpl(flowDirection, null, null);
	}
	
	public FlowDescription getFlowDescription()
	{
		return flowDescription;
	}
	
	public void setFlowDescription(FlowDescription value)
	{
		if(value==null)
			throw new IllegalArgumentException("Flow-Description is required");
		
		this.flowDescription = value;						
	}
	
	public FlowDirectionEnum getFlowDirection()
	{
		if(flowDirection==null)
			return null;
		
		return flowDirection.getEnumerated(FlowDirectionEnum.class);
	}
	
	public void setFlowDirection(FlowDirectionEnum value)
	{
		if(value==null)
			throw new IllegalArgumentException("Flow-Direction is required");
		
		this.flowDirection = new FlowDirectionImpl(value, null, null);
	}
	
	public ByteBuf getToSTrafficClass()
	{
		if(tosTrafficClass==null)
			return null;
		
		return tosTrafficClass.getValue();
	}
	
	public void setToSTrafficClass(ByteBuf value)
	{
		if(value==null)
			this.tosTrafficClass = null;
		else
			this.tosTrafficClass = new ToSTrafficClassImpl(value, null, null);			
	}
	
	public ByteBuf getSecurityParameterIndex()
	{
		if(securityParameterIndex==null)
			return null;
		
		return securityParameterIndex.getValue();
	}
	
	public void setSecurityParameterIndex(ByteBuf value)
	{
		if(value==null)
			this.securityParameterIndex = null;
		else
			this.securityParameterIndex = new SecurityParameterIndexImpl(value, null, null);			
	}
	
	public ByteBuf getFlowLabel()
	{
		if(flowLabel==null)
			return null;
		
		return flowLabel.getValue();
	}
	
	public void setFlowLabel(ByteBuf value)
	{
		if(value==null)
			this.flowLabel = null;
		else
			this.flowLabel = new FlowLabelImpl(value, null, null);			
	}
	
	@DiameterValidate
	public String validate()
	{
		if(flowDescription==null)
			return "Flow-Description is required";
		
		if(flowDirection==null)
			return "Flow-Direction is required";
		
		return null;
	}		  		  
}