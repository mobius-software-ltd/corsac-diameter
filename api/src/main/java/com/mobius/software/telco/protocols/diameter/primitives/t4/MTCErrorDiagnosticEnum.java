package com.mobius.software.telco.protocols.diameter.primitives.t4;

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
 * 	6.3.7	MTC-Error-Diagnostic
	The MTC-Error-Diagnostic AVP is of type Unsigned32. The following values are defined:

	-	ORIGINAL_MESSAGE_NOT_DELETED (0)
	This cause should be sent if the replace failed due to the fact that the old message is pending but could not be deleted in the SMS-SC.

	-	NEW_MESSAGE_NOT_STORED (1)
	This cause should be sent if the replace failed due to the fact that the new message could not be stored in the SMS-SC e.g. no resource available.
 */
public enum MTCErrorDiagnosticEnum implements IntegerEnum
{
	ORIGINAL_MESSAGE_NOT_DELETED(0),NEW_MESSAGE_NOT_STORED(1);

	private static final Map<Integer, MTCErrorDiagnosticEnum> intToTypeMap = new HashMap<Integer, MTCErrorDiagnosticEnum>();
	static
	{
	    for (MTCErrorDiagnosticEnum type : MTCErrorDiagnosticEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static MTCErrorDiagnosticEnum fromInt(Integer value) 
	{
		MTCErrorDiagnosticEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private MTCErrorDiagnosticEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
