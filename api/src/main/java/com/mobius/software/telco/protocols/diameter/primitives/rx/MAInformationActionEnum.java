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
 * 	5.3.67	MA-Information-Action AVP 
	The MA-Information-Action AVP (AVP code 571) is of type Unsigned32, and it indicates the action to apply to the IP-CAN type and RAT type values included in the MA-Information AVP.
	The following values are defined in this specification:

	0 (ADD):
		This value shall be used to indicate that the IP-CAN Type/RAT Type included in the MA-Information AVP are available for the MA PDU session.

	1 (RELEASE):
		This value shall be used to indicate that the IP-CAN Type/RAT Type included in the MA-Information AVP are released and not available for the MA PDU session.
	
	0 (ADD) is the default value.
 */
public enum MAInformationActionEnum implements IntegerEnum
{
	ADD(0),RELEASE(1);

	private static final Map<Integer, MAInformationActionEnum> intToTypeMap = new HashMap<Integer, MAInformationActionEnum>();
	static
	{
	    for (MAInformationActionEnum type : MAInformationActionEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static MAInformationActionEnum fromInt(Integer value) 
	{
		MAInformationActionEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private MAInformationActionEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
