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
 * 	5.3.110 Presence-Reporting-Area-Status AVP (3GPP-EPS access type)
	The Presence-Reporting-Area-Status AVP (AVP code 2823) is of type Unsigned32, and it indicates whether the UE is
	inside or outside of the presence reporting area.
	The following values are defined in this specification:

	0 (In area):
 		This value shall be used to indicate that the UE is inside or enters the presence reporting area.
	1 (Out of area):
 		This value shall be used to indicate that the UE is outside or leaves the presence reporting area.
	2 (Inactive)
 		This value shall be used to indicate that the presence reporting area is inactive in the serving node. 
 */
public enum PresenceReportingAreaStatusEnum implements IntegerEnum
{
	IN_AREA(0),OUT_OF_AREA(1),INACTIVE(2);

	private static final Map<Integer, PresenceReportingAreaStatusEnum> intToTypeMap = new HashMap<Integer, PresenceReportingAreaStatusEnum>();
	static
	{
	    for (PresenceReportingAreaStatusEnum type : PresenceReportingAreaStatusEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static PresenceReportingAreaStatusEnum fromInt(Integer value) 
	{
		PresenceReportingAreaStatusEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private PresenceReportingAreaStatusEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
