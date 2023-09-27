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
 * 	7.2.212 SMS-Node AVP
	The SMS-Node AVP (AVP code 2016) is of type Enumerated and identifies the role which the SMS node performs in
	relation to the charging event. It takes the following values:
	
	0 SMS Router
	1 IP-SM-GW
	2 SMS Router and IP-SM-GW
	3 SMS-SC 
 */
public enum SMSNodeEnum implements IntegerEnum
{
	SMS_ROUTER(0),IP_SM_GW(1),SMS_ROUTER_AND_IP_SM_GW(2),SMS_SC(3);

	private static final Map<Integer, SMSNodeEnum> intToTypeMap = new HashMap<Integer, SMSNodeEnum>();
	static 
	{
	    for (SMSNodeEnum type : SMSNodeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static SMSNodeEnum fromInt(Integer value) 
	{
		SMSNodeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private SMSNodeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
