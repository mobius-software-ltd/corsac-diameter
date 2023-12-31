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
 * 	7.2.154P Proximity-Alert-Indication AVP
	The Proximity-Alert-Indication AVP (AVP code 3454) is of type Enumerated and indicates whether proximity alert has
	been sent before proximity request cancellation. The AVP may take the values as follows:

	0 Alert
	1 No Alert 
 */
public enum ProximityAlertIndicationEnum implements IntegerEnum
{
	ALERT(0),NO_ALERT(1);

	private static final Map<Integer, ProximityAlertIndicationEnum> intToTypeMap = new HashMap<Integer, ProximityAlertIndicationEnum>();
	static 
	{
	    for (ProximityAlertIndicationEnum type : ProximityAlertIndicationEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static ProximityAlertIndicationEnum fromInt(Integer value) 
	{
		ProximityAlertIndicationEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private ProximityAlertIndicationEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
