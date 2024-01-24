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
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterBitmask32Impl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.CLRFlags;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1638L, vendorId = KnownVendorIDs.TGPP_ID)
public class CLRFlagsImpl extends DiameterBitmask32Impl implements CLRFlags
{
	public CLRFlagsImpl()
	{
		super();
	}
	
	protected CLRFlagsImpl(Integer value)
	{
		super(value);
	}

	@Override
	public void setS6AS6DIndicatorBit(boolean isOn)
	{
		setBit(S6A_S6D_INDICATOR_BIT, isOn);
	}

	@Override
	public boolean isS6AS6DIndicatorBitSet()
	{
		return getBit(S6A_S6D_INDICATOR_BIT);
	}

	@Override
	public void setReattachedRequiredBit(boolean isOn)
	{
		setBit(REATTACH_REQUIRED_BIT, isOn);
	}

	@Override
	public boolean isReattachedRequiredBitSet()
	{
		return getBit(REATTACH_REQUIRED_BIT);
	}
}