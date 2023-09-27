package com.mobius.software.telco.protocols.diameter.primitives.s6a;
/*
 * Mobius Software LTD
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

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
@DiameterAvpDefinition(code = 1627L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Report-Interval")
public interface ReportInterval extends DiameterEnumerated<ReportIntervalEnum>
{
}