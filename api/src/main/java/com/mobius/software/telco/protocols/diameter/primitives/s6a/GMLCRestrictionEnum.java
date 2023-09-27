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
 * 	7.3.92	GMLC-Restriction
	The GMLC-Restriction AVP is of type Enumerated. The following values are defined:

	GMLC_LIST (0)
	
	HOME_COUNTRY (1)
 */
public enum GMLCRestrictionEnum implements IntegerEnum
{
	GMLC_LIST(0),HOME_COUNTRY(1);

	private static final Map<Integer, GMLCRestrictionEnum> intToTypeMap = new HashMap<Integer, GMLCRestrictionEnum>();
	static
	{
	    for (GMLCRestrictionEnum type : GMLCRestrictionEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static GMLCRestrictionEnum fromInt(Integer value) 
	{
		GMLCRestrictionEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private GMLCRestrictionEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
