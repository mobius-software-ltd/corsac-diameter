package com.mobius.software.telco.protocols.diameter.primitives.pc6;

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
 * 	6.3.5	Discovery-Type
	The Discovery-Type AVP is of type Unsigned32 and contains a 32-bit address space representing types of Direct Discovery Authorization Request. The following values are defined:

	ANNOUNCING_REQUEST_FOR_OPEN_PROSE_DIRECT_DISCOVERY (0)
	This value is used when the Direct Discovery Authorization Request message is sent for a UE requesting authorization for announcing in open Prose Direct Discovery (Model A).

	MONITORING_REQUEST_FOR_OPEN_PROSE_DIRECT_DISCOVERY (1)
	This value is used when the Direct Discovery Authorization Request message is sent for a UE requesting authorization for monitoring in open Prose Direct Discovery (Model A).

	ANNOUNCING_REQUEST_FOR_RESTRICTED_PROSE_DIRECT_DISCOVERY (2)
	This value is used when the Direct Discovery Authorization Request message is sent for a UE requesting authorization for announcing in restricted ProSe Direct Discovery (Model A).

	MONITORING_REQUEST_FOR_RESTRICTED_PROSE_DIRECT_DISCOVERY (3)
	This value is used when the Direct Discovery Authorization Request message is sent for a UE requesting authorization for monitoring in restricted ProSe Direct Discovery (Model A).

	DISCOVEREE_REQUEST_FOR_RESTRICTED_PROSE_DIRECT_DISCOVERY (4)
	This value is used when the Direct Discovery Authorization Request message is sent for a discoveree UE requesting authorization for monitoring in restricted ProSe Direct Discovery (Model B).

	DISCOVERER_REQUEST_FOR_RESTRICTED_PROSE_DIRECT_DISCOVERY (5)
	This value is used when the Direct Discovery Authorization Request message is sent to the ProSe Function in local PLMN for a discoverer UE requesting authorization for announcing in restricted ProSe Direct Discovery (Model B).

	DISCOVERER_ANNOUNCING_REQUEST_FOR_RESTRICTED_PROSE_DIRECT_DISCOVERY (6)
	This value is used when the Direct Discovery Authorization Request message is sent to the ProSe Function in the visited PLMN for a discoverer UE requesting authorization for announcing in restricted ProSe Direct Discovery (Model B).

	MONITORING_UPDATE_FOR_RESTRICTED_PROSE_DIRECT_DISCOVERY (7)
	This value is used when the Direct Discovery Authorization Request message is sent for the ProSe Function requesting to ban a user of an authorization for monitoring in restricted ProSe Direct Discovery (Model A).

	MONITORING_RESPONSE_FOR_RESTRICTED_PROSE_DIRECT_DISCOVERY (8)
	This value is used when the Direct Discovery Authorization Request message is sent for the ProSe Function reporting the result of an authorization for monitoring in restricted ProSe Direct Discovery (Model A). 
 */
public enum DiscoveryTypeEnum implements IntegerEnum
{
	ANNOUNCING_REQUEST_FOR_OPEN_PROSE_DIRECT_DISCOVERY(0),MONITORING_REQUEST_FOR_OPEN_PROSE_DIRECT_DISCOVERY(1),
	ANNOUNCING_REQUEST_FOR_RESTRICTED_PROSE_DIRECT_DISCOVERY(2),MONITORING_REQUEST_FOR_RESTRICTED_PROSE_DIRECT_DISCOVERY(3),
	DISCOVEREE_REQUEST_FOR_RESTRICTED_PROSE_DIRECT_DISCOVERY(4),DISCOVERER_REQUEST_FOR_RESTRICTED_PROSE_DIRECT_DISCOVERY(5),
	DISCOVERER_ANNOUNCING_REQUEST_FOR_RESTRICTED_PROSE_DIRECT_DISCOVERY(6),MONITORING_UPDATE_FOR_RESTRICTED_PROSE_DIRECT_DISCOVERY(6),
	MONITORING_RESPONSE_FOR_RESTRICTED_PROSE_DIRECT_DISCOVERY(8);

	private static final Map<Integer, DiscoveryTypeEnum> intToTypeMap = new HashMap<Integer, DiscoveryTypeEnum>();
	static
	{
	    for (DiscoveryTypeEnum type : DiscoveryTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static DiscoveryTypeEnum fromInt(Integer value) 
	{
		DiscoveryTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private DiscoveryTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
