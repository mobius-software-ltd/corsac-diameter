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
 * 	7.3.51	Equipment-Status
	The Equipment-Status AVP is of type Enumerated, and shall contain the status of the mobile equipment. The following values are defined:

	PERMITTEDLISTED (0)

	PROHIBITEDLISTED (1)
 */
public enum EquipmentStatusEnum implements IntegerEnum
{
	PERMITTEDLISTED(0),PROHIBITEDLISTED(1);

	private static final Map<Integer, EquipmentStatusEnum> intToTypeMap = new HashMap<Integer, EquipmentStatusEnum>();
	static
	{
	    for (EquipmentStatusEnum type : EquipmentStatusEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static EquipmentStatusEnum fromInt(Integer value) 
	{
		EquipmentStatusEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private EquipmentStatusEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
