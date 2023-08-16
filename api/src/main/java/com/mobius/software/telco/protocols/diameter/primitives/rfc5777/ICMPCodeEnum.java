package com.mobius.software.telco.protocols.diameter.primitives.rfc5777;

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
 * 4.1.8.13.  ICMP-Code AVP

   The ICMP-Code AVP (AVP Code 547) is of type Enumerated and the values
   are managed by IANA under the ICMP Type Numbers registry as defined
   in [RFC2780].
 */
public enum ICMPCodeEnum implements IntegerEnum
{
	NET_UNREACHABLE(0),HOST_UNREACHABLE(1),PROTOCOL_UNREACHABLE(2),PORT_UNREACHABLE(3),
	FRAGMENTATION_NEEDED_AND_DONT_FRAGMENT_SET(4),SOURCE_ROUTE_FAILED(5),DESTINATION_NETWORK_UNKNOWN(6),
	DESTINATION_HOST_UNKNOWN(7),SOURCE_HOST_ISOLATED(8),
	COMMUNICATION_WITH_DESTINATION_NETWORK_IS_ADMINISTRATIVELY_PROHIBITED(9),
	COMMUNICATION_WITH_DESTINATION_HOST_IS_ADMINISTRATIVELY_PROHIBITED(10),
	DESTINATION_NETWORK_UNREACHABLE_FOR_TYPE_OF_SERVICE(11),DESTINATION_HOST_UNREACHABLE_FOR_TYPE_OF_SERVICE(12),
	COMMUNICATION_ADMINISTRATIVELY_PROHOBITED(13),HOST_PRECEDENCE_VIOLATION(14),PRECEDENCE_CUTOFF_IN_EFFECT(15);

	private static final Map<Integer, ICMPCodeEnum> intToTypeMap = new HashMap<Integer, ICMPCodeEnum>();
	static
	{
	    for (ICMPCodeEnum type : ICMPCodeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static ICMPCodeEnum fromInt(Integer value) 
	{
		ICMPCodeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private ICMPCodeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
