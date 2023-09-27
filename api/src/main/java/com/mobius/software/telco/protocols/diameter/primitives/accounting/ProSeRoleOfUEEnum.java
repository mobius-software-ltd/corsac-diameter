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
 * 	7.2.154M ProSe-Role-Of-UE AVP
	The ProSe- Role-Of-UE AVP (AVP code 3451) is of type Enumerated and indicates Role of the UE using ProSe. The
	AVP may take the values as follows:
	
	0 Announcing UE
	1 Monitoring UE
	2 Requestor UE
	3 Requested UE 
 */
public enum ProSeRoleOfUEEnum implements IntegerEnum
{
	ANNOUNCING(0),MONITORING(1),REQUESTOR(2),REQUESTED(3);

	private static final Map<Integer, ProSeRoleOfUEEnum> intToTypeMap = new HashMap<Integer, ProSeRoleOfUEEnum>();
	static 
	{
	    for (ProSeRoleOfUEEnum type : ProSeRoleOfUEEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static ProSeRoleOfUEEnum fromInt(Integer value) 
	{
		ProSeRoleOfUEEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private ProSeRoleOfUEEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
