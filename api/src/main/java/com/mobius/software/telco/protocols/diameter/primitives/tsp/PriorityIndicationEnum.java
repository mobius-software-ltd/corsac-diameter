package com.mobius.software.telco.protocols.diameter.primitives.tsp;

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
 *	6.4.7	Priority-Indication AVP
	The Priority-Indication (AVP code 3006) is of type Enumerated, and identifies priority of the device trigger.
	The following values are defined:

	Non-Priority (0)
	This value indicates that the device trigger has non-priority.

	Priority (1)
	This value indicates that the device trigger has priority.
 */
public enum PriorityIndicationEnum implements IntegerEnum
{
	NON_PRIORITY(0),PRIORITY(1);

	private static final Map<Integer, PriorityIndicationEnum> intToTypeMap = new HashMap<Integer, PriorityIndicationEnum>();
	static
	{
	    for (PriorityIndicationEnum type : PriorityIndicationEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static PriorityIndicationEnum fromInt(Integer value) 
	{
		PriorityIndicationEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private PriorityIndicationEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
