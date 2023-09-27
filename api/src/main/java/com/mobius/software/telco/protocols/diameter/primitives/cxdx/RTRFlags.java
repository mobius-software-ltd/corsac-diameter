package com.mobius.software.telco.protocols.diameter.primitives.cxdx;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	6.3.69	RTR-Flags
	The RTR-Flags AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits shall be as defined in table 6.3.69.1.
	Table 6.3.69.1: RTR-Flags
	Bit Name
	Description

	0 Reference Location Information change
	This bit, when set, indicates the request is sent due to change of Reference Location Information.

	NOTE: Bits not defined in this table shall be cleared by the sending HSS and discarded by the receiving I-CSCF.
 */
@DiameterAvpDefinition(code = 659L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "RTR-Flags")
public interface RTRFlags extends DiameterUnsigned32
{
}