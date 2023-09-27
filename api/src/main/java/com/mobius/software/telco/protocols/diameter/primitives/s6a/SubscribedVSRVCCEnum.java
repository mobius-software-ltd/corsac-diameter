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
 * 	7.3.150	Subscribed-VSRVCC
	The Subscribed-VSRVCC AVP is of type Enumerated. It shall indicate that the user is subscribed to the vSRVCC. The following value is defined:

	VSRVCC_SUBSCRIBED (0)

	Absence of this AVP in IDR shall be interpreted as the Subscribed-VSRVCC has not been modified.

	Absence of this AVP in ULA shall be interpreted as the user is not subscribed to the vSRVCC.
 */
public enum SubscribedVSRVCCEnum implements IntegerEnum
{
	VSRVCC_SUBSCRIBED(0);

	private static final Map<Integer, SubscribedVSRVCCEnum> intToTypeMap = new HashMap<Integer, SubscribedVSRVCCEnum>();
	static
	{
	    for (SubscribedVSRVCCEnum type : SubscribedVSRVCCEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static SubscribedVSRVCCEnum fromInt(Integer value) 
	{
		SubscribedVSRVCCEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private SubscribedVSRVCCEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
