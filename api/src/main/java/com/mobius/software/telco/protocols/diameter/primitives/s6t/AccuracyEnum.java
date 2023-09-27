package com.mobius.software.telco.protocols.diameter.primitives.s6t;

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
 * 	8.4.17	Accuracy
	The Accuracy AVP is of type Unsigned32. It shall indicate the requested accuracy. The following values are defined:

	CGI-ECGI (0)

	eNB (1)

	LA-TA-RA (2)

	PRA(3)

	PLMN-ID (4)
 */
public enum AccuracyEnum implements IntegerEnum
{
	CGI_ECGI(0),ENB(1),LA_TA_RA(2),PRA(3),PLMN_ID(4);

	private static final Map<Integer, AccuracyEnum> intToTypeMap = new HashMap<Integer, AccuracyEnum>();
	static
	{
	    for (AccuracyEnum type : AccuracyEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static AccuracyEnum fromInt(Integer value) 
	{
		AccuracyEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private AccuracyEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
