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
 * 	7.2.95 Location-Estimate-Type AVP
	The Location-Estimate-Type AVP (AVP code 1243) is of type Enumerated and contains one of the following values:
	
	0 CURRENT_LOCATION
	1 CURRENT_LAST_KNOWN_LOCATION
	2 INITIAL_LOCATION
	3 ACTIVATE_DEFERRED_LOCATION
	4 CANCEL_DEFERRED_LOCATION 
 */
public enum LocationEstimateTypeEnum implements IntegerEnum
{
	CURRENT_LOCATION(0),CURRENT_LAST_KNOWN_LOCATION(1),INITIAL_LOCATION(2),ACTIVATE_DEFERRED_LOCATION(3),CANCEL_DEFERRED_LOCATION(4);

	private static final Map<Integer, LocationEstimateTypeEnum> intToTypeMap = new HashMap<Integer, LocationEstimateTypeEnum>();
	static 
	{
	    for (LocationEstimateTypeEnum type : LocationEstimateTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static LocationEstimateTypeEnum fromInt(Integer value) 
	{
		LocationEstimateTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private LocationEstimateTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
