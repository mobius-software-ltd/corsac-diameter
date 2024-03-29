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
 * 	7.3.142	Report-Amount
	The Report-Amount AVP is of type Enumerated. The possible values are those defined in 3GPP TS 32.422 [23] for Report Amount.

	The parameter is mandatory if the reporting trigger is configured for periodical UE side measurement (such as M1
	measurement in LTE or NR and M1/M2 measurements in UMTS) and the jobtype is configured for Immediate MDT or
	combined Immediate MDT and Trace. The parameter defines the number of measurement reports that shall be taken for
	periodical reporting while UE is in connected. Detailed definition of the paremeter is in TS 38.331 [43], TS 36.331 and
	TS 25.331[31].
	The parameter is an enumerated type with the following values in UMTS, in LTE, and in NR:

	- 1 (0),

	- 2 (1),

	- 4 (2),

	- 8 (3),

	- 16 (4),

	- 32 (5),

	- 64 (6),

	- infinity (7) 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.REPORT_AMOUNT, vendorId = VendorIDs.TGPP_ID, must = false, name = "Report-Amount")
public interface ReportAmount extends DiameterEnumerated<ReportAmountEnum>
{
}