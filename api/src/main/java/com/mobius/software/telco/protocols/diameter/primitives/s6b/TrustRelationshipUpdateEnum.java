package com.mobius.software.telco.protocols.diameter.primitives.s6b;

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
 * 	9.2.3.1.4 Trust-Relationship-Update
	The Trust-Relationship-Update AVP is of type Enumerated. It contains an indicator that the correpsonding procedure is
	only used for the 3GPP AAA Server to send the trust relationship to the PDN GW, and the PDN GW shall not perform
	any authorization procedure towards the UE. The Vendor-Id shall be set to 10415 (3GPP). The following values are
	defined:

	REQUEST_UPDATE (1)
	
	Any other values not defined above are equivalent to this AVP not being present.  
 */
public enum TrustRelationshipUpdateEnum implements IntegerEnum
{
	REQUEST_UPDATE(1);

	private static final Map<Integer, TrustRelationshipUpdateEnum> intToTypeMap = new HashMap<Integer, TrustRelationshipUpdateEnum>();
	static
	{
	    for (TrustRelationshipUpdateEnum type : TrustRelationshipUpdateEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static TrustRelationshipUpdateEnum fromInt(Integer value) 
	{
		TrustRelationshipUpdateEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private TrustRelationshipUpdateEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
