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
 * 	7.2.20eA API-Network-Service-Node AVP
	The API-Network-Service-Node AVP (AVP code 1315) is of type Enumerated,and holds the identifier of the network
	element as defined in TS 23.682[243], that triggers the API notification. 
	
	0 MME
 	1 SGSN
 	2 HSS
 	3 PCRF
 	4 PFDF
 	5 BMSC
 	6 CSCF
 	7 RCAF 
 */
public enum APINetworkServiceNodeEnum implements IntegerEnum
{
	MME(0),SGSN(1),HSS(2),PCRF(3),PFDF(4),BMSC(5),CSCF(6),RCAF(7);

	private static final Map<Integer, APINetworkServiceNodeEnum> intToTypeMap = new HashMap<Integer, APINetworkServiceNodeEnum>();
	static 
	{
	    for (APINetworkServiceNodeEnum type : APINetworkServiceNodeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static APINetworkServiceNodeEnum fromInt(Integer value) 
	{
		APINetworkServiceNodeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private APINetworkServiceNodeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
