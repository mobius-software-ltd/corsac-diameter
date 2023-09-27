package com.mobius.software.telco.protocols.diameter.primitives.swx;

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
 * 	8.2.3.27	ERP-Authorization
	The ERP-Authorization AVP is of type Unsigned32 and it indicates whether the subscriber is authorized, or not, to make use of the EAP Reauthentication Protocol. The following values are defined:

	ERP_NOT_AUTHORIZED (0)

	ERP_AUTHORIZED (1)
 */
public enum ERPAuthorizationEnum implements IntegerEnum
{
	ERP_NOT_AUTHORIZED(0),ERP_AUTHORIZED(1);

	private static final Map<Integer, ERPAuthorizationEnum> intToTypeMap = new HashMap<Integer, ERPAuthorizationEnum>();
	static
	{
	    for (ERPAuthorizationEnum type : ERPAuthorizationEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static ERPAuthorizationEnum fromInt(Integer value) 
	{
		ERPAuthorizationEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private ERPAuthorizationEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
