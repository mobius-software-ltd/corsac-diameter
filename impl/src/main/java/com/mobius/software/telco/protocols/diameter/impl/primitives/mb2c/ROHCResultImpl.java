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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterBitmask32Impl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.ROHCResult;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3530L, vendorId = KnownVendorIDs.TGPP_ID)
public class ROHCResultImpl extends DiameterBitmask32Impl implements ROHCResult
{
	public ROHCResultImpl()
	{
		super();
	}

	protected ROHCResultImpl(Integer value)
	{
		super(value);
	}

	@Override
	public void setSuccessBit(boolean isOn)
	{
		setBit(SUCCESS_BIT, isOn);
	}

	@Override
	public boolean isSuccessBitSet()
	{
		return getBit(SUCCESS_BIT);
	}

	@Override
	public void setTryingBit(boolean isOn)
	{
		setBit(TRYING_BIT, isOn);
	}

	@Override
	public boolean isTryingBitSet()
	{
		return getBit(TRYING_BIT);
	}

	@Override
	public void setAuthorizationRejectBit(boolean isOn)
	{
		setBit(AUTHORIZATION_REJECTED_BIT, isOn);
	}

	@Override
	public boolean isAuthorizationRejectBitSet()
	{
		return getBit(AUTHORIZATION_REJECTED_BIT);
	}

	@Override
	public void setResourcesExceededBit(boolean isOn)
	{
		setBit(RESOURCED_EXCEEDED_BIT, isOn);
	}

	@Override
	public boolean isResourcesExceededBitSet()
	{
		return getBit(RESOURCED_EXCEEDED_BIT);
	}

	@Override
	public void setUnknownProfileBit(boolean isOn)
	{
		setBit(UNKNOWN_PROFILE_BIT, isOn);
	}

	@Override
	public boolean isUnknownProfileBitSet()
	{
		return getBit(UNKNOWN_PROFILE_BIT);
	}

	@Override
	public void setSystemErrorBit(boolean isOn)
	{
		setBit(SYSTEM_ERROR_BIT, isOn);
	}

	@Override
	public boolean isSystemErrorBitSet()
	{
		return getBit(SYSTEM_ERROR_BIT);
	}

	@Override
	public void setNoTrafficBit(boolean isOn)
	{
		setBit(NO_TRAFFIC_BIT, isOn);
	}

	@Override
	public boolean isNoTrafficBitSet()
	{
		return getBit(NO_TRAFFIC_BIT);
	}
}