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
 * 	7.2.97B MBMS-Charged-Party AVP
	The MBMS-Charged-Party AVP (AVP code 2323) is of type Enumerated and indicates which party is being charged by
	the CDR generated. The following values are supported:
	
	0 Content Provider
	1 Subscriber 
 */
public enum MBMSChargedPartyEnum implements IntegerEnum
{
	CONTENT_PROVIDER(0),SUBSCRIBER(1);

	private static final Map<Integer, MBMSChargedPartyEnum> intToTypeMap = new HashMap<Integer, MBMSChargedPartyEnum>();
	static 
	{
	    for (MBMSChargedPartyEnum type : MBMSChargedPartyEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static MBMSChargedPartyEnum fromInt(Integer value) 
	{
		MBMSChargedPartyEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private MBMSChargedPartyEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
