package com.mobius.software.telco.protocols.diameter.primitives.s15;

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

import java.util.HashMap;
import java.util.Map;

import com.mobius.software.telco.protocols.diameter.primitives.IntegerEnum;

/*
 * E.6.3.4	CS-Service-Resource-Result-Operation
 * CS-Service-Resource-Result-Operation AVP (AVP code 2815) is type of Enumerated, 
 * and it indicates a resource result operation of the CS service in the Fixed Broadband Access network.
 * The following values are defined:
 * 
 *  DELETION (0)
 *	This value is used to indicate a result that the resources reserved for 
 *	the provided QoS request identifiers have been removed by the Fixed Broadband Access network.
 * 
 */

public enum CSServiceResourceResultOperationEnum implements IntegerEnum
{
	DELETION(0);

	private static final Map<Integer, CSServiceResourceResultOperationEnum> intToTypeMap = new HashMap<Integer, CSServiceResourceResultOperationEnum >();
	static
	{
	    for (CSServiceResourceResultOperationEnum  type : CSServiceResourceResultOperationEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static CSServiceResourceResultOperationEnum fromInt(Integer value) 
	{
		CSServiceResourceResultOperationEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private CSServiceResourceResultOperationEnum (int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
