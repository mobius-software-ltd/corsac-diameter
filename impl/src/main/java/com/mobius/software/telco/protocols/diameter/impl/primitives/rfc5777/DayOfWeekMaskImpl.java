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

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.exceptions.InvalidAvpValueException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterBitmask32Impl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.DayOfWeekMask;

/**
*
* @author yulian oifa
*
*/
public class DayOfWeekMaskImpl extends DiameterBitmask32Impl implements DayOfWeekMask
{
	public DayOfWeekMaskImpl() 
	{
		super();
	}
	
	protected DayOfWeekMaskImpl(Integer value) 
	{
		super(value);
	}

	@Override
	public void setDayBit(int dom, boolean isOn) throws InvalidAvpValueException
	{
		if(dom<0 || dom>7)
			throw new InvalidAvpValueException("Invalid day of week(should be between 1 and 7)", Arrays.asList(new DiameterAvp[] { this }));
		
		setBitUnchecked(dom-1, isOn);
	}

	@Override
	public boolean isDayBitSet(int dom) throws InvalidAvpValueException
	{
		if(dom<0 || dom>7)
			throw new InvalidAvpValueException("Invalid day of week(should be between 1 and 7)", Arrays.asList(new DiameterAvp[] { this }));		
		
		return getBit(dom-1);
	}
}