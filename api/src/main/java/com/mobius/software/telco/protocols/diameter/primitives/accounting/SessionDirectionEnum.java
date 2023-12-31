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
 * 	7.2.186A Session-Direction AVP
	The Session-Direction AVP (AVP code 2707) is of type Enumerated and indicates whether the NNI is used for an
	inbound or outbound service request on the control plane in case of interconnection and roaming.
	It has the following values:
	
	0 inbound
	1 outbound 
 */
public enum SessionDirectionEnum implements IntegerEnum
{
	INBOUND(0),OUTBOUND(1);

	private static final Map<Integer, SessionDirectionEnum> intToTypeMap = new HashMap<Integer, SessionDirectionEnum>();
	static 
	{
	    for (SessionDirectionEnum type : SessionDirectionEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static SessionDirectionEnum fromInt(Integer value) 
	{
		SessionDirectionEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private SessionDirectionEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
