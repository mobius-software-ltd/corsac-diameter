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
 * 	5.3.100 AN-GW-Status AVP (3GPP-EPS access type)
	The AN-GW-Status AVP (AVP code 2811) is of type Enumerated. It is sent from the PCEF to the PCRF to indicate the
	status of the SGW.
	The following values are defined:

	AN_GW_FAILED (0)
 		This value indicates that the AN-Gateway has failed and that the PCRF should refrain from sending policy
		decisions to the PCEF until it is informed that the AN-Gateway has been recovered. This value shall not be used
		if the IP-CAN Session Modification procedure is initiated for PCC rule removal only. 
 */
public enum ANGWStatusEnum implements IntegerEnum
{
	AN_GW_FAILED(0);

	private static final Map<Integer, ANGWStatusEnum> intToTypeMap = new HashMap<Integer, ANGWStatusEnum>();
	static
	{
	    for (ANGWStatusEnum type : ANGWStatusEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static ANGWStatusEnum fromInt(Integer value) 
	{
		ANGWStatusEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private ANGWStatusEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
