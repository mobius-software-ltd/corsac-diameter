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
 * 4.1.7.18.  Use-Assigned-Address AVP

   In some scenarios, the AAA does not know the IP address assigned to
   the managed terminal at the time that the classifier is sent to the
   Classifying Entity.  The Use-Assigned-Address AVP (AVP Code 534) is
   of type Enumerated containing the values of True or False.  When
   present and set to True, it represents the IP address assigned to the
   managed terminal.

     Value | Name
     ------+--------
       0   | False
       1   | True
 */
public enum UseAssignedAddressEnum implements IntegerEnum
{
	FALSE(0),TRUE(1);

	private static final Map<Integer, UseAssignedAddressEnum> intToTypeMap = new HashMap<Integer, UseAssignedAddressEnum>();
	static
	{
	    for (UseAssignedAddressEnum type : UseAssignedAddressEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static UseAssignedAddressEnum fromInt(Integer value) 
	{
		UseAssignedAddressEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private UseAssignedAddressEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
