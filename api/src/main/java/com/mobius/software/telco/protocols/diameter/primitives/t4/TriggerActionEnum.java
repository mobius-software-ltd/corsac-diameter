package com.mobius.software.telco.protocols.diameter.primitives.t4;

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
 * 	6.3.6	Trigger-Action
	The Trigger Action AVP is of type Unsigned32 and indicates the type of the device trigger. The following values are defined:

	TRIGGER (0)
	This value is used when device trigger requests the storage and sending of a new device trigger.

	RECALL (1)
	This value is used when device trigger requests the removal of a pending device trigger.

	REPLACE (2)
	This value is used when device trigger requests the replacement of a pending device trigger.
 */
public enum TriggerActionEnum implements IntegerEnum
{
	TRIGGER(0),RECALL(1),REPLACE(2);

	private static final Map<Integer, TriggerActionEnum> intToTypeMap = new HashMap<Integer, TriggerActionEnum>();
	static
	{
	    for (TriggerActionEnum type : TriggerActionEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static TriggerActionEnum fromInt(Integer value) 
	{
		TriggerActionEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private TriggerActionEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
