package com.mobius.software.telco.protocols.diameter.primitives.sgd;
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
	6.3.3.12	OFR-Flags
	The OFR-Flags AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits shall be as defined in table 6.3.3.12/1:
	Table 6.3.3.12/1: OFR-Flags

	Bit Name
	Description

	0 S6a/S6d-Indicator
	This bit, when set, indicates that the OFR message is sent on the Gdd interface, i.e. the source node is an SGSN (or a combined MME/SGSN to which the UE is attached via UTRAN).
	This bit, when cleared, indicates that the OFR message is sent on the SGd interface, i.e. the source node is an MME (or a combined MME/SGSN to which the UE is attached via UTRAN or GERAN).
 */
@DiameterAvpDefinition(code = 3328L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "OFR-Flags")
public interface OFRFlags extends DiameterUnsigned32
{
}