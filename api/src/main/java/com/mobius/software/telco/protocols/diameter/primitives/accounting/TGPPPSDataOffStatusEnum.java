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
 * 	7.2.0aA 3GPP-PS-Data-Off-Status AVP
	The 3GPP-PS-Data-Off-Status AVP (AVP code 4406) is of type Enumerated and indicated the change in 3GPP PS
	Data off status of UE. The following values are defined:
	
	0 Active
	1 Inactive 
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
