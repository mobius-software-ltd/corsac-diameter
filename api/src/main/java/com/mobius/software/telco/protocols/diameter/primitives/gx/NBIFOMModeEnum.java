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
 * 	5.3.117 NBIFOM-Mode AVP
	The NBIFOM-Mode AVP (AVP code 2830) is of type of Enumerated. When the AVP is sent from the PCEF to the
	PCRF in the initial CCR command, it indicates the NBIFOM mode suggested by the UE. When the AVP is sent from
	the PCRF to the PCEF in the CCA command, it indicates the NBIFOM mode selected by the PCRF.
	The following value is defined:

	UE_INITIATED (0)
 		IP flow mobility can be initiated by the UE.
	NETWORK_INITIATED (1)
 		IP flow mobility can be initiated by the network.
 */
public enum NBIFOMModeEnum implements IntegerEnum
{
	UE_INITIATED(0),NETWORK_INITIATED(1);

	private static final Map<Integer, NBIFOMModeEnum> intToTypeMap = new HashMap<Integer, NBIFOMModeEnum>();
	static
	{
	    for (NBIFOMModeEnum type : NBIFOMModeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static NBIFOMModeEnum fromInt(Integer value) 
	{
		NBIFOMModeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private NBIFOMModeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
