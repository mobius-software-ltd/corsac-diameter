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
 * 	5.3.62 Usage-Monitoring-Report AVP
	The Usage-Monitoring-Report AVP (AVP code 1069) is of type Enumerated and is used by the PCRF to indicate that
	accumulated usage is to be reported by the PCEF regardless of whether a usage threshold is reached.
	The following values are defined:

	USAGE_MONITORING_REPORT_REQUIRED (0)
 		This value, if provided within an RAR or CCA command by the PCRF indicates that accumulated usage shall be
		reported by the PCEF. 
 */
public enum UsageMonitoringReportEnum implements IntegerEnum
{
	USAGE_MONITORING_REPORT_REQUIRED(0);

	private static final Map<Integer, UsageMonitoringReportEnum> intToTypeMap = new HashMap<Integer, UsageMonitoringReportEnum>();
	static
	{
	    for (UsageMonitoringReportEnum type : UsageMonitoringReportEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static UsageMonitoringReportEnum fromInt(Integer value) 
	{
		UsageMonitoringReportEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private UsageMonitoringReportEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
