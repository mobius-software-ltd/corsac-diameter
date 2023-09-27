package com.mobius.software.telco.protocols.diameter.primitives.oma;

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
 * 6.2.4 Application Service Type
	This data element can be used to differentiate between the different roles of a node within service events, e.g. the sending and
	receiving roles of participating and controlling functions.
	Service 	Context Name Value Description
	SIMPLE_IM 	SENDING 	 100
				RECEIVING 	 101
				RETRIEVAL 	 102
				INVITING 	 103
				LEAVING  	 104
				JOINING      105

	Table 5: Application Service Type Values
 */
public enum ApplicationServiceTypeEnum implements IntegerEnum
{
	SENDING(100),RECEIVING(101),RETRIEVAL(102),INVITING(103),LEAVING(104),JOINING(105);

	private static final Map<Integer, ApplicationServiceTypeEnum> intToTypeMap = new HashMap<Integer, ApplicationServiceTypeEnum>();
	static
	{
	    for (ApplicationServiceTypeEnum type : ApplicationServiceTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static ApplicationServiceTypeEnum fromInt(Integer value) 
	{
		ApplicationServiceTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private ApplicationServiceTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
