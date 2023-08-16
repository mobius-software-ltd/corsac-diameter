package com.mobius.software.telco.protocols.diameter.primitives.sh;

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
 * 	6.3.6 Subs-Req-Type AVP
	The Subs-Req-Type AVP is of type Enumerated, and indicates the type of the subscription-to-notifications request. The
	following values are defined:

	Subscribe (0)
		This value is used by an AS to subscribe to notifications of changes in data.
	Unsubscribe (1)
		This value is used by an AS to unsubscribe to notifications of changes in data. 
 */
public enum SubsReqTypeEnum implements IntegerEnum
{
	SUBSCRIBE(0),UNSUBSCRIBE(1);

	private static final Map<Integer, SubsReqTypeEnum> intToTypeMap = new HashMap<Integer, SubsReqTypeEnum>();
	static
	{
	    for (SubsReqTypeEnum type : SubsReqTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static SubsReqTypeEnum fromInt(Integer value) 
	{
		SubsReqTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private SubsReqTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
