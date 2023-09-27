package com.mobius.software.telco.protocols.diameter.primitives.sta;

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
 * 	5.2.3.9	AN-Trusted
	The AN-Trusted AVP (AVP Code 1503) is of type Enumerated.
	The AN-Trusted AVP sent from the 3GPP AAA Server to the Non-3GPP access network conveys the decision about the access network being trusted or untrusted by the HPLMN.
	The following values are defined:
	
	TRUSTED (0)
	This value is used when the non-3GPP access network is to be handled as trusted.

	UNTRUSTED (1)
	This value is used when the non-3GPP access network is to be handled as untrusted.
 */
public enum ANTrustedEnum implements IntegerEnum
{
	TRUSTED(0),UNTRUSTED(1);

	private static final Map<Integer, ANTrustedEnum> intToTypeMap = new HashMap<Integer, ANTrustedEnum>();
	static
	{
	    for (ANTrustedEnum type : ANTrustedEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static ANTrustedEnum fromInt(Integer value) 
	{
		ANTrustedEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private ANTrustedEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
