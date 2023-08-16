package com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol;
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
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcUnitType;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcUnitTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.GSUPoolIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.GSUPoolReference;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UnitValue;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 457L, vendorId = -1)
public class GSUPoolReferenceImpl implements GSUPoolReference
{
	private GSUPoolIdentifier gsuPoolIdentifier;
	
	private CcUnitType ccUnitType;
	
	private UnitValue unitValue;
	
	protected GSUPoolReferenceImpl() 
	{
	}
	
	public GSUPoolReferenceImpl(Long gsuPoolIdentifier,CcUnitTypeEnum ccUnitType,UnitValue unitValue)
	{
		if(gsuPoolIdentifier==null)
			throw new IllegalArgumentException("G-S-U-Pool-Identifier is required");
		
		if(ccUnitType==null)
			throw new IllegalArgumentException("CC-Unit-Type is required");
		
		if(unitValue==null)
			throw new IllegalArgumentException("Unit-Value is required");
		
		this.gsuPoolIdentifier = new GSUPoolIdentifierImpl(gsuPoolIdentifier, null, null);
		
		this.ccUnitType = new CcUnitTypeImpl(ccUnitType, null, null);
		
		this.unitValue = unitValue;
	}
	
	public Long getGSUPoolIdentifier()
	{
		if(gsuPoolIdentifier==null)
			return null;
		
		return gsuPoolIdentifier.getUnsigned();
	}
	
	public void setGSUPoolIdentifier(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("G-S-U-Pool-Identifier is required");
		
		this.gsuPoolIdentifier = new GSUPoolIdentifierImpl(value, null, null);		
	}
	
	public CcUnitTypeEnum getCCUnitType()
	{
		if(ccUnitType == null)
			return null;
		
		return ccUnitType.getEnumerated(CcUnitTypeEnum.class);
	}
	
	public void setCCUnitType(CcUnitTypeEnum value)
	{
		if(value==null)
			throw new IllegalArgumentException("CC-Unit-Type is required");
		
		this.ccUnitType = new CcUnitTypeImpl(value, null, null);
	}
	
	public UnitValue getUnitValue()
	{
		return this.unitValue;
	}
	
	public void setUnitValue(UnitValue value)
	{
		if(value==null)
			throw new IllegalArgumentException("Unit-Value is required");
		
		this.unitValue = value;
	}
	
	@DiameterValidate
	public String validate()
	{
		if(gsuPoolIdentifier==null)
			return "G-S-U-Pool-Identifier is required";
		
		if(ccUnitType==null)
			return "CC-Unit-Type is required";
		
		if(unitValue==null)
			return "Unit-Value is required";
		
		return null;
	}
}