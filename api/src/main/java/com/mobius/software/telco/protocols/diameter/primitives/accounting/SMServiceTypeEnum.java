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
 * 	7.2.213 SM-Service-Type AVP
	The SM-Service-Type AVP (AVP code 2029) is of type Enumerated and indicates the type of SM service that caused
	the charging interaction. The values as defined in TS 22.142 [217] are given below:

	0 VAS4SMS Short Message content processing
	1 VAS4SMS Short Message forwarding
	2 VAS4SMS Short Message Forwarding multiple subscriptions
	3 VAS4SMS Short Message filtering
	4 VAS4SMS Short Message receipt
	5 VAS4SMS Short Message Network Storage
	6 VAS4SMS Short Message to multiple destinations
	7 VAS4SMS Short Message Virtual Private Network (VPN)
	8 VAS4SMS Short Message Auto Reply
	9 VAS4SMS Short Message Personal Signature
	10 VAS4SMS Short Message Deferred Delivery
	11 .. 99 Reserved for 3GPP defined SM services
	100 .. 199 Vendor specific SM services

	The SM-Service-Type AVP shall be present if the SM-Message-Type AVP has value 2, SM Service Request.
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
