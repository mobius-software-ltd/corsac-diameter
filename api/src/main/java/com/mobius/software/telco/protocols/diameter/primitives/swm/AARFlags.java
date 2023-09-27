package com.mobius.software.telco.protocols.diameter.primitives.swm;
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
	7.2.3.5	AAR-Flags
	The AAR-Flags AVP is of type Unsigned32 and it shall contain a bitmask. The meaning of the bits is defined in table 7.2.3.5/1:
	Table 7.2.3.5/1: AAR-Flags

	Bit Name
	Description

	0 WLAN-Location-Info-Request
	This bit, when set, indicates an ePDG request to retrieve the most up to date WLAN Location Information of the UE stored at the 3GPP AAA Server.

	NOTE:	Bits not defined in this table shall be cleared by the sender and discarded by the receiver.
 */
@DiameterAvpDefinition(code = 1539L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "AAR-Flags")
public interface AARFlags extends DiameterUnsigned32
{
}