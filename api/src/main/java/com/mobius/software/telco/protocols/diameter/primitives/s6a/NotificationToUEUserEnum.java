package com.mobius.software.telco.protocols.diameter.primitives.s6a;

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
 * 	7.3.89	Notification-To-UE-User
	The Notification- To-UE-User AVP is of type Enumerated. The following values are defined:

	NOTIFY_LOCATION_ALLOWED (0)

	NOTIFYANDVERIFY_LOCATION_ALLOWED_IF_NO_RESPONSE (1)

	NOTIFYANDVERIFY_LOCATION_NOT_ALLOWED_IF_NO_RESPONSE (2)

	LOCATION_NOT_ALLOWED (3)
 */
public enum NotificationToUEUserEnum implements IntegerEnum
{
	NOTIFY_LOCATION_ALLOWED(0),NOTIFYANDVERIFY_LOCATION_ALLOWED_IF_NO_RESPONSE(1),NOTIFYANDVERIFY_LOCATION_NOT_ALLOWED_IF_NO_RESPONSE(2),LOCATION_NOT_ALLOWED(3);

	private static final Map<Integer, NotificationToUEUserEnum> intToTypeMap = new HashMap<Integer, NotificationToUEUserEnum>();
	static
	{
	    for (NotificationToUEUserEnum type : NotificationToUEUserEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static NotificationToUEUserEnum fromInt(Integer value) 
	{
		NotificationToUEUserEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private NotificationToUEUserEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
