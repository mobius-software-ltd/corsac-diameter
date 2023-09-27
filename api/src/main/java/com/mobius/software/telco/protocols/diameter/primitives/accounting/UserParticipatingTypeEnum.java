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
 * 	7.2.241 User-Participating-Type AVP
	The User-Participating-Type AVP(AVP code 1279) is of type Enumerated. It is a subfield of Participants-Group AVP
	to indicate the user participating type when participating in the PoC session. The AVP may take the values as follows:
	
	0 Normal
	1 NW PoC Box
	2 UE PoC Box
 */
public enum UserParticipatingTypeEnum implements IntegerEnum
{
	NORMAL(0),NW_POC_BOX(1),UE_POC_BOX(2);

	private static final Map<Integer, UserParticipatingTypeEnum> intToTypeMap = new HashMap<Integer, UserParticipatingTypeEnum>();
	static 
	{
	    for (UserParticipatingTypeEnum type : UserParticipatingTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static UserParticipatingTypeEnum fromInt(Integer value) 
	{
		UserParticipatingTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private UserParticipatingTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
