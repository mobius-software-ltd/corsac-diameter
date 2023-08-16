package com.mobius.software.telco.protocols.diameter.primitives.sh;

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
 * 	6.3.10 Identity-Set AVP
	The Identity-Set AVP is of type Enumerated and indicates the requested set of IMS Public Identities. The following
	values are defined:

	ALL_IDENTITIES (0)
	REGISTERED_IDENTITIES (1)
	IMPLICIT_IDENTITIES (2)
	ALIAS_IDENTITIES (3) 
 */
public enum IdentitySetEnum implements IntegerEnum
{
	ALL_IDENTITIES(0),REGISTERED_IDENTITIES(1),IMPLICIT_IDENTITIES(2),ALIAS_IDENTITIES(3);

	private static final Map<Integer, IdentitySetEnum> intToTypeMap = new HashMap<Integer, IdentitySetEnum>();
	static
	{
	    for (IdentitySetEnum type : IdentitySetEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static IdentitySetEnum fromInt(Integer value) 
	{
		IdentitySetEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private IdentitySetEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
