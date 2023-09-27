package com.mobius.software.telco.protocols.diameter.primitives.s6t;

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
 * 	8.4.48	Node-Type
	The Node-Type AVP is of type Unsigned32 and shall identify the type of node sending the information. The following values are defined:

	HSS (0)

	MME (1)

	SGSN (2)
 */
public enum NodeTypeEnum implements IntegerEnum
{
	HSS(0),MME(1),SGSN(2);

	private static final Map<Integer, NodeTypeEnum> intToTypeMap = new HashMap<Integer, NodeTypeEnum>();
	static
	{
	    for (NodeTypeEnum type : NodeTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static NodeTypeEnum fromInt(Integer value) 
	{
		NodeTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private NodeTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
