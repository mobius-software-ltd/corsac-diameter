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
 * 	7.3.166	Measurement-Period-LTE
	The Measurement-Period-LTE AVP is of type Enumerated. The possible values are those defined in 3GPP TS 32.422 [23] for Measurement period LTE.
	
	This parameter is mandatory if the job type is set to Immediate MDT or Immediate MDT and Trace and either the bit 4
	or bit 5 or bit 6 or bit7 of list of measurements parameter in LTE (M4 for DL or M4 for UL or M5 for DL or M5 for
	UL) is set to 1.

	This measurement parameter defines the measuremet period that should be used for the Data Volume and Scheduled IP
	Throughput measurements made by the eNB. The same measurement period should be used for the UL and DL. 
	
	The parameter is an enumerated type with the following values:
	
	- 1024 ms (0),

	- 1280 ms (1),

	- 2048 ms (2),

	- 2560 ms (3),

	- 5120 ms (4),

	- 10240 ms (5)

	- 1 min (6).

	Some values may not be always available e.g., due to the large amount of logging they would generate in a highly
	loaded network. The selection of a specific subset of supported values at the eNB is vendor-specific.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MEASUREMENT_PERIOD_LTE, vendorId = VendorIDs.TGPP_ID, must = false, name = "Measurement-Period-LTE")
public interface MeasurementPeriodLTE extends DiameterEnumerated<MeasurementPeriodLTEEnum>
{
}