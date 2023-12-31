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
 * 	7.2.219A TAD-Identifier AVP
	The TAD-Identifier AVP (AVP code 2717) is of type Enumerated and indicates the type of access network (CS or PS)
	through which the session shall be terminated. It can be one of the following values:
	
	0 CS
	1 PS 
 */
public enum TADIdentifierEnum implements IntegerEnum
{
	CS(0),PS(1);

	private static final Map<Integer, TADIdentifierEnum> intToTypeMap = new HashMap<Integer, TADIdentifierEnum>();
	static 
	{
	    for (TADIdentifierEnum type : TADIdentifierEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static TADIdentifierEnum fromInt(Integer value) 
	{
		TADIdentifierEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private TADIdentifierEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
