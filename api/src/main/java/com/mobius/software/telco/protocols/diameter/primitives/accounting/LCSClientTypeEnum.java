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
 * 	7.2.86 LCS-Client-Type AVP
	The LCS-Client-Type AVP (AVP code 1241) is of type Enumerated and contains the type of services requested by the
	LCS Client. It can be one of the following values:
	
	0 EMERGENCY_SERVICES
	1 VALUE_ADDED_SERVICES
	2 PLMN_OPERATOR_SERVICES
	3 LAWFUL_INTERCEPT_SERVICES
 */
public enum LCSClientTypeEnum implements IntegerEnum
{
	EMERGENCY_SERVICES(0),VALUE_ADDED_SERVICES(1),PLMN_OPERATOR_SERVICES(2),LAWFUL_INTERCEPT_SERVICES(3);

	private static final Map<Integer, LCSClientTypeEnum> intToTypeMap = new HashMap<Integer, LCSClientTypeEnum>();
	static 
	{
	    for (LCSClientTypeEnum type : LCSClientTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static LCSClientTypeEnum fromInt(Integer value) 
	{
		LCSClientTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private LCSClientTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
