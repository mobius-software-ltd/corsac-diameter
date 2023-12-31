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
 * 	7.2.174 Reply-Path-Requested AVP
	The Reply-Path-Requested AVP (AVP code 2011) is of type Enumerated. The possible values are:
	
	0 No Reply Path Set
	1 Reply path Set
 */
public enum ReplyPathRequestedEnum implements IntegerEnum
{
	NO_REPLY_PATH_SET(0),REPLY_PATH_SET(1);

	private static final Map<Integer, ReplyPathRequestedEnum> intToTypeMap = new HashMap<Integer, ReplyPathRequestedEnum>();
	static 
	{
	    for (ReplyPathRequestedEnum type : ReplyPathRequestedEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static ReplyPathRequestedEnum fromInt(Integer value) 
	{
		ReplyPathRequestedEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private ReplyPathRequestedEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
