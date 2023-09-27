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
 * 	7.3.145	Logging-Interval
	The Logging-Interval AVP is of type Enumerated. The possible values are those defined in 3GPP TS 32.422 [23] for Logging Interval

	The parameter is an enumerated type with the following values in UMTS, and LTE as per defined in TS 25.331 [31]
	and TS 36.331 [32] :

	- 1280 ms (0),

	- 2560 ms (1),

	- 5120 ms (2),

	- 10240 ms (3),

	- 20480 ms (4),

	- 30720 ms (5),

	- 40960 ms (6),

	- 61440 ms (7)

	The parameter is an enumerated type with the following values in NR as per defined in 3GPP TS 38.331 [43]:

	- 1280 ms (0),

	- 2560 ms (1),

	- 5120 ms (2),

	- 10240 ms (3),

	- 20480 ms (4),

	- 30720 ms (5),
	
	- 40960 ms (6),

	- 61440 ms (7)

	- 320 ms (8)

	- 640 ms (9)

	- Infinity (10)
 */
public enum LoggingIntervalEnum implements IntegerEnum
{
	MS_1280(0),MS_2560(1),MS_5120(2),MS_10240(3),MS_20480(4),MS_30720(5),MS_40960(6),MS_61440(7),
	MS_320(8),MS_640(9),INFINITITY(10);

	private static final Map<Integer, LoggingIntervalEnum> intToTypeMap = new HashMap<Integer, LoggingIntervalEnum>();
	static
	{
	    for (LoggingIntervalEnum type : LoggingIntervalEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static LoggingIntervalEnum fromInt(Integer value) 
	{
		LoggingIntervalEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private LoggingIntervalEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
