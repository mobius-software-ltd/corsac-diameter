package com.mobius.software.telco.protocols.diameter.primitives.swx;

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
 * 	8.2.3.3 Non-3GPP-IP-Access
	The Non-3GPP-IP-Access AVP (AVP code 1501) is of type Enumerated, and allows operators to determine barring of
	3GPP - non-3GPP interworking subscription. The following values are defined:
 
 	NON_3GPP_SUBSCRIPTION_ALLOWED (0)
 	The subscriber has non-3GPP subscription to access EPC network.
 
 	NON_3GPP_SUBSCRIPTION_BARRED (1) 
 	The subscriber has no non-3GPP subscription to access EPC network
 */
public enum Non3GPPIPAccessAPNEnum implements IntegerEnum
{
	NON_3GPP_SUBSCRIPTION_ALLOWED(0),NON_3GPP_SUBSCRIPTION_BARRED(1);

	private static final Map<Integer, Non3GPPIPAccessAPNEnum> intToTypeMap = new HashMap<Integer, Non3GPPIPAccessAPNEnum>();
	static
	{
	    for (Non3GPPIPAccessAPNEnum type : Non3GPPIPAccessAPNEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static Non3GPPIPAccessAPNEnum fromInt(Integer value) 
	{
		Non3GPPIPAccessAPNEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private Non3GPPIPAccessAPNEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
