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
/*
 * 8.15.  Termination-Cause AVP

   The Termination-Cause AVP (AVP Code 295) is of type Enumerated, and
   is used to indicate the reason why a session was terminated on the
   access device.  The currently assigned values for this AVP can be
   found in the IANA registry for Termination-Cause AVP Values
   [IANATCV].
 */
public enum TerminationCauseEnum implements IntegerEnum
{
	RESERVED(0),DIAMETER_LOGOUT(1),DIAMETER_SERVICE_NOT_PROVIDED(2),DIAMETER_BAD_ANSWER(3),DIAMETER_ADMINISTRATIVE(4),DIAMETER_LINK_BROKEN(5),DIAMETER_AUTH_EXPIRED(6),DIAMETER_USER_MOVED(7),DIAMETER_SESSION_TIMEOUT(8),USER_REQUEST(11),LOST_CARRIER(12),LOST_SERVICE(13),IDLE_TIMEOUT(14),SESSION_TIMEOUT(15),ADMIN_RESET(16),ADMIN_REBOOT(17),PORT_ERROR(18),NAS_ERROR(19),NAS_REQUEST(20),NAS_REBOOT(21),PORT_UNNEEDED(22),PORT_PREEMPTED(23),PORT_SUSPENDED(24),SERVICE_UNAVAILABLE(25),CALLBACK(26),USER_ERROR(27),HOST_REQUEST(28),SUPPLICANT_RESTART(29),REAUTHENTICATION_FAILURE(30),PORT_REINITIALIZED(31),PORT_ADMINISTRATIVELY_DISABLED(32);

	private static final Map<Integer, TerminationCauseEnum> intToTypeMap = new HashMap<Integer, TerminationCauseEnum>();
	static 
	{
	    for (TerminationCauseEnum type : TerminationCauseEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static TerminationCauseEnum fromInt(Integer value) 
	{
		TerminationCauseEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private TerminationCauseEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
