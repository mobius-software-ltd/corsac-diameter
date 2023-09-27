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
 *	6.4.6	Action-Type AVP
	The Action-Type AVP (AVP code 3005) is of type Enumerated, and informs the MTC-IWF of what action type is required in the request and also informs the SCS of what action type is reported.
	The following values are defined:

	Device Trigger Request (1)
	This value indicates a device trigger request and is used:
	-	in the Device-Action AVP of the Device-Action-Request command;
	-	in the Device-Notification AVP of the Device-Action-Answer command.

	Delivery Report (2)
	This value indicates a delivery report sent from MTC-IWF to the SCS and is used:
	-	in the Device-Notification AVP of the Device-Notification-Request command.

	Device Trigger Recall (3)
	This value indicates a device trigger recall request and is used:
	-	in the Device-Action AVP of the Device-Action-Request command;
	-	in the Device-Notification AVP of the Device-Action-Answer command.

	Device Trigger Replace (4)
	This value indicates a device trigger replace request and is used:
	-	in the Device-Action AVP of the Device-Action-Request command;
	-	in the Device-Notification AVP of the Device-Action-Answer command.

	MSISDN-less MO-SMS Delivery (5)
	This value indicates the delivery of an MSISDN-less MO-SMS and is used in the Device-Notification AVP of the Device-Notification-Request command.
 */
public enum ActionTypeEnum implements IntegerEnum
{
	DEVICE_TRIGGER_REQUEST(1),DELIVERY_REPORT(2),DEVICE_TRIGGER_RECALL(3),DEVICE_TRIGGER_REPLACE(4),MSISDN_LESS_MO_SMS_DELIVERY(5);

	private static final Map<Integer, ActionTypeEnum> intToTypeMap = new HashMap<Integer, ActionTypeEnum>();
	static
	{
	    for (ActionTypeEnum type : ActionTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static ActionTypeEnum fromInt(Integer value) 
	{
		ActionTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private ActionTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
