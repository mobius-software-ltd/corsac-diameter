package com.mobius.software.telco.protocols.diameter.primitives.s6a;

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
 * 	7.3.231	Interworking-5GS-Indicator
	The Interworking-5GS-Indicator AVP is of type Enumerated and indicates whether the interworking between 5GS and EPS is subscribed or not subscribed for the APN. See 3GPP TS 23.502 [67].
	The following values are defined:

	NOT-SUBSCRIBED (0)

	SUBSCRIBED (1)

	The default value when this AVP is not present is NOT-SUBSCRIBED (0).
 */
public enum Interworking5GSIndicatorEnum implements IntegerEnum
{
	NOT_SUBSCRIBED(0),SUBSCRIBED(1);

	private static final Map<Integer, Interworking5GSIndicatorEnum> intToTypeMap = new HashMap<Integer, Interworking5GSIndicatorEnum>();
	static
	{
	    for (Interworking5GSIndicatorEnum type : Interworking5GSIndicatorEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static Interworking5GSIndicatorEnum fromInt(Integer value) 
	{
		Interworking5GSIndicatorEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private Interworking5GSIndicatorEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
