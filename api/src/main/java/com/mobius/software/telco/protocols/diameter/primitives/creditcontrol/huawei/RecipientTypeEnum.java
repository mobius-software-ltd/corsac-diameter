package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei;

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
 * 	3.2.403  Premium-Sms-Flag AVP

	AVP Name
	Premium-Sms-Flag

	AVP Code
	30127

	AVP Data Type
	Enumerated

	Vender-ID
	2001

	Vendor Specific
	1

	Mandatory
	1

	Protected
	0 or 1

	Description
	-
 */
public enum RecipientTypeEnum implements IntegerEnum
{
	ZERO(0),ONE(1);

	private static final Map<Integer, RecipientTypeEnum> intToTypeMap = new HashMap<Integer, RecipientTypeEnum>();
	static 
	{
	    for (RecipientTypeEnum type : RecipientTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static RecipientTypeEnum fromInt(Integer value) 
	{
		RecipientTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private RecipientTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
