package com.mobius.software.telco.protocols.diameter.primitives.sgmb;

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
 * 	20.5a.6	MBMS-GW-UDP-Port-Indicator AVP
	MBMS-GW-UDP-Port-Indicator AVP (AVP code 928) is of type Enumerated. It indicates that the payload related to the MBMS service is required to be delivered in the MBMS UDP Port assigned by the MBMS-GW.
	
	UDP-PORT-REQUIRED (1)
	Value 1 indicates that the user plane data corresponding to the MBMS service shall be delivered on the UDP Port provided by the MBMS-GW.
 */
public enum MBMSGWUDPPortIndicatorEnum implements IntegerEnum
{
	UDP_PORT_REQUIRED(1);

	private static final Map<Integer, MBMSGWUDPPortIndicatorEnum> intToTypeMap = new HashMap<Integer, MBMSGWUDPPortIndicatorEnum>();
	static
	{
	    for (MBMSGWUDPPortIndicatorEnum type : MBMSGWUDPPortIndicatorEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static MBMSGWUDPPortIndicatorEnum fromInt(Integer value) 
	{
		MBMSGWUDPPortIndicatorEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private MBMSGWUDPPortIndicatorEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
