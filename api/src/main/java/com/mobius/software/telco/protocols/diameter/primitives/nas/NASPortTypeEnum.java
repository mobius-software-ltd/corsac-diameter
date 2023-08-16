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
 * 4.2.4.  NAS-Port-Type AVP

   The NAS-Port-Type AVP (AVP Code 61) is of type Enumerated and
   contains the type of the port on which the NAS is authenticating the
   user.  This AVP SHOULD be present if the NAS uses the same NAS-Port
   number ranges for different service types concurrently.

   The currently supported values of the NAS-Port-Type AVP are listed in
   [RADIUSAttrVals].
 */
public enum NASPortTypeEnum implements IntegerEnum
{
	ASYNC(0),SYNC(1),ISDN_SYNC(2),ISDN_ASYNC_V120(3),ISDN_ASYNC_V110(4),VIRTUAL(5),PIAFS(6),HDLC_CLEAR_CHANNEL(7),
	X_25(8),X_75(9),G3_FAX(10),SDSL(11),ADSL_CAP(12),ADSL_DMT(13),IDSL_ISDN(14),ETHERNET(15),XDSL(16),CABLE(17),
	WIRELESS_OTHER(18),WIRELESS_IEEE_802_11(19),TOKEN_RING(20),FDDI(21),WIRELESS_CDMA2000(22),WIRELESS_UMTS(23),WIRELESS_UMTS_1X_EV(24),
	IAPP(25),FTTP(26),WIRELESS_IEEE_802_16(27),WIRELESS_IEEE_802_20(28),WIRELESS_IEEE_802_22(29),PPP0A(30),PPPOEOA(31),PPPOEOE(32),
	PPPOEOVLAN(33),PPPOEOQINQ(34),XPON(35),WIRELESS_XGP(36),WIMAX_PRE_RELEASE_8(37),WIMAX_WIFI_IWK(38),WIMAX_SFF(39),
	WIMAX_HA_LMA(40),WIMAX_DHCP(41),WIMAX_LBS(42),WIMAX_WVS(43);

	private static final Map<Integer, NASPortTypeEnum> intToTypeMap = new HashMap<Integer, NASPortTypeEnum>();
	static 
	{
	    for (NASPortTypeEnum type : NASPortTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static NASPortTypeEnum fromInt(Integer value) 
	{
		NASPortTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private NASPortTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
