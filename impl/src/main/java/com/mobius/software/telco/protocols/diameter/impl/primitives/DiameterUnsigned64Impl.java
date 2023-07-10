package com.mobius.software.telco.protocols.diameter.impl.primitives;

import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned64;

/*
 * Mobius Software LTD, Open Source Cloud Communications
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
/**
*
* @author yulian oifa
*
*/
public class DiameterUnsigned64Impl extends DiameterInteger64Impl implements DiameterUnsigned64 
{
	//required for parser
	public DiameterUnsigned64Impl() 
	{
		super();
	}
	
	public DiameterUnsigned64Impl(Long minValue,Long maxValue) 
	{
		super(minValue, maxValue);
	}
	
	public DiameterUnsigned64Impl(Long value,Long minValue,Long maxValue) 
	{
		super(value, minValue, maxValue);
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		DiameterUnsigned64Impl other = (DiameterUnsigned64Impl) obj;
		if (getLong() == null) 
		{
			if (other.getLong() != null)
				return false;
		} 
		else if (!getLong().equals(other.getLong()))
			return false;
		
		return true;
	}
}