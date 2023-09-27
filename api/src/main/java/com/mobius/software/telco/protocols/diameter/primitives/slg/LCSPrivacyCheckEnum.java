package com.mobius.software.telco.protocols.diameter.primitives.slg;

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
 * 	7.4.14	LCS-Privacy-Check
	The LCS-Privacy-Check AVP is of type Enumerated. The following values are defined:

	ALLOWED_WITHOUT_NOTIFICATION (0)

	ALLOWED_WITH_NOTIFICATION (1)

	ALLOWED_IF_NO_RESPONSE (2)

	RESTRICTED_IF_NO_RESPONSE (3)

	NOT_ALLOWED (4)

	Default value if AVP is not present is: ALLOWED_WITHOUT_NOTIFICATION (0).
 */
public enum LCSPrivacyCheckEnum implements IntegerEnum
{
	ALLOWED_WITHOUT_NOTIFICATION(0),ALLOWED_WITH_NOTIFICATION(1),ALLOWED_IF_NO_RESPONSE(2),RESTRICTED_IF_NO_RESPONSE(3),NOT_ALLOWED(4);

	private static final Map<Integer, LCSPrivacyCheckEnum> intToTypeMap = new HashMap<Integer, LCSPrivacyCheckEnum>();
	static
	{
	    for (LCSPrivacyCheckEnum type : LCSPrivacyCheckEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static LCSPrivacyCheckEnum fromInt(Integer value) 
	{
		LCSPrivacyCheckEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private LCSPrivacyCheckEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
