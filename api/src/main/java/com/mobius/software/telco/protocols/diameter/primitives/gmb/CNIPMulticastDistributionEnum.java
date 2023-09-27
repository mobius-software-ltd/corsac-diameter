package com.mobius.software.telco.protocols.diameter.primitives.gmb;

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
 * 	17.7.24	CN-IP-Multicast-Distribution AVP
	CN-IP-Multicast-Distribution AVP (AVP code 921) is of type Enumerated. It represents an indication if IP multicast distribution to UTRAN should be used for the MBMS user plane data. The following values are supported:

	NO-IP-MULTICAST (0)
	Value 0 indicates that IP multicast distribution of MBMS user plane data to UTRAN shall not be used.

	IP-MULTICAST	(1)
	Value 1 indicates that MBMS user plane data to UTRAN should be delivered by IP multicast mechanism.
 */
public enum CNIPMulticastDistributionEnum implements IntegerEnum
{
	NO_IP_MULTICAST(0),IP_MULTICAST(1);

	private static final Map<Integer, CNIPMulticastDistributionEnum> intToTypeMap = new HashMap<Integer, CNIPMulticastDistributionEnum>();
	static
	{
	    for (CNIPMulticastDistributionEnum type : CNIPMulticastDistributionEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static CNIPMulticastDistributionEnum fromInt(Integer value) 
	{
		CNIPMulticastDistributionEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private CNIPMulticastDistributionEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
