package com.mobius.software.telco.protocols.diameter.primitives.s6a;

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
 * 	7.3.214	PDN-Connection-Continuity
	The PDN-Connection-Continuity AVP is of type Unsigned32 and indicates how to handle the PDN connection when the UE moves between "broadband" (WB-E-UTRAN, UTRAN) and "narrowband" (NB-IoT, GPRS, EC-GSM-IoT). The following values are defined:

	MAINTAIN-PDN-CONNECTION (0)

	DISCONNECT-PDN-CONNECTION-WITH-REACTIVATION-REQUEST (1)

	DISCONNECT-PDN-CONNECTION-WITHOUT-REACTIVATION-REQUEST (2)

	This AVP corresponds to the "PDN continuity at inter RAT mobility" field as defined in 3GPP TS 23.401 [2] table 5.7.1-1.
 */
public enum PDNConnectionContinuityEnum implements IntegerEnum
{
	MAINTAIN_PDN_CONNECTION(0),DISCONNECT_PDN_CONNECTION_WITH_REACTIVATION_REQUEST(1),DISCONNECT_PDN_CONNECTION_WITHOUT_REACTIVATION_REQUEST(2);

	private static final Map<Integer, PDNConnectionContinuityEnum> intToTypeMap = new HashMap<Integer, PDNConnectionContinuityEnum>();
	static
	{
	    for (PDNConnectionContinuityEnum type : PDNConnectionContinuityEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static PDNConnectionContinuityEnum fromInt(Integer value) 
	{
		PDNConnectionContinuityEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private PDNConnectionContinuityEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
