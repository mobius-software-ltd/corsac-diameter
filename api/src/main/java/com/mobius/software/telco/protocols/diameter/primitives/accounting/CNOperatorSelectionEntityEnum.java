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
 * 	7.2.41A CN-Operator-Selection-Entity AVP
	The CN-Operator-Selection-Entity AVP (AVP code 3421) is of type Enumerated and holds the indication on which
	entity has selected the Serving Core Network in Network Sharing situations.
	It has the following values:
	
	0 The Serving Network has been selected by the UE
	1 The Serving Network has been selected by the network
 */
public enum CNOperatorSelectionEntityEnum implements IntegerEnum
{
	BY_UE(0),BY_NETWORK(1);

	private static final Map<Integer, CNOperatorSelectionEntityEnum> intToTypeMap = new HashMap<Integer, CNOperatorSelectionEntityEnum>();
	static 
	{
	    for (CNOperatorSelectionEntityEnum type : CNOperatorSelectionEntityEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static CNOperatorSelectionEntityEnum fromInt(Integer value) 
	{
		CNOperatorSelectionEntityEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private CNOperatorSelectionEntityEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
