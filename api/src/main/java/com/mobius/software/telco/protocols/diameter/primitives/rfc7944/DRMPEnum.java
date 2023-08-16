package com.mobius.software.telco.protocols.diameter.primitives.rfc7944;

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
 * 9.1.  DRMP AVP

   The DRMP (AVP code 301) is of type Enumerated.  The value of the AVP
   indicates the routing message priority for the transaction.  The
   following values are defined:

   PRIORITY_15 15  PRIORITY_15 is the lowest priority.

   PRIORITY_14 14  PRIORITY_14 is a higher priority than PRIORITY_15 and
      a lower priority than PRIORITY_13.

   PRIORITY_13 13  PRIORITY_13 is a higher priority than PRIORITY_14 and
      a lower priority than PRIORITY_12.

   PRIORITY_12 12  PRIORITY_12 is a higher priority than PRIORITY_13 and
      a lower priority than PRIORITY_11.

   PRIORITY_11 11  PRIORITY_11 is a higher priority than PRIORITY_12 and
      a lower priority than PRIORITY_10.

   PRIORITY_10 10  PRIORITY_10 is a higher priority than PRIORITY_11 and
      a lower priority than PRIORITY_9.
      
   PRIORITY_9 9  PRIORITY_9 is a higher priority than PRIORITY_10 and a
      lower priority than PRIORITY_8.

   PRIORITY_8 8  PRIORITY_8 is a higher priority than PRIORITY_9 and a
      lower priority than PRIORITY_7.

   PRIORITY_7 7  PRIORITY_7 is a higher priority than PRIORITY_8 and a
      lower priority than PRIORITY_6.

   PRIORITY_6 6  PRIORITY_6 is a higher priority than PRIORITY_7 and a
      lower priority than PRIORITY_5.

   PRIORITY_5 5  PRIORITY_5 is a higher priority than PRIORITY_6 and a
      lower priority than PRIORITY_4.

   PRIORITY_4 4  PRIORITY_4 is a higher priority than PRIORITY_5 and a
      lower priority than PRIORITY_3.

   PRIORITY_3 3  PRIORITY_3 is a higher priority than PRIORITY_4 and a
      lower priority than PRIORITY_2.

   PRIORITY_2 2  PRIORITY_2 is a higher priority than PRIORITY_3 and a
      lower priority than PRIORITY_1.

   PRIORITY_1 1  PRIORITY_1 is a higher priority than PRIORITY_2 and a
      lower priority than PRIORITY_0.

   PRIORITY_0 0  Priority 0 is the highest priority.
 */
public enum DRMPEnum implements IntegerEnum
{
	PRIORITY_15(15),PRIORITY_14(14),PRIORITY_13(13),PRIORITY_12(12),PRIORITY_11(11),
	PRIORITY_10(10),PRIORITY_9(9),PRIORITY_8(8),PRIORITY_7(7),PRIORITY_6(6),
	PRIORITY_5(5),PRIORITY_4(4),PRIORITY_3(3),PRIORITY_2(2),PRIORITY_1(1),PRIORITY_0(0);

	private static final Map<Integer, DRMPEnum> intToTypeMap = new HashMap<Integer, DRMPEnum>();
	static
	{
	    for (DRMPEnum type : DRMPEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static DRMPEnum fromInt(Integer value) 
	{
		DRMPEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private DRMPEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
