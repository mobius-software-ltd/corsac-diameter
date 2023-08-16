package com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AcctApplicationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthApplicationIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.common.AcctApplicationId;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthApplicationId;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorSpecificApplicationId;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedApplications;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 631L, vendorId = KnownVendorIDs.TGPP_ID)
public class SupportedApplicationsImpl extends DiameterGroupedAvpImpl implements SupportedApplications
{
	private List<AuthApplicationId> authApplicationId;
	
	private List<AcctApplicationId> acctApplicationId;
	
	private List<VendorSpecificApplicationId> vendorSpecificApplicationId;
	
	public SupportedApplicationsImpl() 
	{
		super();
	}
	
	public List<Long> getAuthApplicationId()
	{
		if(authApplicationId == null)
			return null;
		
		List<Long> result=new ArrayList<Long>();
		for(AuthApplicationId curr:authApplicationId)
			result.add(curr.getUnsigned());
		
		return result;
	}
	
	public void setAuthApplicationId(List<Long> value)
	{
		if(value==null || value.size()==0)
			this.authApplicationId = null;
		else
		{
			this.authApplicationId = new ArrayList<AuthApplicationId>();
			for(Long curr:value)
				this.authApplicationId.add(new AuthApplicationIdImpl(curr, null, null));
		}
	}
	
	public List<Long> getAcctApplicationId()
	{
		if(acctApplicationId == null)
			return null;
		
		List<Long> result=new ArrayList<Long>();
		for(AcctApplicationId curr:acctApplicationId)
			result.add(curr.getUnsigned());
		
		return result;
	}
	
	public void setAcctApplicationId(List<Long> value)
	{
		if(value==null || value.size()==0)
			this.acctApplicationId = null;
		else
		{
			this.acctApplicationId = new ArrayList<AcctApplicationId>();
			for(Long curr:value)
				this.acctApplicationId.add(new AcctApplicationIdImpl(curr, null, null));
		}
	}
	
	public List<VendorSpecificApplicationId> getVendorSpecificApplicationId()
	{
		return vendorSpecificApplicationId;
	}
	
	public void setVendorSpecificApplicationId(List<VendorSpecificApplicationId> value)
	{
		this.vendorSpecificApplicationId = value;
	}
}