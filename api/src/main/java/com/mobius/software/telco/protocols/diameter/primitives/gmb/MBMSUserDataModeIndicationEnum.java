package com.mobius.software.telco.protocols.diameter.primitives.gmb;

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
 * 	17.7.18	MBMS-User-Data-Mode-Indication AVP
	The MBMS-User-Data-Mode-Indication AVP (AVP code 915) is of type Enumerated. The meaning of the message containing this AVP depends on the sending entity. The absence of this AVP indicates unicast mode of operation.
	The following values are supported:

	Unicast (0)
	When BM-SC sends this value, that indicates to GGSN that BM-SC supports only unicast mode (IP multicast packets encapsulated over UDP by IP unicast header).
	When GGSN sends this value, that indicates to BM-SC that BM-SC shall send user plane data with unicast mode (IP multicast packets encapsulated over UDP by IP unicast header).

	Multicast and Unicast (1)
	When BM-SC sends this value, that indicates to GGSN that BM-SC supports both modes of operation.
	When GGSN sends this value, that indicates to BM-SC that BM-SC shall send user plane data with multicast mode.
 */
public enum MBMSUserDataModeIndicationEnum implements IntegerEnum
{
	UNICAST(0),MULTICAST_AND_UNICAST(1);

	private static final Map<Integer, MBMSUserDataModeIndicationEnum> intToTypeMap = new HashMap<Integer, MBMSUserDataModeIndicationEnum>();
	static
	{
	    for (MBMSUserDataModeIndicationEnum type : MBMSUserDataModeIndicationEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static MBMSUserDataModeIndicationEnum fromInt(Integer value) 
	{
		MBMSUserDataModeIndicationEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private MBMSUserDataModeIndicationEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
