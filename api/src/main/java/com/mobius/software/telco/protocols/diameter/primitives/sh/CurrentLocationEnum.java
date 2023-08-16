package com.mobius.software.telco.protocols.diameter.primitives.sh;

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
 * 6.3.8 Current-Location AVP
	The Current-Location AVP is of type Enumerated, and indicates whether an active location retrieval has to be initiated
	or not:

	DoNotNeedInitiateActiveLocationRetrieval (0)
		The request indicates that the initiation of an active location retrieval is not required.
	InitiateActiveLocationRetrieval (1)
		It is requested that an active location retrieval is initiated. 
 */
public enum CurrentLocationEnum implements IntegerEnum
{
	DO_NOT_NEED_INITIATE_ACTIVE_LOCATION_RETRIEVAL(0),INITIATE_ACTIVE_LOCATION_RETRIEVAL(1);

	private static final Map<Integer, CurrentLocationEnum> intToTypeMap = new HashMap<Integer, CurrentLocationEnum>();
	static
	{
	    for (CurrentLocationEnum type : CurrentLocationEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static CurrentLocationEnum fromInt(Integer value) 
	{
		CurrentLocationEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private CurrentLocationEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
