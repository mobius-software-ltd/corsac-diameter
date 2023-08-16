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
 * 	5.3.19 PCC-Rule-Status AVP (All access types)
	The PCC-Rule-Status AVP (AVP code 1019) is of type Enumerated, and describes the status of one or a group of PCC
	Rules.
	The following values are defined:

	ACTIVE (0)
 		This value is used to indicate that the PCC rule(s) are successfully installed (for those provisioned from PCRF)
		or activated (for those pre-provisioned in PCEF).
	INACTIVE (1)
 		This value is used to indicate that the PCC rule(s) are removed (for those provisioned from PCRF) or inactive
		(for those pre-provisioned in PCEF).
	TEMPORARILY INACTIVE (2)
 		This value is used to indicate that, for some reason (e.g. loss of bearer), already installed or activated PCC rules
		are temporarily disabled.
 */
public enum PCCRuleStatusEnum implements IntegerEnum
{
	ACTIVE(0),INACTIVE(1),TEMPORARILY_INACTIVE(2);

	private static final Map<Integer, PCCRuleStatusEnum> intToTypeMap = new HashMap<Integer, PCCRuleStatusEnum>();
	static
	{
	    for (PCCRuleStatusEnum type : PCCRuleStatusEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static PCCRuleStatusEnum fromInt(Integer value) 
	{
		PCCRuleStatusEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private PCCRuleStatusEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
