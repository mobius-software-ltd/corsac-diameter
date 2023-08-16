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
 * 	5.3.61 Usage-Monitoring-Level AVP
	The Usage-Monitoring-Level AVP (AVP code 1068) is of type Enumerated and is used by the PCRF to indicate
	whether the usage monitoring instance applies to the IP-CAN session or to one or more PCC rules or to one or more
	ADC rules.
	If Usage-Monitoring-Level AVP is not provided, its absence shall indicate the value PCC_RULE_LEVEL (1).
	The following values are defined:

	SESSION_LEVEL (0)
 		This value, if provided within an RAR or CCA command by the PCRF, indicates that the usage monitoring
		instance applies to the entire IP-CAN session.
	PCC_RULE_LEVEL (1)
 		This value, if provided within an RAR or CCA command by the PCRF indicates that the usage monitoring
		instance applies to one or more PCC rules. This value is only applicable to Gx reference point.
	ADC_RULE_LEVEL (2)
 		This value, if provided within a TSR, RAR or CCA command by the PCRF, indicates that the usage monitoring
		instance applies to one or more ADC rules. This value is only applicable to Sd reference point. See clause 5b.4.
 */
public enum UsageMonitoringLevelEnum implements IntegerEnum
{
	SESSION_LEVEL(0),PCC_RULE_LEVEL(1),ADC_RULE_LEVEL(2);

	private static final Map<Integer, UsageMonitoringLevelEnum> intToTypeMap = new HashMap<Integer, UsageMonitoringLevelEnum>();
	static
	{
	    for (UsageMonitoringLevelEnum type : UsageMonitoringLevelEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static UsageMonitoringLevelEnum fromInt(Integer value) 
	{
		UsageMonitoringLevelEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private UsageMonitoringLevelEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
