package com.mobius.software.telco.protocols.diameter.primitives.rfc5778;

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
 * 	6.20.  MIP6-Auth-Mode AVP

   	The MIP6-Auth-Mode (AVP Code 494) is of type Enumerated and contains
   	information of the used Mobile IPv6 Authentication Protocol mode.
   	This specification defines only one value MIP6_AUTH_MN_AAA and the
   	corresponding AAA interactions when MN-AAA security association is
   	used to authenticate the Binding Update as described in [RFC4285].
   	When the MIP6-Auth_Mode AVP is set to the value of MIP6_AUTH_MN_AAA,
   	the Auth-Request-Type AVP MUST be set to the value of
   	AUTHORIZE_AUTHENTICATE.
 */
public enum MIP6AuthModeEnum implements IntegerEnum
{
	MIP6_AUTH_MN_AAA(1);

	private static final Map<Integer, MIP6AuthModeEnum> intToTypeMap = new HashMap<Integer, MIP6AuthModeEnum>();
	static
	{
	    for (MIP6AuthModeEnum type : MIP6AuthModeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static MIP6AuthModeEnum fromInt(Integer value) 
	{
		MIP6AuthModeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private MIP6AuthModeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
