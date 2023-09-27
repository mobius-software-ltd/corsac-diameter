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
 * 	7.4.27	LCS-QoS-Class
	The LCS-QoS-Class AVP is of the type Enumerated. The following values are defined.

	ASSURED (0)

	BEST EFFORT (1)
 */
public enum LCSQoSClassEnum implements IntegerEnum
{
	ASSURED(0),BEST_EFFORT(1);

	private static final Map<Integer, LCSQoSClassEnum> intToTypeMap = new HashMap<Integer, LCSQoSClassEnum>();
	static
	{
	    for (LCSQoSClassEnum type : LCSQoSClassEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static LCSQoSClassEnum fromInt(Integer value) 
	{
		LCSQoSClassEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private LCSQoSClassEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
