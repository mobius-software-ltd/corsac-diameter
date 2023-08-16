package com.mobius.software.telco.protocols.diameter.primitives.gx;

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
 * 	5.3.140 UE-Status AVP (3GPP-EPS access type)
	The UE-Status AVP (AVP code 2854) is of type Unsigned32. It is sent from the PCEF to the PCRF to indicate the
	status of the UE.
	The following values are defined in this specification:

	1 (UE status suspend)
	 	This value indicates that the policy enforcement has failed because the UE is in suspend status, and that the
		PCRF should refrain from sending policy decisions to the PCEF until it is informed that the UE has been
		resumed. This value shall not be used if the IP-CAN Session Modification procedure is initiated for PCC rule
		removal only. 
 */
public enum UEStatusEnum implements IntegerEnum
{
	UE_STATUS_SUSPEND(0);

	private static final Map<Integer, UEStatusEnum> intToTypeMap = new HashMap<Integer, UEStatusEnum>();
	static
	{
	    for (UEStatusEnum type : UEStatusEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static UEStatusEnum fromInt(Integer value) 
	{
		UEStatusEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private UEStatusEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
