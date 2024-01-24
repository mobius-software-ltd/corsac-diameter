package com.mobius.software.telco.protocols.diameter.impl.primitives.slg;
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
import com.mobius.software.telco.protocols.diameter.primitives.slg.DeferredLocationType;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 2532L, vendorId = KnownVendorIDs.TGPP_ID)
public class DeferredLocationTypeImpl extends DiameterBitmask32Impl implements DeferredLocationType
{
	public DeferredLocationTypeImpl()
	{
		super();
	}

	protected DeferredLocationTypeImpl(Integer value)
	{
		super(value);
	}

	@Override
	public void setUEAvailableBit(boolean isOn)
	{
		setBit(UE_AVAILABLE_BIT, isOn);
	}

	@Override
	public boolean isUEAvailableBitSet()
	{
		return getBit(UE_AVAILABLE_BIT);
	}

	@Override
	public void setEnteringIntoAreaBit(boolean isOn)
	{
		setBit(ENTERING_INTO_AREA_BIT, isOn);
	}

	@Override
	public boolean isEnteringIntoAreaBitSet()
	{
		return getBit(ENTERING_INTO_AREA_BIT);
	}

	@Override
	public void setLeavingFromAreaBit(boolean isOn)
	{
		setBit(LEAVING_FROM_AREA_BIT, isOn);
	}

	@Override
	public boolean isLeavingFromAreaBitSet()
	{
		return getBit(LEAVING_FROM_AREA_BIT);
	}

	@Override
	public void setBeingInsideAreaBit(boolean isOn)
	{
		setBit(BEING_INSIDE_AREA_BIT, isOn);
	}

	@Override
	public boolean isBeingInsideAreaBitSet()
	{
		return getBit(BEING_INSIDE_AREA_BIT);
	}

	@Override
	public void setPeriodicLDRBit(boolean isOn)
	{
		setBit(PERIOD_LDR_BIT, isOn);
	}

	@Override
	public boolean isPeriodicLDRBitSet()
	{
		return getBit(PERIOD_LDR_BIT);
	}

	@Override
	public void setMotionEventBit(boolean isOn)
	{
		setBit(MOTION_EVENT_BIT, isOn);
	}

	@Override
	public boolean isMotionEventBitSet()
	{
		return getBit(MOTION_EVENT_BIT);
	}

	@Override
	public void setLDRActivatedBit(boolean isOn)
	{
		setBit(LDR_ACTIVATED_BIT, isOn);
	}

	@Override
	public boolean isLDRActivatedBitSet()
	{
		return getBit(LDR_ACTIVATED_BIT);
	}

	@Override
	public void setMaximumIntervalExpirationBit(boolean isOn)
	{
		setBit(MAXIMUM_INTERVAL_EXPIRATION_BIT, isOn);
	}

	@Override
	public boolean isMaximumIntervalExpirationBitSet()
	{
		return getBit(MAXIMUM_INTERVAL_EXPIRATION_BIT);
	}
}