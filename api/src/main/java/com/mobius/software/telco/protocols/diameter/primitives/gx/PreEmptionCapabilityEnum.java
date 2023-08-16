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
 * 	5.3.46 Pre-emption-Capability AVP
	The Pre-emption-Capability AVP (AVP code 1047) is of type Enumerated. If it is provided within the QoS-Information
	AVP, the AVP defines whether a service data flow can get resources that were already assigned to another service data
	flow with a lower priority level. If it is provided within the Default-EPS-Bearer-QoS AVP, the AVP defines whether
	the default bearer can get resources that were already assigned to another bearer with a lower priority level.
	The following values are defined:

	PRE-EMPTION_CAPABILITY_ENABLED (0)
 		This value indicates that the service data flow or bearer is allowed to get resources that were already assigned to
		another service data flow or bearer with a lower priority level.
	PRE-EMPTION_CAPABILITY_DISABLED (1)
 		This value indicates that the service data flow or bearer is not allowed to get resources that were already assigned
		to another service data flow or bearer with a lower priority level. This is the default value applicable if this AVP
		is not supplied. 
 */
public enum PreEmptionCapabilityEnum implements IntegerEnum
{
	PRE_EMPTION_CAPABILITY_ENABLED(0),PRE_EMPTION_CAPABILITY_DISABLED(1);

	private static final Map<Integer, PreEmptionCapabilityEnum> intToTypeMap = new HashMap<Integer, PreEmptionCapabilityEnum>();
	static
	{
	    for (PreEmptionCapabilityEnum type : PreEmptionCapabilityEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static PreEmptionCapabilityEnum fromInt(Integer value) 
	{
		PreEmptionCapabilityEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private PreEmptionCapabilityEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
