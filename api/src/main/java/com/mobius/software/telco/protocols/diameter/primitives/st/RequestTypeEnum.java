package com.mobius.software.telco.protocols.diameter.primitives.st;

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
 * 	5c.3.2	Request-Type AVP
	The Request-Type AVP (AVP code 2838) is of type Unsigned32, and contains the reason for sending a Request message.
	The following values are defined:

	0	(initial request)
	An initial request is used to initiate a Diameter session and contains information that is relevant to initiation.

	1	(update request)
	An update request is used to update an existing Diameter session.
 */
public enum RequestTypeEnum implements IntegerEnum
{
	INITIAL_REQUEST(0),UPDATE_REQUEST(1);

	private static final Map<Integer, RequestTypeEnum> intToTypeMap = new HashMap<Integer, RequestTypeEnum>();
	static
	{
	    for (RequestTypeEnum type : RequestTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static RequestTypeEnum fromInt(Integer value) 
	{
		RequestTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private RequestTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
