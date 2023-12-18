package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ericsson;

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
 * 	3.1.6 Other-Party-Id-Type AVP
	The Other-Party-Id-Type AVP (AVP code 1078) is of type Enumerated and it is
	used to determine which type of identifier is carried by the Other-Party-Id AVP.

	0 END_USER_E164 
	The identifier is in E.164 format. Other-Party-Id-Nature
	AVP defines the nature of address that is used.

	1 END_USER_IMSI
	The identifier is in international IMSI format.
	
	2 END_USER_SIP_URI
	The identifier is in the form of a SIP URI.

	3 END_USER_NAI
	The identifier is in the form of a Network Access Identifier.
	The only supported value is END_USER_E164 in the SCAPv2 service context.
 */
public enum OtherPartyIdTypeEnum implements IntegerEnum
{
	END_USER_E164(0),END_USER_IMSI(1),END_USER_SIP_URI(2), END_USER_NAI(3);

	private static final Map<Integer, OtherPartyIdTypeEnum> intToTypeMap = new HashMap<Integer, OtherPartyIdTypeEnum>();
	static 
	{
	    for (OtherPartyIdTypeEnum type : OtherPartyIdTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static OtherPartyIdTypeEnum fromInt(Integer value) 
	{
		OtherPartyIdTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private OtherPartyIdTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
