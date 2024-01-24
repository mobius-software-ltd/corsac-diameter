package com.mobius.software.telco.protocols.diameter.impl.primitives.pc4a;
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
import com.mobius.software.telco.protocols.diameter.primitives.pc4a.ProSeDirectAllowed;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3704L, vendorId = KnownVendorIDs.TGPP_ID)
public class ProSeDirectAllowedImpl extends DiameterBitmask32Impl implements ProSeDirectAllowed
{
	public ProSeDirectAllowedImpl()
	{
		super();
	}

	protected ProSeDirectAllowedImpl(Integer value)
	{
		super(value);
	}

	@Override
	public void setAnnounceBit(boolean isOn)
	{
		setBit(ANNOUNCE_BIT, isOn);
	}
 
	@Override
	public boolean isAnnounceBitSet()
	{
		return getBit(ANNOUNCE_BIT);
	}

	@Override
	public void setMonitorBit(boolean isOn)
	{
		setBit(MONITOR_BIT, isOn);
	}

	@Override
	public boolean isMonitorBitSet()
	{
		return getBit(MONITOR_BIT);
	}

	@Override
	public void setCommunicationBit(boolean isOn)
	{
		setBit(COMMUNICATION_BIT, isOn);
	}

	@Override
	public boolean isCommunicationBitSet()
	{
		return getBit(COMMUNICATION_BIT);				
	}

	@Override
	public void setOneToOneCommunicationBit(boolean isOn)
	{
		setBit(COMMUNICATION_BIT, isOn);
	}

	@Override
	public boolean isOneToOneCommunicationBitSet()
	{
		return getBit(ONE_TO_ONE_COMMUNICATION_BIT);
	}

	@Override
	public void setDiscovererBit(boolean isOn)
	{
		setBit(DISCOVERER_BIT, isOn);
	}

	@Override
	public boolean isDiscovererBitSet()
	{
		return getBit(DISCOVERER_BIT);
	}

	@Override
	public void setDiscovereeBit(boolean isOn)
	{
		setBit(DISCOVEREE_BIT, isOn);
	}

	@Override
	public boolean isDiscovereeBitSet()
	{
		return getBit(DISCOVEREE_BIT);
	}

	@Override
	public void setRestrictedAnnounceBit(boolean isOn)
	{
		setBit(RESTRICTED_ANNOUNCE_BIT, isOn);
	}

	@Override
	public boolean isRestrictedAnnounceBitSet()
	{
		return getBit(RESTRICTED_ANNOUNCE_BIT);
	}

	@Override
	public void setRestrictedMonitoringBit(boolean isOn)
	{
		setBit(RESTRICTED_MONITORING_BIT, isOn);
	}

	@Override
	public boolean isRestrictedMonitoringBitSet()
	{
		return getBit(RESTRICTED_MONITORING_BIT);
	}

	@Override
	public void setApplicationControlledExtensionBit(boolean isOn)
	{
		setBit(APPLICATION_CONTROLLED_EXTENSION_BIT, isOn);
	}

	@Override
	public boolean isApplicationControlledExtensionBitSet()
	{
		return getBit(APPLICATION_CONTROLLED_EXTENSION_BIT);
	}

	@Override
	public void setOnDemandAnnouncingBit(boolean isOn)
	{
		setBit(ON_DEMAND_ANNOUNCING_BIT, isOn);
	}

	@Override
	public boolean isOnDemandAnnouncingBitSet()
	{
		return getBit(ON_DEMAND_ANNOUNCING_BIT);				
	}
}