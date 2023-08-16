package com.mobius.software.telco.protocols.diameter.impl.primitives.common;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.primitives.common.ExperimentalResult;
import com.mobius.software.telco.protocols.diameter.primitives.common.ExperimentalResultCode;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorId;

/*
 * Mobius Software LTD, Open Source Cloud Communications
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

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 297L, vendorId = -1L)
public class ExperimentalResultImpl implements ExperimentalResult
{
	private VendorId vendorId;
	
	private ExperimentalResultCode experimentalResultCode;
	
	protected ExperimentalResultImpl() 
	{
	}
	
	public ExperimentalResultImpl(Long vendorId,Long experimentalResultCode)
	{
		if(vendorId==null)
			throw new IllegalArgumentException("Vendor-Id is required");

		if(experimentalResultCode==null)
			throw new IllegalArgumentException("Experimental-Result-Code is required");

		this.vendorId=new VendorIdImpl(vendorId, null, null);	
		
		this.experimentalResultCode=new ExperimentalResultCodeImpl(experimentalResultCode, null, null);			
	}

	@Override
	public Long getVendorId() 
	{
		if(vendorId == null)
			return null;
		
		return vendorId.getUnsigned();
	}

	@Override
	public void setVendorId(Long value) 
	{
		if(value==null)
			throw new IllegalArgumentException("Vendor-Id is required");

		this.vendorId = new VendorIdImpl(value, null, null);
	}

	@Override
	public Long getExperimentalResultCode() 
	{
		if(experimentalResultCode == null)
			return null;
		
		return experimentalResultCode.getUnsigned();
	}

	@Override
	public void setExperimentalResultCode(Long value) 
	{
		if(value==null)
			throw new IllegalArgumentException("Experimental-Result-Code is required");

		this.experimentalResultCode = new ExperimentalResultCodeImpl(value, null, null);
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((experimentalResultCode == null) ? 0 : experimentalResultCode.hashCode());
		result = prime * result + ((vendorId == null) ? 0 : vendorId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		ExperimentalResultImpl other = (ExperimentalResultImpl) obj;
		if (experimentalResultCode == null) 
		{
			if (other.experimentalResultCode != null)
				return false;
		} 
		else if (!experimentalResultCode.equals(other.experimentalResultCode))
			return false;
		
		if (vendorId == null) 
		{
			if (other.vendorId != null)
				return false;
		} 
		else if (!vendorId.equals(other.vendorId))
			return false;
		
		return true;
	}	
	
	@DiameterValidate
	public String validate()
	{
		if(vendorId==null)
			return "Vendor-Id is required";

		if(experimentalResultCode==null)
			return "Experimental-Result-Code is required";

		return null;
	}
}