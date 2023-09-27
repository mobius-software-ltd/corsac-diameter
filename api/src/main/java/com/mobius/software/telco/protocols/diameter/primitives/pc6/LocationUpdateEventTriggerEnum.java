package com.mobius.software.telco.protocols.diameter.primitives.pc6;

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
 * 	6.3.45	Location-Update-Event-Trigger
	The Location-Update-Event-Type AVP is of type Unsigned32 and contains a 32-bit address space representing the possible change of area events i.e. UE enters, leaves or is within requested target area. The following values are defined:

	UE_ENTRY (0)
	This value shall be used to indicate the event trigger is the UE entering a pre-defined geographical area.

	UE_EXIT (1)
	This value shall be used to indicate the event trigger is the UE leaving a pre-defined geographical area

	UE_PRESENCE (2)
	This value shall be used to indicate the event trigger is the current presence of the UE within a pre-defined geographical area.

	The types of change of area event listed above are defined in the clause 4.4.2.1 of the 3GPP TS 23.271 [24]. 
 */
public enum LocationUpdateEventTriggerEnum implements IntegerEnum
{
	UE_ENTRY(0),UE_EXIT(1),UE_PRESENCE(2);

	private static final Map<Integer, LocationUpdateEventTriggerEnum> intToTypeMap = new HashMap<Integer, LocationUpdateEventTriggerEnum>();
	static
	{
	    for (LocationUpdateEventTriggerEnum type : LocationUpdateEventTriggerEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static LocationUpdateEventTriggerEnum fromInt(Integer value) 
	{
		LocationUpdateEventTriggerEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private LocationUpdateEventTriggerEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
