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
 * 	120.5a.1	MBMS-Access-Indicator AVP
	The MBMS-Access-Indicator AVP (AVP code 923) is of type Enumerated. It indicates whether the MBMS bearer service will be delivered in UTRAN-only, E-UTRAN-only or both coverage areas. The following values are supported:
	
	UTRAN (0)
	The MBMS bearer service shall only be delivered in UTRAN only coverage areas.

	E-UTRAN (1)
	The MBMS bearer service shall only be delivered in E-UTRAN only coverage areas.

	UTRAN-AND-E-UTRAN (2)
	The MBMS bearer service shall be delivered both in UTRAN and E-UTRAN coverage areas.
 */
public enum MBMSAccessIndicatorEnum implements IntegerEnum
{
	UTRAN(0),EUTRAN(1),UTRAN_AND_EUTRAN(2);

	private static final Map<Integer, MBMSAccessIndicatorEnum> intToTypeMap = new HashMap<Integer, MBMSAccessIndicatorEnum>();
	static
	{
	    for (MBMSAccessIndicatorEnum type : MBMSAccessIndicatorEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static MBMSAccessIndicatorEnum fromInt(Integer value) 
	{
		MBMSAccessIndicatorEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private MBMSAccessIndicatorEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
