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
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.FlowNumberImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.MediaComponentNumberImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.gq.Flows;
import com.mobius.software.telco.protocols.diameter.primitives.rx.FlowNumber;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MediaComponentNumber;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 510L, vendorId = KnownVendorIDs.TGPP_ID)
public class FlowsImpl implements Flows
{
	private MediaComponentNumber mediaComponentNumber;
	
	private List<FlowNumber> flowNumber;
	
	protected FlowsImpl()
	{
		
	}
	
	public FlowsImpl(Long mediaComponentNumber)
	{
		if(mediaComponentNumber==null)
			throw new IllegalArgumentException("Media-Component-Number is required");
		
		this.mediaComponentNumber = new MediaComponentNumberImpl(mediaComponentNumber, null, null);	
	}
	
	public Long getMediaComponentNumber()
	{
		if(mediaComponentNumber == null)
			return null;
		
		return mediaComponentNumber.getUnsigned();
	}
	
	public void setMediaComponentNumber(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("Media-Component-Number is required");
		
		this.mediaComponentNumber = new MediaComponentNumberImpl(value, null, null);	
	}
	
	public List<Long> getFlowNumber()
	{
		if(flowNumber == null || flowNumber.size()==0)
			return null;
		
		List<Long> result = new ArrayList<Long>();
		for(FlowNumber curr:flowNumber)
			result.add(curr.getUnsigned());
		
		return result;
	}
	
	public void setFlowNumber(List<Long> value)
	{
		if(value==null || value.size()==0)
			this.flowNumber = null;
		else
		{
			this.flowNumber = new ArrayList<FlowNumber>();
			for(Long curr:value)
				this.flowNumber.add(new FlowNumberImpl(curr, null, null));
		}
	}		
	
	@DiameterValidate
	public String validate()
	{
		if(mediaComponentNumber==null)
			return "Media-Component-Number is required";
		
		return null;
	}	
}