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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.167	Measurement-Period-UMTS
	The Measurement-Period-UMTS AVP is of type Enumerated. The possible values are those defined in 3GPP TS 32.422 [23] for Measurement period UMTS.

	This parameter is mandatory if the job type is set to Immediate MDT or Immediate MDT and Trace and either the bit 6
	or bit 7 or bit 8 or bit 9 of list of measurements parameter in UMTS (M6 for DL or M6 for UL or M7 for DL or M7 for
	UL) is set to 1.

	This measurement parameter defines the measuremet period that should be used for the Data Volume and Throughput
	measurements made by the RNC. The same measurement period should be used for the UL and DL.
	The parameter is an enumerated type with the following values (the values 250ms (0) and 500ms (1) are not valid for
	this parameter):

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

	- 64000 ms (14).

	Some values may not be always available e.g., due to the large amount of logging they would generate in a highly
	loaded network. The selection of a specific subset of supported values at the RNC is vendor-specific.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MEASUREMENT_PERIOD_UTMS, vendorId = VendorIDs.TGPP_ID, must = false, name = "Measurement-Period-UMTS")
public interface MeasurementPeriodUMTS extends DiameterEnumerated<MeasurementPeriodUMTSEnum>
{
}