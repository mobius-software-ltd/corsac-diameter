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
 * 	7.3.130	UE-SRVCC-Capability
	The UE-SRVCC-Capability AVP is of type Enumerated. It shall indicate if the UE supports or does not support the SRVCC 
	capability. The following values are defined:
	
	UE-SRVCC-NOT-SUPPORTED (0)

	UE-SRVCC-SUPPORTED (1)
 */
public enum UESRVCCCapabilityEnum implements IntegerEnum
{
	UE_SRVCC_NOT_SUPPORTED(0),UE_SRVCC_SUPPORTED(1);

	private static final Map<Integer, UESRVCCCapabilityEnum> intToTypeMap = new HashMap<Integer, UESRVCCCapabilityEnum>();
	static
	{
	    for (UESRVCCCapabilityEnum type : UESRVCCCapabilityEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static UESRVCCCapabilityEnum fromInt(Integer value) 
	{
		UESRVCCCapabilityEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private UESRVCCCapabilityEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
