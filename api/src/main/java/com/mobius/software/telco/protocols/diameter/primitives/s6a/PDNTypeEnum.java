package com.mobius.software.telco.protocols.diameter.primitives.s6a;

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
 * 	7.3.62	PDN-Type
	The PDN-Type AVP is of type Enumerated and indicates the address type of the PDN, when it is IP-based.	
	
	NOTE:	There are certain PDNs that can be accessed without using IP. These are identified by a specific PDN type indicator in their APN configuration settings (e.g. see clauses 7.3.204 and 7.3.232).

	The following values are defined:

	IPv4 (0)
	This value shall be used to indicate that the PDN can be accessed only in IPv4 mode.

	IPv6 (1)
	This value shall be used to indicate that the PDN can be accessed only in IPv6 mode.

	IPv4v6 (2)
	This value shall be used to indicate that the PDN can be accessed both in IPv4 mode, in IPv6 mode, and also from UEs supporting dualstack IPv4v6.

	IPv4_OR_IPv6 (3)
	This value shall be used to indicate that the PDN can be accessed either in IPv4 mode, or in IPv6 mode, but not from UEs supporting dualstack IPv4v6. It should be noted that this value will never be used as a requested PDN Type from the UE, since UEs will only use one of their supported PDN Types, i.e., IPv4 only, IPv6 only or IPv4v6 (dualstack). This value is only used as part of the APN subscription context, as an authorization mechanism between HSS and MME.
 */
public enum PDNTypeEnum implements IntegerEnum
{
	IPV4(0),IPV6(1),IPV4V6(2),IPV4ORV6(3);

	private static final Map<Integer, PDNTypeEnum> intToTypeMap = new HashMap<Integer, PDNTypeEnum>();
	static
	{
	    for (PDNTypeEnum type : PDNTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static PDNTypeEnum fromInt(Integer value) 
	{
		PDNTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private PDNTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
