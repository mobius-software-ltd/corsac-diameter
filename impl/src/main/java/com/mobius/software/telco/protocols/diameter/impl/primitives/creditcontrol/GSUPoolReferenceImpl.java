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

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
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
public class GSUPoolReferenceImpl extends DiameterAvpImpl implements GSUPoolReference
{
	private GSUPoolIdentifier gsuPoolIdentifier;
	
	private CcUnitType ccUnitType;
	
	private UnitValue unitValue;
	
	protected GSUPoolReferenceImpl() 
	{
	}
	
	public GSUPoolReferenceImpl(Long gsuPoolIdentifier,CcUnitTypeEnum ccUnitType,UnitValue unitValue) throws MissingAvpException
	{
		setGSUPoolIdentifier(gsuPoolIdentifier);
		
		setCCUnitType(ccUnitType);
		
		setUnitValue(unitValue);		
	}
	
	public Long getGSUPoolIdentifier()
	{
		if(gsuPoolIdentifier==null)
			return null;
		
		return gsuPoolIdentifier.getUnsigned();
	}
	
	public void setGSUPoolIdentifier(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("G-S-U-Pool-Identifier is required", Arrays.asList(new DiameterAvp[] { new GSUPoolIdentifierImpl() }));
			
		this.gsuPoolIdentifier = new GSUPoolIdentifierImpl(value, null, null);		
	}
	
	public CcUnitTypeEnum getCCUnitType()
	{
		if(ccUnitType == null)
			return null;
		
		return ccUnitType.getEnumerated(CcUnitTypeEnum.class);
	}
	
	public void setCCUnitType(CcUnitTypeEnum value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("CC-Unit-Type is required", Arrays.asList(new DiameterAvp[] { new CcUnitTypeImpl() }));
			
		this.ccUnitType = new CcUnitTypeImpl(value, null, null);
	}
	
	public UnitValue getUnitValue()
	{
		return this.unitValue;
	}
	
	public void setUnitValue(UnitValue value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Unit-Value is required", Arrays.asList(new DiameterAvp[] { new UnitValueImpl() })); 
			
		this.unitValue = value;
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(gsuPoolIdentifier==null)
			return new MissingAvpException("G-S-U-Pool-Identifier is required", Arrays.asList(new DiameterAvp[] { new GSUPoolIdentifierImpl() }));
		
		if(ccUnitType==null)
			return new MissingAvpException("CC-Unit-Type is required", Arrays.asList(new DiameterAvp[] { new CcUnitTypeImpl() }));
		
		if(unitValue==null)
			return new MissingAvpException("Unit-Value is required", Arrays.asList(new DiameterAvp[] { new UnitValueImpl() }));
		
		return null;
	}
}