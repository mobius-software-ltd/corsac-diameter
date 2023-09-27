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
 * 	5.3.31	Rx-Request-Type AVP
	The Rx-Request-Type AVP (AVP code 533) is of type Enumerated, and contains the reason for sending the AA-Request message.
	The following values are defined:

	INITIAL_REQUEST (0)
		An initial request is used to initiate an Rx session and contains information that is relevant to initiation.

	UPDATE_REQUEST (1)
		An update request is used to update an existing Rx session.

	PCSCF_RESTORATION (2)
		A P-CSCF Restoration is requested. This value is only applicable to the PCSCF-Restoration-Enhancement feature defined in clause 5.4.1.
 */
public enum RxRequestTypeEnum implements IntegerEnum
{
	INITIAL_REQUEST(0),UPDATE_REQUEST(1),PCSCF_RESTORATION(2);

	private static final Map<Integer, RxRequestTypeEnum> intToTypeMap = new HashMap<Integer, RxRequestTypeEnum>();
	static
	{
	    for (RxRequestTypeEnum type : RxRequestTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static RxRequestTypeEnum fromInt(Integer value) 
	{
		RxRequestTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private RxRequestTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
