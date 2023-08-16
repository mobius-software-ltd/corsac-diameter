package com.mobius.software.telco.protocols.diameter.primitives.gx;

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
 * 	5.3.133 3GPP-PS-Data-Off-Status AVP (Applicable access type 3GPP-EPS)
	The 3GPP-PS-Data-Off-Status AVP (AVP code 2847) is of type Enumerated, and describes the 3GPP PS Data off
	status indicated by the UE.
	The following values are defined:

	ACTIVE (0)
 		This value is used to indicate that the UE activates the 3GPP PS Data off.
	INACTIVE (1)
 		This value is used to indicate that the UE deactivates the 3GPP PS Data off. This is the default value applicable
		if this AVP has not been supplied yet. 
 */
public enum TGPPPSDataOffStatusEnum implements IntegerEnum
{
	ACTIVE(0),INACTIVE(1);

	private static final Map<Integer, TGPPPSDataOffStatusEnum> intToTypeMap = new HashMap<Integer, TGPPPSDataOffStatusEnum>();
	static
	{
	    for (TGPPPSDataOffStatusEnum type : TGPPPSDataOffStatusEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static TGPPPSDataOffStatusEnum fromInt(Integer value) 
	{
		TGPPPSDataOffStatusEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private TGPPPSDataOffStatusEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
