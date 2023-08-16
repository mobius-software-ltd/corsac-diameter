package com.mobius.software.telco.protocols.diameter.primitives.gi;

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
 * 	3 - 3GPP-PDP type
 	PDP type value: Unsigned 32 bits integer type
	PDP type may have the following values:
	0 = IPv4
	1 = PPP
	2 = IPv6
	3 = IPv4v6
	For GGSN, only the values "0", "1" and "2" are applicable.
	For P-GW, this sub-attribute represents PDN Type and therefore only the values "0", "2" and "3" are applicable. 
 */
public enum TGPPPDPTypeEnum implements IntegerEnum
{
	IPV4(0),PPP(1),IPV6(2),IPV4V6(3);

	private static final Map<Integer, TGPPPDPTypeEnum> intToTypeMap = new HashMap<Integer, TGPPPDPTypeEnum>();
	static
	{
	    for (TGPPPDPTypeEnum type : TGPPPDPTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static TGPPPDPTypeEnum fromInt(Integer value) 
	{
		TGPPPDPTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private TGPPPDPTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
