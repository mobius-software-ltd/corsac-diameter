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
 * 	7.3.137	Job-Type
	The Job-Type AVP is of type Enumerated. The possible values are those defined in 3GPP TS 32.422 [23] for Job-Type.
	
	The Job type is a conditional mandatory parameter. The condition is either MDT or RLF or RCEF data collection
	functionality is supported. It defines if a single trace job, a combined MDT and trace job or RLF report collection job or
	RCEF report collection job is activated. This parameter also defines the MDT mode. The Job type parameter is an
	enumerated type with the following values:

	- Immediate MDT only (0);

	- Logged MDT only (1);

	- Trace only (2);

	- Immediate MDT and Trace (3);

	- RLF reports only (4) ;

	- RCEF reports only (5).

	- Logged MBSFN MDT (6).

	NOTE 1: The Job type "RLF reports only" and "RCEF reports only" are applicable only in management based trace
	activation in E-UTRAN and NG-RAN.

	NOTE 2: Logged MBSFN MDT is applicable only for activation in E-UTRAN. 
 */
public enum JobTypeEnum implements IntegerEnum
{
	IMMEDIATE_MDT_ONLY(0),LOGGED_MDT_ONLY(1),TRACE_ONLY(1),IMMEDIATE_MDT_AND_TRACE(3),RLF_REPORTS_ONLY(4),RCEF_REPORTS_ONLY(5),LOGGED_MBSFN_MDT(6);

	private static final Map<Integer, JobTypeEnum> intToTypeMap = new HashMap<Integer, JobTypeEnum>();
	static
	{
	    for (JobTypeEnum type : JobTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static JobTypeEnum fromInt(Integer value) 
	{
		JobTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private JobTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
