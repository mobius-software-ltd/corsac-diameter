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
 * 	5.3.98 Mute-Notification AVP
	The Mute-Notification AVP (AVP code 2809) is of type Enumerated, and it is used to mute the notification to the
	PCRF of the detected application's start/stop for the specific PCC Rule from the PCEF.
	The following values are defined:

	MUTE_REQUIRED (0)
 		This value is used to indicate that the PCEF shall not inform the PCRF when the application's start/stop for the
		specific PCC rule(s) is detected.

	Mute-Notification AVP shall be used for solicited application reporting only.
	Absence of this AVP means that application start/stop notifications shall be sent for the detected application. 
 */
public enum MuteNotificationEnum implements IntegerEnum
{
	MUTE_REQUIRED(0);

	private static final Map<Integer, MuteNotificationEnum> intToTypeMap = new HashMap<Integer, MuteNotificationEnum>();
	static
	{
	    for (MuteNotificationEnum type : MuteNotificationEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static MuteNotificationEnum fromInt(Integer value) 
	{
		MuteNotificationEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private MuteNotificationEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
