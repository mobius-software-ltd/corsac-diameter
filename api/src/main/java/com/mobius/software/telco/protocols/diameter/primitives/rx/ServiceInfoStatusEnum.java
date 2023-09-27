package com.mobius.software.telco.protocols.diameter.primitives.rx;

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
 * 	5.3.25	Service-Info-Status-AVP
	The Service-Info-Status AVP (AVP code 527) is of type Enumerated, and indicates the status of the service information that the AF is providing to the PCRF. If the Service-Info-Status AVP is not provided in the AA request, the value FINAL SERVICE INFORMATION shall be assumed.

	FINAL SERVICE INFORMATION (0)
		This value is used to indicate that the service has been fully negotiated between the two ends and service information provided is the result of that negotiation.

	PRELIMINARY SERVICE INFORMATION (1)
		This value is used to indicate that the service information that the AF has provided to the PCRF is preliminary and needs to be further negotiated between the two ends (e.g. for IMS when the service information is sent based on the SDP offer).
 */
public enum ServiceInfoStatusEnum implements IntegerEnum
{
	FINAL_SERVICE_INFORMATION(0),PRELIMINARY_SERVICE_INFORMATION(1);

	private static final Map<Integer, ServiceInfoStatusEnum> intToTypeMap = new HashMap<Integer, ServiceInfoStatusEnum>();
	static
	{
	    for (ServiceInfoStatusEnum type : ServiceInfoStatusEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static ServiceInfoStatusEnum fromInt(Integer value) 
	{
		ServiceInfoStatusEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private ServiceInfoStatusEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
