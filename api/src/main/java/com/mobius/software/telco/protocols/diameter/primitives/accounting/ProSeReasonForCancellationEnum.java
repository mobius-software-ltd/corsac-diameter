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
 * 	7.2.154K ProSe-Reason-For-Cancellation AVP
	The ProSe-Reason-For-Cancellation AVP (AVP code 3449) is of type Enumerated and indicates the reason for
	cancellation of an EPC-level discovery request. The AVP may take the values as follows:
	
	0 Proximity Alert sent
	1 Time expired with no renewal
	2 Requestor cancellation 
 */
public enum ProSeReasonForCancellationEnum implements IntegerEnum
{
	PROXIMITY_ALERT(0),TIME_EXPIRED(1),REQUESTOR_CANCELLATION(2);

	private static final Map<Integer, ProSeReasonForCancellationEnum> intToTypeMap = new HashMap<Integer, ProSeReasonForCancellationEnum>();
	static 
	{
	    for (ProSeReasonForCancellationEnum type : ProSeReasonForCancellationEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static ProSeReasonForCancellationEnum fromInt(Integer value) 
	{
		ProSeReasonForCancellationEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private ProSeReasonForCancellationEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
