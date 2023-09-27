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
 * 	17.7.10	MBMS-2G-3G-Indicator AVP
	The MBMS-2G-3G-Indicator AVP  (AVP code 907) is of type Enumerated. It indicates whether the MBMS bearer service will be delivered in 2G- only, 3G- only of both coverage areas. The following values are supported:

	2G (0)
	The MBMS bearer service shall only be delivered in 2G only coverage areas.

	3G (1)
	The MBMS bearer service shall only be delivered in 3G only coverage areas.

	2G-AND-3G (2)
	The MBMS bearer service shall be delivered both in 2G and 3G coverage areas.
 */
public enum MBMS2G3GIndicatorEnum implements IntegerEnum
{
	TWO_G(0),THREE_G(1),TWO_G_AND_THREE_G(2);

	private static final Map<Integer, MBMS2G3GIndicatorEnum> intToTypeMap = new HashMap<Integer, MBMS2G3GIndicatorEnum>();
	static
	{
	    for (MBMS2G3GIndicatorEnum type : MBMS2G3GIndicatorEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static MBMS2G3GIndicatorEnum fromInt(Integer value) 
	{
		MBMS2G3GIndicatorEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private MBMS2G3GIndicatorEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
