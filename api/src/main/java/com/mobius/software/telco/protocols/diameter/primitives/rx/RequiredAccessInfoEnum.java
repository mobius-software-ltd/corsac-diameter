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
 * 	5.3.34	Required-Access-Info AVP
	The Required-Access-Info AVP (AVP code 536) is of type Enumerated, and contains the access network information required for that AF session.
	The following values are defined:

	USER_LOCATION (0)
		Indicates that the user location information shall be reported, the PCRF shall report the user location information within the 3GPP-User-Location-Info AVP (if available), the serving network identifier containing PLMN identifier within the 3GPP-SGSN-MCC-MNC AVP (if available) and NID AVP (if available), the user location information within the TWAN-Identifier (if available) , UE-Local-IP-Address AVP (if available) , UDP-Source-Port AVP (if available), TCP-Source-Port AVP (if available) and User-Location-Info-Time AVP (if available).
		The NID AVP is only applicable in 5GS when the serving network is an SNPN, as described in Annex E.

	MS_TIME_ZONE (1)
		Indicates that the user timezone information shall be reported, the PCRF shall report the user timezone information within the 3GPP-MS-TimeZone AVP.
 */
public enum RequiredAccessInfoEnum implements IntegerEnum
{
	USER_LOCATION(0),MS_TIME_ZONE(1);

	private static final Map<Integer, RequiredAccessInfoEnum> intToTypeMap = new HashMap<Integer, RequiredAccessInfoEnum>();
	static
	{
	    for (RequiredAccessInfoEnum type : RequiredAccessInfoEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static RequiredAccessInfoEnum fromInt(Integer value) 
	{
		RequiredAccessInfoEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private RequiredAccessInfoEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
