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
 * 	5.3.48	Media-Component-Status AVP 
	The Media-Component-Status AVP (AVP code 549) is of type Unsigned32, and it describes the status of the PCC/QoS rule(s) related to a media component.
	The following values are defined in this specification:

	0 (ACTIVE):
		This value shall be used to indicate that the PCC/QoS rule(s) related to certain media component are active.

	1 (INACTIVE):
		This value shall be used to indicate that the PCC/QoS rule(s) related to certain media component are inactive. This is the default value applicable if this AVP is not supplied.

	NOTE:	It is assumed that the AF considers the PCC/QoS rule(s) related to the media component(s) for which the Media-Component-Status AVP(s) are not received as inactive when the Specific-Action AVP set to INDICATION_OF_FAILED_RESOURCES_ALLOCATION (9) is received.
 */
public enum MediaComponentStatusEnum implements IntegerEnum
{
	ACTIVE(0),INACTIVE(1);

	private static final Map<Integer, MediaComponentStatusEnum> intToTypeMap = new HashMap<Integer, MediaComponentStatusEnum>();
	static
	{
	    for (MediaComponentStatusEnum type : MediaComponentStatusEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static MediaComponentStatusEnum fromInt(Integer value) 
	{
		MediaComponentStatusEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private MediaComponentStatusEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
