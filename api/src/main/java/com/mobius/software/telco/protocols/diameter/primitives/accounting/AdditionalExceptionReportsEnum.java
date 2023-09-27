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
 * 	7.2.5A Additional-Exception-Reports AVP
	The Additional-Exception-Reports AVP (AVP code 3936) is of type Enumerated and indicates whether additional
	exception reports are allowed when maximum rate is reached. It has the following values:
	
	0 Not allowed
	1 Allowed
 */
public enum AdditionalExceptionReportsEnum implements IntegerEnum
{
	NOT_ALLOWED(0),ALLOWED(1);

	private static final Map<Integer, AdditionalExceptionReportsEnum> intToTypeMap = new HashMap<Integer, AdditionalExceptionReportsEnum>();
	static
	{
	    for (AdditionalExceptionReportsEnum type : AdditionalExceptionReportsEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static AdditionalExceptionReportsEnum fromInt(Integer value) 
	{
		AdditionalExceptionReportsEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private AdditionalExceptionReportsEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
