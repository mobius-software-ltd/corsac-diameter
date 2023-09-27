package com.mobius.software.telco.protocols.diameter.primitives.s6c;

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
 * 	5.3.3.39	IP-SM-GW-SBI-Support-Indicator
	The IP-SM-GW-SBI-Support-Indicator AVP is of type Enumerated and shall indicate whether the IP-SM-GW support service-based-interface or not, with the following values:

	-	NOT_SUPPORT_SBI (0),

	-	SUPPORT_SBI (1).
 */
public enum IPSMGWSBISupportIndicatorEnum implements IntegerEnum
{
	NOT_SUPPORT_SBI(0),SUPPORT_SBI(1);

	private static final Map<Integer, IPSMGWSBISupportIndicatorEnum> intToTypeMap = new HashMap<Integer, IPSMGWSBISupportIndicatorEnum>();
	static
	{
	    for (IPSMGWSBISupportIndicatorEnum type : IPSMGWSBISupportIndicatorEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static IPSMGWSBISupportIndicatorEnum fromInt(Integer value) 
	{
		IPSMGWSBISupportIndicatorEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private IPSMGWSBISupportIndicatorEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
