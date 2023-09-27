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
 * 	7.3.38	VPLMN-Dynamic-Address-Allowed
	The VPLMN-Dynamic-Address-Allowed AVP is of type Enumerated. It shall indicate whether for this APN, the UE is allowed to use the PDN GW in the domain of the HPLMN only, or additionally, the PDN GW in the domain of the VPLMN.. If this AVP is not present, this means that the UE is not allowed to use PDN GWs in the domain of the VPLMN. The following values are defined:

	NOTALLOWED (0)

	ALLOWED (1)
 */
public enum VPLMNDynamicAddressAllowedEnum implements IntegerEnum
{
	NOTALLOWED(0),ALLOWED(1);

	private static final Map<Integer, VPLMNDynamicAddressAllowedEnum> intToTypeMap = new HashMap<Integer, VPLMNDynamicAddressAllowedEnum>();
	static
	{
	    for (VPLMNDynamicAddressAllowedEnum type : VPLMNDynamicAddressAllowedEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static VPLMNDynamicAddressAllowedEnum fromInt(Integer value) 
	{
		VPLMNDynamicAddressAllowedEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private VPLMNDynamicAddressAllowedEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
