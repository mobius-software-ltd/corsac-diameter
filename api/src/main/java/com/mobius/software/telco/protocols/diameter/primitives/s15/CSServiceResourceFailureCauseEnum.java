package com.mobius.software.telco.protocols.diameter.primitives.s15;

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

import java.util.HashMap;
import java.util.Map;

import com.mobius.software.telco.protocols.diameter.primitives.IntegerEnum;

/*
 * E.6.3.5	CS-Service-Resource-Failure-Cause
 * CS-Service-Resource-Failure-Cause AVP (AVP code 2814) is type of Enumerated,
 * and it indicates the reason why the resource is released.
 * The following values are defined:
 * 
 *  RESOURCE_RELEASED (0)
 *	This value is used to indicate that resource can not be maintained in the Fixed Broadband Access network.
 * 
 */

public enum CSServiceResourceFailureCauseEnum implements IntegerEnum
{
	RESOURSE_RELEASED(0);

	private static final Map<Integer, CSServiceResourceFailureCauseEnum> intToTypeMap = new HashMap<Integer, CSServiceResourceFailureCauseEnum>();
	static
	{
	    for (CSServiceResourceFailureCauseEnum type : CSServiceResourceFailureCauseEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static CSServiceResourceFailureCauseEnum fromInt(Integer value) 
	{
		CSServiceResourceFailureCauseEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private CSServiceResourceFailureCauseEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
