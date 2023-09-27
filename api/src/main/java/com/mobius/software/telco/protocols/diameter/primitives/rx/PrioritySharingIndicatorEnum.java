package com.mobius.software.telco.protocols.diameter.primitives.rx;

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
 * 	5.3.47	Priority-Sharing-Indicator AVP
	The Priority-Sharing-Indicator AVP (AVP code 550) is of type Enumerated and is used to indicate that the related media component can use the same Allocation and Retention Priority as media component(s) which are assigned the same QCI in the PCRF belonging to other AF sessions for the same IP-CAN session that also contain the Priority-Sharing-Indicator AVP set to PRIORITY_SHARING_ENABLED.
	The following values are defined:

	PRIORITY_SHARING_ENABLED (0)
		This value indicates that the related media component is allowed to share the Allocation and Retention Priority with media components belonging to other AF sessions that have also indicated that priority sharing is enabled.

	PRIORITY_SHARING_DISABLED (1)
		This value indicates that the related media component is not allowed to share the Allocation and Retention Priority with media components belonging to other AF sessions. This is the default value applicable if this AVP is not supplied.
 */
public enum PrioritySharingIndicatorEnum implements IntegerEnum
{
	PRIORITY_SHARING_ENABLED(0),PRIORITY_SHARING_DISABLED(1);

	private static final Map<Integer, PrioritySharingIndicatorEnum> intToTypeMap = new HashMap<Integer, PrioritySharingIndicatorEnum>();
	static
	{
	    for (PrioritySharingIndicatorEnum type : PrioritySharingIndicatorEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static PrioritySharingIndicatorEnum fromInt(Integer value) 
	{
		PrioritySharingIndicatorEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private PrioritySharingIndicatorEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
