package com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5777;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterBitmask32Impl;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.DayOfMonthMask;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 564L, vendorId = -1L)
public class DayOfMonthMaskImpl extends DiameterBitmask32Impl implements DayOfMonthMask
{
	public DayOfMonthMaskImpl() 
	{
		super();
	}
	
	protected DayOfMonthMaskImpl(Integer value) 
	{
		super(value);
	}

	@Override
	public void setDayBit(int dom, boolean isOn)
	{
		if(dom<0 || dom>31)
			throw new RuntimeException("Invalid day of month(should be between 1 and 31)");
		
		setBit(dom-1, isOn);
	}

	@Override
	public boolean isDayBitSet(int dom)
	{
		if(dom<0 || dom>31)
			throw new RuntimeException("Invalid day of month(should be between 1 and 31)");		
		
		return getBit(dom-1);
	}
}