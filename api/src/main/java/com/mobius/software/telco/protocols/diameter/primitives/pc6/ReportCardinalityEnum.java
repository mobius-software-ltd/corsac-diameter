package com.mobius.software.telco.protocols.diameter.primitives.pc6;

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
 * 	6.3.46	Report-Cardinality
	The Report-Cardinality AVP is of type Enumerated. The following values are defined:

	SINGLE (0)
	This value shall be used to indicate the change of area event shall be reported one time only.

	MULTIPLE (1)
	This value shall be used to indicate the change of area event may be reported several times. 
 */
public enum ReportCardinalityEnum implements IntegerEnum
{
	SINGLE(0),MULTIPLE(1);

	private static final Map<Integer, ReportCardinalityEnum> intToTypeMap = new HashMap<Integer, ReportCardinalityEnum>();
	static
	{
	    for (ReportCardinalityEnum type : ReportCardinalityEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static ReportCardinalityEnum fromInt(Integer value) 
	{
		ReportCardinalityEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private ReportCardinalityEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
