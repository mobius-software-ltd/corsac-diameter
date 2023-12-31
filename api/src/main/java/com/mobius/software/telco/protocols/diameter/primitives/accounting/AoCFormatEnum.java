package com.mobius.software.telco.protocols.diameter.primitives.accounting;

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
 * 	7.2.14 AoC-Format AVP
	The AoC-Format AVP (AVP code 2310) is of type Enumerated and holds the format on how the AoC information shall
	be sent to the UE. It can be one of the following values:
	
	0 MONETARY
	1 NON_MONETARY
	2 CAI 
 */
public enum AoCFormatEnum implements IntegerEnum
{
	MONETARY(0),NON_MONETARY(1),CAI(2);

	private static final Map<Integer, AoCFormatEnum> intToTypeMap = new HashMap<Integer, AoCFormatEnum>();
	static 
	{
	    for (AoCFormatEnum type : AoCFormatEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static AoCFormatEnum fromInt(Integer value) 
	{
		AoCFormatEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private AoCFormatEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
