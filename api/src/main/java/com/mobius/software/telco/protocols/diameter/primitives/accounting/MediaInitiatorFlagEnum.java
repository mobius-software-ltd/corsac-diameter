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
 * 	7.2.101 Media-Initiator-Flag AVP
	The Media-Initiator-Flag AVP (AVP code 882) is of type Enumerated and indicates which party has requested the
	session modification. The default value is '0' indicating the called party initiated the modification:
	
	0 called party
	1 calling party
	2 unknown
 */
public enum MediaInitiatorFlagEnum implements IntegerEnum
{
	CALLED_PARTY(0),CALLING_PARTY(1),UNKNOWN(2);

	private static final Map<Integer, MediaInitiatorFlagEnum> intToTypeMap = new HashMap<Integer, MediaInitiatorFlagEnum>();
	static 
	{
	    for (MediaInitiatorFlagEnum type : MediaInitiatorFlagEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static MediaInitiatorFlagEnum fromInt(Integer value) 
	{
		MediaInitiatorFlagEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private MediaInitiatorFlagEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
