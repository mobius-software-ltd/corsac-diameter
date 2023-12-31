package com.mobius.software.telco.protocols.diameter.primitives.mm10;

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
 * 	6.3.15	Read-Reply AVP
	The Read-Reply AVP (AVP code 1112) is of type Enumerated. It indicates whether a delivery report is requested.

	No Read Reply Requested (0)
	Read Reply Requested (1)

	If the Read-Reply AVP is not present, then the default "No Read Reply Requested" shall be assumed.
 */
public enum ReadReplyEnum implements IntegerEnum
{
	NO_READ_REPLY_REQUESTED(0),READ_REPLY_REQUESTED(1);

	private static final Map<Integer, ReadReplyEnum> intToTypeMap = new HashMap<Integer, ReadReplyEnum>();
	static
	{
	    for (ReadReplyEnum type : ReadReplyEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static ReadReplyEnum fromInt(Integer value) 
	{
		ReadReplyEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private ReadReplyEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
