package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol;

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
 * 8.40.  Multiple-Services-Indicator AVP

   The Multiple-Services-Indicator AVP (AVP Code 455) is of type
   Enumerated and indicates whether the Diameter Credit-Control client
   is capable of handling multiple services independently within a
   (sub-)session.  The absence of this AVP means that independent
   credit-control of multiple services is not supported.

   A server not implementing the independent credit-control of multiple
   services MUST treat the Multiple-Services-Indicator AVP as an
   invalid AVP.

   The following values are defined for the Multiple-Services-Indicator
   AVP:

   MULTIPLE_SERVICES_NOT_SUPPORTED   0

   The client does not support independent credit-control of multiple
   services within a (sub-)session.

   MULTIPLE_SERVICES_SUPPORTED       1

   The client supports independent credit-control of multiple services
   within a (sub-)session.
 */
public enum MultipleServicesIndicatorEnum implements IntegerEnum
{
	MULTIPLE_SERVICES_NOT_SUPPORTED(0),MULTIPLE_SERVICES_SUPPORTED(1);

	private static final Map<Integer, MultipleServicesIndicatorEnum> intToTypeMap = new HashMap<Integer, MultipleServicesIndicatorEnum>();
	static 
	{
	    for (MultipleServicesIndicatorEnum type : MultipleServicesIndicatorEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static MultipleServicesIndicatorEnum fromInt(Integer value) 
	{
		MultipleServicesIndicatorEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private MultipleServicesIndicatorEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
