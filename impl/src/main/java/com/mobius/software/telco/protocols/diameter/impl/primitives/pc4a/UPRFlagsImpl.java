package com.mobius.software.telco.protocols.diameter.impl.primitives.pc4a;
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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterBitmask32Impl;
import com.mobius.software.telco.protocols.diameter.primitives.pc4a.UPRFlags;

/**
*
* @author yulian oifa
*
*/
public class UPRFlagsImpl extends DiameterBitmask32Impl implements UPRFlags
{
	public UPRFlagsImpl()
	{
		super();
	}

	protected UPRFlagsImpl(Integer value)
	{
		super(value);
	}

	@Override
	public void setUpdateBit(boolean isOn)
	{
		setBitUnchecked(UPDATE_BIT, isOn);
	}

	@Override
	public boolean isUpdateBitSet()
	{
		return getBit(UPDATE_BIT);
	}

	@Override
	public void setRemovalBit(boolean isOn)
	{
		setBitUnchecked(REMOVAL_BIT, isOn);
	}

	@Override
	public boolean isRemovalBitSet()
	{
		return getBit(REMOVAL_BIT);
	}

	@Override
	public void setResetIDUpdateBit(boolean isOn)
	{
		setBitUnchecked(RESET_ID_UPDATE_BIT, isOn);
	}

	@Override
	public boolean isResetIDUpdateBitSet()
	{
		return getBit(RESET_ID_UPDATE_BIT);
	}

	@Override
	public void setResetIDRemovalBit(boolean isOn)
	{
		setBitUnchecked(RESET_ID_REMOVAL_BIT, isOn);
	}

	@Override
	public boolean isResetIDRemovalBitSet()
	{
		return getBit(RESET_ID_REMOVAL_BIT);
	}
}