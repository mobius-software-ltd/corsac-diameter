package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol;

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
 * 8.50.  User-Equipment-Info-Type AVP

   The User-Equipment-Info-Type AVP is of type Enumerated (AVP Code 459)
   and defines the type of user equipment information contained in the
   User-Equipment-Info-Value AVP.

   This specification defines the following user equipment types.
   However, new User-Equipment-Info-Type values can be assigned by IANA
   as defined in Section 12.

   IMEISV           0

   The identifier contains the International Mobile Equipment Identifier
   and Software Version (IMEISV) in the IMEISV format according to 3GPP
   TS 23.003 [TGPPIMEI].

    MAC              1

   The 48-bit Media Access Control (MAC) address is formatted as
   described in Section 3.21 of [RFC3580].

   EUI64            2

   The 64-bit identifier used to identify the hardware instance of the
   product, as defined in [EUI64].

   MODIFIED_EUI64   3

   There are a number of types of terminals that have identifiers other
   than the International Mobile Equipment Identifier (IMEI), IEEE 802
   MACs, or EUI-64.  These identifiers can be converted to modified
   EUI-64 format as described in [RFC4291] or by using some other
   methods referred to in the service-specific documentation.
 */
public enum UserEquipmentInfoTypeEnum implements IntegerEnum
{
	IMEISV(0),MAC(1),EUI64(2),MODIFIED_EUI64(3);

	private static final Map<Integer, UserEquipmentInfoTypeEnum> intToTypeMap = new HashMap<Integer, UserEquipmentInfoTypeEnum>();
	static 
	{
	    for (UserEquipmentInfoTypeEnum type : UserEquipmentInfoTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static UserEquipmentInfoTypeEnum fromInt(Integer value) 
	{
		UserEquipmentInfoTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private UserEquipmentInfoTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
