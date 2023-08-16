package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol;

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
 * 8.15.  Direct-Debiting-Failure-Handling AVP (DDFH)

   The DDFH (AVP Code 428) is of type Enumerated.  The credit-control
   client uses information in this AVP to decide what to do if sending
   credit-control messages (Requested-Action AVP set to DIRECT_DEBITING)
   to the credit-control server has been, for instance, temporarily
   prevented due to a network problem.

   The following values are defined for the DDFH:

   TERMINATE_OR_BUFFER   0

   When the DDFH is set to TERMINATE_OR_BUFFER, the service MUST be
   granted for as long as there is a connection to the credit-control
   server.  If the credit-control client does not receive any
   Credit-Control-Answer messages before the Tx timer (as defined in
   Section 13) expires, the credit-control request is regarded as
   failed.  The client SHOULD terminate the service if it can determine
   from the failed answer that units have not been debited.  Otherwise,
   the credit-control client SHOULD grant the service, store the request
   in application-level non-volatile storage, and try to resend the
   request.  These requests MUST be marked as possible duplicates by
   setting the T flag in the command header as described in [RFC6733],
   Section 3.  This is the default behavior if the AVP isn't included in
   the reply from the authorization server.

   CONTINUE              1

   When the DDFH is set to CONTINUE, the service SHOULD be granted, even
   if credit-control messages can't be delivered, and the request should
   be deleted.
 */
public enum DirectDebitingFailureHandlingEnum implements IntegerEnum
{
	TERMINATE_OR_BUFFER(0),CONTINUE(1);

	private static final Map<Integer, DirectDebitingFailureHandlingEnum> intToTypeMap = new HashMap<Integer, DirectDebitingFailureHandlingEnum>();
	static 
	{
	    for (DirectDebitingFailureHandlingEnum type : DirectDebitingFailureHandlingEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static DirectDebitingFailureHandlingEnum fromInt(Integer value) 
	{
		DirectDebitingFailureHandlingEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private DirectDebitingFailureHandlingEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
