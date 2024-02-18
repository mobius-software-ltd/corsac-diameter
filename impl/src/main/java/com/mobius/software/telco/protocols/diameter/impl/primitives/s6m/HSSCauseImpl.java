package com.mobius.software.telco.protocols.diameter.impl.primitives.s6m;
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
import com.mobius.software.telco.protocols.diameter.primitives.s6m.HSSCause;

/**
*
* @author yulian oifa
*
*/
public class HSSCauseImpl extends DiameterBitmask32Impl implements HSSCause
{
	public HSSCauseImpl()
	{
		super();
	}

	public HSSCauseImpl(Integer value)
	{
		super(value);
	}

	@Override
	public void setAbsentSubscriberBit(boolean isOn)
	{
		setBitUnchecked(ABSENT_SUBSCRIBER_BIT, isOn);
	}

	@Override
	public boolean isAbsentSubscriberBitSet()
	{
		return getBit(ABSENT_SUBSCRIBER_BIT);
	}

	@Override
	public void setTeleserviceNotProvisionedBit(boolean isOn)
	{
		setBitUnchecked(TELESERVICE_NOT_PROVISIONED_BIT, isOn);
	}

	@Override
	public boolean isTeleserviceNotProvisionedBitSet()
	{
		return getBit(TELESERVICE_NOT_PROVISIONED_BIT);
	}

	@Override
	public void setCallBarredBit(boolean isOn)
	{
		setBitUnchecked(CALL_BARRED_BIT, isOn);
	}

	@Override
	public boolean isCallBarredBitSet()
	{
		return getBit(CALL_BARRED_BIT);
	}
}