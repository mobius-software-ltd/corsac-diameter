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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterUnsigned32Impl;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.MB2USecurity;

/**
*
* @author yulian oifa
*
*/
public class MB2USecurityImpl extends DiameterUnsigned32Impl implements MB2USecurity
{
	protected MB2USecurityImpl()
	{
		super();
	}

	protected MB2USecurityImpl(Long minValue, Long maxValue)
	{
		super(minValue, maxValue);
	}

	public MB2USecurityImpl(Long value, Long minValue, Long maxValue)
	{
		super(value, minValue, maxValue);
	}
}