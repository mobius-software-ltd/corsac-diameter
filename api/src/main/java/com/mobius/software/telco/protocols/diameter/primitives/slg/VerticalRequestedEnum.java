package com.mobius.software.telco.protocols.diameter.primitives.slg;

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
 * 	7.4.9	Vertical-Requested
	The Vertical-Requested AVP is of type Enumerated. The following values are defined:
	
	VERTICAL_COORDINATE_IS_NOT REQUESTED (0)
	
	VERTICAL_COORDINATE_IS_REQUESTED (1)

	Default value if AVP is not present is: VERTICAL_COORDINATE_IS_NOT_REQUESTED (0).
 */
public enum VerticalRequestedEnum implements IntegerEnum
{
	VERTICAL_COORDINATE_IS_NOT_REQUESTED(0),VERTICAL_COORDINATE_IS_REQUESTED(1);

	private static final Map<Integer, VerticalRequestedEnum> intToTypeMap = new HashMap<Integer, VerticalRequestedEnum>();
	static
	{
	    for (VerticalRequestedEnum type : VerticalRequestedEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static VerticalRequestedEnum fromInt(Integer value) 
	{
		VerticalRequestedEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private VerticalRequestedEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
