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
 * 4.3.3.  Prompt AVP

   The Prompt AVP (AVP Code 76) is of type Enumerated and MAY be present
   in the AA-Answer message.  When present, it is used by the NAS to
   determine whether the user's response, when entered, should be
   echoed.

   The supported values are listed in [RADIUSAttrVals].
 */
public enum PromptEnum implements IntegerEnum
{
	NO_ECHO(0),ECHO(1);

	private static final Map<Integer, PromptEnum> intToTypeMap = new HashMap<Integer, PromptEnum>();
	static
	{
	    for (PromptEnum type : PromptEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static PromptEnum fromInt(Integer value) 
	{
		PromptEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private PromptEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
