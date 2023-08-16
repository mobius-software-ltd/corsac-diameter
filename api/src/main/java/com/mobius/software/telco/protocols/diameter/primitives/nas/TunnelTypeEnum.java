package com.mobius.software.telco.protocols.diameter.primitives.nas;

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
 * 4.5.2.  Tunnel-Type AVP

   The Tunnel-Type AVP (AVP Code 64) is of type Enumerated and contains
   the tunneling protocol(s) to be used (in the case of a tunnel
   initiator) or in use (in the case of a tunnel terminator).  It MAY be
   used in an authorization request as a hint to the server that a
   specific tunnel type is desired, but the server is not required to
   honor the hint in the corresponding response.

   The Tunnel-Type AVP SHOULD also be included in ACR messages.

   A tunnel initiator is not required to implement any of these tunnel
   types.  If a tunnel initiator receives a response that contains only
   unknown or unsupported tunnel types, the tunnel initiator MUST behave
   as though a response were received with the Result-Code indicating a
   failure.

   The supported values are listed in [RADIUSAttrVals].
 */
public enum TunnelTypeEnum implements IntegerEnum
{
	PPTP(1),L2F(2),L2TP(3),ATMP(4),VTP(5),AH(6),IP_IP(7),MIN_IP_IP(8),ESP(9),GRE(10),DVS(11),IP_IN_IP(12),VLAN(13);

	private static final Map<Integer, TunnelTypeEnum> intToTypeMap = new HashMap<Integer, TunnelTypeEnum>();
	static
	{
	    for (TunnelTypeEnum type : TunnelTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static TunnelTypeEnum fromInt(Integer value) 
	{
		TunnelTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private TunnelTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
