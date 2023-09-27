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
 * 	7.2.177aA Role-Of-ProSe-Function AVP
	The Role-Of-ProSe-Function AVP (AVP code 3438) is of type Enumerated and indicates ProSe Function resides in
	which PLMN. The AVP may take the values as follows:
	
	0 HPLMN
	1 VPLMN
	2 Local PLMN
 */
public enum RoleOfProSeFunctionEnum implements IntegerEnum
{
	HPLMN(0),VPLMN(1),LOCAL_PLMN(2);

	private static final Map<Integer, RoleOfProSeFunctionEnum> intToTypeMap = new HashMap<Integer, RoleOfProSeFunctionEnum>();
	static 
	{
	    for (RoleOfProSeFunctionEnum type : RoleOfProSeFunctionEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static RoleOfProSeFunctionEnum fromInt(Integer value) 
	{
		RoleOfProSeFunctionEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private RoleOfProSeFunctionEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
