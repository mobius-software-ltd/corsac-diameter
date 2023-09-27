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
 * 	7.2.113 Node-Functionality AVP
	The Node-Functionality AVP (AVP code 862) is of type Enumerated and includes the functionality identifier of the
	node. The functionality identifier can be one of the following:
	
	0 S-CSCF
	1 P-CSCF
	2 I-CSCF
	3 MRFC
	4 MGCF
	5 BGCF
	6 AS
	7 IBCF
	8 S-GW
	9 P-GW
	10 HSGW
	11 E-CSCF
	12 MME
	13 TRF
	14 TF
	15 ATCF
	16 Proxy Function
	17 ePDG
	18 TDF
	19 TWAG
	20 SCEF
	21 IWK-SCEF 
 */
public enum NodeFunctionalityEnum implements IntegerEnum
{
	SCSCF(0),PCSCF(1),ICSCF(2),MRFC(3),MGCF(4),BGCF(5),AS(6),IBCF(7),SGW(8),PGW(9),HSGW(10),ECSCF(11),MME(12),TRF(13),TF(14),ATCF(15),PROXY(16),ePDG(17),TDF(18),TWAG(19),SCEF(20),IWK_SCEF(21);

	private static final Map<Integer, NodeFunctionalityEnum> intToTypeMap = new HashMap<Integer, NodeFunctionalityEnum>();
	static 
	{
	    for (NodeFunctionalityEnum type : NodeFunctionalityEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static NodeFunctionalityEnum fromInt(Integer value) 
	{
		NodeFunctionalityEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private NodeFunctionalityEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
