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
 * 12.17.  Tariff-Change-Usage AVP

   As defined in Section 8.27, the Tariff-Change-Usage AVP includes
   Enumerated type values 0-2.  IANA has created and is maintaining a
   namespace for this AVP.  The definition of new values is subject to
   the Specification Required policy [RFC8126] and conditions for
   enumerated values described in [RFC7423], Section 5.6.
 */
public enum TariffChangeUsageEnum implements IntegerEnum
{
	UNIT_BEFORE_TARIFF_CHANGE(0),UNIT_AFTER_TARIFF_CHANGE(1),UNIT_INDETERMINATE(2);

	private static final Map<Integer, TariffChangeUsageEnum> intToTypeMap = new HashMap<Integer, TariffChangeUsageEnum>();
	static 
	{
	    for (TariffChangeUsageEnum type : TariffChangeUsageEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static TariffChangeUsageEnum fromInt(Integer value) 
	{
		TariffChangeUsageEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private TariffChangeUsageEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
