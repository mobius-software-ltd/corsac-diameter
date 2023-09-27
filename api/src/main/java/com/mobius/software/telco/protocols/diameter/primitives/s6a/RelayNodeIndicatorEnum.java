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
 * 	7.3.147	Relay-Node-Indicator
	The Relay-Node-Indicator AVP is of type Enumerated. It shall indicate whether the subscription data belongs to a Relay Node or not (see 3GPP TS 36.300 [40]). The following values are defined:

	NOT_RELAY_NODE (0)
	This value indicates that the subscription data does not belong to a Relay Node.

	RELAY_NODE (1)
	This value indicates that the subscription data belongs to a Relay Node.

	The default value when this AVP is not present is NOT_RELAY_NODE (0).
 */
public enum RelayNodeIndicatorEnum implements IntegerEnum
{
	NOT_RELAY_NODE(0),RELAY_NODE(1);

	private static final Map<Integer, RelayNodeIndicatorEnum> intToTypeMap = new HashMap<Integer, RelayNodeIndicatorEnum>();
	static
	{
	    for (RelayNodeIndicatorEnum type : RelayNodeIndicatorEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static RelayNodeIndicatorEnum fromInt(Integer value) 
	{
		RelayNodeIndicatorEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private RelayNodeIndicatorEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
