package com.mobius.software.telco.protocols.diameter.primitives.s6c;

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
 * 	5.3.3.37	SMSF-3GPP-SBI-Support-Indicator
	The SMSF-3GPP-SBI-Support-Indicator AVP is of type Enumerated and shall indicate whether the SMSF support service-based-interface or not, with the following values:

	-	NOT_SUPPORT_SBI (0),

	-	SUPPORT_SBI (1).
 */
public enum SMSFNon3GPPSBISupportIndicatorEnum implements IntegerEnum
{
	NOT_SUPPORT_SBI(0),SUPPORT_SBI(1);

	private static final Map<Integer, SMSFNon3GPPSBISupportIndicatorEnum> intToTypeMap = new HashMap<Integer, SMSFNon3GPPSBISupportIndicatorEnum>();
	static
	{
	    for (SMSFNon3GPPSBISupportIndicatorEnum type : SMSFNon3GPPSBISupportIndicatorEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static SMSFNon3GPPSBISupportIndicatorEnum fromInt(Integer value) 
	{
		SMSFNon3GPPSBISupportIndicatorEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private SMSFNon3GPPSBISupportIndicatorEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
