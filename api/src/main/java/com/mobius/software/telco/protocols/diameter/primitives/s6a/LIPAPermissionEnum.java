package com.mobius.software.telco.protocols.diameter.primitives.s6a;

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
 * 	7.3.133	LIPA-Permission
	The LIPA-Permission AVP is of type Enumerated. It shall indicate whether the APN can be accessed via Local IP Access. The following values are defined:

	LIPA_PROHIBITED (0)
	This value indicates that this APN is prohibited to be accessed via LIPA.

	LIPA_ONLY (1)
	This value indicates that this APN can be accessed only via LIPA.

	LIPA_CONDITIONAL (2)
	This value indicates that this APN can be accessed via both non LIPA and LIPA.
 */
public enum LIPAPermissionEnum implements IntegerEnum
{
	LIPA_PROHIBITED(0),LIPA_ONLY(1),LIPA_CONDITIONAL(2);

	private static final Map<Integer, LIPAPermissionEnum> intToTypeMap = new HashMap<Integer, LIPAPermissionEnum>();
	static
	{
	    for (LIPAPermissionEnum type : LIPAPermissionEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static LIPAPermissionEnum fromInt(Integer value) 
	{
		LIPAPermissionEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private LIPAPermissionEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
