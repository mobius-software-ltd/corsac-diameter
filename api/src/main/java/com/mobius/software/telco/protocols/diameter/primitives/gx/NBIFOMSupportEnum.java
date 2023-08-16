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
 * 	5.3.116 NBIFOM-Support AVP
	The NBIFOM-Support AVP (AVP code 2831) is of type of Enumerated. When the AVP is sent from the PCEF to the
	PCRF in the initial CCR command, it indicates that the UE and network support the NBIFOM procedures as defined in
	3GPP TS 23.161 [51].When the AVP is sent from the PCRF to the PCEF in the initial CCA command, it indicates
	whether the PCRF authorizes that the NBIFOM can be applied to the IP-CAN session.
	The following value is defined:

	NBIFOM_NOT_SUPPORTED (0)
 		This value is used to indicate that the PCRF does not authorize that the NBIFOM can be applied to the IP-CAN
		session.
	NBIFOM_SUPPORTED (1)
 		When included in a CCR command, this value is used to indicate that the UE and the access network support the
		NBIFOM procedures. When included in a CCAcommand, this value is used to indicate that the PCRF authorizes
		that NBIFOM can be applied to the IP-CAN session.
		Absence of this AVP in the initial CCR command means that the NBIFOM procedures are not supported by the UE
		and/or network. 
 */
public enum NBIFOMSupportEnum implements IntegerEnum
{
	NBIFOM_NOT_SUPPORTED(0),NBIFOM_SUPPORTED(1);

	private static final Map<Integer, NBIFOMSupportEnum> intToTypeMap = new HashMap<Integer, NBIFOMSupportEnum>();
	static
	{
	    for (NBIFOMSupportEnum type : NBIFOMSupportEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static NBIFOMSupportEnum fromInt(Integer value) 
	{
		NBIFOMSupportEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private NBIFOMSupportEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
