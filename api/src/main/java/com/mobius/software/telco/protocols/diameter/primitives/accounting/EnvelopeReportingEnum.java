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
 * 	7.2.61 Envelope-Reporting AVP
	This Envelope-Reporting AVP (AVP code 1268) is of type Enumerated and is used in the CCA[INITIAL] to indicate
	whether the client shall report the start and end of each time envelope, in those cases in which quota is consumed in
	envelopes. It can take the values:

	0 DO_NOT_REPORT_ENVELOPES
	1 REPORT_ENVELOPES
	2 REPORT_ENVELOPES_WITH_VOLUME
	3 REPORT_ENVELOPES_WITH_EVENTS
	4 REPORT_ENVELOPES_WITH_VOLUME_AND_EVENTS

	If this AVP is not included in the CCA[Initial] then the client shall not report the individual envelopes.
	If this AVP is included within the Offline-Charging AVP, the value shall dictate the mechanism by which offline
	charging information is generated. 
 */
public enum EnvelopeReportingEnum implements IntegerEnum
{
	DO_NOT_REPORT_ENVELOPES(0),REPORT_ENVELOPES(1),REPORT_ENVELOPES_WITH_VOLUME(2),REPORT_ENVELOPES_WITH_EVENTS(3),REPORT_ENVELOPES_WITH_VOLUME_AND_EVENTS(4);

	private static final Map<Integer, EnvelopeReportingEnum> intToTypeMap = new HashMap<Integer, EnvelopeReportingEnum>();
	static 
	{
	    for (EnvelopeReportingEnum type : EnvelopeReportingEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static EnvelopeReportingEnum fromInt(Integer value) 
	{
		EnvelopeReportingEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private EnvelopeReportingEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
