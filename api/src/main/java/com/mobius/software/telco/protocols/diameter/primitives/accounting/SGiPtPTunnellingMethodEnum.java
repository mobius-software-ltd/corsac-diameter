package com.mobius.software.telco.protocols.diameter.primitives.accounting;

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
 * 	7.2.198A SGi-PtP-Tunnelling-Method AVP
	The SGi-PtP-Tunnelling-Method AVP (AVP Code 3931) is of type Enumerated and indicates whether SGi PtP
	tunnelling method is based on UDP/IP or other methods for a non-IP PDN type PDN connection.The following values
	are defined:
	
	0 UDP_IP_based
	1 Others
 */
public enum SGiPtPTunnellingMethodEnum implements IntegerEnum
{
	UDP_IP(0),OTHER(1);

	private static final Map<Integer, SGiPtPTunnellingMethodEnum> intToTypeMap = new HashMap<Integer, SGiPtPTunnellingMethodEnum>();
	static 
	{
	    for (SGiPtPTunnellingMethodEnum type : SGiPtPTunnellingMethodEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static SGiPtPTunnellingMethodEnum fromInt(Integer value) 
	{
		SGiPtPTunnellingMethodEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private SGiPtPTunnellingMethodEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
