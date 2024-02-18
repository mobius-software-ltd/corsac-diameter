package com.mobius.software.telco.protocols.diameter.impl.primitives.mb2c;
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
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.FlowDescriptionImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.ROHCFullHeaderPeriodicity;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.ROHCProfile;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.ROHCRequest;
import com.mobius.software.telco.protocols.diameter.primitives.rx.FlowDescription;

/**
*
* @author yulian oifa
*
*/
public class ROHCRequestImpl extends DiameterGroupedAvpImpl implements ROHCRequest
{
	private List<FlowDescription> flowDescription;
	
	private ROHCFullHeaderPeriodicity rohcFullHeaderPeriodicity;
	
	private ROHCProfile rohcProfile;
	
	public ROHCRequestImpl(List<FlowDescription> flowDescription,Long rohcProfile) throws MissingAvpException
	{
		setFlowDescription(flowDescription);
		
		setROHCProfile(rohcProfile);
	}
	 
	public List<FlowDescription> getFlowDescription()
	{
		return flowDescription;
	}
	
	public void setFlowDescription(List<FlowDescription> value) throws MissingAvpException
	{
		if(value==null || value.size()==0)
			throw new MissingAvpException("Flow-Description is required is required", Arrays.asList(new DiameterAvp[] { new FlowDescriptionImpl() }));
		
		this.flowDescription = value;	
	}
	
	public Float getROHCFullHeaderPeriodicity()
	{
		if(rohcFullHeaderPeriodicity==null)
			return null;
		
		return rohcFullHeaderPeriodicity.getFloat();
	}
	
	public void setROHCFullHeaderPeriodicity(Float value)
	{
		if(value==null)
			this.rohcFullHeaderPeriodicity = null;
		else
			this.rohcFullHeaderPeriodicity = new ROHCFullHeaderPeriodicityImpl(value, null, null);			
	}
	
	public Long getROHCProfile()
	{
		if(rohcProfile==null)
			return null;
		
		return rohcProfile.getUnsigned();
	}
	
	public void setROHCProfile(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("ROHC-Profile is required is required", Arrays.asList(new DiameterAvp[] { new ROHCProfileImpl() }));
			
		this.rohcProfile = new ROHCProfileImpl(value, null, null);	
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(flowDescription==null || flowDescription.size()==0)
			return new MissingAvpException("Flow-Description is required is required", Arrays.asList(new DiameterAvp[] { new FlowDescriptionImpl() }));
		
		if(rohcProfile == null)
			return new MissingAvpException("ROHC-Profile is required is required", Arrays.asList(new DiameterAvp[] { new ROHCProfileImpl() }));
		
		return null;
	}
}