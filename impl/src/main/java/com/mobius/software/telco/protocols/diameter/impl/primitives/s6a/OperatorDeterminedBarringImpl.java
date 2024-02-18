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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterBitmask32Impl;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.OperatorDeterminedBarring;

/**
*
* @author yulian oifa
*
*/
public class OperatorDeterminedBarringImpl extends DiameterBitmask32Impl implements OperatorDeterminedBarring
{
	public OperatorDeterminedBarringImpl()
	{
		super();
	}
	
	protected OperatorDeterminedBarringImpl(Integer value)
	{
		super(value);
	}

	@Override
	public void setAllPacketOrientedServicesBarredBit(boolean isOn)
	{
		setBitUnchecked(ALL_PACKET_ORIENTED_SERVICES_BARRED_BIT, isOn);
	}

	@Override
	public boolean isAllPacketOrientedServicesBarredBitSet()
	{
		return getBit(ALL_PACKET_ORIENTED_SERVICES_BARRED_BIT);
	}

	@Override
	public void setRoamerAccessHPLMNAPBarredBit(boolean isOn)
	{
		setBitUnchecked(ROAMER_ACCESS_HPLMN_AP_BARRED_BIT, isOn);
	}

	@Override
	public boolean isRoamerAccessHPLMNAPBarredBitSet()
	{
		return getBit(ROAMER_ACCESS_HPLMN_AP_BARRED_BIT);
	}

	@Override
	public void setRoamerAccessVPLMNAPBarredBit(boolean isOn)
	{
		setBitUnchecked(ROAMER_ACCESS_VPLMN_AP_BARRED_BIT, isOn);
	}

	@Override
	public boolean isRoamerAccessVPLMNAPBarredBitSet()
	{
		return getBit(ROAMER_ACCESS_VPLMN_AP_BARRED_BIT);
	}

	@Override
	public void setBarringAllOutgoingCallsBit(boolean isOn)
	{
		setBitUnchecked(BARRING_ALL_OUTGOING_CALLS_BIT, isOn);
	}

	@Override
	public boolean isBarringAllOutgoingCallsBitSet()
	{
		return getBit(BARRING_ALL_OUTGOING_CALLS_BIT);				
	}

	@Override
	public void setBarringAllOutgoingInternationalCallsBit(boolean isOn)
	{
		setBitUnchecked(BARRING_ALL_OUTGOING_INTERNATIONAL_CALLS_BIT, isOn);
	}

	@Override
	public boolean isBarringAllOutgoingInternationalCallsBitSet()
	{
		return getBit(BARRING_ALL_OUTGOING_INTERNATIONAL_CALLS_BIT);
	}

	@Override
	public void setBarringAllOutgoingInternationalButHomeCallsBit(boolean isOn)
	{
		setBitUnchecked(BARRING_ALL_OUTGOING_INTERNATIONAL_BUT_HOME_CALLS_BIT, isOn);
	}

	@Override
	public boolean isBarringAllOutgoingInternationalButHomeCallsBitSet()
	{
		return getBit(BARRING_ALL_OUTGOING_INTERNATIONAL_BUT_HOME_CALLS_BIT);
	}

	@Override
	public void setBarringAllOutgoingInterzonalCallsBit(boolean isOn)
	{
		setBitUnchecked(BARRING_ALL_OUTGOING_INTERZONAL_CALLS_BIT, isOn);
	}

	@Override
	public boolean isBarringAllOutgoingInterzonalCallsBitSet()
	{
		return getBit(BARRING_ALL_OUTGOING_INTERZONAL_CALLS_BIT);
	}

	@Override
	public void setBarringAllOutgoingInterzonalButHomeCallsBit(boolean isOn)
	{
		setBitUnchecked(BARRING_ALL_OUTGOING_INTERZONAL_BUT_HOME_CALLS_BIT, isOn);
	}

	@Override
	public boolean isBarringAllOutgoingInterzonalButHomeCallsBitSet()
	{
		return getBit(BARRING_ALL_OUTGOING_INTERZONAL_BUT_HOME_CALLS_BIT);
	}

	@Override
	public void setBarringAllOutgoingInternationalButHomeAndInterzonalCallsBit(boolean isOn)
	{
		setBitUnchecked(BARRING_ALL_OUTGOING_INTERNATIONAL_BUT_HOME_AND_INTERZONAL_CALLS_BIT, isOn);
	}

	@Override
	public boolean isBarringAllOutgoingInternationalButHomeAndInterzonalCallsBitSet()
	{
		return getBit(BARRING_ALL_OUTGOING_INTERNATIONAL_BUT_HOME_AND_INTERZONAL_CALLS_BIT);
	}
}