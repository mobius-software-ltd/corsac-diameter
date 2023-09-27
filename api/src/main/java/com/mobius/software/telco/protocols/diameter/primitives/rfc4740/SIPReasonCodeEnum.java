package com.mobius.software.telco.protocols.diameter.primitives.rfc4740;

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
 * 	9.7.1.  SIP-Reason-Code AVP

   	The SIP-Reason-Code AVP (AVP Code 384) is of type Enumerated and
   	defines the reason for the network initiated deregistration.  The
   	following values are defined:

   	o  PERMANENT_TERMINATION (0)
   
   	o  NEW_SIP_SERVER_ASSIGNED (1)
   
   	o  SIP_SERVER_CHANGE (2)
   
   	o  REMOVE_SIP_SERVER (3)
 */
public enum SIPReasonCodeEnum implements IntegerEnum
{
	PERMANENT_TERMINATION(0),NEW_SIP_SERVER_ASSIGNED(1),SIP_SERVER_CHANGE(2),REMOVE_SIP_SERVER(3);

	private static final Map<Integer, SIPReasonCodeEnum> intToTypeMap = new HashMap<Integer, SIPReasonCodeEnum>();
	static
	{
	    for (SIPReasonCodeEnum type : SIPReasonCodeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static SIPReasonCodeEnum fromInt(Integer value) 
	{
		SIPReasonCodeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private SIPReasonCodeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
