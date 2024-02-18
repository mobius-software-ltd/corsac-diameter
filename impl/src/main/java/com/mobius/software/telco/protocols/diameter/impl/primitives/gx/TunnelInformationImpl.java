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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TunnelHeaderFilter;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TunnelHeaderLength;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TunnelInformation;

/**
*
* @author yulian oifa
*
*/
public class TunnelInformationImpl extends DiameterGroupedAvpImpl implements TunnelInformation
{
	private TunnelHeaderLength tunnelHeaderLength;
	private List<TunnelHeaderFilter> tunnelHeaderFilter;
		
	public TunnelInformationImpl()
	{
		
	}
	
	public Long getTunnelHeaderLength()
	{
		if(tunnelHeaderLength==null)
			return null;
		
		return tunnelHeaderLength.getUnsigned();
	}
	
	public void setTunnelHeaderLength(Long value)
	{
		if(value==null)
			this.tunnelHeaderLength = null;
		else
			this.tunnelHeaderLength = new TunnelHeaderLengthImpl(value, null, null);			
	}
	
	public List<TunnelHeaderFilter> getTunnelHeaderFilter()
	{
		return tunnelHeaderFilter;
	}
	
	public void setTunnelHeaderFilter(List<TunnelHeaderFilter> value) throws AvpOccursTooManyTimesException
	{
		if(value!=null && value.size()>2)
		{
			List<DiameterAvp> failedAvps=new ArrayList<DiameterAvp>();
			for(TunnelHeaderFilter curr:value)
				failedAvps.add(curr);
			
			throw new AvpOccursTooManyTimesException("Up to 2 Tunnel-Header-Filter allowed", failedAvps);
		}
		
		this.tunnelHeaderFilter = value;
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(tunnelHeaderFilter!=null && tunnelHeaderFilter.size()>2)
		{
			List<DiameterAvp> failedAvps=new ArrayList<DiameterAvp>();
			failedAvps.addAll(tunnelHeaderFilter);
			
			return new AvpOccursTooManyTimesException("Up to 2 Tunnel-Header-Filter allowed", failedAvps);
		}
		
		return null;
	}		  		  	  
}