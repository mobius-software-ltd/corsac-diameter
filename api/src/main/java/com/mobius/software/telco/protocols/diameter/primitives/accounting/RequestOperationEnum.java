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
	A.4.22.  Request-Operation AVP
	The Request-Operation AVP (AVP Code 1017) is of type Enumerated and identifies the type of operation 
	requested. The values are defined in Table 6.3.4.2.5-6.
	
	6.3.4.2.5 m2m:operation
	Used for Operation parameter in request and operation attribute in <request> resource as well as operationMonitor.
	Table 6.3.4.2.5‑6: Interpretation of operation
	Value Interpretation
	1 Create
	2 Retrieve
	3 Update
	4 Delete
	5 Notify
	
	NOTE: See clause 6.4.1 “Request message parameter data types”
*/
public enum RequestOperationEnum implements IntegerEnum
{
	CREATE(1),RETREIVE(2),UPDATE(3),DELETE(4),UPDATED(2004),NOTIFY(5);

	private static final Map<Integer, RequestOperationEnum> intToTypeMap = new HashMap<Integer, RequestOperationEnum>();
	static 
	{
	    for (RequestOperationEnum type : RequestOperationEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static RequestOperationEnum fromInt(Integer value) 
	{
		RequestOperationEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private RequestOperationEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
