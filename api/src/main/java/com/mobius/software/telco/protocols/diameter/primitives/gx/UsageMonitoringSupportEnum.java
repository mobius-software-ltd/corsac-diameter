package com.mobius.software.telco.protocols.diameter.primitives.gx;

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
 * 	5.3.63 Usage-Monitoring-Support AVP
	The Usage-Monitoring-Support AVP (AVP code 1070) is of type Enumerated and is used by the PCRF to indicate
	whether usage monitoring shall be disabled for certain Monitoring Key.
	The following values are defined:

	USAGE_MONITORING_DISABLED (0)
 		This value indicates that usage monitoring is disabled for a monitoring key. 
*/
public enum UsageMonitoringSupportEnum implements IntegerEnum
{
	USAGE_MONITORING_DISABLED(0);

	private static final Map<Integer, UsageMonitoringSupportEnum> intToTypeMap = new HashMap<Integer, UsageMonitoringSupportEnum>();
	static
	{
	    for (UsageMonitoringSupportEnum type : UsageMonitoringSupportEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static UsageMonitoringSupportEnum fromInt(Integer value) 
	{
		UsageMonitoringSupportEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private UsageMonitoringSupportEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
