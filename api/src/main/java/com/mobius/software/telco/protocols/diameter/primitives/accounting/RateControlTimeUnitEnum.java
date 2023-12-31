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
 * 	7.2.160G Rate-Control-Time-Unit AVP
	The Rate-Control-Time-Unit AVP (AVP code 3939) is of type Unsigned32 and holds a time unit for rate control.It has
	the following values:
	
	0 Unrestricted
	This value is used to indicate the number of data PDUs is not restricted.
	1 Minute
	2 Hour
	3 Day
	4 Week 
 */
public enum RateControlTimeUnitEnum implements IntegerEnum
{
	UNRESTRICTED(0),MINUTE(1),HOUR(2),DAY(3),WEEK(4);

	private static final Map<Integer, RateControlTimeUnitEnum> intToTypeMap = new HashMap<Integer, RateControlTimeUnitEnum>();
	static 
	{
	    for (RateControlTimeUnitEnum type : RateControlTimeUnitEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static RateControlTimeUnitEnum fromInt(Integer value) 
	{
		RateControlTimeUnitEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private RateControlTimeUnitEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
