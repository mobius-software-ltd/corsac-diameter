package com.mobius.software.telco.protocols.diameter.primitives.slg;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/

/*
	7.4.58	Cell-Portion-ID
	The Cell-Portion-ID AVP is of type Unsigned32. It indicates the current Cell Portion location of the target UE as provided by the E-SMLC. It shall contain the value of the "Cell Portion ID" Information Element as defined in 3GPP TS 29.171 [7].
 */
@DiameterAvpDefinition(code = TgppAvpCodes.CELL_PORTION_ID, vendorId = VendorIDs.TGPP_ID, must = false, name = "Cell-Portion-ID")
public interface CellPortionID extends DiameterUnsigned32
{
}