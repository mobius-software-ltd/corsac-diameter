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
 * 	7.2.132 Participant-Access-Priority AVP
	Participant-Access-Priority AVP (AVP code 1259) is of type Enumerated. It is a subfield of Participants-Group AVP to
	indicate the priority level for users when initiating a new PoC session or participating in a PoC session. The AVP may
	take the values as follows:

	1 Pre-emptive priority:
	The highest level priority. A request with pre-emptive priority SHALL cause the current other requests to
	be revoked immediately, unless they are also with pre-emptive priority

	2 High priority: Lower than Pre-emptive priority

	3 Normal priority: Normal level. Lower than High priority

	4 Low priority: Lowest level priority 
 */
public enum ParticipantAccessPriorityEnum implements IntegerEnum
{
	PREMPTIVE(0),HIGH(1),NORMAL(2),LOW(3);

	private static final Map<Integer, ParticipantAccessPriorityEnum> intToTypeMap = new HashMap<Integer, ParticipantAccessPriorityEnum>();
	static 
	{
	    for (ParticipantAccessPriorityEnum type : ParticipantAccessPriorityEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static ParticipantAccessPriorityEnum fromInt(Integer value) 
	{
		ParticipantAccessPriorityEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private ParticipantAccessPriorityEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
