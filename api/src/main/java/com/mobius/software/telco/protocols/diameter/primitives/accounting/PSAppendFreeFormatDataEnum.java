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
 * 	7.2.155 PS-Append-Free-Format-Data AVP
	The PS-Append-Free-Format-Data AVP (AVP code 867) is of type enumerated and indicates if the information sent in
	the PS-Free-Format-Data AVP shall be appended to the PS-free-format-data stored for the online-session. The
	following values are defined:

	0 'Append'

	If this AVP is present and indicates 'Append', the P-GW shall append the received PS free format data to the PS
	free format data stored for the online charging session.

	1 'Overwrite'

	If this AVP is absent or in value 'Overwrite', the P-GW shall overwrite all PS free format data already stored for
	the online charging session.
	The P-GW shall ignore this AVP if no PS free format data is stored for the online charging session.
 */
public enum PSAppendFreeFormatDataEnum implements IntegerEnum
{
	APPEND(0),OVERWRITE(1);

	private static final Map<Integer, PSAppendFreeFormatDataEnum> intToTypeMap = new HashMap<Integer, PSAppendFreeFormatDataEnum>();
	static 
	{
	    for (PSAppendFreeFormatDataEnum type : PSAppendFreeFormatDataEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static PSAppendFreeFormatDataEnum fromInt(Integer value) 
	{
		PSAppendFreeFormatDataEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private PSAppendFreeFormatDataEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
