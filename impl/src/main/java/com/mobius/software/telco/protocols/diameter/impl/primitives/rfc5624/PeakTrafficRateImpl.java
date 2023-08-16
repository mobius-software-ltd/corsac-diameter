package com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5624;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterFloat32Impl;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5624.PeakTrafficRate;

/**
*
* @author yulian oifa
*
*/

@DiameterAvpImplementation(code = 498L, vendorId = -1L)
public class PeakTrafficRateImpl extends DiameterFloat32Impl implements PeakTrafficRate
{
	protected PeakTrafficRateImpl() 
	{
		super();
	}
	
	protected PeakTrafficRateImpl(Float minValue,Float maxValue) 
	{
		super(minValue, maxValue);
	}
	
	public PeakTrafficRateImpl(Float value,Float minValue,Float maxValue) 
	{
		super(value, minValue, maxValue);
	}
}