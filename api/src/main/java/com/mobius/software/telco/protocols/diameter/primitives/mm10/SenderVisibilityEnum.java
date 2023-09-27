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
 * 	6.3.16	Sender-Visibility AVP
	The Sender-Visibility AVP (AVP code 1113) is of type Enumerated. It indicates whether the sender identification is requested to be hidden or not.

	Sender Identification requested not to be hidden (0)

	Sender Identification requested to be hidden (1)

	If the Sender-Visibility AVP is not present, then the default "Sender Identification requested not to be hidden" shall be assumed.
 */
public enum SenderVisibilityEnum implements IntegerEnum
{
	SENDER_IDENTIFICATION_REQUESTED_NOT_TO_BE_HIDDEN(0),SENDER_IDENTIFICATION_REQUESTED_TO_BE_HIDDEN(1);

	private static final Map<Integer, SenderVisibilityEnum> intToTypeMap = new HashMap<Integer, SenderVisibilityEnum>();
	static
	{
	    for (SenderVisibilityEnum type : SenderVisibilityEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static SenderVisibilityEnum fromInt(Integer value) 
	{
		SenderVisibilityEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private SenderVisibilityEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
