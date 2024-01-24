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
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AccessRestrictionData;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AdjacentAccessRestrictionData;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.VisitedPLMNId;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1673L, vendorId = KnownVendorIDs.TGPP_ID)
public class AdjacentAccessRestrictionDataImpl extends DiameterGroupedAvpImpl implements AdjacentAccessRestrictionData
{
	private VisitedPLMNId visitedPLMNId;
	
	private AccessRestrictionData accessRestrictionData;
	
	protected AdjacentAccessRestrictionDataImpl() 
	{
	}
	
	public AdjacentAccessRestrictionDataImpl(ByteBuf visitedPLMNId,AccessRestrictionData accessRestrictionData)
	{
		if(visitedPLMNId==null)
			throw new IllegalArgumentException("Visited-PLMN-Id is required");
		
		if(accessRestrictionData==null)
			throw new IllegalArgumentException("Access-Restriction-Data is required");
		
		setVisitedPLMNId(visitedPLMNId);
		
		setAccessRestrictionData(accessRestrictionData);
	}
	
	public ByteBuf getVisitedPLMNId()
	{
		if(visitedPLMNId==null)
			return null;
		
		return visitedPLMNId.getValue();
	}
	
	public void setVisitedPLMNId(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("Visited-PLMN-Id is required");
		
		this.visitedPLMNId = new VisitedPLMNIdImpl(value, null, null);	
	}
	
	public AccessRestrictionData getAccessRestrictionData()
	{
		if(accessRestrictionData==null)
			return null;
		
		return accessRestrictionData;
	}
	
	public void setAccessRestrictionData(AccessRestrictionData value)
	{
		if(value==null)
			throw new IllegalArgumentException("Access-Restriction-Data is required");
		
		this.accessRestrictionData = value;	
	}
	
	@DiameterValidate
	public String validate()
	{
		if(visitedPLMNId==null)
			return "Visited-PLMN-Id is required";
		
		if(accessRestrictionData==null)
			return "Access-Restriction-Data is required";
		
		return null;
	}
}