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
 * 	7.2.46aA Coverage-Status AVP
	The Coverage-Status AVP (AVP code 3428) is of type Enumerated and indicates whether UE is served by E-UTRAN
	or not. The following values are defined:
	
	0 Out of coverage
	1 In coverage
 */
public enum CoverageStatusEnum implements IntegerEnum
{
	OUT_OF_COVERAGE(0),IN_COVERAGE(1);

	private static final Map<Integer, CoverageStatusEnum> intToTypeMap = new HashMap<Integer, CoverageStatusEnum>();
	static 
	{
	    for (CoverageStatusEnum type : CoverageStatusEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static CoverageStatusEnum fromInt(Integer value) 
	{
		CoverageStatusEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private CoverageStatusEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
