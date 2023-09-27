package com.mobius.software.telco.protocols.diameter.primitives.s6t;

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
 * 	8.4.78	PDN-Connectivity-Status-Type
	The PDN-Connectivity-Status-Type AVP is of type Unsigned32 and it shall indicate the status of the PDN Connection being monitored. The following values are defined:

	CREATED (0)
	The value CREATED (0) indicates that the event corresponds to the creation of a new PDN Connection on the monitored APN.

	DELETED (1)
	The value DELETED (1) indicates that the event corresponds to the deletion of a PDN Connection on the monitored APN.
 */
public enum PDNConnectivityStatusTypeEnum implements IntegerEnum
{
	CREATED(0),DELETED(1);

	private static final Map<Integer, PDNConnectivityStatusTypeEnum> intToTypeMap = new HashMap<Integer, PDNConnectivityStatusTypeEnum>();
	static
	{
	    for (PDNConnectivityStatusTypeEnum type : PDNConnectivityStatusTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static PDNConnectivityStatusTypeEnum fromInt(Integer value) 
	{
		PDNConnectivityStatusTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private PDNConnectivityStatusTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
