package com.mobius.software.telco.protocols.diameter.impl.primitives.gx;
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
import com.mobius.software.telco.protocols.diameter.primitives.gx.CreditManagementStatus;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1082L, vendorId = KnownVendorIDs.TGPP_ID)
public class CreditManagementStatusImpl extends DiameterBitmask32Impl implements CreditManagementStatus
{
	public CreditManagementStatusImpl()
	{
		super();
	}

	public CreditManagementStatusImpl(Integer value)
	{
		super(value);
	}

	@Override
	public void setEndUserServiceDeniedBit(boolean isOn)
	{
		setBit(END_USER_SERVICE_DENIED_BIT, isOn);
	}

	@Override
	public boolean isEndUserServiceDeniedBitSet()
	{
		return getBit(END_USER_SERVICE_DENIED_BIT);
	}

	@Override
	public void setCreditControlNotApplicableBit(boolean isOn)
	{
		setBit(CREDIT_CONTROL_NOT_APPLICABLE_BIT, isOn);
	}

	@Override
	public boolean isCreditControlNotApplicableBitSet()
	{
		return getBit(CREDIT_CONTROL_NOT_APPLICABLE_BIT);
	}

	@Override
	public void setAuthorizationRejectedBit(boolean isOn)
	{
		setBit(AUTHORIZATION_REJECTED_BIT, isOn);
	}

	@Override
	public boolean isAuthorizationRejectedBitSet()
	{
		return getBit(AUTHORIZATION_REJECTED_BIT);
	}

	@Override
	public void setUserUnknownBit(boolean isOn)
	{
		setBit(USER_UNKNOWN_BIT, isOn);
	}

	@Override
	public boolean isUserUnknownBitSet()
	{
		return getBit(USER_UNKNOWN_BIT);
	}

	@Override
	public void setRatingFailedBit(boolean isOn)
	{
		setBit(RATING_FAILED_BIT, isOn);
	}

	@Override
	public boolean isRatingFailedBitSet()
	{
		return getBit(RATING_FAILED_BIT);				
	}

	@Override
	public void setNoGynSessionServiceAllowedBit(boolean isOn)
	{
		setBit(NO_GYN_SESSION_SERVICE_ALLOWED_BIT, isOn);
	}

	@Override
	public boolean isNoGynSessionServiceAllowedBitSet()
	{
		return getBit(NO_GYN_SESSION_SERVICE_ALLOWED_BIT);
	}

	@Override
	public void setNoGynSessionServiceNotAllowedBit(boolean isOn)
	{
		setBit(NO_GYN_SESSION_SERVICE_NOT_ALLOWED_BIT, isOn);
	}

	@Override
	public boolean isNoGynSessionServiceNotAllowedBitSet()
	{
		return getBit(NO_GYN_SESSION_SERVICE_NOT_ALLOWED_BIT);
	}
}