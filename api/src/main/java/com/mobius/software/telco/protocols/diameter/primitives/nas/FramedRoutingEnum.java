package com.mobius.software.telco.protocols.diameter.primitives.nas;

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
 * 4.4.10.2.  Framed-Routing AVP

   The Framed-Routing AVP (AVP Code 10) is of type Enumerated and
   contains the routing method for the user when the user is a router to
   a network.  This AVP SHOULD only be present in authorization
   responses.  The supported values are listed in [RADIUSAttrVals].
 */
public enum FramedRoutingEnum implements IntegerEnum
{
	NONE(0),SEND(1),LISTEN(2),SEND_AND_LISTEN(3);

	private static final Map<Integer, FramedRoutingEnum> intToTypeMap = new HashMap<Integer, FramedRoutingEnum>();
	static
	{
	    for (FramedRoutingEnum type : FramedRoutingEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static FramedRoutingEnum fromInt(Integer value) 
	{
		FramedRoutingEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private FramedRoutingEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
