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
 * 	6.3.51	Multiple-Registration-Indication
	The Multiple-Registration-Indication AVP is of type Enumerated and indicates to the HSS whether or not the request is related to a multiple registration. The following values are defined:

	NOT_MULTIPLE_REGISTRATION (0)

	MULTIPLE_REGISTRATION (1)
 */
public enum MultipleRegistrationIndicationEnum implements IntegerEnum
{
	NOT_MULTIPLE_REGISTRATION(0),MULTIPLE_REGISTRATION(1);

	private static final Map<Integer, MultipleRegistrationIndicationEnum> intToTypeMap = new HashMap<Integer, MultipleRegistrationIndicationEnum>();
	static
	{
	    for (MultipleRegistrationIndicationEnum type : MultipleRegistrationIndicationEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static MultipleRegistrationIndicationEnum fromInt(Integer value) 
	{
		MultipleRegistrationIndicationEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private MultipleRegistrationIndicationEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
