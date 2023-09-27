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
 * 	8.4.27	Periodic-Communication-Indicator
	The Periodic-communication-indicator AVP is of type Unsigend32. The following values are defined:

	PERIODICALLY (0)

	ON_DEMAND (1)
 */
public enum PeriodicCommunicationIndicatorEnum implements IntegerEnum
{
	PERIODICALLY(0),ON_DEMAND(1);

	private static final Map<Integer, PeriodicCommunicationIndicatorEnum> intToTypeMap = new HashMap<Integer, PeriodicCommunicationIndicatorEnum>();
	static
	{
	    for (PeriodicCommunicationIndicatorEnum type : PeriodicCommunicationIndicatorEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static PeriodicCommunicationIndicatorEnum fromInt(Integer value) 
	{
		PeriodicCommunicationIndicatorEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private PeriodicCommunicationIndicatorEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
