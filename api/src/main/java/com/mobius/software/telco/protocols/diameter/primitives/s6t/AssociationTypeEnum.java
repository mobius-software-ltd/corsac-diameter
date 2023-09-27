package com.mobius.software.telco.protocols.diameter.primitives.s6t;

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
 * 	8.4.18	Association-Type
	The Association-Type AVP is of type Unsigned32. It shall indicate the details of the event configuration related to the change of IMEI(SV)-IMSI association. The following values are defined:

	IMEI-CHANGE (0)
	The event shall be reported if the association between IMSI and IMEI has changed; if only the Software Version (SV) has changed, no event shall be reported.

	IMEISV-CHANGE (1)
	The event shall be reported if the association between IMSI and IMEI, or SV, or both, has changed (this includes the case where only the SV has changed).
 */
public enum AssociationTypeEnum implements IntegerEnum
{
	IMEI_CHANGE(0),IMEISV_CHANGE(1);

	private static final Map<Integer, AssociationTypeEnum> intToTypeMap = new HashMap<Integer, AssociationTypeEnum>();
	static
	{
	    for (AssociationTypeEnum type : AssociationTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static AssociationTypeEnum fromInt(Integer value) 
	{
		AssociationTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private AssociationTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
