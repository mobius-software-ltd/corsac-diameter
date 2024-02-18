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
 * 	7.3.227	Operation-Mode
	The Operation-Mode AVP is of type Unsigned32. This value shall indicate the operation mode for which the Paging-Time-Window-Length applies. See clause 3GPP TS 24.008 [31], clause 10.5.5.32.
	The allowed values of Operation-Mode shall be in the range of 0 to 255.
	Values are defined as follows:

	0:	Spare, for future use

	1:	Iu mode

	2:	WB-S1 mode

	3:	NB-S1 mode

	4 to 255:	Spare, for future use
 */
@DiameterAvpDefinition(code = TgppAvpCodes.OPERATION_MODE, vendorId = VendorIDs.TGPP_ID, must = false, name = "Operation-Mode")
public interface OperationMode extends DiameterEnumerated<OperationModeEnum>
{
}