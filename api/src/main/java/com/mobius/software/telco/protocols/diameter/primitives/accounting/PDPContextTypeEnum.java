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
 * 	7.2.138 PDP-Context-Type AVP
	The PDP-Context-Type AVP (AVP code 1247) is of type Enumerated and indicates the type of a PDP context. The
	values for requested are:
	
	0 Primary
	1 Secondary
	
	This AVP shall only be present in the CCR[Initial]. 
 */
public enum PDPContextTypeEnum implements IntegerEnum
{
	PRIMARY(0),SECONDARY(1);

	private static final Map<Integer, PDPContextTypeEnum> intToTypeMap = new HashMap<Integer, PDPContextTypeEnum>();
	static 
	{
	    for (PDPContextTypeEnum type : PDPContextTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static PDPContextTypeEnum fromInt(Integer value) 
	{
		PDPContextTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private PDPContextTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
