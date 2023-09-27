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
 * 	7.3.67	Trace-Depth AVP
	The Trace-Depth AVP is of type Enumerated. The possible values are those defined in 3GPP TS 32.422 [23] for Trace Depth.

	Trace depth shall be an enumerated parameter with the following possible values:
	0 – Minimum,
	1 – Medium
	2 – Maximum
	3 – MinimumWithoutVendorSpecificExtension
	4 – MediumWithoutVendorSpecificExtension
	5 - MaximumWithoutVendorSpecificExtension 
 */
public enum TraceDepthEnum implements IntegerEnum
{
	MINIMUM(0),MEDIUM(1),MAXIMUM(2),MINIMUMWITHOUTVENDORSPECIFICEXTENSION(3),MEDIUMWITHOUTVENDORSPECIFICEXTENSION(4),MAXIMUMWITHOUTVENDORSPECIFICEXTENSION(5);

	private static final Map<Integer, TraceDepthEnum> intToTypeMap = new HashMap<Integer, TraceDepthEnum>();
	static
	{
	    for (TraceDepthEnum type : TraceDepthEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static TraceDepthEnum fromInt(Integer value) 
	{
		TraceDepthEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private TraceDepthEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
