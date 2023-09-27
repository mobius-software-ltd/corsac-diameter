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
 * 	7.3.141	Report-Interval
	The Report-Interval AVP is of type Enumerated. The possible values are those defined in 3GPP TS 32.422 [23] for Report Interval

	This parameter is mandatory if the Reporting trigger is configured for Periodic UE side measurements (such as M1
	measurement in LTE or NR and M1/M2 measurements in UMTS) and the jobtype is configured for Immediate MDT or
	combined Immediate MDT and Trace. The parameter indicates the interval between the periodical measurements to be
	taken when UE is in connected mode.
	The parameter is enumerated type with the following values in milliseconds in case of UMTS (detailed definition is in
	3GPP TS 25.331 [31]:

	- 250 ms (0), 

	- 500 ms (1),

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
	
	The parameter can have the following values in LTE (detailed definition is in 3GPP TS 36.331 [32]):

	- 120 ms (15),

	- 240 ms (16),

	- 480 ms (17),

	- 640 ms (18),

	- 1024 ms (19),

	- 2048 ms (20),

	- 5120 ms (21),

	- 10240ms (22),

	- 1 min=60000 ms (23),

	- 6 min=360000 ms (24),

	- 12 min=720000 ms (25),

	- 30 min=1800000 ms (26),

	- 60 min=3600000 ms (27) 
	
	The parameter can have the following values in NR (detailed definition is in 3GPP TS 38.331 [43]):

	- 120 ms (28),

	- 240 ms (29),

	- 480 ms (30),

	- 640 ms (31),

	- 1024 ms (32),

	- 2048 ms (33), 

	- 5120 ms (34),

	- 10240 ms (35),

	- 20480 ms (36),

	- 40960 ms (37)

	- 1 min=60000 ms (3838),

	- 6 min=360000 ms (3939),

	- 12 min=720000 ms (4040),

	- 30 min=1800000 ms (4141),

	- 60 min=3600000 ms (4242) 
 */
public enum ReportIntervalEnum implements IntegerEnum
{
	MS_250(0),MS_500(1),MS_1000(2),MS_2000(3),MS_3000(4),MS_4000(5),MS_6000(6),MS_8000(7),
	MS_12000(8),MS_16000(9),MS_20000(10),MS_24000(11),MS_28000(12),MS_32000(13),MS_64000(14),
	MS_120(15),MS_240(16),MS_480(17),MS_640(18),MS_1024(19),MS_2048(20),MS_5120(21),
	MS_10240(22),MIN_1(23),MIN_6(24),MIN_12(25),MIN_30(26),MIN_60(27),
	NR_MS_120(28),NR_MS_240(29),NR_MS_480(30),NR_MS_640(31),NR_MS_1024(32),NR_MS_2048(33),NR_MS_5120(34),
	NR_MS_10240(35),NR_MS_20480(36),NR_MS_40960(37),NS_MIN_1(38),NS_MIN_6(39),NS_MIN_12(40),NS_MIN_30(41),NS_MIN_60(42);

	private static final Map<Integer, ReportIntervalEnum> intToTypeMap = new HashMap<Integer, ReportIntervalEnum>();
	static
	{
	    for (ReportIntervalEnum type : ReportIntervalEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static ReportIntervalEnum fromInt(Integer value) 
	{
		ReportIntervalEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private ReportIntervalEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
