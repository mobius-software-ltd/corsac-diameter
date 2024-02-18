package com.mobius.software.telco.protocols.diameter.impl.primitives.slg;
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
import com.mobius.software.telco.protocols.diameter.primitives.slg.AdditionalArea;
import com.mobius.software.telco.protocols.diameter.primitives.slg.AreaIdentification;
import com.mobius.software.telco.protocols.diameter.primitives.slg.AreaType;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class AdditionalAreaImpl extends DiameterGroupedAvpImpl implements AdditionalArea
{
	private AreaType areaType;
	
	private AreaIdentification areaIdentification;
	
	protected AdditionalAreaImpl() 
	{
	}
	
	public AdditionalAreaImpl(Long areaType, ByteBuf areaIdentification) throws MissingAvpException
	{
		setAreaType(areaType);
		
		setAreaIdentification(areaIdentification);		
	}
	
	public Long getAreaType()
	{
		if(areaType==null)
			return null;
		
		return areaType.getUnsigned();
	}
	
	public void setAreaType(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Area-Type is required", Arrays.asList(new DiameterAvp[] { new AreaTypeImpl() }));
			
		this.areaType = new AreaTypeImpl(value, null, null);						
	}
	
	public ByteBuf getAreaIdentification()
	{
		if(areaIdentification==null)
			return null;
		
		return areaIdentification.getValue();
	}
	
	public void setAreaIdentification(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Area-Identification is required", Arrays.asList(new DiameterAvp[] { new AreaIdentificationImpl() }));
		
		this.areaIdentification = new AreaIdentificationImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(areaType==null)
			return new MissingAvpException("Area-Type is required", Arrays.asList(new DiameterAvp[] { new AreaTypeImpl() }));
		
		if(areaIdentification==null)
			return new MissingAvpException("Area-Identification is required", Arrays.asList(new DiameterAvp[] { new AreaIdentificationImpl() }));
		
		return null;
	}
}