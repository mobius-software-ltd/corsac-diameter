package com.mobius.software.telco.protocols.diameter.primitives.rfc4004;

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
 * 9.8.  MIP-Algorithm-Type AVP

   The MIP-Algorithm-Type AVP (AVP Code 345) is of type Enumerated and
   contains the Algorithm identifier for the associated Mobile IPv4
   authentication extension.  The HAAA selects the algorithm type.  The
   following values are currently defined:

         2   HMAC-SHA-1 [HMAC]
 */
public enum MIPAlgorithmTypeEnum implements IntegerEnum
{
	HMAC_SHA_1(2);

	private static final Map<Integer, MIPAlgorithmTypeEnum> intToTypeMap = new HashMap<Integer, MIPAlgorithmTypeEnum>();
	static
	{
	    for (MIPAlgorithmTypeEnum type : MIPAlgorithmTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static MIPAlgorithmTypeEnum fromInt(Integer value) 
	{
		MIPAlgorithmTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private MIPAlgorithmTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
