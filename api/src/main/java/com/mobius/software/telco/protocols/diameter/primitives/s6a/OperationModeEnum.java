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
 * 	7.3.227	Operation-Mode
	The Operation-Mode AVP is of type Unsigned32. This value shall indicate the operation mode for which the Paging-Time-Window-Length applies. See clause 3GPP TS 24.008 [31], clause 10.5.5.32.
	The allowed values of Operation-Mode shall be in the range of 0 to 255.
	Values are defined as follows:

	0:	Spare, for future use

	1:	Iu mode

	2:	WB-S1 mode

	3:	NB-S1 mode

	4 to 255:	Spare, for future use
 */
public enum OperationModeEnum implements IntegerEnum
{
	IU(0),WB_S1(1),NB_S1(2);

	private static final Map<Integer, OperationModeEnum> intToTypeMap = new HashMap<Integer, OperationModeEnum>();
	static
	{
	    for (OperationModeEnum type : OperationModeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static OperationModeEnum fromInt(Integer value) 
	{
		OperationModeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private OperationModeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
