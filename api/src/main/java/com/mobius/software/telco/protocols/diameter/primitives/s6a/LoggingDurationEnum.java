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
 * 	7.3.146	Logging-Duration
	The Logging-Duration AVP is of type Enumerated. The possible values are those defined in 3GPP TS 32.422 [23] for Logging Duration

	The parameter is mandatory if the the job type parameter is configured for Logged MDT or Logged MBSFN MDT. The
	parameter determines the validity of MDT logged configuration for IDLE. The timer starts at time of receiving
	configuration by the UE, and continues independent of UE state transitions and RAT or RPLMN changes.
	Detailed definition of the parameter is in TS 37.320 [30], TS 25.331 [31], TS 36.331 [32] and TS 38.331[43]:
	
	 The parameter is an enumerated type with the following values in UMTS and LTE:

	- 600 sec (0),

	- 1200 sec (1),

	- 2400 sec (2),

	- 3600 sec (3),

	- 5400 sec (4),

	- 7200 sec (5)

	The parameter is an enumerated type with the following values in NR:

	- 600 sec (6)

	- 1200 sec (7)

	- 2400 sec (8)

	- 3600 sec (9)

	- 5400 sec (10)

	- 7200 sec (11) 
 */
public enum LoggingDurationEnum implements IntegerEnum
{
	MS_600(0),MS_1200(1),MS_2400(2),MS_3600(3),MS_5400(4),MS_7200(5),
	NR_MS_600(6),NR_MS_1200(7),NR_MS_2400(8),NR_MS_3600(9),NR_MS_5400(10),NR_MS_7200(11);

	private static final Map<Integer, LoggingDurationEnum> intToTypeMap = new HashMap<Integer, LoggingDurationEnum>();
	static
	{
	    for (LoggingDurationEnum type : LoggingDurationEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static LoggingDurationEnum fromInt(Integer value) 
	{
		LoggingDurationEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private LoggingDurationEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
