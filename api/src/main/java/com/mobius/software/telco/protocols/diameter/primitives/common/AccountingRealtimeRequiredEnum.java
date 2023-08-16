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
 * 9.8.7.   Accounting-Realtime-Required AVP

   The Accounting-Realtime-Required AVP (AVP Code 483) is of type
   Enumerated and is sent from the Diameter home authorization server to
   the Diameter client or in the Accounting-Answer from the accounting
   server.  The client uses information in this AVP to decide what to do
   if the sending of accounting records to the accounting server has
   been temporarily prevented due to, for instance, a network problem.

   DELIVER_AND_GRANT 1

      The AVP with Value field set to DELIVER_AND_GRANT means that the
      service MUST only be granted as long as there is a connection to
      an accounting server.  Note that the set of alternative accounting
      servers are treated as one server in this sense.  Having to move
      the accounting record stream to a backup server is not a reason to
      discontinue the service to the user.

   GRANT_AND_STORE 2

      The AVP with Value field set to GRANT_AND_STORE means that service
      SHOULD be granted if there is a connection, or as long as records
      can still be stored as described in Section 9.4.

      This is the default behavior if the AVP isn't included in the
      reply from the authorization server.

   GRANT_AND_LOSE 3

      The AVP with Value field set to GRANT_AND_LOSE means that service
      SHOULD be granted even if the records cannot be delivered or
      stored.
 */
public enum AccountingRealtimeRequiredEnum implements IntegerEnum
{
	DELIVER_AND_GRANT(1),GRANT_AND_STORE(2),GRANT_AND_LOSE(3);

	private static final Map<Integer, AccountingRealtimeRequiredEnum> intToTypeMap = new HashMap<Integer, AccountingRealtimeRequiredEnum>();
	static 
	{
	    for (AccountingRealtimeRequiredEnum type : AccountingRealtimeRequiredEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static AccountingRealtimeRequiredEnum fromInt(Integer value) 
	{
		AccountingRealtimeRequiredEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private AccountingRealtimeRequiredEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
