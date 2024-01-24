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
import com.mobius.software.telco.protocols.diameter.primitives.rx.ServiceAuthorizationInfo;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 548L, vendorId = KnownVendorIDs.TGPP_ID)
public class ServiceAuthorizationInfoImpl extends DiameterBitmask32Impl implements ServiceAuthorizationInfo
{
	public ServiceAuthorizationInfoImpl()
	{
		super();
	}

	public ServiceAuthorizationInfoImpl(Integer value)
	{
		super(value);
	}

	@Override
	public void setTheTransferPolicyIsKnownBit(boolean isOn)
	{
		setBit(THE_TRANSFER_POLICY_IS_KNOWN_BIT, isOn);
	}

	@Override
	public boolean isTheTransferPolicyIsKnownBitSet()
	{
		return getBit(THE_TRANSFER_POLICY_IS_KNOWN_BIT);				
	}

	@Override
	public void setTheTransferPolicyHasExpiredBit(boolean isOn)
	{
		setBit(THE_TRANSFER_POLICY_HAS_EXPIRED_BIT, isOn);
	}

	@Override
	public boolean isTheTransferPolicyHasExpiredBitSet()
	{
		return getBit(THE_TRANSFER_POLICY_HAS_EXPIRED_BIT);
	}

	@Override
	public void setTheTimeWindowOfTheTransferPolicyHasOccurredBit(boolean isOn)
	{
		setBit(THE_TIME_WINDOW_OF_THE_TRANSFER_POLICY_HAS_OCCURED_BIT, isOn);
	}

	@Override
	public boolean isTheTimeWindowOfTheTransferPolicyHasOccurredBitSet()
	{
		return getBit(THE_TIME_WINDOW_OF_THE_TRANSFER_POLICY_HAS_OCCURED_BIT);
	}
}