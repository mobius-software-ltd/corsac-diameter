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
 * 	7.2.1B Access-Transfer-Type AVP
	The Access-Transfer-Type AVP (AVP code 2710) is of type Enumerated and indicates which type of transfer occurred
	for IMS service continuity. The following values are defined:

	0 PS to CS Transfer
	1 CS to PS Transfer
	2 PS to PS Transfer
	3 CS to CS Transfer
 */
public enum AccessTransferTypeEnum implements IntegerEnum
{
	PS_TO_CS(0),CS_TO_PS(1),PS_TO_PS(2),CS_TO_CS(3);

	private static final Map<Integer, AccessTransferTypeEnum> intToTypeMap = new HashMap<Integer, AccessTransferTypeEnum>();
	static
	{
	    for (AccessTransferTypeEnum type : AccessTransferTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static AccessTransferTypeEnum fromInt(Integer value) 
	{
		AccessTransferTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private AccessTransferTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
