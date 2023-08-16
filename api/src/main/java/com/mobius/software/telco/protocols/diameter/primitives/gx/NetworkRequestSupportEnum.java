package com.mobius.software.telco.protocols.diameter.primitives.gx;

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

/*	5.3.24 Network-Request-Support AVP
	The Network-Request-Support AVP (AVP code 1024) is of type of Enumerated and indicates the UE and network
	support of the network initiated procedures.
	If the Network Request Support AVP has not been previously provided, its absence shall indicate the value
	NETWORK_REQUEST NOT SUPPORTED. If the Network Request Support AVP has been provided, its value shall
	remain valid until it is provided the next time.
	The following values are defined:

	NETWORK_REQUEST NOT SUPPORTED (0)
		This value is used to indicate that the UE and the access network do not support the network initiated bearer
		establishment request procedure.
	NETWORK_REQUEST SUPPORTED (1)
		This value is used to indicate that the UE and the access network support the network initiated bearer
		establishment request procedure.
*/
public enum NetworkRequestSupportEnum implements IntegerEnum
{
	NETWORK_REQUEST_NOT_SUPPORTED(0),NETWORK_REQUEST_SUPPORTED(1);

	private static final Map<Integer, NetworkRequestSupportEnum> intToTypeMap = new HashMap<Integer, NetworkRequestSupportEnum>();
	static
	{
	    for (NetworkRequestSupportEnum type : NetworkRequestSupportEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static NetworkRequestSupportEnum fromInt(Integer value) 
	{
		NetworkRequestSupportEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private NetworkRequestSupportEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
