package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei;

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
 * 	3.2.250  Recharge-Card-Type AVP

	AVP Name 
	Recharge-Card-Type

	AVP Code 
	20790

	AVP Data Type 
	Enumerated

	Vendor ID
	2011

	Description 
	Dear code define different dealer.
    	- 2:Airtime card 
    	- 3:Network Card 
 */
public enum RechargeCardTypeEnum implements IntegerEnum
{
	AIRTIME(2),NETWORK(3);

	private static final Map<Integer, RechargeCardTypeEnum> intToTypeMap = new HashMap<Integer, RechargeCardTypeEnum>();
	static 
	{
	    for (RechargeCardTypeEnum type : RechargeCardTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static RechargeCardTypeEnum fromInt(Integer value) 
	{
		RechargeCardTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private RechargeCardTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
