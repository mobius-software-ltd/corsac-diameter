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
 * 	7.2.74 Interface-Type AVP
	The Interface-Type AVP (AVP code 2006) is of type Enumerated and contains information about type of interface /
	nature of the transaction in the messaging node for which the charging event occurs. The AVP can take the following
	values:
	
	0 Unknown
	1 MOBILE_ORIGINATING
	2 MOBILE_TERMINATING
	3 APPLICATION_ORIGINATING
	4 APPLICATION_TERMINATION 
 */
public enum InterfaceTypeEnum implements IntegerEnum
{
	UNKNOWN(0),MOBILE_ORIGINATING(1),MOBILE_TERMINATING(2),APPLICATION_ORIGINATING(3),APPLICATION_TERMINATION(4);

	private static final Map<Integer, InterfaceTypeEnum> intToTypeMap = new HashMap<Integer, InterfaceTypeEnum>();
	static 
	{
	    for (InterfaceTypeEnum type : InterfaceTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static InterfaceTypeEnum fromInt(Integer value) 
	{
		InterfaceTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private InterfaceTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
