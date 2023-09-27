package com.mobius.software.telco.protocols.diameter.primitives.sta;

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
 * 	5.2.3.19	Transport-Access-Type
	The Transport-Acess-Type AVP (AVP code 1519) is of type Enumerated and is used to identify the transport access technology that is serving the UE.
	The following values are defined:

	BBF (0)
	This value shall be used to indicate a BBF transport access network.
 */
public enum TransportAccessTypeEnum implements IntegerEnum
{
	BBF(0);

	private static final Map<Integer, TransportAccessTypeEnum> intToTypeMap = new HashMap<Integer, TransportAccessTypeEnum>();
	static
	{
	    for (TransportAccessTypeEnum type : TransportAccessTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static TransportAccessTypeEnum fromInt(Integer value) 
	{
		TransportAccessTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private TransportAccessTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
