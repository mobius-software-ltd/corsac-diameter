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
 * 8.18.  Session-Server-Failover AVP

   The Session-Server-Failover AVP (AVP Code 271) is of type Enumerated
   and MAY be present in application-specific authorization answer
   messages that either do not include the Session-Binding AVP or
   include the Session-Binding AVP with any of the bits set to a zero
   value.  If present, this AVP MAY inform the Diameter client that if a
   re-auth or STR message fails due to a delivery problem, the Diameter
   client SHOULD issue a subsequent message without the Destination-Host
   AVP.  When absent, the default value is REFUSE_SERVICE.

   The following values are supported:

   REFUSE_SERVICE 0

      If either the re-auth or the STR message delivery fails, terminate
      service with the user and do not attempt any subsequent attempts.
      
   TRY_AGAIN 1

      If either the re-auth or the STR message delivery fails, resend
      the failed message without the Destination-Host AVP present.

   ALLOW_SERVICE 2

      If re-auth message delivery fails, assume that re-authorization
      succeeded.  If STR message delivery fails, terminate the session.

   TRY_AGAIN_ALLOW_SERVICE 3

      If either the re-auth or the STR message delivery fails, resend
      the failed message without the Destination-Host AVP present.  If
      the second delivery fails for re-auth, assume re-authorization
      succeeded.  If the second delivery fails for STR, terminate the
      session.            
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
