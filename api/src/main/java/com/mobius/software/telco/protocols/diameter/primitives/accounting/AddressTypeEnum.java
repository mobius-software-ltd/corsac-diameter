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
 * 	7.2.9 Address-Type AVP
	The Address-Type AVP (AVP code 899) is of type Enumerated and indicates the type of address carried within the
	Address-Information AVP. It has the following values:

	0 e-mail address
	1 MSISDN
	2 IPv4 Address
	3 IPv6 Address
	4 Numeric Shortcode
	5 Alphanumeric Shortcode
	6 Other
	7 IMSI 
 */
public enum AddressTypeEnum implements IntegerEnum
{
	EMAIL_ADDRESS(0),MSISDN(1),IP_V4(2),IP_V6(3),NUMERIC_SHORTCODE(4),ALPHA_SHORTCODE(5),OTHER(6),IMSI(7);

	private static final Map<Integer, AddressTypeEnum> intToTypeMap = new HashMap<Integer, AddressTypeEnum>();
	static
	{
	    for (AddressTypeEnum type : AddressTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static AddressTypeEnum fromInt(Integer value) 
	{
		AddressTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private AddressTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
