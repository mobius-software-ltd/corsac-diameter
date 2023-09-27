package com.mobius.software.telco.protocols.diameter.primitives.accounting;

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
 * 	7.2.238A UNI-PDU-CP-Only-Flag AVP
	The UNI-PDU-CP-Only-Flag AVP (AVP code 3932) is of type Enumerated, and indicates whether this PDN
	connection is applied with "Control Plane Only flag", i.e. using only S11-U from S-GW when Control Plane CIoT EPS
	Optimization is enabled. If this AVP is not present, this means both user plane and control plane can be used in UNI for
	PDU transfer, i.e. S1-U and S11-U respectively from S-GW, when Control Plane CIoT EPS Optimization is enabled.
	The following values are defined:

	0 UNI-PDU-both-UP-CP
	1 UNI-PDU-CP-Only
 */
public enum UNIPDUCPOnlyFlagEnum implements IntegerEnum
{
	BOTH_UP_CP(0),CP_ONLY(1);

	private static final Map<Integer, UNIPDUCPOnlyFlagEnum> intToTypeMap = new HashMap<Integer, UNIPDUCPOnlyFlagEnum>();
	static 
	{
	    for (UNIPDUCPOnlyFlagEnum type : UNIPDUCPOnlyFlagEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static UNIPDUCPOnlyFlagEnum fromInt(Integer value) 
	{
		UNIPDUCPOnlyFlagEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private UNIPDUCPOnlyFlagEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
