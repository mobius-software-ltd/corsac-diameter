package com.mobius.software.telco.protocols.diameter.impl.primitives.rx;
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
import com.mobius.software.telco.protocols.diameter.primitives.rx.PreEmptionControlInfo;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 553L, vendorId = KnownVendorIDs.TGPP_ID)
public class PreEmptionControlInfoImpl extends DiameterBitmask32Impl implements PreEmptionControlInfo
{
	public PreEmptionControlInfoImpl()
	{
		super();
	}

	public PreEmptionControlInfoImpl(Integer value)
	{
		super(value);
	}

	@Override
	public void setMostRecentAddedFlowBit(boolean isOn)
	{
		setBit(MOST_RECENT_ADDED_FLOW_BIT, isOn);
	}

	@Override
	public boolean isMostRecentAddedFlowBitSet()
	{
		return getBit(MOST_RECENT_ADDED_FLOW_BIT);
	}

	@Override
	public void setLeastRecentAddedFlowBit(boolean isOn)
	{
		setBit(LEAST_RECENT_ADDED_FLOW_BIT, isOn);
	}

	@Override
	public boolean isLeastRecentAddedFlowBitSet()
	{
		return getBit(LEAST_RECENT_ADDED_FLOW_BIT);
	}

	@Override
	public void setHighestBandwidthFlowBit(boolean isOn)
	{
		setBit(HIGHEST_BANDWIDTH_FLOW_BIT, isOn);
	}

	@Override
	public boolean isHighestBandwidthFlowBitSet()
	{
		return getBit(HIGHEST_BANDWIDTH_FLOW_BIT);
	}
}