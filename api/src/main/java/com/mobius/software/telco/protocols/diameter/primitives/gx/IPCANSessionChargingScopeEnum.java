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

/*
 * 	5.3.114 IP-CAN-Session-Charging-Scope AVP
	The IP-CAN-Session-Charging-Scope AVP (AVP code 2827) is of type Enumerated, and indicates that the AccessNetwork-Charging-Identifier-Gx AVP applies to the whole IP-CAN Session. The following values are defined:

	IP-CAN_SESSION_SCOPE (0)
 		This value indicates that the charging identifier corresponds to the IP-CAN Session
 */
public enum IPCANSessionChargingScopeEnum implements IntegerEnum
{
	IP_CAN_SESSION_SCOPE(0);

	private static final Map<Integer, IPCANSessionChargingScopeEnum> intToTypeMap = new HashMap<Integer, IPCANSessionChargingScopeEnum>();
	static
	{
	    for (IPCANSessionChargingScopeEnum type : IPCANSessionChargingScopeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static IPCANSessionChargingScopeEnum fromInt(Integer value) 
	{
		IPCANSessionChargingScopeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private IPCANSessionChargingScopeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
