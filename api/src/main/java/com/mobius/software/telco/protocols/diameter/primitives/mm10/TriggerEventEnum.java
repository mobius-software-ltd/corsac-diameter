package com.mobius.software.telco.protocols.diameter.primitives.mm10;

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
 * 	6.3.5	Trigger-Event AVP
	The Trigger-Event AVP (AVP code 1103) is of type Enumerated. It indicates the type of the event that triggered the Message-Process-Request.

	MM1 Message Submission, Profile based (0)
	MM1 Message Submission, Address based (1)
	MM1 Message Delivery (2)
	MM7 Message Submission, Profile based (3)
	MM7 Message Submission, Address based (4)
 */
public enum TriggerEventEnum implements IntegerEnum
{
	MM1_SUBMISSION_PROFILE_BASED(0),MM1_SUBMISSION_ADDRESS_BASED(1),MM1_DELIVERY(2),MM7_SUBMISSION_PROFILE_BASED(3),MM7_SUBMISSION_ADDRESS_BASED(4);

	private static final Map<Integer, TriggerEventEnum> intToTypeMap = new HashMap<Integer, TriggerEventEnum>();
	static
	{
	    for (TriggerEventEnum type : TriggerEventEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static TriggerEventEnum fromInt(Integer value) 
	{
		TriggerEventEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private TriggerEventEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
