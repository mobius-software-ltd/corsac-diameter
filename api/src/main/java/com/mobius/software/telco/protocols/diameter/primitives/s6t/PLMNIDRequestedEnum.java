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
 * 	8.4.68	PLMN-ID-Requested
	The PLMN-ID-Requested AVP is of type Enumerated and it shall indicate whether the PLMN-ID value needs to be returned in the event report associated to the monitoring type "ROAMING_STATUS". The following values are defined:

	TRUE (0)
	The value TRUE (0) indicates that the PLMN-ID value shall be returned in the corresponding event report for "ROAMING_STATUS".

	FALSE (1)
	The value FALSE (1) indicates that the PLMN-ID value shall not be returned in the corresponding event report for "ROAMING_STATUS".

	The default value, when this AVP is not included, is TRUE (0).
 */
public enum PLMNIDRequestedEnum implements IntegerEnum
{
	TRUE(0),FALSE(1);

	private static final Map<Integer, PLMNIDRequestedEnum> intToTypeMap = new HashMap<Integer, PLMNIDRequestedEnum>();
	static
	{
	    for (PLMNIDRequestedEnum type : PLMNIDRequestedEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static PLMNIDRequestedEnum fromInt(Integer value) 
	{
		PLMNIDRequestedEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private PLMNIDRequestedEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
