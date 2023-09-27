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
 * 	7.2.154J ProSe-Range-Class AVP
	The ProSe-Range-Class AVP (AVP code 3448) is of type Enumerated and carry a range class for a specific proximity
	request. The AVP may take the values as follows:

	0 Reserved
	1 50 m
	2 100 m 
	ETSI
	3 200 m
	4 500 m
	5 1000 m
	6-255 Unused
	
	It is referred to as "Range Class" in TS 24.334 [236]
 */
public enum ProSeRangeClassEnum implements IntegerEnum
{
	RESERVED(0),M_50(1),M_100(2),M_200(3),M_500(4),M_1000(5);

	private static final Map<Integer, ProSeRangeClassEnum> intToTypeMap = new HashMap<Integer, ProSeRangeClassEnum>();
	static 
	{
	    for (ProSeRangeClassEnum type : ProSeRangeClassEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static ProSeRangeClassEnum fromInt(Integer value) 
	{
		ProSeRangeClassEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private ProSeRangeClassEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
