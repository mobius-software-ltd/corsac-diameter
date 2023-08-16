package com.mobius.software.telco.protocols.diameter.primitives.gx;

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
 * 	5.3.66 Packet-Filter-Usage AVP (All access types)
	The Packet-Filter-Usage AVP (AVP code 1072) is of type of Enumerated, and it indicates whether the UE shall be
	provisioned with the related traffic mapping information, i.e. the packet filter. Traffic mapping information may be sent
	to the UE as per the relevant IP-CAN specifications even if not instructed to do so with the Packet-Filter-Usage AVP.
	The following values are defined:

	SEND_TO_UE (1)
 		This value is used to indicate that the related traffic mapping information, i.e. the packet filter, shall be sent to
		the UE, if applicable to the IP-CAN type as per relevant IP-CAN specifications.

	NOTE: The maximum number of packet filters sent to UE is limited by the IP-CAN type. See access specific
	annexes. 
 */
public enum PacketFilterUsageEnum implements IntegerEnum
{
	SEND_TO_UE(1);

	private static final Map<Integer, PacketFilterUsageEnum> intToTypeMap = new HashMap<Integer, PacketFilterUsageEnum>();
	static
	{
	    for (PacketFilterUsageEnum type : PacketFilterUsageEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static PacketFilterUsageEnum fromInt(Integer value) 
	{
		PacketFilterUsageEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private PacketFilterUsageEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
