package com.mobius.software.telco.protocols.diameter.impl.primitives.np;
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
import com.mobius.software.telco.protocols.diameter.primitives.np.CongestionLevelRange;

/**
*
* @author yulian oifa
*
*/
public class CongestionLevelRangeImpl extends DiameterBitmask32Impl implements CongestionLevelRange
{
	public CongestionLevelRangeImpl()
	{
		super();
	}

	public CongestionLevelRangeImpl(Integer value)
	{
		super(value);
	}

	@Override
	public void setNoCongestionBit(boolean isOn)
	{
		setBitUnchecked(NO_CONGESTION_BIT, isOn);		
	}

	@Override
	public boolean isNoCongestionBitSet()
	{
		return getBit(NO_CONGESTION_BIT);
	}

	@Override
	public void setCongestionLevelBit(int level, boolean isOn) throws InvalidAvpValueException
	{
		if(level<1)
			throw new InvalidAvpValueException("Invalid level(should be 1 to 31", Arrays.asList(new DiameterAvp[] { this }));
		
		setBitUnchecked(level, isOn);
	}

	@Override
	public boolean isCongestionLevelBitSet(int level) throws InvalidAvpValueException
	{
		if(level<1)
			throw new InvalidAvpValueException("Invalid level(should be 1 to 31", Arrays.asList(new DiameterAvp[] { this }));
		
		return getBit(level);
	}
}