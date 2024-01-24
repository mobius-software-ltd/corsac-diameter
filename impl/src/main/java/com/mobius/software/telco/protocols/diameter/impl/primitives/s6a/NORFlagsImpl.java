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
import com.mobius.software.telco.protocols.diameter.primitives.s6a.NORFlags;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1443L, vendorId = KnownVendorIDs.TGPP_ID)
public class NORFlagsImpl extends DiameterBitmask32Impl implements NORFlags
{
	public NORFlagsImpl()
	{
		super();
	}
	
	protected NORFlagsImpl(Integer value)
	{
		super(value);
	}

	@Override
	public void setSingleRegistrationIndicationBit(boolean isOn)
	{
		setBit(SINGLE_REGISTRATION_INDICATION_BIT, isOn);
	}

	@Override
	public boolean isSingleRegistrationIndicationBitSet()
	{
		return getBit(SINGLE_REGISTRATION_INDICATION_BIT);
	}

	@Override
	public void setSGSNAreaRestrictedBit(boolean isOn)
	{
		setBit(SGSN_AREA_RESTRICTED_BIT, isOn);
	}

	@Override
	public boolean isSGSNAreaRestrictedBitSet()
	{
		return getBit(SGSN_AREA_RESTRICTED_BIT);
	}

	@Override
	public void setReadyForSMFromSGSNBit(boolean isOn)
	{
		setBit(READY_FOR_SM_FROM_SGSN_BIT, isOn);
	}

	@Override
	public boolean isReadyForSMFromSGSNBitSet()
	{
		return getBit(READY_FOR_SM_FROM_SGSN_BIT);
	}

	@Override
	public void setUEReachabilityFromMMEBit(boolean isOn)
	{
		setBit(UE_REACHABILITY_FROM_MME_BIT, isOn);
	}

	@Override
	public boolean isUEReachabilityFromMMEBitSet()
	{
		return getBit(UE_REACHABILITY_FROM_MME_BIT);
	}

	@Override
	public void setUEReachabilityFromSGSNBit(boolean isOn)
	{
		setBit(UE_REACHABILITY_FROM_SGSN_BIT, isOn);
	}

	@Override
	public boolean isUEReachabilityFromSGSNBitSet()
	{
		return getBit(UE_REACHABILITY_FROM_SGSN_BIT);
	}

	@Override
	public void setReadyForSMFromMMEBit(boolean isOn)
	{
		setBit(READY_FOR_SM_FROM_MME_BIT, isOn);
	}

	@Override
	public boolean isReadyForSMFromMMEBitSet()
	{
		return getBit(READY_FOR_SM_FROM_MME_BIT);
	}

	@Override
	public void setHomogenousSupportOfIMSVoiceOverPSSessionsBit(boolean isOn)
	{
		setBit(HOMOGENOUS_SUPPORT_OF_IMS_VOICE_OVER_PS_SESSIONS_BIT, isOn);
	}

	@Override
	public boolean isHomogenousSupportOfIMSVoiceOverPSSessionsBitSet()
	{
		return getBit(HOMOGENOUS_SUPPORT_OF_IMS_VOICE_OVER_PS_SESSIONS_BIT);
	}

	@Override
	public void setS6AS6DIndicatorBit(boolean isOn)
	{
		setBit(S6A_S6D_INDICATOR_BIT, isOn);
	}

	@Override
	public boolean isS6AS6DIndicatorBitSet()
	{
		return getBit(S6A_S6D_INDICATOR_BIT);
	}

	@Override
	public void setRemovalOfMMERegistrationForSMSBit(boolean isOn)
	{
		setBit(REMOVAL_OF_MME_REGISTRATION_FOR_SMS_BIT, isOn);
	}

	@Override
	public boolean isRemovalOfMMERegistrationForSMSBitSet()
	{
		return getBit(REMOVAL_OF_MME_REGISTRATION_FOR_SMS_BIT);
	}
}