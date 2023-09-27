package com.mobius.software.telco.protocols.diameter.primitives.mm10;

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
 * 	6.3.14	Delivery-Report AVP
	The Delivery-Report AVP (AVP code 1111) is of type Enumerated. It indicates whether an delivery report is requested.
	
	No Delivery Report Requested (0)
	Delivery Report Requested (1)
	
	If the Delivery-Report AVP is not present, then the default "No Delivery Report Requested" shall be assumed.
 */
public enum DeliveryReportEnum implements IntegerEnum
{
	NO_DELIVERY_REPORT_REQUESTED(0),DELIVERY_REPORT_REQUESTED(1);

	private static final Map<Integer, DeliveryReportEnum> intToTypeMap = new HashMap<Integer, DeliveryReportEnum>();
	static
	{
	    for (DeliveryReportEnum type : DeliveryReportEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static DeliveryReportEnum fromInt(Integer value) 
	{
		DeliveryReportEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private DeliveryReportEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
