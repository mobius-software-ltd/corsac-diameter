package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol;

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
 * 8.6.  Check-Balance-Result AVP

   The Check-Balance-Result AVP (AVP Code 422) is of type Enumerated and
   contains the result of the balance check.  This AVP is applicable
   only when the Requested-Action AVP indicates CHECK_BALANCE in the
   Credit-Control-Request command.  The following values are defined for
   the Check-Balance-Result AVP:

   ENOUGH_CREDIT   0

   There is enough credit in the account to cover the requested service.

   NO_CREDIT       1

   There isn't enough credit in the account to cover the requested
   service.
 */
public enum CheckBalanceResultEnum implements IntegerEnum
{
	ENOUGH_CREDIT(0),NO_CREDIT(1);

	private static final Map<Integer, CheckBalanceResultEnum> intToTypeMap = new HashMap<Integer, CheckBalanceResultEnum>();
	static 
	{
	    for (CheckBalanceResultEnum type : CheckBalanceResultEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static CheckBalanceResultEnum fromInt(Integer value) 
	{
		CheckBalanceResultEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private CheckBalanceResultEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
