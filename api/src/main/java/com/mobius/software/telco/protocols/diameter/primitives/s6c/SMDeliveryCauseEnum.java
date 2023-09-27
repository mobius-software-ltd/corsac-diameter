package com.mobius.software.telco.protocols.diameter.primitives.s6c;

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
 * 	5.3.3.19	SM-Delivery-Cause
	The SM-Delivery-Cause AVP is of type Enumerated and shall indicate the cause of the SMP delivery result. The following values are defined:

	-	UE_ MEMORY_CAPACITY_EXCEEDED (0)

	-	ABSENT_USER (1)

	-	SUCCESSFUL_TRANSFER (2)
 */
public enum SMDeliveryCauseEnum implements IntegerEnum
{
	MEMORY_CAPACITY_EXCEEDED(0),ABSENT_USER(1),SUCCESSFUL_TRANSFER(2);

	private static final Map<Integer, SMDeliveryCauseEnum> intToTypeMap = new HashMap<Integer, SMDeliveryCauseEnum>();
	static
	{
	    for (SMDeliveryCauseEnum type : SMDeliveryCauseEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static SMDeliveryCauseEnum fromInt(Integer value) 
	{
		SMDeliveryCauseEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private SMDeliveryCauseEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
