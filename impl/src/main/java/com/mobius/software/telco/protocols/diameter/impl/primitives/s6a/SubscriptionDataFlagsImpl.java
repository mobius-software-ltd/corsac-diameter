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
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SubscriptionDataFlags;

/**
*
* @author yulian oifa
*
*/
public class SubscriptionDataFlagsImpl extends DiameterBitmask32Impl implements SubscriptionDataFlags
{
	public SubscriptionDataFlagsImpl()
	{
		super();
	}
	
	protected SubscriptionDataFlagsImpl(Integer value)
	{
		super(value);
	}

	@Override
	public void setPSAndSMSOnlyServiceProvisionIndicationBit(boolean isOn)
	{
		setBitUnchecked(PS_AND_SMS_ONLY_SERVICE_PROVISION_INDICATION_BIT, isOn);
	}

	@Override
	public boolean isPSAndSMSOnlyServiceProvisionIndicationBitSet()
	{
		return getBit(PS_AND_SMS_ONLY_SERVICE_PROVISION_INDICATION_BIT);
	}

	@Override
	public void setSMSInSGSNAllowedIndicationBit(boolean isOn)
	{
		setBitUnchecked(SMS_IN_SGSN_ALLOWED_INDICATION_BIT, isOn);
	}

	@Override
	public boolean isSMSInSGSNAllowedIndicationBitSet()
	{
		return getBit(SMS_IN_SGSN_ALLOWED_INDICATION_BIT);
	}

	@Override
	public void setUserPlaneIntegrityIndicationBit(boolean isOn)
	{
		setBitUnchecked(USER_PLANE_INTEGRITY_PROTECTION_BIT, isOn);
	}

	@Override
	public boolean isUserPlaneIntegrityIndicationBitSet()
	{
		return getBit(USER_PLANE_INTEGRITY_PROTECTION_BIT);
	}

	@Override
	public void setPDNConnectionRestrictedBit(boolean isOn)
	{
		setBitUnchecked(PDN_CONNECTION_RESTRICTED_BIT, isOn);
	}

	@Override
	public boolean isPDNConnectionRestrictedBitSet()
	{
		return getBit(PDN_CONNECTION_RESTRICTED_BIT);
	}

	@Override
	public void setAcknowledgmentOfDownlinkNASDataPDUSDisabledBit(boolean isOn)
	{
		setBitUnchecked(ACKNOWLEDGEMENT_OF_DOWNLINK_NAS_DATA_PDUS_DISABLED_BIT, isOn);
	}

	@Override
	public boolean isAcknowledgmentOfDownlinkNASDataPDUSDisabledBitSet()
	{
		return getBit(ACKNOWLEDGEMENT_OF_DOWNLINK_NAS_DATA_PDUS_DISABLED_BIT);
	}
}