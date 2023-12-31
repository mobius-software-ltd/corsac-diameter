package com.mobius.software.telco.protocols.diameter.primitives.nas;

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
 * 4.6.7.  Accounting-Auth-Method AVP

   The Accounting-Auth-Method AVP (AVP Code 406) is of type Enumerated.
   A NAS MAY include this AVP in an Accounting-Request message to
   indicate the method used to authenticate the user.  (Note that this
   AVP is semantically equivalent, and the supported values are
   identical, to the Microsoft MS-Acct-Auth-Type vendor-specific RADIUS
   attribute [RFC2548]).
 */
public enum AccountingAuthMethodEnum implements IntegerEnum
{
	PAP(1),CHAP(2),MS_CHAP_1(3),MS_CHAP_2(4),EAP(5);

	private static final Map<Integer, AccountingAuthMethodEnum> intToTypeMap = new HashMap<Integer, AccountingAuthMethodEnum>();
	static
	{
	    for (AccountingAuthMethodEnum type : AccountingAuthMethodEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static AccountingAuthMethodEnum fromInt(Integer value) 
	{
		AccountingAuthMethodEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private AccountingAuthMethodEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
