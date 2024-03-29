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
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RATTypeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATType;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EDRXRelatedRAT;

/**
*
* @author yulian oifa
*
*/
public class EDRXRelatedRATImpl extends DiameterGroupedAvpImpl implements EDRXRelatedRAT
{
	private List<RATType> ratType;
	
	protected EDRXRelatedRATImpl() 
	{
	}
	
	public EDRXRelatedRATImpl(List<RATTypeEnum> ratType) throws MissingAvpException
	{
		setRATType(ratType);					
	}
	
	public List<RATTypeEnum> getRATType()
	{
		if(ratType==null || ratType.size()==0)
			return null;
		
		List<RATTypeEnum> result = new ArrayList<RATTypeEnum>();
		for(RATType curr:ratType)
			result.add(curr.getEnumerated(RATTypeEnum.class));
		
		return result;
	}
	
	public void setRATType(List<RATTypeEnum> value) throws MissingAvpException
	{
		if(ratType==null || ratType.size()==0)
			throw new MissingAvpException("RAT-Type is required", Arrays.asList(new DiameterAvp[] { new RATTypeImpl() }));
					
		this.ratType = new ArrayList<RATType>();
		for(RATTypeEnum curr:value)
			this.ratType.add(new RATTypeImpl(curr, null, null));
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(ratType==null || ratType.size()==0)
			return new MissingAvpException("RAT-Type is required", Arrays.asList(new DiameterAvp[] { new RATTypeImpl() }));
		
		return null;
	}
}