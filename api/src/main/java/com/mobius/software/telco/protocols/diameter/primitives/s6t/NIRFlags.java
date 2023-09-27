package com.mobius.software.telco.protocols.diameter.primitives.s6t;
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
	8.4.70	NIR-Flags
	The NIR-Flags AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits shall be as defined in table 8.4.70-1:
	Table 8.4.70-1: NIR-Flags

	Bit Name
	Description
	
	0 Incomplete Group-User-Identifier-List
	This bit is set when the SCEF indicates that the union of the Group User Identifier Lists sent in this and in previous messages is still incomplete and more segments of the list will follow within subsequent NIR commands. The bit is not set when NIR contains the last segment of the list.

	NOTE:	Bits not defined in this table shall be cleared by the sender and discarded by the receiver of the command.
 */
@DiameterAvpDefinition(code = 3174L, vendorId = KnownVendorIDs.TGPP_ID,must = false, name = "NIR-Flags")
public interface NIRFlags extends DiameterUnsigned32
{
}