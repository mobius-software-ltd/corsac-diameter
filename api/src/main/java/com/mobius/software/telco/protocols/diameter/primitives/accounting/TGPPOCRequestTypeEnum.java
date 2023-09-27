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
 * 	B.2.2	3GPP-OC-Request-Type AVP
	The OC-Request-Type AVP (AVP code 1322), is of type Enumerated. It contains the CC-Request-Type (defined in IETF RFC 4006 [402]) that the overload control be applied to, i.e. which types of request that should be restricted. It has the following values:

	1	INITIAL_REQUEST
	2	UPDATE_REQUEST
	3	TERMINATION_REQUEST
	4	EVENT_REQUEST
 */
public enum TGPPOCRequestTypeEnum implements IntegerEnum
{
	INITIAL_REQUEST(1),UPDATE_REQUEST(2),TERMINATION_REQUEST(3),EVENT_REQUEST(4);

	private static final Map<Integer, TGPPOCRequestTypeEnum> intToTypeMap = new HashMap<Integer, TGPPOCRequestTypeEnum>();
	static 
	{
	    for (TGPPOCRequestTypeEnum type : TGPPOCRequestTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static TGPPOCRequestTypeEnum fromInt(Integer value) 
	{
		TGPPOCRequestTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private TGPPOCRequestTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
