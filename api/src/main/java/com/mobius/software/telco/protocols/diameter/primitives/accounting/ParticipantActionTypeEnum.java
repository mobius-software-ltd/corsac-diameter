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
 * 	7.2.133 Participant-Action-Type AVP
	The Participant-Action-Type AVP (AVP code 2049) is of type Enumerated and holds the participant's action type
	during the conference for Billing Domain's information. The following values are defined according to TS 24.605
	[219]:
	
	0 CREATE_CONF
	1 JOIN_CONF
	2 INVITE_INTO_CONF
	3 QUIT_CONF 
 */
public enum ParticipantActionTypeEnum implements IntegerEnum
{
	CREATE_CONF(0),JOIN_CONF(1),INVITE_INTO_CONF(2),QUIT_CONF(3);

	private static final Map<Integer, ParticipantActionTypeEnum> intToTypeMap = new HashMap<Integer, ParticipantActionTypeEnum>();
	static 
	{
	    for (ParticipantActionTypeEnum type : ParticipantActionTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static ParticipantActionTypeEnum fromInt(Integer value) 
	{
		ParticipantActionTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private ParticipantActionTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
