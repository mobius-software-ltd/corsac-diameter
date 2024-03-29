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
import com.mobius.software.telco.protocols.diameter.primitives.slg.PLRFlags;

/**
*
* @author yulian oifa
*
*/
public class PLRFlagsImpl extends DiameterBitmask32Impl implements PLRFlags
{
	public PLRFlagsImpl()
	{
		super();
	}

	protected PLRFlagsImpl(Integer value)
	{
		super(value);
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
	public void setOptimizedLCSProcReqBit(boolean isOn)
	{
		setBitUnchecked(OPTIMIZED_LCS_PROC_REQ_BIT, isOn);
	}

	@Override
	public boolean isOptimizedLCSProcReqBitSet()
	{
		return getBit(OPTIMIZED_LCS_PROC_REQ_BIT);
	}

	@Override
	public void setDelayedLocationReportingSupportIndicatorBit(boolean isOn)
	{
		setBitUnchecked(DELAYED_LOCATION_REPORTING_SUPPORT_INDICATOR_BIT, isOn);
	}

	@Override
	public boolean isDelayedLocationReportingSupportIndicatorBitSet()
	{
		return getBit(DELAYED_LOCATION_REPORTING_SUPPORT_INDICATOR_BIT);
	}
}