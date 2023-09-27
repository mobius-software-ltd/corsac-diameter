package com.mobius.software.telco.protocols.diameter.primitives.pc2;

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
 * 	6.4.18	Metadata-Indicator AVP
	The Metadata-Indicator AVP (AVP code 3612) is of type Unsigned32, and contains the options for metadata associated with a particular target RPAUID. The following values are defined:

	0 (NO_METADATA):
	This value may be used to indicate that there is no metadata associated with the target RPAUID. This is the default value applicable if this AVP is not supplied.

	1 (METADATA_UPDATE_DISALLOWED):
	This value shall be used to indicate that there exists metadata associated with the target RPAUID, but the metadata is not allowed to be updated.

	2 (METADATA_UPDATE_ALLOWED):
	This value shall be used to indicate that there exists metadata associated with the target RPAUID, and the metadata is allowed to be updated.  
 */
public enum MetadataIndicatorEnum implements IntegerEnum
{
	NO_METADATA(0),METADATA_UPDATE_DISALLOWED(1),METADATA_UPDATE_ALLOWED(2);

	private static final Map<Integer, MetadataIndicatorEnum> intToTypeMap = new HashMap<Integer, MetadataIndicatorEnum>();
	static
	{
	    for (MetadataIndicatorEnum type : MetadataIndicatorEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static MetadataIndicatorEnum fromInt(Integer value) 
	{
		MetadataIndicatorEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private MetadataIndicatorEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
