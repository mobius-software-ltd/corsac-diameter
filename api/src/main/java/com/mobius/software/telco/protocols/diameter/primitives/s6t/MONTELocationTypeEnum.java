package com.mobius.software.telco.protocols.diameter.primitives.s6t;

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
 * 	8.4.16	MONTE-Location-Type
	The MONTE-Location-Type AVP is of type Unsigned32. It indicates the type of location information to be provided. The following values are defined:

	CURRENT_LOCATION (0)

	LAST_KNOWN_LOCATION (1)

	The default value, when this AVP is not included, is LAST_KNOWN_LOCATION (1).
 */
public enum MONTELocationTypeEnum implements IntegerEnum
{
	CURRENT_LOCATION(0),LAST_KNOWN_LOCATION(1);

	private static final Map<Integer, MONTELocationTypeEnum> intToTypeMap = new HashMap<Integer, MONTELocationTypeEnum>();
	static
	{
	    for (MONTELocationTypeEnum type : MONTELocationTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static MONTELocationTypeEnum fromInt(Integer value) 
	{
		MONTELocationTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private MONTELocationTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
