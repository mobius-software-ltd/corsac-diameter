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
 * 	7.2.198 Serving-Node-Type AVP
	The Serving-Node-Type AVP (AVP Code 2047) is of type Enumerated and identifies the type of Serving Node. It may
	take the following values:

	0 SGSN
	1 PMIPSGW
	2 GTPSGW
	3 ePDG
	4 hSGW
	5 MME
	6 TWAN
 */
public enum ServingNodeTypeEnum implements IntegerEnum
{
	INBOUND(0),OUTBOUND(1);

	private static final Map<Integer, ServingNodeTypeEnum> intToTypeMap = new HashMap<Integer, ServingNodeTypeEnum>();
	static 
	{
	    for (ServingNodeTypeEnum type : ServingNodeTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static ServingNodeTypeEnum fromInt(Integer value) 
	{
		ServingNodeTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private ServingNodeTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
