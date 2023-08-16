package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol;

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
 * 8.32.  CC-Unit-Type AVP

   The CC-Unit-Type AVP (AVP Code 454) is of type Enumerated and
   specifies the type of units considered to be pooled into a
   credit pool.

   The following values are defined for the CC-Unit-Type AVP:

         TIME                         0
         MONEY                        1
         TOTAL-OCTETS                 2
         INPUT-OCTETS                 3
         OUTPUT-OCTETS                4
         SERVICE-SPECIFIC-UNITS       5
 */
public enum CcUnitTypeEnum implements IntegerEnum
{
	TIME(0),MONEY(1),TOTAL_OCTETS(2),INPUT_OCTETS(3),OUTPUT_OCTETS(4),SERVICE_SPECIFIC_UNITS(5);

	private static final Map<Integer, CcUnitTypeEnum> intToTypeMap = new HashMap<Integer, CcUnitTypeEnum>();
	static 
	{
	    for (CcUnitTypeEnum type : CcUnitTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static CcUnitTypeEnum fromInt(Integer value) 
	{
		CcUnitTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private CcUnitTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
