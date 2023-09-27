package com.mobius.software.telco.protocols.diameter.primitives.s6a;

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
 * 	7.3.114	User-State
	The User-State AVP is of type Enumerated and indicates the user state in EPS. The following values are defined:

	DETACHED (0)
	The UE is in EMM_DEREGISTERED state.

	ATTACHED_NOT_REACHABLE_FOR_PAGING (1)
	The SGSN has determined from its internal data that the UE is attached to the network, but there is no EPS bearer active, and the UE is not reachable for paging. This value is only applicable to S4-SGSN.

	ATTACHED_REACHABLE_FOR_PAGING (2)
	The SGSN has determined from its internal data that the UE is attached to the network, but there is no EPS bearer active; the SGSN has not determined from its internal data that the UE is not reachable for paging. This value is only applicable to S4-SGSN.

	CONNECTED_NOT_REACHABLE_FOR_PAGING (3)
	The SGSN or MME has determined from its internal data that the UE is attached to the network, there is at least one EPS bearer active, and the UE is not reachable for paging.

	CONNECTED_REACHABLE_FOR_PAGING (4)
	The SGSN or MME has determined from its internal data that the UE is attached to the network, there is at least one EPS bearer active, and the SGSN or MME has not determined from its internal data that the UE is not reachable for paging.

	RESERVED (5)
	This value should not be used by MME or SGSN over S6a/S6d. If this value is received by the HSS from pre-rel-12 MME/SGSNs, the HSS shall consider that the UE is not reachable and use the "Network determined not reachable" state when reporting the User State to other network entities, e.g. over Sh.

	NOTE:	The state associated to a "Network determined not reachable" condition should also be used by HSS when reporting to the requesting entity, e.g. over Sh, that the user was found to be not reachable (for instance, if the HSS receives no answer from the MME/SGSN to the user state query).
 */
public enum UserStateEnum implements IntegerEnum
{
	DETACHED(0),ATTACHED_NOT_REACHABLE_FOR_PAGING(1),ATTACHED_REACHABLE_FOR_PAGING(2),CONNECTED_NOT_REACHABLE_FOR_PAGING(3),CONNECTED_REACHABLE_FOR_PAGING(4),RESERVED(5);

	private static final Map<Integer, UserStateEnum> intToTypeMap = new HashMap<Integer, UserStateEnum>();
	static
	{
	    for (UserStateEnum type : UserStateEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static UserStateEnum fromInt(Integer value) 
	{
		UserStateEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private UserStateEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
