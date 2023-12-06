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
 * 	3.2.123  Fav-Cell-Id-Flag AVP
	
	AVP Name
	Fav-Cell-Id-Flag

	AVP Code
	20361

	AVP Data Type
	Enumerated

	Vender-ID
	2011

	Description
	Indicates the flag of a preferential cell (HomeZone). The values are as follows:
    	- 0: Not in any preferential cell.
    	- 1: In the system level preferential cell.
    	- 2: In the user level preferential cell.
    	- 3: In the user level HomeZone and system level SpecialZone.
 */
public enum FavCellIdFlagEnum implements IntegerEnum
{
	NOT(0),SYSTEM_LEVEL(1),USER_LEVEL(2),HOME_AND_SPECIAL_ZONE(3);

	private static final Map<Integer, FavCellIdFlagEnum> intToTypeMap = new HashMap<Integer, FavCellIdFlagEnum>();
	static 
	{
	    for (FavCellIdFlagEnum type : FavCellIdFlagEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static FavCellIdFlagEnum fromInt(Integer value) 
	{
		FavCellIdFlagEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private FavCellIdFlagEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
