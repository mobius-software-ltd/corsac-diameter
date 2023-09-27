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
 * 	7.2.74aA Inter-UE-Transfer AVP
	The Inter-UE-Transfer AVP (AVP code 3902) is of type Enumerated and contains information about type of the
	transfer. If this AVP is not present, this means that the type of transfer is Intra-UE transfer. The AVP can take the
	following values:

	0 Intra-UE transfer
	1 Inter-UE transfer
 */
public enum InterUETransferEnum implements IntegerEnum
{
	INTRA(0),INTER(1);

	private static final Map<Integer, InterUETransferEnum> intToTypeMap = new HashMap<Integer, InterUETransferEnum>();
	static 
	{
	    for (InterUETransferEnum type : InterUETransferEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static InterUETransferEnum fromInt(Integer value) 
	{
		InterUETransferEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private InterUETransferEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
