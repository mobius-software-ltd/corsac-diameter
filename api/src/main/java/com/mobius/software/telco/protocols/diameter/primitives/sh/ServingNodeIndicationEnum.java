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
 * 	6.3.23 Serving-Node-Indication AVP
	The Serving-Node-Indication AVP is of type Enumerated. If present it indicates that the sender does not require any
	location information other than the Serving Node Addresses/Identities requested (e.g. MME name, VLR number). Other
	location information (e.g. Global Cell ID, Tracking Area ID) may be absent. The following values are defined:

	ONLY_SERVING_NODES_REQUIRED (0) 
 */
public enum ServingNodeIndicationEnum implements IntegerEnum
{
	ONLY_SERVING_NODES_REQUIRED(0);

	private static final Map<Integer, ServingNodeIndicationEnum> intToTypeMap = new HashMap<Integer, ServingNodeIndicationEnum>();
	static
	{
	    for (ServingNodeIndicationEnum type : ServingNodeIndicationEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static ServingNodeIndicationEnum fromInt(Integer value) 
	{
		ServingNodeIndicationEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private ServingNodeIndicationEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
