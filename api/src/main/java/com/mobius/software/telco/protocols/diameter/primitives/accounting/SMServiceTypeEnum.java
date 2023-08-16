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
public enum SMServiceTypeEnum implements IntegerEnum
{
	CONTENT_PROCESSING(0),FORWARDING(1),FORWARDING_MULTIPLE_SUBSCRIPTIONS(2),FILTERING(3),RECEIPT(4),NETWORK_STORAGE(5),TO_MULTIPLE_DESTINATIONS(6),VPN(7),AUTO_REPLY(8),PERSONAL_SIGNATURE(9),DEFERRED_DELIVERY(10);

	private static final Map<Integer, SMServiceTypeEnum> intToTypeMap = new HashMap<Integer, SMServiceTypeEnum>();
	static 
	{
	    for (SMServiceTypeEnum type : SMServiceTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static SMServiceTypeEnum fromInt(Integer value) 
	{
		SMServiceTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private SMServiceTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
