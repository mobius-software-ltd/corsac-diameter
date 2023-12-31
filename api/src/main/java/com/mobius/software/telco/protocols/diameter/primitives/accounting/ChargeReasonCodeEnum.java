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
 * 	7.2.38A Charge-Reason-Code AVP
	The Charge-Reason-Code AVP (AVP code 2118) is of type Enumerated and identifies if the Rate-Element corresponds
	to a specific charge type. It can be one of the following values:

	0 UNKNOWN
	1 USAGE
	2 COMMUNICATION-ATTEMPT-CHARGE
	3 SETUP-CHARGE
	4 ADD-ON-CHARGE 
 */
public enum ChargeReasonCodeEnum implements IntegerEnum
{
	UNKNOWN(0),USAGE(1),COMMUNICATION_ATTEMPT_CHARGE(2),SETUP_CHARGE(3),ADD_ON_CHARGE(4);

	private static final Map<Integer, ChargeReasonCodeEnum> intToTypeMap = new HashMap<Integer, ChargeReasonCodeEnum>();
	static 
	{
	    for (ChargeReasonCodeEnum type : ChargeReasonCodeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static ChargeReasonCodeEnum fromInt(Integer value) 
	{
		ChargeReasonCodeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private ChargeReasonCodeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
