package com.mobius.software.telco.protocols.diameter.impl.primitives.s6t;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.VisitedPLMNIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.VisitedPLMNId;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.EnhancedCoverageRestriction;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.EnhancedCoverageRestrictionData;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class EnhancedCoverageRestrictionDataImpl extends DiameterGroupedAvpImpl implements EnhancedCoverageRestrictionData
{
	private EnhancedCoverageRestriction enhancedCoverageRestriction;
	
	private VisitedPLMNId visitedPLMNId;
	
	protected EnhancedCoverageRestrictionDataImpl()
	{
		
	}
	
	public EnhancedCoverageRestrictionDataImpl(EnhancedCoverageRestriction enhancedCoverageRestriction) throws MissingAvpException
	{
		setEnhancedCoverageRestriction(enhancedCoverageRestriction);
	}
	
	public EnhancedCoverageRestriction getEnhancedCoverageRestriction()
	{
		return enhancedCoverageRestriction;
	}
	
	public void setEnhancedCoverageRestriction(EnhancedCoverageRestriction value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Enhanced-Coverage-Restriction is required", Arrays.asList(new DiameterAvp[] { new EnhancedCoverageRestrictionImpl() }));
			
		this.enhancedCoverageRestriction = value;		
	}
	
	public ByteBuf getVisitedPLMNId()
	{
		if(visitedPLMNId == null)
			return null;
		
		return visitedPLMNId.getValue();
	}
	
	public void setVisitedPLMNId(ByteBuf value)
	{
		if(value==null)
			this.visitedPLMNId = null;
		else
			this.visitedPLMNId = new VisitedPLMNIdImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(enhancedCoverageRestriction==null)
			return new MissingAvpException("Enhanced-Coverage-Restriction is required", Arrays.asList(new DiameterAvp[] { new EnhancedCoverageRestrictionImpl() }));
		
		return null;
	}
}