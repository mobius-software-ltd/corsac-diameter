package com.mobius.software.telco.protocols.diameter.primitives.t4;

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
 * 	6.3.1	SM-Delivery-Outcome-T4
	The SM-Delivery-Outcome-T4 AVP is of type Enumerated and indicates the outcomes of the device trigger delivery. The following values are defined:

	ABSENT_SUBSCRIBER (0)
	This value is used when the device trigger delivery failed due to absent subscriber.

	UE_MEMORY_CAPACITY_EXCEEDED (1)
	This value is used when the device trigger delivery failed due to UE memory capacity exceeded.

	SUCCESSFUL_TRANSFER (2)
	This value is used when the device trigger delivery is successfully transferred to the UE.

	VALIDITY_TIME_EXPIRED (3)
	This value is used when the message was deleted in the SMS-SC due to expiration of the validity time.
 */
public enum SMDeliveryOutcomeT4Enum implements IntegerEnum
{
	ABSENT_SUBSCRIBER(0),UE_MEMORY_CAPACITY_EXCEEDED(1),SUCCESSFUL_TRANSFER(2),VALIDITY_TIME_EXPIRED(3);

	private static final Map<Integer, SMDeliveryOutcomeT4Enum> intToTypeMap = new HashMap<Integer, SMDeliveryOutcomeT4Enum>();
	static
	{
	    for (SMDeliveryOutcomeT4Enum type : SMDeliveryOutcomeT4Enum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static SMDeliveryOutcomeT4Enum fromInt(Integer value) 
	{
		SMDeliveryOutcomeT4Enum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private SMDeliveryOutcomeT4Enum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
