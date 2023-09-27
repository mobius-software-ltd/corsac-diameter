package com.mobius.software.telco.protocols.diameter.primitives.rx;

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
 * 	5.3.79	MPS-Action AVP
	The MPS-Action AVP (AVP code 582) is of type Enumerated, and contains the indication whether to enable or disable MPS for DTS.
	The following values are defined:

	DISABLE_MPS_FOR_DTS (0)
		Disable MPS for DTS. 

	ENABLE_MPS_FOR_DTS (1)
		Enable MPS for DTS.

	AUTHORIZE_AND_ENABLE_MPS_FOR_DTS (2)
		The PCRF shall check the user's MPS subscription and enable MPS for DTS.

	AUTHORIZE_AND_ENABLE_MPS_FOR_AF_SIGNALLING (3)
		The PCRF shall check the user's MPS subscription and enable MPS for AF signalling.
 */
public enum MPSActionEnum implements IntegerEnum
{
	DISABLE_MPS_FOR_DTS(0),ENABLE_MPS_FOR_DTS(1),AUTHORIZE_AND_ENABLE_MPS_FOR_DTS(2),AUTHORIZE_AND_ENABLE_MPS_FOR_AF_SIGNALLING(3);

	private static final Map<Integer, MPSActionEnum> intToTypeMap = new HashMap<Integer, MPSActionEnum>();
	static
	{
	    for (MPSActionEnum type : MPSActionEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static MPSActionEnum fromInt(Integer value) 
	{
		MPSActionEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private MPSActionEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
