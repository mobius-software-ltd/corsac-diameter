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
 * 	7.2.111AaA Monitoring-Event-Configuration-Activity AVP
	The Monitoring-Event-Configuration-Activity AVP (AVP code3919) is of type Enumerated and indicates Monitoring
	Event configuration action which triggers the Monitoring Event charging. The AVP may take the values as follows:

	0 create
	1 transfer
	2 update
	3 delete 
 */
public enum MonitoringEventConfigurationActivityEnum implements IntegerEnum
{
	CREATE(0),TRANSFER(1),UPDATE(2),DELETE(3);

	private static final Map<Integer, MonitoringEventConfigurationActivityEnum> intToTypeMap = new HashMap<Integer, MonitoringEventConfigurationActivityEnum>();
	static 
	{
	    for (MonitoringEventConfigurationActivityEnum type : MonitoringEventConfigurationActivityEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static MonitoringEventConfigurationActivityEnum fromInt(Integer value) 
	{
		MonitoringEventConfigurationActivityEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private MonitoringEventConfigurationActivityEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
