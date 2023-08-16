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
 * 	5.3.119 Routing-Rule-Failure-Code AVP
	The Routing-Rule-Failure-Code AVP (AVP code 2834) is of type Unsigned32. It is sent by the PCRF to the PCEF
	within a Routing-Rule-Report AVP to identify the reason a NBIFOM routing rule is being reported.
	The following values are defined in this specification:

	0 (Subscription limitation):
 		This value shall be used to indicate that the NBIFOM routing rule cannot be installed or modified due to the
		subscription limitation.
	1 (Operator policy):
 		This value shall be used to indicate that the NBIFOM routing rule cannot be installed or modified due to the
		operator policy.
	2 (Resource limitation):
 		This value shall be used to indicate that the NBIFOM routing rule cannot be installed or modified due to the
		resource limitation.
	3 (Routing access information not allowed):
 		This value shall be used to indicate that the NBIFOM routing rule cannot be installed or modified due to the
		routing access information is not allowed by the network.
	4 (Unspecified error):
 		This value shall be used to indicate that the NBIFOM routing rule cannot be installed or modified due to the
		unspecified error.
 */
public enum RoutingRuleFailureCodeEnum implements IntegerEnum
{
	SUBSCRIPTION_LIMITATION(0),OPERATOR_POLICY(1),RESOURCE_LIMITATION(2),ROUTING_ACCESS_INFORMATION_NOT_ALLOWED(3),UNSPECIFIED_ERROR(4);

	private static final Map<Integer, RoutingRuleFailureCodeEnum> intToTypeMap = new HashMap<Integer, RoutingRuleFailureCodeEnum>();
	static
	{
	    for (RoutingRuleFailureCodeEnum type : RoutingRuleFailureCodeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static RoutingRuleFailureCodeEnum fromInt(Integer value) 
	{
		RoutingRuleFailureCodeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private RoutingRuleFailureCodeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
