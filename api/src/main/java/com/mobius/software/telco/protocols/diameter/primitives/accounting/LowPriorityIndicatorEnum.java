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
 * 	7.2.97A Low-Priority-Indicator AVP
	The Low-Priority-Indicator AVP (AVP code 2602) is of type Enumerated and indicates if the PDN connection has a
	low priority, i.e. for Machine Type Communications. It can be one of the following values:

	0 NO
	1 YES
 */
public enum LowPriorityIndicatorEnum implements IntegerEnum
{
	NO(0),YES(1);

	private static final Map<Integer, LowPriorityIndicatorEnum> intToTypeMap = new HashMap<Integer, LowPriorityIndicatorEnum>();
	static 
	{
	    for (LowPriorityIndicatorEnum type : LowPriorityIndicatorEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static LowPriorityIndicatorEnum fromInt(Integer value) 
	{
		LowPriorityIndicatorEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private LowPriorityIndicatorEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
