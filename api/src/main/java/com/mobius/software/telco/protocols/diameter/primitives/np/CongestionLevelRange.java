package com.mobius.software.telco.protocols.diameter.primitives.np;
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
	5.3.5	Congestion-Level-Range AVP
	The Congestion-Level-Range AVP (AVP code 4003) is of type Unsigned32, and it is used to indicate the list of congestion level(s) bound to a certain congestion level set, between the PCRF and the RCAF. The Congestion-Level-Range AVP shall contain a bit mask. The bit 0 shall be the least significant bit. For example, to get the value of bit 0, a bit mask of 0x0001 should be used. The meaning of the bits shall be as defined below:
	Table 5.3.5.1: Congestion Level Range

	Bit Name
	Description

	0 No congestion
	This bit, when set, indicates that the RCAF shall report the corresponding congestion level set id to the PCRF when there is no congestion for a certain user id and PDN ID.

	1 Congestion level 1
	This bit, when set, indicates that the RCAF shall report the corresponding congestion level set id to the PCRF when congestion level 1 is reached for a certain user id and PDN ID.

	1+n Congestion level 1+n
	This bit, when set, indicates that the RCAF shall report the corresponding congestion level set id to the PCRF when congestion level 1+n is reached for a certain  user id and PDN ID.
 */
@DiameterAvpDefinition(code = 4003L, vendorId = KnownVendorIDs.TGPP_ID,must = false, name = "Congestion-Level-Range")
public interface CongestionLevelRange extends DiameterUnsigned32
{
}