package com.mobius.software.telco.protocols.diameter.primitives.rfc7683;

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
 * 7.6.  OC-Report-Type AVP

   The OC-Report-Type AVP (AVP Code 626) is of type Enumerated.  The
   value of the AVP describes what the overload report concerns.  The
   following values are initially defined:

   HOST_REPORT 0
      The overload report is for a host.  Overload abatement treatment
      applies to host-routed requests.

   REALM_REPORT 1
      The overload report is for a realm.  Overload abatement treatment
      applies to realm-routed requests.

   The values 2-4294967295 are unassigned.
 */
public enum OCReportTypeEnum implements IntegerEnum
{
	HOST_REPORT(0),REALM_REPORT(1);

	private static final Map<Integer, OCReportTypeEnum> intToTypeMap = new HashMap<Integer, OCReportTypeEnum>();
	static
	{
	    for (OCReportTypeEnum type : OCReportTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static OCReportTypeEnum fromInt(Integer value) 
	{
		OCReportTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private OCReportTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
