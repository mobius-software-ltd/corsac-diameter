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
 * 	7.2.154G ProSe-Functionality AVP
	The ProSe-Functionality AVP (AVP code 3445) is of type Enumerated and indicates the ProSe functionality UE is
	requesting. The AVP may take the values as follows:
	
	0 Direct discovery
	1 EPC-level discovery
	2 Direct communication
 */
public enum ProSeFunctionalityEnum implements IntegerEnum
{
	DIRECT_DISCOVERY(0),EPC_LEVEL_DISCOVERY(1),DIRECT_COMMUNICATION(2);

	private static final Map<Integer, ProSeFunctionalityEnum> intToTypeMap = new HashMap<Integer, ProSeFunctionalityEnum>();
	static 
	{
	    for (ProSeFunctionalityEnum type : ProSeFunctionalityEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static ProSeFunctionalityEnum fromInt(Integer value) 
	{
		ProSeFunctionalityEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private ProSeFunctionalityEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
