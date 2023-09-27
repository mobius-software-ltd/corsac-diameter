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
 * 	6.3.43	Location-Update-Event-Type
	The Location-Update-Event-Type AVP is of type Unsigned32 and contains an 32-bit address space representing types of events that will trigger a location update. The following values are defined:

	UE_AVAILABLE (0)
	This value shall be used to indicate that the location update trigger is any event in which the MSC/SGSN/MME has established a contact with the UE.

	CHANGE_OF_AREA (1)
	This value shall be used to indicate that the location update trigger is an event where the UE enters or leaves a pre-defined geographical area or if the UE is currently within the pre-defined geographical area.

	PERIODIC_LOCATION (2)
	This value shall be used to indicate that the location update trigger is an event where a defined periodic timer expires in the UE and activates a location report or a location request

	The types of event listed above are defined in the clause 4.4.2.1 of the 3GPP TS 23.271 [24] 
 */
public enum LocationUpdateEventTypeEnum implements IntegerEnum
{
	UE_AVAILABLE(0),CHANGE_OF_AREA(1),PERIODIC_LOCATION(2);

	private static final Map<Integer, LocationUpdateEventTypeEnum> intToTypeMap = new HashMap<Integer, LocationUpdateEventTypeEnum>();
	static
	{
	    for (LocationUpdateEventTypeEnum type : LocationUpdateEventTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static LocationUpdateEventTypeEnum fromInt(Integer value) 
	{
		LocationUpdateEventTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private LocationUpdateEventTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
