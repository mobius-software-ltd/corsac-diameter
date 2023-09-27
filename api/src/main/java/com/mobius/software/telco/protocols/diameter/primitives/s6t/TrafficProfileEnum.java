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
 * 	8.4.79	Traffic-Profile
	The Traffic-Profile AVP is of type Unsigend32. The following values are defined:

	SINGLE_TRANSMISSION_UL (0)

	SINGLE_TRANSMISSION_DL (1)

	DUAL_TRANSMISSION_UL_WITH_SUBSEQUENT_DL (2)

	DUAL_TRANSMISSION_DL_WITH_SUBSEQUENT_UL (3)

	MULTI_TRANSMISSION (4)
 */
public enum TrafficProfileEnum implements IntegerEnum
{
	SINGLE_TRANSMISSION_UL(0),SINGLE_TRANSMISSION_DL(1),DUAL_TRANSMISSION_UL_WITH_SUBSEQUENT_DL(2),DUAL_TRANSMISSION_DL_WITH_SUBSEQUENT_UL(3),
	MULTI_TRANSMISSION(4);

	private static final Map<Integer, TrafficProfileEnum> intToTypeMap = new HashMap<Integer, TrafficProfileEnum>();
	static
	{
	    for (TrafficProfileEnum type : TrafficProfileEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static TrafficProfileEnum fromInt(Integer value) 
	{
		TrafficProfileEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private TrafficProfileEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
