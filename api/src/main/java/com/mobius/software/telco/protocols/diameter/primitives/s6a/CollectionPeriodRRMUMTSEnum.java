package com.mobius.software.telco.protocols.diameter.primitives.s6a;

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
 * 	7.3.169	Collection-Period-RRM-UMTS
	The Collection-Period-RRM-UMTS AVP is of type Enumerated. The possible values are those defined in 3GPP TS 32.422 [23] for Collection period for RRM measurements UMTS.

	5.10.21 Collection period for RRM measurements UMTS
	This parameter is mandatory if the job type is set to Immediate MDT or Immediate MDT and Trace and any of the bits
	3 (M3), 4 (M4), 5 (M5) of the list of measurements parameter (defined in Section 5.10.3) in UMTS is set to 1. The
	parameter is used only in case of RAN side measurements whose configuration is determined by RRM.
	This measurement parameter defines the collection period that should be used to collect available measurement samples
	in case of RRM configured measurements. The same collection period should be used for all such measurements that
	are requested in the same MDT or combined Trace and MDT job.
	The parameter is an enumerated type with the following values:

	- 250 ms (0)

	- 500 ms (1)

	- 1000 ms (2),

	- 2000 ms (3),

	- 3000 ms (4),

	- 4000 ms (5),

	- 6000 ms (6),

	- 8000 ms (7),

	- 12000 ms (8),

	- 16000 ms (9), 

	- 20000 ms (10),

	- 24000 ms (11),

	- 28000 ms (12),

	- 32000 ms (13),

	- 64000 ms (14)

	Some values may not be always available e.g., due to the large amount of logging they would generate in a highly
	loaded network. The selection of a specific subset of supported values at the RNC is vendor-specific.
 */
public enum CollectionPeriodRRMUMTSEnum implements IntegerEnum
{
	MS_250(0),MS_500(1),MS_1000(2),MS_2000(3),MS_3000(4),MS_4000(5),MS_6000(6),MS_8000(7),MS_12000(8),
	MS_16000(9),MS_20000(10),MS_24000(11),MS_28000(12),MS_32000(13),MS_64000(14);

	private static final Map<Integer, CollectionPeriodRRMUMTSEnum> intToTypeMap = new HashMap<Integer, CollectionPeriodRRMUMTSEnum>();
	static
	{
	    for (CollectionPeriodRRMUMTSEnum type : CollectionPeriodRRMUMTSEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static CollectionPeriodRRMUMTSEnum fromInt(Integer value) 
	{
		CollectionPeriodRRMUMTSEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private CollectionPeriodRRMUMTSEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
