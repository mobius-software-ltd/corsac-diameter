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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterBitmask32Impl;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.HPLMNODB;

/**
*
* @author yulian oifa
*
*/
public class HPLMNODBImpl extends DiameterBitmask32Impl implements HPLMNODB
{
	public HPLMNODBImpl()
	{
		super();
	}
	
	protected HPLMNODBImpl(Integer value)
	{
		super(value);
	}

	@Override
	public void setType1Bit(boolean isOn)
	{
		setBitUnchecked(TYPE_1_BIT, isOn);
	}

	@Override
	public boolean isType1BitSet()
	{
		return getBit(TYPE_1_BIT);
	}

	@Override
	public void setType2Bit(boolean isOn)
	{
		setBitUnchecked(TYPE_2_BIT, isOn);
	}

	@Override
	public boolean isType2BitSet()
	{
		return getBit(TYPE_2_BIT);
	}

	@Override
	public void setType3Bit(boolean isOn)
	{
		setBitUnchecked(TYPE_3_BIT, isOn);
	}

	@Override
	public boolean isType3BitSet()
	{
		return getBit(TYPE_3_BIT);
	}

	@Override
	public void setType4Bit(boolean isOn)
	{
		setBitUnchecked(TYPE_4_BIT, isOn);
	}

	@Override
	public boolean isType4BitSet()
	{
		return getBit(TYPE_4_BIT);
	}
}