package com.mobius.software.telco.protocols.diameter.primitives.gq;

import java.util.HashMap;
import java.util.Map;

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

/*
 * 	7.3.35 Overbooking-indicator
	The Overbooking-indicator AVP (AVP code 460) is of type Enumerated. Indicates that the SPDF should require
	processing the resource request in overbooking mode. The following values are specified The overbooking-indicator
	may be used when having a session initiation or when having a session modification.

	• Overbooking-indicator (0) means that no overbooking mode is required

	• Overbooking-indicator (1) means that overbooking is mode required
 */
public enum OverbookingIndicatorEnum implements IntegerEnum
{
	NO_OVERBOOKING(0),OVERBOOKING(1);

	private static final Map<Integer, OverbookingIndicatorEnum> intToTypeMap = new HashMap<Integer, OverbookingIndicatorEnum>();
	static
	{
	    for (OverbookingIndicatorEnum type : OverbookingIndicatorEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static OverbookingIndicatorEnum fromInt(Integer value) 
	{
		OverbookingIndicatorEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private OverbookingIndicatorEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
