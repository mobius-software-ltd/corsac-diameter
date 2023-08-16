package com.mobius.software.telco.protocols.diameter.primitives.rfc5777;

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
 * 4.1.8.2.  Fragmentation-Flag AVP

   The Fragmentation-Flag AVP (AVP Code 536) is of type Enumerated and
   specifies the packet fragmentation flags to match in the IP header.

     Value | Name and Semantic
     ------+------------------------------------------------------------
       0   | Don't Fragment (DF)
       1   | More Fragments (MF)
 */
public enum FragmentationFlagEnum implements IntegerEnum
{
	DONT_FRAGMENT(0),MORE_FRAGMENTS(1);

	private static final Map<Integer, FragmentationFlagEnum> intToTypeMap = new HashMap<Integer, FragmentationFlagEnum>();
	static
	{
	    for (FragmentationFlagEnum type : FragmentationFlagEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static FragmentationFlagEnum fromInt(Integer value) 
	{
		FragmentationFlagEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private FragmentationFlagEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
