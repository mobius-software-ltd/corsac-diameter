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

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.FlowDescriptionImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
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
	
	public RoutingFilterImpl(FlowDescription flowDescription,FlowDirectionEnum flowDirection) throws MissingAvpException
	{
		setFlowDescription(flowDescription);
		
		setFlowDirection(flowDirection);		
	}
	
	public FlowDescription getFlowDescription()
	{
		return flowDescription;
	}
	
	public void setFlowDescription(FlowDescription value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Flow-Description is required is required", Arrays.asList(new DiameterAvp[] { new FlowDescriptionImpl() }));
		
		this.flowDescription = value;						
	}
	
	public FlowDirectionEnum getFlowDirection()
	{
		if(flowDirection==null)
			return null;
		
		return flowDirection.getEnumerated(FlowDirectionEnum.class);
	}
	
	public void setFlowDirection(FlowDirectionEnum value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Flow-Direction is required is required", Arrays.asList(new DiameterAvp[] { new FlowDirectionImpl() }));
		
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
	public DiameterException validate()
	{
		if(flowDescription==null)
			return new MissingAvpException("Flow-Description is required is required", Arrays.asList(new DiameterAvp[] { new FlowDescriptionImpl() }));
		
		if(flowDirection==null)
			return new MissingAvpException("Flow-Direction is required is required", Arrays.asList(new DiameterAvp[] { new FlowDirectionImpl() }));
		
		return null;
	}		  		  
}