package com.mobius.software.telco.protocols.diameter.impl.primitives.common;
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
import com.mobius.software.telco.protocols.diameter.primitives.common.AcctApplicationId;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthApplicationId;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorId;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorSpecificApplicationId;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 260L, vendorId = -1L)
public class VendorSpecificApplicationIdImpl implements VendorSpecificApplicationId
{
	private VendorId vendorId;
	
	private AuthApplicationId authApplicationId;
	
	private AcctApplicationId acctAppicationId;
	
	public VendorSpecificApplicationIdImpl()
	{
		
	}
	
	public VendorSpecificApplicationIdImpl(Long vendorId,Long authApplicationId,Long acctAppicationId)
	{
		if(authApplicationId!=null && acctAppicationId!=null)
			throw new IllegalArgumentException("Auth Application Id and Acct Application Id can not be set both");

		if(authApplicationId==null && acctAppicationId==null)
			throw new IllegalArgumentException("Either Auth Application Id or Acct Application Id should be set");
		
		if(vendorId!=null)
			this.vendorId=new VendorIdImpl(vendorId, null, null);
		
		if(authApplicationId!=null)
			this.authApplicationId=new AuthApplicationIdImpl(authApplicationId, null, null);
		
		if(acctAppicationId!=null)
			this.acctAppicationId=new AcctApplicationIdImpl(acctAppicationId, null, null);
		
	}
	
	public Long getVendorId()
	{
		if(this.vendorId==null)
			return null;
		
		return this.vendorId.getUnsigned();
	}
	
	public void setVendorId(Long vendorId)
	{
		if(vendorId!=null)
			this.vendorId = new VendorIdImpl(vendorId, null, null);
		else
			this.vendorId = null;
	}
	
	public Long getAuthApplicationId()
	{
		if(this.authApplicationId==null)
			return null;
		
		return this.authApplicationId.getUnsigned();
	}
	
	public void setAuthApplicationId(Long authApplicationId)
	{
		if(authApplicationId!=null)
			this.authApplicationId = new AuthApplicationIdImpl(authApplicationId, null, null);
		else
			this.authApplicationId = null;
	}
	
	public Long getAcctApplicationId()
	{
		if(this.acctAppicationId==null)
			return null;
		
		return this.acctAppicationId.getUnsigned();
	}
	
	public void setAcctApplicationId(Long acctApplicationId)
	{
		if(acctApplicationId!=null)
			this.acctAppicationId = new AcctApplicationIdImpl(acctApplicationId, null, null);
		else
			this.acctAppicationId = null;
	}
}