package com.mobius.software.telco.protocols.diameter.impl.primitives;
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

public class DiameterIdentity extends DiameterAsciiString
{
	//required for parser
	public DiameterIdentity() 
	{
		super();
	}
		
	public DiameterIdentity(Integer minLength,Integer maxLength) 
	{
		super(minLength,maxLength);		
	}
		
	public DiameterIdentity(String value,Integer minLength,Integer maxLength) 
	{
		super(value,minLength,maxLength);			
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
			
		DiameterIdentity other = (DiameterIdentity) obj;
		if (getRealValue() == null) 
		{
			if (other.getRealValue() != null)
				return false;
		} 
		else if (!getRealValue().equals(other.getRealValue()))
			return false;
			
		return true;
	}
}