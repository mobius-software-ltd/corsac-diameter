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
 * 	5.3.1 Bearer-Usage AVP (3GPP-GPRS and 3GPP-EPS access types)
	The Bearer-Usage AVP (AVP code 1000) is of type Enumerated, and it shall indicate how the bearer is being used. If
	the Bearer-Usage AVP has not been previously provided, its absence shall indicate that no specific information is
	available. If the Bearer-Usage AVP has been provided, its value shall remain valid until it is provided the next time. The
	following values are defined:

	GENERAL (0)
	 	This value shall indicate no specific bearer usage information is available.
	IMS_SIGNALLING (1)
	 	This value shall indicate that the bearer is used for IMS signalling only
 */
public enum BearerUsageEnum implements IntegerEnum
{
	GENERAL(0),IMS_SIGNALLING(1);

	private static final Map<Integer, BearerUsageEnum> intToTypeMap = new HashMap<Integer, BearerUsageEnum>();
	static
	{
	    for (BearerUsageEnum type : BearerUsageEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static BearerUsageEnum fromInt(Integer value) 
	{
		BearerUsageEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private BearerUsageEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
