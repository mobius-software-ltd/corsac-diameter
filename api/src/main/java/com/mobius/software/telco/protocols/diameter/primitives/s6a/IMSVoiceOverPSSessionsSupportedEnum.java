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
 * 	7.3.106	IMS-Voice-Over-PS-Sessions-Supported
	The IMS-Voice-Over-PS-Sessions-Supported AVP is of type Enumerated. The following values are defined:

	NOT_SUPPORTED (0)
	This value indicates that "IMS Voice over PS Sessions" is not supported by the UE's most recently used TA or RA in the serving node.

	SUPPORTED (1)
	This value indicates that "IMS Voice over PS Sessions" is supported by the UE's most recently used TA or RA in the serving node.
 */
public enum IMSVoiceOverPSSessionsSupportedEnum implements IntegerEnum
{
	NOT_SUPPORTED(0),SUPPORTED(1);

	private static final Map<Integer, IMSVoiceOverPSSessionsSupportedEnum> intToTypeMap = new HashMap<Integer, IMSVoiceOverPSSessionsSupportedEnum>();
	static
	{
	    for (IMSVoiceOverPSSessionsSupportedEnum type : IMSVoiceOverPSSessionsSupportedEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static IMSVoiceOverPSSessionsSupportedEnum fromInt(Integer value) 
	{
		IMSVoiceOverPSSessionsSupportedEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private IMSVoiceOverPSSessionsSupportedEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
