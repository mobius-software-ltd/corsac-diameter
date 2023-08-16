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
 * 6.3.22 One-Time-Notification AVP
	The One-Time-Notification AVP is of type Enumerated. If present it indicates that the sender requests to be notified
	only one time. The following values are defined:

	ONE_TIME_NOTIFICATION_REQUESTED (0)
	
	This AVP is only applicable to UE reachability for IP (25) 
 */
public enum OneTimeNotificationEnum implements IntegerEnum
{
	ONE_TIME_NOTIFICATION_REQUESTED(0);

	private static final Map<Integer, OneTimeNotificationEnum> intToTypeMap = new HashMap<Integer, OneTimeNotificationEnum>();
	static
	{
	    for (OneTimeNotificationEnum type : OneTimeNotificationEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static OneTimeNotificationEnum fromInt(Integer value) 
	{
		OneTimeNotificationEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private OneTimeNotificationEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
