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
 * 	7.2.142 PoC-Event-Type AVP
	The PoC-Event-Type AVP (AVP code 2025) is of type Enumerated and indicates PoC session unrelated charging event.
	The AVP may take the values as follows:

	0 Normal;
	1 Instant Ppersonal Aalert event;
	2 PoC Group Advertisement event;
	3 Early Ssession Setting-up event;
	4 PoC Talk Burst 
 */
public enum PoCEventTypeEnum implements IntegerEnum
{
	NORMAL(0),INSTANT_PERSONAL_ALERT(1),POC_GROUP_ADVERTISEMENT(2),EARLY_SESSION_SETTING_UP(3),POC_TALK_BURST(4);

	private static final Map<Integer, PoCEventTypeEnum> intToTypeMap = new HashMap<Integer, PoCEventTypeEnum>();
	static 
	{
	    for (PoCEventTypeEnum type : PoCEventTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static PoCEventTypeEnum fromInt(Integer value) 
	{
		PoCEventTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private PoCEventTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
