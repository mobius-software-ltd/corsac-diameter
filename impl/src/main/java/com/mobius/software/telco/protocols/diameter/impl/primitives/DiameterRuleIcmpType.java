package com.mobius.software.telco.protocols.diameter.impl.primitives;

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

public enum DiameterRuleIcmpType 
{
	ECHO_REPLY("echo reply",0),DESTINATION_UNREACHABLE("destination unreachable",3),SOURCE_QUENCH("source quench", 4)
	,REDIRECT("redirect", 5),ECHO_REQUEST("echo request", 8),ROUTER_ADVERTISEMENT("router advertisement", 9)
	,ROUTER_SOLICITATION("router solicitation", 10),TIME_TO_LIVE_EXCEEDED("time-to-live exceeded" ,11)
	,IP_HEADER_BAD("ip header bad", 12),TIMESTAMP_REQUEST("timestamp request", 13),TIMESTAMP_REPLY("timestamp reply", 14)
	,INFORMATION_REQUEST("information request", 15),INFORMATION_REPLY("information reply", 16)
	,ADDRESS_MASK_REQUEST("address mask request", 17),ADDRESS_MASK_REPLY("address mask reply", 18);

	private static final Map<String, DiameterRuleIcmpType> strToTypeMap = new HashMap<String, DiameterRuleIcmpType>();
	private static final Map<Integer, DiameterRuleIcmpType> intToTypeMap = new HashMap<Integer, DiameterRuleIcmpType>();
	static 
	{
	    for (DiameterRuleIcmpType type : DiameterRuleIcmpType.values()) 
	    {
	    	strToTypeMap.put(type.value, type);
	    	intToTypeMap.put(type.code, type);
	    }
	}

	public static DiameterRuleIcmpType fromString(String value) 
	{
		DiameterRuleIcmpType type = strToTypeMap.get(value.toLowerCase());
	    return type;
	}

	public static DiameterRuleIcmpType fromInt(Integer value) 
	{
		DiameterRuleIcmpType type = intToTypeMap.get(value);
	    return type;
	}
	
	private String value;
	private Integer code;
	
	private DiameterRuleIcmpType(String value, Integer code)
	{
		this.value=value;
		this.code=code;
	}
	
	public String getValue()
	{
		return value;
	}
	
	public Integer getCode()
	{
		return code;
	}
}