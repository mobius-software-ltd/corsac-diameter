package com.mobius.software.telco.protocols.diameter.primitives.cxdx;

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
 * 	6.3.17	Reason-Code AVP
	The Reason-Code AVP is of type Enumerated, and defines the reason for the network initiated de-registration. The following values are defined:

	PERMANENT_TERMINATION (0)

	NEW_SERVER_ASSIGNED (1)
	
	SERVER_CHANGE (2)

	REMOVE_S-CSCF (3)

	The detailed behaviour of the S-CSCF is defined in 3GPP TS 29.228 [1].
 */
public enum ReasonCodeEnum implements IntegerEnum
{
	PERMANENT_TERMINATION(0),NEW_SERVER_ASSIGNED(1),SERVER_CHANGE(2),REMOVE_SCSCF(3);

	private static final Map<Integer, ReasonCodeEnum> intToTypeMap = new HashMap<Integer, ReasonCodeEnum>();
	static
	{
	    for (ReasonCodeEnum type : ReasonCodeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static ReasonCodeEnum fromInt(Integer value) 
	{
		ReasonCodeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private ReasonCodeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
