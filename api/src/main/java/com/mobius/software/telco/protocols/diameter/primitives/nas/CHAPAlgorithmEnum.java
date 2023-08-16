package com.mobius.software.telco.protocols.diameter.primitives.nas;

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
 * 4.3.5.  CHAP-Algorithm AVP

   The CHAP-Algorithm AVP (AVP Code 403) is of type Enumerated and
   contains the algorithm identifier used in the computation of the CHAP
   response [RFC1994].  The following values are currently supported:

   CHAP with MD5       5

      The CHAP response is computed by using the procedure described in
      [RFC1994].  This algorithm requires that the CHAP-Response AVP
      (Section 4.3.7) MUST be present in the CHAP-Auth AVP
      (Section 4.3.4).
 */
public enum CHAPAlgorithmEnum implements IntegerEnum
{
	CHAP_WITH_MD5(5);

	private static final Map<Integer, CHAPAlgorithmEnum> intToTypeMap = new HashMap<Integer, CHAPAlgorithmEnum>();
	static
	{
	    for (CHAPAlgorithmEnum type : CHAPAlgorithmEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static CHAPAlgorithmEnum fromInt(Integer value) 
	{
		CHAPAlgorithmEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private CHAPAlgorithmEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
