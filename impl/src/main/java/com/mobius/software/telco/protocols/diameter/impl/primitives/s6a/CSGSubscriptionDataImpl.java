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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5778.ServiceSelectionImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5778.ServiceSelection;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.CSGId;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.CSGSubscriptionData;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ExpirationDate;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.VisitedPLMNId;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1436L, vendorId = KnownVendorIDs.TGPP_ID)
public class CSGSubscriptionDataImpl extends DiameterGroupedAvpImpl implements CSGSubscriptionData
{
	private CSGId csgId;
	
	private ExpirationDate expirationDate;
	
	private List<ServiceSelection> serviceSelection;
	
	private VisitedPLMNId visitedPLMNId;
	
	protected CSGSubscriptionDataImpl()
	{
		
	}
	
	public CSGSubscriptionDataImpl(Long csgId)
	{
		if(csgId==null)
			throw new IllegalArgumentException("CSG-Id is required");
		
		this.csgId = new CSGIdImpl(csgId, null, null);
	}
	
	public Long getCSGId()
	{
		if(csgId == null)
			return null;
		
		return csgId.getUnsigned();
	}
	
	public void setCSGId(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("CSG-Id is required");
		
		this.csgId = new CSGIdImpl(value, null, null);
	}
	
	public Date getExpirationDate()
	{
		if(expirationDate == null)
			return null;
		
		return expirationDate.getDateTime();
	}
	
	public void setExpirationDate(Date value)
	{
		if(value == null)
			this.expirationDate = null;
		else
			this.expirationDate = new ExpirationDateImpl(value, null, null);
	}
	
	public List<String> getServiceSelection()
	{
		if(serviceSelection == null || serviceSelection.size()==0)
			return null;
		
		List<String> result = new ArrayList<String>();
		for(ServiceSelection curr:serviceSelection)
			result.add(curr.getString());
		
		return result;
	}
	
	public void setServiceSelection(List<String> value)
	{
		if(value==null || value.size()==0)
			this.serviceSelection = null;
		else
		{
			this.serviceSelection = new ArrayList<ServiceSelection>();
			for(String curr:value)
				this.serviceSelection.add(new ServiceSelectionImpl(curr, null, null));
		}
	}
	
	public ByteBuf getVisitedPLMNId()
	{
		if(visitedPLMNId == null)
			return null;
		
		return visitedPLMNId.getValue();
	}
	
	public void setVisitedPLMNId(ByteBuf value)
	{
		if(value == null)
			this.visitedPLMNId = null;
		else
			this.visitedPLMNId = new VisitedPLMNIdImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(csgId==null)
			return "CSG-Id is required";
		
		return null;
	}
}