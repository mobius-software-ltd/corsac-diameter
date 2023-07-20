package com.mobius.software.telco.protocols.diameter.impl.primitives;

import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;
import com.mobius.software.telco.protocols.diameter.primitives.IntegerEnum;

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
public class DiameterEnumeratedImpl<T extends Enum<T> & IntegerEnum> extends DiameterInteger32Impl implements DiameterEnumerated<T> 
{
	private T value;
	
	//required for parser
	protected DiameterEnumeratedImpl() 
	{
		super();
	}
	
	protected DiameterEnumeratedImpl(Integer minValue,Integer maxValue) 
	{
		super(minValue, maxValue);
	}
	
	public DiameterEnumeratedImpl(T value,Integer minValue,Integer maxValue) 
	{
		super(value.getValue(), minValue, maxValue);
	}

	public T getEnumerated(Class<T> realClass)
	{
		if(value==null)
		{
			int value=getInteger().intValue();
			T[] allConstants = realClass.getEnumConstants();
			for(T curr:allConstants)
			{
				if(curr.getValue()==value)
					this.value=curr;				
			}
		}
		
		return value;
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
		
		DiameterEnumeratedImpl<?> other = (DiameterEnumeratedImpl<?>) obj;
		if (value == null) 
		{
			if (other.value != null)
				return false;
		} 
		else if (!value.equals(other.value))
			return false;
		
		return true;
	}
}