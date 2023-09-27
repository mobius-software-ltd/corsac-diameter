package com.mobius.software.telco.protocols.diameter.primitives.tsp;

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
 *	6.4.10	Delivery-Outcome AVP
	The Delivery-Outcome AVP (AVP code 3009) is of type Enumerated, and informs the SCS of the outcome of the device action request. The Delivery-Outcome AVP can be included in Device-Notification-Request command.
	The following values are defined:

	SUCCESS (0)
	This value indicates that the device action request was successfully completed. The value SUCCESSFUL_TRANSFER specified in TS 29.337 [17], clause 6.3.1 shall be mapped to this value.

	EXPIRED (1)
	This value indicates that the validity period expired before the trigger could be delivered. The value VALIDITY_TIME_EXPIRED specified in TS 29.337 [17], clause 6.3.1 shall be mapped to this value. (Temporary error)

	TEMPORARYERROR (2)
	This value indicates that this trigger encountered a temporary network error.

	UNDELIVERABLE (3)
	This value indicates that this trigger encountered a delivery error and is deemed permanently undeliverable. The values ABSENT_SUBSCRIBER and UE_MEMORY_CAPACITY_EXCEEDED specified in TS 29.337 [17], clause 6.3.1 shall be mapped to this value.
	
	UNCONFIRMED (4)
	This value indicates that the delivery of the device action request is not confirmed.

	NOTE:	The Absent-Subscriber-Diagnostic-T4 AVP specified in TS 29.337 [17], clause 6.3.2 is connected with the ABSENT_SUBSCRIBER value in the SM-Delivery-Outcome-T4 AVP. The Absent-Subscriber-Diagnostic-T4 AVP values will not be forwarded via the Tsp interface.
 */
public enum DeliveryOutcomeEnum implements IntegerEnum
{
	SUCCESS (0),EXPIRED (1),TEMPORARYERROR (2),UNDELIVERABLE (3),UNCONFIRMED (4);

	private static final Map<Integer, DeliveryOutcomeEnum> intToTypeMap = new HashMap<Integer, DeliveryOutcomeEnum>();
	static
	{
	    for (DeliveryOutcomeEnum type : DeliveryOutcomeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static DeliveryOutcomeEnum fromInt(Integer value) 
	{
		DeliveryOutcomeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private DeliveryOutcomeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
