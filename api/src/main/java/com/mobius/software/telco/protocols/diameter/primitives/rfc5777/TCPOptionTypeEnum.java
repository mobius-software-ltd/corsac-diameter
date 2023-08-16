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
 * 4.1.8.8.  TCP-Option-Value AVP

   The TCP-Option-Value AVP (AVP Code 542) is of type OctetString and
   contains the option value that must be matched.
*/
public enum TCPOptionTypeEnum implements IntegerEnum
{
	END_OF_OPTION_LIST(0),NO_OPERATION(1),MAXIMUM_SEGMENT_SIZE(2),WINDOW_SCALE(3),SACK_PERMITTED(4),
	SACK(5),ECHO(6),ECHO_REPLY(7),TIMESTAMP(8),PARTIAL_ORDER_CONNECTION_PERMITTED(9),PARTIAL_ORDER_SERVICE_PROFILE(10),
	CC(11),CCNEW(12),CCECHO(13),TCP_ALTERNATE_CHECKSUM_REQUEST(14),TCP_ALTERNATE_CHECKSUM_DATA(15),SKEETER(16),
	BUBBA(17),TRAILER_CHECKSUM_OPTION(18),MD5_SIGNATURE_OPTION(19),SCPS_CAPABILITIES(20),
	SELECTIVE_NEGATIVE_ACKNOWLEDGEMTS(21),RECORD_BOUNDARIES(22),CORRUPTION_EXPERIENCED(23),SNAP(24),
	TCP_COMPRESSION_FILTER(26),QUICK_START_RESPONSE(27),USER_TIMEOUT_OPTION(28),TCP_AUTHENTICATION_OPTION(29),
	MULTIPATH_TCP(30),TCP_FAST_OPEN_COOKIE(34),ENCRYPTION_NEGOTIATION(69),ACCURACE_ECN_ORDER_0(172),
	ACCURACE_ECN_ORDER_1(174),EXPERIMENT_1(253),EXPERIMENT_2(254);

	private static final Map<Integer, TCPOptionTypeEnum> intToTypeMap = new HashMap<Integer, TCPOptionTypeEnum>();
	static
	{
	    for (TCPOptionTypeEnum type : TCPOptionTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static TCPOptionTypeEnum fromInt(Integer value) 
	{
		TCPOptionTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private TCPOptionTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
