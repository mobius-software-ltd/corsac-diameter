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
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ReportingTrigger;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1626L, vendorId = KnownVendorIDs.TGPP_ID)
public class ReportingTriggerImpl extends DiameterBitmask32Impl implements ReportingTrigger
{
	public ReportingTriggerImpl()
	{
		super();
	}
	
	protected ReportingTriggerImpl(Integer value)
	{
		super(value);
	}

	@Override
	public void setPeriodicalBit(boolean isOn)
	{
		setBit(PERIODICAL_BIT, isOn);
	}

	@Override
	public boolean isPeriodicalBitSet()
	{
		return getBit(PERIODICAL_BIT);
	}

	@Override
	public void setEventA2Bit(boolean isOn)
	{
		setBit(EVENT_A2_BIT, isOn);
	}

	@Override
	public boolean isEventA2BitSet()
	{
		return getBit(EVENT_A2_BIT);
	}

	@Override
	public void setEvent1FBit(boolean isOn)
	{
		setBit(EVENT_1F_BIT, isOn);
	}

	@Override
	public boolean isEvent1FBitSet()
	{
		return getBit(EVENT_1F_BIT);
	}

	@Override
	public void setEvent1IBit(boolean isOn)
	{
		setBit(EVENT_1I_BIT, isOn);
	}

	@Override
	public boolean isEvent1IBitSet()
	{
		return getBit(EVENT_1I_BIT);
	}

	@Override
	public void setEventA2PeriodicBit(boolean isOn)
	{
		setBit(EVENT_A2_PERIODIC_BIT, isOn);
	}

	@Override
	public boolean isEventA2PeriodicBitSet()
	{
		return getBit(EVENT_A2_PERIODIC_BIT);
	}

	@Override
	public void setAllConfiguredRRMEventTriggersForLTEAndNRBit(boolean isOn)
	{
		setBit(ALL_CONFIGURED_RRM_EVENT_TRIGGERS_FOR_LTE_AND_NR_BIT, isOn);
	}

	@Override
	public boolean isAllConfiguredRRMEventTriggersForLTEAndNRBitSet()
	{
		return getBit(ALL_CONFIGURED_RRM_EVENT_TRIGGERS_FOR_LTE_AND_NR_BIT);
	}

	@Override
	public void setAllConfiguredRRMEventTriggersForUMTSBit(boolean isOn)
	{
		setBit(ALL_CONFIGURED_RRM_EVENT_TRIGGERS_FOR_UMTS_BIT, isOn);
	}

	@Override
	public boolean isAllConfiguredRRMEventTriggersForUMTSBitSet()
	{
		return getBit(ALL_CONFIGURED_RRM_EVENT_TRIGGERS_FOR_UMTS_BIT);
	}
}