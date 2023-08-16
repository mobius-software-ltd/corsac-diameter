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
 * 	5.3.12 Reporting-Level AVP (All access types)
	The Reporting-Level AVP (AVP code 1011) is of type Enumerated, and it defines on what level the PCEF reports the
	usage for the related PCC rule. The following values are defined:

	SERVICE_IDENTIFIER_LEVEL (0)
		This value shall be used to indicate that the usage shall be reported on service id and rating group combination
		level, and is applicable when the Service-Identifier and Rating-Group have been provisioned within the
		Charging-Rule-Definition AVP.
	RATING_GROUP_LEVEL (1)
 		This value shall be used to indicate that the usage shall be reported on rating group level, and is applicable when
		the Rating-Group has been provisioned within the Charging-Rule-Definition AVP.
	SPONSORED_CONNECTIVITY_LEVEL (2)
		This value shall be used to indicate that the usage shall be reported on sponsor identity and rating group
		combination level, and is applicable when the Sponsor-IdentityAVP, Application-Service-Provider-Identity AVP
		and Rating-Group AVP have been provisioned within the Charging-Rule-Definition AVP. Applicable for offline
		charging.
		If the Reporting-Level AVP is omitted but has been supplied previously, the previous information remains valid. If the
		Reporting-Level AVP is omitted and has not been supplied previously, the reporting level pre-configured at the PCEF is
		applicable as default reporting level. 
 */
public enum ReportingLevelEnum implements IntegerEnum
{
	SERVICE_IDENTIFIER_LEVEL(0),RATING_GROUP_LEVEL(1),SPONSORED_CONNECTIVITY_LEVEL(2);

	private static final Map<Integer, ReportingLevelEnum> intToTypeMap = new HashMap<Integer, ReportingLevelEnum>();
	static
	{
	    for (ReportingLevelEnum type : ReportingLevelEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static ReportingLevelEnum fromInt(Integer value) 
	{
		ReportingLevelEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private ReportingLevelEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
