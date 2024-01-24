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
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.MBMSBearerResult;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3506L, vendorId = KnownVendorIDs.TGPP_ID)
public class MBMSBearerResultImpl extends DiameterBitmask32Impl implements MBMSBearerResult
{	
	public MBMSBearerResultImpl()
	{
		super();
	}

	protected MBMSBearerResultImpl(Integer value)
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
		setBit(RESOURCES_EXCEEDED_BIT, isOn);
	}

	@Override
	public boolean isResourcesExceededBitSet()
	{
		return getBit(RESOURCES_EXCEEDED_BIT);
	}

	@Override
	public void setUnknownTMGIBit(boolean isOn)
	{
		setBit(UNKNOWN_TMGI_BIT, isOn);
	}

	@Override
	public boolean isUnknownTMGIBitSet()
	{
		return getBit(UNKNOWN_TMGI_BIT);
	}

	@Override
	public void setTMGINotInUseBit(boolean isOn)
	{
		setBit(TMGI_NOT_IN_USE_BIT, isOn);
	}

	@Override
	public boolean isTMGINotInUseBitSet()
	{
		return getBit(TMGI_NOT_IN_USE_BIT);
	}

	@Override
	public void setOverlappingMBMSServiceAreaBit(boolean isOn)
	{
		setBit(OVERLAPPING_MBMS_SERVICE_AREA_BIT, isOn);
	}

	@Override
	public boolean isOverlappingMBMSServiceAreaBitSet()
	{
		return getBit(OVERLAPPING_MBMS_SERVICE_AREA_BIT);
	}

	@Override
	public void setUnknownFlowIdentifierBit(boolean isOn)
	{
		setBit(UNKNOWN_FLOW_IDENTIFIER_BIT, isOn);
	}

	@Override
	public boolean isUnknownFlowIdentifierBitSet()
	{
		return getBit(UNKNOWN_FLOW_IDENTIFIER_BIT);
	}

	@Override
	public void setQoSAuthorizationRejectedBit(boolean isOn)
	{
		setBit(QOS_AUTHORIZATION_REJECTED_BIT, isOn);
	}

	@Override
	public boolean isQoSAuthorizationRejectedBitSet()
	{
		return getBit(QOS_AUTHORIZATION_REJECTED_BIT);
	}

	@Override
	public void setUnknownMBMSServiceAreaBit(boolean isOn)
	{
		setBit(UNKNOWN_MBMS_SERVICE_AREA_BIT, isOn);
	}

	@Override
	public boolean isUnknownMBMSServiceAreaBitSet()
	{
		return getBit(UNKNOWN_MBMS_SERVICE_AREA_BIT);
	}

	@Override
	public void setMBMSServiceAreaAuthorizationRejectedBit(boolean isOn)
	{
		setBit(MBMS_SERVICE_AREA_AUTHORIZATION_REJECTED_BIT, isOn);
	}

	@Override
	public boolean isMBMSServiceAreaAuthorizationRejectedBitSet()
	{
		return getBit(MBMS_SERVICE_AREA_AUTHORIZATION_REJECTED_BIT);
	}

	@Override
	public void setMBMSStartTimeBit(boolean isOn)
	{
		setBit(MBMS_START_TIME_BIT, isOn);
	}

	@Override
	public boolean isMBMSStartTimeBitSet()
	{
		return getBit(MBMS_START_TIME_BIT);
	}

	@Override
	public void setInvalidAVPCombinationBit(boolean isOn)
	{
		setBit(INVALID_AVP_COMBINATION_BIT, isOn);
	}

	@Override
	public boolean isInvalidAVPCombinationBitSet()
	{
		return getBit(INVALID_AVP_COMBINATION_BIT);
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
	public void setActivationOngoingBit(boolean isOn)
	{
		setBit(ACTIVATION_ONGOING_BIT, isOn);
	}

	@Override
	public boolean isActivationOngoingBitSet()
	{
		return getBit(ACTIVATION_ONGOING_BIT);
	}
}