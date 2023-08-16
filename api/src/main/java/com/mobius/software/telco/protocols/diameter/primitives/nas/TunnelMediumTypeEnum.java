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
 * 4.5.3.  Tunnel-Medium-Type AVP

   The Tunnel-Medium-Type AVP (AVP Code 65) is of type Enumerated and
   contains the transport medium to use when creating a tunnel for
   protocols (such as L2TP [RFC3931]) that can operate over multiple
   transports.  It MAY be used in an authorization request as a hint to
   the server that a specific medium is desired, but the server is not
   required to honor the hint in the corresponding response.

   The supported values are listed in [RADIUSAttrVals].
 */
public enum TunnelMediumTypeEnum implements IntegerEnum
{
	IPv4(1),IPv6(2),NSAP(3),HDLC(4),BBN_1822(5),M802(6),E_163(7),E_164(8),F_69(9),X_121(10),IPX(11),APPLETALK(12),Decnet_IV(13),BANYAN(14),E_164_WITH_NSAP(15);

	private static final Map<Integer, TunnelMediumTypeEnum> intToTypeMap = new HashMap<Integer, TunnelMediumTypeEnum>();
	static
	{
	    for (TunnelMediumTypeEnum type : TunnelMediumTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static TunnelMediumTypeEnum fromInt(Integer value) 
	{
		TunnelMediumTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private TunnelMediumTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
