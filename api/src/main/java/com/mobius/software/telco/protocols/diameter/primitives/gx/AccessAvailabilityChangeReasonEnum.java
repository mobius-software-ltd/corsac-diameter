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
 * 	5.3.121 Access-Availability-Change-Reason AVP
	The Access-Availability-Change-Reason AVP (AVP code 2833) is of type Unsigned32 and it is used to indicate the
	reason why the avalibility of an access is changed by the PCEF.
	The following values are defined in this specification:

	0 (Access stratum indication):
		This value shall be used to indicate that the availablitlity of an access is changed due to theAccess stratum
		indication.
	1 (Access usable/unusable):
 		This value shall be used to indicate that the availablitlity of an access is changed due to the access is unusable or
		usable again. 
 */
public enum AccessAvailabilityChangeReasonEnum implements IntegerEnum
{
	ACCESS_STRATUM_INDICATION(0),ACCESS_USABLE_UNSUABLE(1);

	private static final Map<Integer, AccessAvailabilityChangeReasonEnum> intToTypeMap = new HashMap<Integer, AccessAvailabilityChangeReasonEnum>();
	static
	{
	    for (AccessAvailabilityChangeReasonEnum type : AccessAvailabilityChangeReasonEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static AccessAvailabilityChangeReasonEnum fromInt(Integer value) 
	{
		AccessAvailabilityChangeReasonEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private AccessAvailabilityChangeReasonEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
