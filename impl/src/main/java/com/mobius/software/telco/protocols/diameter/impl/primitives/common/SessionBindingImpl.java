package com.mobius.software.telco.protocols.diameter.impl.primitives.common;
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
import com.mobius.software.telco.protocols.diameter.primitives.common.SessionBinding;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 270L, vendorId = -1L)
public class SessionBindingImpl extends DiameterBitmask32Impl implements SessionBinding
{
	public SessionBindingImpl() 
	{
		super();
	}
	
	public SessionBindingImpl(Integer value) 
	{
		super(value);
	}

	@Override
	public void setReauthBit(boolean isOn)
	{
		setBit(RE_AUTH_BIT, isOn);
	}

	@Override
	public boolean isReauthBitSet()
	{
		return getBit(RE_AUTH_BIT);
	}

	@Override
	public void setSTRBit(boolean isOn)
	{
		setBit(STR_BIT, isOn);
	}

	@Override
	public boolean isSTRBitSet()
	{
		return getBit(STR_BIT);
	}

	@Override
	public void setAccountingBit(boolean isOn)
	{
		setBit(ACCOUNTING_BIT, isOn);
	}

	@Override
	public boolean isAccountingBitSet()
	{
		return getBit(ACCOUNTING_BIT);
	}
}