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
 * 	7.2.40 Class-Identifier AVP
	The Class-Identifier AVP (AVP code 1214) is of type Enumerated and the values are:
	
	0 Personal
	1 Advertisement
	2 Informational
	3 Auto
 */
public enum ClassIdentifierEnum implements IntegerEnum
{
	PRESONAL(0),ADVERTISEMENT(1),INFORMATIONAL(2),AUTO(3);

	private static final Map<Integer, ClassIdentifierEnum> intToTypeMap = new HashMap<Integer, ClassIdentifierEnum>();
	static 
	{
	    for (ClassIdentifierEnum type : ClassIdentifierEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static ClassIdentifierEnum fromInt(Integer value) 
	{
		ClassIdentifierEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private ClassIdentifierEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
