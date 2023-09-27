package com.mobius.software.telco.protocols.diameter.primitives.np;

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
 * 	5.3.13	Reporting-Restriction AVP
	The Reporting-Restriction AVP (AVP code 4011) is of type Unsigned32, and it is used to indicate the applicable reporting restrictions between the PCRF and RCAF. If this AVP is not provided during the initial reporting restriction provisioning, it shall be understood as unconditional reporting restrictions apply.
	The following values are defined:

	0 (No reporting restriction):
	This value shall be used by the PCRF to indicate to the RCAF that there are no restrictions on congestion reporting for a specific user id and PDN ID. This value shall not be used if congestion level definitions are included in the same command.

	1 (Conditional reporting restriction):
	This value shall be used by the PCRF to indicate to the RCAF that there are conditional restrictions on congestion reporting for a specific user id and PDN ID.

	2 (Unconditional reporting restriction):
	This value shall be used by the PCRF to indicate to the RCAF that there are unconditional restrictions on congestion reporting for a specific user id and PDN ID.
 */
public enum ReportingRestrictionEnum implements IntegerEnum
{
	NO_REPORTING_RESTRICTION(0),CONDITIONAL_REPORTING_RESTRICTION(1),UNCONDITIONAL_REPORTING_RESTRICTION(2);

	private static final Map<Integer, ReportingRestrictionEnum> intToTypeMap = new HashMap<Integer, ReportingRestrictionEnum>();
	static
	{
	    for (ReportingRestrictionEnum type : ReportingRestrictionEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static ReportingRestrictionEnum fromInt(Integer value) 
	{
		ReportingRestrictionEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private ReportingRestrictionEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
