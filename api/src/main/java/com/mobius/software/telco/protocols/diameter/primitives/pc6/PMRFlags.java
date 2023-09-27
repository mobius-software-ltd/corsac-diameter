package com.mobius.software.telco.protocols.diameter.primitives.pc6;
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
	6.3.57	PMR-Flags
	The PMR-Flags AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits shall be as defined in table 6.3.57/1:

	Table 6.3.57/1: PMR-Flags
	Bit Name
	Description

	0 Metadata Requested
	This bit, when set, indicates that metadata information associated with the ProSe Application ID are requested.

	NOTE:	Bits not defined in this table shall be cleared by the sending Prose Function and discarded by the receiving receiving ProSe function.
 */
@DiameterAvpDefinition(code = 3852L, vendorId = KnownVendorIDs.TGPP_ID, name = "PMR-Flags")
public interface PMRFlags extends DiameterUnsigned32
{
}