package com.mobius.software.telco.protocols.diameter.impl.primitives.swm;
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
import com.mobius.software.telco.protocols.diameter.primitives.swm.EmergencyServices;

/**
*
* @author yulian oifa
*
*/
public class EmergencyServicesImpl extends DiameterBitmask32Impl implements EmergencyServices
{
	public EmergencyServicesImpl()
	{
		super();
	}
	
	protected EmergencyServicesImpl(Integer value)
	{
		super(value);
	}

	@Override
	public void setEstablishPDNConnectionBit(boolean isOn)
	{
		setBitUnchecked(ESTABLISH_PDN_CONNECTION_BIT, isOn);
	}

	@Override
	public boolean isEstablishPDNConnectionBitSet()
	{
		return getBit(ESTABLISH_PDN_CONNECTION_BIT);
	}
}