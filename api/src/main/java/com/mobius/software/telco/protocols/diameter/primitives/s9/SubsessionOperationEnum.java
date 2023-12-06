package com.mobius.software.telco.protocols.diameter.primitives.s9;

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
 * 	5.3.4	Subsession-Operation
	The Subsession-Operation AVP (AVP code 2203) is of type of Enumerated, and it indicates the operation to be performed on the subsession.
 	The following values are defined:

	TERMINATION (0)
	This value is used to indicate that a subsession is being terminated.

	ESTABLISHMENT (1)
	This value is used to indicate that a new subsession is being established.

	MODIFICATION (2)
	This value is used to indicate that an existing subsession is being modified.
 */
public enum SubsessionOperationEnum implements IntegerEnum
{
	TERMINATION(0),ESTABLISHMENT(1),MODIFICATION(2);

	private static final Map<Integer, SubsessionOperationEnum> intToTypeMap = new HashMap<Integer, SubsessionOperationEnum>();
	static
	{
	    for (SubsessionOperationEnum type : SubsessionOperationEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static SubsessionOperationEnum fromInt(Integer value) 
	{
		SubsessionOperationEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private SubsessionOperationEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
