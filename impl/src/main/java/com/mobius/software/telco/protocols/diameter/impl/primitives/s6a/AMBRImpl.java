package com.mobius.software.telco.protocols.diameter.impl.primitives.s6a;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.ExtendedMaxRequestedBWDLImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.ExtendedMaxRequestedBWULImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.MaxRequestedBandwidthDLImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.MaxRequestedBandwidthULImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.rx.ExtendedMaxRequestedBWDL;
import com.mobius.software.telco.protocols.diameter.primitives.rx.ExtendedMaxRequestedBWUL;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MaxRequestedBandwidthDL;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MaxRequestedBandwidthUL;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AMBR;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1435L, vendorId = KnownVendorIDs.TGPP_ID)
public class AMBRImpl extends DiameterGroupedAvpImpl implements AMBR
{
	private MaxRequestedBandwidthUL maxRequestedBandwidthUL;
	
	private MaxRequestedBandwidthDL maxRequestedBandwidthDL;
	
	private ExtendedMaxRequestedBWUL extendedMaxRequestedBWUL;
	
	private ExtendedMaxRequestedBWDL extendedMaxRequestedBWDL;
	
	protected AMBRImpl() 
	{
	}
	
	public AMBRImpl(Long maxRequestedBandwidthUL,Long maxRequestedBandwidthDL)
	{
		if(maxRequestedBandwidthUL==null)
			throw new IllegalArgumentException("Max-Requested-Bandwidth-UL is required");
		
		if(maxRequestedBandwidthDL==null)
			throw new IllegalArgumentException("Max-Requested-Bandwidth-DL is required");
		
		this.maxRequestedBandwidthUL = new MaxRequestedBandwidthULImpl(maxRequestedBandwidthUL, null, null);				
		
		this.maxRequestedBandwidthDL = new MaxRequestedBandwidthDLImpl(maxRequestedBandwidthDL, null, null);						
	}
	
	public Long getMaxRequestedBandwidthUL()
	{
		if(maxRequestedBandwidthUL==null)
			return null;
		
		return maxRequestedBandwidthUL.getUnsigned();
	}
	
	public void setMaxRequestedBandwidthUL(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("Max-Requested-Bandwidth-UL is required");
		
		this.maxRequestedBandwidthUL = new MaxRequestedBandwidthULImpl(value, null, null);				
	}
	
	public Long getMaxRequestedBandwidthDL()
	{
		if(maxRequestedBandwidthDL==null)
			return null;
		
		return maxRequestedBandwidthDL.getUnsigned();
	}
	
	public void setMaxRequestedBandwidthDL(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("Max-Requested-Bandwidth-DL is required");
		
		this.maxRequestedBandwidthDL = new MaxRequestedBandwidthDLImpl(value, null, null);				
	}
	
	public Long getExtendedMaxRequestedBWUL()
	{
		if(extendedMaxRequestedBWUL==null)
			return null;
		
		return extendedMaxRequestedBWUL.getUnsigned();
	}
	
	public void setExtendedMaxRequestedBWUL(Long value)
	{
		if(value==null)
			this.extendedMaxRequestedBWUL = null;
		else
			this.extendedMaxRequestedBWUL = new ExtendedMaxRequestedBWULImpl(value, null, null);			
	}
	
	public Long getExtendedMaxRequestedBWDL()
	{
		if(extendedMaxRequestedBWDL==null)
			return null;
		
		return extendedMaxRequestedBWDL.getUnsigned();
	}
	
	public void setExtendedMaxRequestedBWDL(Long value)
	{
		if(value==null)
			this.extendedMaxRequestedBWDL = null;
		else
			this.extendedMaxRequestedBWDL = new ExtendedMaxRequestedBWDLImpl(value, null, null);			
	}
	
	@DiameterValidate
	public String validate()
	{
		if(maxRequestedBandwidthUL==null)
			return "Max-Requested-Bandwidth-UL is required";
		
		if(maxRequestedBandwidthDL==null)
			return "Max-Requested-Bandwidth-DL is required";
		
		return null;
	}
}