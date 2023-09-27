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
 * 	7.2.16 AoC-Request-Type AVP
	The AoC-Request-Type AVP (AVP code 2055) is of type enumerated and tags if the client is looking for AoCI in
	conjunction to the Request-Type and Request-Action AVPs. It can be one of the following values:

	0 AoC_NOT_REQUESTED
	1 AoC_FULL
	2 AoC_COST_ONLY
	3 AoC_TARIFF_ONLY 
 */
public enum AoCRequestTypeEnum implements IntegerEnum
{
	AOC_NOT_REQUESTED(0),AOC_FULL(1),AOC_COST_ONLY(2),AOC_TARIFF_ONLY(3);

	private static final Map<Integer, AoCRequestTypeEnum> intToTypeMap = new HashMap<Integer, AoCRequestTypeEnum>();
	static 
	{
	    for (AoCRequestTypeEnum type : AoCRequestTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static AoCRequestTypeEnum fromInt(Integer value) 
	{
		AoCRequestTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private AoCRequestTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
