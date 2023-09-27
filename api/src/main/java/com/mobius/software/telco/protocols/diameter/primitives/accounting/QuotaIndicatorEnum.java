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
 * 	7.2.160aA Quota-Indicator AVP
	The Quota-Indicator AVP (AVP code 3912) is of type Enumerated. It is used to indicate whether granted quota is to be
	used during announcement setup and playback. It has the following values:
	
	0 QUOTA_IS_NOT_USED_DURING_PLAYBACK
	1 QUOTA_IS_USED_DURING_PLAYBACK 
 */
public enum QuotaIndicatorEnum implements IntegerEnum
{
	QUOTA_IS_NOT_USED_DURING_PLAYBACK(0),QUOTA_IS_USED_DURING_PLAYBACK(1);

	private static final Map<Integer, QuotaIndicatorEnum> intToTypeMap = new HashMap<Integer, QuotaIndicatorEnum>();
	static 
	{
	    for (QuotaIndicatorEnum type : QuotaIndicatorEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static QuotaIndicatorEnum fromInt(Integer value) 
	{
		QuotaIndicatorEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private QuotaIndicatorEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
