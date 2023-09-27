package com.mobius.software.telco.protocols.diameter.primitives.rx;

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
 * 	5.3.78	Line-Type AVP
	The Line-Type AVP (AVP code 581) is of type Unsigned32 and it indicates the type of wireline (DSL or PON) for the wireline BBF access.
	The following values are defined in this specification:

	0 (DSL):
		This value shall be used to indicate DSL line.

	1 (PON):
		This value shall be used to indicate PON line.
 */
public enum LineTypeEnum implements IntegerEnum
{
	DSL(0),PON(1);

	private static final Map<Integer, LineTypeEnum> intToTypeMap = new HashMap<Integer, LineTypeEnum>();
	static
	{
	    for (LineTypeEnum type : LineTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static LineTypeEnum fromInt(Integer value) 
	{
		LineTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private LineTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
