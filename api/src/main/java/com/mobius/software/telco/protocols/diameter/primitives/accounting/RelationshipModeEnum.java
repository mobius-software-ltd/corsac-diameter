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
 * 	7.2.171A Relationship-Mode AVP
	The Relationship-Mode AVP (AVP code 2706) is of type Enumerated and indicates whether the other functional entity
	(e.g. contact point of the neighbouring network) is regarded as part of the same trust domain. It has the following
	values:
	
	0 trusted
	1 non-trusted 
 */
public enum RelationshipModeEnum implements IntegerEnum
{
	TRUSTED(0),NON_TRUSTED(1);

	private static final Map<Integer, RelationshipModeEnum> intToTypeMap = new HashMap<Integer, RelationshipModeEnum>();
	static 
	{
	    for (RelationshipModeEnum type : RelationshipModeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static RelationshipModeEnum fromInt(Integer value) 
	{
		RelationshipModeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private RelationshipModeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
