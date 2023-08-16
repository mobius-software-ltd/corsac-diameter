package com.mobius.software.telco.protocols.diameter.primitives.gx;

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
 * 	5.3.125 Resource-Release-Notification AVP (All access types)
	The Resource-Release-Notification AVP (AVP code 2841) is of type Enumerated.
	If the Resource-Release-Notification AVP is included within a Charging-Rule-Remove AVP it defines whether the
	rules included within the Charging-Rule-Remove AVP need to be notified.
	The following values are defined:

	ENABLE_NOTIFICATION (0)
 		This value shall be used to indicate that the outcome of the release of resources for the related PCC rules shall be
		notified.
 */
public enum ResourceReleaseNotificationEnum implements IntegerEnum
{
	ENABLE_NOTIFICATION(0);

	private static final Map<Integer, ResourceReleaseNotificationEnum> intToTypeMap = new HashMap<Integer, ResourceReleaseNotificationEnum>();
	static
	{
	    for (ResourceReleaseNotificationEnum type : ResourceReleaseNotificationEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static ResourceReleaseNotificationEnum fromInt(Integer value) 
	{
		ResourceReleaseNotificationEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private ResourceReleaseNotificationEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
