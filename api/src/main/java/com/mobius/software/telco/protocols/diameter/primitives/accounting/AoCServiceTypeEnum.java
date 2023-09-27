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
 * 	7.2.19 AoC-Service-Type AVP
	The AoC-Service-Type AVP (AVP code 2313) is of type Enumerated and defines the type of AoC information to be
	provided to the subscriber. It can be one of the following values:

	0 NONE
	1 AOC-S	
	2 AOC-D
	3 AOC-E 
 */
public enum AoCServiceTypeEnum implements IntegerEnum
{
	NONE(0),AOC_S(1),AOC_D(2),AOC_E(3);

	private static final Map<Integer, AoCServiceTypeEnum> intToTypeMap = new HashMap<Integer, AoCServiceTypeEnum>();
	static 
	{
	    for (AoCServiceTypeEnum type : AoCServiceTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static AoCServiceTypeEnum fromInt(Integer value) 
	{
		AoCServiceTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private AoCServiceTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
