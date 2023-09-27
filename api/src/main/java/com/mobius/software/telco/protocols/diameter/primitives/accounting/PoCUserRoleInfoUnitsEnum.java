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
 * 	7.2.151 PoC-User-Role-Info-Units AVP
	The PoC-User-Role-Info-Units (AVP code 1254) is of type Enumerated and specify the role type details of PoC users.
	The identifier can be one of the following:
	
	1 Moderator
	2 Dispatcher
	3 Session-Owner
	4 Session-Participant
 */
public enum PoCUserRoleInfoUnitsEnum implements IntegerEnum
{
	MODERATOR(1),DISPATCHER(2),SESSION_OWNER(3),SESSION_PARTICIPANTS(4);

	private static final Map<Integer, PoCUserRoleInfoUnitsEnum> intToTypeMap = new HashMap<Integer, PoCUserRoleInfoUnitsEnum>();
	static 
	{
	    for (PoCUserRoleInfoUnitsEnum type : PoCUserRoleInfoUnitsEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static PoCUserRoleInfoUnitsEnum fromInt(Integer value) 
	{
		PoCUserRoleInfoUnitsEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private PoCUserRoleInfoUnitsEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
