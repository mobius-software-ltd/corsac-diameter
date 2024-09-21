package com.mobius.software.telco.protocols.diameter;
/*
 * Mobius Software LTD, Open Source Cloud Communications
 * Copyright 2023, Mobius Software LTD and individual contributors
 * by the @authors tag.
 *
 * This program is free software: you can redistribute it and/or modify
 * under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation), either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY), without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

import java.util.HashMap;
import java.util.Map;

/**
*
* @author yulian oifa
*
*/

public enum ApplicationID
{
	COMMON(0),
	NASREQ(1),
	MIPV4(2),
	ACC(3),
	CC(4),
	EAP(5),
	SIP(6),
	MIP6I(7),
	MIP6A(8),
	
	CX_DX(16777216),
	SH(16777217),
	GQ(16777222),
	GMB(16777223),
	MM10(16777226),
	E4(16777231),
	CIP(16777232),
	RX(16777236),
	GX(16777238),
	STA(16777250),
	S6A(16777251),
	S13(16777252),
	SLG(16777255),
	SWM(16777264),
	SWX(16777265),
	GXX(16777266),
	S9(16777267),
	S6B(16777272),
	SLH(16777291),
	SGMB(16777292),
	SY(16777302),
	SD(16777303),
	S7A(16777308),
	TSP(16777309),
	S6M(16777310),
	T4(16777311),
	S6C(16777312),
	SGD(16777313),
	S15(16777318),
	S9A(16777319),
	S9ATAG(16777320),
	MB2C(16777335),
	PC4A(16777336),
	PC6(16777340),
	NP(16777342),
	S6T(16777345),
	T6A(16777346),
	NT(16777348),
	ST(16777349),
	PC2(16777350),
	NTA(16777358);
	
	private static final Map<Integer, ApplicationID> intToTypeMap = new HashMap<Integer, ApplicationID>();
	static 
	{
	    for (ApplicationID type : ApplicationID.values()) 
	    {
	        intToTypeMap.put(type.value, type);
	    }
	}
	
	public static ApplicationID fromInt(int i) 
	{
		return intToTypeMap.get(Integer.valueOf(i));	    
	}
	
	private int value;
	
	private ApplicationID(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}