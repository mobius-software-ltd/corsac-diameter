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
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterBitmask64Impl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.BroadcastLocationAssistanceDataTypes;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1700L, vendorId = KnownVendorIDs.TGPP_ID)
public class BroadcastLocationAssistanceDataTypesImpl extends DiameterBitmask64Impl implements BroadcastLocationAssistanceDataTypes
{
	public BroadcastLocationAssistanceDataTypesImpl()
	{
		super();
	}
	
	protected BroadcastLocationAssistanceDataTypesImpl(Long value)
	{
		super(value);
	}

	@Override
	public void setPositioningSIBBit(int type, int bit, boolean isOn)
	{
		if(bit<1)
			throw new RuntimeException("Invalid bit(should be positive)");
					
		switch(type)
		{
			case 1:
				if(bit>8)
					throw new RuntimeException("Invalid bit(should be 1 to 8)");
			
				if(bit<8)
					setBit(bit-1, isOn);
				else
					setBit(27, isOn);
				break;
			case 2:
				if(bit>25)
					throw new RuntimeException("Invalid bit(should be 1 to 25)");
			
				if(bit<20)
					setBit(bit+6, isOn);
				else
					setBit(bit+8, isOn);
				break;
			case 3:
				if(bit!=1)
					throw new RuntimeException("Invalid bit(should be 1)");
				
				setBit(26, isOn);
				break;
			case 4:
				if(bit!=1)
					throw new RuntimeException("Invalid bit(should be 1)");
				
				setBit(34, isOn);
				break;
			case 5:
				if(bit!=1)
					throw new RuntimeException("Invalid bit(should be 1)");
				
				setBit(35, isOn);
				break;
			default:
				throw new RuntimeException("Invalid type(should be 1 to 5)");
				
		}
	}

	@Override
	public boolean isPositioningSIBBitSet(int type, int bit)
	{
		if(bit<1)
			throw new RuntimeException("Invalid bit(should be positive)");
					
		switch(type)
		{
			case 1:
				if(bit>8)
					throw new RuntimeException("Invalid bit(should be 1 to 8)");
			
				if(bit<8)
					return getBit(bit-1);
				else
					return getBit(27);
			case 2:
				if(bit>25)
					throw new RuntimeException("Invalid bit(should be 1 to 25)");
			
				if(bit<20)
					return getBit(bit+6);
				else
					return getBit(bit+8);
			case 3:
				if(bit!=1)
					throw new RuntimeException("Invalid bit(should be 1)");
				
				return getBit(26);
			case 4:
				if(bit!=1)
					throw new RuntimeException("Invalid bit(should be 1)");
				
				return getBit(34);
			case 5:
				if(bit!=1)
					throw new RuntimeException("Invalid bit(should be 1)");
				
				return getBit(35);
			default:
				throw new RuntimeException("Invalid type(should be 1 to 5)");
				
		}
	}
}