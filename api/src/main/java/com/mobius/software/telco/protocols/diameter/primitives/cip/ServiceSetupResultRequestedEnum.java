package com.mobius.software.telco.protocols.diameter.primitives.cip;
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

import java.util.HashMap;
import java.util.Map;

import com.mobius.software.telco.protocols.diameter.primitives.IntegerEnum;

/*
	4.4.9 Service-Setup-Result-Requested AVP
	The Service-Setup-Result-Requested AVP (AVP code 1136) is included and
	has the value RESULT_REQUESTED if the result of the service setup should
	be reported for all services, even if the service isn't under credit control or for
	failed service setups.
	The Service-Setup-Result-Requested is of the type Enumerated.
			The possible values are:
			• 0 = RESULT_NOT_NEEDED
			• 1 = RESULT_REQUESTED
*/
public enum ServiceSetupResultRequestedEnum implements IntegerEnum
{
	RESULT_NOT_NEEDED(0),RESULT_REQUESTED(1);

	private static final Map<Integer, ServiceSetupResultRequestedEnum> intToTypeMap = new HashMap<Integer, ServiceSetupResultRequestedEnum>();
	static 
	{
	    for (ServiceSetupResultRequestedEnum type : ServiceSetupResultRequestedEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static ServiceSetupResultRequestedEnum fromInt(Integer value) 
	{
		ServiceSetupResultRequestedEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private ServiceSetupResultRequestedEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
