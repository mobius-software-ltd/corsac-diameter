package com.mobius.software.telco.protocols.diameter.primitives.s9;

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
 * 	5.3.7	DRA-Deployment
	The DRA-Deployment AVP (AVP code 2206) is of type Enumerated and is used by the V-DRA (proxy) to indicate to the H-PCRF that whether the DRA is deployed in the visited network.
	The following values are defined:

	DRA_Deployed (0)
	This value indicates that the DRA is deployed.
 */
public enum DRADeploymentEnum implements IntegerEnum
{
	DRA_DEPLOYED(0);

	private static final Map<Integer, DRADeploymentEnum> intToTypeMap = new HashMap<Integer, DRADeploymentEnum>();
	static
	{
	    for (DRADeploymentEnum type : DRADeploymentEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static DRADeploymentEnum fromInt(Integer value) 
	{
		DRADeploymentEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private DRADeploymentEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
