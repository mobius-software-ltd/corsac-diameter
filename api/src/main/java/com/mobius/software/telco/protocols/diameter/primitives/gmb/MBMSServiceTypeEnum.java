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
 * 	17.7.9	MBMS-Service-Type AVP
	The MBMS-Service-Type AVP (AVP code 906) is of type Enumerated, and contains explicit information about the type of service that the BM-SC Start Procedure is about to start.

	MULTICAST (0)
	The Start Procedure signalled by the BM-SC is for a Multicast Service.

	BROADCAST (1)
	The Start Procedure signalled by the BM-SC is for a Broadcast Service.
 */
public enum MBMSServiceTypeEnum implements IntegerEnum
{
	MULTICAST(0),BROADCAST(1);

	private static final Map<Integer, MBMSServiceTypeEnum> intToTypeMap = new HashMap<Integer, MBMSServiceTypeEnum>();
	static
	{
	    for (MBMSServiceTypeEnum type : MBMSServiceTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static MBMSServiceTypeEnum fromInt(Integer value) 
	{
		MBMSServiceTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private MBMSServiceTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
