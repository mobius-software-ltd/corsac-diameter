package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei;

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
 * 	3.2.261  Msg-Send-Result AVP

	AVP Name
	Msg-Send-Result

	AVP Code
	20803

	AVP Data Type
	Enumerated

	Vendor ID
	2011

	Description
	Indicates the result of sending a message.
	    - 0: The message fails to be sent.
	    - 1: The message is sent successfully.
 */
public enum MsgSendResultEnum implements IntegerEnum
{
	FAILED(0),SENT_SUCCESFULLY(1);

	private static final Map<Integer, MsgSendResultEnum> intToTypeMap = new HashMap<Integer, MsgSendResultEnum>();
	static 
	{
	    for (MsgSendResultEnum type : MsgSendResultEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static MsgSendResultEnum fromInt(Integer value) 
	{
		MsgSendResultEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private MsgSendResultEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
