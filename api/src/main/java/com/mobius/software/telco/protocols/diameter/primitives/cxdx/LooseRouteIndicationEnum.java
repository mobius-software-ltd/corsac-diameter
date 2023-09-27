package com.mobius.software.telco.protocols.diameter.primitives.cxdx;

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
 * 	6.3.45	Loose-Route-Indication AVP
	The Loose-Route-Indication AVP is of type Enumerated and indicates to the S-CSCF whether or not the loose route mechanism is required to serve the registered Public User Identities. The following values are defined:

	LOOSE_ROUTE_NOT_REQUIRED (0)

	LOOSE_ROUTE_REQUIRED (1)
 */
public enum LooseRouteIndicationEnum implements IntegerEnum
{
	LOOSE_ROUTE_NOT_REQUIRED(0),LOOSE_ROUTE_REQUIRED(1);

	private static final Map<Integer, LooseRouteIndicationEnum> intToTypeMap = new HashMap<Integer, LooseRouteIndicationEnum>();
	static
	{
	    for (LooseRouteIndicationEnum type : LooseRouteIndicationEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static LooseRouteIndicationEnum fromInt(Integer value) 
	{
		LooseRouteIndicationEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private LooseRouteIndicationEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
