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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.ROHCFullHeaderPeriodicity;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.ROHCProfile;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.ROHCRequest;
import com.mobius.software.telco.protocols.diameter.primitives.rx.FlowDescription;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3526L, vendorId = KnownVendorIDs.TGPP_ID)
public class ROHCRequestImpl extends DiameterGroupedAvpImpl implements ROHCRequest
{
	private List<FlowDescription> flowDescription;
	
	private ROHCFullHeaderPeriodicity rohcFullHeaderPeriodicity;
	
	private ROHCProfile rohcProfile;
	
	public ROHCRequestImpl(List<FlowDescription> flowDescription,Long rohcProfile)
	{
		if(flowDescription==null || flowDescription.size()==0)
			throw new IllegalArgumentException("Flow-Description is required");
			
		if(rohcProfile==null)
			throw new IllegalArgumentException("ROHC-Profile is required");
			
		this.flowDescription = flowDescription;
	    	
		this.rohcProfile = new ROHCProfileImpl(rohcProfile,null,null);	    	
	}
	 
	public List<FlowDescription> getFlowDescription()
	{
		return flowDescription;
	}
	
	public void setFlowDescription(List<FlowDescription> value)
	{
		if(value==null || value.size()==0)
			throw new IllegalArgumentException("Flow-Description is required");
		
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
	
	public void setROHCProfile(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("ROHC-Profile is required");
		
		this.rohcProfile = new ROHCProfileImpl(value, null, null);	
	}
	
	@DiameterValidate
	public String validate()
	{
		if(flowDescription==null || flowDescription.size()==0)
			return "Flow-Description is required";
		
		if(rohcProfile == null)
			return "ROHC-Profile is required";
		
		return null;
	}
}