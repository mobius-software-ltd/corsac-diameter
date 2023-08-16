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
 * 	5.3.31 RAT-Type AVP
	The RAT-Type AVP (AVP code 1032) is of type Enumerated and is used to identify the radio access technology that is
	serving the UE. It may be further detailed by AN-Trusted if applicable.

	NOTE 1: Values 0-999 are used for generic radio access technologies that can apply to different IP-CAN types and
	are not IP-CAN specific.

	NOTE 2: Values 1000-1999 are used for 3GPP specific radio access technology types.

	NOTE 3: Values 2000-2999 are used for 3GPP2 specific radio access technology types.

	NOTE 4: The informative Annex C presents a mapping between the code values for different access network types.

	The following values are defined:

	WLAN (0)
 		This value shall be used to indicate that the RAT is WLAN.
	VIRTUAL (1)
 		This value shall be used to indicate that the RAT is unknown. For further details refer to 3GPP TS 29.274 [22].
	TRUSTED- N3GA (2)
 		This value shall be used to indicate that the RAT is a trusted non-3GPP access, different than Trusted Wireless
		LAN (IEEE 802.11) access.

	NOTE 5: This value is not used in the present specification.

	WIRELINE (3)
 		This value shall be used to indicate that the transmission technology is wireline access. It is used when it is not
		possible to differentiate between wireline cable and wireline BBF.

	NOTE 6: This value is not used in the present specification.

	WIRELINE-CABLE (4)
 		This value shall be used to indicate that the transmission technology is wireline cable.

	NOTE 7: This value is not used in the present specification.

	WIRELINE-BBF (5)
 		This value shall be used to indicate that the transmission technology is wireline BBF.

	NOTE 8: This value is not used in the present specification. 

	UTRAN (1000)
 		This value shall be used to indicate that the RAT is UTRAN. For further details refer to 3GPP TS 29.060 [18].
	GERAN (1001)
 		This value shall be used to indicate that the RAT is GERAN. For further details refer to 3GPP TS 29.060 [18].
	GAN (1002)
 		This value shall be used to indicate that the RAT is GAN. For further details refer to 3GPP TS 29.060 [18] and
		3GPP TS 43.318 [29].
	HSPA_EVOLUTION (1003)
 		This value shall be used to indicate that the RAT is HSPA Evolution. For further details refer to
		3GPP TS 29.060 [18].
	EUTRAN (1004)
 		This value shall be used to indicate that the RAT is EUTRAN (WB-EUTRAN) terrestrial RAT type. For further
		details refer to 3GPP TS 29.274 [22].
	EUTRAN-NB-IoT (1005)
 		This value shall be used to indicate that the RAT is NB-IoT. For further details refer to 3GPP TS 29.274 [22].
 	NR (1006)
 		This value shall be used to indicate that the RAT is NR.

	NOTE 9: This value is not used in the present specification.

	LTE-M (1007)
 		This value shall be used to indicate that the RAT is LTE-M. For further details refer to 3GPP TS 29.274 [22].
	NR-U (1008)
 		This value shall be used to indicate that the RAT is NR in unlicensed bands.
	
	NOTE 10: This value is not used in the present specification.

	EUTRAN(LEO) (1011)
 		This value shall be used to indicate that the RAT is WB-EUTRAN(LEO). For further details refer to
		3GPP TS 29.274 [22].
	EUTRAN(MEO) (1012)
 		This value shall be used to indicate that the RAT is WB-EUTRAN(MEO). For further details refer to
		3GPP TS 29.274 [22].
	EUTRAN(GEO) (1013)
 		This value shall be used to indicate that the RAT is WB-EUTRAN(GEO). For further details refer to
		3GPP TS 29.274 [22].
	EUTRAN(OTHERSAT) (1014)
 		This value shall be used to indicate that the RAT is WB-EUTRAN(OTHERSAT). For further details refer to
		3GPP TS 29.274 [22].
	EUTRAN-NB-IoT(LEO) (1021)
 		This value shall be used to indicate that the RAT is NB-IoT(LEO). For further details refer to
		3GPP TS 29.274 [22].
	EUTRAN-NB-IoT(MEO) (1022)
 		This value shall be used to indicate that the RAT is NB-IoT(MEO). For further details refer to
		3GPP TS 29.274 [22].
	EUTRAN-NB-IoT(GEO) (1023)
 		This value shall be used to indicate that the RAT is NB-IoT(GEO). For further details refer to
		3GPP TS 29.274 [22].
	EUTRAN-NB-IoT(OTHERSAT) (1024)
 		This value shall be used to indicate that the RAT is NB-IoT(OTHERSAT). For further details refer to
		3GPP TS 29.274 [22].
	LTE-M(LEO) (1031)
 		This value shall be used to indicate that the RAT is LTE-M(LEO). For further details refer to
		3GPP TS 29.274 [22]. 
	LTE-M(MEO) (1032)
 		This value shall be used to indicate that the RAT is LTE-M(MEO). For further details refer to
		3GPP TS 29.274 [22].
	LTE-M(GEO) (1033)
		This value shall be used to indicate that the RAT is LTE-M(GEO). For further details refer to
		3GPP TS 29.274 [22].
	LTE-M(OTHERSAT) (1034)
 		This value shall be used to indicate that the RAT is LTE-M(OTHERSAT). For further details refer to
		3GPP TS 29.274 [22].
	CDMA2000_1X (2000)
 		This value shall be used to indicate that the RAT is CDMA2000 1X. For further details refer to
		3GPP2 X.S0011 [20].
	HRPD (2001)
 		This value shall be used to indicate that the RAT is HRPD. For further details refer to 3GPP2 X.S0011 [20].
	UMB (2002)
 		This value shall be used to indicate that the RAT is UMB. For further details refer to 3GPP2 X.S0011 [20].
	EHRPD (2003)
 		This value shall be used to indicate that the RAT is eHRPD. For further details refer to 3GPP2 X.S0057 [24].
 */
public enum RATTypeEnum implements IntegerEnum
{
	WLAN(0),VIRTUAL(1),TRUSTED_N3GA(2),WIRELINE(3),WIRELINE_CABLE(4),WIRELINE_BBF(5),UTRAN(1000),
	GERAN(1001),GAN(1002),HSPA_EVOLUTION(1003),EUTRAN(1004),EUTRAN_NB_IOT(1005),NR(1006),LTE_M(1007),
	NR_U(1008),EUTRAN_LEO(1011),EUTRAN_MEO(1012),EUTRAN_GEO(1013),EUTRAN_OTHERSAT(1014),
	EUTRAN_NB_IOT_LEO(1021),EUTRAN_NB_IOT_MEO(1022),EUTRAN_NB_IOT_GEO(1023),EUTRAN_NB_IOT_OTHERSAT(1024),
	LTE_M_LEO(1031),LTE_M_MEO(1032),LTE_M_GEO(1033),LTE_M_OTHERSAT(1034),CDMA2000_1X(2000),
	HRPD(2001),UMB(2002),EHRPD(2003);

	private static final Map<Integer, RATTypeEnum> intToTypeMap = new HashMap<Integer, RATTypeEnum>();
	static
	{
	    for (RATTypeEnum type : RATTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static RATTypeEnum fromInt(Integer value) 
	{
		RATTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private RATTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
