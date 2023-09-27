package com.mobius.software.telco.protocols.diameter.primitives.s6a;

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
 * 	7.3.164	Daylight-Saving-Time
	The Daylight-Saving-Time AVP is of type Enumerated and shall contain the Daylight Saving Time (in steps of 1 hour) used to adjust for summertime the time zone of the location where the UE is attached in the visited network.
	The following values are defined:

	NO_ADJUSTMENT (0)

	PLUS_ONE_HOUR_ADJUSTMENT (1)

	PLUS_TWO_HOURS_ADJUSTMENT (2)
 */
public enum DaylightSavingTimeEnum implements IntegerEnum
{
	NO_ADJUSTMENT(0),PLUS_ONE_HOUR_ADJUSTMENT(1),PLUS_TWO_HOURS_ADJUSTMENT(2);

	private static final Map<Integer, DaylightSavingTimeEnum> intToTypeMap = new HashMap<Integer, DaylightSavingTimeEnum>();
	static
	{
	    for (DaylightSavingTimeEnum type : DaylightSavingTimeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static DaylightSavingTimeEnum fromInt(Integer value) 
	{
		DaylightSavingTimeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private DaylightSavingTimeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
