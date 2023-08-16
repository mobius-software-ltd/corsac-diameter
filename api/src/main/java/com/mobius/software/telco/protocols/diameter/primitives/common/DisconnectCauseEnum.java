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
 * 5.4.3.   Disconnect-Cause AVP

   The Disconnect-Cause AVP (AVP Code 273) is of type Enumerated.  A
   Diameter node MUST include this AVP in the Disconnect-Peer-Request
   message to inform the peer of the reason for its intention to shut
   down the transport connection.  The following values are supported:

      REBOOTING                         0
         A scheduled reboot is imminent.  A receiver of a DPR with
         above result code MAY attempt reconnection.

      BUSY                              1
         The peer's internal resources are constrained, and it has
         determined that the transport connection needs to be closed.
         A receiver of a DPR with above result code SHOULD NOT attempt
         reconnection.

      DO_NOT_WANT_TO_TALK_TO_YOU        2
         The peer has determined that it does not see a need for the
         transport connection to exist, since it does not expect any
         messages to be exchanged in the near future.  A receiver of a
         DPR with above result code SHOULD NOT attempt reconnection.
 */
public enum DisconnectCauseEnum implements IntegerEnum
{
	REBOOTING(0),BUSY(1),DO_NOT_WANT_TO_TALK_TO_YOU(2);

	private static final Map<Integer, DisconnectCauseEnum> intToTypeMap = new HashMap<Integer, DisconnectCauseEnum>();
	static 
	{
	    for (DisconnectCauseEnum type : DisconnectCauseEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static DisconnectCauseEnum fromInt(Integer value) 
	{
		DisconnectCauseEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private DisconnectCauseEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
