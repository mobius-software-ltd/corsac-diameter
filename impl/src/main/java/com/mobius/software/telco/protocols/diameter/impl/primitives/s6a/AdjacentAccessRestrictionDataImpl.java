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

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AccessRestrictionData;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AdjacentAccessRestrictionData;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.VisitedPLMNId;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class AdjacentAccessRestrictionDataImpl extends DiameterGroupedAvpImpl implements AdjacentAccessRestrictionData
{
	private VisitedPLMNId visitedPLMNId;
	
	private AccessRestrictionData accessRestrictionData;
	
	protected AdjacentAccessRestrictionDataImpl() 
	{
	}
	
	public AdjacentAccessRestrictionDataImpl(ByteBuf visitedPLMNId,AccessRestrictionData accessRestrictionData) throws MissingAvpException
	{
		setVisitedPLMNId(visitedPLMNId);
		
		setAccessRestrictionData(accessRestrictionData);
	}
	
	public ByteBuf getVisitedPLMNId()
	{
		if(visitedPLMNId==null)
			return null;
		
		return visitedPLMNId.getValue();
	}
	
	public void setVisitedPLMNId(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Visited-PLMN-Id is required", Arrays.asList(new DiameterAvp[] { new VisitedPLMNIdImpl() }));
			
		this.visitedPLMNId = new VisitedPLMNIdImpl(value, null, null);	
	}
	
	public AccessRestrictionData getAccessRestrictionData()
	{
		if(accessRestrictionData==null)
			return null;
		
		return accessRestrictionData;
	}
	
	public void setAccessRestrictionData(AccessRestrictionData value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Access-Restriction-Data is required", Arrays.asList(new DiameterAvp[] { new AccessRestrictionDataImpl() })); 
			
		this.accessRestrictionData = value;	
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(visitedPLMNId==null)
			return new MissingAvpException("Visited-PLMN-Id is required", Arrays.asList(new DiameterAvp[] { new VisitedPLMNIdImpl() }));
		
		if(accessRestrictionData==null)
			return new MissingAvpException("Access-Restriction-Data is required", Arrays.asList(new DiameterAvp[] { new AccessRestrictionDataImpl() }));
		
		return null;
	}
}