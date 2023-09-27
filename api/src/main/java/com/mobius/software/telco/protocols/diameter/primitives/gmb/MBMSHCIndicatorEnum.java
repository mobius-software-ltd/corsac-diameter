package com.mobius.software.telco.protocols.diameter.primitives.gmb;

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
 * 	17.7.25	MBMS-HC-Indicator AVP
	MBMS-HC-Indicator AVP (AVP code 922) is of type Enumerated. It represents an indication if header compression is used by BM-SC when sending for MBMS user plane data. The enumeration values are defined in 3GPP TS 25.413 [92].
 */
public enum MBMSHCIndicatorEnum implements IntegerEnum
{
	UNCOMPRESSED_HEADER(0),COMPRESSED_HEADER(1);

	private static final Map<Integer, MBMSHCIndicatorEnum> intToTypeMap = new HashMap<Integer, MBMSHCIndicatorEnum>();
	static
	{
	    for (MBMSHCIndicatorEnum type : MBMSHCIndicatorEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static MBMSHCIndicatorEnum fromInt(Integer value) 
	{
		MBMSHCIndicatorEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private MBMSHCIndicatorEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
