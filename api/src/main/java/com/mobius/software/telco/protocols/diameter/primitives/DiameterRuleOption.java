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
public enum DiameterRuleOption 
{
	FRAGMENT("frag"),ESTABLISHED("established"),SETUP("setup"),IP_OPTS("ipoptions"),TCP_OPTS("tcpoptions"),ICMP_TYPES("icmptypes"),TCP_FLAGS("tcpflags");

	private static final Map<String, DiameterRuleOption> strToTypeMap = new HashMap<String, DiameterRuleOption>();
	static 
	{
	    for (DiameterRuleOption type : DiameterRuleOption.values()) 
	    {
	    	strToTypeMap.put(type.value, type);
	    }
	}

	public static DiameterRuleOption fromString(String value) 
	{
		DiameterRuleOption type = strToTypeMap.get(value);
	    return type;
	}
	
	private String value;
	
	private DiameterRuleOption(String value)
	{
		this.value=value;
	}
	
	public String getValue()
	{
		return value;
	}
}
