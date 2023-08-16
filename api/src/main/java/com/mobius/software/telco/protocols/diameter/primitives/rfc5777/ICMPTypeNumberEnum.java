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
 * 4.1.8.12.  ICMP-Type-Number AVP

   The ICMP-Type-Number AVP (AVP Code 546) is of type Enumerated and the
   values are managed by IANA under the ICMP Type Numbers registry as
   defined in [RFC2780].
 */
public enum ICMPTypeNumberEnum implements IntegerEnum
{
	ECHO_REPLY(0),DESTINATION_UNREACHABLE(3),SOURCE_QUENCH(4),REDIRECT(5),ALTERNATE_HOST_ADDRESS(6),
	ECHO(8),ROUTER_ADVERTISEMENT(9),ROUTER_SOLICITATIONS(10),TIME_EXCEEDED(11),PARAMETER_PROBLEM(12),
	TIMESTAMP(13),TIMESTAMP_REPLY(14),INFORMATION_REQUEST(15),INFORMATION_REPLY(16),
	ADDRESS_MASK_REQUEST(17),ADDRESS_MASK_REPLY(18),TRACEROUTE(30),DATAGRAM_CONVERSION_ERROR(31),
	MOBILE_HOST_REDIRECT(32),IPV6_WHERE_ARE_YOU(33),IPV6_I_AM_HERE(34),MOBILE_REGISTRATION_REQUEST(35),
	MOBILE_REGISTRATION_REPLY(36),DOMAIN_NAME_REQUEST(37),DOMAIN_NAME_REPLY(38),SKIP(39),PHOTURIS(40),
	EXPERIMENTAL(41),EXTENDED_ECHO_REQUEST(42),EXTENDED_ECHO_REPLY(43),EXPERIMENT_1(253),EXPERIMENT_2(254);

	private static final Map<Integer, ICMPTypeNumberEnum> intToTypeMap = new HashMap<Integer, ICMPTypeNumberEnum>();
	static
	{
	    for (ICMPTypeNumberEnum type : ICMPTypeNumberEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static ICMPTypeNumberEnum fromInt(Integer value) 
	{
		ICMPTypeNumberEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private ICMPTypeNumberEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
