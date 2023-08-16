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
 * 4.1.8.1.  Diffserv-Code-Point AVP

   The Diffserv-Code-Point AVP (AVP Code 535) is of type Enumerated and
   specifies the Differentiated Services Field Codepoints to match in
   the IP header.  The values are managed by IANA under the
   Differentiated Services Field Codepoints registry as defined in
   [RFC2474].
 */
public enum DiffServCodePointEnum implements IntegerEnum
{
	CS0(0),CS1(8),CS2(16),CS3(24),CS4(32),CS5(40),CS6(48),CS7(56),
	AF11(10),AF12(12),AF13(14),AF21(18),AF22(20),AF23(22),
	AF31(26),AF32(28),AF33(30),AF41(34),AF42(36),AF43(38),
	EF(46),VOICE_ADMIT(44);

	private static final Map<Integer, DiffServCodePointEnum> intToTypeMap = new HashMap<Integer, DiffServCodePointEnum>();
	static
	{
	    for (DiffServCodePointEnum type : DiffServCodePointEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static DiffServCodePointEnum fromInt(Integer value) 
	{
		DiffServCodePointEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private DiffServCodePointEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
