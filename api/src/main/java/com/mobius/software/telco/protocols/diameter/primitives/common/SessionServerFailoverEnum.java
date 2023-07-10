package com.mobius.software.telco.protocols.diameter.primitives.common;

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
public enum SessionServerFailoverEnum implements IntegerEnum
{
	REFUSE_SERVICE(0),TRY_AGAIN(1),ALLOW_SERVICE(2),TRY_AGAIN_ALLOW_SERVICE(3);

	private static final Map<Integer, SessionServerFailoverEnum> intToTypeMap = new HashMap<Integer, SessionServerFailoverEnum>();
	static 
	{
	    for (SessionServerFailoverEnum type : SessionServerFailoverEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static SessionServerFailoverEnum fromInt(Integer value) 
	{
		SessionServerFailoverEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private SessionServerFailoverEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
