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
 * 	7.2.145 PoC-Server-Role AVP
	The PoC-Server-Role AVP (AVP code 883) is of type Enumerated and specifies the role of the PoC server. The
	identifier can be one of the following:
	
	0 Participating PoC Server
	1 Controlling PoC Server
	2 Interworking function
	3 Interworking selection function 
 */
public enum PoCServerRoleEnum implements IntegerEnum
{
	PARTICIPATING(0),CONTROLLING(1),INTERWORKING(2),INTERWORKING_SELECTION(3);

	private static final Map<Integer, PoCServerRoleEnum> intToTypeMap = new HashMap<Integer, PoCServerRoleEnum>();
	static 
	{
	    for (PoCServerRoleEnum type : PoCServerRoleEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static PoCServerRoleEnum fromInt(Integer value) 
	{
		PoCServerRoleEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private PoCServerRoleEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
