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
 * 	7.2.177 Role-Of-Node AVP
	The Role-Of-Node AVP (AVP code 829) is of type Enumerated and specifies whether the IMS (except the MRFC) or
	VCS node is serving the calling, called, or forwarding party. The identifier can be one of the following:
 	
 	0 ORIGINATING_ROLE
 	The node is applying an originating role, serving the calling party.
 	
 	1 TERMINATING_ROLE
 	The node is applying a terminating role, serving the called party.
 	
 	2 FORWARDING_ROLE
 	The node is applying a originating role, serving the forwarding party. 
 */
public enum RoleOfNodeEnum implements IntegerEnum
{
	ORIGINATING(0),TERMINATING(1),FORWARDING(2);

	private static final Map<Integer, RoleOfNodeEnum> intToTypeMap = new HashMap<Integer, RoleOfNodeEnum>();
	static 
	{
	    for (RoleOfNodeEnum type : RoleOfNodeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static RoleOfNodeEnum fromInt(Integer value) 
	{
		RoleOfNodeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private RoleOfNodeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
