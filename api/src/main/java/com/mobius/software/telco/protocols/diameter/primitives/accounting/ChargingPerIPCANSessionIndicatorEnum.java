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
 * 	7.2.39B Charging-Per-IP-CAN-Session-Indicator AVP
	The Charging-Per-IP-CAN-Session-Indicator AVP (AVP code 4400) is of type of Enumerated. It indicates whether the
	charging per IP-CAN session is active for offline charging. If this AVP is not present, that means charging per IP-CAN
	session is not active.
	The following value is defined:
	
	0 Inactive
	1 Active
 */
public enum ChargingPerIPCANSessionIndicatorEnum implements IntegerEnum
{
	INACTIVE(0),ACTIVE(1);

	private static final Map<Integer, ChargingPerIPCANSessionIndicatorEnum> intToTypeMap = new HashMap<Integer, ChargingPerIPCANSessionIndicatorEnum>();
	static 
	{
	    for (ChargingPerIPCANSessionIndicatorEnum type : ChargingPerIPCANSessionIndicatorEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static ChargingPerIPCANSessionIndicatorEnum fromInt(Integer value) 
	{
		ChargingPerIPCANSessionIndicatorEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private ChargingPerIPCANSessionIndicatorEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
