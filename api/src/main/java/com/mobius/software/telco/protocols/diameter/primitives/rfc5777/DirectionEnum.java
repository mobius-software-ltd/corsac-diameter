package com.mobius.software.telco.protocols.diameter.primitives.rfc5777;

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
 * 4.1.4.  Direction AVP

   The Direction AVP (AVP Code 514) is of type Enumerated and specifies
   in which direction to apply the classifier.  The values of the
   enumeration are "IN","OUT","BOTH".  In the "IN" and "BOTH"
   directions, the From-Spec refers to the address of the managed
   terminal and the To-Spec refers to the unmanaged terminal.  In the
   "OUT" direction, the From-Spec refers to the unmanaged terminal
   whereas the To-Spec refers to the managed terminal.  If the Direction
   AVP is omitted, the classifier matches packets flowing in both
   directions.

     Value | Name and Semantic
     ------+--------------------------------------------------
       0   | IN - The classifier applies to flows from the
           | managed terminal.
       1   | OUT - The classifier applies to flows to the
           | managed terminal.
       2   | BOTH - The classifier applies to flows both to
           | and from the managed terminal.
 */
public enum DirectionEnum implements IntegerEnum
{
	IN(0),OUT(1),BOTH(2);

	private static final Map<Integer, DirectionEnum> intToTypeMap = new HashMap<Integer, DirectionEnum>();
	static
	{
	    for (DirectionEnum type : DirectionEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static DirectionEnum fromInt(Integer value) 
	{
		DirectionEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private DirectionEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
