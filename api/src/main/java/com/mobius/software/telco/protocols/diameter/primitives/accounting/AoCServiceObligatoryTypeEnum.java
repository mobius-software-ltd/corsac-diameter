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
 * 	7.2.18 AoC-Service-Obligatory-Type AVP
	The AoC-Service-Obligatory-Type AVP (AVP code 2312) is of type Enumerated and holds the information if the AoC
	information is binding or not. It can be one of the following values:

	0 NON_BINDING
	1 BINDING 
 */
public enum AoCServiceObligatoryTypeEnum implements IntegerEnum
{
	NON_BINDING(0),BINDING(1);

	private static final Map<Integer, AoCServiceObligatoryTypeEnum> intToTypeMap = new HashMap<Integer, AoCServiceObligatoryTypeEnum>();
	static 
	{
	    for (AoCServiceObligatoryTypeEnum type : AoCServiceObligatoryTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static AoCServiceObligatoryTypeEnum fromInt(Integer value) 
	{
		AoCServiceObligatoryTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private AoCServiceObligatoryTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
