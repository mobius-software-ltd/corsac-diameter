package com.mobius.software.telco.protocols.diameter.primitives.sgd;

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
 * 	6.3.3.6	SM-Enumerated-Delivery-Failure-Cause
	The SM-Enumerated-Delivery-Failure-Cause AVP is of type enumerated and it shall contain the cause of the failure of a SM delivery. The following values are defined:

	MEMORY_CAPACITY_EXCEEDED  (0),

	EQUIPMENT_PROTOCOL_ERROR  (1),

	EQUIPMENT_NOT_SM-EQUIPPED  (2),

	UNKNOWN_SERVICE_CENTRE  (3),

	SC-CONGESTION  (4),

	INVALID_SME-ADDRESS  (5),

	USER_NOT_SC-USER  (6).

	NOTE:	The values of the SM- Enumerated-Delivery-Failure-Cause AVP correspond to the ones for the SM-EnumeratedDeliveryFailureCause parameter in MAP as described in 3GPP TS 29.002[9].  
 */
public enum SMEnumeratedDeliveryFailureCauseEnum implements IntegerEnum
{
	MEMORY_CAPACITY_EXCEEDED(0),EQUIPMENT_PROTOCOL_ERROR(1),EQUIPMENT_NOT_SM_EQUIPPED(2),UNKNOWN_SERVICE_CENTRE(3),SC_CONGESTION(4),INVALID_SME_ADDRESS(5),USER_NOT_SC_USER(6);

	private static final Map<Integer, SMEnumeratedDeliveryFailureCauseEnum> intToTypeMap = new HashMap<Integer, SMEnumeratedDeliveryFailureCauseEnum>();
	static
	{
	    for (SMEnumeratedDeliveryFailureCauseEnum type : SMEnumeratedDeliveryFailureCauseEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static SMEnumeratedDeliveryFailureCauseEnum fromInt(Integer value) 
	{
		SMEnumeratedDeliveryFailureCauseEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private SMEnumeratedDeliveryFailureCauseEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
