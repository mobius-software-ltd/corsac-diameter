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
 * 	7.2.80A IP-Realm-Default-Indication AVP
	The IP-Realm-Default-Indication-Indication AVP (AVP code 2603) is of type Enumerated and indicates whether the IP
	realm used for the SDP media component is the Default IP realm or not. The following values are defined:
	
	0 Default IP Realm Not used
	1 Default IP realm used 
 */
public enum IPRealmDefaultIndicationEnum implements IntegerEnum
{
	NOT_USED(0),USED(1);

	private static final Map<Integer, IPRealmDefaultIndicationEnum> intToTypeMap = new HashMap<Integer, IPRealmDefaultIndicationEnum>();
	static 
	{
	    for (IPRealmDefaultIndicationEnum type : IPRealmDefaultIndicationEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static IPRealmDefaultIndicationEnum fromInt(Integer value) 
	{
		IPRealmDefaultIndicationEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private IPRealmDefaultIndicationEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
