package com.mobius.software.telco.protocols.diameter.primitives.sh;

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
 * 	6.3.26 Pre-paging-Supported AVP
	The Pre-paging-Supported AVP is of type Enumerated. It indicates whether the sender supports pre-paging or not. The
	following values are defined:

	PREPAGING_NOT_SUPPORTED (0)

	PREPAGING_SUPPORTED (1)

	If this AVP is not present in the command, the default value is PREPAGING_NOT_SUPPORTED (0). 
*/
public enum PrePagingSupportedEnum implements IntegerEnum
{
	PREPAGING_NOT_SUPPORTED(0),PREPAGING_SUPPORTED(1);

	private static final Map<Integer, PrePagingSupportedEnum> intToTypeMap = new HashMap<Integer, PrePagingSupportedEnum>();
	static
	{
	    for (PrePagingSupportedEnum type : PrePagingSupportedEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static PrePagingSupportedEnum fromInt(Integer value) 
	{
		PrePagingSupportedEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private PrePagingSupportedEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
