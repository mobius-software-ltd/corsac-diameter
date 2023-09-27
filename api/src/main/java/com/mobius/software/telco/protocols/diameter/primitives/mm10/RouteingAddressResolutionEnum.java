package com.mobius.software.telco.protocols.diameter.primitives.mm10;

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
 * 	6.3.22	Routeing-Address-Resolution AVP
	The Routeing-Address-Resolution AVP (AVP code 1119) is of type Enumerated. It indicates whether the corresponding Routeing-Address has been resolved already.

	unresolved (0)

	resolved (1)
 */
public enum RouteingAddressResolutionEnum implements IntegerEnum
{
	UNRESOLVED(0),RESOLVED(1);

	private static final Map<Integer, RouteingAddressResolutionEnum> intToTypeMap = new HashMap<Integer, RouteingAddressResolutionEnum>();
	static
	{
	    for (RouteingAddressResolutionEnum type : RouteingAddressResolutionEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static RouteingAddressResolutionEnum fromInt(Integer value) 
	{
		RouteingAddressResolutionEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private RouteingAddressResolutionEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
