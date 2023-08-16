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
 * 4.1.8.4.  IP-Option-Type AVP

   The IP-Option-Type AVP (AVP Code 538) is of type Enumerated and the
   values are managed by IANA under the IP Option Numbers registry as
   defined in [RFC2780].
*/
public enum IPOptionTypeEnum implements IntegerEnum
{
	EOOL(0),NOP(1),SEC(130),LSR(131),TS(68),ESEC(133),CIPSO(134),
	RR(7),SID(136),SSR(137),ZSU(10),MTUP(11),MTUR(12),FINN(205),
	VISA(142),ENCODE(15),IMITD(144),EIP(145),TR(82),ADDEXT(147),RTRALT(148),
	SDB(149),DPS(151),UMP(152),QS(25),EXP_1(30),EXP_2(94),EXP_3(158),
	EXP_4(222);

	private static final Map<Integer, IPOptionTypeEnum> intToTypeMap = new HashMap<Integer, IPOptionTypeEnum>();
	static
	{
	    for (IPOptionTypeEnum type : IPOptionTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static IPOptionTypeEnum fromInt(Integer value) 
	{
		IPOptionTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private IPOptionTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
