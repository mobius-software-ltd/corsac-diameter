package com.mobius.software.telco.protocols.diameter.primitives.gmb;

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
 * 	17.7.17	MBMS-Counting-Information AVP
	The MBMS-Counting-Information AVP (AVP code 914) is of type Enumerated, and contains explicit information about whether the MBMS Counting procedures are applicable for the MBMS Service that is about to start. See 3GPP TS 25.346 [72].
	This AVP is only valid for UTRAN access type.
	
	The following values are supported:

	COUNTING-NOT-APPLICABLE (0)
	The MBMS Session Start Procedure signalled by the BM-SC is for a MBMS Service where MBMS Counting procedures are not applicable.

	COUNTING-APPLICABLE (1)
	The MBMS Session Start Procedure signalled by the BM-SC is for a MBMS Service where MBMS Counting procedures are applicable.
 */
public enum MBMSCountingInformationEnum implements IntegerEnum
{
	COUNTING_NOT_APPLICABLE(0),COUNTING_APPLICABLE(1);

	private static final Map<Integer, MBMSCountingInformationEnum> intToTypeMap = new HashMap<Integer, MBMSCountingInformationEnum>();
	static
	{
	    for (MBMSCountingInformationEnum type : MBMSCountingInformationEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static MBMSCountingInformationEnum fromInt(Integer value) 
	{
		MBMSCountingInformationEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private MBMSCountingInformationEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
