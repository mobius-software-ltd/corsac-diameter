package com.mobius.software.telco.protocols.diameter.primitives.s6m;

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
 * 	6.4.3	Service-ID
	The Service-ID AVP is of type Enumerated and it shall identify the service requested by the SCS. The following values are defined:

	DEVICE_TRIGGER (0)
	The SCS requests a control plane device triggering to the UE. .

	SMS_MO (1)
	The UE (identified by IMSI and application port identifier) requests SMS_MO to be delivered to the SCS.  
 */
public enum ServiceIDEnum implements IntegerEnum
{
	DEVICE_TRIGGER(0),SMS_MO(1);

	private static final Map<Integer, ServiceIDEnum> intToTypeMap = new HashMap<Integer, ServiceIDEnum>();
	static
	{
	    for (ServiceIDEnum type : ServiceIDEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static ServiceIDEnum fromInt(Integer value) 
	{
		ServiceIDEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private ServiceIDEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
