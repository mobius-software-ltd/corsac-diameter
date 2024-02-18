package com.mobius.software.telco.protocols.diameter.impl.primitives.gq;
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
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.FlowNumberImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.FlowStatusImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.FlowUsageImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.MaxRequestedBandwidthDLImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.MaxRequestedBandwidthULImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.gq.MediaSubComponent;
import com.mobius.software.telco.protocols.diameter.primitives.rx.FlowDescription;
import com.mobius.software.telco.protocols.diameter.primitives.rx.FlowNumber;
import com.mobius.software.telco.protocols.diameter.primitives.rx.FlowStatus;
import com.mobius.software.telco.protocols.diameter.primitives.rx.FlowStatusEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.FlowUsage;
import com.mobius.software.telco.protocols.diameter.primitives.rx.FlowUsageEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MaxRequestedBandwidthDL;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MaxRequestedBandwidthUL;

/**
*
* @author yulian oifa
*
*/
public class MediaSubComponentImpl extends DiameterGroupedAvpImpl implements MediaSubComponent
{
	private FlowNumber flowNumber;
	
	private List<FlowDescription> flowDescription;
	
	private FlowStatus flowStatus;
	
	private FlowUsage flowUsage;
	
	private MaxRequestedBandwidthUL maxRequestedBandwidthUL;
	
	private MaxRequestedBandwidthDL maxRequestedBandwidthDL;
	
	protected MediaSubComponentImpl()
	{
		
	}
	
	public MediaSubComponentImpl(Long flowNumber) throws MissingAvpException
	{
		setFlowNumber(flowNumber);
	}
	
	public Long getFlowNumber()
	{
		if(flowNumber == null)
			return null;
		
		return flowNumber.getUnsigned();
	}
	
	public void setFlowNumber(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Flow-Number is required", Arrays.asList(new DiameterAvp[] { new FlowNumberImpl() }));
		
		this.flowNumber = new FlowNumberImpl(value, null, null);
	}
	
	public List<FlowDescription> getFlowDescription()
	{
		return flowDescription;
	}
	
	public void setFlowDescription(List<FlowDescription> value) throws AvpOccursTooManyTimesException
	{
		if(value!=null && value.size()>2)
		{
			List<DiameterAvp> failedAvps = new ArrayList<DiameterAvp>();
			failedAvps.addAll(value);
			throw new AvpOccursTooManyTimesException("Flow-Description may hold 0 to 2 items",failedAvps);
		}
		
		this.flowDescription = value;
	}
	
	public FlowStatusEnum getFlowStatus()
	{
		if(flowStatus == null)
			return null;
		
		return flowStatus.getEnumerated(FlowStatusEnum.class);
	}
	
	public void setFlowStatus(FlowStatusEnum value)
	{
		if(value == null)
			this.flowStatus = null;
		else
			this.flowStatus = new FlowStatusImpl(value, null, null);
	}
	
	public FlowUsageEnum getFlowUsage()
	{
		if(flowUsage == null)
			return null;
		
		return flowUsage.getEnumerated(FlowUsageEnum.class);
	}
	
	public void setFlowUsage(FlowUsageEnum value)
	{
		if(value == null)
			this.flowUsage = null;
		else
			this.flowUsage = new FlowUsageImpl(value, null, null);
	}
	
	public Long getMaxRequestedBandwidthUL()
	{
		if(maxRequestedBandwidthUL == null)
			return null;
		
		return maxRequestedBandwidthUL.getUnsigned();
	}
	
	public void setMaxRequestedBandwidthUL(Long value)
	{
		if(value == null)
			this.maxRequestedBandwidthUL = null;
		else
			this.maxRequestedBandwidthUL = new MaxRequestedBandwidthULImpl(value, null, null);
	}
	
	public Long getMaxRequestedBandwidthDL()
	{
		if(maxRequestedBandwidthDL == null)
			return null;
		
		return maxRequestedBandwidthDL.getUnsigned();
	}
	
	public void setMaxRequestedBandwidthDL(Long value)
	{
		if(value == null)
			this.maxRequestedBandwidthDL = null;
		else
			this.maxRequestedBandwidthDL = new MaxRequestedBandwidthDLImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(flowDescription!=null && flowDescription.size()>2)
		{
			List<DiameterAvp> failedAvps=new ArrayList<DiameterAvp>();
			failedAvps.addAll(flowDescription);
			
			return new AvpOccursTooManyTimesException("Flow-Description may hold 0 to 2 items", failedAvps);
		}
		
		if(flowNumber==null)
			return new MissingAvpException("Flow-Number is required", Arrays.asList(new DiameterAvp[] { new FlowNumberImpl() }));
		
		return null;
	}	
}