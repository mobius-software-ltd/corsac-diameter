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
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RATTypeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATType;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EDRXCycleLength;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EDRXCycleLengthValue;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1691L, vendorId = KnownVendorIDs.TGPP_ID)
public class EDRXCycleLengthImpl extends DiameterGroupedAvpImpl implements EDRXCycleLength
{
	private RATType ratType;
	
	private EDRXCycleLengthValue eDRXCycleLengthValue;
	
	protected EDRXCycleLengthImpl() 
	{
	}
	
	public EDRXCycleLengthImpl(RATTypeEnum ratType,ByteBuf eDRXCycleLengthValue)
	{
		if(ratType==null)
			throw new IllegalArgumentException("RAT-Type is required");
		
		if(eDRXCycleLengthValue==null)
			throw new IllegalArgumentException("eDRX-Cycle-Length-Value is required");
		
		this.ratType = new RATTypeImpl(ratType, null, null);
		
		this.eDRXCycleLengthValue = new EDRXCycleLengthValueImpl(eDRXCycleLengthValue, null, null);				
	}
	
	public RATTypeEnum getRATType()
	{
		if(ratType==null)
			return null;
		
		return ratType.getEnumerated(RATTypeEnum.class);
	}
	
	public void setRATType(RATTypeEnum value)
	{
		if(value==null)
			throw new IllegalArgumentException("RAT-Type is required");
		
		this.ratType = new RATTypeImpl(value, null, null);		
	}
	
	public ByteBuf getEDRXCycleLengthValue()
	{
		if(eDRXCycleLengthValue==null)
			return null;
		
		return eDRXCycleLengthValue.getValue();
	}
	
	public void setEDRXCycleLengthValue(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("eDRX-Cycle-Length-Value is required");
		
		this.eDRXCycleLengthValue = new EDRXCycleLengthValueImpl(value, null, null);	
	}
		
	@DiameterValidate
	public String validate()
	{
		if(ratType==null)
			return "RAT-Type is required";
		
		if(eDRXCycleLengthValue==null)
			return "eDRX-Cycle-Length-Value is required";
		
		return null;
	}
}