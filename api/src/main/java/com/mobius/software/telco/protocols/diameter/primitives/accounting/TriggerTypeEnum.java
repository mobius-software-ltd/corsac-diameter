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
public enum TriggerTypeEnum implements IntegerEnum
{
	CHANGE_IN_SGSN_IP_ADDRESS(1),CHANGE_IN_QOS(2),CHANGE_IN_LOCATION(3),CHANGE_IN_RAT(4),CHANGE_IN_UE_TIMEZONE(5),
	CHANGEINQOS_TRAFFIC_CLASS(10),CHANGEINQOS_RELIABILITY_CLASS(11),CHANGEINQOS_DELAY_CLASS(12),CHANGEINQOS_PEAK_THROUGHPUT(13),CHANGEINQOS_PRECEDENCE_CLASS(14),
	CHANGEINQOS_MEAN_THROUGHPUT(15),CHANGEINQOS_MAXIMUM_BIT_RATE_FOR_UPLINK(16),CHANGEINQOS_MAXIMUM_BIT_RATE_FOR_DOWNLINK(17),CHANGEINQOS_RESIDUAL_BER(18),CHANGEINQOS_SDU_ERROR_RATIO(19),
	CHANGEINQOS_TRANSFER_DELAY(20),CHANGEINQOS_TRAFFIC_HANDLING_PRIORITY(21),CHANGEINQOS_GUARANTEED_BIT_RATE_FOR_UPLINK(22),CHANGEINQOS_GUARANTEED_BIT_RATE_FOR_DOWNLINK(23),
	CHANGEINQOS_APN_AGGREGATE_MAXIMUM_BIT_RATE(24),CHANGEINLOCATION_MCC(30),CHANGEINLOCATION_MNC(31),CHANGEINLOCATION_RAC(32),CHANGEINLOCATION_LAC(33),
	CHANGEINLOCATION_CELLID(34),CHANGEINLOCATION_TAC(35),CHANGEINLOCATION_ECGI(36),CHANGE_IN_MEDIA_COMPOSITION(40),CHANGE_IN_PARTICIPANTS_NMB(50),
	THRSHLD_OF_PARTICIPANTS_NMB(51),CHANGE_IN_USER_PARTICIPATING_TYPE(52),CHANGE_IN_SERVICE_CONDITION(60),CHANGE_IN_SERVING_NODE(61),CHANGE_IN_ACCESS_FOR_A_SERVICE_DATA_FLOW(62),
	CHANGE_IN_USER_CSG_INFORMATION(70),CHANGE_IN_HYBRID_SUBSCRIBED_USER_CSG_INFORMATION(71),CHANGE_IN_HYBRID_UNSUBSCRIBED_USER_CSG_INFORMATION(72),
	CHANGE_OF_UE_PRESENCE_IN_PRESENCE_REPORTING_AREA(73),CHANGE_IN_APN_RATE_CONTROL(75),CHANGE_IN_3GPP_PS_DATA_OFF(76);

	private static final Map<Integer, TriggerTypeEnum> intToTypeMap = new HashMap<Integer, TriggerTypeEnum>();
	static 
	{
	    for (TriggerTypeEnum type : TriggerTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static TriggerTypeEnum fromInt(Integer value) 
	{
		TriggerTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private TriggerTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
