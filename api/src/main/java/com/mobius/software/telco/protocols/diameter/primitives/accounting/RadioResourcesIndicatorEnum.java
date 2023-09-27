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
 * 	7.2.160D Radio-Resources-Indicator AVP
	The Radio-Resources-Indicator AVP (AVP code 3465) is of type Integer32 and identifies whether the operatorprovided radio resources or the configured radio resources were used for ProSe direct communication. The allowed
	values are:

	1 Operator-provided
	2 Configured 
 */
public enum RadioResourcesIndicatorEnum implements IntegerEnum
{
	OPERATOR_PROVIDER(1),CONFIGURED(2);

	private static final Map<Integer, RadioResourcesIndicatorEnum> intToTypeMap = new HashMap<Integer, RadioResourcesIndicatorEnum>();
	static 
	{
	    for (RadioResourcesIndicatorEnum type : RadioResourcesIndicatorEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static RadioResourcesIndicatorEnum fromInt(Integer value) 
	{
		RadioResourcesIndicatorEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private RadioResourcesIndicatorEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
