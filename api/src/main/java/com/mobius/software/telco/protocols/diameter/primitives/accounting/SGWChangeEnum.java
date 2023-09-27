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
 * 	7.2.200 SGW-Change AVP
	The SGW-Change AVP (AVP Code 2065) is of type Enumerated, and indicates this is the first ACR[Start] due to an
	inter serving node change (change from SGW, ePDG, TWAG, HSGW). If this AVP is not present, this means this
	ACR[Start] is not due to an inter serving node change.
	The following values are defined:
	
	0 ACR_Start_NOT_due_to_SGW_Change
	1 ACR_Start_due_to_SGW_Change
 */
public enum SGWChangeEnum implements IntegerEnum
{
	NOT_DUE_TO_SGW_CHANGE(0),DUE_TO_SGW_CHANGE(1);

	private static final Map<Integer, SGWChangeEnum> intToTypeMap = new HashMap<Integer, SGWChangeEnum>();
	static 
	{
	    for (SGWChangeEnum type : SGWChangeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static SGWChangeEnum fromInt(Integer value) 
	{
		SGWChangeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private SGWChangeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
