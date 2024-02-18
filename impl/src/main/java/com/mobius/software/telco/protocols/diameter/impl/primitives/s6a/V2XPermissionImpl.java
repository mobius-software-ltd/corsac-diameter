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
import com.mobius.software.telco.protocols.diameter.primitives.s6a.V2XPermission;

/**
*
* @author yulian oifa
*
*/
public class V2XPermissionImpl extends DiameterBitmask32Impl implements V2XPermission
{
	public V2XPermissionImpl()
	{
		super();
	}
	
	protected V2XPermissionImpl(Integer value)
	{
		super(value);
	}

	@Override
	public void setAllowV2XCommunicationOverPC5AsVehicleUEBit(boolean isOn)
	{
		setBitUnchecked(ALLOW_V2X_COMMUNICATION_OVER_PC5_AS_VEHICLE_UE_BIT, isOn);
	}

	@Override
	public boolean isAllowV2XCommunicationOverPC5AsVehicleUEBitSet()
	{
		return getBit(ALLOW_V2X_COMMUNICATION_OVER_PC5_AS_VEHICLE_UE_BIT);
	}

	@Override
	public void setAllowV2XCommunicationOverPC5AsPedestrianUEBit(boolean isOn)
	{
		setBitUnchecked(ALLOW_V2X_COMMUNICATION_OVER_PC5_AS_PEDESTRIAN_UE_BIT, isOn);
	}

	@Override
	public boolean isAllowV2XCommunicationOverPC5AsPedestrianUEBitSet()
	{
		return getBit(ALLOW_V2X_COMMUNICATION_OVER_PC5_AS_PEDESTRIAN_UE_BIT);
	}
}