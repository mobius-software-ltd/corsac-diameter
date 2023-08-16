package com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5777;
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
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.HighUserPriority;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.LowUserPriority;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.UserPriorityRange;

/**
*
* @author yulian oifa
*
*/

@DiameterAvpImplementation(code = 557L, vendorId = -1L)
public class UserPriorityRangeImpl extends DiameterGroupedAvpImpl implements UserPriorityRange
{
	private List<LowUserPriority> lowUserPriority; 
	
	private List<HighUserPriority> highUserPriority; 
	
	public UserPriorityRangeImpl() 
	{
	}
	
	public List<Long> getLowUserPriority()
	{
		if(lowUserPriority==null || lowUserPriority.size()==0)
			return null;
		
		List<Long> result = new ArrayList<Long>();
		for(LowUserPriority curr:lowUserPriority)
			result.add(curr.getUnsigned());
		
		return result;
	}
	
	public void setLowUserPriority(List<Long> value)
	{
		if(value==null || value.size()==0)
			this.lowUserPriority = null;
		else
		{
			this.lowUserPriority = new ArrayList<LowUserPriority>();
			for(Long curr:value)
				this.lowUserPriority.add(new LowUserPriorityImpl(curr, null, null));			
		}
	}
	
	public List<Long> getHighUserPriority()
	{
		if(highUserPriority==null || highUserPriority.size()==0)
			return null;
		
		List<Long> result = new ArrayList<Long>();
		for(HighUserPriority curr:highUserPriority)
			result.add(curr.getUnsigned());
		
		return result;
	}
	
	public void setHighUserPriority(List<Long> value)
	{
		if(value==null || value.size()==0)
			this.highUserPriority = null;
		else
		{
			this.highUserPriority = new ArrayList<HighUserPriority>();
			for(Long curr:value)
				this.highUserPriority.add(new HighUserPriorityImpl(curr, null, null));			
		}
	}
}