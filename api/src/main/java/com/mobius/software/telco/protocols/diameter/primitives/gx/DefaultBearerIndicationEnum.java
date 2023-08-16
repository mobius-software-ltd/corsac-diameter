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
 * 	5.3.132 Default-Bearer-Indication AVP
	The Default-Bearer-Indication AVP (AVP code 2844) is of type Enumerated and is used by the PCRF to indicate the
	related PCC rule shall be bound to the default bearer.
	The following values are defined:

	BIND_TO_DEF_BEARER (0)
 		This value indicates that the related PCC rule shall be bound to the default bearer.
	BIND_TO_APPLICABLE_BEARER (1)
 		This value indicates that the related PCC rule shall follow the bearer binding procedures by using the QCI/ARP
		within the QoS-Information AVP as defined in subclause 5.4 of 3GPP TS 29.213 [8]. This is the default value
		when the AVP has not yet been provided. 
 */
public enum DefaultBearerIndicationEnum implements IntegerEnum
{
	BIND_TO_DEF_BEARER(0),BIND_TO_APPLICABLE_BEARER(1);

	private static final Map<Integer, DefaultBearerIndicationEnum> intToTypeMap = new HashMap<Integer, DefaultBearerIndicationEnum>();
	static
	{
	    for (DefaultBearerIndicationEnum type : DefaultBearerIndicationEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static DefaultBearerIndicationEnum fromInt(Integer value) 
	{
		DefaultBearerIndicationEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private DefaultBearerIndicationEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
