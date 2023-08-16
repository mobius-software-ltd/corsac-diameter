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
 * 	5.3.27 IP-CAN-Type AVP (All access types)
	The IP-CAN-Type AVP (AVP code 1027) is of type Enumerated, and it shall indicate the type of Connectivity Access
	Network in which the user is connected.
	The IP-CAN-Type AVP shall always be present during the IP-CAN session establishment. During an IP-CAN session
	modification, this AVP shall be present when there has been a change in the IP-CAN type and the PCRF requested to be
	informed of this event. The Event-Trigger AVP with value IP-CAN-CHANGE shall be provided together with the IPCAN-Type AVP.

	NOTE 1: The informative Annex C presents a mapping between the code values for different access network types.
	The following values are defined:

	3GPP-GPRS (0)
 		This value shall be used to indicate that the IP-CAN is associated with a 3GPP GPRS access that is connected to
		the GGSN based on the Gn/Gp interfaces and is further detailed by the RAT-Type AVP. RAT-Type AVP will
		include applicable 3GPP values, except EUTRAN (WB-EUTRAN) , EUTRAN-NB-IoT and LTE-M.
	DOCSIS (1)
 		This value shall be used to indicate that the IP-CAN is associated with a DOCSIS access.
	xDSL (2)
 		This value shall be used to indicate that the IP-CAN is associated with an xDSL access.
	WiMAX (3)
 		This value shall be used to indicate that the IP-CAN is associated with a WiMAX access (IEEE 802.16).
	3GPP2 (4)
 		This value shall be used to indicate that the IP-CAN is associated with a 3GPP2 access connected to the 3GPP2
		packet core as specified in 3GPP2 X.S0011 [20] and is further detailed by the RAT-Type AVP.
	3GPP-EPS (5)
 		This value shall be used to indicate that the IP-CAN is associated with a 3GPP EPS access and is further detailed
		by the RAT-Type AVP.
	Non-3GPP-EPS (6)
 		This value shall be used to indicate that the IP-CAN is associated with an EPC based non-3GPP access and is
		further detailed by the RAT-Type AVP and AN-Trusted AVP if applicable.
	FBA (7)
 		This value shall be used to indicate that the IP-CAN is associated with any kind of Fixed Broadband Network
		access convergence via the IP Edge (e.g, xDSL, Fiber).
	3GPP-5GS (8)
 		This value shall be used to indicate that the IP-CAN is associated with a 3GPP 5GS access and is further detailed
		by the RAT-Type AVP. RAT-Type AVP will include applicable 3GPP values, except EUTRAN-NB-IoT and
		LTE-M.

	NOTE 2: This value is not used in the present specification.

	Non-3GPP-5GS (9)
 		This value shall be used to indicate that the IP-CAN is associated with a 5GS based non-3GPP access.
	
	NOTE 3: This value is not used in the present specification.
 */
public enum IPCANTypeEnum implements IntegerEnum
{
	TGPP_GPRS(0),DOCSIS(1),XDSL(2),WIMAX(3),TGPP2(4),TGPP_EPS(5),NON_TGPP_EPS(6),FBA(7),TGPP_5GS(8),NON_TGPP_5GS(9);

	private static final Map<Integer, IPCANTypeEnum> intToTypeMap = new HashMap<Integer, IPCANTypeEnum>();
	static
	{
	    for (IPCANTypeEnum type : IPCANTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static IPCANTypeEnum fromInt(Integer value) 
	{
		IPCANTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private IPCANTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
