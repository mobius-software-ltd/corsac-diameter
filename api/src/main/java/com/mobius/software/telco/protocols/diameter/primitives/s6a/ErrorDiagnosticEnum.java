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
 * 	7.3.128	Error-Diagnostic
	The Error-Diagnostic AVP is of type Enumerated. The following values are defined:

	-	GPRS_DATA_SUBSCRIBED (0)
	This value shall be used when Experimental-Error is DIAMETER_ERROR_UNKNOWN_EPS_SUBSCRIPTION and there is GPRS Subscription Data for the user.

	-	NO_GPRS_DATA_SUBSCRIBED (1)
	This value shall be used when Experimental-Error is DIAMETER_ERROR_UNKNOWN_EPS_SUBSCRIPTION and there is not GPRS Subscription Data for the user.

	-	ODB_ALL_APN (2)
	This value shall be used when Experimental-Error is DIAMETER_ERROR_ROAMING_NOT_ALLOWED and the Operator Determined Barring indicates "All Packet Oriented Services Barred" (see clause 7.3.30).

	-	ODB_HPLMN_APN (3)
	This value shall be used when Experimental-Error is DIAMETER_ERROR_ROAMING_NOT_ALLOWED and the Operator Determined Barring indicates "Roamer Access HPLMN-AP Barred" (see clause 7.3.30).
	
	-	ODB_VPLMN_APN (4)
	This value shall be used when Experimental-Error is DIAMETER_ERROR_ROAMING_NOT_ALLOWED and the Operator Determined Barring indicates "Roamer Access to VPLMN-AP Barred" (see clause 7.3.30).
 */
public enum ErrorDiagnosticEnum implements IntegerEnum
{
	GPRS_DATA_SUBSCRIBED(0),NO_GPRS_DATA_SUBSCRIBED(1),ODB_ALL_APN(2),ODB_HPLMN_APN(3),ODB_VPLMN_APN(4);

	private static final Map<Integer, ErrorDiagnosticEnum> intToTypeMap = new HashMap<Integer, ErrorDiagnosticEnum>();
	static
	{
	    for (ErrorDiagnosticEnum type : ErrorDiagnosticEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static ErrorDiagnosticEnum fromInt(Integer value) 
	{
		ErrorDiagnosticEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private ErrorDiagnosticEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
