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
public enum MessageTypeEnum implements IntegerEnum
{
	M_SEND_REQ(1),M_SEND_CONF(2),M_NOTIFICATION_IND(3),M_NOTIFYRESP_IND(4),M_RETRIEVE_CONF(5),M_ACKNOWLEDGE_IND(6),M_DELIVERY_IND(7),M_READ_REC_INC(8),M_READ_ORIG_INC(9),M_FORWARD_REQ(10),M_FORWARD_CONF(11),M_MBOX_STORE_CONF(12),M_MBOX_VIEW_CONF(13),M_MBOX_UPLOAD_CONF(14),M_MBOX_DELETE_CONF(15);

	private static final Map<Integer, MessageTypeEnum> intToTypeMap = new HashMap<Integer, MessageTypeEnum>();
	static 
	{
	    for (MessageTypeEnum type : MessageTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static MessageTypeEnum fromInt(Integer value) 
	{
		MessageTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private MessageTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
