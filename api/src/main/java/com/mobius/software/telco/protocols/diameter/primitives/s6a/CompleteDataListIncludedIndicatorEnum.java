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
 * 	7.3.44	PDN-GW-Allocation-Type
	The PDN-GW-Allocation-Type AVP is of type Enumerated. It shall indicate whether the PDN GW address included in MIP6-Agent-Info has been statically allocated (i.e. provisioned in the HSS by the operator), or dynamically selected by other nodes. The following values are defined:

	STATIC (0)

	DYNAMIC (1)
 */
public enum CompleteDataListIncludedIndicatorEnum implements IntegerEnum
{
	STATIC(0),DYNAMIC(1);

	private static final Map<Integer, CompleteDataListIncludedIndicatorEnum> intToTypeMap = new HashMap<Integer, CompleteDataListIncludedIndicatorEnum>();
	static
	{
	    for (CompleteDataListIncludedIndicatorEnum type : CompleteDataListIncludedIndicatorEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static CompleteDataListIncludedIndicatorEnum fromInt(Integer value) 
	{
		CompleteDataListIncludedIndicatorEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private CompleteDataListIncludedIndicatorEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
