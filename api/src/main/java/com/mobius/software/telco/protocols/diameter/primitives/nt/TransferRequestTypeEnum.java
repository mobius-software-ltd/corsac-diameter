package com.mobius.software.telco.protocols.diameter.primitives.nt;

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
 * 	5.3.4	Transfer-Request-Type AVP
	The Transfer-Request-Type AVP (AVP code 4203) is of type Unsigned32, it contains the reason for sending the BT-Request message.
	The following values are defined:

	0 (TRANSFER_POLICY_REQUEST)
	The BT-Request message is sent to initiate a transfer policy request procedure.

	1 (TRANSFER_POLICY_NOTIFICATION)
	The BT-Request message is sent to initiate a transfer policy notification procedure. 
 */
public enum TransferRequestTypeEnum implements IntegerEnum
{
	TRANSFER_POLICY_REQUEST(0),TRANSFER_POLICY_NOTIFICATION(1);

	private static final Map<Integer, TransferRequestTypeEnum> intToTypeMap = new HashMap<Integer, TransferRequestTypeEnum>();
	static
	{
	    for (TransferRequestTypeEnum type : TransferRequestTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static TransferRequestTypeEnum fromInt(Integer value) 
	{
		TransferRequestTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private TransferRequestTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
