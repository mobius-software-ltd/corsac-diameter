package com.mobius.software.telco.protocols.diameter.primitives.s6a;

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
 * 	7.3.224	Aerial-UE-Subscription-Information
	The Aerial-UE-Subscription-Information AVP is of type Unsigned32 and indicates the subscription of Aerial UE function. The following values are defined:

	AERIAL_UE_ALLOWED (0)

	AERIAL_UE_NOT_ALLOWED (1)

	This AVP corresponds to the "Aerial UE subscription information" information element as defined in 3GPP TS 36.413[19] and TS 36.423 [65].
 */
public enum AerialUESubscriptionInformationEnum implements IntegerEnum
{
	AERIAL_UE_ALLOWED(0),AERIAL_UE_NOT_ALLOWED(1);

	private static final Map<Integer, AerialUESubscriptionInformationEnum> intToTypeMap = new HashMap<Integer, AerialUESubscriptionInformationEnum>();
	static
	{
	    for (AerialUESubscriptionInformationEnum type : AerialUESubscriptionInformationEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static AerialUESubscriptionInformationEnum fromInt(Integer value) 
	{
		AerialUESubscriptionInformationEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private AerialUESubscriptionInformationEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
