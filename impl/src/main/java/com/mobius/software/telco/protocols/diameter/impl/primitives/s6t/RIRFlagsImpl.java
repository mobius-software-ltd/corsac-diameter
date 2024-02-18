package com.mobius.software.telco.protocols.diameter.impl.primitives.s6t;
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
import com.mobius.software.telco.protocols.diameter.primitives.s6t.RIRFlags;

/**
*
* @author yulian oifa
*
*/
public class RIRFlagsImpl extends DiameterBitmask32Impl implements RIRFlags
{
	public RIRFlagsImpl()
	{
		super();
	}

	protected RIRFlagsImpl(Integer value)
	{
		super(value);
	}

	@Override
	public void setGroupConfigurationInProgressBit(boolean isOn)
	{
		setBitUnchecked(GROUP_CONFIGURATION_IN_PROGRESS_BIT, isOn);
	}

	@Override
	public boolean isGroupConfigurationInProgressBitSet()
	{
		return getBit(GROUP_CONFIGURATION_IN_PROGRESS_BIT);
	}

	@Override
	public void setAllMonitoringEventsCancelledBit(boolean isOn)
	{
		setBitUnchecked(ALL_MONITORING_EVENTS_CANCELLED_BIT, isOn);
	}

	@Override
	public boolean isAllMonitoringEventsCancelledBitSet()
	{
		return getBit(ALL_MONITORING_EVENTS_CANCELLED_BIT);
	}

	@Override
	public void setChangeOfAuthorizedMonitoringEventsBit(boolean isOn)
	{
		setBitUnchecked(CHANGE_OF_AUTHORIZED_MONITORING_EVENTS_BIT, isOn);
	}

	@Override
	public boolean isChangeOfAuthorizedMonitoringEventsBitSet()
	{
		return getBit(CHANGE_OF_AUTHORIZED_MONITORING_EVENTS_BIT);
	}

	@Override
	public void setAllCommunicationPatternCancelledBit(boolean isOn)
	{
		setBitUnchecked(ALL_COMMUNICATION_PATTERN_CANCELLED_BIT, isOn);
	}

	@Override
	public boolean isAllCommunicationPatternCancelledBitSet()
	{
		return getBit(ALL_COMMUNICATION_PATTERN_CANCELLED_BIT);
	}

	@Override
	public void setAllSuggestedNetworkConfigurationCancelledBit(boolean isOn)
	{
		setBitUnchecked(ALL_SUGGESTED_NETWORK_CONFIGURATION_CANCELLED_BIT, isOn);
	}

	@Override
	public boolean isAllSuggestedNetworkConfigurationCancelledBitSet()
	{
		return getBit(ALL_SUGGESTED_NETWORK_CONFIGURATION_CANCELLED_BIT);
	}
}