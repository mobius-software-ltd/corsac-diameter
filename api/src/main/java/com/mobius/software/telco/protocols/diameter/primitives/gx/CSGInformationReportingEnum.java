package com.mobius.software.telco.protocols.diameter.primitives.gx;

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
 * 	5.3.64 CSG-Information-Reporting AVP
	The CSG-Information-Reporting AVP (AVP code 1071) is of type Enumerated, it is sent from the PCRF to the PCEF to
	request the PCEF to report the user CSG information change to the OFCS. The following values are defined:

	CHANGE_CSG_CELL (0)
 		This value indicates that the PCEF reports the user CSG information change to the OFCS when the UE
		enters/leaves/accesses via a CSG cell.
	CHANGE_CSG_SUBSCRIBED_HYBRID_CELL (1)
 		This value indicates that the PCEF reports the user CSG information change to the OFCS when the UE
		enters/leaves/accesses via a hybrid cell in which the subscriber is a CSG member.
	CHANGE_CSG_UNSUBSCRIBED_HYBRID_CELL (2)
 		This value indicates that the PCEF reports the user CSG information change to the OFCS when the UE
		enters/leaves/accesses via a hybrid cell in which the subscriber is not a CSG member.
		NOTE: Due to the increased signalling load, it is recommended that such reporting applied for a limited number
		of subscribers only
 */
public enum CSGInformationReportingEnum implements IntegerEnum
{
	CHANGE_CSG_CELL(0),CHANGE_CSG_SUBSCRIBED_HYBRID_CELL(1),CHANGE_CSG_UNSUBSCRIBED_HYBRID_CELL(2),;

	private static final Map<Integer, CSGInformationReportingEnum> intToTypeMap = new HashMap<Integer, CSGInformationReportingEnum>();
	static
	{
	    for (CSGInformationReportingEnum type : CSGInformationReportingEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static CSGInformationReportingEnum fromInt(Integer value) 
	{
		CSGInformationReportingEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private CSGInformationReportingEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
