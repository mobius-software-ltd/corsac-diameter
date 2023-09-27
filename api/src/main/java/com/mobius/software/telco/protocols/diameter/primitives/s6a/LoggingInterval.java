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
 * 	7.3.145	Logging-Interval
	The Logging-Interval AVP is of type Enumerated. The possible values are those defined in 3GPP TS 32.422 [23] for Logging Interval

	The parameter is an enumerated type with the following values in UMTS, and LTE as per defined in TS 25.331 [31]
	and TS 36.331 [32] :

	- 1280 ms (0),

	- 2560 ms (1),

	- 5120 ms (2),

	- 10240 ms (3),

	- 20480 ms (4),

	- 30720 ms (5),

	- 40960 ms (6),

	- 61440 ms (7)

	The parameter is an enumerated type with the following values in NR as per defined in 3GPP TS 38.331 [43]:

	- 1280 ms (0),

	- 2560 ms (1),

	- 5120 ms (2),

	- 10240 ms (3),

	- 20480 ms (4),

	- 30720 ms (5),
	
	- 40960 ms (6),

	- 61440 ms (7)

	- 320 ms (8)

	- 640 ms (9)

	- Infinity (10)
 */
@DiameterAvpDefinition(code = 1631L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Logging-Interval")
public interface LoggingInterval extends DiameterEnumerated<LoggingIntervalEnum>
{
}