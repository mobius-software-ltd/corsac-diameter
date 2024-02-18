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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterBitmask32Impl;
import com.mobius.software.telco.protocols.diameter.primitives.pc4a.ProSePermission;

/**
*
* @author yulian oifa
*
*/
public class ProSePermissionImpl extends DiameterBitmask32Impl implements ProSePermission
{
	public ProSePermissionImpl()
	{
		super();
	}

	protected ProSePermissionImpl(Integer value)
	{
		super(value);
	}

	@Override
	public void setProSeDirectDiscoveryBit(boolean isOn)
	{
		setBitUnchecked(PROSE_DIRECT_DISCOVERY_BIT, isOn);
	}

	@Override
	public boolean isProSeDirectDiscoverySet()
	{
		return getBit(PROSE_DIRECT_DISCOVERY_BIT);
	}

	@Override
	public void setEPCLevelProSeDiscoveryBit(boolean isOn)
	{
		setBitUnchecked(EPC_LEVEL_PROSE_DISCOVERY_BIT, isOn);
	}

	@Override
	public boolean isEPCLevelProSeDiscoveryBitSet()
	{
		return getBit(EPC_LEVEL_PROSE_DISCOVERY_BIT);
	}

	@Override
	public void setEPCSupportWLANDirectDiscoveryAndCommunicationBit(boolean isOn)
	{
		setBitUnchecked(EPC_SUPPORT_WLAN_DIRECT_DISCOVERY_AND_COMMUNICATION_BIT, isOn);
	}

	@Override
	public boolean isEPCSupportWLANDirectDiscoveryAndCommunicationBitSet()
	{
		return getBit(EPC_SUPPORT_WLAN_DIRECT_DISCOVERY_AND_COMMUNICATION_BIT);
	}

	@Override
	public void setOneToManyProSeDirectCommunicationBit(boolean isOn)
	{
		setBitUnchecked(ONE_TO_MANY_PROSE_DIRECT_COMMUNICATION_BIT, isOn);
	}

	@Override
	public boolean isOneToManyProSeDirectCommunicationBitSet()
	{
		return getBit(ONE_TO_MANY_PROSE_DIRECT_COMMUNICATION_BIT);
	}

	@Override
	public void setOneToOneProSeDirectCommunicationBit(boolean isOn)
	{
		setBitUnchecked(ONE_TO_MANY_PROSE_DIRECT_COMMUNICATION_BIT, isOn);
	}

	@Override
	public boolean isOneToOneProSeDirectCommunicationBitSet()
	{
		return getBit(ONE_TO_ONE_PROSE_DIRECT_COMMUNICATION_BIT);
	}

	@Override
	public void setUEToNetworkRelayBit(boolean isOn)
	{
		setBitUnchecked(UE_TO_NETWORK_RELAY_BIT, isOn);
	}

	@Override
	public boolean isUEToNetworkRelayBitSet()
	{
		return getBit(UE_TO_NETWORK_RELAY_BIT);
	}

	@Override
	public void setRemoteUEAccessBit(boolean isOn)
	{
		setBitUnchecked(REMOTE_UE_ACCESS_BIT, isOn);
	}

	@Override
	public boolean isRemoteUEAccessBitSet()
	{
		return getBit(REMOTE_UE_ACCESS_BIT);
	}

	@Override
	public void setRestrictedProSeDirectDiscoveryBit(boolean isOn)
	{
		setBitUnchecked(RESTRICTED_PROSE_DIRECT_DISCOVERY_BIT, isOn);
	}

	@Override
	public boolean isRestrictedProSeDirectDiscoveryBitSet()
	{
		return getBit(RESTRICTED_PROSE_DIRECT_DISCOVERY_BIT);
	}
}