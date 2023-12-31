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
 * 	7.2.67 File-Repair-Supported AVP
	The File-Repair-Supported AVP (AVP code 1224) is of type Enumerated and indicates whether the MBMS user service
	supports point-to-point file repair. The following values are supported:
	
	1 SUPPORTED
 		The MBMS user service does support point-to-point file repair.
	2 NOT_SUPPORTED
 		The MBMS user service does not support point-to-point file repair.
 */
public enum FileRepairSupportedEnum implements IntegerEnum
{
	SUPPORTED(0),MBMS_USER_SUPPORTED(1),NOT_SUPPORTED(2),MBMS_USER__NOT_SUPPORTED(3);

	private static final Map<Integer, FileRepairSupportedEnum> intToTypeMap = new HashMap<Integer, FileRepairSupportedEnum>();
	static 
	{
	    for (FileRepairSupportedEnum type : FileRepairSupportedEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static FileRepairSupportedEnum fromInt(Integer value) 
	{
		FileRepairSupportedEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private FileRepairSupportedEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
