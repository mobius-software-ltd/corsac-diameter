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
 * 	7.2.57A Dynamic-Address-Flag-Extension AVP
	The Dynamic-Address-Flag-Extension AVP (AVP code 2068) is of type Enumerated, and indicatesthat the IPv4 PDN
	address has been dynamically allocated for that particular IP CAN bearer (PDN connection) of PDN type IPv4v6, and
	the dynamic IPv6 address is indicated in Dynamic Address Flag. If this AVP is not present, this means that the address
	is statically allocated.The following values are defined:

	0 Static
	1 Dynamic	
 */
public enum DynamicAddressFlagExtensionEnum implements IntegerEnum
{
	STATIC(0),DYNAMIC(1);

	private static final Map<Integer, DynamicAddressFlagExtensionEnum> intToTypeMap = new HashMap<Integer, DynamicAddressFlagExtensionEnum>();
	static 
	{
	    for (DynamicAddressFlagExtensionEnum type : DynamicAddressFlagExtensionEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static DynamicAddressFlagExtensionEnum fromInt(Integer value) 
	{
		DynamicAddressFlagExtensionEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private DynamicAddressFlagExtensionEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
