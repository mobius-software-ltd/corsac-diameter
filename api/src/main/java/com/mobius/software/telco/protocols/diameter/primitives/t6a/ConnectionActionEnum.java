package com.mobius.software.telco.protocols.diameter.primitives.t6a;

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
 * 	6.4.18	Connection-Action
	The Connection-Action AVP is of type Unsigned32 and it shall identify the action to be performed on the T6a/b connection. The following values are defined:

	CONNECTION_ESTABLISHMENT (0)
	This value shall be used if the T6a/b Connection-Management-Request applies to a T6a/b connection establishment.

	CONNECTION_RELEASE (1)
	This value shall be used if the T6a/b Connection-Management-Request applies to a T6a/b connection release.

	CONNECTION_UPDATE (2)
	This value shall be used if the T6a/b Connection-Management-Request applies to updating the properties of a T6a/b connection.
 */
public enum ConnectionActionEnum implements IntegerEnum
{
	CONNECTION_ESTABLISHMENT(0),CONNECTION_RELEASE(1),CONNECTION_UPDATE(2);

	private static final Map<Integer, ConnectionActionEnum> intToTypeMap = new HashMap<Integer, ConnectionActionEnum>();
	static
	{
	    for (ConnectionActionEnum type : ConnectionActionEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static ConnectionActionEnum fromInt(Integer value) 
	{
		ConnectionActionEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private ConnectionActionEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
