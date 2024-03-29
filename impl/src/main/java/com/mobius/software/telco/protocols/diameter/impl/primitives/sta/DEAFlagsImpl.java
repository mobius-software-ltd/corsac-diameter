package com.mobius.software.telco.protocols.diameter.impl.primitives.sta;
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
import com.mobius.software.telco.protocols.diameter.primitives.sta.DEAFlags;

/**
*
* @author yulian oifa
*
*/
public class DEAFlagsImpl extends DiameterBitmask32Impl implements DEAFlags
{
	public DEAFlagsImpl()
	{
		super();
	}

	public DEAFlagsImpl(Integer value)
	{
		super(value);
	}

	@Override
	public void setNSWOAuthorizationBit(boolean isOn)
	{
		setBitUnchecked(NSWO_AUTHORIZATION_BIT, isOn);
	}

	@Override
	public boolean isNSWOAuthorizationBitSet()
	{
		return getBit(NSWO_AUTHORIZATION_BIT);
	}

	@Override
	public void setTWANS2aConnectivityIndicatorBit(boolean isOn)
	{
		setBitUnchecked(TWAN_S2A_CONNECTIVITY_INDICATOR_BIT, isOn);
	}

	@Override
	public boolean isTWANS2aConnectivityIndicatorBitSet()
	{
		return getBit(TWAN_S2A_CONNECTIVITY_INDICATOR_BIT);				
	}

	@Override
	public void setIMEICheckRequestInVPLMNBit(boolean isOn)
	{
		setBitUnchecked(IMEI_CHECK_REQUEST_IN_VPLMN_BIT, isOn);
	}

	@Override
	public boolean isIMEICheckRequestInVPLMNBitSet()
	{
		return getBit(IMEI_CHECK_REQUEST_IN_VPLMN_BIT);
	}
}