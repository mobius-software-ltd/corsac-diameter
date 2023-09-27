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
 * 	6.3.58	Priviledged-Sender-Indication AVP
	The Priviledged-Sender-Indication AVP is of type Enumerated and indicates to the S-CSCF whether or not the Private User Identity shall be considered as a priviledged sender. 
	The following values are defined:
	
	NOT_PRIVILEDGED_SENDER (0)
	
	PRIVILEDGED_SENDER (1)
 */
public enum PriviledgedSenderIndicationEnum implements IntegerEnum
{
	NOT_PRIVILEDGED_SENDER(0),PRIVILEDGED_SENDER(1);

	private static final Map<Integer, PriviledgedSenderIndicationEnum> intToTypeMap = new HashMap<Integer, PriviledgedSenderIndicationEnum>();
	static
	{
	    for (PriviledgedSenderIndicationEnum type : PriviledgedSenderIndicationEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static PriviledgedSenderIndicationEnum fromInt(Integer value) 
	{
		PriviledgedSenderIndicationEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private PriviledgedSenderIndicationEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
