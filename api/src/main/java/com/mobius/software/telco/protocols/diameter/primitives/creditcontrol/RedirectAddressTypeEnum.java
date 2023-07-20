package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol;

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
public enum RedirectAddressTypeEnum implements IntegerEnum
{
	IPV4_ADDRESS(0),IPV6_ADDRESS(1),URL(2),SIP_URI(3),END_USER_PRIVATE(4);

	private static final Map<Integer, RedirectAddressTypeEnum> intToTypeMap = new HashMap<Integer, RedirectAddressTypeEnum>();
	static 
	{
	    for (RedirectAddressTypeEnum type : RedirectAddressTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static RedirectAddressTypeEnum fromInt(Integer value) 
	{
		RedirectAddressTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private RedirectAddressTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
