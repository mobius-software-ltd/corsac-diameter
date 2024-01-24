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
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ULRFlags;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1405L, vendorId = KnownVendorIDs.TGPP_ID)
public class ULRFlagsImpl extends DiameterBitmask32Impl implements ULRFlags
{
	public ULRFlagsImpl()
	{
		super();
	}
	
	protected ULRFlagsImpl(Integer value)
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
	public void setS6AS6DIndicationBit(boolean isOn)
	{
		setBit(S6A_S6D_INDICATOR_BIT, isOn);
	}

	@Override
	public boolean isS6AS6DIndicationBitSet()
	{
		return getBit(S6A_S6D_INDICATOR_BIT);
	}

	@Override
	public void setSkipSubscriberDataBit(boolean isOn)
	{
		setBit(SKIP_SUBSCRIBER_DATA_BIT, isOn);
	}

	@Override
	public boolean isSkipSubscriberDataBitSet()
	{
		return getBit(SKIP_SUBSCRIBER_DATA_BIT);
	}

	@Override
	public void setGPRSSubscriptionDataIndicationBit(boolean isOn)
	{
		setBit(GPRS_SUBSCRIPTION_DATA_INDICATOR_BIT, isOn);
	}

	@Override
	public boolean isGPRSSubscriptionDataIndicationBitSet()
	{
		return getBit(GPRS_SUBSCRIPTION_DATA_INDICATOR_BIT);
	}

	@Override
	public void setNodeTypeIndicationBit(boolean isOn)
	{
		setBit(NODE_TYPE_INDICATION_BIT, isOn);
	}

	@Override
	public boolean isNodeTypeIndicationBitSet()
	{
		return getBit(NODE_TYPE_INDICATION_BIT);
	}

	@Override
	public void setInitialAttachIndicationBit(boolean isOn)
	{
		setBit(INITIAL_ATTACH_INDICATION_BIT, isOn);
	}

	@Override
	public boolean isInitialAttachIndicationBitSet()
	{
		return getBit(INITIAL_ATTACH_INDICATION_BIT);
	}

	@Override
	public void setPSLCSNotSupportedByUEBit(boolean isOn)
	{
		setBit(PS_LCS_NOT_SUPPORTED_BY_UE_BIT, isOn);
	}

	@Override
	public boolean isPSLCSNotSupportedByUEBitSet()
	{
		return getBit(PS_LCS_NOT_SUPPORTED_BY_UE_BIT);
	}

	@Override
	public void setSMSOnlyIndicationBit(boolean isOn)
	{
		setBit(SMS_ONLY_INDICATION_BIT, isOn);
	}

	@Override
	public boolean isSMSOnlyIndicationBitSet()
	{
		return getBit(SMS_ONLY_INDICATION_BIT);
	}

	@Override
	public void setDualRegistration5GIndicationBit(boolean isOn)
	{
		setBit(DUAL_REGISTRATION_5G_INDICATION_BIT, isOn);
	}

	@Override
	public boolean isDualRegistration5GIndicationBitSet()
	{
		return getBit(DUAL_REGISTRATION_5G_INDICATION_BIT);
	}

	@Override
	public void setInterPLMNInterMMEHandoverBit(boolean isOn)
	{
		setBit(INTER_PLMN_INTER_MME_HANDOVER_BIT, isOn);
	}

	@Override
	public boolean isInterPLMNInterMMEHandoverBitSet()
	{
		return getBit(INTER_PLMN_INTER_MME_HANDOVER_BIT);
	}

	@Override
	public void setIntraPLMNInterMMEHandoverBit(boolean isOn)
	{
		setBit(INTRA_PLMN_INTER_MME_HANDOVER_BIT, isOn);
	}

	@Override
	public boolean isIntraPLMNInterMMEHandoverBitSet()
	{
		return getBit(INTRA_PLMN_INTER_MME_HANDOVER_BIT);
	}
}