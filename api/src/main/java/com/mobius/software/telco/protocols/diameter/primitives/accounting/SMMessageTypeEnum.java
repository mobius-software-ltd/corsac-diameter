package com.mobius.software.telco.protocols.diameter.primitives.accounting;

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
 * 	7.2.207 SM-Message-Type AVP
	The SM-Message-Type AVP (AVP code 2007) is of type Enumerated and indicates the type of the message which
	caused the charging interaction. The values are given below:
	
	0 SUBMISSION
	1 DELIVERY_REPORT 
	2. SM Service Request
	3 T4 Device Trigger
	4 SM Device Trigger
	5 MO-SMS T4 submission
 */
public enum SMMessageTypeEnum implements IntegerEnum
{
	SUBMISSION(0),DELIVERY_REPORT(1),SERVICE_REQUEST(2),T4_DEVICE_TRIGGER(3),SM_DEVICE_TRIGGER(4),MO_SMS_T4_SUBMISSION(5);

	private static final Map<Integer, SMMessageTypeEnum> intToTypeMap = new HashMap<Integer, SMMessageTypeEnum>();
	static 
	{
	    for (SMMessageTypeEnum type : SMMessageTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static SMMessageTypeEnum fromInt(Integer value) 
	{
		SMMessageTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private SMMessageTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
