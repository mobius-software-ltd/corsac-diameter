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
 * 8.13.  Credit-Control AVP

   The Credit-Control AVP (AVP Code 426) is of type Enumerated and MUST
   be included in AA-Request messages when the Service Element has
   credit-control capabilities.  The following values are defined for
   the Credit-Control AVP:

   CREDIT_AUTHORIZATION   0

   If the home Diameter AAA server determines that the user has a
   prepaid subscription, this value indicates that the credit-control
   server MUST be contacted to perform the first interrogation.  The
   value of the Credit-Control AVP MUST always be set to 0 in an
   AA-Request sent to perform the first interrogation and to initiate a
   new credit-control session.

   RE_AUTHORIZATION       1

   This value indicates to the Diameter AAA server that a credit-control
   session is ongoing for the subscriber and that the credit-control
   server MUST NOT be contacted.  The Credit-Control AVP set to the
   value of 1 is to be used only when the first interrogation has been
   successfully performed and the credit-control session is ongoing
   
   (i.e., re-authorization triggered by authorization lifetime).  This
   value MUST NOT be used in an AA-Request sent to perform the first
   interrogation.
 */
public enum CreditControlEnum implements IntegerEnum
{
	CREDIT_AUTHORIZATION(0),RE_AUTHORIZATION(1);

	private static final Map<Integer, CreditControlEnum> intToTypeMap = new HashMap<Integer, CreditControlEnum>();
	static 
	{
	    for (CreditControlEnum type : CreditControlEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static CreditControlEnum fromInt(Integer value) 
	{
		CreditControlEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private CreditControlEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
