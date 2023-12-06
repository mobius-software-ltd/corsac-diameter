package com.mobius.software.telco.protocols.diameter.primitives.sy;

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
 * 	5.3.4	SL-Request-Type AVP
	The SL-Request-Type AVP (AVP code 2904) is of type Enumerated, and informs the OCS whether the SLR command is being sent as part of the initial or intermediate spending limit report request procedure.
	The following values are defined:

	INITIAL_REQUEST (0)
	This value indicates that this is the first request in the Diameter session.

	INTERMEDIATE_REQUEST (1)
	This value indicates that this is the second or subsequent request in the Diameter session. 
 */
public enum SLRequestTypeEnum implements IntegerEnum
{
	INITIAL_REQUEST(0),INTERMEDIATE_REQUEST(1);

	private static final Map<Integer, SLRequestTypeEnum> intToTypeMap = new HashMap<Integer, SLRequestTypeEnum>();
	static
	{
	    for (SLRequestTypeEnum type : SLRequestTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static SLRequestTypeEnum fromInt(Integer value) 
	{
		SLRequestTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private SLRequestTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
