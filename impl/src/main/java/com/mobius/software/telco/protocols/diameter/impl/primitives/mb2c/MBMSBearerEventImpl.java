package com.mobius.software.telco.protocols.diameter.impl.primitives.mb2c;
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
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.MBMSBearerEvent;

/**
*
* @author yulian oifa
*
*/
public class MBMSBearerEventImpl extends DiameterBitmask32Impl implements MBMSBearerEvent
{
	public MBMSBearerEventImpl()
	{
		super();
	}

	protected MBMSBearerEventImpl(Integer value)
	{
		super(value);
	}

	@Override
	public void setBearerTerminatedBit(boolean isOn)
	{
		setBitUnchecked(BEARER_TERMINATED_BIT, isOn);
	}

	@Override
	public boolean isBearerTerminatedBitSet()
	{
		return getBit(BEARER_TERMINATED_BIT);
	}

	@Override
	public void setBearerActivatedBit(boolean isOn)
	{
		setBitUnchecked(BEARER_ACTIVATED_BIT, isOn);
	}

	@Override
	public boolean isBearerActivatedBitSet()
	{
		return getBit(BEARER_ACTIVATED_BIT);
	}
	
	@Override
	public void setUserplaneEventBit(boolean isOn)
	{
		setBitUnchecked(USERPLANE_EVENT_BIT, isOn);
	}

	@Override
	public boolean isUserplaneEventBitSet()
	{
		return getBit(USERPLANE_EVENT_BIT);
	}

	@Override
	public void setBearerActivationFailureBit(boolean isOn)
	{
		setBitUnchecked(BEARER_ACTIVATION_FAILURE_BIT, isOn);
	}

	@Override
	public boolean isBearerActivationFailureBitSet()
	{
		return getBit(BEARER_ACTIVATION_FAILURE_BIT);
	}
}