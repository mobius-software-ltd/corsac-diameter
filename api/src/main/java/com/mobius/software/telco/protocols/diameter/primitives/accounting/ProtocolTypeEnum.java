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
	A.4.17.  Protocol-Type AVP

	The Protocol-Type AVP (AVP Code 1013) is of type Enumerated and indicates the protocol used for the request. The values are given below:
	0	HTTP
	1	CoAP
	2	MQTT
	
	3 .. 99	Reserved for OneM2M defined protocol types
	100 .. 199	Operator and vendor specific protocol types
*/
public enum ProtocolTypeEnum implements IntegerEnum
{
	HTTP(0),COAP(1),MQTT(2);

	private static final Map<Integer, ProtocolTypeEnum> intToTypeMap = new HashMap<Integer, ProtocolTypeEnum>();
	static 
	{
	    for (ProtocolTypeEnum type : ProtocolTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static ProtocolTypeEnum fromInt(Integer value) 
	{
		ProtocolTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private ProtocolTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
