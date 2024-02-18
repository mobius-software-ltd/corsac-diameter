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
import com.mobius.software.telco.protocols.diameter.primitives.s6a.IDRFlags;

/**
*
* @author yulian oifa
*
*/
public class IDRFlagsImpl extends DiameterBitmask32Impl implements IDRFlags
{
	public IDRFlagsImpl()
	{
		super();
	}
	
	protected IDRFlagsImpl(Integer value)
	{
		super(value);
	}

	@Override
	public void setUEReachabilityRequestBit(boolean isOn)
	{
		setBitUnchecked(UE_REACHABILITY_REQUEST_BIT, isOn);
	}

	@Override
	public boolean isUEReachabilityRequestBitSet()
	{
		return getBit(UE_REACHABILITY_REQUEST_BIT);
	}

	@Override
	public void setTADSDataRequestBit(boolean isOn)
	{
		setBitUnchecked(T_ADS_DATA_REQUEST_BIT, isOn);
	}

	@Override
	public boolean isTADSDataRequestBitSet()
	{
		return getBit(T_ADS_DATA_REQUEST_BIT);
	}

	@Override
	public void setEPSUserStateRequestBit(boolean isOn)
	{
		setBitUnchecked(EPS_USER_STATE_REQUEST_BIT, isOn);
	}

	@Override
	public boolean isEPSUserStateRequestBitSet()
	{
		return getBit(EPS_USER_STATE_REQUEST_BIT);
	}

	@Override
	public void setEPSLocationInformationRequestBit(boolean isOn)
	{
		setBitUnchecked(EPS_LOCATION_INFORMATION_REQUEST_BIT, isOn);
	}

	@Override
	public boolean isEPSLocationInformationRequestBitSet()
	{
		return getBit(EPS_LOCATION_INFORMATION_REQUEST_BIT);
	}

	@Override
	public void setCurrentLocationRequestBit(boolean isOn)
	{
		setBitUnchecked(CURRENT_LOCATION_REQUEST_BIT, isOn);
	}

	@Override
	public boolean isCurrentLocationRequestBitSet()
	{
		return getBit(CURRENT_LOCATION_REQUEST_BIT);
	}

	@Override
	public void setLocatTimezoneRequestBit(boolean isOn)
	{
		setBitUnchecked(LOCAL_TIMEZONE_REQUEST_BIT, isOn);
	}

	@Override
	public boolean isLocatTimezoneRequestBitSet()
	{
		return getBit(LOCAL_TIMEZONE_REQUEST_BIT);
	}

	@Override
	public void setRemoveSMSRegistrationRequestBit(boolean isOn)
	{
		setBitUnchecked(REMOVE_SMS_REGISTRATION_REQUEST_BIT, isOn);
	}

	@Override
	public boolean isRemoveSMSRegistrationRequestBitSet()
	{
		return getBit(REMOVE_SMS_REGISTRATION_REQUEST_BIT);
	}

	@Override
	public void setRATTypeRequestBit(boolean isOn)
	{
		setBitUnchecked(RAT_TYPE_REQUEST_BIT, isOn);
	}

	@Override
	public boolean isRATTypeRequestBitSet()
	{
		return getBit(RAT_TYPE_REQUEST_BIT);
	}

	@Override
	public void setPCSCFRestorationRequestBit(boolean isOn)
	{
		setBitUnchecked(PCSCF_RESTORATION_REQUEST_BIT, isOn);
	}

	@Override
	public boolean isPCSCFRestorationRequestBitSet()
	{
		return getBit(PCSCF_RESTORATION_REQUEST_BIT);
	}
}