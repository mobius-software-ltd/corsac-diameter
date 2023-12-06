package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei;

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
 * 	3.2.266  SDP-Media-Identifier AVP
	
	AVP Name
	SDP-Media-Identifier

	AVP Code
	20820

	AVP Data Type
	Enumerated

	Vendor ID
	2011

	Description
	Indicates the ID of a multimedia service.

	The SDP-Media-Identifier AVP contains the following values:
	    - 0: VoiceCall
	    - 1: VideoCall
	    - 2: Fax
 */
public enum SDPMediaIdentifierEnum implements IntegerEnum
{
	VOICE(0),VIDEO(1),FAX(2);

	private static final Map<Integer, SDPMediaIdentifierEnum> intToTypeMap = new HashMap<Integer, SDPMediaIdentifierEnum>();
	static 
	{
	    for (SDPMediaIdentifierEnum type : SDPMediaIdentifierEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static SDPMediaIdentifierEnum fromInt(Integer value) 
	{
		SDPMediaIdentifierEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private SDPMediaIdentifierEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
