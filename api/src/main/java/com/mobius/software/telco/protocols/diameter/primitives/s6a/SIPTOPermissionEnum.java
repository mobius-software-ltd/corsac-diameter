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
 * 	7.3.135	SIPTO-Permission
	The SIPTO-Permission AVP is of type Enumerated. It shall indicate whether the traffic associated with this particular APN is allowed or not for SIPTO above RAN.
	The following values are defined:

	SIPTO_above_RAN _ALLOWED (0)

	SIPTO_above_RAN _NOTALLOWED (1)
 */
public enum SIPTOPermissionEnum implements IntegerEnum
{
	SIPTO_ABOVE_RAN_ALLOWED(0),SIPTO_ABOVE_RAN_NOTALLOWED(1);

	private static final Map<Integer, SIPTOPermissionEnum> intToTypeMap = new HashMap<Integer, SIPTOPermissionEnum>();
	static
	{
	    for (SIPTOPermissionEnum type : SIPTOPermissionEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static SIPTOPermissionEnum fromInt(Integer value) 
	{
		SIPTOPermissionEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private SIPTOPermissionEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
