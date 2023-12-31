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
 * 	7.2.112B NNI-Type AVP
	The NNI-Type AVP (AVP code 2704) is of type Enumerated and indicates whether the type of used NNI is nonroaming, roaming without loopback routing or roaming with loopback routing. It has the following values:
 	
 	0 non-roaming
 	1 roaming without loopback
 	2 roaming with loopback 
 */
public enum NNITypeEnum implements IntegerEnum
{
	NON_ROAMING(0),WITHOUT_LOOPBACK(1),WITH_LOOPBACK(2);

	private static final Map<Integer, NNITypeEnum> intToTypeMap = new HashMap<Integer, NNITypeEnum>();
	static 
	{
	    for (NNITypeEnum type : NNITypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static NNITypeEnum fromInt(Integer value) 
	{
		NNITypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private NNITypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
