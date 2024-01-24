package com.mobius.software.telco.protocols.diameter.impl.primitives.s6c;
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
import com.mobius.software.telco.protocols.diameter.primitives.s6c.MWDStatus;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3312L, vendorId = KnownVendorIDs.TGPP_ID)
public class MWDStatusImpl extends DiameterBitmask32Impl implements MWDStatus
{
	public MWDStatusImpl()
	{
		super();
	}

	public MWDStatusImpl(Integer value)
	{
		super(value);
	}

	@Override
	public void setMNRFBit(boolean isOn)
	{
		setBit(MNRF_BIT, isOn);
	}

	@Override
	public boolean isMNRFBitSet()
	{
		return getBit(MNRF_BIT);
	}

	@Override
	public void setMCEFFlowBit(boolean isOn)
	{
		setBit(MCEF_BIT, isOn);
	}

	@Override
	public boolean isMCEFBitSet()
	{
		return getBit(MCEF_BIT);
	}

	@Override
	public void setMNRGBit(boolean isOn)
	{
		setBit(MNRG_BIT, isOn);
	}

	@Override
	public boolean isMNRGBitSet()
	{
		return getBit(MNRG_BIT);
	}

	@Override
	public void setMNRG5GBit(boolean isOn)
	{
		setBit(MNRG5G_BIT, isOn);
	}

	@Override
	public boolean isMNRG5GBitSet()
	{
		return getBit(MNRG5G_BIT);
	}
}