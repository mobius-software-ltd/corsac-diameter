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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.slg.Area;
import com.mobius.software.telco.protocols.diameter.primitives.slg.AreaIdentification;
import com.mobius.software.telco.protocols.diameter.primitives.slg.AreaType;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 2535L, vendorId = KnownVendorIDs.TGPP_ID)
public class AreaImpl extends DiameterGroupedAvpImpl implements Area
{
	private AreaType areaType;
	
	private AreaIdentification areaIdentification;
	
	protected AreaImpl() 
	{
	}
	
	public AreaImpl(Long areaType, ByteBuf areaIdentification)
	{
		if(areaType==null)
			throw new IllegalArgumentException("Area-Type is required");
		
		if(areaIdentification==null)
			throw new IllegalArgumentException("Area-Identification is required");
		
		this.areaType = new AreaTypeImpl(areaType, null, null);				
		
		this.areaIdentification = new AreaIdentificationImpl(areaIdentification, null, null);
	}
	
	public Long getAreaType()
	{
		if(areaType==null)
			return null;
		
		return areaType.getUnsigned();
	}
	
	public void setAreaType(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("Area-Type is required");
		
		this.areaType = new AreaTypeImpl(value, null, null);						
	}
	
	public ByteBuf getAreaIdentification()
	{
		if(areaIdentification==null)
			return null;
		
		return areaIdentification.getValue();
	}
	
	public void setAreaIdentification(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("Area-Identification is required");
		
		this.areaIdentification = new AreaIdentificationImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(areaType==null)
			return "Area-Type is required";
		
		if(areaIdentification==null)
			return "Area-Identification is required";
		
		return null;
	}
}