package com.mobius.software.telco.protocols.diameter.primitives.nas;

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
 * 4.4.11.3.  Login-Service AVP

   The Login-Service AVP (AVP Code 15) is of type Enumerated and
   contains the service that should be used to connect the user to the
   login host.  This AVP SHOULD only be present in authorization
   responses.  The supported values are listed in RFC 2869.
 */
public enum LoginServiceEnum implements IntegerEnum
{
	TELNET(0),RLOGIN(1),TCP_CLEAR(2),PORT_MASTER(3),LAT(4),X25_PAD(5),X25_T3POS(6),TCP_CLEAR_QUIET(7);

	private static final Map<Integer, LoginServiceEnum> intToTypeMap = new HashMap<Integer, LoginServiceEnum>();
	static
	{
	    for (LoginServiceEnum type : LoginServiceEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static LoginServiceEnum fromInt(Integer value) 
	{
		LoginServiceEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private LoginServiceEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
