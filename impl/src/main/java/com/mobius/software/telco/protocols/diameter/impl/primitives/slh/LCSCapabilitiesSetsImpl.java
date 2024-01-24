package com.mobius.software.telco.protocols.diameter.impl.primitives.slh;
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
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.slh.LCSCapabilitiesSets;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 2404L, vendorId = KnownVendorIDs.TGPP_ID)
public class LCSCapabilitiesSetsImpl extends DiameterBitmask32Impl implements LCSCapabilitiesSets
{
	public LCSCapabilitiesSetsImpl()
	{
		super();
	}

	public LCSCapabilitiesSetsImpl(Integer value)
	{
		super(value);
	}

	@Override
	public void setRel9899Bit(boolean isOn)
	{
		setBit(REL98_99_BIT, isOn);
	}

	@Override
	public boolean isRel9899Set()
	{
		return getBit(REL98_99_BIT);
	}

	@Override
	public void setRel4Bit(boolean isOn)
	{
		setBit(REL4_BIT, isOn);
	}

	@Override
	public boolean isRel4Set()
	{
		return getBit(REL4_BIT);
	}

	@Override
	public void setRel5Bit(boolean isOn)
	{
		setBit(REL5_BIT, isOn);
	}

	@Override
	public boolean isRel5Set()
	{
		return getBit(REL5_BIT);
	}

	@Override
	public void setRel6Bit(boolean isOn)
	{
		setBit(REL6_BIT, isOn);
	}

	@Override
	public boolean isRel6Set()
	{
		return getBit(REL6_BIT);				
	}

	@Override
	public void setRel7Bit(boolean isOn)
	{
		setBit(REL7_BIT, isOn);
	}

	@Override
	public boolean isRel7Set()
	{
		return getBit(REL7_BIT);
	}
}