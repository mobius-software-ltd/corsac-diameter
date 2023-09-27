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
 * 	7.2.135C PC5-Radio-Technology AVP
	The PC5-Radio-Technology AVP (AVP code 1300) is of type Enumerated and indicates the PC5 radio technology that
	the UE used for ProSe Direct Discovery. This AVP may take the value from the following:
	
	0 EUTRA
	1 WLAN
	2 Both EUTRA and WLAN 
 */
public enum PC5RadioTechnologyEnum implements IntegerEnum
{
	EUTRA(0),WLAN(1),BOTH(2);

	private static final Map<Integer, PC5RadioTechnologyEnum> intToTypeMap = new HashMap<Integer, PC5RadioTechnologyEnum>();
	static 
	{
	    for (PC5RadioTechnologyEnum type : PC5RadioTechnologyEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static PC5RadioTechnologyEnum fromInt(Integer value) 
	{
		PC5RadioTechnologyEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private PC5RadioTechnologyEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
