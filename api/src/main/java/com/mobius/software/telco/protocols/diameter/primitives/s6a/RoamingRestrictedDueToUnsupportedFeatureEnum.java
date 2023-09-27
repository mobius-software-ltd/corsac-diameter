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
 * 	7.3.81	Roaming-Restricted-Due-To-Unsupported-Feature
	The Roaming-Restricted-Due-To-Unsupported-Feature AVP is of type Enumerated and indicates that roaming is restricted due to unsupported feature. The following value is defined:

	Roaming-Restricted-Due-To-Unsupported-Feature (0)
 */
public enum RoamingRestrictedDueToUnsupportedFeatureEnum implements IntegerEnum
{
	ROAMING_RESTRICTED_DUE_TO_UNSUPPORTED_FEATURE(0);

	private static final Map<Integer, RoamingRestrictedDueToUnsupportedFeatureEnum> intToTypeMap = new HashMap<Integer, RoamingRestrictedDueToUnsupportedFeatureEnum>();
	static
	{
	    for (RoamingRestrictedDueToUnsupportedFeatureEnum type : RoamingRestrictedDueToUnsupportedFeatureEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static RoamingRestrictedDueToUnsupportedFeatureEnum fromInt(Integer value) 
	{
		RoamingRestrictedDueToUnsupportedFeatureEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private RoamingRestrictedDueToUnsupportedFeatureEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
