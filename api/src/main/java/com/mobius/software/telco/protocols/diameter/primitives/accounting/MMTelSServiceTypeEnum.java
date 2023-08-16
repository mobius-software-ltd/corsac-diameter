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
public enum MMTelSServiceTypeEnum implements IntegerEnum
{
	OIP(0),OIR(1),TIP(2),TIR(3),HOLD(4),CB(5),CDIV(6),CW(8),MWI(9),CONF(10),FA(12),CCBS(12),CCNR(13),MCID(14),CAT(15),CUG(16),PNM(17),CRS(18),AoC(19),ECT(20);

	private static final Map<Integer, MMTelSServiceTypeEnum> intToTypeMap = new HashMap<Integer, MMTelSServiceTypeEnum>();
	static 
	{
	    for (MMTelSServiceTypeEnum type : MMTelSServiceTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static MMTelSServiceTypeEnum fromInt(Integer value) 
	{
		MMTelSServiceTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private MMTelSServiceTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
