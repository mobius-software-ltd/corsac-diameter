package com.mobius.software.telco.protocols.diameter.primitives;

import java.util.HashMap;
import java.util.Map;

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
public enum DiameterAddressTypeEnum implements IntegerEnum
{
	RESERVED(0),IPV4(1),IPV6(2),NSAP(3),HDLC(4),BBN_1822(5),E802(6),E163(7),E164(8),
	F69(9),X121(10),IPX(11),APPLETALK(12),DECNET_IV(13),BANYAN_VINES(14),E164_WITH_NSAP(15),DNS(16),
	DISTINGUISHED_NAME(17),AS_NUMBER(18),XTP_OVER_IP_VERSION_4(19),XTP_OVER_IP_VERSION_6(20),XTP_NATIVE_MODE_XTP(21),
	FIBRE_CHANNEL_WW_PORT_NAME(22),FIBRE_CHANNEL_WW_NODE_NAME(23),GWID(24),AFI_FOR_L2VPN(25),
	MPLS_TP_SECTION_ENDPOINT_IDENTIFIER(26),MPLS_TP_LSP_ENDPOINT_IDENTIFIER(27),MPLS_TP_PSEUDOWIRE_ENDPOINT_IDENTIFIER(28),
	MT_IP(29),MT_IPV6(30),BGP_SFC(31),
	EIGRP_COMMON_SERVICE_FAMILY(16384),EIGRP_IPV4_SERVICE_FAMILY(16385),EIGRP_IPV6_SERVICE_FAMILY(16386),LCAF(16387),
	BGPLS(16388),MAC_48(16389),MAC_64(16390),OUI(16391),MAC_24(16392),MAC_40(16393),IPV6_64(16394),RBEIDGE_PORT_ID(16395),
	TRILL_NICKNAME(16396),UUID(16397),ROUTING_POLICY_AFI(16398),MPLS_NAMESPACES(16399);

	private static final Map<Integer, DiameterAddressTypeEnum> intToTypeMap = new HashMap<Integer, DiameterAddressTypeEnum>();
	static
	{
	    for (DiameterAddressTypeEnum type : DiameterAddressTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static DiameterAddressTypeEnum fromInt(Integer value) 
	{
		DiameterAddressTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private DiameterAddressTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
