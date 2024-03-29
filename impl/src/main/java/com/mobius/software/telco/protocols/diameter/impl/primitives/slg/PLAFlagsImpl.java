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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterBitmask32Impl;
import com.mobius.software.telco.protocols.diameter.primitives.slg.PLAFlags;

/**
*
* @author yulian oifa
*
*/
public class PLAFlagsImpl extends DiameterBitmask32Impl implements PLAFlags
{
	public PLAFlagsImpl()
	{
		super();
	}

	protected PLAFlagsImpl(Integer value)
	{
		super(value);
	}

	@Override
	public void setDeferredMTLRResponseIndicatorBit(boolean isOn)
	{
		setBitUnchecked(DEFERRED_MTLR_RESPONSE_INDICATOR_BIT, isOn);
	}

	@Override
	public boolean isDeferredMTLRResponseIndicatorBitSet()
	{
		return getBit(DEFERRED_MTLR_RESPONSE_INDICATOR_BIT);
	}

	@Override
	public void setMOLRShortCircuitIndicatorBit(boolean isOn)
	{
		setBitUnchecked(MOLR_SHORT_CIRCUIT_INDICATOR_BIT, isOn);
	}

	@Override
	public boolean isMOLRShortCircuitIndicatorBitSet()
	{
		return getBit(MOLR_SHORT_CIRCUIT_INDICATOR_BIT);
	}

	@Override
	public void setOptimizedLCSProcPerformedBit(boolean isOn)
	{
		setBitUnchecked(OPTIMIZED_LCS_PROC_PERFOMED_BIT, isOn);
	}

	@Override
	public boolean isOptimizedLCSProcPerformedBitSet()
	{
		return getBit(OPTIMIZED_LCS_PROC_PERFOMED_BIT);
	}

	@Override
	public void setUETransientlyNotReachableIndicatorBit(boolean isOn)
	{
		setBitUnchecked(UE_TRANSIENTLY_NOT_REACHABLE_INDICATOR_BIT, isOn);
	}

	@Override
	public boolean isUETransientlyNotReachableIndicatorBitSet()
	{
		return getBit(UE_TRANSIENTLY_NOT_REACHABLE_INDICATOR_BIT);
	}
}