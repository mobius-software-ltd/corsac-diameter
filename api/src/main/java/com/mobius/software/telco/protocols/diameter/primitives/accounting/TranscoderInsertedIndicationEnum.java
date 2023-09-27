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
 * 	7.2.233A Transcoder-Inserted-Indication AVP
	The Transcoder-Inserted-Indication AVP (AVP code 2605) is of type Enumerated and indicates if a transcoder is
	inserted or not for the SDP media component. The following values are defined:
	
	0 Transcoder Not Inserted
	1 Transcoder Inserted 
 */
public enum TranscoderInsertedIndicationEnum implements IntegerEnum
{
	NOT_INSERTED(0),INSERTED(1);

	private static final Map<Integer, TranscoderInsertedIndicationEnum> intToTypeMap = new HashMap<Integer, TranscoderInsertedIndicationEnum>();
	static 
	{
	    for (TranscoderInsertedIndicationEnum type : TranscoderInsertedIndicationEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static TranscoderInsertedIndicationEnum fromInt(Integer value) 
	{
		TranscoderInsertedIndicationEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private TranscoderInsertedIndicationEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
